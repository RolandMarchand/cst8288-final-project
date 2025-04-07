package presentation;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet displays a simple dashboard to filter maintenance reports
 * by vehicle fuel type. It handles both GET and POST requests.
 *
 * Author: sebl4
 */
public class MaintenanceDashboard extends HttpServlet {

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
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MaintenanceDashboard</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            
            out.println("<h1>Maintenance Dashboard</h1>");
            out.println("<form action=\"MainController-URL\" method=\"POST\">");
            out.println("<label for=\"fuelType\">Select Fuel Type:</label>");
            out.println("<select name=\"fuelType\" id=\"fuelType\">");
            out.println("<option value=\"all\">All</option>");
            out.println("<option value=\"electric\">Electric</option>");
            out.println("<option value=\"diesel\">Diesel</option>");
            out.println("<option value=\"dieselElectric\">Diesel-Electric</option>");
            out.println("</select>");
            out.println("<button type=\"submit\" name=\"action\" value=\"getMaintenanceReports\">Filter</button>");
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
