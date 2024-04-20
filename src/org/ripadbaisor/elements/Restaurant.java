package org.ripadbaisor.elements;

import java.util.Random;

public class Restaurant implements Comparable<Restaurant> {
    
    private String id;
    private String name;
    private String location;
    private String hours;
    private double rating;

    public Restaurant(String name, String location, String hours, double rating) {

        this.id = generateId();
        this.name = name;
        this.hours = hours;
        this.location = location;
        this.rating = rating;
    }

    private String generateId() {
    
        Random random = new Random();
        String id = "";

        for (int i = 0; i < 5; i++) {
            id += random.nextInt(0, 10);
        }

        return id;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(header(this.name, '_'))
                     .append("\nNº de identificación: ").append(this.id)
                     .append("\nLocalización: ").append(this.location)
                     .append("\nHorario: ").append(this.hours)
                     .append("\nPuntuación: ").append(this.rating)
                     .append("\n");

        return stringBuilder.toString();
    }

    private static StringBuilder header(String title, char c) {

        StringBuilder header = new StringBuilder();

        int titleLength = title.length();
        int sidesLength = (45 - titleLength) / 2;

        header.append(repeatChar(c, 45)).append("\n")
              .append(repeatChar(c, sidesLength - 1)).append("  ")
              .append(title)
              .append("  ").append(repeatChar(c, sidesLength - 1));

        if ((45 - titleLength - 8) % 2 == 1) {
            header.append(c);
        }

        return header;
    }

    private static String repeatChar(char c, int n) {

        return String.valueOf(c).repeat(Math.max(0, n));    
    }

    @Override
    public int compareTo(Restaurant otherRestaurant) {

        if (this.rating > otherRestaurant.rating) {
            return -1;
        }

        if (this.rating < otherRestaurant.rating) {
            return 1;
        }

        return 0;
    }
}
