/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

/**
 *
 * @author rb__s
 */
public abstract class CrudControllerAbs {
    
    public abstract String[][] get(int index);
    public abstract String[][] get();
    public abstract int update(int index, String[][] datesuser);
    public abstract int insert(String[][] datesuser);
    public abstract int delete(int index);
    
    
    
}
