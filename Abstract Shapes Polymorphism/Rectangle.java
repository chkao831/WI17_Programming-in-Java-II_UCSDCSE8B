// DO NOT import from javafx package
import java.awt.*;
import java.util.*;

import objectdraw.*;

/**---File Header---/
 * File: Rectangle.java
 * Author: Chih-Hsuan Kao
 * Login: cs8bwagy
 * Email: c4kao@ucsd.edu
 * Date: Feb 16, 2018
 * Sources of Help: Tutor Hours
 */

/**---Class Header---/
 * This Rectangle class can create a rectangle, characterized by an integer
 * width and an integer height.
 * It contains methods that can move the object, compare two objects, 
 * print out string contents and draw the object on canvas.
 * Its instance variables are private int width and private int height.
 * It extends an abstract class ARectangle.
 */
public class Rectangle extends ARectangle {
    private int width;
    private int height;

    /**
     * The no-arg constructor for the Rectangle class.
     * This calls the second constructor by passing in upperLeft(0,0)
     * and width 0 and height 0
     */
    public Rectangle() {
        this(0,0,0,0);
    }

    /**
     * A constructor for the Rectangle class.
     * This calls the third constructor by passing in a new Point determined
     * by passed-in-parameters x and y; width and height
     * @param int x: upperLeft x coord
     * @param int y: upperLeft y coord
     * @param int width
     * @param int height
     */
    public Rectangle(int x, int y, int width, int height) {
        this(new Point(x,y),width,height);
    }

    /**
     * A constructor for the Rectangle class.
     * Call its superclass ARectangle to set name
     * and then set width and height according to passed-in parameters
     * @param Point upperLeft of Rectangle
     * @param int width
     * @param int height
     */
    public Rectangle(Point upperLeft, int width, int height) {
        //call the superclass's constructor with the same name
        //and the upperLeft corner given
        super(new String("Rectangle"),new Point(upperLeft));
        //set width and height with the parameter passed in
        setWidth(width);
        setHeight(height);
    }

    /**
     * A constructor for the Rectangle class.
     * This constructor initializes a new Rectangle with a passed-in Rectangle
     * @param Rectangle r: a rectangle to be deep-copied
     */
    public Rectangle(Rectangle r) {
        this(new Point(r.getUpperLeft()),r.getWidth(),r.getHeight());
    }

    /**Method: getHeight 
     * Getter method to get height of the rectangle
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return int height of the rectangle
     */
    public int getHeight(){
        int h = this.height;
        return h;
    }

    /**Method: setHeight
     * Setter method to set height of the rectangle
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param int height to be set
     * @return none
     */
    private void setHeight(int height) {
        this.height = height;
    }

    /**Method: getWidth
     * Getter method to get the width of the rectangle
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return int width of the rectangle
     */
    public int getWidth(){
        int w = this.width;
        return w;
    }

    /**Method: setWidth
     * Setter method to set width of the rectangle
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param int width to be set
     * @return none
     */
    private void setWidth(int width) {
        this.width = width;
    }

    /**Method: toString
     * Generates the string representation of this Rectangle
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return A string in the form "Rectangle: Upper Left Corner: 
     *                               Point:(x,y) Width: w Height: h"
     */
    @Override
    public String toString() {
        String toReturn = super.toString() + "Width: " + this.getWidth()
            + " Height: " + this.getHeight();
        return toReturn;
    }

    /**Method: equals
     * Determines whether this Rectangle is equivalent to another object.
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param Object o: to be compared to this Rectangle
     * @return boolean true: if o is a non-null instance of Rectangle
     *                 false: otherwise
     */
    @Override
    public boolean equals(Object o) {
        //make sure the Object o is non-null
        if(o == null){
            return false;
        }
        //
        if(super.equals(o) == true){

            if(o instanceof Rectangle){
                //casting object o to rectangle if o is instanceof rectangle
                Rectangle objR = (Rectangle)o;
                //after casting, return true if have same width and height
                if(this.getWidth() == objR.getWidth()
                        && this.getHeight() == objR.getHeight()){
                    return true;
                        }
                //otherwise, return false
                return false;
            }
        }return false;
    }

    /**Method: draw
     * First generate a random number for rgb components of a color
     * then call the second draw method with canvas, the color and boolean true
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param DrawingCanvas canvas: to be drawn on
     * @return none
     */
    public void draw(DrawingCanvas canvas) {
        //generate a random number from 0 to 255 to randomly 
        //assign values to RGB components in a color
        Random ramGenerator = new Random();
        //generate a new color
        Color color = new Color(ramGenerator.nextInt(255),ramGenerator.nextInt(255),
                ramGenerator.nextInt(255));
        //call the second draw method passing in canvas, color and boolean true
        this.draw(canvas,color,true);
    }

    /**Method: draw
     * A draw method that actually draws the Rectangle on canvas
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param DrawingCanvas canvas: to be drawn on
     * @param Color c: color of the Rectangle
     * @param boolean fill: true if filled Rectangle
     *                      false if framed Rectangle
     * @return none
     */
    public void draw(DrawingCanvas canvas, Color c, boolean fill) {
        //if the color parameter is null, use the black color
        if(c == null){
            c = Color.BLACK;
        }
        //get UpperPoint coordinate
        double xPos = this.getUpperLeft().getX();
        double yPos = this.getUpperLeft().getY();
        //create loc based on xPos and yPos
        Location loc = new Location(xPos,yPos);

        //check fill or framed
        //if fill is true, draw a filled Rectangle by creating a FilledRect obj
        if(fill == true){
            FilledRect filledRecObj = new FilledRect(loc,this.getWidth(),
                    this.getHeight(),canvas);
            filledRecObj.setColor(c);
        }
        //if fill is false, draw a framed Rectangle by creating FramedRect obj
        if(fill == false){
            FramedRect framedRecObj = new FramedRect(loc,this.getWidth(),
                    this.getHeight(),canvas);
            framedRecObj.setColor(c);
        }
    }
}
