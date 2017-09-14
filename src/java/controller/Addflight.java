/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ahmedfadel.com.FlightDao;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Flight;
import model.organization_acount;

/**
 *
 * @author Smart
 */
public class Addflight extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public boolean  checkDuplictePrimaKey() {
    
     String sql=null;
     boolean resu=false;
    
            int id=2;
   try{    try{Class.forName("com.mysql.jdbc.Driver");}catch(Exception e){}
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ahmed","root","");
            sql="SELECT * FROM `flight` WHERE flight_number =  '"+id+"' ";
            Statement st=con.createStatement(); 
            resu= st.execute(sql); 
        
     }catch(SQLException sqlex){
       sqlex.printStackTrace();
     }       
    return resu;
    } 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       boolean c= checkDuplictePrimaKey();
        PrintWriter o=response.getWriter();
        
       

        if  (c)  {
        
           response.sendRedirect("view/cars.jsp"); 
            
           return;
       
        } 
        if  (c)  {
        
           response.sendRedirect("view/tour.jsp"); 
            
          
       
        } 
//          if (request.getParameter("insert") != null) {
//            insertflight(request, response);
//        } else if (request.getParameter("update") != null) {
//           deleteflight(request, response);
//        } else if (request.getParameter("delete") != null) {
//             updateflight(request, response);
//        } else {
//            // ???
//        } 
          
          // response.sendRedirect("view/index.jsp");
       
    }
        public  void insertflight(HttpServletRequest request, HttpServletResponse response){
           HttpSession session=request.getSession();
            organization_acount oc  =new organization_acount(); 
              oc.setId(1);
              oc.setName("ahmed");
              oc.setEmail("fdkmf");
              oc.setPassword("d,flf");
              oc.setAddress("dffmdk");
              oc.setPhone("fmmg");
            
            int flight_num = Integer.parseInt(request.getParameter("flightnumber"));
            String place = request.getParameter("place");
            String email = request.getParameter("email");
            String fromto = request.getParameter("fromto");
            int duration = Integer.parseInt(request.getParameter("duration"));
            int price = Integer.parseInt(request.getParameter("price"));
            String arrivetime = request.getParameter("arrivetime");
            String departime = request.getParameter("departuretime");
            int nsets = Integer.parseInt(request.getParameter("numseats"));
            String bagfees = request.getParameter("bagfees");
            String c_pass = request.getParameter("company_password");
            String c_address = request.getParameter("company_address");
            String com_phone = request.getParameter("company_phone");
            Flight flight = new Flight();
            flight.setFlight_number(flight_num);
            flight.setArrival_time(arrivetime);
            flight.setBag_fees(bagfees);
            flight.setDeparture_time(departime);
            flight.setDuration(duration);
            flight.setNum_seats(nsets);
            flight.setPrice(price);
            flight.setorganization_acount(oc);
            flight.setFrom_to(fromto);
            flight.setFlight_number(flight_num);
            flight.setPlaces(place);

           
            FlightDao.insert(flight);
       
         
        
         
           
           
          
     }
      public  void deleteflight(HttpServletRequest request, HttpServletResponse response){
         int flight_num = Integer.parseInt(request.getParameter("flightnumber"));
           FlightDao.delete(flight_num);
      }
      public void updateflight(HttpServletRequest request,HttpServletResponse response){
          
        
             HttpSession session=request.getSession();
        organization_acount oc  =(organization_acount) session.getAttribute("organization_acount");
        
           
            int flight_num = Integer.parseInt(request.getParameter("flightnumber"));
            String place = request.getParameter("place");
            String email = request.getParameter("email");
            String fromto = request.getParameter("fromto");
            int duration = Integer.parseInt(request.getParameter("duration"));
            int price = Integer.parseInt(request.getParameter("price"));
            String arrivetime = request.getParameter("arrivetime");
            String departime = request.getParameter("departuretime");
            int nsets = Integer.parseInt(request.getParameter("numseats"));
            String bagfees = request.getParameter("bagfees");
           
       FlightDao.update(oc,  flight_num, arrivetime, departime, duration, fromto, place, price, nsets, bagfees);
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
