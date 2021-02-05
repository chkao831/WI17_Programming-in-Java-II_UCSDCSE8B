File: REAME.md
This file contains the code testing description and answers to conceptual
questions. 
Name: Chih-Hsuan Kao
Logi: cs8bwagy
Email: c4kao@ucsd.edu
Date: Mar 10, 2018
Sources of Help: N/A

//Makefile
    I have not edited the Makefile while running my code. However, I have
    modified the main method under each file while testing out my code by
    passing in different parameters to figure out if the output matches my
    expectation. 

//Conceptual Questions
    The fixed overhead time should always be considered. There're only two
    threads but we have 8 threads to complete. We can only complete two threads
    at a time given the condition. Thus, I suppose that the total time is the
    overhead + 4 charTime. 

//Pointer Questions
    Using pointers to build MyStringBuilder allows us to modify the string
    itself (like insert, delete, etc) simply by changing the pointer from each
    node, instead of discarding the initial string and then create a new one. 
    My thoughts on how to reuse the nodes are to modify the CharacterNode class. 
    Currently, it only contains a char letter and a pointer. I'd like to add
    something like an integer count so that I would know how many times it's
    pointing back to itself. Once the counting is over, it could thus move on to
    the next node. 

//Design Decision
    I used a quite lot of while loop for MyStringBuilder because it's relatively
    more straightforward at this stage personally. 
    The advantage of using a recursive helper method is that it might be more
    concise in terms of context, since by calling the recursive method we
    don't need to create a lot of loops to traverse down the string everytime we
    need to do so. However, recursion does not necessarily make it more
    efficient. On the other hand, by using loop, it's more straightforward, but
    by doing this we might be creating a relatively longer method. 
