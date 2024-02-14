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


@WebServlet(name = "SvServicio", urlPatterns = {"/SvServicio"})
public class SvServicio extends HttpServlet {
    
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
        
        String nombre = request.getParameter("nombre");
        String tipo_servicio = request.getParameter("tipo_servicio"); 
        String descripcion = request.getParameter("descripcion");
        String destino =  request.getParameter("destino");
        
        String fecha_servicio_str = request.getParameter("fecha_servicio");
        
        //recibe la fecha como String y la pasa a Date:
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        //en este formato se guardará después en la BD, no encontré la manera de que acepte el dd/MM/yyyy para la guarda
        
        Date fecha_servicio = null;
        
        try {
            fecha_servicio = formato.parse(fecha_servicio_str); //paso de dd/MM/yyyydel front al yyyy-MM-dd para la BD
        } 
        
        catch (ParseException ex) {
            Logger.getLogger(SvServicio.class.getName()).log(Level.SEVERE, null, ex);
        }

        Double costo = Double.parseDouble(request.getParameter("costo"));
        
        controladora.altaServicio(nombre, tipo_servicio, descripcion, destino, fecha_servicio, costo);

        request.getSession().setAttribute("listaServicios", controladora.leeServicios());
        //luego del ALTA muestro la LISTA y tengo la confirmación visual de la misma
        response.sendRedirect("lista-servicios.jsp");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
