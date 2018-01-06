/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountManagment;


import java.time.LocalDateTime;

/**
 *
 * @author jearly
 */
public class MeterReading {
 
// MeterReading - This class represents a value collected 
//   from a specific meter. 
    private double reading;
    private LocalDateTime date;
    private String flag;
    private Meter meter;
    
//    The following methods should be available:
//getReading() - Returns a floating point number indicating the total energy units consumed
    public double getReading(){
        return reading;
    }
    
//getDate() - Returns a Date reference indicating the date/time when the reading was taken
//https://docs.oracle.com/javase/tutorial/datetime/iso/index.html

    public LocalDateTime getDateTime(){
        return date;
    }
//getFlag() - Returns a String indicating if the reading was taken in response 
//    to an external request, or in response to a timing event (polling vs. push).
    public String getFlag() {
        return flag;
    }
//getMeter() - Return the reference to the Meter to which the reading belongs
    public Meter getMeter(){
        return meter;
    }
//A constructor to initialize all the required instance variables in the object
    public MeterReading(double r, LocalDateTime d, String f, Meter m) {
        reading = r;
        date = d;
        flag = f;
        meter = m;
    }

    
}
