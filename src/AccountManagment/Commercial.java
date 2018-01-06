/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountManagment;


/**
 *
 * @author jearly
 */
public class Commercial extends Address {

    public Commercial(String s, int h, String z, String t) {
        super(s, h, z, t);
    }

    public String getType() {
        return "commercial";
    }
    @Override
    public String getUnit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
