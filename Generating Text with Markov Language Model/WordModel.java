/**---File Header---
 * File: WordModel.java
 * This file contains WordModel class, which contains methods to implement a
 * CharacterModel, a Markov Languange Model that is capable of training by
 * reading and remembering prefix+prediction combinations.
 * Name: Chih-Hsuan Kao
 * Login: cs8bwagy
 * Email: c4kao@ucsd.edu
 * Date: Feb 27, 2018
 * Sources of Help: Tutorhours and Textbook
 */
import java.util.HashMap;
import java.util.ArrayList;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**---Class Header---
 * The class WordModel contains methods to implement a Markov Language Model.
 * This class contains the following instance vairables: Hashmap predictionMap that has
 * key of ArrayList<String> type and value of another Hashmap; Hashmap cache
 * that has key of ArrayList<String> type and value of another
 * ArrayList<String>; integer degree to indicate the degree of a WordModel
 * object; a Random object to generate random values.
 */
public class WordModel {

    //instance variables
    protected HashMap<ArrayList<String>, HashMap<String, Integer>> predictionMap;
    protected HashMap<ArrayList<String>, ArrayList<String>> cache;
    protected int degree;
    protected Random random;

    /**
     * A Constructor that takes in an int degree
     * creates a WordModel object of degree based on the int passed in
     * @param int degree: the degree of the WordModel object
     */
    public WordModel (int degree) {
        //TODO
        this.predictionMap = new HashMap<ArrayList<String>,HashMap<String,Integer>>();
        this.cache = new HashMap<ArrayList<String>,ArrayList<String>>();
        this.degree = degree;
        this.random = new Random();
    }

    /**Method: incrementPrediction
     * This method increases the frequency of a prefix+prediction pair by 1
     * @param ArrayList<String> prefix: the key of the top level map
     * @param String prediction: the key of the bottom level map
     * @return none
     */
    public void incrementPrediction(ArrayList<String> prefix, String prediction){
        // TODO
        // if prefix exists in predictionMap
        if(predictionMap.containsKey(prefix)){
            //get its corresponding value (a HashMap type)
            //in the sub-HashMap, check if String prediction exists
            if(predictionMap.get(prefix).containsKey(prediction)){
                //get the current frequency corresponding the the string
                int freq = predictionMap.get(prefix).get(prediction);
                //increment by 1
                freq++;
                //update the frequency back to the HashMap
                predictionMap.get(prefix).put(prediction,freq);
            } else {
                //otherwise, put prediction as a new Key 
                //and set its value to 1
                predictionMap.get(prefix).put(prediction,1);
            }
        } else {
            //otherwise, create a new map, put prediction as a key in the new
            //map, and set its value to 1
            HashMap<String,Integer> newMap = new HashMap<String,Integer>();
            newMap.put(prediction,1);
            //put prefix as a key and set its value to the new HashMap
            predictionMap.put(prefix,newMap);
        }
    }

    /**Method: trainFromText
     * This method trains the model by reading the text word-by-word, 
     * while incrementing frequencies of occurring prefix+prediction pairs in
     * the HashMaps
     * @param String content: a string containing the entire training text
     * @return int totalWords: how many words are read from the file
     */ 
    public int trainFromText(String content) {
        // TODO
        //construct a scanner that read in words from String content
        Scanner input = new Scanner(content);
        //create an arraylist of string to store all words first
        ArrayList<String> wholeList = new ArrayList<String>();
        while(input.hasNext()){
            wholeList.add(input.next().toLowerCase());
        }
        //get the number of elements in the arraylist
        int totalWords = wholeList.size();

        //loop from degree+1 word to the end of list
        //repeat until there are no more words to be read
        for(int i = this.degree; i<totalWords; i++){
            //create a small list to catch [degree] words 
            ArrayList<String> subList = new ArrayList<String>();
            for(int j=0; j < this.degree; j++){
                subList.add(wholeList.get(i- this.degree + j));
            }
            //after creating the small String ArrayList, 
            //call incrementPrediction method using the small list as prefix
            //and the next word after that as the prediction
            incrementPrediction(subList,wholeList.get(i));
        }
        //return how many words are read from the file
        return totalWords;
    }

    /**Method: getFlattenedList
     * This method constructs a flattened list, add it to the cache and returns
     * the list 
     * @param ArrayList<String> prefix: a list of degree words that comes
     * immediately before the prediction word
     * @return ArrayList<String> the flattened list 
     */ 
    public ArrayList<String> getFlattenedList(ArrayList<String> prefix){
        // TODO
        //first check whether prefix already exists in cache
        if(cache.containsKey(prefix)){
            //if contained, directly return the value
            return cache.get(prefix);
        }
        else{
            //if not, construct a flattened list
            ArrayList<String> flattened = new ArrayList<String>();
            //Create a set of string to get all keys from the sub-HashMap
            //for each loop to loop through each key
            for(String key: predictionMap.get(prefix).keySet()){
                //get the value (int count) of the key
                int count = predictionMap.get(prefix).get(key);
                //and add to the flattened list based on the count
                for(int i=0; i<count; i++){
                    flattened.add(key);
                }
            }
            //After the construction of flattened list
            //add the prefix and the list to the cache and return the list
            cache.put(prefix,flattened);
            return flattened;
        }
    }

    /**Method: generateNext
     * This method gets a flattened list of words associated with the specified
     * prefix and then randomly returns a word from the list
     * @param ArrayList<String> prefix: a list of degree words that comes
     * immediately before the prediction word
     * @return a word that the model predicts based on the prefix 
     */ 
    public String generateNext(ArrayList<String> prefix) {
        //create a new string arraylist
        ArrayList<String> list = new ArrayList<String>();

        //reference to the flattened list corresponding to the prefix
        list = getFlattenedList(prefix);

        //get the size of the flattend list
        int amount = list.size();
        //Create a random integer based on the flattend list size
        int randomIndex = this.random.nextInt(amount);

        //randomly return a word from the list
        return list.get(randomIndex);
    }

    /**Method: generate
     * This method randomly selects a prefix from all available prefixes, and
     * generates the next word until there are [count] words generated
     * @param int count: how many words to be generated
     * @return a String that contains [count] words
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

        //if the words to be generated is equal to or less than zero
        //cannot be generated
        if (count <= 0){
            return " ";
        }

        //if the degree of word is bigger than or equal to count
        else if(this.degree >=  count){

            //ArrayList to Array Conversion
            String str = new String();
            for(int j = 0; j < degree; j++){
                str = str.concat(firstPrefix.get(j));
                str = str.concat(" ");
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
            //call generateNext first to construct first word after the
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
                //add space between words
                toReturn = toReturn + " ";
            }
            return toReturn;
        }  
    }

    /** return reference to predictionMap */
    public HashMap<ArrayList<String>, HashMap<String, Integer>> getPredictionMap() {
        return this.predictionMap;
    }

    /* return reference to cache */
    public HashMap<ArrayList<String>, ArrayList<String>> getCache(){
        return this.cache;
    }

    /* return a reference to the random object */
    public Random getRandom(){
        return this.random;
    }

    /* return the degree */
    public int getDegree(){
        return this.degree;
    }


    /* provided for debug purposes,
       but really, provided so students can look at how to iterate HashMap */ 
    public void printMap(){

        /* for each key (prefix) in predictionMap, 
           print prefix, print all predictions with counts */
        for(ArrayList<String> prefix: predictionMap.keySet()){
            System.out.println("Prefix: " + prefix + ":");

            HashMap<String, Integer> freqMap = predictionMap.get(prefix);
            /* for each key (prediction) in the subsequen HashMap, 
               print prediction, print count */
            for (String prediction: freqMap.keySet()){
                System.out.printf("\tPrediction: \"%s\"   Count: %d\n", 
                        prediction, freqMap.get(prediction));           
            }
        }       
    }

}
