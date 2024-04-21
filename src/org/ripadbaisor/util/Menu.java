package org.ripadbaisor.util;

import org.ripadbaisor.elements.Manager;
import org.ripadbaisor.elements.Restaurant;

import javax.swing.JOptionPane;

public class Menu {
    
    public static String showMenu() throws IllegalArgumentException {

        
        String option = JOptionPane.showInputDialog(null,
                                        "1. Añadir restaurante.\n2. Editar restaurante.\n" +
                                        "3. Mostrar restaurantes.\n4. Eliminar restaurante.\nQ. Salir del programa.",
                                        "Menú de opciones",
                                        JOptionPane.PLAIN_MESSAGE);

        if (option == null || option.isEmpty()) {
            throw new IllegalArgumentException("Debe elegir alguna de las opciones\ndel menú proporcionado.");
        }

        return option;                                   
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
        
        try {
            String id = InputProcessor.requestId("Número de identificación:", "Editar restaurante");
            Restaurant restaurant = manager.getRestaurant(id);

            if (restaurant == null) {
                throw new IllegalArgumentException("No se ha encontrado un restaurante\ncon código " + id + ".");
            }

            boolean keepEditing = true;

            while (keepEditing) {
                String option = showEditionMenu(restaurant);
                keepEditing = edit(option, restaurant);
            }
        } catch (IllegalArgumentException iae) {
            JOptionPane.showMessageDialog(null, iae.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static String showEditionMenu(Restaurant restaurant) {

        return JOptionPane.showInputDialog(null,
                                           "1. Nombre.\n2. Localización.\n" +
                                           "3. Horario.\n4. Puntuación.\nQ. Confirmar cambios y volver.",
                                           "Menú de edición - " + restaurant.getName(),
                                           JOptionPane.PLAIN_MESSAGE);
    }

    private static boolean edit(String option, Restaurant restaurant) throws IllegalArgumentException {

        switch (option.trim().toUpperCase()) {
            case "1":
                changeName(restaurant);
                return true;
            case "2":
                changeLocation(restaurant);
                return true;
            case "3":
                changeHours(restaurant);
                return true;
            case "4":
                changeRating(restaurant);
                return true;
            case "Q": // Salir del menú de edición
                JOptionPane.showMessageDialog(null, "Cambios guardados.", "Mensaje de confirmación", JOptionPane.INFORMATION_MESSAGE);
                return false;
            default: // Opción no válida
                throw new IllegalArgumentException("Debe introducir una opción válida.");
        }
    }

    private static void changeName(Restaurant restaurant) {
        String newName = InputProcessor.requestText("Nombre actual: " + restaurant.getName() + "\nNuevo nombre:",
                                                    "Editando Restaurante " + restaurant.getName());
        restaurant.setName(newName);                                                     
    }

    private static void changeLocation(Restaurant restaurant) {
        String newLocation = InputProcessor.requestText("Localización actual: " + restaurant.getLocation() + "\nNueva localización:",
                                                        "Editando Restaurante " + restaurant.getName());
        restaurant.setLocation(newLocation);                                                     
    }

    private static void changeHours(Restaurant restaurant) {
        String newHours = InputProcessor.requestText("Horario actual: " + restaurant.getHours() + "\nNuevo horario:",
                                                     "Editando Restaurante " + restaurant.getName());
        restaurant.setHours(newHours);                                                     
    }

    private static void changeRating(Restaurant restaurant) {
        double newRating = InputProcessor.requestRating("Puntuación actual: " + restaurant.getRating() + "\nNueva puntuación:",
                                                        "Editando Restaurante " + restaurant.getName());
        restaurant.setRating(newRating);                                                     
    }
    
    private static void showRestaurants(Manager manager) {
        
        try {
            JOptionPane.showMessageDialog(null, manager.getRanking(), "Restaurantes", JOptionPane.PLAIN_MESSAGE);
        } catch (IllegalArgumentException iae) {
            JOptionPane.showMessageDialog(null, iae.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void removeRestaurant(Manager manager) {
        
        try {
            if (manager.isEmpty()) {
                throw new IllegalArgumentException("La base de datos se encuentra vacía.");
            }

            String id = InputProcessor.requestId("Número de identificación:", "Eliminar restaurante");
            
            if (!manager.removeRestaurant(id)) {
                throw new IllegalArgumentException("No se ha encontrado un restaurante\ncon código " + id + ".");
            }

            JOptionPane.showMessageDialog(null, "Restaurante eliminado.", "Mensaje de confirmación", JOptionPane.INFORMATION_MESSAGE);
        } catch (IllegalArgumentException iae) {
            JOptionPane.showMessageDialog(null, iae.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
