/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ahmedfadel.com.FlightDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Flight;
import model.Hotel;

/**
 *
 * @author Smart
 */
public class Flightsearch extends HttpServlet {

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
        List<Flight> flights=null;
        String check = request.getParameter("check");
        String searvalue=request.getParameter("searchflight");
         
        
        if ("FromTo".equals(check)) {
           
         flights= FlightDao.searchflightByfrom_to(searvalue);
            
        }  
         else if ("numof_seats".equals(check)) {
            
         flights=FlightDao.searchflightBynum_seats(Integer.parseInt(searvalue));
            
        }
         else if ("ArrivalTime".equals(check)) {
           flights=   FlightDao.searchfligtByarrival_time(searvalue);
        }
         else if ("DepatureTime".equals(check)) {
           flights=   FlightDao.searchfligtBydeparture_time(searvalue);
         }
         else if ("price".equals(check)) {
            flights=  FlightDao.searchflightByprice(Integer.parseInt(searvalue));
         }
         else{
             flights=null;
             
             
         } 
        if(flights==null) response.sendRedirect("view/tour.jsp");
        HttpSession session=request.getSession();
        session.setAttribute("flightlist", flights);
        response.sendRedirect("view/Tour-search.jsp");

       
              
                   
              
        
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

}
