package roulette;

import util.ConsoleReader;

public class OddEvenBet extends Bet {
    private String myChoice;

    public OddEvenBet (String description, int odds) {
        super(description, odds);
        // initialize to default value, so no need to check for null
        myChoice = "";
    }

    @Override
    public boolean isMade (Wheel.SpinResult wheel) {
        return (wheel.getNumber() % 2 == 0 && myChoice.equals("even"))
                || (wheel.getNumber() % 2 == 1 && myChoice.equals("odd"));
    }

    @Override
    public void place () {
        myChoice = ConsoleReader.promptOneOf("Please bet", "even", "odd");
    }
}
