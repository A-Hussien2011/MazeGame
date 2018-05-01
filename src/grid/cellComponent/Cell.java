/**
 *
 */
package grid.cellComponent;

import drawables.Drawable;

/**
 * @author Personal
 *
 */
public class Cell<T> extends Drawable{
	private boolean valid;
	private T type;

	public Cell (T type) {
		this.type = type;
	}

	public void setValidity (boolean valid) {
		this.valid = valid;
	}

	public boolean getValidity () {
		return valid;
	}

	public void setType (T type) {
		this.type = type;
	}
	public T getType () {
		return type;
	}

	public String getClassName () {
		String[] temp = type.getClass().toString().split("\\.");
		return temp[(temp.length) - 1];
	}
}
