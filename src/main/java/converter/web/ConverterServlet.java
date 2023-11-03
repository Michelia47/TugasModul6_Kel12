/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package converter.web;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import converter.ejb.ConverterBean;

@WebServlet(name = "ConverterServlet", urlPatterns = {"/ConverterServlet"})
public class ConverterServlet extends HttpServlet {
 /**
 * Processes requests for both HTTP <code>GET</code> and 
<code>POST</code>
 * methods.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
 private ConverterBean cb = new ConverterBean();
 
 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
     response.setContentType("text/html;charset=UTF-8");
     PrintWriter out = response.getWriter();
    // Output the results
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Temperature Converter</title>");
    out.println("<style>");
    out.println(".h1 {text-align: center; padding: 20px}");
    out.println(".p1 {text-align: center;}");
    out.println(".p2 {text-align: center; margin: 5px auto}");
    out.println(".p3 {background-color: #a5e5ff}");
    out.println(".p4 {background-color: #ffc784}");
    out.println("</style>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1 class='h1'>Temperature Converter </h1>");
    try {
        String degree = request.getParameter("degree");
        if ((degree != null) && (degree.length() > 0)) {
            double d = Double.parseDouble(degree);
            if (request.getParameter("C TO K") != null) {
                String centigrade = cb.ctok(d); 
                out.println("<p class='p1'>" + degree + " Celcius are " + centigrade + " Kelvin.</p>");
            }
            if (request.getParameter("K TO C") != null) {
                String kelvin = cb.ktoc(d);
                out.println("<p class='p1'>" + degree + " Kelvin are " + 
                        kelvin + " Celcius.</p>");
            }
        } else {
            out.println("<p class='p1'>Enter degree to convert :</p>");
            out.println("<form method=\"get\">");
            out.println("<p class='p1'> <input type=\"text\" name=\"degree\" size=\"25\"></p>");
            out.println("<p class='p2'><input class='p3' type=\"submit\" name=\"K TO C\" value=\"K TO C\"></p>" + "<p class='p2'><input class='p4' type=\"submit\" name=\"C TO K\" value=\"C TO K\"></p>");
            out.println("</form>");
        } 
    } finally {
        out.println("</body>");
        out.println("</html>");
        out.close();
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
         throws ServletException, IOException {processRequest(request, response);}
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
 throws ServletException, IOException {processRequest(request, response);}
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