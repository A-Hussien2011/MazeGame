/**
 *
 */
package enemy_follow_player;

/**
 * @author Personal
 *
 */
public class FollowPlayer {

	/*GenerateGame game;
	Cell[][] maze;
	Level level;
	public FollowPlayer (GenerateGame game) {
		this.game = game;
		maze = game.getMaze();
		level = game.getLevel();
	}

	*//*this method returns a stack of points where the top of the stack is
	 * the player position, so the monster starts moving from index(0) and so on.
	 *//*
	public Stack<Point> follow(Point playerPosition, Point monsterPosition) {

		boolean[][] visites = new boolean[level.getMazeSize().x][level.getMazeSize().y];
		Point start = monsterPosition;
		Stack<Point> stack = new Stack<Point>();
		stack.push(start);
		while (!(stack.isEmpty())) {
			start = stack.peek();
			visites[start.x][start.y] = true;
			int[] y = {0, 0, -1, 1};
			int[] x = {1, -1, 0, 0};
			if (start.equals(playerPosition)) {
				stack.remove(0);
				return stack;
			}
			int i = 0;
			for (i = 0; i < x.length; i++) {
				int rowNum = start.x + x[i];
				int colNum = start.y + y[i];
				if (rowNum < level.getMazeSize().x && colNum < level.getMazeSize().y
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

		//remove the current position of the monster.
		stack.remove(0);
		return stack;
	}
*/
}
