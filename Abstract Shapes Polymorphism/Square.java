// DO NOT import from javafx package
import java.awt.*;
import java.util.*;

import objectdraw.*;

/**---File Header---/
 * File: Square.java
 * Author: Chih-Hsuan Kao
 * Login: cs8bwagy
 * Email: c4kao@ucsd.edu
 * Date: Feb 15, 2018
 * Sources of Help: Tutor Hours
 */

/**---Class Header---/
 * The Square class can create a square, characterized by an integer side.
 * It contains methods that can move the object, compare two objects, 
 * print out string contents and draw the object on canvas.
 * Its instance variables is private int side: side of the square.
 * It extends an abstract class ARectangle.
 */
public class Square extends ARectangle {

    private int side;

    /**
     * The no-arg constructor for the Square class.
     * This calls the second constructor by passing in upperLeft(0,0) and side 0
     */
    public Square() {
        this(0,0,0);
    }

    /**
     * A constructor for the Square class. 
     * This calls the third constructor by passing in a new Point determined by
     * passed-in-parameters s and y; and square side
     * @param int x: upperLeft x coordinate
     * @param int y: upperLeft y coordinate
     * @param int side: side of the square
     */
    public Square(int x, int y, int side) {
        this(new Point(x,y), side);
    }

    /**
     * A constructor for the Square class.
     * Call its superclass ARectangle to set name
     * and then set side according to passed-in parameters
     * @param Point upperLeft of Square
     * @param int side: side of Square
     */
    public Square(Point upperLeft, int side) {
        //call the superclass's constructor with the name Square and the
        //upperLeft corner given
        super(new String("Square"),new Point(upperLeft));
        //set the side field using its setter
        setSide(side);
    }

    /**
     * A constructor for the Square class.
     * This constructor initializes a new Square with a passed-in Square
     * @param Square square: a square to be deep-copied
     */
    public Square(Square square) {
        this(new Point(square.getUpperLeft()),square.getSide());
    }

    /**Method: setSide
     * Setter method to set side of the Square
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param int side: side of the square to be set
     * @return none
     */
    private void setSide(int side) {
        this.side = side;
    }

    /**Method: getSide
     * Getter method to get the side of the Square
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return int side of the square
     */
    public int getSide() {
        int value = this.side;
        return value;
    }

    /**Method: toString
     * Generates the string representation of the Square
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return A string in the form "Square: Upper Left Corner:
     *                               Point:(x,y) Side:s"
     */
    @Override
    public String toString() {
        String toReturn = super.toString() + " Sides: " + this.getSide();
        return toReturn;
    }

    /**Method: equals
     * Determines whether this Square is equivalent to another object
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param Object o: to be compared to this Square
     * @return boolean true: if o is a non-null instance of Square
     *                 false: otherwise
     */
    @Override
    public boolean equals(Object o) {
        //make sure the Object o is non-null
        if(o == null){
            return false;
        }
        if(super.equals(o) == true){
            if(o instanceof Square){
                //casting object o to square if o is instanceof Square
                Square objS = (Square)o;
                //after casting, return true if have same side length as calling
                //object
                if(this.getSide() == objS.getSide()){
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
        //generate a random number for the red, blue and green
        //components of the Color
        Random ramGenerator = new Random();
        //generate a new color
        Color color = new Color(ramGenerator.nextInt(255),ramGenerator.nextInt(255),
                ramGenerator.nextInt(255));
        //call the second draw method passing in canvas, color and boolean true
        this.draw(canvas,color,true);
    }

    /**Method: draw
     * A draw method that actually draws the Square on canvas
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param DrawingCanvas canvas: to be drawn on
     * @param Color c: color of the Square
     * @param boolean fill: true if filled Square
     *                      false if framed Square
     * @return none
     */
    public void draw(DrawingCanvas canvas, Color c, boolean fill) {
        //if the color parameter is null, use the black color
        if(c == null){
            c = Color.BLACK;
        }
        //get UpperLeft coordinate
        double xPos = this.getUpperLeft().getX();
        double yPos = this.getUpperLeft().getY();
        //create a new location based on UpperLeft x and y
        Location loc = new Location(xPos,yPos);
        //if fill is true, draw a filled Square by creating a FilledRect obj
        if(fill == true){
            FilledRect filledRecObj = new FilledRect(loc,this.getSide(),
                    this.getSide(),canvas);
            filledRecObj.setColor(c);
        }
        //if fill is false, draw a framed Square by creating FramedRect obj
        if(fill == false){
            FramedRect framedRecObj = new FramedRect(loc,this.getSide(),
                    this.getSide(),canvas);
            framedRecObj.setColor(c);
        }
    }

}
