/**
 *
 */
package grid.Levels;

import java.awt.Point;

/**
 * @author Personal
 *
 */
public class Level implements ILevel {

	private int strongBombNumber;
	private int weakBombNumber;
	private int iceBulletNumber;
	private int fireBulletNumber;
	private int iceMmonsterNumber;
	private int fireMonsterNumber;
	private int treeNumber;
	private int bronzeCoinNumber;
	private int silverCoinNumber;
	private int goldCoinNumber ;
	private int giftNumber;
	private int blockedGiftNumber;
	private static final int harmfullGiftNnumber = 0;
	private Point mazeSize;

	@Override
	public void setStrongBombNumber (int number) {
		strongBombNumber = number;
	}
	@Override
	public int getStrongBombNumber () {
		return strongBombNumber;

	}

	@Override
	public void setWeakBombNumber (int number) {
		weakBombNumber = number;
	}
	@Override
	public int getWeakBombNumber () {
		return weakBombNumber;

	}

	@Override
	public void setIceBulletNumber (int number) {
		iceBulletNumber = number;
	}
	@Override
	public int getIceBulletNumber () {
		return iceBulletNumber;

	}

	@Override
	public void setFireBulletNumber (int number) {
		fireBulletNumber = number;
	}
	@Override
	public int getFireBulletNumber () {
		return fireBulletNumber;

	}

	@Override
	public void setIceMonsterNumber (int number) {
		iceMmonsterNumber = number;
	}
	@Override
	public int getIceMonsterNumber () {
		return iceMmonsterNumber;

	}

	@Override
	public void setFireMonsterNumber (int number) {
		fireMonsterNumber = number;
	}
	@Override
	public int getFireMonsterNumber () {
		return fireMonsterNumber;

	}

	@Override
	public void setTreesNumber (int number) {
		treeNumber = number;
	}
	@Override
	public int getTreesNumber () {
		return treeNumber;

	}

	@Override
	public void setGiftNumber (int number) {
		giftNumber = number;
	}
	@Override
	public int getGiftNumber () {
		return giftNumber;

	}

	@Override
	public void setBronzeCoinNumber (int number) {
		bronzeCoinNumber = number;
	}
	@Override
	public int getBronzeCoinNumber () {
		return bronzeCoinNumber;

	}

	@Override
	public void setGoldCoinNumber (int number) {
		goldCoinNumber = number;
	}
	@Override
	public int getGoldCoinNumber () {
		return goldCoinNumber;

	}

	@Override
	public void setSilverCoinNumber (int number) {
		silverCoinNumber = number;
	}
	@Override
	public int getSilverCoinNumber () {
		return silverCoinNumber;

	}

	@Override
	public int getHarmfullGiftNnumber () {
		return harmfullGiftNnumber;

	}

	@Override
	public void setBlockedGiftNumber (int number) {
		blockedGiftNumber = number;
	}
	@Override
	public int getBlockedGiftNumber () {
		return blockedGiftNumber;

	}

	@Override
	public void setMazeSize (Point size) {
		mazeSize = size;
	}
	@Override
	public Point getMazeSize () {
		return mazeSize;
	}
}
