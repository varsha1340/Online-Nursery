
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

public class reg extends HttpServlet {
Connection con;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String uname = request.getParameter("uname");
           
            String mob = request.getParameter("mob");
            String email = request.getParameter("email");
            String pass = request.getParameter("pass");
             String cpass = request.getParameter("cpass");
            String state = request.getParameter("state");
            String city = request.getParameter("city");
            String pin = request.getParameter("pin");
            String addr = request.getParameter("addr");
             String security = request.getParameter("security");
            String answer = request.getParameter("answer");
             Class.forName("org.apache.derby.jdbc.ClientDriver"); 
           con = DriverManager.getConnection("jdbc:derby://localhost:1527/varsha","root","varsha");
           Statement st = con.createStatement();
           ResultSet rs;
           int i = st.executeUpdate("insert into register values('"+uname+"','"+mob+"','"+email+"','"+pass+"','"+cpass+"','"+state+"','"+city+"','"+pin+"','"+addr+"','"+security+"','"+answer+"')");
            response.sendRedirect("http://localhost:8080/varsha/signupthanku.html");
            
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
