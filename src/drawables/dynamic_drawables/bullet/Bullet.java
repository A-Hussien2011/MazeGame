package drawables.dynamic_drawables.bullet;

import drawables.DynamicDrawable;

/**
 * Created by Bassam on 12/8/2017.
 */
public abstract class Bullet extends DynamicDrawable {
    public static final int BULLET_TYPE_ICE = 0;
    public static final int BULLET_TYPE_FIRE = 1;
    private static final String BULLETS_ASSETS_DIRECTORY = getAssetsMainDirectory() + "bullets\\";

    private int bulletType;
    private int bulletNumbers;

    public Bullet(int bulletType) {
        this.bulletType = bulletType;
    }

    public static String getBulletsAssetsDirectory() {
        return BULLETS_ASSETS_DIRECTORY;
    }

    public int getBulletType() {
        return bulletType;
    }

    public abstract double getBulletDamage();
}
