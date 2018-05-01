package drawables_observers;

import drawables.Drawable;
import drawables.DynamicDrawable;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Bassam on 12/7/2017.
 */
public class ImageChangeObserver implements Observer {
    Drawable drawable;

    @Override
    public void update(Observable observable, Object arg) {
        drawable = (Drawable) observable;
        if (arg instanceof String) {

            switch ((String) arg) {
                case Drawable.KEY_IMAGE_DIRECTORY:
                    updateDrawableImage();
                    break;
                case DynamicDrawable.KEY_MOVING_IMAGE:
                    updateMovingImage();
                default:
                    break;
            }
        }
    }

    private void updateMovingImage() {

    }

    private void updateDrawableImage() {

    }
}
