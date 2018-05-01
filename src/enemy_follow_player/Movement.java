/**
 *
 */
package enemy_follow_player;

import java.awt.Point;
import java.util.Stack;

import drawables.dynamic_drawables.character.monster.Monster;
import drawables.static_drawables.emptyMaze.Empty;
import grid.cellComponent.Cell;
import grid.generation.GenerateGame;

/**
 * @author Personal
 *
 */
public class Movement implements Runnable {

	private GenerateGame game;
	private Point startPoint;
	private Point endPoint;
	private Point transitionPoint;
	Cell[][] maze;

	public Movement (GenerateGame game, Point startPoint, Point endPoint) {
		this.game = game;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.maze = game.getMaze();

	}

	private void moveObjectTo (Point startPoint, Point endPoint) {
		((Monster)(maze[endPoint.x][endPoint.y].getType())).moveTo(endPoint);
		maze[endPoint.x][endPoint.y].setType(maze[startPoint.x][startPoint.y].getType());
		maze[startPoint.x][startPoint.y].setType(new Empty());

	}
	@Override
	public void run() {
		FindPath path = new FindPath(game.getMaze(), game.getLevel().getMazeSize());
		Stack<Point> pathOfPoints = path.getValidPath(startPoint, endPoint);

		int movementsNumber = 0;
		while(!pathOfPoints.isEmpty() && movementsNumber < 6){
			transitionPoint = pathOfPoints.remove(0);
			moveObjectTo(startPoint, transitionPoint);
			startPoint = transitionPoint;
			movementsNumber++;
		}


	}

}
