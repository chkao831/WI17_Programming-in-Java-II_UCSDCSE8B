import java.awt.*;
import java.util.Random;

/*---File Header---
 * File: ChihHsuan_c4kao.java
 * @author: Chih-Hsuan Kao
 * Login: cs8bwagy
 * Email: c4kao@ucsd.edu
 * Date: Feb 10, 2018
 * Sources of Help: N/A
 **/

/*---Class Header---
 * This class inherits the Critter Class
 */

public class ChihHsuan_c4kao extends Critter {

    protected static final int SEED = 1997;

    //instance variables
    protected String displayName;
    protected Color color;
    protected Random random;
    protected int randomCount;
    protected Attack attackRef;
    protected Direction direction;

    //no arg constructor to initialize instance variables
    //take no parameter and return nothing
    public ChihHsuan_c4kao(){
        displayName = "CK";
        color = Color.PINK;
        random = new Random (SEED);
        direction = Direction.NORTH;
        attackRef = Attack.SCRATCH;
    }

    /* Method: fight
     * decide next attack mode
     * @param String opponent
     * @return Attack attackRef: next attack mode
     **/
    @Override
    protected Attack fight(String opponent){
        return attackRef;
    }

    /* Method: getColor
     * get the color of the critter
     * @param none
     * @return Color: color of the critter
     **/
    @Override
    protected Color getColor(){
        return this.color;
    }

    /* Method: getMove
     * return the direction of next movement
     * @param none
     * @return none
     */
    @Override
    protected Direction getMove(){
        return this.nextMovement();
    }
    /* Method: generateAttack
     * generate different modes of attack upon different calls and under
     * different scenarios
     * @param none
     * @return none
     */
    protected void generateAttack(){
        //generate a random int between 1 and 100
        randomCount = random.nextInt(99)+1;
        //have 25 percent of choosing roar
        if(randomCount < 25){
            attackRef = Attack.ROAR;
        }
        //have 25 percent of choosing pounce
        else if(randomCount < 50){
            attackRef = Attack.POUNCE;
        }
        //have 50 percent of choosing scratch
        else{
            attackRef = Attack.SCRATCH;
        }
    }
    /* Method: nextMovement
     * Get the next direction of the movement randomly
     * @param none
     * @return Direction: the direction of next movement
     */
    protected Direction nextMovement(){
        //generate an int from 1 to 100
        randomCount = random.nextInt(99)+1;
        //divided by 4, return east if remainder is 1
        //west if 2; south if 3; north if 0
        if(randomCount % 4 ==  1){
            return Direction.EAST;
        } 
        if(randomCount % 4 ==  2){
            return Direction.WEST;
        }
        if(randomCount % 4 == 3){
            return direction.SOUTH;
        }
        else {
            return Direction.NORTH;
        }
    }
    /* Method: eat
     * Upon eating (always eat), call nextMovement to generate a random next
     * direction
     * @param none
     * @return boolean true: always eat
     */
    @Override
    protected boolean eat(){
        this.nextMovement();
        return true;
    }
    /* Method: win
     * Upon winning, call nextMovement to generate a random next direction
     * @param none
     * @return none
     */
    @Override
    protected void win(){
        this.nextMovement();
    }
    /* Method: toString
     * Upon calling, return displayName
     * @param none
     * @return String displayname
     */
    @Override
    public String toString(){
        return this.displayName;
    }
    /* Method: mate
     * Upon mating, call nextMovement to generate a random next direction
     * @param none
     * @return none
     */
    @Override
    protected void mate(){
        this.nextMovement();
    }
}
