// DO NOT import from javafx package
import java.awt.*;
import java.util.*;

import objectdraw.*;

/**---File Header---/
 * File: Circle.java
 * Author: Chih-Hsuan Kao
 * Login: cs8bwagy
 * Email: c4kao@ucsd.edu
 * Date: Feb 15, 2018
 * Sources of Help: Tutor Hours
 */

/**---Class Header---/
 * The Circle class can create a circle, characterized by a Point center
 * and an integer radius.
 * It contains methods that can move the object, compare two objects, 
 * print out string contents and draw the object on canvas.
 * Its instance variables are Point center and int radius.
 */
public class Circle extends Shape {
    private Point center;
    private int radius;

    /**
     * The no-arg constructor for the Circle class.
     * This initializes a new Circle with a new Point and radius of 0
     */
    public Circle() {
        setCenter(new Point());
        setRadius(0);
    }

    /**
     * A constructor for the Circle class.
     * This constructor initializes a new Circle with a passed-in
     * Point center and int radius.
     * Deep copy is performed.
     * @param Point center
     * @param int radius
     */
    public Circle(Point center, int radius) {
        setCenter(new Point(center));
        setRadius(radius);
    }

    /**
     * A constructor for the Circle class.
     * This constructor initializes a new Circle with a passed-in Circle c.
     * Deep copy is performed.
     * @param Circle c: a circle to be deep-copied
     */
    public Circle(Circle c) {
        this(new Point(c.getCenter()),c.getRadius());
    }

    /**Method: getCenter
     * Getter for the instance variable Point center
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return Point center
     */
    public Point getCenter() {
        Point centerPoint = this.center;
        return centerPoint;
    }

    /**Method: setCenter
     * Setter for the instance variable Point center
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param Point the center of the circle
     * @return none
     */
    private void setCenter(Point point) {
        this.center = point;
    }

    /**Method: getRadius
     * Getter for the instance variable int radius
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return int radius of the Circle
     */
    public int getRadius(){
        int rad = this.radius;
        return rad;
    }

    /**Method: setRadius
     * Setter for the instance variable int radius
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param int radius
     * @return none
     */
    private void setRadius(int radius) {
        this.radius = radius;
    }

    /**Method: move
     * Moves this Circle by a certain x and y amount
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param deltaX The amount to increase x coord
     * @param deltaY The amount to increase y coord
     * @return none
     */
    @Override
    public void move(int deltaX, int deltaY) {
        this.getCenter().move(deltaX, deltaY);
    }

    /**Method: toString
     * Generates the string representation of this Circle
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return A string in the form "Circle: Center: Point: (x,y); Radius: r"
     */
    @Override
    public String toString() {
        int circleX = this.getCenter().getX();
        int circleY = this.getCenter().getY();
        String toReturn = "Circle: Center: Point: ("+
            circleX + "," + circleY + "); Radius: " + this.getRadius();
        return toReturn;
    }

    /**Method: equals
     * Determines whether this Circle is equivalent to another object.
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param Object o: to be compared to this Circle
     * @return boolean true: if o is a non-null instance of Circle
     *                 false: otherwise
     */
    @Override
    public boolean equals(Object o) {
        //make sure the Object o is non-null
        if(o == null){
            return false;
        }
        if(o instanceof Circle){
            //casting object o to Circle if o is instance of Circle
            Circle objCir = (Circle)o;

            //after casting, return true if both have same center and radius
            if(this.getCenter().getX() == objCir.getCenter().getX()
                    && this.getCenter().getY() == objCir.getCenter().getY()
                    && this.getRadius() == objCir.getRadius()){
                return true;
                    }
            //otherwise, return false
            return false;
        }return false;
    }

    /**Method: draw
     * Defer to the second draw method by passing in parameters
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param DrawingCanvas canvas
     * @return none
     */
    public void draw(DrawingCanvas canvas) {
        //generate a random number of rgb
        Random ramGenerator = new Random();
        //generate a new color
        Color color = new Color(ramGenerator.nextInt(255),
                ramGenerator.nextInt(255),ramGenerator.nextInt(255));
        //call the second draw method 
        this.draw(canvas,color,true);
    }

    /**Method: draw
     * A draw method that actually draws the Circle on canvas
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param DrawingCanvas canvas: to be drawn on
     * @param Color c: color of the Circle
     * @param boolean fill: true if filled Circle
     *                      false if framed Circle
     * @return none
     */
    public void draw(DrawingCanvas canvas, Color c, boolean fill) {
        //if the color parameter is null, use the black color   
        if(c == null){
            c = Color.BLACK;
        }
        //get the start point of drawing circle
        double upperLeftX = (this.getCenter().getX() - this.getRadius());
        double upperLeftY = (this.getCenter().getY() - this.getRadius());
        double diameter = (this.getRadius()*2);
        //if fill is true, draw a filled Circle by creating a FilledOval obj
        if(fill == true){
            FilledOval filledOv = new FilledOval(upperLeftX,upperLeftY,
                    diameter,diameter,canvas);
            filledOv.setColor(c);
        }
        //if fill is false, draw a framed Circle by creating a FramedOval obj
        if(fill == false){
            FramedOval framedOv = new FramedOval(upperLeftX,upperLeftY,
                    diameter,diameter,canvas);
            framedOv.setColor(c);
        }
    }

}
