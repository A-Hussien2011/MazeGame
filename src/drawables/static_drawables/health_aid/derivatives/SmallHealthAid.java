package drawables.static_drawables.health_aid.derivatives;

import drawables.static_drawables.health_aid.HealthAid;

/**
 * Created by Bassam on 12/8/2017.
 */
public class SmallHealthAid extends HealthAid {
    private static final double SMALL_HEALTH_AID_AMOUNT = 50;
    private static final String SMALL_HEALTH_AID_IMG = getHealthAidsAssetsDirectory() + "small_health_aid.png";


    public SmallHealthAid() {
        super(HealthAid.HEALTH_AID_TYPE_SMALL);
        setImageDirectory(SMALL_HEALTH_AID_IMG);
    }

    @Override
    public double getHealthAmount() {
        return SMALL_HEALTH_AID_AMOUNT;
    }
}
