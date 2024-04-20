# RestaurantRanking Classes Description and Documentation

## Data Type Classes

1. **Restaurant Class**

The Restaurant class represents a restaurant entity with attributes such as name, location, hours of operation, and rating. It provides functionalities for managing restaurant details, generating unique identifiers, and comparing restaurants based on their ratings by implementing the java.lang.Comparable<> interface.

2. **Manager Class**

The Manager class serves as a tool for managing a collection of Restaurant objects stored in an ArrayList of said type. It provides functionalities for adding, removing, and retrieving restaurants from the collection, as well as generating a ranked list based on restaurant ratings.

## Utility Classes

1. **Menu Class**

The Menu class represents a simple menu system for managing restaurant information by allowing users to perform various actions such as adding, editing, displaying, and removing restaurants from a database.

2. **InputProcessor Class**

The InputProcessor class provides methods for validating and processing user inputs using the javax.swing.JOptionPane class to incorporate a graphical user interface. It offers functionalities for requesting texts, ratings, and identifiers, ensuring that the inputs meet specific criteria for the corresponding fields that need to be filled throughout the execution of the program.

## Executable Class

1. **Main Class**

The Main class serves as the entry point of this application, orchestrating the interaction between the user, the menu system, and the restaurant management functionalities. It instantiates a Manager object to manage the collection of restaurants and creates a loop to continuously display a menu, handle user input, and perform corresponding actions based on the selected menu option at every moment.

[<- Go back](/README.md)
