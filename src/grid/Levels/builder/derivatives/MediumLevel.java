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
public class MediumLevel implements ILevelBuilder{

	private Level level;
	public MediumLevel () {
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
		this.level.setFireMonsterNumber(2);

	}

	@Override
	public void buildIceMonsterNumber() {
		this.level.setIceMonsterNumber(1);

	}

	@Override
	public void buildIceBulletNumber() {
		this.level.setIceBulletNumber(1);

	}

	@Override
	public void buildFireBulletNumber() {
		this.level.setFireBulletNumber(5);

	}

	@Override
	public void buildWeakBombNumber() {
		this.level.setWeakBombNumber(3);

	}

	@Override
	public void buildStrongBombNumber() {
		this.level.setStrongBombNumber(1);

	}

	@Override
	public void buildTreesNumber() {
		this.level.setTreesNumber(4);

	}

	@Override
	public void buildGiftNumber() {
		this.level.setGiftNumber(6);

	}

	@Override
	public void buildBlockedGiftNumber() {
		this.level.setBlockedGiftNumber(4);

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
