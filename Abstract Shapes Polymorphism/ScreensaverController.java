/**
 * Helper program to test various Shapes per CSE 8B - Inheritance
 * homework.
 *
 * Basic WindowController (with canvas) to support drawing from the
 * ActiveObject Screensaver object.
 *
 * Invoked from Screensaver.html
 */

import objectdraw.*;

public class ScreensaverController extends WindowController
{

  public void begin()
  {
    new Screensaver( canvas );
  }

}
