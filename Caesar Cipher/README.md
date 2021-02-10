Written by cs8bwagy, Chih-Hsuan Kao
Date: Jan 14, 2018

Part 1

Section A: Creating two variables. Two types of variables are created in
this case. The first variable created is a primitive-type integer a; the
second variable, b, is reference-type, which stores references to Integer
objects. 

Section B: is a constructor method in the class Class1. Constructor
methods always have the same name as the class, so in this case, it's
called Class1(). It does not take any parameter, in this case.
It basically initializes the values of variables a and b to be 5 and 5
respectively.

Section C: The line indicates a method header. From the header, we can
see that the method Method1 is a public method that returns integer
values. It's a non-static method that takes in 3 input (parameters),
including integer a, character b and Integer c.

Section D: is the argument of the method Method1. From the argument, we
can see that the method basically prints out the value of the integer a,
and then returns 0 at the end to terminate the method call. 

Section E: the parameters (6, 'a', 100) are the values to be passed into
the method Method1 with type integer, character and Integer respectively.
6 is an integer type (primitive); 'a' is a character type (primitive);
100 is an Integer type (reference). 

Section F: is a method call. The method Method 1 is called with a new
object called name, whose type is Class1. Note that the Class1 here is
different from the Class1 in part b, which is a class. The method call
to Method 1 takes in input (6, 'a', 100) and executes the body inside
the method. 

Section C and F are matched up because as Method1 is called, (6,'a',100)
are taken as parameters and passed into the method call as inputs. Java
is able to identify and connect the two because firstly, the calling 
object is created and declared (called name) in the beginning of the
body of the static method. Again, its type Class1 is different from the
class Class1 in part B. Secondly, Method1 and main methods are both
under the class Class1 and are both public. As the method call is
executed successfully, those three parameters are passed into the method
Method1 and do what the method wants them to do. 

//

Part 3

method p2
 1) The method p2 failed to consider the case in which a null String is
 passed into the method. If we compare a null String with the
 possibleAnagrams, a NullPointerException would occur. 
 2) String word = null; 
 3) A program crash (NullPointerException)
 4) Such an error occurs because the one who wrote the method forgot to
 consider the String that is compared in the method could be null.
 To fix it, simply use a try/catch statement to catch the exception and
 print out an exception message when there's a NullPointerException. 
5) The program didn't run, but the error is easy to be recognized and
easy to be fixed even though an exception message is not thrown. 

method p3
 1) The problem of method p3 is that the one who wrote it only focused
 on having each alphabet that the String word has appear in the Strings
 in the array without checking if it contains something else.
 2) String word = "hello" 
 String[] possibleAnagrams = {"cse8b","rocks","elloah")
 3) Wrong output (counted wrong)
 4) The program writer probably set up a for loop and check if every
 character in the String word appear in the corresponding string, though
 it's true when every element is there, but failed to recognize it's
 false since there're other things in the String. 
 5) Sort of a severe error, since the number of output is wrong, which is
 what the program aims to get. (logical error) 

method p4
 didn't figure it out

method p5
 1) The code writer made a typo while passing in the parameters for
 comparison. 
 2) String word = "ccse8bb"
 String[] possibleAnagrams = {"cse8b","rocks","hello"}
 3) Wrong output: in this case, ccse8bb is wrongly recognized as an
 anagram, while it's not
 4) the method was wrongly written because a typo might have occurred
 5) Sort of severe because of wrong output (logical error)

method p6
 1) Divergent case when considering empty string array
 2) When we set the String[] possibleAnagrams to be new String[0]
 3) Wrong output printed: 0 anagrams found, which is NaN%
    Right output should be Cannot find anagrams; s has nothing in it
 4) occurred because the code writer didn't consider the case and print
 out the statement saying that s has nothing in it
 5) not very critical though

method p7
 1) A string "" is regarded as an anagram to the String word 
 2) When passing an input "" into the StringArray
 3) Wrong output: 1 anagrams found
    Right output should be 0 anagram found, since "" is not an
    anagram of "hello"
 4) The method was wrongly written probably because the code writer
 forgot to consider that arrays in general could have a length of 0.
 And then the method written wrongly regards the array with length of 0
 as an anagram. 
 5) Sort of severe (logical error)

method p8
 1) An error in p8 is spacing error. When there's a space within a string,
 it's wrongly considered as an anagram.
 2) When there's a space within the anagram of hello
 3) Wrong output: the anagram with space in it is counted as an anagram,
 while it's not
 4) When comparing two strings, the code writer might have ignored the
 fact that the word and its anagram should have exactly the same
 characters (and amount), so even a space makes it different. 
 5) Sort of severe (logical error)

//

Part 4C

Run the script for three times. 
The real time for running it are shown below. 
1: encryptTwo method: 0m2.219s / encrypt method: 0m34.748s
2: encryptTwo method: 0m1.643s / encrypt method: 0m27.387s
3: encryptTwo method: 0m1.163s / encrypt method: 0m29.301s

Reason:
StringBuilder is more efficient.
The main reason is that String objects are immutable,
while StringBuilder objects are mutable,
which means the StringBuilder itself can be altered, unlike String objects.
In Part 4A, when we manipulate the String object,
we basically create one and another String objects throughout the for loop,
and as new objects are created,
the arrow pointing out from the objects changes its direction
from old objects to new ones from time to time.
On the other hand, since we can manipulate StringBuilder itself and alter
it directly, less memory would be taken up then.
This is why the method code in 4B takes less time
to run than the code in 4A. 

Personal Comparison:
The StringBuilder methods are easier for me to complete for some reasons.
Firstly, as I already finished writing the 4A when I worked on 4B,
I can write the code based on similar concept in which same parameter
types, return types are used. 
Implementing the details take less time than figuring up the logic at first.
Therefore, I spent much less time on Part B than on Part A.
Both of them are fairly straightforward, in my opinion. 


//

Summary, decription and what I learned
[Part 1] Part 1 is about starting editing file on vim editor and learning
some vocabulary. In the section, I looked at a file with color-coded
letters and boxes and explained what the codes are doing.
What I learned is some clarification of terms and ideas of computer
programming language. 

[Part 2] Part 2 is to debug some code in a file FunWithIntArrays.java.
There are some bugs in the file, which would lead to some errors
(making the program crush or generating wrong output, etc). 
Therefore, I fixed them and explained the things I've done in the header.
Then, I used ArraysTester.java, which helps test the changes in the
FunWithIntArrays.class, to test if my work is correct.
I learned/reviewed to debug in this section. 

[Part 3] Part 3 is about writing/revising methods in AnagramTester.java
to demonstrate some incorrect behavior of the method.
Sometime, when we write a code, we have some logic mistakes even though
our file is compilable and runnable.
In this section, although everything seems compilable and runnable,
unexpected outputs might be generated in certain cases, so it's important
to use testers to figure these out.
I learned to write a tester from this exercise, and recognized that fixing a
logical error is much harder than fixing a compile or runtime error. 

[Part 4] Part 4 is about performing change on some words by encrypting and decrypting them using codes provided in ASCII table. By rotating each alphabetic character in a word(string object), we can encrypt a message to another mystery thing; also, we can decrypt the mystery thing by decrypting it back. I learned to encrypt and decrypt string objects in the section. 
