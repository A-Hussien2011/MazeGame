/**
 *
 */
package game.save;

import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import drawables.dynamic_drawables.bullet.Bullet;
import drawables.dynamic_drawables.character.Character;
import drawables.dynamic_drawables.character.player.Player;
import drawables.static_drawables.wall.Wall;
import grid.cellComponent.Cell;

/**
 * @author Personal
 *
 */
interface ISetAttributes {

	public void addAttribute(XMLStreamWriter xMLStreamWriter, Map<String, Object> map) throws XMLStreamException;

}


class addStaticAttributes implements ISetAttributes {

	@Override
	public void addAttribute(XMLStreamWriter xMLStreamWriter, Map<String, Object> map) throws XMLStreamException {
		xMLStreamWriter.writeAttribute("TYPE", String.valueOf(map.get("TYPE")));
		xMLStreamWriter.writeAttribute("ROW", String.valueOf(map.get("ROW")));
		xMLStreamWriter.writeAttribute("COLUMN", String.valueOf(map.get("COLUMN")));

	}

}

class addPlayerAttributes implements ISetAttributes {

	@Override
	public void addAttribute(XMLStreamWriter xMLStreamWriter, Map<String, Object> map) throws XMLStreamException {
		xMLStreamWriter.writeAttribute("TYPE", String.valueOf(map.get("TYPE")));
		xMLStreamWriter.writeAttribute("ROW", String.valueOf(map.get("ROW")));
		xMLStreamWriter.writeAttribute("COLUMN", String.valueOf(map.get("COLUMN")));
		xMLStreamWriter.writeAttribute("HEALTH", String.valueOf(((Character)((Cell)map.get("MAZE")).getType()).getCharacterHealth()));
		xMLStreamWriter.writeAttribute("NAME", ((Player)((Cell)map.get("MAZE")).getType()).getPlayerName());
		xMLStreamWriter.writeAttribute("SCORE",String.valueOf(((Player)((Cell)map.get("MAZE")).getType()).getPlayerScore()));

		List<Bullet> bullets = ((Player)((Cell)map.get("MAZE")).getType()).getAllBullets();
		int iceBullets = 0;
		int fireBullets = 0;
		for (int i = 0; i < bullets.size(); i++) {
			if (bullets.get(i).getBulletType() == 0) {
				iceBullets++;
				continue;
			}
			fireBullets++;
		}
		xMLStreamWriter.writeAttribute("FireBullet", String.valueOf(fireBullets));
		xMLStreamWriter.writeAttribute("IceBullet", String.valueOf(iceBullets));

	}

}

class addMonsterAttributes implements ISetAttributes {

	@Override
	public void addAttribute(XMLStreamWriter xMLStreamWriter, Map<String, Object> map) throws XMLStreamException {
		xMLStreamWriter.writeAttribute("TYPE", String.valueOf(map.get("TYPE")));
		xMLStreamWriter.writeAttribute("ROW", String.valueOf(map.get("ROW")));
		xMLStreamWriter.writeAttribute("COLUMN", String.valueOf(map.get("COLUMN")));
		xMLStreamWriter.writeAttribute("HEALTH", String.valueOf( ((Character)((Cell)map.get("MAZE")).getType()).getCharacterHealth() ));


	}

}

class addTreeAttributes implements ISetAttributes {

	@Override
	public void addAttribute(XMLStreamWriter xMLStreamWriter, Map<String, Object> map) throws XMLStreamException {
		xMLStreamWriter.writeAttribute("TYPE", String.valueOf(map.get("TYPE")));
		xMLStreamWriter.writeAttribute("ROW", String.valueOf(map.get("ROW")));
		xMLStreamWriter.writeAttribute("COLUMN", String.valueOf(map.get("COLUMN")));
		xMLStreamWriter.writeAttribute("HEALTH", String.valueOf(((Wall)((Cell)map.get("MAZE")).getType()).getWallHealth()));

	}

}
