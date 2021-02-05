/*
 * @author CSE8B Winter 2018 Staff
 * 02/04/18
 */

/* THIS FILE SHOULD NOT BE EDITED. */

import java.awt.*;
import java.util.Random;

/* Partially implements an animal's characteristics. */
public class HappyAnimal extends Critter {
    protected String displayName;
    protected Color color;
    protected Random random;

    /* Constructor: Create a new HappyAnimal. */
    public HappyAnimal () {
        displayName = ":-)";
        color = Color.BLUE;
    }

    // This animal always uses scratch.
    @Override
    protected Attack fight(String opponent) {
        return Attack.SCRATCH;
    }

    // This method tells the simulator what color I should be.
    @Override
    protected Color getColor() {
        return this.color;
    }

    // This method returns the string representation of HappyAnimal
    @Override
    public String toString() {
        return this.displayName;
    }

}
