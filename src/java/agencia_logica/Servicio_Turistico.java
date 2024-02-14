package agencia_logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;  //recordar antes importar en Libraries: "javax.persistence_2.1.0.v201304241213.jar"
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Servicio_Turistico implements Serializable { //nombre con '_' para claridad en la BD que es 'ci' (case insensitive)
    @Id
    @GeneratedValue //por defecto toma: GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo_servicio;
    @Basic
    private String estado; //como antes, para el borrado lógico
    private String nombre;
    private String tipo_servicio;
    private String descripcion_breve;
    private String destino_servicio;
    private double costo_servicio;
    @Temporal(TemporalType.DATE)
    private Date fecha_servicio;
    @ManyToMany //defino el n a n
    private List<Paquete_Turistico> listaPaquete; //genero el 1 a n (1 servicio puede estar en n paquetes) desde este lado

    public Servicio_Turistico() {
    }

    public Servicio_Turistico(int codigo_servicio, String estado, String nombre, String tipo_servicio, String descripcion_breve, String destino_servicio, double costo_servicio, Date fecha_servicio, List<Paquete_Turistico> listaPaquete) {
        this.codigo_servicio = codigo_servicio;
        this.estado = estado;
        this.nombre = nombre;
        this.tipo_servicio = tipo_servicio;
        this.descripcion_breve = descripcion_breve;
        this.destino_servicio = destino_servicio;
        this.costo_servicio = costo_servicio;
        this.fecha_servicio = fecha_servicio;
        this.listaPaquete = listaPaquete;
    }

    public int getCodigo_servicio() {
        return codigo_servicio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion_breve() {
        return descripcion_breve;
    }

    public String getDestino_servicio() {
        return destino_servicio;
    }

    public Date getFecha_servicio() {
        return fecha_servicio;
    }

    public double getCosto_servicio() {
        return costo_servicio;
    }

    public void setCodigo_servicio(int codigo_servicio) {
        this.codigo_servicio = codigo_servicio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion_breve(String descripcion_breve) {
        this.descripcion_breve = descripcion_breve;
    }

    public void setDestino_servicio(String destino_servicio) {
        this.destino_servicio = destino_servicio;
    }

    public void setFecha_servicio(Date fecha_servicio) {
        this.fecha_servicio = fecha_servicio;
    }

    public void setCosto_servicio(double costo_servicio) {
        this.costo_servicio = costo_servicio;
    }

    public List<Paquete_Turistico> getListaPaquete() {
        return listaPaquete;
    }

    public void setListaPaquete(List<Paquete_Turistico> listaPaquete) {
        this.listaPaquete = listaPaquete;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo_servicio() {
        return tipo_servicio;
    }

    public void setTipo_servicio(String tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }
    
}
