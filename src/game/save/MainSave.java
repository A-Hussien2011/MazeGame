/**
 *
 */
package game.save;

import javax.xml.transform.TransformerConfigurationException;

import drawables.dynamic_drawables.character.player.derivatives.Princess;
import grid.Levels.builder.derivatives.MediumLevel;
import grid.cellComponent.Cell;
import grid.generation.GenerateGame;

/**
 * @author Personal
 *
 */
public class MainSave {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GenerateGame g = new GenerateGame(new MediumLevel(), Princess.getInstance());
		g.generateMaze();
		Cell[][] maze = g.getMaze();



		Save s = new Save (maze);
		try {
			s.saveMaze("newTrial");
		} catch (TransformerConfigurationException e) {

			e.printStackTrace();
		}

	}

}
