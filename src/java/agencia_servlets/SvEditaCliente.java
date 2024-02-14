package agencia_servlets;

import agencia_logica.Cliente;
import agencia_logica.Controladora;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvEditaCliente", urlPatterns = {"/SvEditaCliente"})
public class SvEditaCliente extends HttpServlet {
    
    Controladora controladora = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id_Cliente = Integer.parseInt(request.getParameter("id_Cliente"));
        //así llamé al ID (id_Cliente) en el jsp edita-cliente
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String dni = request.getParameter("dni");
        String fecha_nac_str = request.getParameter("fecha_nac");
       
        //recibe la fecha como String y la pasa a Date:
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        //tuve que usar el formato que usa MySQL se ve por defecto....no lo supe cambiar a dd/MM/yyyy
        //lo veré más adelante ya que no me funcionó de otra manera
        Date fecha_nac = null;
        try {
            fecha_nac = formato.parse(fecha_nac_str);
        } catch (ParseException ex) {
            Logger.getLogger(SvEditaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String nacionalidad = request.getParameter("nacionalidad");
        String celular = request.getParameter("celular");
        String email = request.getParameter("email");

        Cliente cliente = controladora.leeCliente(id_Cliente);
        
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDireccion(direccion);
        cliente.setDni(dni);
        cliente.setFecha_nac(fecha_nac);
        cliente.setNacionalidad(nacionalidad);
        cliente.setCelular(celular);
        cliente.setEmail(email);

        controladora.editaCliente(cliente);
        
        //actualizo lista de empleados:
        //request.getSession().setAttribute("listaCliente", controladora.leeClientes());
       
        //termino de editar y muestro la lista actualizada:
        response.sendRedirect("lista-clientes.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
