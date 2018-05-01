/**
 *
 */
package game.save;

/**
 * @author Personal
 *
 */
class StrategyFactory implements IStrategyFactory {


	@Override
	public ISetAttributes getStrategy(String className) {
		if (className.equalsIgnoreCase("IceDragon")
				|| className.equalsIgnoreCase("FireDragon")) {
			return new addMonsterAttributes();
		} else if (className.equalsIgnoreCase("Princess")
				|| className.equalsIgnoreCase("Knight")) {
			return new addPlayerAttributes();
		} else if (className.equalsIgnoreCase("TreeWall")) {
			return new addTreeAttributes();
		} else {
			return new addStaticAttributes();
		}
	}

}