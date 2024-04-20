package org.ripadbaisor.util;

import org.ripadbaisor.elements.Manager;
import org.ripadbaisor.elements.Restaurant;

import javax.swing.JOptionPane;

public class Menu {
    
    public static String showMenu() {

        return JOptionPane.showInputDialog(null,
                                           "1. Añadir restaurante.\n2. Editar restaurante.\n" +
                                           "3. Mostrar restaurantes.\n4. Eliminar restaurante.\nQ. Salir del programa.",
                                           "Menú de opciones",
                                           JOptionPane.PLAIN_MESSAGE);
    }

    public static void performAction(String option, Manager manager) {
        switch (option.trim().toUpperCase()) {
            case "1":
                addRestaurant(manager);
                break;
            case "2":
                alterRestaurant(manager);
                break;
            case "3":
                showRestaurants(manager);
                break;
            case "4":
                removeRestaurant(manager);
                break;
            case "Q": // Salir del programa
                System.exit(0);
                break;
            default: // Opción no válida
                throw new IllegalArgumentException("Debe introducir una opción válida.");
        }
    }

    private static void addRestaurant(Manager manager) {
        
        String name = InputProcessor.requestText("Nombre:", "Nuevo restaurante");
        String location = InputProcessor.requestText("Localización:", name);
        String hours = InputProcessor.requestText("Horario:", name);
        double rating = InputProcessor.requestRating("Puntuación:", name);

        Restaurant newRestaurant = new Restaurant(name, location, hours, rating);
        manager.addRestaurant(newRestaurant);
    }
    
    private static void alterRestaurant(Manager manager) {
        
        
    }
    
    private static void showRestaurants(Manager manager) {
        
        JOptionPane.showMessageDialog(null, manager.getRanking(), "Restaurantes", JOptionPane.PLAIN_MESSAGE);
    }

    private static void removeRestaurant(Manager manager) {
        
        String id = InputProcessor.requestId("Número de identificación:", "Eliminar restaurante");
        
        manager.removeRestaurant(id);
    }
}
