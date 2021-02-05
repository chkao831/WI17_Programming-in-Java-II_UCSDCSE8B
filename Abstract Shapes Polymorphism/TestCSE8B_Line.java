/*
 * Test program for classes CSE8B_Line for Shapes inheritance
 * exercise - CSE 8B
 *
 * Program draws interlocking squares.
 */

import java.awt.*;
import objectdraw.*;

public class TestCSE8B_Line extends WindowController
{
  public void begin()
  {
    try
    {
      makeCSE8B_Line();
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

  public void makeCSE8B_Line()
  {
    Point start = new Point(150, 150);
    Point end = new Point (250, 250);
    
    CSE8B_Line l1 = new CSE8B_Line();
    CSE8B_Line l2 = new CSE8B_Line(new Point (300,10), new Point (140, 267));
    CSE8B_Line l3 = new CSE8B_Line(start, end);
    CSE8B_Line l4 = new CSE8B_Line(l2);

    // Tests for the no arg constructor; if they fail this
    // we throw an exception so they can see what went wrong.ch
    if (l1.getStart() == null ||
        l1.getStart().getX() != 0 ||
        l1.getStart().getY() != 0 || 
        l1.getEnd() == null ||
        l1.getEnd().getX() != 0 ||
        l1.getEnd().getY() != 0 ) {
        
      throw new IllegalStateException("This should not print!\n" +
          "Testing no arg constructor\nShould be starting from (0,0) and ending at (0,0)");
    }

    if (l2.getStart() == null ||
        l2.getStart().getX() != 300 ||
        l2.getStart().getY() != 10 || 
        l2.getEnd() == null ||
        l2.getEnd().getX() != 140 ||
        l2.getEnd().getY() != 267 ) {
      
      throw new IllegalStateException("This should not print!\n" +
          "Testing (Point, Point) constructor\nShould be starting from (300,10) and ending at (140, 267)");
    }

    if (l3.getStart() == null ||
        l3.getStart().getX() != 150 ||
        l3.getStart().getY() != 150 || 
        l3.getEnd() == null ||
        l3.getEnd().getX() != 250 ||
        l3.getEnd().getY() != 250 ) {
      
      throw new IllegalStateException("This should not print!\n" +
          "Testing (Point, Point) constructor\nShould be starting from (150,150) and ending at (250,250)");
    }

    if (l3.getStart() == start || l3.getEnd() == end) {
      throw new IllegalStateException("This should not print!\n" +
          "Constructor (Point, Point) uses a shallow copy!");
    }

    if (l4.getStart() == null ||
        l4.getStart().getX() != 300 ||
        l4.getStart().getY() != 10 || 
        l4.getEnd() == null ||
        l4.getEnd().getX() != 140 ||
        l4.getEnd().getY() != 267 ) {
      
      throw new IllegalStateException("This should not print!\n" +
          "Testing (Point, Point) constructor\nShould be starting from (300,10) and ending at (140, 267)");
    }
  
    if (l4.getStart() == l2.getStart() || l4.getEnd() == l2.getEnd()) {
      throw new IllegalStateException("This should not print!\n" +
          "Copy Constructor uses a shallow copy!");
    }


    l1.draw(canvas);
    l2.draw(canvas, Color.RED, false);
    l3.draw(canvas, Color.BLUE, true);
    l4.draw(canvas);
    l4.draw(canvas, Color.ORANGE, false);

  }  // End of makeLine

} // End of class 
