/**
 *
 */
package grid.Levels;

import java.awt.Point;

/**
 * @author Personal
 *
 */
public interface ILevel {
	public void setStrongBombNumber (int number);
	public int getStrongBombNumber ();

	public void setWeakBombNumber (int number);
	public int getWeakBombNumber ();

	public void setIceBulletNumber (int number) ;
	public int getIceBulletNumber ();

	public void setFireBulletNumber (int number);
	public int getFireBulletNumber ();

	public void setIceMonsterNumber (int number);
	public int getIceMonsterNumber ();

	public void setFireMonsterNumber (int number);
	public int getFireMonsterNumber ();

	public void setTreesNumber (int number);
	public int getTreesNumber ();

	public void setGiftNumber (int number);
	public int getGiftNumber ();

	public void setBronzeCoinNumber (int number);
	public int getBronzeCoinNumber ();

	public void setGoldCoinNumber (int number);
	public int getGoldCoinNumber ();

	public void setSilverCoinNumber (int number);
	public int getSilverCoinNumber ();

	public int getHarmfullGiftNnumber ();

	public void setBlockedGiftNumber (int number);
	public int getBlockedGiftNumber ();

	public void setMazeSize (Point size);
	public Point getMazeSize ();
}
