package drawables.dynamic_drawables.character.monster.derivatives;

import drawables.DynamicDrawable;
import drawables.dynamic_drawables.character.monster.Monster;

/**
 * Created by Bassam on 12/8/2017.
 */
public class FireDragon extends Monster {
    private static final String FIRE_DRAGON_IMG = getMonstersAssetsDirectory() + "fire_dragon_left.png";
    private static final String FIRE_DRAGON_LABEL = "The Fire Dragon";
    private static final double FIRE_DRAGON_HEALTH = 100;

    public FireDragon() {
        super(Monster.MONSTER_TYPE_FIRE_DRAGON);
        setCharacterLabel(FIRE_DRAGON_LABEL);
        setImageDirectory(FIRE_DRAGON_IMG);
        setCharacterHealth(FIRE_DRAGON_HEALTH);
    }

    public static String getFireDragonLabel() {
        return FIRE_DRAGON_LABEL;
    }

    @Override
    protected void addImagesOfEachDirection() {
        addImageWithDirection(DynamicDrawable.DIRECTION_UP, getMonstersAssetsDirectory() + "fire_dragon_up.png");
        addImageWithDirection(DynamicDrawable.DIRECTION_DOWN, getMonstersAssetsDirectory() + "fire_dragon_down.png");
        addImageWithDirection(DynamicDrawable.DIRECTION_LEFT, getMonstersAssetsDirectory() + "fire_dragon_left.png");
        addImageWithDirection(DynamicDrawable.DIRECTION_RIGHT, getMonstersAssetsDirectory() + "fire_dragon_right.png");
    }
}
