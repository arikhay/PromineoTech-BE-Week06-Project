package promineo.tech;

// imports from Java framework
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * The Deck class represents a collection of cards in a standard deck.
 * This class provides methods to initialize the deck, shuffle it, and draw cards.
 * @author Ari Hayhurst
 */
public class Deck {

    //    global variable for seeding the Random class
    private long seed = 325;

//    instantiate the deck of cards
    private ArrayList<Card> cards;

    /**
     * Constructs a Deck object and initializes it with a standard set of 52 playing cards.
     * The deck consists of four suits: Clubs, Diamonds, Hearts, and Spades.
     * Each suit has 13 ranks: Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine,
     * Ten, Jack, Queen, and King, each associated with a numerical value starting from 2.
     *
     * The cards are stored in an ArrayList, where each card is represented by a Card object.
     */
    public Deck() {
//        declare the ArrayList
        cards = new ArrayList<>();

        //    array of suits
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        for (String suit : suits) {
//            array of ranks
            String[] ranks = {"Two", "Three", "Four", "Five",
                    "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
            for (int j = 0; j < ranks.length; j++) {
                cards.add(new Card(j + 2, suit + " of " + ranks[j]));
            }
        }
    }

    public void shuffle() {
//        Collections.shuffle(cards); // Removed for proof of understanding

//        increment seed
        seed += 274;

//        generate random variable with new seed
        Random rand = new Random(seed);

//        shuffle with a for loop
        for (int index = 0 ; index < cards.size() ; index++) {
            Card tmp = cards.get(index);
            int replacementInd = rand.nextInt(cards.size() - 1);
            cards.set(index, cards.get(replacementInd));
            cards.set(replacementInd, tmp);
        }
    }

    public Card draw() {
//        remove and return the first card in the deck
        return cards.removeFirst();
    }
}
