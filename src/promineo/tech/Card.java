package promineo.tech;

/**
 * The Card class represents a playing card with a specific value and name.
 * It includes methods for retrieving and modifying the card's properties
 * as well as a method to describe the card's details.
 * @author Ari Hayhurst
 */
public class Card {
//    required project variables
    private int value;
    private String name;

    /**
     * Constructs a Card object with the specified value and name.
     *
     * @param value the numerical value of the card
     * @param name the name or rank of the card
     */
    public Card(int value, String name) {
//        instantiate a card to use with assigned variables
        this.value = value;
        this.name = name;
    }

//    getters

    /**
     * Retrieves the numerical value of the card.
     *
     * @return the value of the card as an integer
     */
    public int getValue() {return value;} // get the value of a card

    /**
     * Retrieves the suit and rank of the card.
     *
     * @return the suit and rank of the card as a String
     */
    public String getName() {return name;} // get the name of a card

//    setters

    /**
     * Sets the numerical value of the card.
     *
     * @param value the value to assign to the card
     */
    public void setValue(int value) {this.value = value;} // set the value of a card

    /**
     * Sets the suit and rank of the card.
     *
     * @param name the suit and rank to assign to the card
     */
    public void setName(String name) {this.name = name;} // set the name of a card

    /**
     * Prints the details of the card to the standard output.
     * Displays the name (suit and rank) of the card followed by its value.
     */
    public void describe() {
//        print out name
        System.out.println(name);
//        print out an easily comparable value
        System.out.println("\tValue: " + value);
    }
}
