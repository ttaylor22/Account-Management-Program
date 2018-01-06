/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountManagment;


/**
 *
 * @author jearly
 */
public class MailingAddress extends Address{
    private String unit;
    
    public MailingAddress(String s, int h, String z, String t) {
        super(s,h,z,t);
    }
    void setUnit(String u){
            unit=u;
        }
  
    public String getUnit(){
        return unit;
    }
    
    public String getType(){
        return "mailing";
    }
    
}
