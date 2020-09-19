
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditServlet extends HttpServlet {
 Connection con;
    PreparedStatement pst;
    ResultSet rs;
    int row;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
 String uid = request.getParameter("uid");
         
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             Class.forName("org.apache.derby.jdbc.ClientDriver"); 
           con = DriverManager.getConnection("jdbc:derby://localhost:1527/varsha","root","varsha");
          String uname = request.getParameter("uname");
           
            String mob = request.getParameter("mob");
            String email = request.getParameter("email");
            String state = request.getParameter("state");
            String city = request.getParameter("city");
            String pin = request.getParameter("pin");
            String addr = request.getParameter("addr");
           
           pst = con.prepareStatement("update register set uname = ? ,mob = ? ,email = ?,state = ? ,city = ?,pin = ? ,addr = ? where uid = ? ");
           pst.setString(1, uname);
           pst.setString(2, mob);
            pst.setString(3, email);
           pst.setString(4, state);
            pst.setString(5, city);
           pst.setString(6, pin);
           pst.setString(7, addr);
            pst.setString(8, uid);
          
           row = pst.executeUpdate();
           
           out.println("<font color='green'>Recorded Updated</font>");
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
               
             out.println("<font color='red'>Recorded failed</font>");
         
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
