/**
 *
 */
package grid.Levels.builder.derivatives;

import java.awt.Point;

import grid.Levels.Level;
import grid.Levels.builder.ILevelBuilder;

/**
 * @author Personal
 *
 */
public class HardLevel implements ILevelBuilder{

	private Level level;
	public HardLevel () {
		this.level = new Level();
	}

	@Override
	public void buildBronzeCoinNumber() {
		this.level.setBronzeCoinNumber(5);

	}

	@Override
	public void buildGoldCoinNumber() {
		this.level.setGoldCoinNumber(5);

	}

	@Override
	public void buildSilverCoinNumber() {
		this.level.setSilverCoinNumber(5);

	}

	@Override
	public void buildFireMonsterNumber() {
		this.level.setFireMonsterNumber(1);

	}

	@Override
	public void buildIceMonsterNumber() {
		this.level.setIceMonsterNumber(1);

	}

	@Override
	public void buildIceBulletNumber() {
		this.level.setIceBulletNumber(2);

	}

	@Override
	public void buildFireBulletNumber() {
		this.level.setFireBulletNumber(4);

	}

	@Override
	public void buildWeakBombNumber() {
		this.level.setWeakBombNumber(1);

	}

	@Override
	public void buildStrongBombNumber() {
		this.level.setStrongBombNumber(2);

	}

	@Override
	public void buildTreesNumber() {
		this.level.setTreesNumber(6);

	}

	@Override
	public void buildGiftNumber() {
		this.level.setGiftNumber(6);

	}

	@Override
	public void buildBlockedGiftNumber() {
		this.level.setBlockedGiftNumber(6);

	}

	@Override
	public void buildMazeSize() {
		this.level.setMazeSize(new Point(31, 31));

	}

	@Override
	public Level getLevel() {
		return this.level;
	}

}
