/**---File Header---
 * File: CharacterNode.java
 * This file contains class CharacterNode, whose purpose is to hold chars and
 * pointers to the next char in the sequence of MyStringBuilder
 * Name: Chih-Hsuan Kao
 * Login: cs8bwagy
 * Email: c4kao@ucsd.edu
 * Date: Mar 9, 2018
 * Sources of Help: N/A
 */

/**---Class Header---
 * The class CharacterNode contains a private final char type named letter and a
 * public CharacterNode pointer named nextNode.
 */
public class CharacterNode{
    
    //two instance variables
    private final char letter;
    public CharacterNode nextNode;

    /**
     * One constructor that takes in a character
     * a char, initializing the instance char letter
     */ 
    public CharacterNode(char c){
        letter = c;
    }
    
    /**Method: getLetter
     * This is a getter method that returns the letter 
     * @param none
     * @return char letter: the letter of the CharacterNode
     */
    public char getLetter(){
        return this.letter;
    }

}
