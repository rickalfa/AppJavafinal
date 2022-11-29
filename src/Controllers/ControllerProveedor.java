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
public class ControllerProveedor extends CrudControllerAbs {


    
    private String dates;
    private ModelConnbd Conn;
    
    public ControllerProveedor()
    {
        
        
       Conn = new ModelConnbd();
        
        
    }
    
       /**
     * @return the dates
     */
    public String getDates() 
    {
        
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

    @Override
    public String[][] get(int index) {
    
    String query = "Select * from proveedor where id_proveedor='"+index+"'";
    String[][] datesuser = new String[1][3]; 
    int i = 0;
            
        try{
            
            
             ResultSet resulqy = Conn.ejecutarQueryResult(query);
        
             String RowQuery = String.valueOf(resulqy.getRow());
             
             System.out.print(" \n row de la query : " + RowQuery);
            while(resulqy.next())
            {
                
               datesuser[i][0] =  resulqy.getString("nombre");
               datesuser[i][1] =  resulqy.getString("email");
               datesuser[i][2] =  resulqy.getString("direccion");
        
               i++;
               
            }
            
            if(datesuser[0][0] != null){
            
                return datesuser;
                 
            }else{
                
                return null;
            
            }
             
           
             
        }catch(Exception e)
        {
            
            System.out.print("peticion get FAIL ");
            return null;
        }
    
        
    }

    @Override
    public String[][] get() {
        
        String query = "Select * from proveedor";
        String name = "";
        String[][] datesuser = new String[20][5];
       
        int i = 0;
        
        try{
            
            
            ResultSet resulqy = Conn.ejecutarQueryResult(query);
        
             String RowQuery = String.valueOf(resulqy.getRow());
             
             System.out.print(" \n row de la query : " + RowQuery);
         
            
            while(resulqy.next())
            {
                
               datesuser[i][0] =  resulqy.getString("nombre");
               datesuser[i][1] =  resulqy.getString("email");
               datesuser[i][2] =  resulqy.getString("direccion");
        
               i++;
               
            }
             System.out.print(" \n valor de i : ");
            System.out.print(i );
            
            String[][] datesResult= new String[i][3];
            
             int count = 0;
            
             for(count = 0; count < i; count++){
                 datesResult[count][0] = datesuser[count][0];
                 datesResult[count][1] = datesuser[count][1];
                 datesResult[count][2] = datesuser[count][2];
            
                 System.out.print(" \n"+ datesResult[count][0] +" \n");
              }
            
             return datesResult;
            
        }catch(Exception e)
        {
            System.out.print(" \nQuery Fail a Proveedor \n");
            return null;    
            
        }
        
             
        
   }

    @Override
    public int update(int index, String[][] datesuser) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insert(String[][] datesuser) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
