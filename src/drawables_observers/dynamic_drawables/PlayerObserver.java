package drawables_observers.dynamic_drawables;

import drawables.dynamic_drawables.character.player.Player;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Bassam on 12/8/2017.
 */
public class PlayerObserver implements Observer {

    Player player;

    @Override
    public void update(Observable observable, Object arg) {
        player = (Player) observable;

        if (arg instanceof String) {

            switch ((String) arg) {
                case Player.KEY_PLAYER_MAXIMUM_HEALTH:
                    updatePlayerMaximumHealth();
                    break;
                case Player.KEY_PLAYER_NAME:
                    updatePlayerName();
                    break;
                case Player.KEY_PLAYER_SCORE:
                    updatePlayerScore();
                    break;
                default:
                    break;
            }
        }
    }

    private void updatePlayerMaximumHealth() {

    }

    private void updatePlayerName() {

    }

    private void updatePlayerScore() {

    }
}
