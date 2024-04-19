package org.ripadbaisor.elements;

import java.util.ArrayList;
import java.util.Collections;

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

    public String getRanking() {

        Collections.sort(this.restaurants);
        StringBuilder ranking = new StringBuilder();

        for (Restaurant restaurant : this.restaurants) {
            ranking.append(restaurant); 
        }

        return ranking.toString();
    }
}
