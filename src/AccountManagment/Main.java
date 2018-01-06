/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountManagment;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 *
 * @author Tevin
 */
public class Main extends MyHandler {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        String account = "";
        String name = "";
        int n = 0;
        File c;
        Scanner in = new Scanner(System.in);
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyHandler handler = new MyHandler();
            System.out.println("Welcome to the Energy Management System");
            while (true) {
                System.out.println("Enter a command: (load <file directory>) (clear) (quit) (show customer <last name>) (show account <account number>) (show address <address number>)");
                String cmd = in.nextLine();
                String space[] = cmd.split(" ");

                if (space[0].equalsIgnoreCase("load") && space.length == 2) {
                    c = new File(space[1]);
                    
                    if (c.exists()) {
                        saxParser.parse(c, handler);
                        System.out.println("Load successful: " + c);
                    } else {
                        System.out.println("Invalid input file - " + c);
                    }
                } else if (space[0].equalsIgnoreCase("clear")) {
                    handler.getCustList().clear();
                } else if (space[0].equalsIgnoreCase("quit")) {
                    System.out.println("Program ending");
                    break;
                } else if (space[0].equalsIgnoreCase("show") && space.length == 3) {
                    if (space[1].equalsIgnoreCase("customer")) {
                        name = space[2];
                    } else if (space[1].equalsIgnoreCase("account")) {
                        account = space[2];

                    } else if (space[1].equalsIgnoreCase("address")) {
                        n = Integer.parseInt(space[2]);
                        // s = cmd.substring(16);
                    } /*
                     else if (space[1].equalsIgnoreCase("meter")) {
                     // id = space[2];
                       
                     }
                     */ else {
                        System.out.println("Invalid command: " + cmd);
                    }

                } else {
                    System.out.println("Invalid command: " + cmd);
                }
                //Get Customer list
                List<Customer> customerList = handler.getCustList();
                //print customer information
                search:
                {
                    for (Customer customer : customerList) {

                        //System.out.println("TEST:" + customer.getLastName());
                        for (Account acct : customer.getAccounts()) {

                            //System.out.println("TEST: " + acct.getAccountNumber() + ":" + df.format(acct.getCurrentBalance()));
                            for (Address address : acct.getAddresses()) {
                                for (Meter meter : address.getMeters()) {
                                    for (MeterReading meterReading : meter.getReadings()) {
                                        if (space[0].equalsIgnoreCase("show")) {
                                            if (name.equalsIgnoreCase(customer.getLastName()) && space[2].equalsIgnoreCase(acct.getAccountNumber())) {
                                                System.out.println("Account number: " + acct.getAccountNumber());
                                                System.out.println("Balance: $" + df.format(acct.getCurrentBalance()));
                                                System.out.println("Addresses:");
                                                int o = acct.getAddresses().length;
                                                for (int i = 0; i < o; i++) {
                                                    acct.getAddresses()[i].getNumber();
                                                    System.out.println(" " + acct.getAddresses()[i].getNumber() + " " + acct.getAddresses()[i].getStreet());
                                                }
                                                break search;
                                            } else if (account.equalsIgnoreCase(acct.getAccountNumber()) && n == address.getNumber() && cmd.substring(16).equalsIgnoreCase(address.getStreet())) {
                                                System.out.println("Number: " + address.getNumber());
                                                System.out.println("Street: " + address.getStreet());
                                                System.out.println("Zip: " + address.getZipCode());
                                                System.out.println("Type: " + address.getType());
                                                if (address.getType().equalsIgnoreCase("apartment")) {
                                                    System.out.println("Unit: " + address.getUnit());
                                                }
                                                System.out.println("Meters:");
                                                int o = address.getMeters().length;
                                                for (int i = 0; i < o; i++) {
                                                    System.out.println(" " + address.getMeters()[i].getID());
                                                }
                                                break search;
                                            } else if (account.equalsIgnoreCase(acct.getAccountNumber()) && space[2].equalsIgnoreCase(meter.getID())) {
                                                System.out.println("ID: " + meter.getID());
                                                System.out.println("Brand: " + meter.getBrand());
                                                System.out.println("Location: " + meter.getLocation());
                                                System.out.println("Type: " + meter.getType());
                                                System.out.println("Meters Readings:");
                                                int o = meter.getReadings().length;
                                                for (int i = 0; i < o; i++) {
                                                    System.out.println(" " + meter.getReadings()[i].getDateTime());
                                                }
                                                break search;
                                            } else if (space[2].equalsIgnoreCase(customer.getLastName())) {
                                                System.out.println("Last name: " + customer.getLastName());
                                                System.out.println("First name: " + customer.getFirstName());
                                                System.out.println("Accounts:");
                                                int o = customer.getAccounts().length;
                                                for (int i = 0; i < o; i++) {
                                                    System.out.println(" " + customer.getAccounts()[i].getAccountNumber());
                                                }
                                                break search;
                                            } else {
                                                System.out.println("No records found");
                                                break search;
                                            }
                                        }
                                    }

                                }
                            }
                        }
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
