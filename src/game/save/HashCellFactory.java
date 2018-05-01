/**
 *
 */
package game.save;

/**
 * @author Personal
 *
 */
class HashCellFactory implements IHashCellFactory {

	@Override
	public int getClassHashCode(String className) {
		if (className.equalsIgnoreCase("StoneWall")) {
			return 0;
		} else if (className.equalsIgnoreCase("StrongBomb")) {
			return 2;
		} else if (className.equalsIgnoreCase("WeakBomb")) {
			return 3;
		} else if (className.equalsIgnoreCase("IceDragon")) {
			return 4;
		} else if (className.equalsIgnoreCase("TreeWall")) {
			return 5;
		} else if (className.equalsIgnoreCase("SafePowerup")) {
			return 6;
		} else if (className.equalsIgnoreCase("BronzeCoin")) {
			return 7;
		} else if (className.equalsIgnoreCase("GoldCoin")) {
			return 8;
		} else if (className.equalsIgnoreCase("SilverCoin")) {
			return 9;
		} else if (className.equalsIgnoreCase("FireDragon")) {
			return 10;
		} else if (className.equalsIgnoreCase("NonSafePowerup")) {
			return 11;
		} else if (className.equalsIgnoreCase("Princess")) {
			return 12;
		} else if (className.equalsIgnoreCase("Knight")) {
			return 13;
		} else {
			return 1;
		}

	}
}
