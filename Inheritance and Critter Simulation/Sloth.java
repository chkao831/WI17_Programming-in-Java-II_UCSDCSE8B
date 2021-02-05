import java.awt.*;
import java.util.Random;
/*---File Header---
 * File: Sloth.java
 * @author CSE8B Winter 2018 Staff
 * 02/04/18
 *
 * @modified by Chih-Hsuan Kao
 * Login: cs8bwagy  
 * Email: c4kao@ucsd.edu
 * Date: Feb 10, 2018
 * Sources of Help: textbook
 */

/*---Class Header---
 * This class implements the Sloth critter class. 
 * It inherits from the HappyAnimal and inherits capabilities of it. 
 * It overrides some methods from Critter and HappyAnimal class
 **/
public class Sloth extends HappyAnimal {
    //Direction the critter would move to
    protected Direction direction;
    //int to count the number of times eaten
    protected int numberEaten;
    //int to count the number of times moved
    protected int numberMovement;

    /* Constructor: Create a new Sloth. */
    public Sloth() {

        displayName = "S";
        direction = Direction.NORTH;
    }

    /* Method: eat
     * eating behavior of Sloth
     * Name: Chih-Hsaun Kao, cs8bwagy
     * @param none
     * @return boolean true: when encountering food, Sloth will always eat
     */
    @Override
    protected boolean eat() {
        this.numberEaten++; 
        return true; 
    }

    /* Method: fight
     * fight mode of the sloth
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param String opponent
     * @return Attack: the next attack mode
     */
    @Override
    protected Attack fight(String opponent) {
        // A sloth will pounce instead if has eaten 10 food or more
        if(this.numberEaten >= 10){
            return Attack.POUNCE;
            //in general, a sloth will scratch
        } else {
            return Attack.SCRATCH;
        }
    }
    /* Method: getMove
     * the sloth will alternate in moving north and east, 
     * starting with north when it is first born.
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return Direction: the next direction
     */
    @Override
    protected Direction getMove() {
        this.numberMovement++;
        if(this.numberMovement%2 ==0){
            return Direction.NORTH;
        } else {
            return Direction.EAST;
        }
    }
    /* Method: sleep
     * the sloth will switch its identity into Zzz upon sleep
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return none
     */
    @Override
    protected void sleep() {
        this.displayName = "Zzz";
    }

    /* Method: wakeup
     * the sloth will switch its identity back to S whenever it wakes up
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return none
     */
    @Override
    protected void wakeup() {
        this.displayName = "S";
    }

}
