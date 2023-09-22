
package servlets;

import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logica.Controladora;


@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {

Controladora control = new Controladora(); 
   
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
        processRequest(request, response);
        
        String usuario = request.getParameter("usuario");
        String contrasenia = request.getParameter("contrasenia");
        
        boolean validacion = false;
        
        validacion = control.comprobarIngreso(usuario, contrasenia);
        
        if(validacion == true){
            
            HttpSession misession = request.getSession(true);
            misession.setAttribute("usuario", usuario);
            response.sendRedirect("index.jsp");
        }
        else{
             response.sendRedirect("loginError.jsp");
            
        }
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
