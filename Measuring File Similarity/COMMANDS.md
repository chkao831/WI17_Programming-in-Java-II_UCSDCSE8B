
/* Filename: COMMANDS.md
 * Purpose: This file contains answers to linux/vim questions
 * Name: Chih-Hsuan Kao
 * Login: cs8bwagy
 * Email: c4kao@ucsd.edu
 * Date: Jan 18, 2018
 * Sources of Help: N/A
 **/

Questions about Vim:
    1. What are two ways to switch from command mode to insert mode?
        <Esc> + <i> insert text before the cursor
        <Esc> + <a> append text after the cursor
    2. How to you move the cursor to the end of a line in vim without using the
    arrow keys or mouse?
        In command mode, press $
    3. How do you copy 8 lines of code in Vim?
        In command mode, position the cursor where I want to begin copying;
        press v to select characters; move the cursor down to the end of line
        that I want to copy; press y to copy. 

Questions about Linux:
    1. How do you change to the home directory, no matter what directory you are
    currently in?
        cd ~home  
    2. How do you make a new directory from the command line?
        (Suppose the name of the new directory is called newdirectory,) 
        mkdir newdirectory
        ls
        newdirectory
    3. How do you show the path to the directory you are currently in?
        pwd
    4. How do you copy a directory and all of its contents?
        Let's say I have a folder under home directory 
        called sourcefolder and need to copy all
        contents of sourcefolder to destinationfolder under home directory
        cp -r /home/sourcefolder/* /home/destinationfolder
    5. How do you copy files from your personal computer to the iegn6 server?
        If I want to copy a file called FunWithIntArrays.java 
        scp FunWithIntArrays.java cs8bwagy@ieng6.ucsd.edu:~/Desktop
    6. How do you copy files from the ieng6 server to your personal computer?
        If I want to copy the psa2 folder from the ieng6 server to my desktop,
        scp -r cs8bwagy@ieng6.ucsd.edu:~/../public/psa2 ~/Desktop
