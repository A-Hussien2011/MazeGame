package drawables.static_drawables.mysterious_powerups.derivatives;

import drawables.static_drawables.mysterious_powerups.MysteriousPowerup;

/**
 * Created by Bassam on 12/15/2017.
 */
public class SafePowerup extends MysteriousPowerup {

    private static final String POWERUP_SAFE_IMG = getPowerupsAssetsDirectory() + "mysterious_box.png";

    public SafePowerup() {
        super(MysteriousPowerup.POWERUP_SAFE);
        setImageDirectory(POWERUP_SAFE_IMG);
    }

}
