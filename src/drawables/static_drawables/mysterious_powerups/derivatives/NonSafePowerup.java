package drawables.static_drawables.mysterious_powerups.derivatives;

import drawables.static_drawables.mysterious_powerups.MysteriousPowerup;

/**
 * Created by Bassam on 12/15/2017.
 */
public class NonSafePowerup extends MysteriousPowerup {

    private static final String POWERUP_NON_SAFE_IMG = getPowerupsAssetsDirectory() + "mysterious_box.png";

    public NonSafePowerup() {
        super(MysteriousPowerup.POWERUP_NON_SAFE);
        setImageDirectory(POWERUP_NON_SAFE_IMG);
    }


}
