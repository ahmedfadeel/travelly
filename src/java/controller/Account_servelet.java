/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.organization_acount;

/**
 *
 * @author Smart
 */
public class Account_servelet extends HttpServlet {

    /*
    this page take an account of organization_acount to save in seesion to be used in adding relation 
    bitween cars and hotels and flights
    
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
       boolean rememberMe=false;
       
        
       organization_acount oc=new organization_acount();
          oc.setAddress(request.getParameter("address"));
          oc.setId(Integer.parseInt(request.getParameter("ID")));
          oc.setName(request.getParameter("username"));
          oc.setPassword(request.getParameter("password"));
          oc.setPhone(request.getParameter("phone"));
          oc.setEmail(request.getParameter("email"));
          
        if (rememberMe){
            Cookie userNameCookie=new Cookie("userName", request.getParameter("username"));
             response.addCookie(userNameCookie);
        }   
        HttpSession  session=request.getSession();
            session.setAttribute("organization_acount", oc);
              response.sendRedirect("view/index.jsp");
            
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
