import java.util.ArrayList; //importing Array List class
import java.util.List;      // importing List class
import java.util.Random;    // importing Random class

/*
simulate ants finding the shortest path between two points on a grid.
The Ant class represents an ant which moves around the grid.
The move() method determines the next position for the ant based on its current position and the grid.
The getNeighbors() method returns a list of neighboring positions around the ant's current position.
The pickNextPosition() method randomly selects one of the neighboring positions for the ant to move to.
The AntRoutingExample class is the main class where the simulation is run. It initializes the grid, creates an ant, and moves it for a certain number of steps.
 */

class Ant {
    private int x; // creating integer x axis for the grid
    private int y; // creating integer y axis for the grid
    private int[][] grid; // 2d array as the grid

    public Ant(int x, int y, int[][] grid) { // a constructor creating an ant on the grid
        this.x = x; // assigning x coordinate of ant
        this.y = y; // assigning y coordinate of ant
        this.grid = grid;  // assigning grid
    }

    public void move() { // creating method to move ant
        List<int[]> neighbors = getNeighbors(x, y, grid.length, grid[0].length); // assigns neighboring positions for ant to move to
        int[] nextPosition = pickNextPosition(neighbors); // assigns nextPosition location using pickNextPosition
        this.x = nextPosition[0]; // updates x coordinate
        this.y = nextPosition[1]; // updates y coordinate
    }

    private List<int[]> getNeighbors(int x, int y, int maxX, int maxY) { // method to get neighboring positions in a list
        List<int[]> neighbors = new ArrayList<>(); // making new list for neighbors
        for (int dx = -1; dx <= 1; dx++) { // post increment for loop going through neighbor x coordinates
            for (int dy = -1; dy <= 1; dy++) { // inside loop going through y coordinates
                int newX = x + dx; // calculating newX and assigning it as the new x coordinate
                int newY = y + dy; // calculating newY and assigning it as the new y` coordinate
                if (newX >= 0 && newX < maxX && newY >= 0 && newY < maxY && !(dx == 0 && dy == 0)) { // if condition added in order to  add valid values
                    neighbors.add(new int[]{newX, newY}); // checking previous if condition and adding new coordinates to the list
                }
            }
        }
        return neighbors; // returns list of neighbor coordinates
    }

    private int[] pickNextPosition(List<int[]> neighbors) { // method to randomly select next neighboring position
        Random rand = new Random(); // assigning object rand a random integer
        int index = rand.nextInt(neighbors.size()); // generates a random index from the neighbor's list
        return neighbors.get(index); // returns randomly selected neighbor position
    }

    public int getX() { // getter method for getting x value
        return x;
    }

    public int getY() { // getter method to get y coordinate
        return y;
    }
}

public class AntRoutingExample {

    public static void main(String[] args) { // calls main method
        int[][] grid = new int[10][10]; // creates a 2d grid, 10x10

        grid[3][3] = 1; // Set obstacle at (3,3)

        Ant ant = new Ant(0, 0, grid); // creates ant object at 0,0 on grid
        int steps = 20; // assigns 20 to steps ants will walk
        for (int i = 0; i < steps; i++) { // for loop to increase i by one at the end of each loop
            ant.move(); // moves ant
            System.out.println("Ant moved to: (" + ant.getX() + ", " + ant.getY() + ")"); // prints position ant moved to
        }
    }
}