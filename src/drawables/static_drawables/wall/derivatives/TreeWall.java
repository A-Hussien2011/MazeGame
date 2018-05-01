package drawables.static_drawables.wall.derivatives;

import drawables.static_drawables.wall.Wall;

/**
 * Created by Bassam on 12/7/2017.
 */
public class TreeWall extends Wall {
    private static final boolean DESTROYABLE = true;
    private static final double TREE_WALL_HEALTH = 0;
    private static final String TREE_WALL_IMG = getWallsAssetsDirectory() + "tree.png";

    public TreeWall() {
        super(Wall.WALL_TYPE_TREE);
        setImageDirectory(TREE_WALL_IMG);
        setDestroyable(DESTROYABLE);
        setWallHealth(TREE_WALL_HEALTH);
    }
}
