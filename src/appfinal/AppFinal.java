/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package appfinal;

import Models.ModelConnbd;
import Controllers.ControllerProveedor;
import Controllers.ControllerUsuario;
import Views.jFrameToplSubmenu;

import java.util.Arrays;

/**
 *
 * @author rb__s
 */
public class AppFinal {

    static ControllerUsuario ConProv;
    static String[][] datesuser;
    
    public static void imprimirArrayGet(String[][] datesTable)
    {
        String contenido_array = "";
        int quantity_row = datesTable.length;
        
        for(int i = 0; i < quantity_row; i++){
        
            contenido_array = Arrays.toString(datesTable[i]);
            System.out.println(contenido_array);
        }
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConProv = new ControllerUsuario();
        
       
        
        String[] upDatesUser = {"sara", "sara@email.ur", "calle tres "};
        String[] inDatesUser = {"raul", "gato@gatos.com", "8723812 ", "nueva calle", "14444428"};
        
   
        
        try{
            String[][] datesProvs = ConProv.get();
            int lengArray = datesProvs[0].length;
            int i = 0;
               
            imprimirArrayGet(datesProvs);
            
             String dateProv = Arrays.toString(datesProvs[0]);
             System.out.println("\n dates proveedor : " +dateProv);
       
            
            ConProv.update(2, upDatesUser);
            
            //ConProv.insert(inDatesUser);
            
            //ConProv.delete(6);
            
            
        }catch(Exception e){
        
              System.out.println("\n Error en la peticion");
        
        }
 
        
       
        
       new jFrameToplSubmenu().setVisible(true);
        
    }
    
}
