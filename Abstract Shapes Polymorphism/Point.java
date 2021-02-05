/**---File Header---/
 * File: Point.java
 * Author: Chih-Hsuan Kao
 * Login: cs8bwagy
 * Email: c4kao@ucsd.edu
 * Date: Feb 15, 2018
 * Sources of Help: Tutor Hours
 */

/**---Class Header---/
 * The Point class represents a single 2D location that our
 * shapes will use. Its instance variables are private int x and y. 
 */
public class Point {

    // The x coordinate of this point. getX() and setX() are the only two
    // methods that should access this variable (not even constructors!).
    private int x;

    // The y coordinate of this point. getY() and setY() are the only two
    // methods that should access this variable (not even constructors!).
    private int y;

    /**
     * The no-arg constructor for the Point class. This initializes a new
     * point with an x and y of 0.
     */
    public Point() {
        setX(0);
        setY(0);
    }

    /**
     * The general constructor for the Point class. This initializes a new
     * Point at the specified x and y location.
     * 
     * @param x The x position of the new Point.
     * @param y The y position of the new Point.
     */
    public Point(int x, int y) {
        setX(x);
        setY(y);
    }

    /**
     * Copy constructor for the Point class. This initializes a new Point at
     * the same x and y as another point.
     * 
     * @param point The Point whose x and y values to copy.
     */
    public Point(Point point) {
        setX(point.getX());
        setY(point.getY());
    }

    /**Method: getX
     * Getter for the x coordinate of this Point.
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return The x position for this Point.
     */
    public int getX() {
        int value = this.x;
        return value;
    }

    /**Method: setX
     * Setter for the x coordinate of this Point.
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param x The new x coordinate to move this Point to.
     * @return none
     */
    private void setX(int x) {
        this.x = x;
    }

    /**Method: getY
     * Getter for the y coordinate of this Point.
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return The y position for this Point.
     */
    public int getY() {
        int value = this.y;
        return value;
    }

    /**Method: setY
     * Setter for the y coordinate of this Point.
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param y The new y coordinate to move this Point to.
     * @return none
     */
    private void setY(int y) {
        this.y = y;
    }

    /**Method: move
     * Moves this Point by a certain x and y amount.
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param deltaX The amount to increase the x coordinate
     *               of this point.
     * @param deltaY The amount to increase the y coordinate
     *               of this point.
     * @return none
     */
    public void move(int deltaX, int deltaY) {
        int nextX = this.getX() + deltaX;
        int nextY = this.getY() + deltaY;
        this.setX(nextX);
        this.setY(nextY);
    }

    /**Method: toString
     * Generates the string representation of this Point so that it can be
     * displayed to the user.
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param none
     * @return A string in the form "Point: (x,y)"
     */
    @Override
    public String toString() {
        int i = this.getX();
        int j = this.getY();
        String string = "Point: (" + i + "," + j + ")";
        return string;
    }

    /**Method: equals
     * Determines whether this Point is equivalent to another object.
     * Name: Chih-Hsuan Kao, cs8bwagy
     * @param o The object to compare this Point to.
     * @return True only if o is a non-null instance of the Point class
     *         with the same x and y coordinates as this point, false
     *         otherwise.
     */
    @Override
    public boolean equals(Object o) {
        //make sure that the Object o is non-null
        if(o == null){
            return false;
        }
        //downcast the Object o to type Point if o is instanceof Point type
        if(o instanceof Point){
            Point obj = (Point)o;

            //after casting, return true if have same x and y coordinates
            if((this.getX() == obj.getX())&& (this.getY() == obj.getY())){
                return true;
            }
            //otherwise, return false;
            return false;
        }
        return false;
    }

}
