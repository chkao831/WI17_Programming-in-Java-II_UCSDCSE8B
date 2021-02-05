/* Starter Code by Hans Yuan WI 18 */
/**File: EncryptionTurtle
 * This file contains EncryptionTurtle class, which performs encryption and
 * creates new Turtle for each case.
 * Name: Chih-Hsuan Kao
 * Login: cs8bwagy
 * Email: c4kao@ucsd.edu
 * Date: Mar 8, 2018
 * Sources of Help: Tutorhours
 */
import turtleClasses.Turtle;
import turtleClasses.World;
import java.awt.*;
import java.util.*;

/**---Class Header---
 * The class EncryptionTurtle extends DrawingTurtle, which extends the Turtle
 * class. This class has capabilities of verifying if a string is valid,
 * performing encryption if string is valid with letter operation, creating new
 * world and calling the drawing method (with inheritance) to draw turtles.
 */ 
public class EncryptionTurtle extends DrawingTurtle {

    // DON'T CHANGE
    // The World is set with a width of 800 and height of 120
    public final static int WORLD_WIDTH = 800;
    public final static int WORLD_HEIGHT = 120;

    // CHANGE BACK TO 75 WHEN DONE
    public final static int DELAY = 75;

    // These constants may be helpful:
    public final static int CHAR_WIDTH = 40;
    public final static int LINE_PADDING = 40;
    public final static int CHAR_SPACE = CHAR_WIDTH + LINE_PADDING;

    //self-added pen width and pen color
    public final static int PEN_WIDTH = 8;
    public final static Color PEN_COLOR = Color.MAGENTA;

    /**
     * The only constructor that takes in (String, int)
     * pass each encrypted letter to the draw method
     * check legal string: if illegal use System.err.println()
     * @param String originalString: the string to be encrypted
     * @param int rotation: the amount of rotation to be performed
     */
    public EncryptionTurtle(String originalString, int rotation){
        //call super with a newly created world and delay
        super(new World(WORLD_WIDTH,WORLD_HEIGHT),DELAY);    

        //verifying validity of the parameter string
        if(validString(originalString)==false){
            System.err.println("Illegal String was passed in!");
        }

        //create a char array to catch each character after encryption
        char[] charArr = encrypt(originalString,rotation).toCharArray();
        int count = 0;
        //for each char, assign pen width and color and draw on the world
        for(char ch: charArr){
            setPenWidth(PEN_WIDTH);
            setPenColor(PEN_COLOR);
            draw(ch,LINE_PADDING+(count*CHAR_SPACE),LINE_HEIGHT/4);
            count ++;
        }
    }

    /**Method: validString
     * This method verifies if a string is valid
     * @param String rawInput: the string to be verified
     * @return boolean true: if the string content is valid (all upper cased)
     *                 false: otherwise
     */ 
    private boolean validString(String rawInput) {
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

    /**Method: encrypt
     * This method perform encryption by calling letterOperation with passed in
     * parameters character and amount of rotation
     * @param String originalStr: the original string to be encrypted
     * @param int rotation: the rotation by which the encryption is performed
     * @return String toBeReturned: an encrypted string
     */
    private String encrypt(String originalStr, int rotation) {
        //if String content is valid, perform encryption
        if(validString(originalStr) == true){
            String toBeReturned = new String();

            //iterate through each character
            for(int i = 0; i< originalStr.length(); i++){
                //catch each character
                char c = originalStr.charAt(i);
                //concat each encrypted characters
                toBeReturned = toBeReturned + letterOperation(c,rotation);
            } return toBeReturned;
        } return "";
    }

    /**Method: letterOperation
     * This method performs letter operation with the passed-in parameters: an
     * character and int rotation
     * @param char original: the character to be rotated
     * @param int rotation: the amount by which to rotate
     * @return char the encrypted character
     */ 
    private char letterOperation(char original, int rotation) {
        //if the value to be divided by 26 is non-negative
        if((original-65+rotation)>=0){
            original = (char)(((int)(original - 65 + rotation)) % 26 + 65 ); 
        }
        //otherwise, if negative
        else if((original - 65 + rotation)< 0){
            int w = 26 - ((Math.abs((int)(original-65+rotation)))%26);
            original = (char)((w%26)+65);
        }
        return original;
    }

    /**Method: Main method
     * Test cases are added here
     * to run encryption, will create a new turtle for each new case
     */ 
    public static void main(String[] args) {
        System.out.println("Hello, this is the Main method of EncryptionTurtle");
        EncryptionTurtle potato1 = new EncryptionTurtle("IMCAROLYN",-100);
    }

} // End of public class EncryptionTurtle extends Turtle
