package org.ripadbaisor.elements;

public class Restaurant {
    
    private String name;
    private String location;
    private String hours;
    private double rating;

    public Restaurant(String name, String location, String hours, double rating) {

        this.name = name;
        this.hours = hours;
        this.location = location;
        this.rating = rating;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder("\n");

        stringBuilder.append(header(this.name, '_'))
                     .append("\nLocalización: ").append(this.location)
                     .append("\nHorario: ").append(this.hours)
                     .append("\nPuntuación: ").append(this.rating);

        return stringBuilder.toString();
    }

    private static StringBuilder header(String title, char c) {

        StringBuilder header = new StringBuilder();

        int titleLength = title.length();
        int sidesLength = (45 - titleLength) / 2;

        header.append(repeatChar(c, 45)).append("\n")
              .append(repeatChar(c, sidesLength - 2)).append("  ")
              .append(title)
              .append("  ").append(repeatChar(c, sidesLength - 2));

        if ((45 - titleLength - 8) % 2 == 1) {
            header.append(c);
        }

        return header;
    }

    private static String repeatChar(char c, int n) {

        return String.valueOf(c).repeat(Math.max(0, n));    
    }
}
