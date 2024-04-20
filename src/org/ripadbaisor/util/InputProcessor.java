package org.ripadbaisor.util;

import javax.swing.JOptionPane;
import java.util.regex.Pattern;;

public class InputProcessor {

    public static String requestText(String message, String title) {
        
        while (true) {
            String text = JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);

            try {
                return validateText(text);
            } catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(null, iae.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static String validateText(String text) {

        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Por favor, introduzca los datos solicitados.");
        }

        return text;
    }
    
    public static double requestRating(String message, String title) {

        while (true) {
            String ratingString = JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);

            try {
                return validateRating(ratingString);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static double validateRating(String ratingString) {

        try {
            if (ratingString == null || ratingString.isEmpty()) {
                throw new IllegalArgumentException("Por favor, introduzca los datos solicitados.");
            }

            double rating = Double.parseDouble(ratingString);

            if (rating < 0 || rating > 5) {
                throw new IllegalArgumentException("La puntuación debe ser un número entre el 0 y el 5.");
            }

            return rating;
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException("Se espera un número entre el 0 y el 5.");
        }
    }

    public static String requestId(String message, String title) {

        while (true) {
            String id = JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);

            try {
                return validateId(id);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static String validateId(String id) {

        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Por favor, introduzca los datos solicitados.");
        }

        String idRegex = "\\d{5}";

        if (!Pattern.matches(idRegex, id)) {
            throw new IllegalArgumentException("Formato no válido: Introduzca un código de 5 dígitos.");
        }

        return id;
    }
}
