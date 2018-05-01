/**
 *
 */
package grid.generation.initialize_player;

import java.util.ArrayList;
import java.util.List;

import drawables.dynamic_drawables.bullet.Bullet;
import drawables.dynamic_drawables.bullet.derivatives.FireBullet;
import drawables.dynamic_drawables.bullet.derivatives.IceBullet;
import drawables.dynamic_drawables.character.player.Player;
import grid.Levels.Level;
import grid.cellComponent.Cell;

/**
 * @author Personal
 *
 */
public class GeneratePlayer {

	Player player;
	public GeneratePlayer (Player player) {
		this.player = player;
	}

	public void generatePlayer(Cell[][] maze, Level level){
		maze[1][1] = new Cell<Player>(player);
		generateBullets(level);

	}
	private void generateBullets (Level level) {
		int iceBullets = level.getIceBulletNumber();
		int fireBullets = level.getFireBulletNumber();

		List<Bullet> bullets = new ArrayList<Bullet>();
		for (int i = 0; i < iceBullets; i++) {
			bullets.add(new IceBullet());
		}
		for (int i = 0; i < fireBullets; i++) {
			bullets.add(new FireBullet());
		}
		player.addBullets(bullets);
	}
}
