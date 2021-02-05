/* Starter Code by Hans Yuan WI 18 */
/**File: EncryptionTurtleMT
 * This file contains EncryptionTurtleMT class, which performs encryption and
 * creates new Turtles using multiple threads to draw.
 * Name: Chih-Hsuan Kao
 * Login: cs8bwagy
 * Email: c4kao@ucsd.edu
 * Date: Mar 8, 2018
 * Sources of Help: TutorHours
 */
import turtleClasses.Turtle;
import turtleClasses.World;
import java.awt.*;
import java.util.*;

/**---Class Header---
 * The class EncryptionTurtleMT extends DrawingTurtle, which extends the Turtle
 * class. This class has capabilites of verifying if a string is valid,
 * performing encryption if string is valid with letter operation based on
 * rotation, and calling the drawing methods using multiple threads to complete
 * the drawing task.
 */ 
public class EncryptionTurtleMT extends DrawingTurtle implements Runnable {

    // DON'T CHANGE
    public final static int WORLD_WIDTH = 800;
    public final static int WORLD_HEIGHT = 120;

    //height of the top of letter
    public final static int START_HEIGHT = 20;

    // CHANGE BACK TO 75 WHEN DONE
    public final static int DELAY = 75;

    // These constants may be helpful:
    public final static int CHAR_WIDTH = 40;
    public final static int LINE_PADDING = 40;
    public final static int CHAR_SPACE = CHAR_WIDTH + LINE_PADDING;

    //self-added pen width and pen color
    public final static int PEN_WIDTH = 8;
    public final static Color PEN_COLOR = Color.MAGENTA;

    private char charr;
    private int x, y;

    /* private constructor -- this should not be called by anyone */
    /**
     * The constructor calls super and passes in a world and amount of delay,
     * and configure each turtle's setting and then make it run 
     * @param World the world that turtles are drawn on
     * @param char c: the original char to be encrypted
     * @param int xPos: the start x position of the character
     * @param int yPos: the start y position of the character
     */
    private EncryptionTurtleMT(World world, char c,int xPos, int yPos){
        super(world,DELAY);
        charr = c;
        x = xPos;
        y = yPos;
        setPenWidth(PEN_WIDTH);
        setPenColor(PEN_COLOR);
        //create a thread for each letter
        Thread thread = new Thread(this);
        thread.start();
    }

    /* multithreaded turtle code starts here; we call this method */
    /**Method: encryptMT
     * This method performs encryption by calling letterOperation 
     * It also contructs x and y position for a newly created EncryptionTurtleMT
     * object when it's called
     * @param String originalStr: the original string to be encrypted
     * @param int rotation: the rotation by which the encryption is performed
     * @return none
     */ 
    public static void encryptMT(String originalStr, int rotation) {
        //create a world that is shared by every turtle
        World world = new World(WORLD_WIDTH,WORLD_HEIGHT);

        //if string is valid, start encryption
        if(validString(originalStr)==true){
            String toBeReturned = new String();

            //start counting the index of each character
            for(int i = 0; i<originalStr.length(); i++){
                char c = originalStr.charAt(i);
                //assign x and y position
                int xPos = ((i+1)*CHAR_SPACE);
                int yPos = START_HEIGHT;
                //and perform encryption
                c = letterOperation(c,rotation);

                //at the end, create new EncryptionTurtleMT object and pass in
                //the parameters that are just created when the method is called
                EncryptionTurtleMT turtleMT = 
                    new EncryptionTurtleMT(world,c,xPos,yPos);
            }
        }
    }

    /**Method: letterOperation
     * This method performs letter operation with the passed-in parameters: an
     * character and int rotation
     * @param char original: the character to be rotated
     * @param int rotation: the amount by which to rotate
     * @return char: the encrypted character
     */ 
    private static char letterOperation(char original,int rotation){
        //if the value to be divided by 26 is non-negative
        if((original-65+rotation)>=0){
            original = (char)(((int)(original -65 +rotation))%26+65);
        }
        //otherwise, if negative
        else if((original-65+rotation)<0){
            int w = 26 - ((Math.abs((int)(original-65+rotation)))%26);
            original = (char)((w%26)+65);
        }
        return original;
    }

    /**Method: validString
     * This method verifies if a string is valid
     * @param String rawInput: the string to be verified
     * @return boolean true: if valid (all upper cased)
     *                 false: otherwise
     */ 
    private static boolean validString(String rawInput) {

        //if string is null, return false
        if(rawInput == null){
            return false;
        }
        //if the string is empty, return false
        else if(rawInput.equals("")){
            return false;
        }
        else{
            char[] rawInputChar = rawInput.toCharArray();
            for(char c: rawInputChar){
                //if character is letter
                if(Character.isLetter(c)){
                    //if lowercase, return false
                    if(Character.isLowerCase(c)){
                        return false;
                    }
                } else {
                    //if character is not letter
                    return false;
                }
            } return true;
        }
    }

    /**Method: run
     * This run method calls the turtle's draw method with passed-in param
     * but is not called directly
     * @param none
     * @return none
     */
    public void run(){
        draw(charr,x,y);
    }

    /**Main method
     * Test cases are added here
     */
    public static void main(String[] args) {
        System.out.println("Hello, this is the Main method of EncryptionTurtleMT");
        EncryptionTurtleMT.encryptMT("HELLOHERO",10);
    }

} // End of public class EncryptionTurtleMT extends Turtle
