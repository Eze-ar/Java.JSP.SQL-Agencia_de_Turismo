package agencia_logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Paquete_Turistico implements Serializable { //pongo _ para que en la BD separe las palabras ya que es ci (case insensitive!)
    @Id
    @GeneratedValue
    private int codigo_paquete;
    @ManyToMany //defino el n a n
    private List<Servicio_Turistico> listaServicios; //genero el 1 a n (1 paquete contiene n servicios) desde el lado del Paquete
    @Basic
    private String estado;
    private double costo_paquete;
    private String nombre;
    
    public Paquete_Turistico() {
    }

    public Paquete_Turistico(int codigo_paquete, List<Servicio_Turistico> listaServicios, String estado, double costo_paquete, String nombre) {
        this.codigo_paquete = codigo_paquete;
        this.listaServicios = listaServicios;
        this.estado = estado;
        this.costo_paquete = costo_paquete;
        this.nombre = nombre;
    }

    public int getCodigo_paquete() {
        return codigo_paquete;
    }

    public List<Servicio_Turistico> getListaServicios() {
        return listaServicios;
    }

    public double getCosto_paquete() {
        return costo_paquete;
    }

    public void setCodigo_paquete(int codigo_paquete) {
        this.codigo_paquete = codigo_paquete;
    }

    public void setListaServicios(List<Servicio_Turistico> listaServicios) {
        this.listaServicios = listaServicios;
    }

    public void setCosto_paquete(double costo_paquete) {
        this.costo_paquete = costo_paquete;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
   
}
