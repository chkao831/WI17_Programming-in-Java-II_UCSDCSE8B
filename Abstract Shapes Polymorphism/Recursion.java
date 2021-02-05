/*
 * Test program for classes Point and Circle for Shapes inheritance
 * exercise - CSE 8B
 *
 * Program draws interlocking squares.
 */

import java.awt.*;
import objectdraw.*;

/**---File Header---/
 * File: Recursion.java
 * Author: Chih-Hsuan Kao, cs8bwagy
 * Login: cs8bwagy
 * Email: c4kao@ucsd.edu
 * Date: Feb 18, 2018
 * Sources of Help: Tutor Hours
 */

/**---Class Header---
 * The Recursion class draws smaller squares at the four corners of a larger
 * square repeatedly to form a pattern. It inherits WindownController Class.
 */
public class Recursion extends WindowController
{
    public void begin()
    {
        try
        {
            makeSquares();
        }
        catch ( Exception e )
        {
            String msg1 = "An Exception Occurred!";
            String msg2 = "Check the terminal window";
            String msg3 = "for details!";

            Text errorMsg1 = new Text( msg1, 25, 200, canvas );
            Text errorMsg2 = new Text( msg2, 25, 225, canvas );
            Text errorMsg3 = new Text( msg3, 25, 250, canvas );

            errorMsg1.setColor( Color.RED );
            errorMsg1.setFontSize( 32 );
            errorMsg1.setBold( true );

            errorMsg2.setColor( Color.RED );
            errorMsg2.setFontSize( 32 );
            errorMsg2.setBold( true );

            errorMsg3.setColor( Color.RED );
            errorMsg3.setFontSize( 32 );
            errorMsg3.setBold( true );

            e.printStackTrace();
        }
    }

    public void makeSquares()
    {
        Point point = new Point(150, 150);

        Square s1 = new Square();
        Square s2 = new Square(150, 150, 200);
        Square s3 = new Square(point, 200);
        Square s4 = new Square(s2);

        s4.move(100, 100);

        recursiveSquare(s3, 0.5, 6);

    }  // End of makeSquares()

    /**Method: recursiveSquare
     * A method that uses recursion by calling itself within its method body and
     * draws sqaures at four corners of a larger square repeatedly
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param Square square: The square that is received to be drawn
     * @param double proportion: the ratio of the size of the smaller square's
     * sides to the square passed in as parameter
     * @param int n: an int counter that controls the number of times this
     * method is called
     * @return none
     */
    private void recursiveSquare(Square square, double proportion, int n) {

        //return, if the proportion given doesn't allow to draw
        //smaller squares from a large square
        if(proportion >= 1 || proportion <= 0) return;
        
        // Don't forget the base case!
        // Make the squares and implement the recursion here:

        if(n == 0) {
            
        square.draw(canvas, Color.LIGHT_GRAY, true);
        square.draw(canvas, Color.BLACK, false);
        }

        //return, if the proportion given doesn't allow to draw
        //smaller squares from a large square

        // This draws the square we received.

        else{
            
            //the new size of the smaller square to be drawn at four corners
            int newSide =(int)(square.getSide()*proportion);

            //calculate upperleft x and y coordinates for smaller squares
            int LeftX_coord = square.getUpperLeft().getX()-newSide/2;
            int RightX_coord = square.getUpperLeft().getX()+square.getSide()-newSide/2;
            int UpperY_coord= square.getUpperLeft().getY()-newSide/2;
            int LowerY_coord = square.getUpperLeft().getY()+square.getSide()-newSide/2;

            //draw Upper Left Square
            recursiveSquare(new Square(LeftX_coord,UpperY_coord,newSide),proportion,n-1);
            //draw Upper Right Square
            recursiveSquare(new Square(RightX_coord,UpperY_coord,newSide),proportion,n-1);
            //draw Lower Left Square
            recursiveSquare(new Square(LeftX_coord,LowerY_coord,newSide),proportion,n-1);
            //draw Lower Right Square
            recursiveSquare(new Square(RightX_coord,LowerY_coord,newSide),proportion,n-1);
        }

        //draws the sqaure we received
        square.draw(canvas, Color.LIGHT_GRAY, true);
        square.draw(canvas, Color.BLACK, false);
    }

} // End of class 
