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

    public boolean removeRestaurant(String id) {

        Restaurant restaurant = this.getRestaurant(id);

        return this.restaurants.remove(restaurant);
    }

    private Restaurant getRestaurant(String id) {

        for (Restaurant restaurant : this.restaurants) {
            if (restaurant.getId().equals(id)) {
                return restaurant;
            }
        }

        return null;
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
