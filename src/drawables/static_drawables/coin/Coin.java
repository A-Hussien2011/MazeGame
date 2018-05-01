package drawables.static_drawables.coin;

import drawables.Drawable;

/**
 * Created by Bassam on 12/7/2017.
 */
public abstract class Coin extends Drawable {

    protected static final int COIN_GOLD = 2;
    protected static final int COIN_SILVER = 1;
    protected static final int COIN_BRONZE = 0;
    protected static final String COINS_ASSETS_DIRECTORY = getAssetsMainDirectory() + "coins\\";

    private int coinType;

    public Coin(int coinType) {
        this.coinType = coinType;
    }

    public static String getCoinsAssetsDirectory() {
        return COINS_ASSETS_DIRECTORY;
    }

    public int getCoinType() {
        return coinType;
    }

    abstract public int getCoinValue();
}
