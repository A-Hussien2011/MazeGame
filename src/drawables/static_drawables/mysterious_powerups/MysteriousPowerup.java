package drawables.static_drawables.mysterious_powerups;

import drawables.Drawable;

/**
 * Created by Bassam on 12/15/2017.
 */
public abstract class MysteriousPowerup extends Drawable {

    protected static final int POWERUP_SAFE = 0;
    protected static final int POWERUP_NON_SAFE = 1;
    private static final String POWERUPS_ASSETS_DIRECTORY = getAssetsMainDirectory() + "powerups\\";

    private int powerupType;

    public MysteriousPowerup(int powerupType) {
        this.powerupType = powerupType;
    }

    public static String getPowerupsAssetsDirectory() {
        return POWERUPS_ASSETS_DIRECTORY;
    }

    private int getPowerupType() {
        return powerupType;
    }


}
