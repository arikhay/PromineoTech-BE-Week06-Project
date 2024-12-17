package promineo.tech;


import java.util.ArrayList;
import java.util.List;

public class GameOfWar {

//    create the states enumerator
    public enum State {
        NEW,
        ONGOING,
        FINISHED
    }

//    instantiate player variables
    private final Player player1;
    private final Player player2;
//    instantiate the victor
    private Player victor;
//    instantiate the deck
    private final Deck deck;
//    instantiate the game state
    private State state;
//    instantiate game log
    private final List<String> gameLog;
//    instatiate a way to track the rounds
    private int round;

    public GameOfWar(String player1Name, String player2Name) {
//        declare player variables
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
        victor = null;
//        declare the deck
        deck = new Deck();
//        declare the game log
        gameLog = new ArrayList<>();
//        declare the state
        state = State.NEW;
//        declare round to 0
        round = 0;

    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return this.state;
    }

    public void setVictor(Player victor) {
        this.victor = victor;
    }

    public Player getVictor() {
        return this.victor;
    }

    public void writeToLog(String record) {
        gameLog.add(record) ;
    }


    public void nextRound() {

        switch(this.state) {
            case FINISHED: {
                System.out.println("Game is over.");
                break;
            } case NEW: {
                this.state = State.ONGOING;
//              shuffle and deal the deck
                deck.shuffle();
                for (int deal = 0 ; deal < 26 ; deal++) {
                    player1.draw(deck);
                    player2.draw(deck);
                }
            } case ONGOING: {
                Card player1Card = player1.flip();
                Card player2Card = player2.flip();
                if (player1Card.getValue() > player2Card.getValue()) {
                    System.out.println("Round " + round + ":\n" +
                            "\t" + player1.getName() + "'s card is '" + player1Card.getName() + "' with a value of " + player1Card.getValue() + ".\n" +
                            "\t" + player2.getName() + "'s card is '" + player2Card.getName() + "' with a value of " + player2Card.getValue() + ".");
                    System.out.println(player1.getName() + "wins this round.");
                    player1.incrementScore();
                    gameLog.add("[WIN: " + player1.getName() + " ('" + player1Card.getName() + "', " + player1Card.getValue() + ", Score: " + player1.getScore() + ")]\n" +
                            "[LOSE: " + player2.getName() + " ('" + player2Card.getName() + "', " + player2Card.getValue() + ", Score: " + player1.getScore() + ")]");
                } else if (player1Card.getValue() < player2Card.getValue()) {
                    System.out.println("Round " + round + ":\n" +
                            "\t" + player1.getName() + "'s card is '" + player1Card.getName() + "' with a value of " + player1Card.getValue() + ".\n" +
                            "\t" + player2.getName() + "'s card is '" + player2Card.getName() + "' with a value of " + player2Card.getValue() + ".");
                    System.out.println(player2.getName() + "wins this round.");
                    player2.incrementScore();
                    gameLog.add("[LOSE: " + player1.getName() + " ('" + player1Card.getName() + "', " + player1Card.getValue() + ", Score: " + player1.getScore() + ")]\n" +
                            "[WIN: " + player2.getName() + " ('" + player2Card.getName() + "', " + player2Card.getValue() + ", Score: " + player2.getScore() + ")]");
                } else {
                    System.out.println("Round " + round + ":\n" +
                            "\t" + player1.getName() + "'s card is '" + player1Card.getName() + "' with a value of " + player1Card.getValue() + ".\n" +
                            "\t" + player2.getName() + "'s card is '" + player2Card.getName() + "' with a value of " + player2Card.getValue() + ".");
                    System.out.println("It's a tie. No one wins this round.");
                    gameLog.add("[TIED: " + player1.getName() + " ('" + player1Card.getName() + "', " + player1Card.getValue() + ", Score: " + player1.getScore() + ")]\n" +
                            "[TIED: " + player2.getName() + " ('" + player2Card.getName()+ "', " + player2Card.getValue() + ", Score: " + player1.getScore() + ")]");
                }
                round++;

                if (round >= 26) {
                    this.state = State.FINISHED;
                    System.out.println("GAME OVER");
                    if (player1.getScore() > player2.getScore()) {
                        System.out.println(player1.getName() + "wins.");
                    } else if (player1.getScore() < player2.getScore()) {
                        System.out.println(player2.getName() + "wins.");
                    } else {
                        System.out.println("It's a tie.");
                    }
                }
            }
        }


    }

    public void printDeck() {
        List<Card> displayDeck = deck.getDeck();
        for (Card card : displayDeck) card.describe();
    }

    public void printPlayers() {
        player1.describe();
        player2.describe();
    }

    public void printLog() {
        int padding = Integer.toString(gameLog.size() - 1).length();
        for (int entry = gameLog.size() - 1 ; entry >= 0 ; entry--) {
            System.out.println("ENTRY " + String.format("%0" + padding + "d", entry) + " -> " +
                    gameLog.get(entry).replace("\n","\nENTRY " +
                            String.format("%0" + padding + "d", entry) + " -> "));
        }
    }

}
