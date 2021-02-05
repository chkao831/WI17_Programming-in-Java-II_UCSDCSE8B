/**---File Header---
 * File: MyStringBuilder.java
 * This file contains methods that implement sequences of characters by
 * modifying the data structure internally. 
 * Name: Chih-Hsuan Kao
 * Login: cs8bwagy
 * Email: c4kao@ucsd.edu
 * Date: Mar 9, 2018
 * Sources of Help: Tutorhours
 */

/**---Class Header---
 * The class MyStringBuilder has capabilities of appending a letter to the end
 * of the stringbuilder, output it as a string, output the length, insert a
 * letter in between, delete a range of characters, and compare it with other
 * objects. There is no constructor and there is only one instance variable: a
 * CharacterNode object called firstNode that is a pointer to the first node.
 */
public class MyStringBuilder{

    //only one field variable: a pointer to the first node
    public CharacterNode firstNode;

    /**Method: append
     * This method appends a char to the end of MyStringBuilder
     * @param char addingChar: the letter of the newly created characterNode
     * @return none
     */
    public void append(char addingChar){
        //if MyStringBuilder is empty
        //the firstNode points to a new CN object that contains the addingChar
        if(firstNode==null){
            CharacterNode cn = new CharacterNode(addingChar);
            firstNode = cn;
        }
        //otherwise, traverse through all nodes until arrive at the last node
        else{
            CharacterNode currNode = firstNode;
            while(currNode.nextNode!=null){
                currNode = currNode.nextNode;
            }
            //when reached the last CN object
            //create a new CN object with letter [addingChar]
            CharacterNode cn = new CharacterNode(addingChar);
            //make the nextNode of the last node point to the new object
            currNode.nextNode = cn;
        }
    }

    /**Method: toString
     * This method takes the sequence of CharacterNodes and turns the sequence
     * of chars into a String
     * @param none
     * @return String toBeReturned: the content of the sequence
     */
    public String toString(){
        //check if the firstNode is empty
        if(firstNode == null){
            System.out.println("MyStringBuilder is empty!");
            return " ";
        }
        //if not empty
        //let the currNode firstly point to the first CN object
        CharacterNode currNode = firstNode;

        //initialize a string that catched each character
        String toBeReturned = new String();

        //catches the letter contained by each CN object
        //let currNode point to the next node if there's next
        while (currNode.nextNode!=null){

            char currChar = currNode.getLetter();
            toBeReturned = toBeReturned.concat(Character.toString(currChar));
            currNode = currNode.nextNode;

        }

        //now pointing to the last CN object
        //concat its letter
        toBeReturned
            = toBeReturned.concat(Character.toString(currNode.getLetter()));

        //return the whole string
        return toBeReturned;
    }

    /**Method: length
     * This method outputs the length of the data structure
     * @param none
     * @return int currCount: the number of nodes counted
     */
    public int length(){

        //if MyStringBuilder is empty
        //return 0
        if(firstNode == null){
            return 0;
        }

        //otherwise, let the currNode point to the first CN object
        CharacterNode currNode = firstNode;
        //initialize the count to be 1 because this is the first character
        int currCount = 1;

        //if there's next, point to the next and increment the count
        while(currNode.nextNode!=null){

            currNode = currNode.nextNode;
            currCount++;

        }
        //return the count
        return currCount;
    }

    /**Method: insert
     * This method insert a char at the position offset (with valid offset
     * value)
     * if offset value is not valid, an exception would be thrown with message
     * @param int offset: the position to insert a char
     * @param char insertChar: the character to insert
     * @return none
     */
    public void insert(int offset, char insertChar) 
            throws IndexOutOfBoundsException{

            //throw exception if StringBuilder is empty but offset is nonzero
            if(firstNode == null){
                if(offset != 0){
                    throw new IndexOutOfBoundsException("offset should be zero "+
                            "to insert because this SB is empty!");
                }

                //good case 1: if empty, offset is 0, insert the letter
                else{
                    CharacterNode onlyNode = new CharacterNode(insertChar);
                    firstNode = onlyNode;
                }
            }

            //otherwise, if MyStringBuilder is not empty
            else{

                //good case 2: if not empty, but offset is 0,
                //insert it in front of first node
                if(offset ==0){

                    CharacterNode newFirstNode = new CharacterNode(insertChar);
                    CharacterNode toBeSecond = firstNode;
                    firstNode = newFirstNode;
                    newFirstNode.nextNode = toBeSecond;

                }

                //if not empty, but offset value goes out of bound
                //throws exception message
                else if(offset<0 || offset>this.length()){
                    throw new IndexOutOfBoundsException("invalid offset value!");

                }

                //good case 3: if not empty, and offset is within range
                else{

                    //currNode now points to the firstNode
                    //currently at the 0th index
                    int count = 0;
                    CharacterNode currNode = firstNode;

                    while(count < offset-1){
                        currNode = currNode.nextNode;
                        count++;
                    }
                    if(count == offset-1){
                        CharacterNode cn = new CharacterNode(insertChar);
                        CharacterNode temp = currNode.nextNode;
                        currNode.nextNode = cn;
                        cn.nextNode = temp;
                    }
                }
            }
    }

    /**Method: delete
     * This method deletes a subsequence of characters from MyStringBuilder
     * throws an exception with an error message if the parameters go out of
     * bound
     * @param int start: deletion starts at position start
     * @param int end: deletes up to (but not including) this position
     * @return none
     */
    public void delete(int start,int end) throws StringIndexOutOfBoundsException{

        if(firstNode == null){
            throw new StringIndexOutOfBoundsException("Nothing to delete!");
        }
        if(start<0 || end<0){
            throw new StringIndexOutOfBoundsException("indices should be " +
                    "nonnegative!");
        }
        else if(start > end){
            throw new StringIndexOutOfBoundsException("start should not "+
                    "be greater than end!");
        }
        else if(start >= this.length()){
            throw new StringIndexOutOfBoundsException("exceeds the last "+
                    "position!");
        }
        else{
            //considering normal case
            if(start == end){
                //do nothing and return
                return;
            }
            //otherwise, if start is smaller than end within reasonable range
            else {
                //if the start index is zero, change the firstNode pointer
                if(start == 0){
                    //if start is 0 and end is equal to
                    //or greater than length(), delete whole sequence
                    if(end >= this.length()){
                        firstNode = null;
                    }

                    //if start is 0 and end is strictly less than length()
                    //let the [end] node be the first node
                    else{
                        int currCount = 0;
                        CharacterNode currNode = firstNode;
                        //traverse down until reach [end] index
                        while(currCount < end){
                            currNode = currNode.nextNode;
                            currCount++;
                        }
                        //let the firstNode be the currNode
                        firstNode = currNode;
                    }
                }
                //if start is smaller than end, within range,
                //and if the start index is not zero
                else{
                    //to void NullPointerException, if end is greater than
                    //length, set it to length before start traversing
                    while(end > this.length()){
                        end--;
                    }

                    int currCount = 0;
                    CharacterNode currNode = firstNode;
                    //traverse down 
                    while(currCount < (start-1)){
                        currNode = currNode.nextNode;
                        currCount++;
                    }
                    if(currCount == (start-1)){
                        int endCount = start;
                        //create a new CN object to find the end position of
                        //deletion
                        CharacterNode newNode = currNode.nextNode;
                        while(endCount < end){
                            newNode = newNode.nextNode;
                            endCount++;
                        }
                        currNode.nextNode = newNode;
                    }
                }
            }
        }
    }

    /**Method: equals
     * This method does a char-by-char check between the calling object and the
     * other object (either String, or MyStringBuilder, or something
     * uncomparable)
     * @param Object other: other other object to be compared with the calling
     *                      object
     * @return boolean true: if both have exactly same sequence of characters
     *                 false: otherwise
     */
    public boolean equals(Object other){

        //if the object is instanceof MyStringBuilder 
        //compare its content with the calling object
        if(other instanceof MyStringBuilder){

            MyStringBuilder oth = (MyStringBuilder)other;

            //return true if both are empty MSB
            if(this.firstNode==null && oth.firstNode==null){
                System.out.println("Both are empty MyStringBuilder!");
                return true;
            }

            //if different length, return false
            if(this.length() != oth.length()){
                return false;
            }
            //if same length, check content char-by-char
            else{
                CharacterNode otherNode = oth.firstNode;
                CharacterNode thisNode = this.firstNode;
                int count = 1;

                //compare the first letter
                //return false if different
                if(otherNode.getLetter()!=thisNode.getLetter()){
                    return false;
                }

                //start the loop til the end
                //return false if different
                while(count < this.length()){
                    otherNode = otherNode.nextNode;
                    thisNode = thisNode.nextNode;
                    count++;

                    if(otherNode.getLetter()!=thisNode.getLetter()){
                        return false;
                    }
                }
                //by the end, if no different
                return true;
            }
        }
        //if the object is instanceof String
        //compare its content with the calling object
        else if(other instanceof String){

            String oth = (String)other;

            //return true if the string is empty and the calling object MSB is
            //also empty
            if(this.firstNode==null && oth.equals("")){
                System.out.println("Both empty!");
                return true;
            }

            //if different length, return false
            if(this.length() != oth.length()){
                return false;
            }
            //if same length, check content char-by-char
            else{
                CharacterNode thisNode = this.firstNode;
                int count = 1;

                //compare the first letter
                //return false if different
                if(thisNode.getLetter()!=oth.charAt(count-1)){
                    return false;
                }

                //start the loop til the end
                //return false if different
                while(count < this.length()){
                    thisNode = thisNode.nextNode;
                    count++;

                    if(thisNode.getLetter()!=oth.charAt(count-1)){
                        return false;
                    }
                    //by the end, if no different   
                }return true;
            }
        }
        //if object is not instanceof MyStringBuilder or String
        //not comparable, return false
        else{
            return false;
        }
    }

/**
    
    //This is the main method to test
     
    public static void main(String args[]){
        MyStringBuilder mySB = new MyStringBuilder();
        mySB.append('x');
        mySB.append('^');
        mySB.append('2');
        mySB.append('=');
        mySB.append('4');
        mySB.insert(3,'k');
        System.out.println("toString result: "+mySB.toString());
        System.out.println("length is "+mySB.length());
        mySB.delete(5,100);
        System.out.println(mySB.toString());
        String newStr = new String();
        newStr = "x^2k=";
        MyStringBuilder otherSB = new MyStringBuilder();
        otherSB.append('2');
        otherSB.append('=');
        otherSB.append('4');
        otherSB.append('#');
        System.out.println(mySB.equals(otherSB));
        System.out.println(mySB.equals(newStr));
    }
*/
}
