import java.io.*;
import java.util.*;

/* Filename: WordCountListTester.java
 * Purpose: This is a tester file for WordCountList.java
 * Name: Chih-Hsuan Kao
 * Login: cs8bwagy
 * Email: c4kao@ucsd.edu
 * Date: Jan 18, 2018
 * Sources of Help: Tutorhours
 **/

/*
 *The WordCountListTester Class is a tester file for WordCountList.java; it contains 
 *main method, unit testers for methods in WordCountList.java, etc. 
 **/
public class WordCountListTester {

    /** Methods: */

    /* main method */
    public static void main(String[] args) throws IOException {
        WordCountListTester wct = new WordCountListTester();

        //This tester uses the command line. That's why the args are passed to the method
        wct.providedTester(args);

        /* The following tester are for local files' unit testers*/

        //wct.A1UnitTester(args[0]);
        //wct.B1UnitTester(args[0],args[1]);
        //wct.C1UnitTester(args[0]);
        //wct.D1UnitTester(args[0]);
        //wct.C2UnitTester(args[0]);
        //wct.myNewTester(args[0],args[1]);

    } // End Main Method

    /*
     * This is a unit tester to test the method getWordsFromFile
     */
    public static void A1UnitTester(String fileName) throws IOException {
        //Create a new instance of a WordCountList object
        WordCountList wcl = new WordCountList();
        //Load the words from a file that I created
        wcl.getWordsFromFile(fileName);

        String correctWord1 = "Hello"; 
        int correctCount1 = 3; 
        String correctWord2 = "World";
        int correctCount2 = 2;
        String correctWord3 = "PSA2";
        int correctCount3 = 1; 
        String correctWord4 = "Java";
        int correctCount4 = 4;

        System.out.println("Running tests using Exception.");

        if(!correctWord1.equals(wcl.getList().get(0).getWord())){
            throw new IOException("First word test failed");
        }
        if(correctCount1!=(wcl.getList().get(0).getCount())){
            throw new IOException("First count test failed");
        }
        if(!correctWord2.equals(wcl.getList().get(1).getWord())){
            throw new IOException("Second word test failed");
        }
        if(correctCount2!=(wcl.getList().get(1).getCount())){
            throw new IOException("Second count test failed");
        }
        if(!correctWord3.equals(wcl.getList().get(2).getWord())){
            throw new IOException("Third word test failed");
        }
        if(correctCount3!=(wcl.getList().get(2).getCount())){
            throw new IOException("Third count test failed");
        }
        if(!correctWord4.equals(wcl.getList().get(3).getWord())){
            throw new IOException("Fourth word test failed");
        }
        if(correctCount4!=(wcl.getList().get(3).getCount())){
            throw new IOException("Fourth count test failed");
        }
        System.out.println("All test in A1 passed!");
    }

    /*
     * This is a unit tester for method removeCommon
     */
    public static void B1UnitTester(String fileName, String ComFile) throws IOException{
        //create a new instance of a WordCountList object
        WordCountList wcl2 = new WordCountList();
        //update the arraylist containing WordCount objects
        wcl2.getWordsFromFile(fileName);
        //Remove common words using a file that I created
        wcl2.removeCommon(ComFile);

        String remainedWord1 = "World";
        String remainedWord2 = "CSE8B";
        String remainedWord3 = "PSA2";

        if(!remainedWord1.equals(wcl2.getList().get(0).getWord())){
            throw new IOException("First remaining word is wrong");
        }
        if(!remainedWord2.equals(wcl2.getList().get(1).getWord())){
            throw new IOException("Second remaining word is wrong");
        }
        if(!remainedWord3.equals(wcl2.getList().get(2).getWord())){
            throw new IOException("Third remaining word is wrong");
        }

        System.out.println("All test in B1 passed!");
    }

    /*
     * This is a unit tester for method toString
     */
    public static void C1UnitTester(String fileName) throws IOException {
        //Create a new instance of a WordCountList object
        WordCountList wcl3 = new WordCountList();
        //update the arraylist containing WordCount objects
        wcl3.getWordsFromFile(fileName);

        String StringComb = "Hello(3) World(1) CSE8B(1) PSA2(2) Java(1) ";
        System.out.println(wcl3.toString());

        if(!StringComb.equals(wcl3.toString())){
            throw new IOException("This string is wrong");
        }
        System.out.println("All test in C1 passed!");

    }

    /*
     * This is a unit tester for method outputWords
     */
    public static void C2UnitTester(String fileName) throws IOException {
        //Create a new instance of a WordCountList object
        WordCountList wclc2 = new WordCountList();
        //update the arraylist containing WordCount objects
        wclc2.getWordsFromFile(fileName);
        //Call method outputWords, pass in true or false to see result
        wclc2.outputWords(true);
    }

    /*
     * This is a tester for method TopNWords
     */
    public static void D1UnitTester(String fileName) throws IOException {
        //Create a new instance of a WordCountList object
        WordCountList wcl4 = new WordCountList();
        //update the arraylist containing WordCount objects
        wcl4.getWordsFromFile(fileName);

        String correctWord1 = "Hello"; 
        int correctCount1 = 3; 
        String correctWord2 = "PSA2";
        int correctCount2 = 2;
        String correctWord3 = "World";
        int correctCount3 = 1; 
        String correctWord4 = "CSE8B";
        int correctCount4 = 1;

        System.out.println("Running tests using Exception.");

        if(!correctWord1.equals(wcl4.topNWords(4).get(0).getWord())){
            throw new IOException("First word test failed");
        }
        if(correctCount1!=(wcl4.topNWords(4).get(0).getCount())){
            throw new IOException("First count test failed");
        }
        if(!correctWord2.equals(wcl4.topNWords(4).get(1).getWord())){
            throw new IOException("First word test failed");
        }
        if(correctCount2!=(wcl4.topNWords(4).get(1).getCount())){
            throw new IOException("First count test failed");
        }
        if(!correctWord3.equals(wcl4.topNWords(4).get(2).getWord())){
            throw new IOException("First word test failed");
        }
        if(correctCount3!=(wcl4.topNWords(4).get(2).getCount())){
            throw new IOException("First count test failed");
        }
        if(!correctWord4.equals(wcl4.topNWords(4).get(3).getWord())){
            throw new IOException("First word test failed");
        }
        if(correctCount4!=(wcl4.topNWords(4).get(3).getCount())){
            throw new IOException("First count test failed");
        }

        System.out.println("The D1 Result is" + wcl4.topNWords(4)); 
        System.out.println("All test in D1 passed!");
    }

    /*
     * This is the tester for files: hoop.txt and hoopc.txt
     */
    public static void myNewTester(String fileName, String ComFile) throws IOException{
        //create a new instance of a WordCountList object
        WordCountList wc11 = new WordCountList();
        //update the arraylist containing WordCount objects
        wc11.getWordsFromFile(fileName);

        //Remove common words using
        //a file that I created
        wc11.removeCommon(ComFile);
        System.out.println(wc11.getList().get(0).getWord());
        System.out.println(wc11.getList().get(0).getCount());
        System.out.println(wc11.getList().get(1).getWord());
        System.out.println(wc11.getList().get(1).getCount());
    } 

    /** Write more unit tests above this provided tester */ 
    public static void providedTester(String[] args) throws IOException {

        if (args.length == 0) {
            System.out.println("Skipping provided tester because no arguments were given!");
            return;
        }

        // Command line usage:
        // java WordCloudTester nameOfInputFile.txt numberOfTopNWords {console|file} {length|char} {value}

        // init the word clound
        WordCountList w = new WordCountList();
        System.out.println("Reading in File: " + args[0]);
        w.getWordsFromFile(args[0]);

        System.out.println("Removing common words");
        w.removeCommon("inputFiles_DoNotSubmit/commonWords.txt");

        // get the input number of words you want
        int numberOfTopNWords = Integer.parseInt(args[1]);

        // condition ? a : b => if (condition == true) then a else b
        // parse the second argument to check if it is printToFile or not
        boolean printToFile = args[2].charAt(0) == 'f' ? true : false;
        // parse the third argument to check if it is filter by lengh or not

        System.out.println("Printing the top " + numberOfTopNWords + " words " + (printToFile == true ?
                    " in file a named myOutput.out" : " on console"));


        WordCountList w2 = new WordCountList(w.topNWords(numberOfTopNWords));
        w2.outputWords(printToFile);

    }
}
