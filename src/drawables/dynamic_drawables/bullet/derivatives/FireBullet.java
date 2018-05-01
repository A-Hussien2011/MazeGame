package drawables.dynamic_drawables.bullet.derivatives;

import drawables.DynamicDrawable;
import drawables.dynamic_drawables.bullet.Bullet;

/**
 * Created by Bassam on 12/8/2017.
 */
public class FireBullet extends Bullet {

    private static final double FIRE_BULLET_DAMAGE = 50;
    private static final String FIRE_BULLET_IMG = getBulletsAssetsDirectory() + "fire_bullet_right.png";

    public FireBullet() {
        super(Bullet.BULLET_TYPE_FIRE);
        setImageDirectory(FIRE_BULLET_IMG);
    }

    @Override
    protected void addImagesOfEachDirection() {
        addImageWithDirection(DynamicDrawable.DIRECTION_UP, getBulletsAssetsDirectory() + "fire_bullet_up.png");
        addImageWithDirection(DynamicDrawable.DIRECTION_DOWN, getBulletsAssetsDirectory() + "fire_bullet_down.png");
        addImageWithDirection(DynamicDrawable.DIRECTION_LEFT, getBulletsAssetsDirectory() + "fire_bullet_left.png");
        addImageWithDirection(DynamicDrawable.DIRECTION_RIGHT, getBulletsAssetsDirectory() + "fire_bullet_right.png");
    }

    @Override
    public double getBulletDamage() {
        return FIRE_BULLET_DAMAGE;
    }
}
