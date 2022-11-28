/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package appfinal;

import Models.ModelConnbd;
import Controllers.ControllerProveedor;
import Views.jFrameToplSubmenu;

/**
 *
 * @author rb__s
 */
public class AppFinal {

    static ControllerProveedor ConProv;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConProv = new ControllerProveedor();
        
        ModelConnbd Conn = new ModelConnbd();
        
        String nombre_prov = ConProv.getDates();
        System.out.print(nombre_prov + "\n");
        
       new jFrameToplSubmenu().setVisible(true);
        
    }
    
}
