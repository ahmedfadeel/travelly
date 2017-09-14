package  ahmedfadel.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * 
 *searchHotelBypriceBerDay()

searchOfferByType()
	searchOfferByPrice()
 *
 * @author Smart
 */
 

public class Mainsearch { 
   public static  boolean  checkDuplictePrimaKey(int id) {
     ResultSet   res=null;
    
     String sql="SELECT  *  FROM `hotel` WHERE   id = ?";
     try{ //int hotelId=Integer.parseInt(request.getParameter("hotel_id"));    
       try{Class.forName("com.mysql.jdbc.Driver");}catch(Exception e){}
       Connection con=DriverManager.getConnection("jdbc:mysql://localhost/ahmed","root","");
         
       PreparedStatement pst=con.prepareStatement(sql); 
       pst.setInt(1,id);
       res=pst.executeQuery();
       if(!res.next()){
          return false;
       }      
         
     }catch(SQLException sqlex){
       sqlex.printStackTrace();
     }
     
      
    return true;
    
    }   
//    public static boolean checkNameExistence(String Name){
//      String sql="";
//      boolean result=true;
//      try{   
//          try {
//              Class.forName("com.mysql.jdbc.Driver");
//          } catch (ClassNotFoundException ex) {
//              Logger.getLogger(Mainsearch.class.getName()).log(Level.SEVERE, null, ex);
//          }
//           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ahmed","root","");
//            sql="SELECT `ORGANIZATION_ID`,  `name`, `password` FROM `organization_acount` WHERE name =  '"+Name+"' ";
//            Statement st=con.createStatement(); 
//            result= st.execute(sql); 
//        
//      }catch(SQLException sqlex){
//       sqlex.printStackTrace();
//      }       
//    return result;      
//     
//    }
 public static void main(String[] args) {
        System.out.println(checkDuplictePrimaKey(100));
     
        
         } 
          
                    
                  
               }             
 
    
   
  

