/*
 * Test program for classes Point and Circle for Shapes inheritance
 * exercise - CSE 8B
 *
 * Program draws interlocking squares.
 */

import java.awt.*;
import objectdraw.*;

public class TestSquares extends WindowController
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
    
    Square s1 = new Square();
    Square s2 = new Square(150, 150, 200);
    Square s3 = new Square(point, 175);
    Square s4 = new Square(s2);

    // Tests for the no arg constructor; if they fail this
    // we throw an exception so they can see what went wrong.
    if (s1.getUpperLeft() == null ||
        s1.getUpperLeft().getX() != 0 ||
        s1.getUpperLeft().getY() != 0 ||
        s1.getSide() != 0) {
        
      throw new RuntimeException("This should not print!\n" +
          "Testing no arg constructor\nShould be at (0, 0) with a size of 0");
    }

    // Test for the (int, int, int) constructor
    // Checks that all the fields are set properly.
    if (s2.getUpperLeft() == null ||
        s2.getUpperLeft().getX() != 150 ||
        s2.getUpperLeft().getY() != 150 ||
        s2.getSide() != 200) {
      
      throw new RuntimeException("This should not print!\n" +
          "Testing (int, int, int) constructor\nShould be at (150, 150) with a size of 200");
    }

    // Checks that the constructor (Point, int) works correctly to
    // set all of the fields
    if (s3.getUpperLeft() == null ||
      s3.getUpperLeft().getX() != 250 ||
      s3.getUpperLeft().getY() != 150 ||
      s3.getSide() != 175) {
  
      throw new RuntimeException("This should not print!\n" +
        "Testing (Point, int) constructor\nShould be at (250, 150) with a size of 175");
    }

    // If they just set the point directly by reference instead of using
    // its copy constructor this will throw
    if (s3.getUpperLeft() == point) {
      throw new RuntimeException("This should not print!\n" +
          "Constructor (Point, int) uses a shallow copy!");
    }

    // Check that the copy constructor made an exact copy
    if (s4.getUpperLeft() == null ||
        s4.getUpperLeft().getX() != 150 ||
        s4.getUpperLeft().getY() != 150 ||
        s4.getSide() != 200) {
      
      throw new RuntimeException("This should not print!\n" +
          "Testing copy constructor\nShould be at (150, 150) with a size of 200");
    }  
  
    // Check for shallow copy when copying upper left corner.
    if (s4.getUpperLeft() == s2.getUpperLeft()) {
      throw new RuntimeException("This should not print!\n" +
          "Copy constructor uses a shallow copy!");
    }

    // Check whether the equals() method actually checks everything
    if (!s4.equals(s2)) {
      throw new RuntimeException("This should not print\n" +
        "s4 should equal s2, but it didn't");
    }

    s4.move(0, 110);

    if (s4.getUpperLeft().getX() != 150 &&
        s4.getUpperLeft().getY() != 260) {
      throw new RuntimeException("This should not print\n" +
          "s4 should be at (150, 260) but it wasn't!");
    }

    if (s4.equals(s2)) {
      throw new RuntimeException("This should not print\n" +
        "s4 shouldn't equal s2, but it did");
    }

    s1.draw(canvas);
    s2.draw(canvas, Color.RED, false);
    s3.draw(canvas, Color.BLUE, true);
    s4.draw(canvas);
    s4.draw(canvas, Color.ORANGE, false);

  }  // End of makeSquares()

} // End of class 
