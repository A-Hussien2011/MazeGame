package drawables.dynamic_drawables.character;

import drawables.DynamicDrawable;
import drawables.dynamic_drawables.bullet.Bullet;
import drawables.static_drawables.bomb.Bomb;
import drawables_observers.dynamic_drawables.CharacterObserver;

/**
 * Created by Bassam on 12/8/2017.
 */
public abstract class Character extends DynamicDrawable {

    public static final String KEY_CHARACTER_HEALTH = "character-health";
    public static final String KEY_CHARACTER_LIFE_STATUS = "character-life-status";


    public static final int CHAR_TYPE_PLAYER = 0;
    public static final int CHAR_TYPE_MONSTER = 1;

    private double characterHealth;
    private String characterLabel;
    private int characterType;


    private boolean characterAlive;

    public Character(int characterType) {
        this.characterType = characterType;
        this.characterAlive = true;
        addObserver(new CharacterObserver());

    }

    public double getCharacterHealth() {
        return characterHealth;
    }

    public void setCharacterHealth(double characterHealth) {
        this.characterHealth = characterHealth;
        notifyObserversWithKey(KEY_CHARACTER_HEALTH);
    }

    public int getCharacterType() {
        return characterType;
    }

    public String getCharacterLabel() {
        return characterLabel;
    }

    protected void setCharacterLabel(String characterLabel) {
        this.characterLabel = characterLabel;
    }

    public double causeDamage(double damageAmount) {

        if (damageAmount >= 0) {
            setCharacterHealth(characterHealth - damageAmount);
        }

        if (characterHealth < 0) {
            characterHealth = 0;
            setCharacterAlive(false);
        }

        return getCharacterHealth();
    }

    public double causeDamageByBomb(Bomb bomb) {
        return causeDamage(bomb.getBombDamage(getCharacterHealth()));
    }

    public double causeDamageByBullet(Bullet bullet) {
        return causeDamage(bullet.getBulletDamage());
    }

    public boolean isCharacterAlive() {
        return characterAlive;
    }

    private void setCharacterAlive(boolean characterAlive) {
        this.characterAlive = characterAlive;
        notifyObserversWithKey(KEY_CHARACTER_LIFE_STATUS);
    }


}
