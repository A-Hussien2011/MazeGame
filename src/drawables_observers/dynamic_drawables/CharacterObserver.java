package drawables_observers.dynamic_drawables;

import drawables.dynamic_drawables.character.Character;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Bassam on 12/8/2017.
 */
public class CharacterObserver implements Observer {
    Character character;

    @Override
    public void update(Observable observable, Object arg) {
        character = (Character) observable;

        if (arg instanceof String) {

            switch ((String) arg) {
                case Character.KEY_CHARACTER_HEALTH:
                    updateCharacterHealth();
                    break;
                case Character.KEY_CHARACTER_LIFE_STATUS:
                    updateCharacterLifeStatus();
                    break;
                default:
                    break;
            }

        }
    }

    private void updateCharacterLifeStatus() {

    }

    private void updateCharacterHealth() {

    }
}
