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


    private String tablename;
    private String dates;
    private ModelConnbd Conn;
    private String column_idname = "id_proveedor";
    private String[] columns= {"id_proveedor","nombre", "email", "direccion", "password"}; ;
    private String newquery_sql = "";
    
    public ControllerProveedor()
    {
        
        
       Conn = new ModelConnbd();
       tablename = "proveedor";
       
        
    }
    
       /**
     * @return the dates
     */
    public String getDates() 
    {
        
        String query = "Select * from "+ tablename +"";
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
    
    String query = "Select * from "+ tablename +" where "+column_idname+"='"+index+"'";
    
    int count_columns = this.columns.length;
    
    String[][] datesuser = new String[1][count_columns]; 
    int i = 0;
    int count = 0;
            
        try{
            
            
             ResultSet resulqy = Conn.ejecutarQueryResult(query);
        
             String RowQuery = String.valueOf(resulqy.getRow());
             
             System.out.print(" \n row de la query : " + RowQuery);
            while(resulqy.next())
            {
                
               //datesuser[i][0] =  resulqy.getString("nombre");
               //datesuser[i][1] =  resulqy.getString("email");
               //datesuser[i][2] =  resulqy.getString("direccion");
        
               for(count = 0; count < count_columns; count++){
               
                      datesuser[i][count] =  resulqy.getString(this.columns[count]);
               
               }
               
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
        
        String query = "Select * from "+ tablename +"";
        
        int count_columns = this.columns.length;
        
        String name = "";
        int count = 0;
        String[][] datesuser = new String[20][5];
       
        int i = 0;
        
        try{
            
            
            ResultSet resulqy = Conn.ejecutarQueryResult(query);
        
             String RowQuery = String.valueOf(resulqy.getRow());
             
             System.out.print(" \n row de la query : " + RowQuery);
         
            
            while(resulqy.next())
            {
                
              // datesuser[i][0] =  resulqy.getString("nombre");
              // datesuser[i][1] =  resulqy.getString("email");
               //datesuser[i][2] =  resulqy.getString("direccion");
        
                for(count = 0; count < count_columns; count++){
               
                     datesuser[i][count] =  resulqy.getString(this.columns[count]);
               
                }
                
               i++;
               
            }
             System.out.print(" \n valor de i : \n");
            System.out.print(i );
            
            String[][] datesResult= new String[i][count_columns];
            
             int count02 = 0;
            
             for(count = 0; count < i; count++){
                 
                 //datesResult[count][0] = datesuser[count][0];
                 //datesResult[count][1] = datesuser[count][1];
                 // datesResult[count][2] = datesuser[count][2];
                 
                 for(count02 = 0; count02 < count_columns; count02++){
                  datesResult[count][count02] = datesuser[count][count02];
                     
                 }
                 
            
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
    public int update(int index, String[] datesuser) {

        int count02 = 0;
        String create_query = "";
        int length_array_dates = datesuser.length;
        String[] datesUser = datesuser;
        
         String indexstr = String.valueOf(index);
         
                   /**
           * Creacion de la query parte de los datos SET en query UPDATE
           */
          for(count02 = 0; count02 < length_array_dates; count02++)
          {
              
              if(count02 == (length_array_dates - 1))
              {
                  create_query += this.columns[count02]+"='"+datesUser[count02]+"'";
              }else{
                  create_query += this.columns[count02]+"='"+datesUser[count02]+"', ";
              }
              
          }
          
          create_query = "update "+ tablename +" set "+ create_query+" where "+this.column_idname+"='"+indexstr+"' ";
          
          System.out.print(" nueva query update : "+create_query);
        
         //String query = "update "+ tablename +" set nombre='"+ datesuser[0]+"', email='"+ datesuser[1]+"', direccion='"+ datesuser[2]+"' where id_proveedor='"+indexstr+"' ";
         String name = "";
         
         try{
             
           int resulqy = Conn.ejecutarQuery(create_query);
           
           return 1;
           
         }catch(Exception e)
         {
             
             return 0;
         }
         
    }

    @Override
    public int insert(String[] datesuser) {
   
          String query_sql = "";
        
          String create_query = "";
          
         
          createquery(this.columns,datesuser);
           
           //System.out.print("\n query creada de columnas : "+ query_sql + "\n");
           //System.out.print("\n query creada de dates : "+ create_query + "\n");
           //System.out.println(length_array_dates);
          
           
            System.out.print("\n nueva query generada : "+newquery_sql + "\n");
          
        try{
            
            System.out.print(query_sql);
            
            int resulqy = Conn.ejecutarQuery(newquery_sql);
              
            String emailuser = String.valueOf(resulqy);
            
            System.out.print(" \n valor de retorno del metodo insert : "+emailuser + " \n");
           
            
            return 1;
            
        }
        catch(Exception e)
        {
            
            System.out.print(e);
            
            return 0;
            
        }
        
    }

    @Override
    public int delete(int index) {
   
          String indexstr = String.valueOf(index);
        
        String querysql = "delete from "+ tablename +" where "+column_idname+"='"+indexstr+"' ";
        
        
        try{
        
            Conn.ejecutarQuery(querysql);
            
            
            return 1;
        
        }catch(Exception e){
        
            
            System.out.println(e);
            
            return 0;
        
        }
    
    }

    @Override
    public void createquery(String[] columns, String[] datesUser) {
  
          String query_sql = "";
        
          String create_query = "";
          
         int length_array = columns.length;
          int length_array_dates = datesUser.length;
          int count = 0;
          int count02 = 0; 
          
          /**
           *Creacion de la query parte de los nombres de las columnas 
           *
           */
          for(count = 0; count < length_array; count++)
          {
              
              if(count == (length_array - 1))
              {
                  query_sql += "`"+columns[count]+"`";
              }else{
                  query_sql += "`"+columns[count]+"`, ";
              }
              
          }
          
          query_sql = "("+ query_sql+")";
          
          
          /**
           * Creacion de la query parte de los datos SET en query UPDATE
           */
          for(count02 = 0; count02 < length_array_dates; count02++)
          {
              
              if(count02 == (length_array_dates - 1))
              {
                  create_query += "'"+datesUser[count02]+"'";
              }else{
                  create_query += "'"+datesUser[count02]+"', ";
              }
              
          }
          
          create_query = "("+ create_query+")";
          
           this.newquery_sql = "insert into "+ tablename +query_sql +" values "+ create_query;
    
    }
    
    
}
