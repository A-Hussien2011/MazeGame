package drawables_observers;

import drawables.DynamicDrawable;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Bassam on 12/9/2017.
 */
public class DynamicDrawableObserver implements Observer {
    DynamicDrawable dynamicDrawable;

    @Override
    public void update(Observable observable, Object arg) {
        dynamicDrawable = (DynamicDrawable) observable;

        if (arg instanceof String) {

            switch ((String) arg) {
                case DynamicDrawable.KEY_MOVING_DIRECTION:
                    updateMovingDirection();
                    break;
                case DynamicDrawable.KEY_MOVING_SPEED_FACTOR:
                    updateMovingSpeedFactor();
                    break;
                default:
                    break;
            }
        }
    }

    private void updateMovingSpeedFactor() {

    }

    private void updateMovingDirection() {

    }
}
