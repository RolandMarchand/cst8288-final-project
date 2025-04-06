package presentation;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet handles the user registration form and posts a attemptUserRegistration action to MainController.
 * The following html attributes are also populated: firstName, lastName, email, password, userType. 
 * 
 * @author sebl4
 */
public class RegistrationPage extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * 
     * Displays registration form to users. Posts action to MainController 
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
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Register</title>");
            out.println("</head>");
            out.println("<body>");
            
            out.println("<center>");
            out.println("<h1>Transit System Registration</h1>");
            out.println("<form action=\"MainController-URL\" method=\"POST\">");
            
            out.println("<label for=\"firstName\">First Name:</label><br>");
            out.println("<input type=\"text\" id=\"firstName\" name=\"firstName\" required><br><br>");
            
            out.println("<label for=\"lastName\">Last Name:</label><br>");
            out.println("<input type=\"text\" id=\"lastName\" name=\"lastName\" required><br><br>");
            
            out.println("<label for=\"email\">Email:</label><br>");
            out.println("<input type=\"email\" id=\"email\" name=\"email\" required><br><br>");
            
            out.println("<label for=\"password\">Password:</label><br>");
            out.println("<input type=\"password\" id=\"password\" name=\"password\" required><br><br>");
            
            out.println("<label for=\"userType\">User Type:</label><br>");
            out.println("<select id=\"userType\" name=\"userType\" required>");
            out.println("<option value=\"Operator\">Operator</option>");
            out.println("<option value=\"Manager\">Manager</option>");
            out.println("</select><br><br>");
            
            out.println("<button type=\"submit\" name=\"action\" value=\"attemptUserRegistration\">Register</button>");
            out.println("</form>");
            out.println("<br>");
            out.println("<br>");
            out.println("<button type=\"button\" onclick=\"window.location.href='WelcomePage-URL'\">Back to Welcome</button>");
            out.println("</center>");
            
            out.println("</body>");
            out.println("</html>");
        }
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
