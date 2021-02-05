import java.awt.*;
import java.util.Random;
/*---File Header---
 * File: GreenTurtle.java
 * @author Chih-Hsuan Kao
 * Login: cs8bwagy
 * Email: c4kao@ucsd.edu
 * Date: Feb 10, 2018
 * Sources of Help: textbook and lecture
 **/

/*---Class Header---
 * GreenTurtle inherits the Turtle Class.
 * It inherits methods and capabilities from Turtle class and its other super
 * classes. It also has a new method called generateMove() to change the
 * movement of the Green turtle. 
 **/
public class GreenTurtle extends Turtle {

    //declare final static variables
    //Random seed is 9
    private static final int SEED = 9;
    //GreenTurtle will eat three times and then never eats again
    private static final int MAXEAT = 3;

    //no-arg constructor
    public GreenTurtle(){
        displayName = "G";
        color = Color.GREEN;
        random = new Random(SEED);
        direction = Direction.NORTH;
        eatCount = 0;
        attackRef = Attack.ROAR;
    }

    /* Method: generateMove
     * This method will change the movement of the Green turtle
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return none
     */
    protected void generateMove(){
        //the GreenTurtle cycle between the four non-center directions
        //starting with north, then south, then east, then west
        if(direction.equals(Direction.NORTH)){
            direction = Direction.SOUTH;
        }
        else if(direction.equals(Direction.SOUTH)){
            direction = Direction.EAST;
        }
        else if(direction.equals(Direction.EAST)){
            direction = Direction.WEST;
        }   
        else {
            direction = Direction.NORTH;
        }
    }

    /* Method: generateAttack
     * This method handles the attack mode of the turtle
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return none
     */
    @Override
    protected void generateAttack(){
        if(attackRef.equals(Attack.ROAR)){
            attackRef = Attack.SCRATCH;
        }
        else {
            attackRef = Attack.ROAR;
        }
    }

    /* Method: eat
     * GreenTurtle will eat three times and then never eats again
     * When encountering food, decide its next direction
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return none
     */
    @Override
    protected boolean eat(){
        //before eaten three times, increment count and decide move
        while(eatCount < MAXEAT){
            eatCount = eatCount +1;
            this.generateMove();
            return true;
        }
        //after three times, don't eat
        return false;
    }

    /* Method: fight
     * The method gives which attack to use
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param String opponent
     * @return Attack: type of attack to use
     */
    @Override
    protected Attack fight(String opponent){
        //if opponent is Sloth, the GreenTurtle will roar
        if(opponent.equals("S")){
            return Attack.ROAR;
        }
        //if opponent is sleeping Sloth, will forfeit
        else if(opponent.equals("Zzz")){
            return Attack.FORFEIT;
        }
        //otherwide, use the attack that it had decided on earlier
        else{
            return attackRef;
        }
    }

    /* Method: win
     * Upon winning, decide its next direction and its next attack
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return none
     */
    @Override
    protected void win(){
        this.generateAttack();
        this.generateMove();
    }

    /* Method: mate
     * Upon mating, decide its next attack
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return none
     */
    @Override
    protected void mate(){
        this.generateAttack();
    }

    /* Method: getMove
     * move in the direction that it has decided on
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return Direction: the next direction to move
     */
    @Override
    protected Direction getMove(){
        return this.direction;
    }
}
