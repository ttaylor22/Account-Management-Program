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
public abstract class Address {
// Address - This class represents a building in a municipality.
    //Variables
    private String street;
    private int houseNumber;
    private String zipCode;
    private String type;
    private ArrayList<Meter> meters;
    private Account account;
    
    
//It should have the following methods:
// - getStreet() - Return a String for the street name
    public String getStreet(){
        return street;
    }
// - getNumber() - Return an integer building or house number
    public int getNumber(){
        return houseNumber;
    }
// - getZipCode() - Returns a String with the zip code (both formats)
    public String getZipCode(){
        return zipCode;
    }
    public abstract String getUnit();
    
// - getType() - Returns a String indicating the building type (house, apartment, commercial, etc.)
    public abstract String getType();
    
// - getMeters() - Returns an array of Meter objects installed at this address
    public Meter[] getMeters(){
        Meter [] metersArray = new Meter[meters.size()];
        metersArray = meters.toArray(metersArray);
        return metersArray;
    }
    
// - addMeter(Meter m) - Adds a Meter reference to the list of installed meters. 
//    Returns a boolean to indicate success or failure.
    public boolean addMeter(Meter m){
        meters.add(m);
        return true;
    }
    
// - removeMeter(String id) - Removes the reference to the Meter with the named id. 
//    Returns a boolean to indicate success or failure.
    public boolean removeMeter(String id){
        boolean returnVal = false;
        // Look for Meter with the named id        
        for (int i = 0; i < meters.size(); i++) {
            Meter m = meters.get(i);        
            if (id.equals(m.getID())) {
                // Match found -- remove meter
                meters.remove(i);
                returnVal = true;
                break;
            }
        }
        return returnVal;
    }
    
// - getAccount() - Returns a reference to the Account
    public Account getAccount(){
        return account;
    }
    
// - setAccount(Account a) - Sets the Account associated with this address
    public void setAccount(Account a){
        account = a;
    }
// - A constructor to initialize the required instance variables in the object (except Meters and Account)
    public Address(String s, int h, String z, String t){
        street = s;
        houseNumber = h;
        zipCode = z;
        type = t;
        account = null;
        meters = new ArrayList<Meter>();
                
    }
    

}
