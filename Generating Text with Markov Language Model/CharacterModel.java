/**---File Header---
 * File: CharacterModel.java
 * This file contains CharacterModel class, which extends WordModel class. This
 * class contains extends most method from WordModel class with overridden
 * methods trainFromText and generate to make a Markov Language Model that can
 * process at the character level. This model is capable of training by reading
 * and remembering prefix+prediction combinations.
 * Name: Chih-Hsuan Kao
 * Login: cs8bwagy
 * Email: c4kao@ucsd.edu
 * Date: Mar 4, 2018
 * Sources of Help: Tutorhours
 */
import java.util.HashMap;
import java.util.ArrayList;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**---Class Header---
 * The class CharacterModel extends WordModel. It inherits the level of degree
 * from its superclass to its constructor. It also inherits other methods that
 * increments prediction, creates a flattened list, etc. This class contains
 * overriden methods including trainFromText, which trains the model by reading
 * the text character by character, and method generate, which randomly selects
 * a prefex and generates the next character. 
 */
public class CharacterModel extends WordModel {

    /**
     * A constructor that inherits the degree from its superclass
     */
    public CharacterModel (int degree) {
        super(degree);
    }

    /**Method: trainFromText
     * This method trains the model by reading the text char by char, 
     * while incrementing frequencies of occurring prefix+prediction pairs in
     * the HashMaps
     * @param String content: a string containing the entire training text
     * @return int totalWords: how many words are read from the file
     */ 
    public int trainFromText(String content) {
        // get total number of characters in the string containing the entire
        // training text
        String lowered = new String();
        lowered = content.toLowerCase();

        //calculate the total number of characters read
        int totalChars = lowered.length();

        //loop from degree+1 char to the end of string
        //repeat until there are no more chars to be read
        for(int i = this.degree; i<totalChars; i++){

            //create a small list to catch [degree] chars 
            ArrayList<String> subList = new ArrayList<String>();
            for(int j=0; j < this.degree; j++){

                subList.add(Character.toString(lowered.charAt(i-this.degree+j)));
            }
            //after creating the small String ArrayList, 
            //call incrementPrediction method using the small list as prefix
            //and the next character after that as the prediction
            incrementPrediction(subList,Character.toString(lowered.charAt(i)));
        }
        //return how many words are read from the file
        return totalChars;
    }

    /**Method: generate
     * This method randomly selects a prefix from all available prefixes, and
     * generates the next character until there are [count] characters generated
     * @param int count: how many characters to be generated
     * @return a String that contains [count] characters
     */ 
    public String generate(int count) {
        //get all the keys in predictionMap into an ArrayList keys
        ArrayList<ArrayList<String>> keys
            = new ArrayList<ArrayList<String>>(predictionMap.keySet());

        //randomly select a prefix from prefixes
        int ram = keys.size();
        //generate the first prefix randomly from all available prefixes
        int randomCount = this.random.nextInt(ram);
        ArrayList<String> firstPrefix = keys.get(randomCount);

        //if the characters to be generated is equal to or less than zero
        //we cannot generate
        if (count <= 0){
            return " ";
        }

        //if the degree of character is bigger than or equal to count
        else if(this.degree >=  count){

            //return [degree] character
            //ArrayList to Array Conversion
            String str = new String();
            //get [degree] number of characters
            for(int j = 0; j < degree; j++){
                str = str.concat(firstPrefix.get(j));
            }
            return str;
        }

        //else, if the degree of word is smaller than count
        else {

            //perform deep copy to copy the first prefix to the new arraylist
            ArrayList<String> predictedWords = new ArrayList<String>();
            predictedWords.addAll(firstPrefix);

            //use a local integer to count how many words to add
            int remained = count - predictedWords.size();                
            //call generateNext first to construct first character after the
            //first prefix
            String newWord = new String();
            newWord = generateNext(firstPrefix);
            //add the newly constructed string to predictedWords
            predictedWords.add(newWord);
            remained = remained - 1;


            //if not yet reached count, keep adding
            while(remained > 0){
                //create a small arraylist to store new prefix
                ArrayList<String> newPrefix = new ArrayList<String>();

                //get the size of the current predictedWords arraylist
                //and construct new prefix based on degree
                int length = predictedWords.size();
                newPrefix = new ArrayList<String>
                    (predictedWords.subList(length-this.degree,length));

                //add the next string predicted by new prefix to update
                //predictedWords arraylist
                predictedWords.add(generateNext(newPrefix));
                //decrement count by 1 after adding new string
                remained = remained - 1;
            }

            //construct final string to be returned
            String toReturn = new String();
            for(int k=0; k<predictedWords.size(); k++){
                toReturn = toReturn.concat(predictedWords.get(k));
            }
            return toReturn;
        }  
    }

}
