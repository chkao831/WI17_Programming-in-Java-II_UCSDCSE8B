/*
 * Test program for classes Triangle for Shapes inheritance
 * exercise - CSE 8B
 *
 * Program draws interlocking squares.
 */

import java.awt.*;
import objectdraw.*;

public class TestTriangle extends WindowController
{
  public void begin()
  {
    try
    {
      makeTriangle();
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

  public void makeTriangle()
  {
    Point p1 = new Point(200,200);
    Point p2 = new Point (150,250);
    Point p3 = new Point (250,250);

    Triangle t1 = new Triangle();
    Triangle t2 = new Triangle(new Point (230,10), new Point (10, 150), new Point (450, 150));
    Triangle t3 = new Triangle(p1,p2,p3);
    Triangle t4 = new Triangle(t2);

    // Tests for the no arg constructor; if they fail this
    // we throw an exception so they can see what went wrong.ch
    if (t1.getPoint1() == null ||
        t1.getPoint1().getX() != 0 ||
        t1.getPoint1().getY() != 0 ||
        t1.getPoint2() == null ||
        t1.getPoint2().getX() != 0 ||
        t1.getPoint2().getY() != 0 ||
        t1.getPoint3() == null ||
        t1.getPoint3().getX() != 0 ||
        t1.getPoint3().getY() != 0 ) {

      throw new IllegalStateException("This should not print!\n" +
          "Testing no arg constructor\nShould be p1: (0,0) p2: (0,0) and p3: (0,0)");
    }

    if (t2.getPoint1() == null ||
        t2.getPoint1().getX() != 230 ||
        t2.getPoint1().getY() != 10 ||
        t2.getPoint2() == null ||
        t2.getPoint2().getX() != 10 ||
        t2.getPoint2().getY() != 150 ||
        t2.getPoint3() == null ||
        t2.getPoint3().getX() != 450 ||
        t2.getPoint3().getY() != 150 ) {

      throw new IllegalStateException("This should not print!\n" +
          "Testing (Point, Point) constructor\nShould be p1: (230,10) p2: (10,20) and p3: (450,20)");
    }

    if (t3.getPoint1() == null ||
        t3.getPoint1().getX() != 200 ||
        t3.getPoint1().getY() != 200 ||
        t3.getPoint2() == null ||
        t3.getPoint2().getX() != 150 ||
        t3.getPoint2().getY() != 250 ||
        t3.getPoint3() == null ||
        t3.getPoint3().getX() != 250 ||
        t3.getPoint3().getY() != 250  ) {

      throw new IllegalStateException("This should not print!\n" +
          "Testing (Point, Point) constructor\nShould be p1: (200,200) p2: (150,250) and p3: (250,250)");
    }

    if (t3.getPoint1() == p1 || t3.getPoint2() == p2 || t3.getPoint3() == p3) {
      throw new IllegalStateException("This should not print!\n" +
          "Constructor (Point, Point) uses a shallow copy!");
    }

    if (t4.getPoint1() == null ||
        t4.getPoint1().getX() != 230 ||
        t4.getPoint1().getY() != 10 ||
        t4.getPoint2() == null ||
        t4.getPoint2().getX() != 10 ||
        t4.getPoint2().getY() != 150 ||
        t4.getPoint3() == null ||
        t4.getPoint3().getX() != 450 ||
        t4.getPoint3().getY() != 150 ) {

      throw new IllegalStateException("This should not print!\n" +
          "Testing (Point, Point) constructor\nShould be p1: (230,10) p2: (10,20) and p3: (450,20)");
    }

    if (t4.getPoint1() == t2.getPoint1() || t4.getPoint2() == t2.getPoint2() || t4.getPoint3() == t2.getPoint3()) {
      throw new IllegalStateException("This should not print!\n" +
          "Copy Constructor uses a shallow copy!");
    }


    t1.draw(canvas);
    t2.draw(canvas, Color.RED, false);
    t3.draw(canvas, Color.BLUE, false);
    t4.draw(canvas);
    t4.draw(canvas, Color.ORANGE, false);

  }  // End of makeTriangle

} // End of class
