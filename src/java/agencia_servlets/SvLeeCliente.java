package agencia_servlets;

import agencia_logica.Cliente;
import agencia_logica.Controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvLeeCliente", urlPatterns = {"/SvLeeCliente"})
public class SvLeeCliente extends HttpServlet {
    
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
        
         //del front obtiene el id_Cliente:
        int id_Cliente = Integer.parseInt(request.getParameter("id_Cliente"));
       
        Cliente cliente = controladora.leeCliente(id_Cliente);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("cliente", cliente);
        response.sendRedirect("edita-cliente.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
