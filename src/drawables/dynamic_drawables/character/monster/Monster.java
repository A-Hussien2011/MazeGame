package drawables.dynamic_drawables.character.monster;

import drawables.dynamic_drawables.character.Character;

/**
 * Created by Bassam on 12/8/2017.
 */
public abstract class Monster extends Character {

    public static final int MONSTER_TYPE_ICE_DRAGON = 0;
    public static final int MONSTER_TYPE_FIRE_DRAGON = 1;

    private static final String MONSTERS_ASSETS_DIRECTORY = getAssetsMainDirectory() + "monsters\\";
    private int monsterType;

    public Monster(int monsterType) {
        super(Character.CHAR_TYPE_MONSTER);
        this.monsterType = monsterType;
    }

    public static String getMonstersAssetsDirectory() {
        return MONSTERS_ASSETS_DIRECTORY;
    }

    public int getMonsterType() {
        return monsterType;
    }
}
