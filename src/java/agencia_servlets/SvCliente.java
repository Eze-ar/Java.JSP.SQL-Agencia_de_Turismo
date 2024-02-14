package agencia_servlets;

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

@WebServlet(name = "SvCliente", urlPatterns = {"/SvCliente"})
public class SvCliente extends HttpServlet {

    Controladora controladora = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
    }

    
    //doPOST para el ALTA del CLIENTE
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String dni = request.getParameter("dni");
        
        String fecha_nac_str = request.getParameter("fecha_nac");
        
        //recibe la fecha como String y la pasa a Date:
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        //en este formato se guardará después en la BD, no encontré la manera de que acepte el dd/MM/yyyy para la guarda
        
        Date fecha_nac = null;
        try {
            fecha_nac = formato.parse(fecha_nac_str); //paso de dd/MM/yyyydel front al yyyy-MM-dd para la BD
        } 
        catch (ParseException ex) {
            Logger.getLogger(SvCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        String nacionalidad = request.getParameter("nacionalidad");
        String celular = request.getParameter("celular");
        String email = request.getParameter("email");
      
        controladora.altaCliente(nombre, apellido, direccion, dni, fecha_nac, nacionalidad, celular, email);
        
        //actualizo lista de clientes:
        request.getSession().setAttribute("listaClientes", controladora.leeClientes());
        
        //creo un CLIENTE y redirecciono a la lista de clientes
        //acá podría poner una página de "operación exitosa" también pero por ahora me alcanza así
        
        response.sendRedirect("lista-clientes.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
