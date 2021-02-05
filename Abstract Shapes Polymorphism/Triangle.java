// DO NOT import from javafx package
import java.awt.*;
import java.util.*;

import objectdraw.*;

/**---File Header---/
 * File: Triangle.java
 * Author: Chih-Hsuan Kao
 * Login: cs8bwagy
 * Email: c4kao@ucsd.edu
 * Date: Feb 16,2018
 * Sources of Help: Tutor Hours
 */
public class Triangle extends Shape {
    private Point p1;
    private Point p2;
    private Point p3;

    /**
     * The no-arg constructor for the Triangle class. 
     * This initializes three private Points p1, p2 and p3. 
     * Each represents vertex of the Triangle.
     */
    public Triangle() {
        setPoint1(new Point());
        setPoint2(new Point());
        setPoint3(new Point());
    }

    /**
     * A constructor for the Triangle class. 
     * This constructor initializes a new Triangle with the passed-in
     * Point p1, p2 and p3. 
     * Deep copy is performed. 
     * @param Point p1: 1st vertex of the object
     * @param Point p2: 2nd vertex of the object
     * @param Point p3: 3rd vertex of the object
     */
    public Triangle(Point p1, Point p2, Point p3) {
        setPoint1(new Point(p1));
        setPoint2(new Point(p2));
        setPoint3(new Point(p3));
    }

    /**
     * A constructor for the Triangle class.
     * This constructor initializes a new Triangle with a passed-in
     * Triangle tri. Deep copy is performed. 
     * @param Triangle tri: the triangle to be copied
     */
    public Triangle(Triangle tri) {
        this(new Point(tri.getPoint1()),new Point(tri.getPoint2()),
                new Point(tri.getPoint3()));
    }

    /**Method: getPoint1
     * Getter method for the instance variable Point p1
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return Point p1: the first vertex of Triangle
     */
    public Point getPoint1() {
        Point point1 = this.p1;
        return point1;
    }

    /**Method: setPoint1
     * Setter method for the instance variable Point p1
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param Point p1: the first vertex of Triangle to be set
     * @return none
     */
    private void setPoint1(Point p1) {
        this.p1 = p1;
    }

    /**Method: getPoint2
     * Getter method for the instance variable Point p2
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return Point p2: the second vertex of Triangle
     */
    public Point getPoint2() {
        Point point2 = this.p2;
        return point2;
    }

    /**Method: setPoint2
     * Setter method for the instance variable Point p2
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param Point p2: the second vertex of Triangle to be set
     * @return none
     */
    private void setPoint2(Point p2) {
        this.p2 = p2;
    }

    /**Method: getPoint3
     * Getter method for the instance variable Point p3
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return Point p3: the third vertex of Triangle
     */
    public Point getPoint3() {
        Point point3 = this.p3;
        return point3;
    }

    /**Method: setPoint3
     * Setter method for the instance variable Point p3
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param Point p3: the third vertex of Triangle to be set
     * @return none
     */
    private void setPoint3(Point p3) {
        this.p3 = p3;
    }

    /**Method: move
     * Moves this Triangle by a certain x and y amount
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param deltaX The amount to increase x coordinate
     * @param deltaY The amount ot increase y coordinate
     * @return none
     */
    @Override
    public void move(int deltaX, int deltaY) {
        this.getPoint1().move(deltaX,deltaY);
        this.getPoint2().move(deltaX,deltaY);
        this.getPoint3().move(deltaX,deltaY);
    }

    /**Method: toString
     * Generates the string representation of this Triangle
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return A string in the form "Triangle: Point: (x,y), Point: (x,y), 
     *                               Point: (x,y)"
     */
    @Override
    public String toString() {

        int p1X = this.getPoint1().getX();
        int p1Y = this.getPoint1().getY();
        int p2X = this.getPoint2().getX();
        int p2Y = this.getPoint2().getY();
        int p3X = this.getPoint3().getX();
        int p3Y = this.getPoint3().getY();

        String toReturn = "Triangle: Point: (" + p1X + "," + p1Y + "),"+
            " Point: (" + p2X + "," + p2Y + "),"+
            " Point: (" + p3X + "," + p3Y + ")";
        return toReturn;
    }

    /**Method: equals
     * Determines whether this Triangle is equivalent to another object
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param Object o: to be compared to this Triangle
     * @return boolean true: if o is a non-null instance of Triangle
     *                 false: otherwise
     */
    @Override
    public boolean equals(Object o) {
        //make sure the Object o is non-null
        if(o == null){
            return false;
        }
        if(o instanceof Triangle){
            //casting object o to Triangle if o is instance of Triangle
            Triangle objTri = (Triangle)o;

            //after casting, return true if both have same vertices
            if(this.getPoint1().getX() == objTri.getPoint1().getX()
                    && this.getPoint1().getY() == objTri.getPoint1().getY()
                    && this.getPoint2().getX() == objTri.getPoint2().getX()
                    && this.getPoint2().getY() == objTri.getPoint2().getY()
                    && this.getPoint3().getX() == objTri.getPoint3().getX()
                    && this.getPoint3().getY() == objTri.getPoint3().getY()){
                return true;
                    }
            //otherwise, return false
            return false;
        }return false;
    }

    /**Method: draw
     * Defer to the second draw method by passing in parameters
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param DrawingCanvas canvas: canvas to be drawn on
     * @return none
     */
    public void draw(DrawingCanvas canvas) {
        //generate a random number for rgb components of the color
        Random ramGenerator = new Random();
        //generate a new color
        Color color = new Color(ramGenerator.nextInt(255),
                ramGenerator.nextInt(255),ramGenerator.nextInt(255));
        //call the second draw method
        this.draw(canvas,color,true);
    }

    /**Method: draw 
     * A draw method that actually draws the Triangle on canvas
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param DrawingCanvas canvas: to be drawn on
     * @param Color c: color of the Circle
     * @param boolean fill: true if filled Triangle
     *                      false if framed Triangle
     * @return none
     */
    public void draw(DrawingCanvas canvas, Color c, boolean fill) {

        double p1x = this.getPoint1().getX();
        double p1y = this.getPoint1().getY();
        double p2x = this.getPoint2().getX();
        double p2y = this.getPoint2().getY();
        double p3x = this.getPoint3().getX();
        double p3y = this.getPoint3().getY();

        //if color parameter is null, use black color
        if(c == null){
            c = Color.BLACK;
        }
        //Triangle is a shape that is composed of 3 lines
        //don't need to consider the fill situation for triangle
        Line lineDraw12 = new Line(p1x,p1y,p2x,p2y,canvas);
        lineDraw12.setColor(c);
        Line lineDraw23 = new Line(p2x,p2y,p3x,p3y,canvas);
        lineDraw23.setColor(c);
        Line lineDraw31 = new Line(p3x,p3y,p1x,p1y,canvas);
        lineDraw31.setColor(c);

    }

}
