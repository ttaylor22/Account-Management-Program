/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountManagment;


import java.util.ArrayList;

/**
 *
 * @author jearly
 */
public class House extends Address {

    public House(String s, int h, String z, String t) {
        super(s, h, z, t);
    }

    public String getType() {
        return "house";
    }
    @Override
    public String getUnit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
