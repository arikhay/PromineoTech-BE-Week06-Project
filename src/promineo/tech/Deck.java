package promineo.tech;

// imports from Java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.lang.System.exit;

/**
 * The Deck class represents a collection of cards in a standard deck.
 * This class provides methods to initialize the deck, shuffle it, and draw cards.
 * @author Ari Hayhurst
 */
public class Deck {

    //    global variable for seeding the Random class
    private long seed = 325;

//    instantiate the deck of cards
    private final List<Card> cards;

    /**
     * Constructs a Deck object and initializes it with a standard set of 52 playing cards.
     * The deck consists of four suits: Clubs, Diamonds, Hearts, and Spades.
     * Each suit has 13 ranks: Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine,
     * Ten, Jack, Queen, and King, each associated with a numerical value starting from 2.
     *<p>
     * The cards are stored in an ArrayList, where each card is represented by a Card object.
     */
    public Deck() {
//        declare the ArrayList
        this.cards = new ArrayList<>();

        //    array of suits
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        for (String suit : suits) {
//            array of ranks
            String[] ranks = {"Two", "Three", "Four", "Five",
                    "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
            for (int j = 0; j < ranks.length; j++) {
                this.cards.add(new Card(j + 2, suit + " of " + ranks[j]));
            }
        }
    }

    /**
     * Shuffles the deck of cards using a deterministic approach.
     *<p>
     * This method increments the internal `seed` value and uses it to initialize
     * a new instance of the Random class. The shuffle is performed manually by
     * iterating over the list of cards and swapping the position of each card
     * with a randomly chosen card in the deck.
     *<p>
     * Ensures that a card already shuffled can be shuffled again by the
     * random int being able to include previous indexes.
     */
    public void shuffle() {
//        Collections.shuffle(cards); // Removed for proof of understanding

//        increment seed
        seed += 274;

//        generate random variable with new seed
        Random rand = new Random(seed);

//        shuffle with a for loop
        for (int index = 0 ; index < this.cards.size() ; index++) {
                Card tmp = this.cards.get(index);
                int replacementInd = rand.nextInt(this.cards.size() - 1);
            try {
                this.cards.set(index, cards.get(replacementInd));
                this.cards.set(replacementInd, tmp);
            } catch (IndexOutOfBoundsException e) { // to be safe, including this catch for unforeseen error handling with the random call
                System.err.println("[ERROR] Random hit index out of bounds: " + replacementInd +
                        "\nPrinting error stream and hard exiting:\n" + e);
                exit(1);
            }
        }
    }

    /**
     * Draws the top card from the deck and removes it.
     *
     * @return the card that was removed from the top of the deck
     */
    public Card draw() {
//        remove and return the first card in the deck
        return this.cards.removeFirst();
    }


    public List<Card> getDeck() {
        List<Card> displayDeck = new ArrayList<>();
        Collections.copy(displayDeck, this.cards);
        return displayDeck;
    }

}
