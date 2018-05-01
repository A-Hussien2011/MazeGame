package drawables;

import drawables_observers.ImageChangeObserver;
import drawables_observers.PositionChangeObserver;

import java.awt.*;
import java.util.Observable;

/**
 * Created by Bassam on 12/7/2017.
 */
public abstract class Drawable extends Observable {

    public static final String KEY_IMAGE_DIRECTORY = "image-directory";
    public static final String KEY_CENTER_POINT = "center-point";
    public static final String KEY_START_POINT = "start-point";
    public static final String KEY_END_POINT = "end-point";

    protected final static String ASSETS_MAIN_DIRECTORY = "\\src\\assets\\";
    private Point centerPoint;
    private Point startPoint;
    private Point endPoint;
    private String imageDirectory;


    protected Drawable() {
        addObserver(new ImageChangeObserver());
        addObserver(new PositionChangeObserver());
    }

    public static String getAssetsMainDirectory() {
        return ASSETS_MAIN_DIRECTORY;
    }

    public Point getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(Point centerPoint) {
        this.centerPoint = centerPoint;
        notifyObserversWithKey(KEY_CENTER_POINT);
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
        notifyObserversWithKey(KEY_START_POINT);
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
        notifyObserversWithKey(KEY_END_POINT);
    }

    public String getImageDirectory() {
        return imageDirectory;
    }

    public void setImageDirectory(String imageDirectory) {
        this.imageDirectory = imageDirectory;
        notifyObserversWithKey(KEY_IMAGE_DIRECTORY);
    }

    protected void notifyObserversWithKey(String key) {
        setChanged();
        notifyObservers(key);
    }

}
