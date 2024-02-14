package agencia_servlets;

import agencia_logica.Controladora;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvUsuario", urlPatterns = {"/SvUsuario"})
public class SvUsuario extends HttpServlet {

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
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        //creo una instancia de controladora, que me conecta el servlet con la lógica
        Controladora controladora = new Controladora();
        
        boolean autorizado = controladora.autorizaIngreso(usuario, password);
        
        if (autorizado) {
            //estando autorizado el log in se obtiene la sesión asignando user/password
            HttpSession sesion = request.getSession(true); 
            sesion.setAttribute("usuario", usuario);
            sesion.setAttribute("password", password);
            response.sendRedirect("index.jsp");
        }
        
        else {
            // No está autorizado el ingreso, al login de nuevo
            request.setAttribute("errorMessage", "Usuario o contraseña incorrectos");
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
