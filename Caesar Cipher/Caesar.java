import java.io.*;
import java.util.*;

/** File: Caesar.java
 *  Name: Chih-Hsuan Kao, cs8bwagy
 *  Date: Jan 14, 2018.
 * */


public class Caesar {

 /**Created by Chih-Hsuan Kao, cs8bwagy
  * Method: encrypt
  * Purpose: To encrypt characters within a string 
  * Input: String s: the string to be passed into the method
  *         int rotation: rotational cipher that shift the characters
  * Output: String encryptedString
  */
 
 public static String encrypt(String s, int rotation) {
   //return null if the string passed in is null
   if ( s == null ) return null;
   //create a string object
   String encryptedString = new String();
   for (int i=0; i<s.length(); i++){
     //set character within the string object
     char c  = s.charAt(i);
     //concatenate the encrypted character to the string
     encryptedString = encryptedString + Caesar.letterOperation(c,rotation);
   }
 //return the string
 return encryptedString;
 }

 /**Created by Chih-Hsuan Kao, cs8bwagy
  * Method: decrypt
  * Purpose: To decrypt characters within a string 
  * Input: String s: the string to be passed into the method
  *        int rotation: rotational cipher that shift the characters
  * Output: String decryptedString
  */

 public static String decrypt(String s, int rotation) {
   //return null if the string is null
   if ( s == null ) return null; 
   //create a string object
   String decryptedString = new String();
   for (int i=0; i<s.length(); i++){
     //set character within string
     char c  = s.charAt(i); 
     //concatenate the decrypted character to the new string
     decryptedString = decryptedString + Caesar.letterOperation(c,(-1)*rotation);
   }
  //reutrn the string
  return decryptedString; 
 }

 /**Created by Chih-Hsuan Kao, cs8bwagy
  * Method: letterOperation 
  * Purpose: To perform character rotation, be called when encrypt/decrypt methods
  *          are used
  * Input: char a: the character that undergoes rotation
  *        int rotation: rotational cipher that shift the characters
  * Output: character a
  */

 private static char letterOperation(char a, int rotation) {
   //if the value of char a is upper case
   if(a>=65 && a<=90){
     //if the value to be divided by 26 is non-negative
     if((a-65+rotation)>=0){
       //rotate and get new value
       a = (char)(((int)(a- 65 + rotation)) % 26 + 65);
     }
     //if negative
     else if((a-65+rotation)<0){
       int w = 26-((Math.abs((int)(a-65+rotation)))%26);
       a = (char)(( w % 26) +65);
     }
   }
  //if lower case
   else if(a>= 97 && a<= 122){
     //if value to be divided by 26 is non-negative
     if((a-97+rotation)>=0){
       //rotate and get value
       a = (char)(((int)(a- 97 + rotation)) % 26 + 97);
     }
     //if negative
     else if((a-97+rotation)<0){
       int w = 26-((Math.abs((int)(a-97+rotation)))%26);
       a = (char)(( w % 26) +97);
     }
   }
   //if the character passed in is non-alphabetic
   else {a = a;}
  //return character a
  return a;
 }

/**Created by Chih-Hsuan Kao, cs8bwagy
  * Method: encryptTwo
  * Purpose: To encrypt characters within a string, using StringBuilder
  * Input: String s: the string to be passed into the method
  *        int rotation: rotational cipher that shift the characters
  * Output: String finalString
  */

 public static String encryptTwo(String s, int rotation) {
   //if string is null, return null
   if ( s == null ) return null; 
   //create a new StringBuilder object
   StringBuilder stringObj = new StringBuilder();
   //for loop to go through the string
   for (int i=0; i<s.length(); i++){
     //set character within the string
     char c = s.charAt(i);
     //concatenation
     stringObj.append(Caesar.letterOperation(c,rotation));
   }
   String finalString = stringObj.toString();
 //return the string
 return finalString;
 }

/**Created by Chih-Hsuan Kao, cs8bwagy
  * Method: decryptTwo
  * Purpose: To decrypt characters within a string,using StringBuilder 
  * Input: String s: the string to be passed into the method
  *        int rotation: rotational cipher that shift the characters
  * Output: String finalString
  */

 public static String decryptTwo(String s, int rotation) {
   //if string is null, return null
   if ( s == null ) return null; 
   //create a new StringBuilder object
   StringBuilder stringObj = new StringBuilder();
   for (int i=0; i<s.length(); i++){
     //character within string
     char c = s.charAt(i);
     //concatenation
     stringObj.append(Caesar.letterOperation(c,(-1)*rotation));
   }
   String finalString = stringObj.toString();
 //return the string
 return finalString;
 }
}
