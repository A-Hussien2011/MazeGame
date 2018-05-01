package drawables.dynamic_drawables.character.player.derivatives;

import drawables.DynamicDrawable;
import drawables.dynamic_drawables.character.player.Player;

/**
 * Created by Bassam on 12/8/2017.
 */
public class Knight extends Player {

    private static final String KNIGHT_IMG = getPlayersAssetsDirectory() + "knight_down.png";
    private static final String KNIGHT_LABEL = "The Knight";
    private static Knight knight;

    public Knight() {
        super(Player.PLAYER_TYPE_KNIGHT);
        setCharacterLabel(KNIGHT_LABEL);
        setImageDirectory(KNIGHT_IMG);
    }

    public static Knight getInstance() {
        synchronized (Knight.class) {
            if (knight == null) {
                knight = new Knight();
            }
            return knight;
        }
    }

    public static String getKnightLabel() {
        return KNIGHT_LABEL;
    }

    @Override
    protected void addImagesOfEachDirection() {
        addImageWithDirection(DynamicDrawable.DIRECTION_UP, getPlayersAssetsDirectory() + "knight_up.png");
        addImageWithDirection(DynamicDrawable.DIRECTION_DOWN, getPlayersAssetsDirectory() + "knight_down.png");
        addImageWithDirection(DynamicDrawable.DIRECTION_LEFT, getPlayersAssetsDirectory() + "knight_left.png");
        addImageWithDirection(DynamicDrawable.DIRECTION_RIGHT, getPlayersAssetsDirectory() + "knight_right.png");
    }
}
