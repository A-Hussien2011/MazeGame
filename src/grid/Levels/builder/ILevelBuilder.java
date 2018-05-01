/**
 *
 */
package grid.Levels.builder;

import grid.Levels.Level;

/**
 * @author Personal
 *
 */
public interface ILevelBuilder {

	void buildBronzeCoinNumber();
	void buildGoldCoinNumber();
	void buildSilverCoinNumber();
	void buildFireMonsterNumber();
	void buildIceMonsterNumber();
	void buildIceBulletNumber();
	void buildFireBulletNumber();
	void buildWeakBombNumber();
	void buildStrongBombNumber();
	void buildTreesNumber();
	void buildGiftNumber();
	void buildBlockedGiftNumber();
	void buildMazeSize();
	Level getLevel();
}
