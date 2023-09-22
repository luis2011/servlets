
package servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import logica.Controladora;
import logica.Usuario;


@WebServlet(name = "SvUsuarios", urlPatterns = {"/SvUsuarios"})
public class SvUsuarios extends HttpServlet {

    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        List<Usuario>listaUsuarios = new ArrayList<Usuario>();
         listaUsuarios = control.getUsuarios();
         
         HttpSession misession = request.getSession();
         misession.setAttribute("listaUsuarios", listaUsuarios);
         
        
         
         response.sendRedirect("verUsuarios.jsp");
         
    
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombreUsuario = request.getParameter("nombreusu");
        String contra = request.getParameter("contrasenia");
        String rol = request.getParameter("rol");
        
       // System.out.println("el nombre de usuario es: " + nombreUsuario);
       control.crearUsuario(nombreUsuario, contra, rol);
       
       
        
        response.sendRedirect("index.jsp");        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
