/**
 *
 */
package enemy_follow_player;

import drawables.dynamic_drawables.character.player.derivatives.Princess;
import grid.Levels.builder.derivatives.EasyLevel;
import grid.generation.GenerateGame;

/**
 * @author Personal
 *
 */
public class MainFollow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GenerateGame g = new GenerateGame(new EasyLevel(), Princess.getInstance());
		g.generateMaze();
	//	FollowPlayer f = new FollowPlayer(g);
	//	Stack<Point> s = f.follow(new Point(1,1), new Point(29,29));
	}

}
