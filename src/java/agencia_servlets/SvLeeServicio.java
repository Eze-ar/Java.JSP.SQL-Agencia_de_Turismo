package agencia_servlets;

import agencia_logica.Controladora;
import agencia_logica.Servicio_Turistico;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvLeeServicio", urlPatterns = {"/SvLeeServicio"})
public class SvLeeServicio extends HttpServlet {
    
    Controladora controladora = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        List<Servicio_Turistico> listaServicios = controladora.leeServicios();
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("listaServicios", listaServicios);
        response.sendRedirect("lista-servicios.jsp");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int codigo = Integer.parseInt(request.getParameter("codigo"));
       
        Servicio_Turistico servicio = controladora.leeServicio(codigo);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("servicio", servicio);
        response.sendRedirect("edita-servicio.jsp");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
