package agencia_servlets;

import agencia_logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvBajaPaquete", urlPatterns = {"/SvBajaPaquete"})
public class SvBajaPaquete extends HttpServlet {
    
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
        
        controladora.bajaPaquete(codigo);
        
        //actualizo lista de paquetes para reflejar el cambio.
        request.getSession().setAttribute("listaPaquetes", controladora.leePaquetes());
        
        response.sendRedirect("lista-paquetes.jsp");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
