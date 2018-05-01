package drawables.static_drawables.wall;

import drawables.Drawable;
import drawables.static_drawables.bomb.Bomb;

/**
 * Created by Bassam on 12/7/2017.
 */
public abstract class Wall extends Drawable {
    protected static final int WALL_TYPE_STONE = 0;
    protected static final int WALL_TYPE_TREE = 1;
    private static final String WALLS_ASSETS_DIRECTORY = getAssetsMainDirectory() + "walls\\";

    private int wallType;
    private boolean destroyable;
    private double wallHealth;

    public Wall(int wallType) {
        this.wallType = wallType;
    }

    public static String getWallsAssetsDirectory() {
        return WALLS_ASSETS_DIRECTORY;
    }

    public int getWallType() {
        return wallType;
    }

    public boolean isDestroyable() {
        return destroyable;
    }

    protected void setDestroyable(boolean destroyable) {
        this.destroyable = destroyable;
    }

    public double getWallHealth() {
        return wallHealth;
    }

    public void setWallHealth(double wallHealth) {
        if (wallHealth < 0) {
            wallHealth = 0;
        }
        this.wallHealth = wallHealth;
    }

    public boolean causeDamage(double damageAmount) {
        if (!isDestroyable() || damageAmount <= 0) {
            return false;
        }
        setWallHealth(getWallHealth() - damageAmount);

        return !(getWallHealth() <= 0);
    }

    public boolean causeDamageByBomb(Bomb bomb, double currentPlayerHealth) {
        return causeDamage(bomb.getBombDamage(currentPlayerHealth));
    }
}
