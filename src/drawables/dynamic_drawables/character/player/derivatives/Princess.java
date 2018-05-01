package drawables.dynamic_drawables.character.player.derivatives;

import drawables.DynamicDrawable;
import drawables.dynamic_drawables.character.player.Player;

/**
 * Created by Bassam on 12/8/2017.
 */
public class Princess extends Player {
    private static final String PRINCESS_IMG = getPlayersAssetsDirectory() + "princess_down.png";
    private static final String PRINCESS_LABEL = "The Princess";
    private static Princess princess;

    private Princess() {
        super(Player.PLAYER_TYPE_PRINCESS);
        setImageDirectory(PRINCESS_IMG);
        setCharacterLabel(PRINCESS_LABEL);
    }

    public static Princess getInstance() {
        synchronized (Princess.class) {
            if (princess == null) {
                princess = new Princess();
            }
            return princess;
        }
    }

    public static String getPrincessLabel() {
        return PRINCESS_LABEL;
    }

    @Override
    protected void addImagesOfEachDirection() {
        addImageWithDirection(DynamicDrawable.DIRECTION_UP, getPlayersAssetsDirectory() + "princess_up.png");
        addImageWithDirection(DynamicDrawable.DIRECTION_DOWN, getPlayersAssetsDirectory() + "princess_down.png");
        addImageWithDirection(DynamicDrawable.DIRECTION_LEFT, getPlayersAssetsDirectory() + "princess_left.png");
        addImageWithDirection(DynamicDrawable.DIRECTION_RIGHT, getPlayersAssetsDirectory() + "princess_right.png");
    }
}
