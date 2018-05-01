/**
 *
 */
package grid.Levels.builder.generate;

import grid.Levels.Level;
import grid.Levels.builder.ILevelBuilder;

/**
 * @author Personal
 *
 */
public class GenerateLevel {

	private ILevelBuilder levelBuilder;
	public GenerateLevel (ILevelBuilder levelBuilder) {
		this.levelBuilder = levelBuilder;
	}

	public void generate() {
		levelBuilder.buildBlockedGiftNumber();
		levelBuilder.buildBronzeCoinNumber();
		levelBuilder.buildFireBulletNumber();
		levelBuilder.buildFireMonsterNumber();
		levelBuilder.buildGiftNumber();
		levelBuilder.buildGoldCoinNumber();
		levelBuilder.buildIceBulletNumber();
		levelBuilder.buildIceMonsterNumber();
		levelBuilder.buildMazeSize();
		levelBuilder.buildSilverCoinNumber();
		levelBuilder.buildStrongBombNumber();
		levelBuilder.buildTreesNumber();
		levelBuilder.buildWeakBombNumber();
	}

	public Level getLevel () {
		return levelBuilder.getLevel();
	}

}
