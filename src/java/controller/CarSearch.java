/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import ahmedfadel.com.CarsDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cars;


/**
 *
 * @author master
 */
public class CarSearch extends HttpServlet {

   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        request.getParameter("check");
//        request.getParameter("searchcar");
         String check = "take";
         String searchcar = "1/5/2015";
         List <Cars> cars=null;
        if ("take".equals(check)) {
           cars= CarsDao.searchCarBytake_car(searchcar);
        } else if ("price".equals(check)) {
           
            cars=CarsDao.searchCarByPriceperday(Double.parseDouble(searchcar));
            
        }
         else if ("model".equals(check)) {
           cars= CarsDao.searchCarBytype(searchcar);
        }
         else if ("Retrive".equals(check)) {
            cars=CarsDao.searchCarByRetretiveCar(searchcar);
        }
        if(cars.isEmpty()) response.sendRedirect("view/cars.jsp");
        else{  
        HttpSession session=request.getSession();
        session.setAttribute("carslist", cars);
        response.sendRedirect("view/Car-search.jsp");}
      

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


