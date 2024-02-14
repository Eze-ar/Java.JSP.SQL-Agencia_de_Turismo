package agencia_servlets;

import agencia_logica.Controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvBajaCliente", urlPatterns = {"/SvBajaCliente"})
public class SvBajaCliente extends HttpServlet {
    
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
        
        controladora.bajaCliente(id_Cliente);
        
        //actualizo lista de Clientes para reflejar el cambio.
        //request.getSession().setAttribute("listaClientes", controladora.leeClientes());
        
        response.sendRedirect("lista-clientes.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
