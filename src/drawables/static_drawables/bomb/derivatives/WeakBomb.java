package drawables.static_drawables.bomb.derivatives;

import drawables.static_drawables.bomb.Bomb;

/**
 * Created by Bassam on 12/7/2017.
 */
public class WeakBomb extends Bomb {
    private static final String WEAK_BOMB_IMG = getBombsAssetsDirectory() + "weakBomb.png";
    private static final double WEAK_BOMB_HEALTH_DAMAGE_FACTOR = 0.5;

    public WeakBomb() {
        super(Bomb.BOMB_WEAK);
        setImageDirectory(WEAK_BOMB_IMG);
    }

    @Override
    public double getBombDamage(double currentPlayerHealth) {
        return currentPlayerHealth * WEAK_BOMB_HEALTH_DAMAGE_FACTOR;
    }
}
