import java.awt.*;
import objectdraw.*;
import java.util.*;
/*---File Header---/
 * File: ScreenSaver.java
 * drawShape Method is modified by: Chih-Hsuan Kao
 * Login: cs8bwagy
 * Email: c4kao@ucsd.edu
 * Date: Feb 15, 2018
 * Sources of Help: N/A
 */

/*---Class Header---/
 * The ScreenSaver class operates screensaver, which is an animated assortment
 * of colors and shapes to make sure no single image displyed too long. 
 * It contains an instance variable, DrawingCanvas canvas, which is the canvas
 * on which shapes are drawn. 
 */
public class Screensaver extends ActiveObject {
    private static final int DELAY = 300;
    private DrawingCanvas canvas;

    public Screensaver( DrawingCanvas canvas )
    {
        this.canvas = canvas; // Need this to tell objects where to draw.
        // Gotten from the GUI controller object.

        start();      // Start the animation.
    }
    public void run()
    {
        try
        {
            // number of loop
            int NUM = 10;
            // SEED for random
            int SEED = 2048;
            // Declar x, y, and size
            int x, y, x2, y2, x3, y3, size, size2;
            // Initialize height and width
            int height = canvas.getHeight();
            int width = canvas.getWidth();
            // Initialize greater and smaller
            int greaterOne = height > width ? height: width;
            int smallerOne = height < width ? height: width;
            Random random = new Random(SEED);
            // Declare arraylist of shapes
            ArrayList<Shape> list = new ArrayList<Shape>();
            // Adding shapes to arraylist
            for(int index=0;index<NUM;index++){
                // Add random Circle to ArrayList
                x = random.nextInt(width);
                y = random.nextInt(height);
                size = random.nextInt(greaterOne/8);
                list.add(new Circle(new Point(x,y),size));
                // Add random Square to ArrayList
                x = random.nextInt(width);
                y = random.nextInt(height);
                size = random.nextInt(greaterOne/8);
                list.add(new Square(new Point(x,y),size));
                // Add random Rectangle to ArrayList
                x = random.nextInt(width);
                y = random.nextInt(height);
                size = random.nextInt(greaterOne/8);
                size2 = random.nextInt(greaterOne/8);
                list.add(new Rectangle(new Point(x,y),size,size2));
                // Add random Triangle to ArrayList
                x = random.nextInt(width);
                y = random.nextInt(height);
                x2 = random.nextInt(width);
                y2 = random.nextInt(height);
                x3 = random.nextInt(width);
                y3 = random.nextInt(height);
                list.add(new Triangle(new Point(x,y),new Point(x2,y2),new Point(x3,y3)));
                // Add random Line to ArrayList
                x = random.nextInt(width);
                y = random.nextInt(height);
                x2 = random.nextInt(width);
                y2 = random.nextInt(height);
                list.add(new CSE8B_Line(new Point(x,y),new Point(x2,y2)));
            }
            // Call the method
            drawShape(list);
        }
        catch ( Exception e )
        {
        }
    }

    /**Method: drawShape
     * This method uses a for-each loop to iterate through the parameter
     * ArrayList. Shapes are drawn until the ArrayList runs out of Shapes.
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param ArrayList<Shape> list: the list to be iterated
     * @return none
     */
    public void drawShape(ArrayList<Shape> list){

        //use a for-each loop to iterate through the parameter ArrayList
        //inside the for-each loop, use the Shape ref to call 
        //the one-argument draw method.
        //pause is called for a delay between shape and shape display. 
        //
        for (Shape shape : list){
            shape.draw(canvas);
            pause( DELAY );
        }
    }
}
