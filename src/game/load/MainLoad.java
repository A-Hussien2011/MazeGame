/**
 *
 */
package game.load;

import java.io.FileNotFoundException;

import javax.xml.stream.XMLStreamException;

import grid.cellComponent.Cell;

/**
 * @author Personal
 *
 */
public class MainLoad {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Load l = new Load();
		Cell[][] m;
		try {
			m = l.load("newTrial.xml");
		} catch (FileNotFoundException | XMLStreamException e) {
			e.printStackTrace();
		}

	}
}
