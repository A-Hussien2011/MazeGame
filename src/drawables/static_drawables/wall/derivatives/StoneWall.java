package drawables.static_drawables.wall.derivatives;

import drawables.static_drawables.wall.Wall;

/**
 * Created by Bassam on 12/7/2017.
 */
public class StoneWall extends Wall {
    private static final boolean DESTROYABLE = false;
    private static final double STONE_WALL_HEALTH = 10000;
    private static final String STONE_WALL_IMG = getWallsAssetsDirectory() + "stoneWall.jpg";

    public StoneWall() {
        super(Wall.WALL_TYPE_STONE);
        setWallHealth(STONE_WALL_HEALTH);
        setDestroyable(DESTROYABLE);
        setImageDirectory(STONE_WALL_IMG);
    }
}
