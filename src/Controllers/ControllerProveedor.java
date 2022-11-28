/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Models.ModelConnbd;

/**
 *
 * @author rb__s
 */
public class ControllerProveedor {


    
    private String dates;
    private ModelConnbd Conn;
    
    public ControllerProveedor()
    {
        
        
       Conn = new ModelConnbd();
        
        
    }
    
    
       /**
     * @return the dates
     */
    public String getDates() {
        
        String query = "Select * from proveedor";
         String name = "";
        ResultSet resulqy = Conn.ejecutarQueryResult(query);
        
        try{
            while(resulqy.next())
            {
                
               name =  resulqy.getString("nombre");
        
            }
        }catch(Exception e)
        {
            System.out.print(" \nQuery Fail a Proveedor \n");
            return name;
        }
        
        return name;
    }

    /**
     * @param dates the dates to set
     */
    public void setDates(String dates) {
        this.dates = dates;
    }
    
    
}
