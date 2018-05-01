/**
 *
 */
package game.save;

/**
 * @author Personal
 *
 */
interface IStrategyFactory {
	public ISetAttributes getStrategy(String className);
}
