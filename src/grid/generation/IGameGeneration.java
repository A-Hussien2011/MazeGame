/**
 *
 */
package grid.generation;

import drawables.dynamic_drawables.character.player.Player;
import grid.Levels.Level;
import grid.cellComponent.Cell;

/**
 * @author Personal
 *
 */
public interface IGameGeneration {

	public Player getPlayer ();
	public Level getLevel ();
	public void generateMaze();
	public Cell[][] getMaze ();
}
