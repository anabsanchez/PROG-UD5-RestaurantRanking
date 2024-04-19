package org.ripadbaisor.elements;

import java.util.ArrayList;

public class Manager {

    private ArrayList<Restaurant> restaurants;

    public Manager() {

        this.restaurants = new ArrayList<>();
    }
    
    public void addRestaurant(Restaurant restaurant) {

        this.restaurants.add(restaurant);
    }

    public boolean removeRestaurant(Restaurant restaurant) {

        return this.restaurants.remove(restaurant);
    }
}
