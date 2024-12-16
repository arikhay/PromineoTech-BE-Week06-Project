package promineo.tech;

// imports from Java framework
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class Deck {

//    arrays to construct the deck
    private final String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private final String[] ranks = {"Ace", "Two", "Three", "Four", "Five",
            "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};

//    instantiate the deck of cards
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();

        for (String suit : suits) {
            for (int j = 0; j < ranks.length; j++) {
                cards.add(new Card(j + 2, suit + " of " + ranks[j]));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }


}
