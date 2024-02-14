package agencia_persistencia;

import agencia_logica.Cliente;
import agencia_logica.Empleado;
import agencia_logica.Paquete_Turistico;
import agencia_logica.Servicio_Turistico;
import agencia_logica.Usuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {

    UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    EmpleadoJpaController empleadoJpa = new EmpleadoJpaController();

    ClienteJpaController clienteJpa = new ClienteJpaController();
    
    Servicio_TuristicoJpaController servicioJpa = new Servicio_TuristicoJpaController();
    
    Paquete_TuristicoJpaController paqueteJpa = new Paquete_TuristicoJpaController();

    public List<Usuario> leerUsuarios() {
        return usuarioJpa.findUsuarioEntities();
    }

    public void altaEmpleado(Empleado empleado, Usuario usuario) {

        usuarioJpa.create(usuario);
        empleadoJpa.create(empleado);

    }

    public void altaCliente(Cliente cliente) {

        clienteJpa.create(cliente);

    }

    public List<Empleado> leeEmpleados() {
        return empleadoJpa.findEmpleadoEntities();
    }

    public Empleado leeEmpleado(int id_Empleado) {
        //lee el empleado con el ID pasado como parámetro
        return empleadoJpa.findEmpleado(id_Empleado);
    }

    public void bajaEmpleado(Empleado empleado) {
        try {
            empleadoJpa.edit(empleado); //modifica al empleado pasando su estado a inactivo (borrado lógico)

        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void editaEmpleado(Empleado empleado) {
        try {
            empleadoJpa.edit(empleado); //edita el empleado
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Cliente> leeClientes() {
        return clienteJpa.findClienteEntities();
    }


    public Cliente leeCliente(int id_Cliente) {
        //lee el cliente con el ID pasado como parámetro
        return clienteJpa.findCliente(id_Cliente);
        
    }

    public void bajaCliente(Cliente cliente) {
        try {
            clienteJpa.edit(cliente); //modifica pasando su estado a inactivo (borrado lógico)
        } 
        catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editaCliente(Cliente cliente) {
        
        try {
            clienteJpa.edit(cliente); //edita el cliente
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void bajaUsuario(int id_usuario) {
        Usuario usuario = usuarioJpa.findUsuario(id_usuario);
        usuario.setNombre("-"); // pongo user vacío y lo mismo en pass ya que no
        usuario.setPassword("-");//dejo ingresar con campos vacíos. Podría haber usado null.
        try {
            usuarioJpa.edit(usuario); //edito en la BD por medio del JPA
        } 
        catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void altaServicio(Servicio_Turistico servicio) {
        
        servicioJpa.create(servicio);
        
    }

    public List<Servicio_Turistico> leeServicios() {
        
        return servicioJpa.findServicio_TuristicoEntities();
        
    }

    public Servicio_Turistico leeServicio(int codigo) {
        
        return servicioJpa.findServicio_Turistico(codigo);
        
    }

    public void altaPaquete(Paquete_Turistico paquete) {
        
        paqueteJpa.create(paquete);
        
    }

    public List<Paquete_Turistico> leePaquetes() {
        return paqueteJpa.findPaquete_TuristicoEntities();
    }

    public void bajaServicio(Servicio_Turistico servicio) {
        //borrado lógico del servicio
        try {
            servicioJpa.edit(servicio);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Paquete_Turistico leePaquete(int codigo) {
        return paqueteJpa.findPaquete_Turistico(codigo);
    }

    public void bajaPaquete(Paquete_Turistico paquete) {
        try {
            paqueteJpa.edit(paquete);
        } 
        catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
