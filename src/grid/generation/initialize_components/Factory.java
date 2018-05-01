/**
 *
 */
package grid.generation.initialize_components;

import drawables.dynamic_drawables.character.monster.derivatives.FireDragon;
import drawables.dynamic_drawables.character.monster.derivatives.IceDragon;
import drawables.dynamic_drawables.character.player.Player;
import drawables.dynamic_drawables.character.player.derivatives.Knight;
import drawables.dynamic_drawables.character.player.derivatives.Princess;
import drawables.static_drawables.bomb.derivatives.StrongBomb;
import drawables.static_drawables.bomb.derivatives.WeakBomb;
import drawables.static_drawables.coin.derivatives.BronzeCoin;
import drawables.static_drawables.coin.derivatives.GoldCoin;
import drawables.static_drawables.coin.derivatives.SilverCoin;
import drawables.static_drawables.emptyMaze.Empty;
import drawables.static_drawables.mysterious_powerups.derivatives.NonSafePowerup;
import drawables.static_drawables.mysterious_powerups.derivatives.SafePowerup;
import drawables.static_drawables.wall.derivatives.StoneWall;
import drawables.static_drawables.wall.derivatives.TreeWall;
import grid.cellComponent.Cell;

/**
 * @author Personal
 *
 */
public class Factory implements CellFactory{


	@Override
	public Cell getCellClass(int number) {
		if (number == 0) {
			Cell<StoneWall> cellComponent = new Cell<StoneWall>(new StoneWall());
			cellComponent.setValidity(false);
			return cellComponent;
		} else if (number == 2) {
			Cell<StrongBomb> cellComponent = new Cell<StrongBomb>(new StrongBomb());
			cellComponent.setValidity(true);
			return cellComponent;
		} else if (number == 3) {
			Cell<WeakBomb> cellComponent = new Cell<WeakBomb>(new WeakBomb());
			cellComponent.setValidity(true);
			return cellComponent;

		} else if (number == 4) {
			Cell<IceDragon> cellComponent = new Cell<IceDragon>(new IceDragon());
			cellComponent.setValidity(true);
			return cellComponent;

		} else if (number == 5) {
			Cell<TreeWall> cellComponent = new Cell<TreeWall>(new TreeWall());
			cellComponent.setValidity(false);
			return cellComponent;

		} else if (number == 6) {
			Cell<SafePowerup> cellComponent = new Cell<SafePowerup>(new SafePowerup());
			cellComponent.setValidity(true);
			return cellComponent;

		} else if (number == 7) {
			Cell<BronzeCoin> cellComponent = new Cell<BronzeCoin>(new BronzeCoin());
			cellComponent.setValidity(true);
			return cellComponent;

		} else if (number == 8) {
			Cell<GoldCoin> cellComponent = new Cell<GoldCoin>(new GoldCoin());
			cellComponent.setValidity(true);
			return cellComponent;

		} else if (number == 9) {
			Cell<SilverCoin> cellComponent = new Cell<SilverCoin>(new SilverCoin());
			cellComponent.setValidity(true);
			return cellComponent;

		} else if (number == 10) {
			Cell<FireDragon> cellComponent = new Cell<FireDragon>(new FireDragon());
			cellComponent.setValidity(true);
			return cellComponent;

		} else if (number == 11) {
			Cell<NonSafePowerup> cellComponent = new Cell<NonSafePowerup>(new NonSafePowerup());
			cellComponent.setValidity(true);
			return cellComponent;

		} else if (number == 12) {
			Cell<Player> cellComponent = new Cell<Player>(Princess.getInstance());
			cellComponent.setValidity(true);
			return cellComponent;

		} else if (number == 13) {
			Cell<Player> cellComponent = new Cell<Player>(Knight.getInstance());
			cellComponent.setValidity(true);
			return cellComponent;

		} else {
			Cell<Empty> cellComponent = new Cell<Empty>(new Empty());
			cellComponent.setValidity(true);
			return cellComponent;

		}
	}

}
