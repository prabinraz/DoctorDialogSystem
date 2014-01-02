/*
 * Main.java
 *
 * Created on November 19, 2006, 12:17 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package doctordialogsystem;

/**
 *
 * @author root
 *
 */
import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.util.*;
//import jpl.*;
//import jpl.Query;
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DialogFrame myFrame=new DialogFrame("Dialog Based Expert System for Vaccines And Immunization information");
        myFrame.setLocation(0,0);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
