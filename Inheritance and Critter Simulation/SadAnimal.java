import java.awt.*;
import java.util.Random;
/*---File Header---
 * File: SadAnimal.java
 * @author CSE8B Winter 2018 Staff
 * 02/04/18
 *
 * @modified by Chih-Hsuan Kao
 * Login: cs8bwagy
 * Email: c4kao@ucsd.edu
 * Date: Feb 10, 2018
 * Sources of Help: textbook and lecture
 **/

/*---Class Header---
 * SadAnimal inherits the Critter class, and is inherited by its subclass,
 * such as Omnivore, Turtle, Leopard and GreenTurtle. It overrides some methods
 * from the Critter class and inherits capabilities of them. 
 **/
public class SadAnimal extends Critter {
    //a String to identify itself
    protected String displayName;
    //a Color to display itself
    protected Color color; 
    //a boolean to know whether eaten yet
    protected boolean eaten; 
    //random object to make arbitrary decisions
    protected Random random; 
    //int to count step
    protected int count;
    //Direction the critter would move to
    protected Direction direction;
    //int to count the number of times eaten
    protected int eatCount;
    public String carolyn;

    /*
     * no-arg constructor for SadAnimal
     * @param none
     * @return SanAnimal
     **/
    public SadAnimal () {
        displayName = ":-(";
        color = Color.RED;
        eaten = false; 
        direction = Direction.WEST;
        eatCount = 0;
    }
    /* Method: getMove
     * This is a movement method of SadAnimal that takes in empty parameter and
     * returns a direction that the critter would move to
     * Name: Chih-Hsuan Kao, cs8bwagy
     * Date: Feb 10, 2018
     * @param none
     * @return Direction: direction of next move
     **/
    @Override
    protected Direction getMove() {
        //always move west first, and move west again after eats again
        if(eatCount%2 == 0){
            direction = Direction.WEST;
            //when it eats, change direciton to south
        } else{
            direction = Direction.SOUTH;
        }    
        return direction;
    }
    /* Method: eat
     * When encounters food, call this on it to ask and it always want to eat
     * Name: Chih-Hsuan Kao, cs8bwagy
     * Date: Feb 10, 2018
     * @param none
     * @return boolean true: if it wants to eat (always true)
     **/
    @Override
    protected boolean eat() {
        eatCount++;
        return true; 
    }

    /* Method: getColor
     * This method tells the simulator what color the animal should be
     * Name: Chih-Hsuan Kao, cs8bwagy
     * Date: Feb 10, 2018
     * @param none
     * @return Color: the displayed color
     **/
    @Override
    protected Color getColor() {
        return this.color;
    }

    /* Method: toString
     * This method returns the string representation of SanAnimal
     * Name: Chih-Hsuan Kao, cs8bwagy
     * Date: Feb 10, 2018
     * @param none
     * @return String: the display name of the animal
     **/
    @Override
    public String toString() {
        return this.displayName; 
    }
}
