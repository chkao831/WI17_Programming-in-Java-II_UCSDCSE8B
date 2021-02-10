/* Name: Chih-Hsuan Kao
 * Login: cs8bwagy
 * Date:  January 14, 2018
 * File:  CaesarTester.java 
 * Sources of Help: Tutorhours
 * Tests Caesar.java using basic strings and rotation values. 
 */


/*
 * Name:    CaesarTester
 * Purpose: To test Caesar.java for correct output.
 */
public class CaesarTester {

 /*
  * Name:       main
  * Purpose:    To call methods in Caesar and test them
  * Parameters: String[] args - command line arguments that are unused
  * Return:     void
  */
 public static void main(String[] args) {

  /** The main method. THIS IS WHERE YOU SHOULD ADD MORE TESTS
   * FOR encrypt and decrypt methods AND ANY OTHER METHOD
   * THAT YOU CREATE. BE SURE TO TEST YOUR CODE THOROUGHLY
   **/

  //The Caesar Cipher Tests
  int failCases = 0;

  //Test 1
  String message1 = "When in the course of human events it becomes necessary for one people to" + 
" dissolve the political bands which have connected them with another and to"+
" assume among the powers of the earth the separate and equal station to"+
" which the laws of nature and of nature's God entitle them a decent respect"+
" to the opinions of mankind requires that they should declare the causes"+
" which impel them to the separation.";
  String encryptedAnswer = "Nyve ze kyv tflijv fw yldre vmvekj zk svtfdvj evtvjjrip " +
  "wfi fev gvfgcv kf uzjjfcmv kyv gfczkztrc sreuj nyzty yrmv tfeevtkvu kyvd nzky refkyvi" + 
  " reu kf rjjldv rdfex kyv gfnvij fw kyv vriky kyv jvgrirkv reu vhlrc jkrkzfe kf nyzty " + 
  "kyv crnj fw erkliv reu fw erkliv'j Xfu vekzkcv kyvd r uvtvek ivjgvtk kf kyv fgzezfej fw" + 
  " drebzeu ivhlzivj kyrk kyvp jyflcu uvtcriv kyv trljvj nyzty zdgvc kyvd kf kyv jvgrirkzfe.";
  String encrypted1 = Caesar.encrypt(message1, 17);

  if (!encryptedAnswer.equals(encrypted1)) {
   System.out.println("Test 1 Failed(encryption for Part A)");
   System.out.println("Given message to encrypt is: " + message1);
   System.out.println("Your Answer is: " + encrypted1);
   System.out.println("The correct answer is: " + encryptedAnswer);
   failCases++;
  } else {
   System.out.println("Test 1 Passed!\n");
  }

  //Test 2
  String encrypted2 = "Byffi yhwlsjncih qilfx, byffi yhwlsjncih qilfx";
  String messageAnswer = "Hello encryption world, hello encryption world";
  String message2 = Caesar.decrypt(encrypted2, -58);

  if (!messageAnswer.equals(message2)) {
   System.out.println("Test 2 Failed(decryption for Part A)");
   System.out.println("Given message to decrypt is: " + encrypted2);
   System.out.println("Your Answer is: " + message2);
   System.out.println("The correct answer is: " + messageAnswer);
   failCases++;
  } else {
   System.out.println("Test 2 Passed!\n");
  }

  //Test 3
  encrypted1 = Caesar.encryptTwo(message1, 17);

  if (!encryptedAnswer.equals(encrypted1)) {
   System.out.println("Test 3 Failed(encryption for Part B)");
   System.out.println("Given message to encrypt is: " + message1);
   System.out.println("Your Answer is: " + encrypted1);
   System.out.println("The correct answer is: " + encryptedAnswer);
   failCases++;
  } else {
   System.out.println("Test 3 Passed!\n");
  }

  //Test 4
  message2 = Caesar.decryptTwo(encrypted2, -58);

  if (!messageAnswer.equals(message2)) {
   System.out.println("Test 4 Failed(decryption for Part B)");
   System.out.println("Given message to decrypt is: " + encrypted2);
   System.out.println("Your Answer is: " + message2);
   System.out.println("The correct answer is: " + messageAnswer);
   failCases++;
  } else {
   System.out.println("Test 4 Passed!\n");
  }

  //Messages that print whether tests were successful or not
  if (failCases == 0) {
   System.out.println("All Tests Passed!");
  } else {
   System.out.println("Number of Failed Test Cases : " + failCases);
  }

 /*
  * Name:       My Own Test for Part A Encryption
  * Purpose:    To call methods in Caesar and test them - Method used: Part A Encryption
  * Parameters: String[] args - command line arguments that are unused
  * Return:     void
  */

 String myEncryptedMessage = "Financial Accounting is a highly-stylized " +
 "Information System formulated as a system of simultaneous equations, "+
 "organized around the fundamental accounting Equation: "+
 "Assets = Liabilities + Equity.";
 String myEncryptedAnswer = "Hkpcpekcn Ceeqwpvkpi ku c jkijna-uvankbgf "+
 "Kphqtocvkqp Uauvgo hqtowncvgf cu c uauvgo qh ukownvcpgqwu gswcvkqpu, "+
 "qticpkbgf ctqwpf vjg hwpfcogpvcn ceeqwpvkpi Gswcvkqp: "+
 "Cuugvu = Nkcdknkvkgu + Gswkva.";

 String myEncryptedResult = Caesar.encrypt(myEncryptedMessage, 2);

 if (!myEncryptedAnswer.equals(myEncryptedResult)) {
   System.out.println("Test 1 Failed(encryption for Part A)");
   System.out.println("Given message to encrypt is: " + myEncryptedMessage);
   System.out.println("Your Answer is: " + myEncryptedResult);
   System.out.println("The correct answer is: " + myEncryptedAnswer);
   } else {
   System.out.println("My Test Passed for encryption for Part A. Yayyy!\n");
 }

 /*
  * Name:       My Own Test for Part A Decryption
  * Purpose:    To call methods in Caesar and test them - Method used: Part A Decryption
  * Parameters: String[] args - command line arguments that are unused
  * Return:     void
  */

 String myDecryptedResult = Caesar.decrypt(myEncryptedAnswer, 2);

 if (!myEncryptedMessage.equals(myDecryptedResult)) {
   System.out.println("Test 2 Failed(decryption for Part A)");
   System.out.println("Given message to decrypt is: " + myEncryptedAnswer);
   System.out.println("Your Answer is: " + myDecryptedResult);
   System.out.println("The correct answer is: " + myEncryptedMessage);
   } else {
   System.out.println("My Test Passed for decryption for Part A. Yayyy!\n");
 }
}
}
