import java.awt.*;
import java.util.Random;
/*---File Header---
 * File: Leopard.java
 * @author: Chih-Hsuan Kao
 * Login: cs8bwagy
 * Email: c4kao@ucsd.edu
 * Date: Feb 10, 2018
 * Sources of Help: textbook and lecture
 **/

/*---Class Header---
 * Leopard inherits the Omnivore Class. It overrides some of the methods from
 * its superclasses and inherits some other capabilities of its superclass. 
 */
public class Leopard extends Omnivore {
    //declaring final static variables
    //move around square motion with a cycle of 20
    private static final int MOVEDENO = 20;
    //random seed of 2018
    private static final int SEED = 2018;
    //maximum confidence is 10
    private static final int MAXCONFIDENCE = 10;
    //remainders to decide which direction
    private static final int MOVESOUTH = 4;
    private static final int MOVEWEST= 9;
    private static final int MOVENORTH = 14;
    private static final int PERCENT = 100;
    //base on the confidence *10 to decide eat or not
    private static final int BASE = 10;
    //roar if confidence higher than 5
    private static final int ROAR = 5;
    //forfeit if confidence lower than 2
    private static final int FORFEIT = 2;


    //instance variables to determine confidence level
    protected static int confidence;

    //no-arg constructor
    public Leopard(){
        //The self-identity is Li
        displayName = "Li";
        //orange identity
        color = Color.ORANGE;
        confidence = 10;
        count = 0;
        //random seed of 2018
        random = new Random(SEED);
    }

    /* Method: win
     * Upon winning, increment confidence level by 1
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return none
     */
    @Override
    protected void win(){
        if(confidence < MAXCONFIDENCE){
            confidence = confidence +1; 
        }
    }
    /* Method: lose
     * Upon losing, decrement confidence level by 1
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return none
     */

    @Override
    protected void lose(){
        if(confidence > 0){
            confidence = confidence -1;
        }
    }
    /* Method: getMove
     * Move around square motion by using count
     * divide count by 20 and see its remainder to decide
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return Direction: direction of next move
     */
    @Override
    protected Direction getMove(){
        count = count + 1;
        if(count % MOVEDENO <= MOVESOUTH){
            return Direction.SOUTH;
        }
        else if(count % MOVEDENO <= MOVEWEST){
            return Direction.WEST;
        }   
        else if(count % MOVEDENO <= MOVENORTH){
            return Direction.NORTH;
        }
        else {
            return Direction.EAST;
        }
    }
    /* Method: eat
     * Always have (confidence*10)% change of eating
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return boolean: true: eat
     *                  false: don't eat
     */
    @Override
    protected boolean eat(){
        //random number generate 0 to 99
        int randomNum = random.nextInt(PERCENT);

        //base on the confidence *10 to decide eat or not
        if(randomNum < (confidence* BASE)){
            return true;
        } else {
            return false;
        }
    }
    /* Method: fight
     * The leopard uses the attack based on different scenarios and conditions
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param String opponent
     * @return Attack: the next attack mode
     */
    @Override
    protected Attack fight(String opponent){

        //If opponent is Omnivore or have confidence > 5, roar
        if(opponent.equals("O") || confidence > ROAR){
            return Attack.ROAR;
        }
        //if confidence less than 2, forfeit
        else if(confidence < FORFEIT){
            return Attack.FORFEIT;
        }
        //otherwise, will scratch
        else {
            return Attack.SCRATCH;
        }
        
    }
    
}
