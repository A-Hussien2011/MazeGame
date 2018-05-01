/**
 *
 */
package grid.generation.initialize_maze;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Personal
 *
 */
public class Maze {

    private static final int WALL = 0;
    private static final int SPACE = 1;

    private byte[][] data;
    private Point[][] backTracking;
    private int width;
    private int height;

    private List<Point> path;
    private java.util.Random rand = new java.util.Random();

	public Maze (Point dimension) {
		this.height = dimension.x;
		this.width = dimension.y;
        data = new byte[height][width];
        backTracking = new Point[height][width];
        path = new ArrayList<Point>();

	}

	 private void carve(int x, int y) {

         final int[] upx = { 1, -1, 0, 0 };
         final int[] upy = { 0, 0, 1, -1 };

         int dir = rand.nextInt(4);
         int count = 0;
         while(count < 4) {
            final int x1 = x + upx[dir];
            final int y1 = y + upy[dir];
            final int x2 = x1 + upx[dir];
            final int y2 = y1 + upy[dir];
            if (!(x1 >= 0 && x1 < height && y1 >= 0 && y1 < width
            		&& x2 >= 0 && x2 < height && y2 >= 0 && y2 < width)) {
            	dir = (dir + 1) % 4;
                count += 1;
                continue;
            }
            if(data[x1][y1] == WALL && data[x2][y2] == WALL) {
               data[x1][y1] = SPACE;
               data[x2][y2] = SPACE;
               backTracking[x1][y1] = new Point(x, y);
               backTracking[x2][y2] = new Point(x1, y1);
               carve(x2, y2);
            } else {
               dir = (dir + 1) % 4;
               count += 1;
            }
         }
      }

     public void generate() {
        for(int x = 0; x < height; x++) {
           data[x] = new byte[width];
           for(int y = 0; y < width; y++) {
              data[x][y] = WALL;
           }
        }

        data[1][1] = SPACE;
        carve(1, 1);

        for(int x = 0; x < width; x++) {
            data[0][x] = WALL;
            data[height - 1][x] = WALL;
         }

   	  for(int x = 0; x < height; x++) {
   		  data[x][0] = WALL;
   		  data[x][width - 1] = WALL;

         }

   	  	setMazePath();
        data[0][1] = SPACE;
        data[height - 1][width - 2] = SPACE;

     }

     private void setMazePath () {
   	  Point start = new Point(1, 1);
   	  path.add(start);

   	  Point currentPoint = new Point(height - 2, width - 2);

   	  while (!currentPoint.equals(start)) {
   		  path.add(currentPoint);
   		  currentPoint = backTracking[currentPoint.x][currentPoint.y];
   	  }
     }

     public List<Point> getPath () {
   	  return path;
     }

     public byte[][] getGrid () {
   	  byte[][] grid = new byte[height][width];
   	  for (int i = 0; i < height; i++) {
   		  for (int j = 0; j < width; j++) {
   			  grid[i][j] = data[i][j];
   		  }
   	  }
     	//set the end with number 9

   	 // grid[height - 2][width - 2] = 9;
   	  return grid;
     }

     public void print() {
        for(int y = 0; y < height; y++) {
           for(int x = 0; x < width; x++) {
              if(data[y][x] == 0) {
                 System.out.print("[]");
              } else {
                 System.out.print("  ");
              }
           }
           System.out.println();
        }
     }

     public Point getPathMiddlePoint () {
   	  Point middle = path.get(path.size()/2);
   	  return middle;
     }
}
