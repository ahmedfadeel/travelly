/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ahmedfadel.com.HotelDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Hotel;


/**
 *
 * @author master
 */
public class HotelSearch extends HttpServlet {

   // HotelDao hoteldao = new HotelDao();
    
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
        int id=0;
        List<Hotel> hotels=null;
        String check = request.getParameter("check");
        String searvalue=request.getParameter("searchhotel");
        
        if ("sName".equals(check)) {
           
            hotels=HotelDao.searchHotelByname(searvalue);
        } else if ("sPrice".equals(check)) {
           
              hotels=HotelDao.searchHotelByprice(Double.parseDouble(searvalue));
            
        }
         else if ("sLocation".equals(check)) {
            hotels=HotelDao.searchHotelByLocation(searvalue);
        }else{
             hotels=null;
             
             
         } 
      if(hotels==null) response.sendRedirect("view/hotel_1.jsp");
        HttpSession session=request.getSession();
        session.setAttribute("hotellist", hotels);
        response.sendRedirect("view/hotel-search.jsp");
       
//               RequestDispatcher rd = request.getRequestDispatcher("/view/newjsp.jsp");
//                     rd.forward(request,response);  
//              
        
        String s=request.getParameter("message");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HotelSearch</title>");            
            out.println("</head>");
            out.println("<body>");
            
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

    public static boolean isNumeric(String str) {  
        try  {  
          double d = Double.parseDouble(str);  
        }  
        catch(NumberFormatException nfe){  
          return false;  
        }  
        return true;  
  }

}
