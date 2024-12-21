package promineo.tech;

import java.util.Formatter;

/**
 * The App class represents the main driver program for the card game.
 * It initializes a deck of cards and two players, shuffles the deck,
 * and distributes the cards equally between two players. The game is
 * played in a series of rounds where each player flips a card from their
 * hand, and the card with a higher value wins the round. The game concludes
 * with a score comparison to determine the winner.
 *
 * Responsibilities:
 * - Initialize the deck and players.
 * - Shuffle the deck and distribute cards evenly between the players.
 * - Execute and display the results of each round.
 * - Determine and display the overall winner or if the game ends in a tie.
 *
 * Features:
 * - Simulates card draws using methods in the Player and Deck classes.
 * - Handles round results and scorekeeping.
 * - Outputs detailed game progress and final results to the console.
 * @author Ari Hayhurst
 */
public class App {

    /**
     * The main method serves as the entry point of the application. It initializes a deck of cards
     * and two players, shuffles the deck, deals cards alternately to the players, and then simulates
     * a series of 26 rounds where each player flips a card to determine the round winner based on
     * card values. At the end of the rounds, the game declares the final winner or identifies a tie.
     *
     * @param args an array of {@code String} objects that can store command-line arguments. This
     *             parameter is not utilized in the method.
     */
    public static void main(String[] args) {

//        instantiate and declare global variables
        Deck deck = new Deck();
        Player player1 = new Player("Polaris");
        Player player2 = new Player("Sirius");

//        shuffle the deck
        deck.shuffle();

//        for loop to deal the deck, using modulo 2 to decide who draws
        for (int dealt = 0 ; dealt < 52 ; dealt++) {
            if (dealt % 2 == 0) {
                player1.draw(deck);
            } else {
                player2.draw(deck);
            }
        }

//        play each round
        for (int round = 0 ; round < 26 ; round++) {
            Card player1Card = player1.flip();
            Card player2Card = player2.flip();

            System.out.println();
            System.out.println("-----ROUND " + String.format("%02d", round + 1));
            System.out.println(player1.getName() + "'s card is a " + player1Card.getName() + ".\n\t\t\t\tValue: " + player1Card.getValue());
            System.out.println(player2.getName() + "'s card is a " + player2Card.getName() + ".\n\t\t\t\tValue: " + player2Card.getValue());

//            decide victor, notify, and increment
            if (player1Card.getValue() > player2Card.getValue()) {
                System.out.println(player1.getName() + " wins the round.");
                player1.incrementScore();
                System.out.println(player1.getName() + "'s score: " + player1.getScore());
                System.out.println(player2.getName() + "'s score: " + player2.getScore());
            } else if (player1Card.getValue() < player2Card.getValue()) {
                System.out.println(player2.getName() + " wins the round.");
                player2.incrementScore();
                System.out.println(player1.getName() + "'s score: " + player1.getScore());
                System.out.println(player2.getName() + "'s score: " + player2.getScore());
            } else {
                System.out.println("It's a tie. No points.");
                System.out.println(player1.getName() + "'s score: " + player1.getScore());
                System.out.println(player2.getName() + "'s score: " + player2.getScore());
            }

        }

//        print out final results
        System.out.println();
        System.out.println();
        System.out.println("-----RESULTS");
        System.out.println(player1.getName() + "'s score: " + player1.getScore());
        System.out.println(player2.getName() + "'s score: " + player2.getScore());
        if (player1.getScore() > player2.getScore()) {
            System.out.println(player1.getName() + " wins the game.");
        } else if (player1.getScore() < player2.getScore()) {
            System.out.println(player2.getName() + " wins the game.");
        } else {
            System.out.println("It's a tie. No victor.");
        }
        System.out.println();

    }

}
