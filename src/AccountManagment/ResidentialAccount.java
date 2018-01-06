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
public class ResidentialAccount extends Account implements Constants{

    // - A constructor to initialize the account number and customer. For now, initialize the balance to zero.
    public ResidentialAccount(String a, Customer c) {
        super(a, c);
    }

    @Override
    public void updateBalance() {
        double sum = 0;
        //System.out.println("DEBUG:" + this.getAccountNumber());
        for (Address addr : this.getAddresses()) {
            //System.out.println("DEBUG:" + addr.getStreet());
            for (Meter m: addr.getMeters()) {
                //System.out.println("DEBUG: "+ m.getLocation());
                for (MeterReading mr : m.getReadings()) {
                    sum = sum + mr.getReading();
                    //System.out.println("UPDATE:" + sum);
                }
            }
        }
        this.setBalance(sum * residentialUnitRate);
    }
}
