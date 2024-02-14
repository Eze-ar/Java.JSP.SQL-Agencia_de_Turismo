package agencia_servlets;

import agencia_logica.Controladora;
import agencia_logica.Empleado;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvLeeEmpleado", urlPatterns = {"/SvLeeEmpleado"})
public class SvLeeEmpleado extends HttpServlet {
    
    Controladora controladora = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Empleado> listaEmpleados = controladora.leeEmpleados();
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("listaEmpleados", listaEmpleados);
        response.sendRedirect("lista-empleados.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id_Empleado = Integer.parseInt(request.getParameter("id_Empleado"));
       
        Empleado empleado = controladora.leeEmpleado(id_Empleado);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("empleado", empleado);
        response.sendRedirect("edita-empleado.jsp");
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}