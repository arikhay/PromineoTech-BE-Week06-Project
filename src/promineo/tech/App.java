package promineo.tech;

import java.util.Formatter;

public class App {

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
            System.out.println(player1.getName() + "'s card is a " + player1Card.getName() + ".\tValue: " + player1Card.getValue());
            System.out.println(player2.getName() + "'s card is a " + player2Card.getName() + ".\tValue: " + player2Card.getValue());

            if (player1Card.getValue() > player2Card.getValue()) {
                System.out.println(player1.getName() + " wins the round.");
                player1.incrementScore();
                System.out.println(player1.getName() + "'s score:\t" + player1.getScore());
                System.out.println(player2.getName() + "'s score:\t" + player2.getScore());
            } else if (player1Card.getValue() < player2Card.getValue()) {
                System.out.println(player2.getName() + " wins the round.");
                player2.incrementScore();
                System.out.println(player1.getName() + "'s score:\t" + player1.getScore());
                System.out.println(player2.getName() + "'s score:\t" + player2.getScore());
            } else {
                System.out.println("It's a tie. No points.");
                System.out.println(player1.getName() + "'s score:\t" + player1.getScore());
                System.out.println(player2.getName() + "'s score:\t" + player2.getScore());
            }

        }

        System.out.println();
        System.out.println();
        System.out.println("-----RESULTS");
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
