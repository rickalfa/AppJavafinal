/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Models.ModelUsuario;
import Models.ModelConnbd;
/**
 *
 * @author rb__s
 */
public class ControllerUsuario {
    
    private ModelConnbd Conn = new ModelConnbd();
    private ModelUsuario User;
    
    public ControllerUsuario()
    {
    
      User = new ModelUsuario();
        
    
    } 
    
    public int CreateUsuario(String _nombre, String _email, String _phone, String _direccion)
    {
        String query_sql = "";
        
        try{
            
            query_sql = "insert into usuario( `nombre`, `email`, `phone`, `direccion`) values ('"+ _nombre +"' ,'"+ _email +"', '"+ _phone +"', '"+ _direccion + "') ";
            
            System.out.print(query_sql);
            
            int resulqy = Conn.ejecutarQuery(query_sql);
              
            String emailuser = String.valueOf(resulqy);
            
            System.out.print("valor de retorno del metodo createUsuario : "+emailuser + " \n");
            
            
            
            return 1;
            
        }
        catch(Exception e)
        {
            
            System.out.print(e);
            
            return 0;
            
        }
        
        
    }
    
    
    public String[] getUsuario(int index)
    {
        
        String indexstr = String.valueOf(index);
        String name = "";
        
        String querysql = "select * from usuario where id_usuario='"+ indexstr+"'";
        

        try{
            
          ResultSet resultQuery = Conn.ejecutarQueryResult(querysql);
        
          //String nombreuser = resultQuery.getString("nombre");
        
            while(resultQuery.next())
            {
                
               name =  resultQuery.getString("nombre");
        
            }
          
        
         // System.out.print("\n nombre del usuario: ");
        
            
         /// resultQuery.getArray(index);
        
         
        }catch(Exception e)
        {
            System.out.print(e);
            
            return null;
        }
        
        String[] dateuser = {name};
        
        return dateuser;
        
    }
    
    
    
    
    
    
    
}
