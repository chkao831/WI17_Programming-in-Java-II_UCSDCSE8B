// DO NOT import from javafx package
import java.awt.*;
import java.util.*;

import objectdraw.*;

/**---File Header---/
 * File: CSE8B_Line.java
 * Author: Chih-Hsuan Kao, cs8bwagy
 * Login: cs8bwagy
 * Email: c4kao@ucsd.edu
 * Date: Feb 15, 2018
 * Sources of Help: Tutor Hours
 */

/**---Class Header---/
 * The CSE8B_Line class can create a line, connected by two points.
 * It contains methods that can move the object, compare two objects, 
 * print out string contents and draw it on canvas. 
 * Its instance variables are Point start and Point end. 
 */
public class CSE8B_Line extends Shape {
    private Point start;
    private Point end;

    /**
     * The no-arg constructor for the CSE8B_Line class. 
     * This initializes a new line with two new Points.
     */
    public CSE8B_Line() {
        setStart(new Point());
        setEnd(new Point());
    }

    /**
     * A constructor for the class.
     * This initializes a new line with two passed in points.
     * Deep copy is performed.
     * @param Point start
     * @param Point end
     */
    public CSE8B_Line(Point start, Point end) {
        setStart(new Point(start));
        setEnd(new Point(end));
    }

    /**
     * A constructor for the class.
     * This initializes a new line with a line passed in.
     * Deep copy is performed.
     * @param CSE8B_Line line
     */
    public CSE8B_Line(CSE8B_Line line) {
        this(new Point(line.getStart()),new Point(line.getEnd()));
    }

    /**Method: getStart
     * Getter for the instance variable Point start
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return Point startPoint
     */
    public Point getStart() {
        Point startPoint = this.start;
        return startPoint;
    }

    /**Method:setStart
     * Setter for the instance variable Point start
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param Point start
     * @return none
     */
    private void setStart(Point start) {
        this.start = start;
    }

    /**Method: getEnd
     * Getter for the instance variable Point end
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return Point endPoint
     */
    public Point getEnd() {
        Point endPoint = this.end;
        return endPoint;
    }

    /**Method: setEnd
     * Setter for the instance variable Point end
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param Point end
     * @return none
     */
    private void setEnd(Point end) {
        this.end = end;
    }

    /**Method: move
     * Moves this line by a certain x and y amount.
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param deltaX The amount to increase x coord 
     * @param deltaY The amount to increase y coord
     * @return none
     */
    @Override
    public void move(int deltaX, int deltaY) {
        this.getStart().move(deltaX,deltaY);
        this.getEnd().move(deltaX,deltaY);
    }

    /**Method: toString
     * Generates the string representation of this Line
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return A string in the form "CSE8B_Line: Point: (x,y)
     *         to Point: (x,y)"
     */
    @Override
    public String toString() {
        int StartX = this.getStart().getX();
        int StartY = this.getStart().getY();
        int EndX = this.getEnd().getX();
        int EndY = this.getEnd().getY();
        String toReturn = "CSE8B_Line: Point: ("+
            StartX + ","+ StartY + ") to Point: (" +
            EndX + ","+ EndY + ")"; 
        return toReturn;
    }

    /**Method: equals
     * Determines whether this CSE8B_Line is equivalent to another object.
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param Object o: to be compared to this line
     * @return boolean true: if o is a non-null instance of CSE8B_Line
     *                 false: otherwise
     */

    @Override
    public boolean equals(Object o) {
        //make sure the Object o is non-null
        if(o == null){
            return false;
        }
        if(o instanceof CSE8B_Line){
            //casting object o to CSE8B_Line if o is instanceof CSE8B_Line
            CSE8B_Line ObjLine = (CSE8B_Line)o;

            //after casting, return true if both have same start and end points
            if(this.getStart().getX()==ObjLine.getStart().getX()
                    && this.getStart().getY() == ObjLine.getStart().getY()
                    && this.getEnd().getX() == ObjLine.getEnd().getX()
                    && this.getEnd().getY() == ObjLine.getEnd().getY()){
                return true;
                    } 
            //otherwise, return false
            return false;
        } return false;
    }

    /**Method: draw
     * Defer to the second draw method by passing in parameters
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param DrawingCanvas canvas
     * @return none
     */
    public void draw(DrawingCanvas canvas) {
        //generate a random number of rgb components of color
        Random ramGenerator = new Random();
        //generate a new color
        Color color = new Color(ramGenerator.nextInt(255),
                ramGenerator.nextInt(255),ramGenerator.nextInt(255));
        //call the second draw method 
        this.draw(canvas,color,true);
    }

    /**Method: draw
     * A draw method that actually draws the shape on canvas.
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param DrawingCanvas canvas: to be drawn on
     * @param Color c: color of the line
     * @param boolean fill: for this class, it doesn't matter 
     *                      since lines are both framed and filled
     *                      Will draw under both true and false.
     * @return none
     */

    public void draw(DrawingCanvas canvas, Color c, boolean fill) {

        //get the start and end point of the line
        double startX = this.getStart().getX();
        double startY = this.getStart().getY();
        double endX = this.getEnd().getX();
        double endY = this.getEnd().getY();

        //if the color parameter is null, use the black color
        if(c == null){
            c = Color.BLACK;
        }
        //Create a Line object to draw on canvas
        Line lineDraw = new Line(startX,startY,endX,endY,canvas);
        lineDraw.setColor(c);
    }
}
