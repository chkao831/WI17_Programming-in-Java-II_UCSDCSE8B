File: REAME.md
Purpose: Program Summary
Name: Chih-Hsuan Kao
Login: cs8bwagy
Email: c4kao@ucsd.edu
Date: Jan 21, 2018

In WordCountList.java, I created several tools to implement programs that
do things to a files that I pass in. 
For example, getWordsFromFile can take a file, and update the list with counts
in them by sorting elements out with respect of names and its amounts
of occurrences. I also write something else that remove common words from the 
list, return a list with a specific formats, and finds the top n occurring 
words in the list and returns it as a list, etc. 
To test those codes, I have another file called WordCountListTester.java.
I created some unit testers to test them and see if each of them works.
The purpose of doing it is to see if the real results returned by it  match
the expected results that I expect. Some will throw exceptions
if things don't pass in/print out/match the size successfully, etc. 
Lastly, in Similarity.java, I created a Similarity Detector to determine how
similar two texts are. Firstly, I wrote some things to count the maximum and
minimum number of occurrences of each word. Next, I divide the sum of all
minimum counts by the sum of all maximum counts and multiply by 100 to get the
percent similarity of two documents. Then, I also checked if one document is the
subset of another (every word in one doc appears in another). 
