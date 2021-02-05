import java.util.*;
import java.io.*;

/* File: WordCountList.java
 * Purpose: Contains several methods, mainly to read words from files, strip
 * out common words, sort and display words and get what words occur most
 * Name: Chih-Hsuan Kao
 * Login: cs8bwagy
 * Email: c4kao@ucsd.edu
 * Date: Jan 21, 2018
 * Sources of Help: Tutorhours
 **/

/*
 * The WordCountList Class uses ArrayList<WordCount> to store the words and
 * their corresponding counts
 **/ 
public class WordCountList {

    // The ArrayList to store the words and their associated counts
    ArrayList<WordCount> list;

    // construct the list
    public WordCountList() {
        list = new ArrayList<WordCount>();
    }

    public WordCountList(ArrayList<WordCount> list) {
        this.list = list;
    }

    /* Method: getWordsFromFile
     * This method populates the ArrayList containing WordCount objects for each
     * word in the file, and properly update the list
     * Name: Chih-Hsuan Kao, cs8bwagy
     * Date: Jan 21, 2018
     * @param String filename: input string
     * @return none
     **/
    public void getWordsFromFile( String filename ) throws IOException {
        //set boolean value for repetition use
        boolean repeat=false;
        //Construct a Scanner that reads in words from a file
        File sourceFile = new File(filename);
        Scanner input = new Scanner(sourceFile); 
        int num=1;

        //add words into list as long as there's word in the next
        while(input.hasNext()){
            String word = input.next();
            WordCount wcObj = new WordCount(word);

            //add default because of the first element
            if(list.size()==0){
                list.add(wcObj);
            }
            //from the second element
            else{
                String newWord = "";
                int first = (int)word.charAt(0);
                //if first letter is upper case, cast it to lower
                if( first <= 90 && first >= 65){  
                    char newChar = (char)(first+32);
                    //assign the cast word as the newWord
                    newWord = word.substring(1);
                    newWord = Character.toString(newChar).concat(newWord);
                }

                //if first letter is lower case, cast it to upper
                if( first>=97 && first<=122){
                    char newChar = (char)(first-32);
                    //assign the cast word as the newWord 
                    newWord=word.substring(1);
                    newWord = Character.toString(newChar).concat(newWord);
                }

                // check for repetition
                for (int i=0; i<list.size(); i++){
                    //if the original word or the cast-first-letter word have
                    //appeared in the list
                    if(word.equals(list.get(i).getWord()) 
                            || newWord.equals(list.get(i).getWord())){
                        int count = list.get(i).getCount();
                        //increment count by 1
                        count = count + 1; 
                        list.get(i).setCount(count);
                        repeat=true;
                        break;
                    }
                }
                //otherwise, add list element
                if(!repeat)
                {
                    list.add(wcObj);
                }
                //reset the repeat boolean
                repeat=false;
            }
        }
    }

    /* Method: getList
     * This method is an accessor method for the tester file. 
     * Name: Chih-Hsuan Kao, cs8bwagy
     * Date: Jan 21, 2018
     * @param none
     * @return ArrayList <WordCount> list: a returned ArrayList
     **/
    public ArrayList<WordCount> getList(){
        return list;
    }

    /* Method: removeCommon
     * This method removes any commonly used words from the list.  
     * Name: Chih-Hsuan Kao, cs8bwagy
     * Date: Jan 21, 2018
     * @param String omitFilename: common word file
     * @return none
     **/
    public void removeCommon( String omitFilename ) throws IOException {
        //Construct a Scanner to read file
        File sourceFile = new File(omitFilename);
        Scanner input = new Scanner(sourceFile);

        //remove all capitalized common words
        while(input.hasNext()){
            String word = input.next();
            String capital = "";
            //get the first character of the string
            int first = (int)word.charAt(0);
            //Make the lowercase char to uppercase
            char newChar = (char)(first-32);
            //trim the first character
            capital = word.substring(1);
            //Get the Capital common word
            capital = Character.toString(newChar).concat(capital);
            WordCount remElem;

            //check each elements and remove common words from the list
            for(int i=0; i<list.size(); i++){

                //remove capitalized common words
                if(capital.equals(list.get(i).getWord())){
                    remElem = list.remove(i);
                    break;
                }
            }  
        }
        //Read the word again to remove the lowercase common words
        //Construct a new Scanner to read
        File sourceFile2 = new File(omitFilename);
        Scanner input2 = new Scanner(sourceFile2);
        //remove all lowercase common words
        while(input2.hasNext()){
            String word = input2.next();
            WordCount remElem2;

            //check each elements and remove common words from the list
            for(int i=0; i<list.size(); i++){

                //remove noncapital common words
                if(word.equals(list.get(i).getWord())){
                    remElem2 = list.remove(i);
                    break;
                }
            }  
        }
    }

    /* Method: toString
     * This method takes the WordCounts and outputs the words and their counts
     * as a String
     * Name: Chih-Hsuan Kao, cs8bwagy
     * Date: Jan 21, 2018
     * @param none
     * @return String newString: a sorted string
     **/
    public String toString() {

        String newString="";
        for(int i=0; i<list.size(); i++){
            //create a new string with correct format
            newString = newString.concat(list.get(i).getWord())
            + "("+list.get(i).getCount()+")"+" ";
        }
        return newString;
    }

    /* Method: outputWords
     * This method takes in an ArrayList of WordCoutns and a boolean
     * printToFile. If true, output the arraylist of wordpair with their counts
     * to a file called myOutput.out ; if false, should print the arraylist of
     * wordpair with their counts on the console
     * Name: Chih-Hsuan Kao, cs8bwagy
     * Date: Jan 21, 2018
     * @param boolean printToFile
     * @return none
     **/
    public void outputWords(boolean printToFile) throws IOException{
        //if printToFile is false
        if(printToFile == false){
            String printString = "";
            //print the result of toString on the screen
            for(int i=0; i<list.size();i++){
                printString = printString.concat(list.get(i).getWord())
                + "(" +list.get(i).getCount() + ")" + " ";
            }
            System.out.println(printString);
        }
        //if printToFile is true
        if(printToFile == true){
            //Use FileOutputStream and PrintWriter to open a FileOutputStream and
            //assign a name myOutput.out to the file
            FileOutputStream fw = new FileOutputStream("myOutput.out");
            PrintWriter writer = new PrintWriter(fw);
            //convert list to String object with correct format
            String outputString = "";
            //loop through the whole list
            for(int i=0; i<list.size();i++){
                outputString = outputString.concat(list.get(i).getWord())
                + "(" +list.get(i).getCount() + ")" + " ";
            }
            //print a newline after concating all words in the outputString
            outputString = outputString.concat("\n");
            //prints the outputString to the file and terminates 
            writer.println(outputString);
            writer.flush();
            writer.close();
        }
    }

    /* Method: topNWords
     * This method finds the top n occurring words in the list with lengths >=
     * length and returns it as an ArrayList. In the evend of a tie, use the
     * first occurring word with that count. 
     * Name: Chih-Hsuan Kao, cs8bwagy
     * Date: Jan 21, 2018
     * @param integer n: the number of top n most occurring words
     * @return ArrayList<WordCount> topArray: a list with ranked elements
     **/
    public ArrayList<WordCount> topNWords(int n){
        ArrayList<WordCount> topArray = new ArrayList<WordCount>();
        //create variables for future use
        int currentMaxVal = 0;
        int currentMaxIndex = 0;
        int i=0;
        int j=0;
        int val=0;
        String rankedString="";

        //Check whether n is bigger than listsize()
        if (n>list.size()){
            //if bigger, set n equals listsize()
            n = list.size();
        }
        //outer nested for loop to get n top elements
        for(j=0; j<n; j++){
            //inner nested for loop to get max value
            for(i=0; i<list.size(); i++){
                val = list.get(i).getCount();
                //update the currentMaxVal when encountering bigger value
                if(val>currentMaxVal)
                {
                    currentMaxVal = val;
                    currentMaxIndex = i; 
                }
            }
            //put max in the return array
            topArray.add(list.get(currentMaxIndex));
            //once save the element, make the count negative so it won't be the
            //one with the highest rank again in the next round
            list.get(currentMaxIndex).setCount(0-currentMaxVal);
            //set currentMaxVale as negative to reset the value in next round
            currentMaxVal = 0-val;
        }
        //loop through the list and change the negative values to positive
        for(int k=0;k<list.size();k++){
            int value = list.get(k).getCount();
            if (value < 0) {
                list.get(k).setCount(0 - value);
            } 
        }
        return topArray;
    }
}
