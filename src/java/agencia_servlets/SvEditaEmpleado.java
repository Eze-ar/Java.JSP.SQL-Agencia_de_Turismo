package agencia_servlets;

import agencia_logica.Controladora;
import agencia_logica.Empleado;
import agencia_logica.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvEditaEmpleado", urlPatterns = {"/SvEditaEmpleado"})
public class SvEditaEmpleado extends HttpServlet {

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
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String dni = request.getParameter("dni");
        String fecha_nac_str = request.getParameter("fecha_nac");
       
        //recibe la fecha como String y la pasa a Date:
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        //tuve que usar el formato que usa MySQL se ve por defecto....no lo supe cambiar a dd/MM/yyyy
        //lo veré más adelante ya que no me funcionó de otra manera
        Date fecha_nac = null;
        try {
            fecha_nac = formato.parse(fecha_nac_str);
        } catch (ParseException ex) {
            Logger.getLogger(SvEditaEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String nacionalidad = request.getParameter("nacionalidad");
        String celular = request.getParameter("celular");
        String email = request.getParameter("email");
        String cargo = request.getParameter("cargo");
        Double sueldo = Double.parseDouble(request.getParameter("sueldo"));
        
        Usuario usuario = new Usuario();
        
        usuario.setNombre(request.getParameter("usuario"));
        usuario.setPassword(request.getParameter("password"));
       
        Empleado empleado = controladora.leeEmpleado(id_Empleado);
        
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setDireccion(direccion);
        empleado.setDni(dni);
        empleado.setFecha_nac(fecha_nac);
        empleado.setNacionalidad(nacionalidad);
        empleado.setCelular(celular);
        empleado.setEmail(email);
        empleado.setCargo(cargo);
        empleado.setSueldo(sueldo);
        empleado.setUsuario(usuario);
        
        //lo debería hacer la controladora:
        controladora.editaEmpleado(empleado);
        
        //actualizo lista de empleados:
        request.getSession().setAttribute("listaEmpleados", controladora.leeEmpleados());
        
        //termino de editar y muestro la lista actualizada:
        response.sendRedirect("lista-empleados.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
