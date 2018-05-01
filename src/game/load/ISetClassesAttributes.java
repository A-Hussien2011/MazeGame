/**
 *
 */
package game.load;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLStreamException;

import drawables.dynamic_drawables.bullet.Bullet;
import drawables.dynamic_drawables.bullet.derivatives.FireBullet;
import drawables.dynamic_drawables.bullet.derivatives.IceBullet;
import drawables.dynamic_drawables.character.monster.Monster;
import drawables.dynamic_drawables.character.player.Player;
import drawables.static_drawables.wall.derivatives.TreeWall;
import grid.cellComponent.Cell;
import grid.generation.initialize_components.CellFactory;
import grid.generation.initialize_components.Factory;

/**
 * @author Personal
 *
 */
interface ISetClassesAttributes {
	public void setClassAttributes(Cell[][] maze, Map<String, Object> map) throws XMLStreamException;

}

class addStaticAttributes implements ISetClassesAttributes {

	@Override
	public void setClassAttributes(Cell[][] maze, Map<String, Object> map) throws XMLStreamException {
		CellFactory factory = new Factory();
		Cell c = factory.getCellClass(Integer.parseInt((map.get("TYPE")).toString()));
		int row = Integer.parseInt(map.get("ROW").toString());
		int col = Integer.parseInt(map.get("COLUMN").toString());
		maze[row][col] = c;
	}

}

class addPlayerAttributes implements ISetClassesAttributes {

	@Override
	public void setClassAttributes(Cell[][] maze, Map<String, Object> map) throws XMLStreamException {
		CellFactory factory = new Factory();
		Cell<Player> c = factory.getCellClass(Integer.parseInt((map.get("TYPE")).toString()));
		int row = Integer.parseInt(map.get("ROW").toString());
		int col = Integer.parseInt(map.get("COLUMN").toString());
		maze[row][col] = c;
		c.getType().setCharacterHealth(Double.parseDouble(map.get("HEALTH").toString()));
		c.getType().addScore(Double.parseDouble(map.get("HEALTH").toString()));
		c.getType().setPlayerName((map.get("NAME").toString()));

		int iceBullets =Integer.valueOf(map.get("IceBullet").toString());
		int fireBullets =Integer.valueOf(map.get("FireBullet").toString());

		List<Bullet> bullets = new ArrayList<Bullet>();
		for (int i = 0; i < iceBullets; i++) {
			bullets.add(new IceBullet());
		}
		for (int i = 0; i < fireBullets; i++) {
			bullets.add(new FireBullet());
		}
		c.getType().addBullets(bullets);
	}

}

class addMonsterAttributes implements ISetClassesAttributes {

	@Override
	public void setClassAttributes(Cell[][] maze, Map<String, Object> map) throws XMLStreamException {
		CellFactory factory = new Factory();
		Cell<Monster> c = factory.getCellClass(Integer.parseInt((map.get("TYPE")).toString()));
		int row = Integer.parseInt(map.get("ROW").toString());
		int col = Integer.parseInt(map.get("COLUMN").toString());
		maze[row][col] = c;
		c.getType().setCharacterHealth(Double.parseDouble(map.get("HEALTH").toString()));
	}

}

class addTreeAttributes implements ISetClassesAttributes {

	@Override
	public void setClassAttributes(Cell[][] maze, Map<String, Object> map) throws XMLStreamException {
		CellFactory factory = new Factory();
		Cell<TreeWall> c = factory.getCellClass(Integer.parseInt((map.get("TYPE")).toString()));
		int row = Integer.parseInt(map.get("ROW").toString());
		int col = Integer.parseInt(map.get("COLUMN").toString());
		maze[row][col] = c;
		c.getType().setWallHealth(Double.parseDouble(map.get("HEALTH").toString()));

	}

}