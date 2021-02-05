import java.util.*;
import java.io.*;

/* File: Similarity.java
 * Purpose: To determine how similar two texts are
 * Name: Chih-Hsuan Kao
 * Login: cs8bwagy
 * Email: c4kao@ucsd.edu
 * Date: Jan 21, 2018
 * Sources of Help: N/A
 **/

 /*
  * The Similarity Class contains methods that find the maximum and minimum
  * number of occurrences of each word, find the percent similarity, and 
  * determine if one is a subset to another
  **/
public class Similarity{
     public static void main(String[] args){
        WordCountList wc11 = new WordCountList();
        WordCountList wc22 = new WordCountList();
        WordCountList wclMax = new WordCountList();
        WordCountList wclMin = new WordCountList();
        double simVal = 0.0;
        
        try{
        wc11.getWordsFromFile(args[0]);
        wc22.getWordsFromFile(args[1]);
        wc11.removeCommon("inputFiles_DoNotSubmit/commonWords.txt");
        wc22.removeCommon("inputFiles_DoNotSubmit/commonWords.txt"); 
        } catch(IOException e) {
            e.printStackTrace();
        }

        wclMax = Similarity.findMax(wc11, wc22);
        wclMin = Similarity.findMin(wc11, wc22);
        simVal = Similarity.getSimilarity(wc11, wc22);
        

        System.out.println("simVal = " + simVal + "%");
        
        //print out warning if wc11 is subset of wc22
        if(Similarity.isStrictSubset(wc11,wc22)){
            System.out.println("Warning! "+args[1]+" is a subset of "
            +args[0]);
        }
        //print out warning if wc22 is subset of wc11
        else if(Similarity.isStrictSubset(wc22,wc11)){
            System.out.println("Warning! "+args[0]+" is a subset of "
            +args[1]);
        }
        System.out.println("The files have a "+simVal+" similarity.");

        boolean b = Similarity.isStrictSubset(wc11,wc22);
    }
     
     /* Method: findMax
      * This method find the maximum occurrence of each word between two 
      * wordCountLists a and b
      * @param WordCountList a and WordCountList b
      * @return WordCountList wcl
      **/ 
     public static WordCountList findMax(WordCountList a, WordCountList b){
         
         //create a WordCountList object wcl
         WordCountList wcl = new WordCountList();
         //loop through the words in a
         for(int i=0; i<a.getList().size(); i++){
             //get each word in a
             String wordInA = a.getList().get(i).getWord();
             //loop through the words in b
             for(int j=0; j<b.getList().size(); j++){
                 //get each word in b
                 String wordInB = b.getList().get(j).getWord();
                 //if word in a matches word in b (same word detected)
                 if(wordInA.equals(wordInB)){
                     int valueA = a.getList().get(i).getCount();
                     int valueB = b.getList().get(j).getCount();
                     int maxValue;
                     //compare the number of occurrence in two lists
                     //update the maxValue
                     if(valueA > valueB ){
                        maxValue = valueA;
                        WordCount wcObj1 = new WordCount(a.getList().get(i).getWord());    
                        wcObj1.setCount(maxValue);
                        wcl.getList().add(wcObj1);
                     } 
                     else {
                        maxValue = valueB;
                        WordCount wcObj2 = new WordCount(a.getList().get(i).getWord());    
                        wcObj2.setCount(maxValue);
                        wcl.getList().add(wcObj2);
                    }
                 }

             }
          }
          
          return wcl;

      }

     /* Method: findMin
      * This method find the minimum occurrence of each word between two 
      * wordCountLists a and b
      * @param WordCountList a and WordCountList b
      * @return WordCountList wcl
      **/ 
      public static WordCountList findMin(WordCountList a, WordCountList b){
         
         //create a WordCountList object wcl
         WordCountList wcl = new WordCountList();
         //loop through the words in a
         for(int i=0; i<a.getList().size(); i++){
             //get each word in a
             String wordInA = a.getList().get(i).getWord();
             //loop through the words in b
             for(int j=0; j<b.getList().size(); j++){
                 //get each word in b
                 String wordInB = b.getList().get(j).getWord();
                 //if word in a matches word in b (same word detected)
                 if(wordInA.equals(wordInB)){
                     int valueA = a.getList().get(i).getCount();
                     int valueB = b.getList().get(j).getCount();
                     int minValue;
                     //if value of A is bigger than value of B store A as max vice
                     //versa
                     if(valueA > valueB ){
                        minValue = valueB;
                        WordCount wcObj1 = new WordCount(a.getList().get(i).getWord());    
                        wcObj1.setCount(minValue);
                        wcl.getList().add(wcObj1);
                     }
                     // Store the value of B in Maxvalue
                     else {
                        minValue = valueA;
                        WordCount wcObj2 = new WordCount(a.getList().get(i).getWord());    
                        wcObj2.setCount(minValue);
                        wcl.getList().add(wcObj2);
                    }
                 }
             }
          }
          return wcl;
      }
      
     /* Method: getSimilarity
      * This method find the percent similarity between two documents
      * @param WordCountList a and WordCountList b
      * @return double sim
      **/ 
      public static double getSimilarity(WordCountList a, WordCountList b){
          WordCountList wclMax = new WordCountList();
          WordCountList wclMin = new WordCountList();
        
          wclMax = Similarity.findMax(a, b);
          wclMin = Similarity.findMin(a, b);
          int maxVal = 0;
          int minVal = 0;
          double sim = 0;

          //add up all of the value of Max
          for(int i=0; i<wclMax.getList().size(); i++){
              maxVal = wclMax.getList().get(i).getCount() + maxVal;    
          }

          //add up all of the value of Min
          for(int j=0; j<wclMin.getList().size(); j++){
              minVal = wclMin.getList().get(j).getCount() + minVal; 
          }
          System.out.println("maxValue = " + maxVal);
          System.out.println("minValue = " + minVal);
          sim = (minVal/(double)maxVal)*100;
          return sim;
      }
    
     /* Method: isStrictSubset
      * This method determines if one WordCountList is a subset of another
      * @param WordCountList a and WordCountList b
      * @return boolean: true if subset
      **/ 
      public static boolean isStrictSubset(WordCountList a, WordCountList b){
          String tempString = "";
          int count = 0;
          //outer for loop through the word in a
          for(int i=0; i<a.getList().size(); i++){
               tempString = a.getList().get(i).getWord();
               //inner for loop, comparing the word in a with words in b
               for(int j=0; j<b.getList().size(); j++){
                   //if word in a appears in b
                   if((b.getList().get(j).getWord()).equals(tempString)){
                        //increment the count by 1
                        count = count +1;
                   }
               }
          }
          //get the total word count in a
          int wordcountA = a.getList().size();

          //if every word in a appears in b, return true
          if(count == wordcountA){
              return true;
            //otherwise, return false
          } else {
              return false; 
          }
      }
}
