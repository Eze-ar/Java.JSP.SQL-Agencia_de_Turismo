package agencia_servlets;

import agencia_logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvBajaEmpleado", urlPatterns = {"/SvBajaEmpleado"})
public class SvBajaEmpleado extends HttpServlet {
    
    Controladora controladora = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id_Empleado = Integer.parseInt(request.getParameter("id_Empleado"));
        
        controladora.bajaEmpleado(id_Empleado);
        
        //actualizo lista de Empleados para reflejar el cambio.
        request.getSession().setAttribute("listaEmpleados", controladora.leeEmpleados());
        
        response.sendRedirect("lista-empleados.jsp");
        
    }
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
