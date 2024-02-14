package agencia_servlets;

import agencia_logica.Controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvEmpleado", urlPatterns = {"/SvEmpleado"})
public class SvEmpleado extends HttpServlet {
    
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
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String dni = request.getParameter("dni");
        String fecha_nac_str = request.getParameter("fecha_nac");
        //sí, podría haber convertido a Date acá pero para hacer lo mín indispensable!
        String nacionalidad = request.getParameter("nacionalidad");
        String celular = request.getParameter("celular");
        String email = request.getParameter("email");
        String cargo = request.getParameter("cargo");
        String sueldo_str = request.getParameter("sueldo");
        //sí, podría haber convertido a Double acá pero para hacer lo mín indispensable!        
        
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        controladora.altaEmpleado(nombre, apellido, direccion, dni, fecha_nac_str, nacionalidad, celular, email, cargo, sueldo_str, usuario, password);
        
        //acá podría poner una página de "operación exitosa" también pero con mostrar la lista me alcanza
        request.getSession().setAttribute("listaEmpleados", controladora.leeEmpleados());
        //luego del ALTA muestro la LISTA y tengo la confirmación visual de la misma
        response.sendRedirect("lista-empleados.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
