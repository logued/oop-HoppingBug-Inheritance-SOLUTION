package org.example;
/**
 * Demonstrates INHERITANCE.
 * The HoppingBug class extends the Bug class, so, 
 * HoppingBug inherits all fields and methods from the Bug class.
 * (This is an example of reusing code that exists in Bug)
 * 
 * One new field "hoppingDistance" is added to HoppingBug, to store the hop distance.
 * 
 * The move method() in HoppingBug must be different from the one defined in Bug
 * because the HoppingBug will move a 'hop' distance each time move() is called.
 * Therefore, we must override the move() method in the HoppingBug class to
 * change its behavior.
 *
 * The turn() functionality is the same in both Bug and HoppingBug,
 * so, the HoppingBug class inherits the turn() method 'as-is' from Bug with no
 * redefinition required.
 * 
 * We must write a HoppingBug constructor that initializes the hop distance field,
 * and which initializes the fields defined in the Bug (base class/ superclass),
 * using a call to "super( ... )"
 */

import enums.Direction;

public class HoppingBug extends Bug {       // "extends" means to "inherit from"

    private int hoppingDistance;
    
    public HoppingBug(int hoppingDistance, int initialPosition, Direction initialDirection) 
    {
        super(initialPosition, initialDirection);   // call constructor in the superclass (Base class)
        this.hoppingDistance = hoppingDistance;
    }

    // other constructors left out to avoid clutter

    /**
     * move()
     * Moves the HoppingBug by its 'hoppingDistance' in the direction it is facing.
     * This is different BEHAVIOUR to what is provided by the move() defined in Bug.
     * This move() method overrides the move() method that is inherited from
     * the Bug class.  This must be done as this HoppingBug moves in a different
     * way (it hops).  The behavior is different.
     * Note that we MUST use the Bug classes public getters and setters to access 
     * the position and direction because they are 'private' to the Bug class 
     * (and are therefore not directly accessible by code defined outside the Bug class)
     * (we could make those fields 'protected', but this is not considered best practice)
     */
    @Override
    public void move() 
    {
        if (Direction.RIGHT == getDirection()) {
            setPosition( getPosition() + hoppingDistance );
        } else {
            setPosition( getPosition() - hoppingDistance );
        }
    }

    public int getHoppingDistance() { return hoppingDistance; }

    public void setHoppingDistance(int hoppingDistance) { this.hoppingDistance = hoppingDistance; }

    @Override                   // overrides the toString() method in the Bug class
    public String toString()
    {       // call the superclass toString() to get a string that contains the position and direction
            // and then append the hopping distance.
        return super.toString() + "{hoppingDistance=" + hoppingDistance + '}';
    }  
}
