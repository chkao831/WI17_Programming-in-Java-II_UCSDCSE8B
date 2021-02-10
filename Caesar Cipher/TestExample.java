/** Writing Tester Methods

Methods take in an input and returns and output. But what if you wanted to
know that, for some input s, the method will return the correct output t? 

NOTE: This file provides various examples of how to write testers. But by
no means are they mandatory. The only thing that is "mandatory" is learning
how to test you code, which is usually done by writing testers. Thus, this
file simply contains examples and explanations about the testers. 

There are a few ways you can write testers:
- Write print statements inside your code to determine behavior internally.
- Write tester methods that will test functions with a series of inputs and 
returns, for example, true or false depending on whether all inputs produced
correct outputs.
- Write your methods to return if all inputs works and throws an 
Exception when a wrong behavior is found. This might be the newest form of testing.


*/

public class TestExample {
    private TestExample(){};

    /** Writing a Tester Method and Normal Cases

    Suppose I had written a method add() which takes in two Integers and returns
    the sum as an Integer. Some normal cases would be to put in two integer 
    numbers and see what it returns. 

    */
    public static Integer add(Integer first, Integer sec){
        return new Integer (new Integer(first) + new Integer(sec));

        //Suppose you wanted to put a print statement inside
        /*
        Integer tempInteger = new Integer(new Integer(first) + new Integer(sec));
        System.out.println(tempInteger);
        return tempInteger
        */
    
    }

    /* 
    Some normal cases I could test for, just to make sure I have normal conditions:

    add(5, 7) should return 12
    add(0, 0) should return 0
    */

    public static void main1() throws Exception {

        // Notice how you must declare the method to "throws Exception" in order
        // to throw exceptions

        if (add(5, 7) != 12) throw new Exception();  //TODO

        /* The following error gets thrown

        Exception in thread "main" java.lang.Exception
        at TestExample.main1(TestExample.java:32)
        at TestExample.main(TestExample.java:36)   

        (Line numbers are wrong.)

        Now you can debug your code. */
    }

    /** Another normal case to check for is the null case */
    public static void main2() throws Exception {
        add(5,null); //TODO

        //You will get a null pointer exception: 
        /*
        Exception in thread "main" java.lang.NullPointerException
        at TestExample.add(TestExample.java:17)
        at TestExample.main2(TestExample.java:47)
        at TestExample.main(TestExample.java:52)
        */

        // Objects always need references that are not null. Accessing
        // addresses that are null will crash the program. 
    }

    /** Finally, edge cases 
        
        In an array with 100 elements (from 0 to 99 inclusive)
        What are the edges?

        They are 0 and 99. 
        If possible inputs are all possible integer values, you must test
        what happens when you input negative numbers, 0, 1 through 98, 99, and 100+. 

        What does the program do between the edges, at the edges, and beyond the edges?

        What are edge cases for Strings? for chars? for Arrays? for ints? 
    */

    public static boolean main3() throws Exception {
        String s = null;
        String t = null;
        s.concat(t);

        s = "";
        t = "t";

        if(s.length()<1)throw new Exception();
        if(s.concat(t).length()<5)throw new Exception();

        return true; // if main3 returns true, everything passed. 
    }


    public static void main(String[] args) throws Exception {
        TestExample.main1();
        TestExample.main2();
        TestExample.main3();
    }
}
/*
    It basically summarizes down to:
    1. What are the inputs that can crash the program?
    2. What are the inputs that produces wrong outputs?

    With that in mind, you should be able to now write your own testers.

    */

/** Additional Resource: 
"Writing Great Unit Tests: Best and Worst Practices" (Find on Google)
*/