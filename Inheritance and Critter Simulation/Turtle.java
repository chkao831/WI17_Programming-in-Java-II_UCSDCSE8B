import java.awt.*;
import java.util.Random;
/*---File Header---
 * File: Turtle.java
 * @author Chih-Hsuan Kao
 * Login: cs8bwagy
 * Email: c4kao@ucsd.edu
 * Date: Feb 10, 2018
 * Sources of Help: textbook and lecture
 **/

/*---Class Header---
 * Turtle inherits the Ombivore Class, and is inherited by its subclass
 * GreenTurtle. 
 * It overrides some methods from its superclass and inherits capabilities of
 * it. It also has a new method, called generateAttack(), to decide on which
 * attack to choose next.  
 **/
public class Turtle extends Omnivore {

    //declare final static variable
    //instantiate random object with a seed of 8
    private static final int SEED = 8;
    //attack mode changes in a cycle of 3
    private static final int DENOMINATOR = 3;
    //in a cycle of 3, turtle stand still 2 times
    private static final int STANDSTILL = 2;

    //initialze new instance variable
    //attackRef: an attack type reference to store attack mode
    protected Attack attackRef;

    //no-arg constructor
    public Turtle(){
        displayName = "Tu";
        color = Color.CYAN;
        count = 0;
        random = new Random(SEED);
        attackRef = Attack.POUNCE;
    }

    /* Method: generateAttack
     * This method handles the attack mode of the turtle.
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return none
     */
    protected void generateAttack(){
        //attack mode cycle between roar, scratch and pounce
        if(attackRef.equals(Attack.ROAR)){
            attackRef = Attack.SCRATCH;
        }
        else if(attackRef.equals(Attack.SCRATCH)){
            attackRef = Attack.POUNCE;
        }
        else{
            //the first time generateAttack is called,
            //decide to use roar on its first attack
            attackRef = Attack.ROAR;
        }
    }

    /* Method: getMove
     * Turtle will standstill two times, and then move north, repeating
     * this pattern for the duration of the simulation. 
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return Direction: direction of next move
     */
    @Override
    protected Direction getMove(){

        //the turtle will standstill two times then move one north
        if(count% DENOMINATOR < STANDSTILL){
            count++;
            return Direction.CENTER;
        }
        else{
            count++;
            return Direction.NORTH;
        }
    }

    /* Method: eat
     * The turtle will never eat, but upon encountering food, the Turtle decides
     * a new attack.
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return boolean: false: the turtle never eats
     */
    @Override
    protected boolean eat(){
        this.generateAttack();
        return false;
    }

    /* Method: fight
     * The turtle uses the attack that it has decided on using with
     * generateAttack method.
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param String opponent
     * @return Attack attackRef: next attack mode
     **/
    @Override
    protected Attack fight(String opponent){
        return attackRef;
    }

    /* Method: win
     * Upon winning a fight, Turtle decides a new attack by calling
     * generateAttack()
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return none
     */
    @Override
    protected void win(){
        this.generateAttack();
    }
}
