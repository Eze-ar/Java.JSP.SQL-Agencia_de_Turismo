package agencia_logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Venta implements Serializable {
    @Id
    @GeneratedValue
    private long num_venta;
    @Temporal(TemporalType.DATE)
    private Date fecha_venta;
    @Basic
    private String medio_pago;
    @ManyToOne //N ventas pueden ser de 1 paquete
    private Paquete_Turistico paquete;
    @ManyToMany //N servicios en N ventas
    private List<Servicio_Turistico> listaServicios;
    @ManyToOne //N ventas para 1 cliente
    private Cliente cliente;
    @ManyToOne //N ventas para 1 empleado
    private Empleado empleado;

    public Venta() {
    }

    public Venta(long num_venta, Date fecha_venta, String medio_pago, Paquete_Turistico paquete, List<Servicio_Turistico> listaServicios, Cliente cliente, Empleado empleado) {
        this.num_venta = num_venta;
        this.fecha_venta = fecha_venta;
        this.medio_pago = medio_pago;
        this.paquete = paquete;
        this.listaServicios = listaServicios;
        this.cliente = cliente;
        this.empleado = empleado;
    }

    

    public long getNum_venta() {
        return num_venta;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public String getMedio_pago() {
        return medio_pago;
    }

    public Paquete_Turistico getPaquete() {
        return paquete;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setNum_venta(long num_venta) {
        this.num_venta = num_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public void setMedio_pago(String medio_pago) {
        this.medio_pago = medio_pago;
    }

    public void setPaquete(Paquete_Turistico paquete) {
        this.paquete = paquete;
    }

    public void setListaServicios(List<Servicio_Turistico> listaServicios) {
        this.listaServicios = listaServicios;
    }



    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Servicio_Turistico> getListaServicios() {
        return listaServicios;
    }
    
}
