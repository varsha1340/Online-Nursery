/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Varsha Patidar
 */
public class manageuser extends HttpServlet {
 Connection con;
    PreparedStatement pst;
    ResultSet rs;
    int row;
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
           
          Class.forName("org.apache.derby.jdbc.ClientDriver"); 
           con = DriverManager.getConnection("jdbc:derby://localhost:1527/varsha","root","varsha");
          String sql;
          sql="select * from register";
          Statement stmt = con.createStatement();
          rs = stmt.executeQuery(sql);
              out.println("<table cellspacing='0' width='1050px' border='1' font-size='90px' align='center'>");
             out.println("<tr align='center'>");
               out.println("<td>user id</td>");
                   out.println("<td>User name</td>");
                  out.println("<td>mobile</td>");
                   out.println("<td>Email</td>");
                  out.println("<td>State</td>");
                  out.println("<td>city</td>");
                   out.println("<td>pin</td>");
                  out.println("<td>address</td>");
                  out.println("<td>Delete</td>");
                   out.println("</tr>");
             
             while(rs.next())
             {
                out.println("<tr align='center'>");
                 out.println("<td>"  + rs.getString("uid")  + "</td>");
                out.println("<td>"  + rs.getString("uname")  + "</td>");
                out.println("<td>"  + rs.getString("mob")  + "</td>");
                out.println("<td>"  + rs.getString("email")  + "</td>");
                out.println("<td>"  + rs.getString("state")  + "</td>");
                out.println("<td>"  + rs.getString("city")  + "</td>");
                out.println("<td>"  + rs.getString("pin")  + "</td>");
                out.println("<td>"  + rs.getString("addr")  + "</td>");
              
               
                out.println("<td>"  + "<a href='Delete1?uid="  +  rs.getString("uid")  + "'> Delete </a>" +   "</td>");
                out.println("</tr>");
             }
             
            
          out.println("</table>");
          
          
          
        } catch (ClassNotFoundException | SQLException ex) {
         Logger.getLogger(manageuser.class.getName()).log(Level.SEVERE, null, ex);
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
