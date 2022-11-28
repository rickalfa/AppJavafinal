/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author rb__s
 */
public class ModelConnbd {
    
    
     private Connection Conn;
    
    public ModelConnbd(){
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
        
            Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_finalproject","root","");
        
            System.out.print(" \n conexion establecida con la base de datos \n");
            
           } catch(Exception e){
        
            System.err.println("Error Conexion base de datos : " + e.getMessage());
        
           }
                          
    
    }
    
        /**
     * Se ejecuta una query que no tenga como resultado devovler Datos 
     * Recive como para metro una Query SQL
     * @param querysql
     * Retorna un 1 Si la Query fue ejecutada sin error o un 0 si la Query no se ejecuto bien
     * @return 
     */
    public int ejecutarQuery(String querysql)
    {
        
        Statement St;
        ResultSet Result;
        
        try{
            
            St = Conn.createStatement();
            //Result = St.executeQuery("INSERT INTO reloj(hora, minuto, segundos ) VALUES('1', '32', '23');  ");
            
            String sql = querysql;
            
             PreparedStatement Pstm = Conn.prepareStatement(sql);
            
             Pstm.execute();
             
           
            
            return 1;
            
        } 
        catch(Exception e)
        {
            
            System.err.println("Error Query : " + e.getMessage());
            
            return 0;
    
        }
          
    
    }
    
    
    public ResultSet ejecutarQueryResult(String querysql)
    {
        
        Statement St;
        ResultSet Result;
        
        try{
            
            St = Conn.createStatement();
            //Result = St.executeQuery("INSERT INTO reloj(hora, minuto, segundos ) VALUES('1', '32', '23');  ");
            
            String sql = querysql;
            
             PreparedStatement Pstm = Conn.prepareStatement(sql);
            
             ResultSet respuestaQuery = Pstm.executeQuery();
             
         
            
            return respuestaQuery;
            
        } 
        catch(Exception e)
        {
            
            System.err.println("Error Query : " + e.getMessage());
            
            return null;
    
        }
          
        
    }
    
}
