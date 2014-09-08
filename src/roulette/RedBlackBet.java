package roulette;

import util.ConsoleReader;

public class RedBlackBet extends Bet {
    private String myChoice;

    public RedBlackBet (String description, int odds) {
        super(description, odds);
        // no initialization needed for myChoice
    }

    @Override
    public boolean isMade (Wheel.SpinResult wheel) {
        return wheel.getColor().equals(myChoice);
    }

    @Override
    public void place () {
        myChoice = ConsoleReader.promptOneOf("Please bet", Wheel.BLACK,
                Wheel.RED);
    }
}
