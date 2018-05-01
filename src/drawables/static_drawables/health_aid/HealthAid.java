package drawables.static_drawables.health_aid;

import drawables.Drawable;

/**
 * Created by Bassam on 12/7/2017.
 */
public abstract class HealthAid extends Drawable {
    protected static final int HEALTH_AID_TYPE_SMALL = 0;

    private static final String HEALTH_AIDS_ASSETS_DIRECTORY = getAssetsMainDirectory() + "health_aids\\";

    private int healthAidType;

    public HealthAid(int healthAidType) {
        this.healthAidType = healthAidType;
    }

    public static String getHealthAidsAssetsDirectory() {
        return HEALTH_AIDS_ASSETS_DIRECTORY;
    }

    public abstract double getHealthAmount();

    public int getHealthAidType() {
        return healthAidType;
    }

}
