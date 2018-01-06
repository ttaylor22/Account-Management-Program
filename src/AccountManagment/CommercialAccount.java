/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountManagment;


/**
 *
 * @author jearly
 */
public class CommercialAccount extends Account implements Constants{
     // - A constructor to initialize the account number and customer. For now, initialize the balance to zero.
    public CommercialAccount(String a, Customer c) {
        super(a, c);
    }

    @Override
    public void updateBalance() {
        double sum = 0;
        for (Address addr : getAddresses()) {
            for (Meter m: addr.getMeters()) {
                for (MeterReading mr : m.getReadings()) {
                    sum = sum + mr.getReading();
                }
            }
        }
        this.setBalance(sum * commercialUnitRate);
    }
}
