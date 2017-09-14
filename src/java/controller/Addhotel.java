/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ahmedfadel.com.HotelDao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Hotel;
import model.organization_acount;

/**
 *
 * @author Smart
 */
public class Addhotel extends HttpServlet {

    /**
    
    * this servelet manage add hotel page 
    * there are three buttons add update, delete  
    * we make three methods for them 
    * insert ,update ,delete
     * @throws IOException if an I/O error occurs
     */
    Connection con=null;
    @Override
    public void init(){
      
        
    
    }
    //the method prevent duplication of primary key in hotel table 
    // if value of p k eixtst return false
    private  boolean  checkDuplictePrimaKey(HttpServletRequest request) {
     try{ int hotelId=Integer.parseInt(request.getParameter("hotel_id"));    
       
       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ahmed","root","");
          String sql="SELECT  *  FROM `hotel` WHERE id=?";
          PreparedStatement pst=con.prepareStatement(sql); 
          pst.setInt(1, hotelId);
     }catch(SQLException sqlex){
       sqlex.printStackTrace();
     }    
    return true;
    } 
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        // this mean if there is data with thaat key  go to error page 
        if(checkDuplictePrimaKey( request))   
                 response.sendRedirect("view/index.jsp");
        
          
        if (request.getParameter("insert")!= null) {
            inserthotel(request, response);
            
        } else if (request.getParameter("update") != null) {
           updatehotel(request, response);
        } else if (request.getParameter("delete") != null) {
            deletehotel(request, response);
        } else {
           
        } 
          
//              response.sendRedirect("view/index.jsp");
      
        
    }
     public  void inserthotel(HttpServletRequest request, HttpServletResponse response){
           HttpSession session=request.getSession();
              organization_acount oc  =(organization_acount) session.getAttribute("organization_acount");
//         File file = new File(request.getParameter("pic"));
//         byte[] imageData = new byte[(int) file.length()];
// 
//         try {
//            fileInputStream = new FileInputStream(file);
//            fileInputStream.read(imageData);
//            fileInputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } 
        String image,name,address,arrival_time,location;
         int  rooms,id,adults,price,children;
       
        
       // image = request.getParameter("pic");
        id = Integer.parseInt( request.getParameter("hotel_id"));
        rooms = Integer.parseInt(request.getParameter("rooms"));
        adults = Integer.parseInt(request.getParameter("adalts"));
        price = Integer.parseInt(request.getParameter("price"));
        name = request.getParameter("name");
        address = request.getParameter("address");
        arrival_time = request.getParameter("arrivaltime");
        location = request.getParameter("location");
           
           
        Hotel hotel=new Hotel();
             hotel.setId(id);
             hotel.setorganization_acount(oc);
            // hotel.setFileimage(imageData);`
             hotel.setAddress(address);
             hotel.setAdults(adults);
             hotel.setName(name);
             hotel.setArrival_time( arrival_time);
             hotel.setChildren(10);
            
             hotel.setLocation(location);
             hotel.setPrice(price);
             hotel.setRooms(rooms);
         
        
         HotelDao.insert(hotel);
           
           
          
     }
     
     public void deletehotel(HttpServletRequest request, HttpServletResponse response){
        int id= Integer.parseInt(request.getParameter("hotel_id"));
           HotelDao.delete(id);
     }
     public void updatehotel (HttpServletRequest request, HttpServletResponse response){
        int id= Integer.parseInt(request.getParameter("hotel_id"));
           HotelDao.delete(id);
          inserthotel(request,response);  
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
