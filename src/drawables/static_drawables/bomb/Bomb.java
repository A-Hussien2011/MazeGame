package drawables.static_drawables.bomb;

import drawables.Drawable;

/**
 * Created by Bassam on 12/7/2017.
 */
public abstract class Bomb extends Drawable {

    protected static final int BOMB_STRONG = 0;
    protected static final int BOMB_WEAK = 1;
    private static final String BOMBS_ASSETS_DIRECTORY = getAssetsMainDirectory() + "bombs\\";

    private int bombType;

    public Bomb(int bombType) {
        this.bombType = bombType;
    }

    public static String getBombsAssetsDirectory() {
        return BOMBS_ASSETS_DIRECTORY;
    }

    public int getBombType() {
        return bombType;
    }

    public abstract double getBombDamage(double currentPlayerHealth);

}
