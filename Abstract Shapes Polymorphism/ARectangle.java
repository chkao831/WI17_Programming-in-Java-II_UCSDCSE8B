// DO NOT import from javafx package
import java.awt.*;
import java.util.*;

import objectdraw.*;

/**---File Header---/
 * File: ARectangle
 * Author: Chih-Hsuan Kao
 * Login: cs8bwagy
 * Email: c4kao@ucsd.edu
 * Date: Feb 15, 2018
 * Sources of Help: Tutor Hours
 */

/**---Class Header---/
 * The ARectangle class is an abstract class that extends Shape class. 
 * It is inherited by both the Square and Rectangle classes.
 * It has one instance variable, a Point that indicates the top left corner from
 * which it draws. 
 */
public abstract class ARectangle extends Shape {
    private Point upperLeft;

    /**
     * The no-arg constructor for ARectangle class. 
     */
    public ARectangle() {
        this("ARectangle",0,0);
    }

    public ARectangle(String name, int x, int y) {
        this(new String("ARectangle"),new Point(x,y));
    }

    public ARectangle(String name, Point upperLeft) {
        //calling parent's constructor and passing in the name parameter
        super(new String(name));
        //set the upperLeft field with the point parameter
        setUpperLeft(new Point(upperLeft));
    }

    public ARectangle(ARectangle r) {
        this(new String(r.getName()),new Point(r.getUpperLeft()));
    }

    /* Method: getUpperLeft
     *
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return
     **/
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /* Method: setUpperLeft
     *
     **/
    private void setUpperLeft(Point point) {
        this.upperLeft = new Point(point);
    }

    @Override
    public void move(int deltaX, int deltaY) {
        this.getUpperLeft().move(deltaX, deltaY);
    }

    @Override
    public String toString() {
        String name = this.getName();
        String toReturn = name + ": Upper Left Corner: " + 
            this.getUpperLeft().toString();
        return toReturn;
    }

    @Override
    public boolean equals(Object o) {
        //make sure the Object o is non-null
        if(o == null){
            return false;
        }
        //downcast the Object o to type ARectangle if o is instanceOf ARectangle
        //type
        if(o instanceof ARectangle){
            ARectangle objAR = (ARectangle)o;

            //after casting, return true if have same x and y coordinates
            if((this.getUpperLeft().getX() == objAR.getUpperLeft().getX())
                    && (this.getUpperLeft().getY() == 
                        objAR.getUpperLeft().getY())){
                return true;
            }
            //otherwise, return false
            return false;
        }
        return false;

    }
}
