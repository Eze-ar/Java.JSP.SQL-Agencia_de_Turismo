package agencia_persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import agencia_logica.Paquete_Turistico;
import agencia_logica.Servicio_Turistico;
import agencia_persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Servicio_TuristicoJpaController implements Serializable {

    public Servicio_TuristicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    private EntityManagerFactory emf = null;
    
    //defino mi constructor para mi unidad de persistencia y conexión con mi controladora de JPA:
    public Servicio_TuristicoJpaController() {
        emf = Persistence.createEntityManagerFactory("Angio_Adrian_Ezequiel_tpFinal-PU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Servicio_Turistico servicio_Turistico) {
        if (servicio_Turistico.getListaPaquete() == null) {
            servicio_Turistico.setListaPaquete(new ArrayList<Paquete_Turistico>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Paquete_Turistico> attachedListaPaquete = new ArrayList<Paquete_Turistico>();
            for (Paquete_Turistico listaPaquetePaquete_TuristicoToAttach : servicio_Turistico.getListaPaquete()) {
                listaPaquetePaquete_TuristicoToAttach = em.getReference(listaPaquetePaquete_TuristicoToAttach.getClass(), listaPaquetePaquete_TuristicoToAttach.getCodigo_paquete());
                attachedListaPaquete.add(listaPaquetePaquete_TuristicoToAttach);
            }
            servicio_Turistico.setListaPaquete(attachedListaPaquete);
            em.persist(servicio_Turistico);
            for (Paquete_Turistico listaPaquetePaquete_Turistico : servicio_Turistico.getListaPaquete()) {
                listaPaquetePaquete_Turistico.getListaServicios().add(servicio_Turistico);
                listaPaquetePaquete_Turistico = em.merge(listaPaquetePaquete_Turistico);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Servicio_Turistico servicio_Turistico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Servicio_Turistico persistentServicio_Turistico = em.find(Servicio_Turistico.class, servicio_Turistico.getCodigo_servicio());
            List<Paquete_Turistico> listaPaqueteOld = persistentServicio_Turistico.getListaPaquete();
            List<Paquete_Turistico> listaPaqueteNew = servicio_Turistico.getListaPaquete();
            List<Paquete_Turistico> attachedListaPaqueteNew = new ArrayList<Paquete_Turistico>();
            for (Paquete_Turistico listaPaqueteNewPaquete_TuristicoToAttach : listaPaqueteNew) {
                listaPaqueteNewPaquete_TuristicoToAttach = em.getReference(listaPaqueteNewPaquete_TuristicoToAttach.getClass(), listaPaqueteNewPaquete_TuristicoToAttach.getCodigo_paquete());
                attachedListaPaqueteNew.add(listaPaqueteNewPaquete_TuristicoToAttach);
            }
            listaPaqueteNew = attachedListaPaqueteNew;
            servicio_Turistico.setListaPaquete(listaPaqueteNew);
            servicio_Turistico = em.merge(servicio_Turistico);
            for (Paquete_Turistico listaPaqueteOldPaquete_Turistico : listaPaqueteOld) {
                if (!listaPaqueteNew.contains(listaPaqueteOldPaquete_Turistico)) {
                    listaPaqueteOldPaquete_Turistico.getListaServicios().remove(servicio_Turistico);
                    listaPaqueteOldPaquete_Turistico = em.merge(listaPaqueteOldPaquete_Turistico);
                }
            }
            for (Paquete_Turistico listaPaqueteNewPaquete_Turistico : listaPaqueteNew) {
                if (!listaPaqueteOld.contains(listaPaqueteNewPaquete_Turistico)) {
                    listaPaqueteNewPaquete_Turistico.getListaServicios().add(servicio_Turistico);
                    listaPaqueteNewPaquete_Turistico = em.merge(listaPaqueteNewPaquete_Turistico);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = servicio_Turistico.getCodigo_servicio();
                if (findServicio_Turistico(id) == null) {
                    throw new NonexistentEntityException("The servicio_Turistico with id " + id + " no longer exists.");
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
            Servicio_Turistico servicio_Turistico;
            try {
                servicio_Turistico = em.getReference(Servicio_Turistico.class, id);
                servicio_Turistico.getCodigo_servicio();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The servicio_Turistico with id " + id + " no longer exists.", enfe);
            }
            List<Paquete_Turistico> listaPaquete = servicio_Turistico.getListaPaquete();
            for (Paquete_Turistico listaPaquetePaquete_Turistico : listaPaquete) {
                listaPaquetePaquete_Turistico.getListaServicios().remove(servicio_Turistico);
                listaPaquetePaquete_Turistico = em.merge(listaPaquetePaquete_Turistico);
            }
            em.remove(servicio_Turistico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Servicio_Turistico> findServicio_TuristicoEntities() {
        return findServicio_TuristicoEntities(true, -1, -1);
    }

    public List<Servicio_Turistico> findServicio_TuristicoEntities(int maxResults, int firstResult) {
        return findServicio_TuristicoEntities(false, maxResults, firstResult);
    }

    private List<Servicio_Turistico> findServicio_TuristicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Servicio_Turistico.class));
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

    public Servicio_Turistico findServicio_Turistico(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Servicio_Turistico.class, id);
        } finally {
            em.close();
        }
    }

    public int getServicio_TuristicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Servicio_Turistico> rt = cq.from(Servicio_Turistico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
