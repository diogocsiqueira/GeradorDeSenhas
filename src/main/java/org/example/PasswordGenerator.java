package org.example;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Random;

public class PasswordGenerator {
    public String generatePassword(int length, boolean includeUpper, boolean includeLower, boolean includeNumbers, boolean includeSpecial) {
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specials = "!@#$%^&*()-_=+[]{}|;:',.<>?/";

        String allowedChars = "";
        if (includeUpper) {allowedChars += upperCase;}
        if (includeLower) {allowedChars += lowerCase;}
        if (includeSpecial) {allowedChars += specials;}
        if (includeNumbers) {allowedChars += numbers;}

        if (!includeLower && !includeUpper && !includeSpecial && !includeNumbers) {
            return "Marque ao menos uma caixinha";
        }else {

            Random random = new Random();
            StringBuilder password = new StringBuilder();

            for (int i = 0; i < length; i++) {
                password.append(allowedChars.charAt(random.nextInt(allowedChars.length())));
            }
            return password.toString();
        }
    }

    public void copyPasswordToClipboard(String password) {
        StringSelection stringSelection = new StringSelection(password);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
}
