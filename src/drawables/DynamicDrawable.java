package drawables;

import drawables_observers.DynamicDrawableObserver;
import grid.cellComponent.Cell;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bassam on 12/7/2017.
 */
public abstract class DynamicDrawable extends Drawable {

    public static final String KEY_MOVING_SPEED_FACTOR = "moving-speed-factor";
    public static final String KEY_MOVING_DIRECTION = "moving-direction";
    public static final String KEY_MOVING_IMAGE = "moving-image";

    public static final int DIRECTION_UP = 0;
    public static final int DIRECTION_DOWN = 1;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_LEFT = 3;

    private static final int DEFAULT_MOVING_DIRECTION = DIRECTION_RIGHT;
    private static final double DEFAULT_MOVING_SPEED_FACTOR = 1;


    private double movingSpeedFactor;
    private int movingDirection;
    private Map<Integer, String> imagesWithDirectionsMap;

    private String movingImageDirectory;

    public DynamicDrawable() {
        this.movingSpeedFactor = DEFAULT_MOVING_SPEED_FACTOR;
        this.movingDirection = DEFAULT_MOVING_DIRECTION;
        this.imagesWithDirectionsMap = new HashMap<>();
        addObserver(new DynamicDrawableObserver());
        addImagesOfEachDirection();
    }

    public static int getDefaultMovingDirection() {
        return DEFAULT_MOVING_DIRECTION;
    }

    public static double getDefaultMovingSpeedFactor() {
        return DEFAULT_MOVING_SPEED_FACTOR;
    }

    public boolean moveTo(Point destinationPoint) {

        if (!isPointHorizontal(getCenterPoint(), destinationPoint) && !isPointVertical(getCenterPoint(), destinationPoint)) {
            return false;
        }

        int movingDirection = findMovingDirection(getCenterPoint(), destinationPoint);
        setMovingDirection(movingDirection);
        setImageOfCurrentDirection(movingDirection);

        this.setCenterPoint(destinationPoint);

        return true;
    }

    public boolean moveToCell(Cell cell) {
        return moveTo(cell.getCenterPoint());
    }

    private void setImageOfCurrentDirection(int movingDirection) {
        String imageNameOfThisDirection = imagesWithDirectionsMap.get(movingDirection);
        if (imageNameOfThisDirection != null) {
            setImageDirectory("Character\\" + imageNameOfThisDirection);
        }
    }

    private int findMovingDirection(Point centerPoint, Point destinationPoint) {

        if (isPointHorizontal(centerPoint, destinationPoint)) {
            if (centerPoint.getX() - destinationPoint.getX() < 0) {
                return DIRECTION_RIGHT;
            } else if (centerPoint.getX() - destinationPoint.getX() == 0) {
                return getMovingDirection();
            }
            return DIRECTION_LEFT;
        } else {
            if (centerPoint.getY() - destinationPoint.getY() > 0) {
                return DIRECTION_UP;
            } else if (centerPoint.getY() - destinationPoint.getY() == 0) {
                return getMovingDirection();
            }
            return DIRECTION_DOWN;
        }
    }

    private boolean isPointVertical(Point centerPoint, Point destinationPoint) {
        return centerPoint.getX() == destinationPoint.getX();
    }

    private boolean isPointHorizontal(Point centerPoint, Point destinationPoint) {
        return centerPoint.getY() == destinationPoint.getY();
    }

    public double getMovingSpeedFactor() {
        return movingSpeedFactor;
    }

    public void setMovingSpeedFactor(double movingSpeedFactor) {
        this.movingSpeedFactor = movingSpeedFactor;
        notifyObserversWithKey(KEY_MOVING_SPEED_FACTOR);
    }

    public int getMovingDirection() {
        return movingDirection;
    }

    public void setMovingDirection(int movingDirection) {
        this.movingDirection = movingDirection;
        setImageOfCurrentDirection(movingDirection);
        notifyObserversWithKey(KEY_MOVING_DIRECTION);
    }

    public void addImageWithDirection(int direction, String imageName) {
        imagesWithDirectionsMap.put(direction, imageName);
    }

    public String getImageOfDirection(int direction) {
        return imagesWithDirectionsMap.get(direction);
    }

    public String getMovingImageDirectory() {
        return movingImageDirectory;
    }

    public void setMovingImageDirectory(String movingImageDirectory) {
        this.movingImageDirectory = movingImageDirectory;
        notifyObserversWithKey(KEY_MOVING_IMAGE);
    }

    protected abstract void addImagesOfEachDirection();
}

