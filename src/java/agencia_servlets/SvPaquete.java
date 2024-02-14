package agencia_servlets;

import agencia_logica.Controladora;
import agencia_logica.Servicio_Turistico;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvPaquete", urlPatterns = {"/SvPaquete"})
public class SvPaquete extends HttpServlet {
    
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
        
        int cod_servicio1 = Integer.parseInt(request.getParameter("cod_servicio1"));
        int cod_servicio2 = Integer.parseInt(request.getParameter("cod_servicio2"));
        int cod_servicio3 = Integer.parseInt(request.getParameter("cod_servicio3"));
        
        //no puedo cargar un servicio más de 1 vez en el paquete!:
        if ((cod_servicio1 == cod_servicio2) || (cod_servicio1 == cod_servicio3) || (cod_servicio2 == cod_servicio3)) 
            response.sendRedirect("servicio-repetido.jsp");
       
        String nombre = request.getParameter("nombre");
        
        //recibí del front los cód de servicio, con ellos obtengo toda la info de los
        //mismo por medio de la controladora:
        Servicio_Turistico servicio1 = controladora.leeServicio(cod_servicio1);
        Servicio_Turistico servicio2 = controladora.leeServicio(cod_servicio2);
        Servicio_Turistico servicio3 = controladora.leeServicio(cod_servicio3);
         
        Double costo_total = servicio1.getCosto_servicio();
        
        List<Servicio_Turistico> listaServicios = new ArrayList<Servicio_Turistico>();
        
        listaServicios.add(servicio1);
        
        if(cod_servicio2 != 0){ //o sea si hay servicio2
            
            costo_total += servicio2.getCosto_servicio();
            listaServicios.add(servicio2);
        }
        
        if(cod_servicio3 != 0){ //o sea si hay servicio3
            
            costo_total += servicio3.getCosto_servicio();
            listaServicios.add(servicio3);
        }
        
        costo_total -= costo_total*0.1; //dto del 10% por paquete
        
        controladora.altaPaquete(nombre, listaServicios, costo_total);
        
        response.sendRedirect("lista-paquetes.jsp");
        
       
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
