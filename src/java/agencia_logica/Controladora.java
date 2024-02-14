package agencia_logica;

import agencia_persistencia.ControladoraPersistencia;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controladora {

    ControladoraPersistencia controladoraPersistencia = new ControladoraPersistencia();

    //método para autorizar o no el ingreso en el log in:
    public boolean autorizaIngreso(String usuario, String password) {

        List<Usuario> listaUsuarios = controladoraPersistencia.leerUsuarios();

        if (listaUsuarios.size() == 0) { //no hay usuarios previamente cargados
            //entonces ingreso con clave incluída por defecto
            if (usuario.equals("admin") && password.equals("2435")) {
                return true;
            }
        } //si viene acá es porque sí hay una base de usuarios cargada:
        else {
            for (Usuario u : listaUsuarios) {
                if (u.getNombre() != null && u.getPassword() != null) { //para evitar generar una excepción al comparar con null luego
                    if (u.getNombre().equals(usuario) && u.getPassword().equals(password)) {
                        return true; //encontró ese user y ese pass en la BD de usuarios
                    }
                }
            }

        }

        return false;
    }

    public void altaEmpleado(String nombre, String apellido, String direccion, String dni, String fecha_nac_str, String nacionalidad, String celular, String email, String cargo, String sueldo_str, String user, String password) {
        Empleado empleado = new Empleado();

        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setDireccion(direccion);
        empleado.setDni(dni);

        //recibe la fecha como String y la pasa a Date:
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        //tuve que usar el formato que usa MySQL se ve por defecto....no lo supe cambiar a dd/MM/yyyy
        //lo veré más adelante ya que no me funcionó de otra manera
        Date fecha_nac = null;
        try {
            fecha_nac = formato.parse(fecha_nac_str);
        } catch (ParseException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        empleado.setFecha_nac(fecha_nac);

        empleado.setNacionalidad(nacionalidad);
        empleado.setCelular(celular);
        empleado.setEmail(email);
        empleado.setCargo(cargo);

        Double sueldo;
        if (!sueldo_str.equals("")) {
            sueldo = Double.parseDouble(sueldo_str);
        } else {
            sueldo = null;
        }
        empleado.setSueldo(sueldo);

        Usuario usuario = new Usuario();
        usuario.setNombre(user);
        usuario.setPassword(password);
        empleado.setUsuario(usuario);

        empleado.setEstado("ACTIVO"); //al crear pongo estado activo, esto lo uso en mi borrado lógico
        //ahora mando el empleado completo a la controladora de la persistencia para que lo de de alta en la BD:
        controladoraPersistencia.altaEmpleado(empleado, usuario);
        //debo pasar usuario como parámetro ya que en la BD debe estar usuario para asignarlo a empleado en primer lugar!

    }

    public void altaCliente(String nombre, String apellido, String direccion, String dni, Date fecha_nac, String nacionalidad, String celular, String email) {
    
        Cliente cliente = new Cliente();

        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDireccion(direccion);
        cliente.setDni(dni);
        cliente.setFecha_nac(fecha_nac);
        cliente.setNacionalidad(nacionalidad);
        cliente.setCelular(celular);
        cliente.setEmail(email);
        
        cliente.setEstado("ACTIVO"); //al crear pongo estado activo, esto lo uso en mi borrado lógico

        //ahora mando el cliente completo a la controladora de la persistencia para que lo de de alta en la BD:
        controladoraPersistencia.altaCliente(cliente);

    }
    
    
    //método para obtener el listado de clientes / LEE CLIENTES
    public List<Cliente> leeClientes() {
        
        return controladoraPersistencia.leeClientes();
    }

    public List<Empleado> leeEmpleados() {
        return controladoraPersistencia.leeEmpleados();
    }

    public void bajaEmpleado(int id_Empleado) {
        //controladoraPersistencia.bajaEmpleado(id_Empleado);
        //como la baja de 1 empleado incluye el pasar el estado a inactivo y borrar su usuario
        //primero recupero su info completa:
        Empleado empleado = controladoraPersistencia.leeEmpleado(id_Empleado);
        empleado.setEstado("INACTIVO"); //modifico el estado (borrado lógico)
        
        /*// si hago esto en realidad creo un nuevo usuario en empleado y yo quiero borrar el que tiene:
        Usuario u = new Usuario();
        u.setNombre("");   //borro o pongo string vació en nombre y password
        u.setPassword(""); //total no dejo entrar sin user/password
        empleado.setUsuario(u);
        */
        
        int id_usuario = empleado.getUsuario().getId_usuario();
        
        controladoraPersistencia.bajaUsuario(id_usuario);

        controladoraPersistencia.bajaEmpleado(empleado); //ya no paso el Id sino el objeto completo

    }
/* borrar
    public void editaEmpleado(int id_Empleado) {

    }*/

    public Empleado leeEmpleado(int id_Empleado) {
        return controladoraPersistencia.leeEmpleado(id_Empleado);
    }

    public void editaEmpleado(String nombre, String apellido, String direccion, String dni, String fecha_nac_str, String nacionalidad, String celular, String email, String cargo, String sueldo_str, String user, String password) {
        Empleado empleado = new Empleado();

        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setDireccion(direccion);
        empleado.setDni(dni);

        //recibe la fecha como String y la pasa a Date:
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        //tuve que usar el formato que usa MySQL se ve por defecto....no lo supe cambiar a dd/MM/yyyy
        //lo veré más adelante ya que no me funcionó de otra manera
        Date fecha_nac = null;
        try {
            fecha_nac = formato.parse(fecha_nac_str);
        } catch (ParseException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        empleado.setFecha_nac(fecha_nac);

        empleado.setNacionalidad(nacionalidad);
        empleado.setCelular(celular);
        empleado.setEmail(email);
        empleado.setCargo(cargo);

        Double sueldo;
        if (!sueldo_str.equals("")) {
            sueldo = Double.parseDouble(sueldo_str);
        } else {
            sueldo = null;
        }
        empleado.setSueldo(sueldo);

        Usuario usuario = new Usuario();
        usuario.setNombre(user);
        usuario.setPassword(password);
        empleado.setUsuario(usuario);

        //ahora mando el empleado completo a la controladora de la persistencia para que lo modifique en la BD:
        controladoraPersistencia.editaEmpleado(empleado);

    }

    
    //borrar luego que ande el anterior:
    public void editaEmpleado(Empleado empleado) {
        //ahora mando el empleado completo a la controladora de la persistencia para que lo modifique en la BD:
        controladoraPersistencia.editaEmpleado(empleado);
    }

    public void bajaCliente(int id_Cliente) {
        //la baja de 1 cliente es pasar el estado a inactivo
        Cliente cliente = controladoraPersistencia.leeCliente(id_Cliente);
        cliente.setEstado("INACTIVO"); //modifico el estado (borrado lógico)
 
        controladoraPersistencia.bajaCliente(cliente); //paso el objeto completo no sólo el ID
        
    }

    public Cliente leeCliente(int id_Cliente) {
        return controladoraPersistencia.leeCliente(id_Cliente);
    }

    public void editaCliente(Cliente cliente) {
        
        //ahora mando el cliente completo a la controladora de la persistencia para que lo modifique en la BD:
        controladoraPersistencia.editaCliente(cliente);
        
    }

    public void altaServicio(String nombre, String tipo_servicio, String descripcion, String destino, Date fecha_servicio, Double costo) {
        Servicio_Turistico servicio = new Servicio_Turistico();
        
        servicio.setNombre(nombre);
        servicio.setTipo_servicio(tipo_servicio);
        servicio.setDescripcion_breve(descripcion); 
        servicio.setDestino_servicio(destino);
        servicio.setFecha_servicio(fecha_servicio);
        servicio.setCosto_servicio(costo);
        
        servicio.setEstado("ACTIVO"); //al crear pongo estado activo, esto lo uso en mi borrado lógico

        //ahora mando el servicio completo a la controladora de la persistencia para que lo de de alta en la BD:
        controladoraPersistencia.altaServicio(servicio);
    }

    public List<Servicio_Turistico> leeServicios() {
        
        return controladoraPersistencia.leeServicios();
        
    }

    public Servicio_Turistico leeServicio(int codigo) {
        
        return controladoraPersistencia.leeServicio(codigo);
        
    }

    public void altaPaquete(String nombre, List<Servicio_Turistico> listaServicios, Double costo_total) {
        
        Paquete_Turistico paquete = new Paquete_Turistico();
        
        paquete.setNombre(nombre);
        paquete.setListaServicios(listaServicios);
        paquete.setCosto_paquete(costo_total);
        paquete.setEstado("ACTIVO"); //seteo el estado activo para permitir el borrado lógico
        
        controladoraPersistencia.altaPaquete(paquete);
         
    }
    
    public List<Paquete_Turistico> leePaquetes() {

        return controladoraPersistencia.leePaquetes();
    }

    public void bajaServicio(int codigo) {
        
        Servicio_Turistico servicio = controladoraPersistencia.leeServicio(codigo);
        servicio.setEstado("INACTIVO"); //modifico el estado (borrado lógico)
 
        controladoraPersistencia.bajaServicio(servicio); //paso el objeto completo no sólo el ID
        
    }

    public void bajaPaquete(int codigo) {
        
        Paquete_Turistico paquete = controladoraPersistencia.leePaquete(codigo);
        paquete.setEstado("INACTIVO"); //borrado lógico
        
        controladoraPersistencia.bajaPaquete(paquete);
    }

}
