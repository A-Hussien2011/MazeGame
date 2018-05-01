package drawables_observers;

import drawables.Drawable;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Bassam on 12/7/2017.
 */
public class PositionChangeObserver implements Observer {
    Drawable drawable;

    @Override
    public void update(Observable observable, Object arg) {
        drawable = (Drawable) observable;
        if (arg instanceof String) {

            switch ((String) arg) {
                case Drawable.KEY_CENTER_POINT:
                    updateCenterPoint();
                    break;
                case Drawable.KEY_START_POINT:
                    updateStartPoint();
                    break;
                case Drawable.KEY_END_POINT:
                    updateEndPoint();
                    break;
                default:
                    break;
            }
        }
    }

    private void updateCenterPoint() {

    }

    private void updateEndPoint() {

    }

    private void updateStartPoint() {

    }


}
