package drawables.static_drawables.bomb.derivatives;

import drawables.static_drawables.bomb.Bomb;

/**
 * Created by Bassam on 12/7/2017.
 */
public class StrongBomb extends Bomb {
    private static final String STRONG_BOMB_IMG = getBombsAssetsDirectory() + "strongBomb.png";
    private static final double STRONG_BOMB_HEALTH_DAMAGE_FACTOR = 1;

    public StrongBomb() {
        super(Bomb.BOMB_STRONG);
        setImageDirectory(STRONG_BOMB_IMG);
    }

    @Override
    public double getBombDamage(double currentPlayerHealth) {
        return currentPlayerHealth * STRONG_BOMB_HEALTH_DAMAGE_FACTOR;
    }
}
