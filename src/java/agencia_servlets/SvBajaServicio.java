package agencia_servlets;

import agencia_logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvBajaServicio", urlPatterns = {"/SvBajaServicio"})
public class SvBajaServicio extends HttpServlet {
    
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
        
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        
        controladora.bajaServicio(codigo);
        
        //actualizo lista para reflejar el cambio.
        request.getSession().setAttribute("listaServicios", controladora.leeServicios());
        
        response.sendRedirect("lista-servicios.jsp");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
