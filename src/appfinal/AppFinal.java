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

    static ControllerProveedor ConProv;
    static String[] datesuser;
    
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
        ConProv = new ControllerProveedor();
        
        ModelConnbd Conn = new ModelConnbd();
        
        ControllerUsuario ConUser = new ControllerUsuario();
        
        ///ConUser.CreateUsuario("miguel", "introduci@email.com", "9834421", "pasaje gatemala");
        
        
        String[] upDatesUser = {"maria", "maria@email.es", "calle nueva luz"};
        String[] inDatesUser = {"raul", "gato@gatos.com", "nueva calle", "14444428"};
        
        
        datesuser = ConUser.getUsuario(1);
        
        System.out.print("nombre del usuario : " + datesuser[0]+ "\n");
        
        String nombre_prov = ConProv.getDates();
        System.out.print("\n nombre del Proveedor : "+ nombre_prov + "\n");
        
        try{
            String[][] datesProvs = ConProv.get();
            int lengArray = datesProvs[0].length;
            int i = 0;
               
            imprimirArrayGet(datesProvs);
            
             String dateProv = Arrays.toString(datesProvs[0]);
             System.out.println("\n dates proveedor : " +dateProv);
       
            
            //ConProv.update(4, upDatesUser);
            
            //ConProv.insert(inDatesUser);
            
            //ConProv.delete(6);
            
            
        }catch(Exception e){
        
              System.out.println("\n No existe el usuario");
        
        }
 
        
       
        
       new jFrameToplSubmenu().setVisible(true);
        
    }
    
}
