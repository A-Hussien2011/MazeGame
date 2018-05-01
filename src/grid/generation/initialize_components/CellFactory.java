/**
 *
 */
package grid.generation.initialize_components;

import grid.cellComponent.Cell;

/**
 * @author Personal
 *
 */
public interface CellFactory {

	public Cell getCellClass(int number);
}
