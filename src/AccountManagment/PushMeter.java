/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountManagment;


/**
 *
 * @author jearly
 */
public class PushMeter extends Meter {

    private int interval;

    // - A constructor to initialize ID, brand, and type.
    public PushMeter(String i, String b, String t) {
        super(i, b, t);
    }

    public String getType() {
        return "push";
    }

    //Declare a new method in the PushMeter class called setInterval(int s). 
    // This method sets the interval (in seconds) at which the meter sends out its reading.
    public void setInterval(int s) {
        interval = s;
    }

    //Declare a new method called getInterval() that returns the current interval.
    public int getInterval() {
        return interval;
    }
}
