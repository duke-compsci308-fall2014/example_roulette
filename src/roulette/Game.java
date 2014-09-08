package roulette;

import util.ConsoleReader;

/**
 * Plays a game of roulette.
 * 
 * @author Robert C. Duvall
 */
public class Game {
    // name of the game
    private static final String DEFAULT_NAME = "Roulette";

    private Wheel myWheel;
    private Bet[] myPossibleBets = { new RedBlackBet("Red or Black", 1),
            new OddEvenBet("Odd or Even", 1),
            new ConsecutiveBet("Three in a Row", 11), };

    /**
     * Construct the game.
     */
    public Game () {
        myWheel = new Wheel();
    }

    /**
     * @return name of the game
     */
    public String getName () {
        return DEFAULT_NAME;
    }

    /**
     * Play a round of this game.
     *
     * For Roulette, this means prompting the player to make a bet, spinning the
     * roulette wheel, and then verifying that the bet is won or lost.
     *
     * @param player one that wants to play a round of the game
     */
    public void play (Gambler player) {
        int amount = ConsoleReader.promptRange("How much do you want to bet",
                0, player.getBankroll());
        Bet b = promptForBet();
        b.place();

        System.out.print("Spinning ...");
        Wheel.SpinResult result = myWheel.spin();
        System.out.println("Dropped into " + result);

        if (b.isMade(result)) {
            System.out.println("*** Congratulations :) You win ***");
            amount += b.payout(amount);
        } else {
            System.out.println("*** Sorry :( You lose ***");
            amount *= -1;
        }
        player.updateBankroll(amount);
    }

    /**
     * Prompt user to make a bet from a menu of choices.
     */
    private Bet promptForBet () {
        System.out.println("You can make one of the following types of bets:");
        for (int k = 0; k < myPossibleBets.length; k++) {
            System.out.println((k + 1) + ") " + myPossibleBets[k]);
        }
        int whichBet = ConsoleReader.promptRange("Please make a choice", 1,
                myPossibleBets.length);
        return myPossibleBets[whichBet - 1];
    }
}
