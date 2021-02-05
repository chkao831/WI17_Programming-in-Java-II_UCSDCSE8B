/*
 * Test program for classes Point and Circle for Shapes inheritance
 * exercise - CSE 8B
 *
 * Program draws rectangles.
 */

import java.awt.*;
import objectdraw.*;

public class TestRectangle extends WindowController
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
    Point point = new Point(250, 150);
    
    Rectangle r1 = new Rectangle();
    Rectangle r2 = new Rectangle(150, 150, 200, 100);
    Rectangle r3 = new Rectangle(point, 175, 25);
    Rectangle r4 = new Rectangle(r2);

    // Tests for the no arg constructor; if they fail this
    // we throw an exception so they can see what went wrong.
    if (r1.getUpperLeft() == null ||
        r1.getUpperLeft().getX() != 0 ||
        r1.getUpperLeft().getY() != 0 ||
        r1.getWidth() != 0 ||
        r1.getHeight() != 0) {
        
      throw new RuntimeException("This should not print!\n" +
          "Testing no arg constructor\nShould be at (0, 0) with a width and height of 0");
    }

    // Test for the (int, int, int) constructor
    // Checks that all the fields are set properly.
    if (r2.getUpperLeft() == null ||
        r2.getUpperLeft().getX() != 150 ||
        r2.getUpperLeft().getY() != 150 ||
        r2.getWidth() != 200 ||
        r2.getHeight() != 100) {
      
      throw new RuntimeException("This should not print!\n" +
          "Testing (int, int, int) constructor\nShould be at (150, 150) with a width of 200"+
          " and a height of 100");
    }

    // Checks that the constructor (Point, int) works correctly to
    // set all of the fields
    if (r3.getUpperLeft() == null ||
      r3.getUpperLeft().getX() != 250 ||
      r3.getUpperLeft().getY() != 150 ||
      r3.getWidth() != 175 ||
      r3.getHeight() != 25) {
  
      throw new RuntimeException("This should not print!\n" +
        "Testing (Point, int) constructor\nShould be at (250, 150) with a width of 175"+
        " and a height of 25");
    }

    // If they just set the point directly by reference instead of using
    // its copy constructor this will throw
    if (r3.getUpperLeft() == point) {
      throw new RuntimeException("This should not print!\n" +
          "Constructor (Point, int) uses a shallow copy!");
    }

    // Check that the copy constructor made an exact copy
    if (r4.getUpperLeft() == null ||
        r4.getUpperLeft().getX() != 150 ||
        r4.getUpperLeft().getY() != 150 ||
        r4.getWidth() != 200 ||
        r4.getHeight() != 100) {
      
      throw new RuntimeException("This should not print!\n" +
          "Testing copy constructor\nShould be at (150, 150) with a width of 200" +
          " and a height of 100");
    }  
  
    // Check for shallow copy when copying upper left corner.
    if (r4.getUpperLeft() == r2.getUpperLeft()) {
      throw new RuntimeException("This should not print!\n" +
          "Copy constructor uses a shallow copy!");
    }

    // Check whether the equals() method actually checks everything
    if (!r4.equals(r2)) {
      throw new RuntimeException("This should not print\n" +
        "r4 should equal r2, but it didn't");
    }

    r4.move(0, 110);

    if (r4.getUpperLeft().getX() != 150 &&
        r4.getUpperLeft().getY() != 260) {
      throw new RuntimeException("This should not print\n" +
          "r4 should be at (150, 260) but it wasn't!");
    }

    if (r4.equals(r2)) {
      throw new RuntimeException("This should not print\n" +
        "r4 shouldn't equal r2, but it did");
    }

    r1.draw(canvas);
    r2.draw(canvas, Color.PINK, false);
    r3.draw(canvas, Color.CYAN, true);
    r4.draw(canvas);
    r4.draw(canvas, Color.BLACK, false);

  }  // End of makeSquares()

} // End of class 
