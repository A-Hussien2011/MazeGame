package drawables.dynamic_drawables.character.monster.derivatives;

import drawables.DynamicDrawable;
import drawables.dynamic_drawables.character.monster.Monster;

/**
 * Created by Bassam on 12/8/2017.
 */
public class IceDragon extends Monster {
    private static final String ICE_DRAGON_IMG = getMonstersAssetsDirectory() + "ice_dragon_left.png";
    private static final String ICE_DRAGON_LABEL = "The Ice Dragon";
    private static final double ICE_DRAGON_HEALTH = 50;

    public IceDragon() {
        super(Monster.MONSTER_TYPE_ICE_DRAGON);
        setCharacterLabel(ICE_DRAGON_LABEL);
        setImageDirectory(ICE_DRAGON_IMG);
        setCharacterHealth(ICE_DRAGON_HEALTH);
    }

    public static String getIceDragonLabel() {
        return ICE_DRAGON_LABEL;
    }

    @Override
    protected void addImagesOfEachDirection() {
        addImageWithDirection(DynamicDrawable.DIRECTION_UP, getMonstersAssetsDirectory() + "ice_dragon_up.png");
        addImageWithDirection(DynamicDrawable.DIRECTION_DOWN, getMonstersAssetsDirectory() + "ice_dragon_down.png");
        addImageWithDirection(DynamicDrawable.DIRECTION_LEFT, getMonstersAssetsDirectory() + "ice_dragon_left.png");
        addImageWithDirection(DynamicDrawable.DIRECTION_RIGHT, getMonstersAssetsDirectory() + "ice_dragon_right.png");
    }
}
