/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Smart
 */
public class Login extends HttpServlet {

    public static boolean checkNameExistence(String Name){
      String sql="";
      PreparedStatement pst=null; 
      ResultSet res=null;
  
      try{   
           try{Class.forName("com.mysql.jdbc.Driver");}catch(Exception e){}
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ahmed","root","");
            sql="SELECT `ORGANIZATION_ID`,  `name`, `password` FROM `organization_acount` WHERE name  =  ?";
            pst=con.prepareStatement(sql); 
            pst.setString(1, Name);
            res= pst.executeQuery(); 
            if(!res.next()){
            
                return false;
            }
      }catch(SQLException sqlex){
       sqlex.printStackTrace();
      } 
      
    return true;      
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // start loh in using cookies
        Cookie cookies[] =request.getCookies();
        boolean foundUser=false;
          for(int i=0;i<cookies.length;i++){
              if( cookies[i].getName().equals("userName") &&  cookies[i].getValue()!=null ){
                foundUser=true;   
                break;
              };
          }    
          if(foundUser){
           request.getSession().setAttribute("name", "userName");  
           response.sendRedirect("view/index.jsp");
          }else{
            request.getRequestDispatcher("view/login/login.jsp").forward(request, response);
          } 
        // end log in using cookies 
        //*********************************
        // start log in using database  
        String userName=request.getParameter("username");
        boolean isexixt= checkNameExistence(userName); // check if this user exist indadabase or not 

          if (isexixt){
           request.getSession().setAttribute("name", "userName");  
           response.sendRedirect("view/index.jsp");
          }   
          else{ request.getRequestDispatcher("view/login/login.jsp").forward(request, response);}
             
//                      .
//        try  {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Login</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>"+isexixt);
//            out.println("</body>");
//            out.println("</html>");
//        }
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
