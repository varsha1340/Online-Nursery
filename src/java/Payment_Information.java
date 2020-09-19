
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Payment_Information extends HttpServlet {
Connection con;
   ResultSet rs;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String pid = request.getParameter("pid");
            String uid = request.getParameter("uid");
            String fname = request.getParameter("fname");
            String state = request.getParameter("state");
            String city = request.getParameter("city");
            String address = request.getParameter("address");
            String cardname = request.getParameter("cardname");
            String cardnumber = request.getParameter("cardnumber");
            String expmonth = request.getParameter("expmonth");
            String expyear = request.getParameter("expyear");
            String cvv = request.getParameter("cvv");
            String contact = request.getParameter("contact");
            String ocontact = request.getParameter("ocontact");
            String pin = request.getParameter("pin");
            String email = request.getParameter("email");
             Class.forName("org.apache.derby.jdbc.ClientDriver"); 
           con = DriverManager.getConnection("jdbc:derby://localhost:1527/varsha","root","varsha");
           Statement st = con.createStatement();
        
           int i = st.executeUpdate("insert into PAYMENTINFORMATION values('"+pid+"','"+uid+"','"+fname+"','"+state+"','"+city+"','"+address+"','"+cardname+"','"+cardnumber+"','"+expmonth+"','"+expyear+"','"+cvv+"','"+contact+"','"+ocontact+"','"+pin+"','"+email+"')");
         out.print("<form action='home.html' method='get'");
                out.print("<pre><center><h1>View Order Details Account</h1></center></pre>");
              
                 out.print("View Order :"  + "<a href='vieworder? '> View Order Products </a><br>" );
             
              
                out.print("</form");
        } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(reg.class.getName()).log(Level.SEVERE, null, ex);
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
