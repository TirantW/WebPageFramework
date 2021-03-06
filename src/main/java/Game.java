package main.java;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;
    Card tableCards = new Card();
    CardDeck cardDeck = new CardDeck();

    Rules rules = new Rules();

    /**
     * contructor
     * @param players
     */
    public Game(ArrayList<Player> players) {
        players = new ArrayList<>();
    }

    /**
     *
     * @param players
     * @return sets rules and plays the game krig
     */
    public void gameKrig(ArrayList<Player> players) {

        for (int i = 0; i < players.size(); i++) { //Iterating through each player
            Player iteratorPlayer = players.get(i);//Set current player
            while (iteratorPlayer.getCards().size() < 26) { //Iterate trough so each player get half of the card deck
                iteratorPlayer.drawCard(cardDeck);
            }
            Player playerOne = players.get(0);
            Player playerTwo = players.get(1);
            Player currentPlayer;


            while (!playerOne.isEmpty() && !playerTwo.isEmpty()) {
                    if (rules.isHigher(playerOne.getCard(0), playerTwo.getCard(0))) {
                        playerOne.drawCard(cardDeck);
                    } else if (rules.doCardsNumberMatch(playerOne.getCard(0), playerTwo.getCard(0))) {
                        for (int j = 1; j < 3; j++) {
                            playerOne.layOutCard(tableCards);
                            playerTwo.layOutCard(tableCards);
                        }
                        if (rules.isHigher(playerOne.getCard(2), playerTwo.getCard(2))) { //Hvis index2 of tableCards > index 2 tableCards2
                            playerOne.pullInCardsOnTable(tableCards);
                        }

                    } else
                        playerTwo.drawCard(cardDeck);

                    playerOne.drawCard(cardDeck);
                    playerTwo.drawCard(cardDeck);
            }
            if (playerOne.isEmpty()) {
                System.out.println("Player: " + playerTwo.getName() + " Won!");
            } else if (playerTwo.isEmpty())
                System.out.println("Player: " + playerOne.getName() + " Won!");

        }
    }

    /**
     * sets rules for each round
     * @param players
     */
    public void onNewRound(ArrayList<Player> players) {
        onNewPlayerRound(players);
        Player playerOne = players.get(0);
        Player playerTwo = players.get(1);

        while (!playerOne.isEmpty() && !playerTwo.isEmpty()) {
            if (rules.isHigher(playerOne.getCard(0), playerTwo.getCard(0))) {
                playerOne.drawCard(cardDeck);
            } else {
                playerTwo.drawCard(cardDeck);
            }
            if (rules.doCardsNumberMatch(playerOne.getCard(0), playerTwo.getCard(0))) {
                for (int j = 1; j < 3; j++) {
                    playerOne.layOutCard(tableCards);
                    playerTwo.layOutCard(tableCards);
                }
                if (rules.isHigher(playerOne.getCard(2), playerTwo.getCard(2))) { //Hvis index2 of tableCards > index 2 tableCards2
                    playerOne.pullInCardsOnTable(tableCards);
                } else {
                    playerTwo.pullInCardsOnTable(tableCards);
                }
            }
            if (playerOne.isEmpty()) {
                System.out.println("Player: " + playerTwo.getName() + " Won!");
            } else if (playerTwo.isEmpty())
                System.out.println("Player: " + playerOne.getName() + " Won!");
        }
    }


    /**
     * sets rules for each player per round
     * @param players
     */
    public void onNewPlayerRound(ArrayList<Player> players) {

        for (int i = 0; i < players.size(); i++) {
            players.get(i).layOutCard(tableCards);
        }
    }

    public void Play() {

    }
}
