package drawables.dynamic_drawables.bullet.derivatives;

import drawables.DynamicDrawable;
import drawables.dynamic_drawables.bullet.Bullet;

/**
 * Created by Bassam on 12/8/2017.
 */
public class IceBullet extends Bullet {
    private static final double ICE_BULLET_DAMAGE = 50;
    private static final String ICE_BULLET_IMG = getBulletsAssetsDirectory() + "ice_bullet_right.png";

    public IceBullet() {
        super(Bullet.BULLET_TYPE_ICE);
        setImageDirectory(ICE_BULLET_IMG);
    }

    @Override
    protected void addImagesOfEachDirection() {
        addImageWithDirection(DynamicDrawable.DIRECTION_UP, getBulletsAssetsDirectory() + "ice_bullet_up.png");
        addImageWithDirection(DynamicDrawable.DIRECTION_DOWN, getBulletsAssetsDirectory() + "ice_bullet_down.png");
        addImageWithDirection(DynamicDrawable.DIRECTION_LEFT, getBulletsAssetsDirectory() + "ice_bullet_left.png");
        addImageWithDirection(DynamicDrawable.DIRECTION_RIGHT, getBulletsAssetsDirectory() + "ice_bullet_right.png");
    }

    @Override
    public double getBulletDamage() {
        return ICE_BULLET_DAMAGE;
    }
}
