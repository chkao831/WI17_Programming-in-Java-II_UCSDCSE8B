/---File Header---/
File: README.md
Name: Chih-Hsuan Kao, cs8bwagy
Date: Feb 18, 2018

[Paragraph on how I tested Shapes, Screensaver, and Recursion]
The way I tested my Shapes is to look at the output directly first and
match it with the sample output provided in the writeup. If error messages
occur, there must be something wrong. Then, I would take a look at the 
tester file. For example, when looking at the tester file for CSE8B, 
I can see how many lines are created at where, and how many lines are 
actually displayed when running it. If the displayed outcome does not 
match the speculation, I know there's something wrong even without exception
messages. I test Screensaver and Recursion in the same way. Look at the 
output first, and after it seems right, look at the tester file and see
if what is supposed to be drawn matches what is actually drawn. 

[Paragraph about entire program, no CS term]
First, I have created several Shapes, such as Circles, Triangles, Rectangles,
Lines, respectively. Their common jobs are to create objects and then perform
some basic tasks, and most importantly, draw the shapes on a specified canvas.
Then, in Screensaver file, the program basically have a list, in which shapes
are added into the list randomly. After adding, I use a for-each loop to iterate
through the list and use Shape reference to call to accomplish this. 
Similarly, in Recursion.java, since I already know how to create a Square, 
and draw it on canvas, I made use of some recursion mechanism to format an 
interlocking square pattern by drawing the square I receive recursively. 

[Short Response]
1. If I were to write a test, let's say I've already have an object, line1, 
and in the constructor, I tried to deep-copied line1 to be line2. I would try 
to change the property of line2 by changing it start point and end point to 
somewhere else (or change its color). Then, I'll use an if statement like
if(line2.getStart() == line1.getStart()){throw new IllegalStatementException}
to throw exception when the deep copy is not performed property as I expected.

2. After making sure that my deep-copy constructor is working properly, I 
would create two objects (two lines, with different contents but pointing 
to different objects by performing deep copy). Then, I'll test my equals 
method by using if statement in which !(line1).equals(line2) to make sure
we're only comparing the contents of the two lines. 

3. Firstly, in the tester file, several circles are created first to test if
the constructor did the right thing by testing the center coordinate & radius.
After passing the constructor test, we check if deep copy is performed.
In addition to Circle copy constructor, Point copy constructor and move method
is also tested by using a Point to perform copy and move. 
Similarly, in equals method, we pass in null refernce and see if the null 
case is handled properly. Then, we do a deep check of the contents of the two
Circles and see if they're compared properly. Lastly, we display info about
the things we draw and see if the information is correct. 


