package promineo.tech;

// imports from Java
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a player in a card game, maintaining their name, hand of cards, and score.
 * This class provides functionality for describing the player's status, drawing cards
 * into their hand, flipping a card, and incrementing their score.
 * @author Ari Hayhurst
 */
public class Player {
    private final List<Card> hand; // Note to self: 'final' keyword with a variable ensures that
                                    // the reference to the object stays the same. Not necessarily that the
                                    // contents of the object stay the same, as with Collection objects.
    private int score;
    private final String name;

    /**
     * Constructs a Player object with the specified name.
     * Initializes a player with a starting score of 0 and an empty hand.
     *
     * @param name the name of the player
     */
    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.hand = new ArrayList<>();
    }

    /**
     * Retrieves the name of the Player.
     *
     * @return the name of the Player as a String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the player.
     *
     * @param name the name to assign to the player
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Prints a description of the player and their hand to the standard output.
     * The description includes the player's name and score, followed by a visual separator
     * and details of each card in the player's hand. Each card's details are displayed
     * by calling the `describe` method of the `Card` objects in the hand.
     */
    public void describe() {
        System.out.println("Player: " + name +
                "\n\tScore: " + score);
        System.out.println("""
                --------------------------\
                
                CARDS IN HAND:\
                
                --------------------------""");
        System.out.println();
        for (Card card : hand) {
            card.describe();
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    /**
     * Removes and returns the first card from the player's hand.
     *
     * @return the first {@code Card} object in the player's hand
     */
    public Card flip() {
        // Remove first card from hand and return
        return hand.removeFirst();
    }

    /**
     * Draws a card from the specified deck and adds it to the player's hand.
     *
     * @param deck the deck from which the card is drawn
     */
    public void draw(Deck deck) {
       hand.add(deck.draw());
    }

    /**
     * Adds the specified card to the player's hand.
     *
     * @param card the card to be added to the hand
     */
    public void addToHand(Card card) {
        hand.add(card);
    }

    /**
     * Increases the player's score by 1.
     */
    public void incrementScore() {
        this.score++;
    }
}
