/**
 *  P8.12   Bug
 *  In this program, the Bug class implements the behaviour of a Bug.
 *  The HoppingBug class inherits from this class in order to reuse the
 *  code defined in Bug. Some methods must be overridden in the
 *  HoppingBug subclass, such as move() , because the move behaviour of
 *  a HoppingBug is different from that of the Bug. Whereas, the turn()
 *  method is simply inherited from Bug because the turn behaviour is the
 *  same in both classes.
 */
package org.example;
import enums.Direction; // Enumeration class

public class Bug
{
    private Direction direction;  // see Enumeration in Direction.java
    private int position; // current position;
    
    public Bug()            // no-argument constructor
    {
        this.position = 0;
        this.direction = Direction.RIGHT;
    }
    
    public Bug(int initialPosition)
    {
        this.position = initialPosition;
        this.direction = Direction.RIGHT;   //initial direction
    }

    public Bug(int initialPosition, Direction initialDirection)
    {
        this.position = initialPosition;
        this.direction = initialDirection;   //initial direction
    }

    public void turn()
    {
        if (Direction.RIGHT == this.direction) {
            direction = Direction.LEFT;  // reverse direction
        } else {
            direction = Direction.RIGHT;
        }
    }

    public void move()
    {
        if (Direction.RIGHT == this.direction) {
            this.position++;
        } else {
            this.position--;
        }
    }
 
    public int getPosition() { return this.position; }
    public Direction getDirection() { return this.direction; }
    public void setDirection(Direction direction) { this.direction = direction; }
    public void setPosition(int position) { this.position = position; }

    @Override                   // overrides the toString()method in Object superclass
    public String toString()
    {
        return getClass() + "{direction=" + this.direction + ", position=" + this.position + '}';
    }
    
}
