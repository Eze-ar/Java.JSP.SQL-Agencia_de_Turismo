package agencia_persistencia;

import agencia_logica.Paquete_Turistico;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import agencia_logica.Servicio_Turistico;
import agencia_persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Paquete_TuristicoJpaController implements Serializable {

    public Paquete_TuristicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    private EntityManagerFactory emf = null;
    
    //defino mi constructor para mi unidad de persistencia y conexión con mi controladora de JPA:
    public Paquete_TuristicoJpaController() {
        emf = Persistence.createEntityManagerFactory("Angio_Adrian_Ezequiel_tpFinal-PU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Paquete_Turistico paquete_Turistico) {
        if (paquete_Turistico.getListaServicios() == null) {
            paquete_Turistico.setListaServicios(new ArrayList<Servicio_Turistico>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Servicio_Turistico> attachedListaServicios = new ArrayList<Servicio_Turistico>();
            for (Servicio_Turistico listaServiciosServicio_TuristicoToAttach : paquete_Turistico.getListaServicios()) {
                listaServiciosServicio_TuristicoToAttach = em.getReference(listaServiciosServicio_TuristicoToAttach.getClass(), listaServiciosServicio_TuristicoToAttach.getCodigo_servicio());
                attachedListaServicios.add(listaServiciosServicio_TuristicoToAttach);
            }
            paquete_Turistico.setListaServicios(attachedListaServicios);
            em.persist(paquete_Turistico);
            for (Servicio_Turistico listaServiciosServicio_Turistico : paquete_Turistico.getListaServicios()) {
                listaServiciosServicio_Turistico.getListaPaquete().add(paquete_Turistico);
                listaServiciosServicio_Turistico = em.merge(listaServiciosServicio_Turistico);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Paquete_Turistico paquete_Turistico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paquete_Turistico persistentPaquete_Turistico = em.find(Paquete_Turistico.class, paquete_Turistico.getCodigo_paquete());
            List<Servicio_Turistico> listaServiciosOld = persistentPaquete_Turistico.getListaServicios();
            List<Servicio_Turistico> listaServiciosNew = paquete_Turistico.getListaServicios();
            List<Servicio_Turistico> attachedListaServiciosNew = new ArrayList<Servicio_Turistico>();
            for (Servicio_Turistico listaServiciosNewServicio_TuristicoToAttach : listaServiciosNew) {
                listaServiciosNewServicio_TuristicoToAttach = em.getReference(listaServiciosNewServicio_TuristicoToAttach.getClass(), listaServiciosNewServicio_TuristicoToAttach.getCodigo_servicio());
                attachedListaServiciosNew.add(listaServiciosNewServicio_TuristicoToAttach);
            }
            listaServiciosNew = attachedListaServiciosNew;
            paquete_Turistico.setListaServicios(listaServiciosNew);
            paquete_Turistico = em.merge(paquete_Turistico);
            for (Servicio_Turistico listaServiciosOldServicio_Turistico : listaServiciosOld) {
                if (!listaServiciosNew.contains(listaServiciosOldServicio_Turistico)) {
                    listaServiciosOldServicio_Turistico.getListaPaquete().remove(paquete_Turistico);
                    listaServiciosOldServicio_Turistico = em.merge(listaServiciosOldServicio_Turistico);
                }
            }
            for (Servicio_Turistico listaServiciosNewServicio_Turistico : listaServiciosNew) {
                if (!listaServiciosOld.contains(listaServiciosNewServicio_Turistico)) {
                    listaServiciosNewServicio_Turistico.getListaPaquete().add(paquete_Turistico);
                    listaServiciosNewServicio_Turistico = em.merge(listaServiciosNewServicio_Turistico);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = paquete_Turistico.getCodigo_paquete();
                if (findPaquete_Turistico(id) == null) {
                    throw new NonexistentEntityException("The paquete_Turistico with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paquete_Turistico paquete_Turistico;
            try {
                paquete_Turistico = em.getReference(Paquete_Turistico.class, id);
                paquete_Turistico.getCodigo_paquete();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paquete_Turistico with id " + id + " no longer exists.", enfe);
            }
            List<Servicio_Turistico> listaServicios = paquete_Turistico.getListaServicios();
            for (Servicio_Turistico listaServiciosServicio_Turistico : listaServicios) {
                listaServiciosServicio_Turistico.getListaPaquete().remove(paquete_Turistico);
                listaServiciosServicio_Turistico = em.merge(listaServiciosServicio_Turistico);
            }
            em.remove(paquete_Turistico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Paquete_Turistico> findPaquete_TuristicoEntities() {
        return findPaquete_TuristicoEntities(true, -1, -1);
    }

    public List<Paquete_Turistico> findPaquete_TuristicoEntities(int maxResults, int firstResult) {
        return findPaquete_TuristicoEntities(false, maxResults, firstResult);
    }

    private List<Paquete_Turistico> findPaquete_TuristicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Paquete_Turistico.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Paquete_Turistico findPaquete_Turistico(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paquete_Turistico.class, id);
        } finally {
            em.close();
        }
    }

    public int getPaquete_TuristicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Paquete_Turistico> rt = cq.from(Paquete_Turistico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
