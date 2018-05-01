package drawables.static_drawables.coin.derivatives;

import drawables.static_drawables.coin.Coin;

/**
 * Created by Bassam on 12/7/2017.
 */
public class BronzeCoin extends Coin {
    private static final int COIN_BRONZE_VALUE = 10;
    private static final String COIN_BRONZE_IMG = getCoinsAssetsDirectory() + "bronzeCoin.png";


    public BronzeCoin() {
        super(Coin.COIN_BRONZE);
        setImageDirectory(COIN_BRONZE_IMG);
    }

    @Override
    public int getCoinValue() {
        return COIN_BRONZE_VALUE;
    }
}
