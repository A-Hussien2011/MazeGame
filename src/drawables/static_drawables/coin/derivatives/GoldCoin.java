package drawables.static_drawables.coin.derivatives;

import drawables.static_drawables.coin.Coin;

/**
 * Created by Bassam on 12/7/2017.
 */
public class GoldCoin extends Coin {
    private static final int COIN_GOLD_VALUE = 100;
    private static final String COIN_GOLD_IMG = getCoinsAssetsDirectory() + "goldCoin.png";


    public GoldCoin() {
        super(Coin.COIN_GOLD);
        setImageDirectory(COIN_GOLD_IMG);
    }

    @Override
    public int getCoinValue() {
        return COIN_GOLD_VALUE;
    }
}
