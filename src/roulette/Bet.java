package roulette;

/**
 * Represents player's attempt to bet on outcome of the roulette wheel's spin.
 * 
 * @author Robert C. Duvall
 */
public abstract class Bet {
    private String myDescription;
    private int myOdds;

    /**
     * Constructs a bet with the given name and odds.
     * 
     * @param description name of this kind of bet
     * @param odds given by the house for this kind of bet
     */
    protected Bet (String description, int odds) {
        myDescription = description;
        myOdds = odds;
    }

    /**
     * @return amount to pay out for winning this bet
     */
    public int payout (int wager) {
        return myOdds * wager;
    }

    /**
     * @return string representation of this bet
     */
    @Override
    public String toString () {
        return myDescription;
    }

    /**
     * Checks if this bet is won or lost given result of spinning the wheel.
     */
    public abstract boolean isMade (Wheel.SpinResult wheel);

    /**
     * Place bet by prompting user for the specific information needed.
     */
    public abstract void place ();
}
