package drawables.static_drawables.coin.derivatives;

import drawables.static_drawables.coin.Coin;

/**
 * Created by Bassam on 12/7/2017.
 */
public class SilverCoin extends Coin {
    private static final int COIN_SILVER_VALUE = 50;
    private static final String COIN_SILVER_IMG = getCoinsAssetsDirectory() + "silverCoin.png";

    public SilverCoin() {
        super(Coin.COIN_SILVER);
        setImageDirectory(COIN_SILVER_IMG);
    }

    @Override
    public int getCoinValue() {
        return COIN_SILVER_VALUE;
    }


}
