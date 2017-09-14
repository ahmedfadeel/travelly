
package controller;

import ahmedfadel.com.CarsDao;
import ahmedfadel.com.organization_acountDao;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cars;
import model.organization_acount;
 
public class Addcar extends HttpServlet {
     FileInputStream fileInputStream =null;
      
    
      
       
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            
            throws ServletException, IOException {
       
        if (request.getParameter("insert")!= null) {
               
        HttpSession session=request.getSession();
     organization_acount oc  =(organization_acount) session.getAttribute("organization_acount");
//           
//          
//            int carnum=Integer.parseInt(request.getParameter("carnumber")); 
//            double  d=Double.parseDouble(request.getParameter("price_per_day"));
              // start validation id 
           
                    
                
                  
//             
            
//               cars= (ArrayList<Cars>)CarsDao.searchCarById(id);  
//                  if(cars!=null) idMessage="+\n enter valid id this id exists   " ; 
//               
            Cars cars=new Cars();
            
            
               
            
              int id=Integer.parseInt(request.getParameter("car_id")); 
           ArrayList<Cars>     carss= (ArrayList<Cars>)CarsDao.searchCarById(id);  
                  if(!carss.isEmpty())   response.sendRedirect("view/add/car_validate_pk.jsp");  
                          
                          
          cars.setId(id);            
          cars.setCampany_name(request.getParameter("orgenizationname"));
         
          cars.setCar_number(Integer.parseInt(request.getParameter("carnumber")));
          cars.setOwner_name(request.getParameter("onwername"));
          cars.setCommit(request.getParameter("commit"));
          cars.setType(request.getParameter("type"));
          cars.setorganization_acount(oc);
          cars.setPrice_perday(Double.parseDouble(request.getParameter("price_per_day")));
          cars.setTake_car(request.getParameter("takecar"));
//          cars.setFileimage(imageData);
          cars.setRetretive_car(request.getParameter("retretivecar"));
    
           CarsDao.insert(cars);
           
               response.sendRedirect("view/index.jsp"); 
        } 
        
        
        
        else if (request.getParameter("update") != null) {
           updatecar(request, response);
            response.sendRedirect("view/index.jsp"); 
        } 
        
        
        else if (request.getParameter("delate") != null) {
          
         int id=Integer.parseInt(request.getParameter("car_id"));
              response.sendRedirect("view/index.jsp"); }
        } 
        
        
                 
     
    
     public  void insertcar(HttpServletRequest request, HttpServletResponse response) throws IOException{
          
        
 
       
         
        HttpSession session=request.getSession();
     organization_acount oc  =(organization_acount) session.getAttribute("organization_acount");
//           
//          
//            int carnum=Integer.parseInt(request.getParameter("carnumber")); 
//            double  d=Double.parseDouble(request.getParameter("price_per_day"));
              // start validation id 
           
                    
                
                  
//             
            
//               cars= (ArrayList<Cars>)CarsDao.searchCarById(id);  
//                  if(cars!=null) idMessage="+\n enter valid id this id exists   " ; 
//               
            Cars cars=new Cars();
            
            
               
            
              int id=Integer.parseInt(request.getParameter("car_id")); 
           ArrayList<Cars>     carss= (ArrayList<Cars>)CarsDao.searchCarById(id);  
                  if(!carss.isEmpty())   response.sendRedirect("view/add/car_validate_pk.jsp");  
                          
                          
          cars.setId(id);            
          cars.setCampany_name(request.getParameter("orgenizationname"));
         
          cars.setCar_number(Integer.parseInt(request.getParameter("carnumber")));
          cars.setOwner_name(request.getParameter("onwername"));
          cars.setCommit(request.getParameter("commit"));
          cars.setType(request.getParameter("type"));
          cars.setorganization_acount(oc);
          cars.setPrice_perday(Double.parseDouble(request.getParameter("price_per_day")));
          cars.setTake_car(request.getParameter("takecar"));
//          cars.setFileimage(imageData);
          cars.setRetretive_car(request.getParameter("retretivecar"));
    
           CarsDao.insert(cars);
     
     }
     
      public void updatecar(HttpServletRequest request,HttpServletResponse response){
          
                
        File file = new File(request.getParameter("pic"));
          byte[] imageData = new byte[(int) file.length()];
          
          
         try {
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(imageData);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int id=Integer.parseInt(request.getParameter("car_id"));
            ArrayList<Cars>     carss= (ArrayList<Cars>)CarsDao.searchCarById(id);  
                  if(carss!=null)   try {
                      response.sendRedirect("view/add/car_delete_nEk.jsp");
         } catch (IOException ex) {
             Logger.getLogger(Addcar.class.getName()).log(Level.SEVERE, null, ex);
         }  
        
        String owner_name=request.getParameter("onwername");
        String type=request.getParameter("type");
        String campany_name=request.getParameter("orgenizationname"); 
        String take_car=request.getParameter("takecar");
        String retretive_car=request.getParameter("retretivecar");
        Double price_perday=Double.parseDouble(request.getParameter("price_per_day"));
        String commit=request.getParameter("commit");
        int car_number=Integer.parseInt(request.getParameter("carnumber"));  
      HttpSession session=request.getSession();
         organization_acount oc  =(organization_acount) session.getAttribute("organization_acount");
   
       
         CarsDao.update(id, oc, retretive_car, owner_name, type, campany_name, take_car, price_perday, commit, car_number, id);
          
              
             
      
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
