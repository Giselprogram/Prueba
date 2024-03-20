
package Servlet;

import Control.accionesEmpleado;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Empleado;

/**
 *
 * @author Jhon Gerardo
 */
public class guardarEmpleado extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
                       String nom, pass, email, pais;
            
            nom = request.getParameter("nombre");
            pass = request.getParameter("password"); 
             email = request.getParameter("email");
             pais = request.getParameter("pais");
            
            Empleado e = new Empleado();
            
            e.setNombre(nom);
            e.setPassword(pass);
            e.setEmail(email);
            e.setPais(pais);
            
          int status = accionesEmpleado.registrarEmpleado(e);

            
            if(status>0){
                response.sendRedirect("registroEmpleados.jsp");
            }else{
               response.sendRedirect("error.jsp");
            }
        }
    }

}
  