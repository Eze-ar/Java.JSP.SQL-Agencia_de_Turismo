package agencia_logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Empleado implements Serializable {//NetBeans recomendó que una clase
    @Id                      //entidad debe implementar la interfaz Serializable
    @GeneratedValue //por defecto toma: GeneratedValue(strategy = GenerationType.AUTO)
    private int id_empleado;
    @Basic
    private String estado; //agrego el estado para el borrado lógico...sí, pude usar un boolean
    private String nombre;
    private String apellido;
    private String direccion;
    private String dni;
    private String nacionalidad;
    private String celular;
    private String email;
    private String cargo;
    private Double sueldo;
    @Temporal(TemporalType.DATE)
    private Date fecha_nac;
    @OneToOne        //la forma de mapear con JPA el 1 a 1
    private Usuario usuario; //cada empleado tiene 1 sólo user/pass, relación 1 a 1
    @OneToMany //1 empleado realiza N ventas. En clases la Foreign Key, la lista de objetos va del lado del 1
    private List<Venta> listaVentas;

    public Empleado() {
    }

    public Empleado(int id_empleado, String estado, String nombre, String apellido, String direccion, String dni, String nacionalidad, String celular, String email, String cargo, Double sueldo, Date fecha_nac, Usuario usuario, List<Venta> listaVentas) {
        this.id_empleado = id_empleado;
        this.estado = estado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = dni;
        this.nacionalidad = nacionalidad;
        this.celular = celular;
        this.email = email;
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.fecha_nac = fecha_nac;
        this.usuario = usuario;
        this.listaVentas = listaVentas;
    }
    
    public String getCargo() {
        return cargo;
    }

    public Double getSueldo() {
        return sueldo;
    }


    public int getId_empleado() {
        return id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getDni() {
        return dni;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getCelular() {
        return celular;
    }

    public String getEmail() {
        return email;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
     
}
