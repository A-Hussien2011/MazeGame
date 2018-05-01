/**
 *
 */
package drawables.static_drawables.emptyMaze;

import drawables.Drawable;

/**
 * @author Personal
 *
 */
public class Empty extends Drawable{
    private static final String Empty_Cell_IMG = getAssetsMainDirectory() + "empty_cell.jpg";

    public Empty () {
    	setImageDirectory(Empty_Cell_IMG);
    }
    
    public static String getEmptyAssetsDirectory() {
		return Empty_Cell_IMG;
	}
}
