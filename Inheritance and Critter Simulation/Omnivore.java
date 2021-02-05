/*
 * @author CSE8B Winter 2018 Staff
 * 02/04/18
 */


/* THIS FILE SHOULD NOT BE EDITED. */

import java.awt.*;
import java.util.Random;

/* Partially implements an animal's characteristics. */
public class Omnivore extends SadAnimal {
    // Constructor: Create a new Omnivore.
    public Omnivore () {
        displayName = "O";
    }

    // Movement method of Omnivore that takes in empty parameter
    // Returns a direction that Omnivore would move to
    @Override
    protected Direction getMove() {
        return Direction.WEST;
    }

    // Attack method of Omnivore that takes in parameter of the name of opponent
    // Returns the pounce attack that Omnivore would always use
    @Override
    protected Attack fight(String opponent) {
        return Attack.POUNCE;
    }

    @Override
    protected boolean eat() {
        return true;
    }


}
