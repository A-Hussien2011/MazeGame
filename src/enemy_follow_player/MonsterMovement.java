/**
 *
 */
package enemy_follow_player;

import java.awt.Point;

import drawables.dynamic_drawables.character.monster.Monster;
import grid.cellComponent.Cell;
import grid.generation.GenerateGame;

/**
 * @author Personal
 *
 */
public class MonsterMovement {

	private Cell[][] maze;
	private GenerateGame game;
	private Point monsterCenterPoint;
	private Point playerPosition;

	public MonsterMovement(GenerateGame game, Point monsterCenterPoint, Point playerPosition) {
		this.maze = game.getMaze();
		this.game = game;
		this.monsterCenterPoint = monsterCenterPoint;
		this.playerPosition = playerPosition;

	}

	public void moveMonster() {
		while (((Monster) (maze[monsterCenterPoint.y][monsterCenterPoint.x].getType())).isCharacterAlive()) {
			Thread move = new Thread(new Movement(game, monsterCenterPoint, playerPosition));
			move.start();
			move = new Thread(new Movement(game, playerPosition, monsterCenterPoint));
			move.start();
		}
	}
}
