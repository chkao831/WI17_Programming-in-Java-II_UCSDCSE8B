import java.awt.*;
import java.util.Random;
/*---File Header---
 * File: Elephant.java
 * @author Chih-Hsuan Kao
 * Login: cs8bwagy
 * Email: c4kao@ucsd.edu
 * Date: Feb 10, 2018
 * Sources of Help: textbook and lecture
 **/

/*---Class Header---
 * Elephant inherits HappyAnimal class. It overrides some methods from its
 * superclasses and inherits some other capabilities from its superclasses. 
 **/
public class Elephant extends HappyAnimal{

    //decalre final static variable
    ////instantiate random object with a seed of 2048
    private static final int SEED = 2048;

    //new instance variables
    //Elephants have x and y goal to which they all travel towards in a pack
    protected static int goalX;
    protected static int goalY;
    
    //no-arg constructor
    public Elephant(){
        displayName = "El";
        color = Color.GRAY;
        random = new Random (SEED);
        goalX = -1;
        goalY = -1;
    }

    /* Method: fight
     * Elephants should always pounce
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param String opponent
     * @return Attack: pounce
     */
    @Override
    protected Attack fight(String opponent){
        return Attack.POUNCE;
    }

    /* Method: getMove
     * A method to get the next direction that an elephant should be moving
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return Direction: next direction
     */
    @Override
    protected Direction getMove(){
        //local boolean variables to check the relative direction of the goal 
        boolean goLeft = false;
        boolean goDown = false;
        //local int variables to check the absolute value of x and y difference
        int xDif = 0;
        int yDif = 0;

        //check if the goal has been set for the first time, if not, set it
        if(goalX==-1 && goalY==-1){
            goalX = random.nextInt(this.getWidth());
            goalY = random.nextInt(this.getHeight());
        }
        //check if the elephant has reached the goal it wants to reach
        //if reached, set a new goal
        else if (goalX==this.getX() && this.getY() == goalY){
            System.out.println("hi");
            goalX = random.nextInt(this.getWidth());
            goalY = random.nextInt(this.getHeight());
        }
        else{
        }

        System.out.println("");
        System.out.println("this is goalX + goalY " + 
                goalX +"  "+goalY );
        System.out.println("this is the X and Y " + this.getX()
                +"  "+ this.getY());

        //in x direction, calculate the difference and relative direction
        if(this.getX() - goalX > 0){
            xDif = this.getX() - goalX;
            goLeft = true;
        } else {
            xDif = goalX - this.getX();
        }
        //in y direction, calculate the difference and relative direction
        if(goalY - this.getY() > 0){
            yDif = goalY - this.getY();
        } else {
            yDif = this.getY() - goalY;
            goDown = true;
        }

        System.out.println("this is XDIF + YDIF "+ xDif+" " +yDif);

        //check further away in x or y direction
        //if further away in x
        if(xDif > yDif){
            //goal is on left
            if(goLeft == true){
                return Direction.WEST;    
                //goal is on right
            } else {
                return Direction.EAST;
            }
        }
        //if further away in y
        else {
            //goal is in bottom
            if(goDown == true){
                return Direction.NORTH;
                //goal is on top
            } else {
                return Direction.SOUTH;
            }
        }
    }
}
