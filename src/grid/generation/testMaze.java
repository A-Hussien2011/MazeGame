/**
 *
 */
package grid.generation;

import drawables.dynamic_drawables.character.player.derivatives.Princess;
import grid.Levels.builder.derivatives.HardLevel;
import grid.Levels.builder.derivatives.MediumLevel;

/**
 * @author Personal
 *
 */
public class testMaze {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GenerateGame g = new GenerateGame(new HardLevel(), Princess.getInstance());
		g.generateMaze();


	}

}
