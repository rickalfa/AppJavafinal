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
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConProv = new ControllerProveedor();
        
        ModelConnbd Conn = new ModelConnbd();
        
        ControllerUsuario ConUser = new ControllerUsuario();
        
        ///ConUser.CreateUsuario("miguel", "introduci@email.com", "9834421", "pasaje gatemala");
        
        
        String[] upDatesUser = {"PIlar", "correo@email.es", "calle nueva luz"};
        String[] inDatesUser = {"estefania", "estefania@gmail.com", "calle marte", "8239128"};
        
        
        datesuser = ConUser.getUsuario(1);
        
        System.out.print("nombre del usuario : " + datesuser[0]+ "\n");
        
        String nombre_prov = ConProv.getDates();
        System.out.print("\n nombre del Proveedor : "+ nombre_prov + "\n");
        
        try{
            String[][] datesProvs = ConProv.get(1);
            int lengArray = datesProvs.length;
            int i = 0;
        
            for(i = 0; i < lengArray; i++){
            
            
             String dateProv = Arrays.toString(datesProvs[i]);
             System.out.println(dateProv);
           
            }
            
            ConProv.update(1, upDatesUser);
            
            ConProv.insert(inDatesUser);
            
            //ConProv.delete(2);
            
            
        }catch(Exception e){
        
              System.out.println("\n No existe el usuario");
        
        }
 
        
        
        
        
       new jFrameToplSubmenu().setVisible(true);
        
    }
    
}
