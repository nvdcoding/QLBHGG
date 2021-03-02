/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class Helper {
    
    public void sendMessage(String s) {
        JOptionPane.showMessageDialog(null, s);
    }
    
    public String getNextCode(String key, int number) {
        
        String s = key;
        String numberString = number + "";
        for(int i = 0; i < ((10-key.length()) - numberString.length()); i++) {
            s += "0";
        }
        s += numberString;
        return s;
    }
    
    public boolean validateMail(String email) {
        return Pattern.matches("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$", email) && !email.equals("");
    }
    
    public boolean isFloatNumber(String n) {
        try {
            float m = Float.parseFloat(n);
        } catch (NumberFormatException e) {
            // str is not a number
            return false;
        }
        return true;
    }
    public boolean isIntNumber(String n) {
        try {
            int m = Integer.parseInt(n);
        } catch (NumberFormatException e) {
            // str is not a number
            return false;
        }
        return true;
    }
}
