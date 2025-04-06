package presentation;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * Servlet handles vehicle registration and posts attemptVehicleRegistration action to MainController.
 * 
 * Populates the following html attributes:vehicleType, vehicleNumber, fuelType,
 * consumptionRate, and maxPassengers.
 * 
 * @author sebl4
 */
public class AddVehiclePage extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Login</title>");
            out.println("</head>");
            out.println("<body>");
        
            out.println("<center>");
            out.println("<h1>Transit System Vehicle Registration</h1>");
            out.println("<form action=\"MainController-URL\" method=\"POST\">");
            
            out.println("<label for=\"vehicleType\">Vehicle Type:</label><br>");
            out.println("<select id=\"vehicleType\" name=\"vehicleType\" required>");
            out.println("<option value=\"Diesel Bus\">Diesel Bus</option>");
            out.println("<option value=\"Electric Light Rail\">Electric Light Rail</option>");
            out.println("<option value=\"Diesel-Electric Train\">Diesel-Electric Train</option>");
            out.println("</select><br><br>");
            
            out.println("<label for=\"vehicleNumber\">Vehicle Number:</label><br>");
            out.println("<input type=\"text\" id=\"vehicleNumber\" name=\"vehicleNumber\" required><br><br>");
            
            out.println("<label for=\"fuelType\">Fuel/Energy Type:</label><br>");
            out.println("<select id=\"fuelType\" name=\"fuelType\" required>");
            out.println("<option value=\"Electric\">Electric</option>");
            out.println("<option value=\"Diesel\">Diesel</option>");
            out.println("<option value=\"Diesel-Electric\">Diesel-Electric</option>");
            out.println("</select><br><br>");
            
            out.println("<label for=\"consumptionRate\">Consumption Rate:</label><br>");
            out.println("<input type=\"number\" step=\"0.01\" id=\"consumptionRate\" name=\"consumptionRate\" required><br><br>");
            
            out.println("<label for=\"maxPassengers\">Maximum # of Passengers:</label><br>");
            out.println("<input type=\"number\" id=\"maxPassengers\" name=\"maxPassengers\" required><br><br>");
            out.println("<button type=\"submit\" name=\"action\" value=\"attemptVehicleRegistration\">Register Vehicle</button>");
            out.println("<br>");
            out.println("<button type=\"button\" onclick=\"history.back()\">Back</button>");
           
            out.println("</form>");
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
