package presentation;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * Front end main controller, all forms and posts go here, and are filtered by their action attribute's value.
 * 
 * @author sebl4
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController-URL"})
public class MainController extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        if(action == null || action.isEmpty()) {
            action = "welcome";
        }
        
        String url;
        switch(action) {
            case "welcome":
                url = "/WelcomePage-URL";
                break;
            case "login":
                url = "/LoginPage-URL";
                break;
            case "attemptUserLogin":
                url = "/ValidateLoginServlet-URL";
                break; 
            case "register":
                url = "/RegistrationPage-URL";
                break; 
            case "attemptUserRegistration":
                url = "/ValidateNewUserServlet-URL";
                break;
            case "addNewVehicle":
                url = "/AddVehiclePage-URL";
                break;    
            case "attemptVehicleRegistration":
                url = "/ValidateNewVehicleServlet-URL";
                break;
            default:
                url = "/WelcomePage-URL";
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
