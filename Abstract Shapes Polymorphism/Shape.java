// DO NOT import from javafx package
import java.awt.*;
import java.util.*;

import objectdraw.*;

/**---File Header---/
 * File: Shape.java
 * Author: Chih-Hsuan Kao
 * Login: cs8bwagy
 * Email: c4kao@ucsd.edu
 * Date: Feb 15, 2018
 * Source of Help: Tutor Hours
 */

/**---Class Header---/
 * The Shape class is an abstract class that is the super class
 * of other shapes, and some of its methods need to be overriden.
 * It has an instance variable, a private String name. 
 */
public abstract class Shape {
    private String name;

    /**
     * The no-arg constructor for the Shape class. 
     * This initializes the name with the string "Shape"
     */
    public Shape() {
        setName(new String("Shape"));
    }

    /**
     * A constructor for the class.
     * This initializes a shape with a string name passed in.
     * @param String name
     */
    public Shape(String name) {
        setName(new String(name));
    }

    /**Method: getName
     * A getter method to get the String name. 
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return String name
     */
    public String getName() {
        String stringName = this.name;
        return stringName;
    }

    /**Method: setName
     * A setter method to set name to the shape
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param String name
     * @return none
     */ 
    private void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        String s = "\n**********************************************************\n"
            + "This should never print. If it does print, then\n"
            + "you did not override equals() properly in class "
            + this.getClass().getName() + "\n"
            + "**********************************************************\n";

        System.out.println(s);

        return this == o;
    }

    public abstract void move(int xDelta, int yDelta);

    public abstract void draw(DrawingCanvas canvas);

    public abstract void draw(DrawingCanvas canvas, Color c, boolean fill);
}
