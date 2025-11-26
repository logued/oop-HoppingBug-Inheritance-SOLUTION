package org.example;
/*                          //  November 2025
 * P8.12 - Bug movement.
 * HoppingBug inherits from Bug class and extends its functionality.
 */

import enums.Direction;
import java.util.ArrayList;

public class MainApp
{
    public static void main(String[] args) {
        MainApp app = new MainApp();
        app.start();
    }

    public void start() {
        Bug bug1 = new Bug( 0, Direction.RIGHT );  // start at position 0, facing RIGHT
        bug1.move();
        bug1.move();
        bug1.turn(); // change direction
        bug1.move();
        System.out.println("bug1 ended up at position: " + bug1.getPosition());
        
        Bug bug2 = new Bug();   // calls no-argument constructor, defaults are (0, RIGHT)
        bug2.turn();
        bug2.move();
        System.out.println("bug2 is at position: " + bug2.getPosition());
        // using toString() method
        System.out.println("bug2.toString() : " + bug2.toString());

        // Using HoppingBug subclass objects
        HoppingBug hoppingBug1 = new HoppingBug( 0, 3, Direction.RIGHT ); // start at 0, hop distance of 3
        hoppingBug1.move();  // calls move() method in HoppingBug clas that overrides the one inherited from Bug
        hoppingBug1.move();
        hoppingBug1.move();
        hoppingBug1.turn();   // calls turn() method that was inherited from the Bug class (reusing existing code)
        hoppingBug1.move();
        hoppingBug1.move();
        System.out.println("hoppingBug1 is now at position: " + hoppingBug1.getPosition());
        
        System.out.println("hoppingBug1.toString() : " + hoppingBug1.toString());   // calls overridden toString()
        System.out.println("printing object hoppingBug1, will call toString(): " + hoppingBug1);
        
        HoppingBug hoppingBug2= new HoppingBug(3,0,Direction.RIGHT );
        System.out.println("hoppingBug2: " +hoppingBug2);
        HoppingBug hoppingBug3 = new HoppingBug(5,0, Direction.LEFT);
        System.out.println("hoppingBug3: " +hoppingBug3);

        // As HoppingBug inherits from Bug, we can use a reference of type Bug
        // to point at either a Bug or HoppingBug object.  So, we can store both
        // types of bugs in an ArrayList<Bug> and make use of polymorphic behaviour when we
        // call the move() method on each object in the ArrayList.

        ArrayList<Bug> bugList = new ArrayList<>();
        bugList.add(bug1);
        bugList.add(bug2);              //add both types of bug objects to arraylist
        bugList.add(hoppingBug1);
        bugList.add(hoppingBug2);

        // Use Polymorphism to call the move() method against each object
        // The version of the move() method called depends on the type
        // of the object in question. If the object is of type Bug then the
        // move() method as defined in the Bug class is called.
        // If the object is of type HoppingBug, then the move() defined
        // in the hoppingBug class is called. This is what is called polymorphism.
        System.out.println("Move all bugs in ArrayList, and print them out.");
        for( Bug bug : bugList) {       // move all the bugs in the list
            bug.move();
        }

        for(Bug bug : bugList) {
            System.out.println(bug.toString());
        }
    }
}
