/**
 *
 */
package enemy_follow_player;

import java.awt.Point;
import java.util.Stack;

import grid.cellComponent.Cell;

/**
 * @author Personal
 *
 */
public class FindPath {

	Cell[][] maze;
	Point mazeSize;
	public FindPath (Cell[][] maze, Point mazeSize) {
		this.maze = maze;
		this.mazeSize = mazeSize;
	}

	/*this method returns a stack of points where the top of the stack is
	 * the player position, so the monster starts moving from index(0) and so on.
	 */
	private Stack<Point> follow(Point startPoint, Point endPoint) {

		boolean[][] visites = new boolean[mazeSize.x][mazeSize.y];
		Point start = startPoint;
		Stack<Point> stack = new Stack<Point>();
		stack.push(start);
		while (!(stack.isEmpty())) {
			start = stack.peek();
			visites[start.x][start.y] = true;
			int[] y = {0, 0, -1, 1};
			int[] x = {1, -1, 0, 0};
			if (start.equals(endPoint)) {
				stack.remove(0);
				return stack;
			}
			int i = 0;
			for (i = 0; i < x.length; i++) {
				int rowNum = start.x + x[i];
				int colNum = start.y + y[i];
				if (rowNum < mazeSize.x && colNum < mazeSize.y
				&& rowNum >= 0 && colNum >= 0
				&& !visites[rowNum][colNum]
				&& !maze[rowNum][colNum].getClassName().equals("StoneWall")) {
					Point p = new Point(rowNum, colNum);
					stack.push(p);
						break;
				}
			}
			if (i == x.length) {
				stack.pop();
			}
		}

		stack.remove(0);
		return stack;
	}

	public Stack<Point> getValidPath (Point startPoint, Point endPoint) {
		Stack<Point> pathOfPoints = follow(startPoint, endPoint);
		Stack<Point> absolutePath = new Stack<Point>();
		while (!pathOfPoints.isEmpty()) {
			Point p = pathOfPoints.remove(0);
			if (!maze[p.x][p.y].getValidity()) {
				break;
			}
			absolutePath.push(p);
		}
		return absolutePath;
	}

}
