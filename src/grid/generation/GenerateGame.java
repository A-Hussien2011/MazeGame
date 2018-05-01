/**
 *
 */
package grid.generation;

import javax.swing.JLabel;

import drawables.dynamic_drawables.character.player.Player;
import grid.Levels.Level;
import grid.Levels.builder.ILevelBuilder;
import grid.Levels.builder.generate.GenerateLevel;
import grid.cellComponent.Cell;
import grid.generation.initialize_components.GenerateComponent;
import grid.generation.initialize_maze.Maze;
import grid.generation.initialize_player.GeneratePlayer;

/**
 * @author Personal
 *
 */
public class GenerateGame implements IGameGeneration{
	private Player player;
	private Level level;

	private Cell[][] maze;

	public GenerateGame (ILevelBuilder levelBuilder, Player player) {
		this.player = player;
		setILevelBuilder(levelBuilder);
	}


	@Override
	public Player getPlayer() {
		return player;
	}


	private void setILevelBuilder(ILevelBuilder levelBuilder) {
		GenerateLevel g = new GenerateLevel(levelBuilder);
		g.generate();
		level = g.getLevel();

	}

	@Override
	public Level getLevel() {
		return level;
	}

	@Override
	public void generateMaze() {
		Maze m = new Maze(level.getMazeSize());
		m.generate();

		GenerateComponent g = new GenerateComponent(level, m);
		g.generateGridComponents();

		maze = g.getCellMaze();
		GeneratePlayer p = new GeneratePlayer(player);
		p.generatePlayer(maze, level);
	}

	@Override
	public Cell[][] getMaze() {
		return maze;
	}
}
