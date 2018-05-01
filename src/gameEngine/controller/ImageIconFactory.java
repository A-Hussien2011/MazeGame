package gameEngine.controller;

import drawables.dynamic_drawables.bullet.Bullet;
import drawables.dynamic_drawables.character.monster.Monster;
import drawables.dynamic_drawables.character.player.Player;
import drawables.static_drawables.bomb.Bomb;
import drawables.static_drawables.coin.Coin;
import drawables.static_drawables.wall.Wall;

import javax.swing.*;
import java.awt.*;

public class ImageIconFactory {
	
	public static String yourchar = "\\Ahmed\\";
	public static boolean charWanted = false;
	
	public static ImageIcon stoneWall = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Wall.getWallsAssetsDirectory() + "stoneWall.jpg"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	public static ImageIcon tree = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Wall.getWallsAssetsDirectory() + "tree.png"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	public static ImageIcon strongBomb = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Bomb.getBombsAssetsDirectory() + "strongBomb.png"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	public static ImageIcon weakBomb = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Bomb.getBombsAssetsDirectory() + "weakBomb.jpg"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	public static ImageIcon iceBullet = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Bullet.getBulletsAssetsDirectory() + "iceBullet.png"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	public static ImageIcon fireBullet = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Bullet.getBulletsAssetsDirectory() + "fireBullet.png"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	
	
	public static ImageIcon bronzeCoin = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Coin.getCoinsAssetsDirectory() + "bronzeCoin.png"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	public static ImageIcon silverCoin = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Coin.getCoinsAssetsDirectory() + "silverCoin.png"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	public static ImageIcon goldCoin = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Coin.getCoinsAssetsDirectory() + "goldCoin.png"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	
	//knight direction
	public static ImageIcon knight_left = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Player.getPlayersAssetsDirectory() + yourchar + "knight_left.png"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	public static ImageIcon knight_right = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Player.getPlayersAssetsDirectory() + yourchar + "knight_right.png"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	public static ImageIcon knight_down = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Player.getPlayersAssetsDirectory() + yourchar + "knight_down.png"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	public static ImageIcon knight_up = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Player.getPlayersAssetsDirectory() + yourchar + "knight_up.png"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	
	//princess direction
	public static ImageIcon princess_left = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Player.getPlayersAssetsDirectory() + yourchar + "princess_left.png"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	public static ImageIcon princess_right = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Player.getPlayersAssetsDirectory() + yourchar + "princess_right.png"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	public static ImageIcon princess_up = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Player.getPlayersAssetsDirectory() + yourchar + "princess_up.png"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	public static ImageIcon princess_down = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Player.getPlayersAssetsDirectory() + yourchar + "princess_down.png"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	
	//fire dragon direction
	public static ImageIcon fire_dragon_right = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Monster.getMonstersAssetsDirectory() + "fire_dragon_right.png"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	public static ImageIcon fire_dragon_left = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Monster.getMonstersAssetsDirectory() + "fire_dragon_left.png"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	public static ImageIcon fire_dragon_up = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Monster.getMonstersAssetsDirectory() + "fire_dragon_up.png"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	public static ImageIcon fire_dragon_down = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Monster.getMonstersAssetsDirectory() + "fire_dragon_down.png"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	
	//ice dragon direction
	public static ImageIcon ice_dragon_down = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Monster.getMonstersAssetsDirectory() + "ice_dragon_down.png"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	public static ImageIcon ice_dragon_up = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Monster.getMonstersAssetsDirectory() + "ice_dragon_up.png"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	public static ImageIcon ice_dragon_left = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Monster.getMonstersAssetsDirectory() + "ice_dragon_left.png"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	public static ImageIcon ice_dragon_right = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Monster.getMonstersAssetsDirectory() + "ice_dragon_right.png"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	
//fire_bullet direction
	public static ImageIcon fire_bullet_down = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Bullet.getBulletsAssetsDirectory() + "fire_bullet_down.png"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	public static ImageIcon fire_bullet_up = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Bullet.getBulletsAssetsDirectory() + "fire_bullet_up.png"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	public static ImageIcon fire_bullet_left = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Bullet.getBulletsAssetsDirectory() + "fire_bullet_left.png"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	public static ImageIcon fire_bullet_right = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Bullet.getBulletsAssetsDirectory() + "fire_bullet_right.png"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	
	//ice_bullet direction
	public static ImageIcon ice_bullet_down = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Bullet.getBulletsAssetsDirectory() + "ice_bullet_down.png"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	public static ImageIcon ice_bullet_up = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Bullet.getBulletsAssetsDirectory() + "ice_bullet_up.png"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	public static ImageIcon ice_bullet_left = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Bullet.getBulletsAssetsDirectory() + "ice_bullet_left.png"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	public static ImageIcon ice_bullet_right = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Bullet.getBulletsAssetsDirectory() + "ice_bullet_right.png"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	
	public static ImageIcon getImageIcon(String imgPath){
		//System.out.println(imgPath);
		if(charWanted){
			knight_left = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
					Player.getPlayersAssetsDirectory() + yourchar + "knight_left.png"))
					.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
			knight_right = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
					Player.getPlayersAssetsDirectory() + yourchar + "knight_right.png"))
					.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
			knight_down = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
					Player.getPlayersAssetsDirectory() + yourchar + "knight_down.png"))
					.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
			knight_up = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
					Player.getPlayersAssetsDirectory() + yourchar + "knight_up.png"))
					.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
			
			//princess direction
			princess_left = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
					Player.getPlayersAssetsDirectory() + yourchar + "princess_left.png"))
					.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
			princess_right = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
					Player.getPlayersAssetsDirectory() + yourchar + "princess_right.png"))
					.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
			princess_up = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
					Player.getPlayersAssetsDirectory() + yourchar + "princess_up.png"))
					.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
			princess_down = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
					Player.getPlayersAssetsDirectory() + yourchar + "princess_down.png"))
					.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
		}
		
		if(imgPath.contains("fireBullet")){
			return fireBullet;
		}else if(imgPath.contains("iceBullet")){
			return iceBullet;
		}else if(imgPath.contains("strongBomb")){
			return strongBomb;
		}else if(imgPath.contains("weakBomb")){
			return weakBomb;
		}else if(imgPath.contains("bronzeCoin")){
			return bronzeCoin;
		}else if(imgPath.contains("silverCoin")){
			return silverCoin;
		}else if(imgPath.contains("goldCoin")){
			return goldCoin;
		}else if(imgPath.contains("fire_dragon_left")){
			return fire_dragon_left;
		}else if(imgPath.contains("fire_dragon_right")){
			return fire_dragon_right;
		}else if(imgPath.contains("fire_dragon_up")){
			return fire_dragon_up;
		}else if(imgPath.contains("fire_dragon_down")){
			return fire_dragon_down;
		}else if(imgPath.contains("stoneWall")){
			System.out.println("stone");
			return stoneWall;
		}else if(imgPath.contains("tree")){
			return tree;
		}
		else if(imgPath.contains("ice_dragon_left")){
			return ice_dragon_left;
		}else if(imgPath.contains("ice_dragon_right")){
			return ice_dragon_right;
		}else if(imgPath.contains("ice_dragon_up")){
			return ice_dragon_up;
		}else if(imgPath.contains("ice_dragon_down")){
			return ice_dragon_down;
		}
		else if(imgPath.contains("knight_left")){
			return knight_left;
		}else if(imgPath.contains("knight_right")){
			return knight_right;
		}else if(imgPath.contains("knight_up")){
			return knight_up;
		}else if(imgPath.contains("knight_down")){
			System.out.println(System.getProperty("user.dir") +
					Player.getPlayersAssetsDirectory() + yourchar + "knight_left.png");
			System.out.println(yourchar);
			return knight_down;
		}
		else if(imgPath.contains("princess_left")){
			
			return princess_left;
		}else if(imgPath.contains("princess_right")){
			return princess_right;
		}else if(imgPath.contains("princess_up")){
			return princess_up;
		}else if(imgPath.contains("princess_down")){
			System.out.println(System.getProperty("user.dir") + Player.getPlayersAssetsDirectory()  );
			System.out.println(yourchar);
			return princess_down;
		}
		else if(imgPath.contains("fire_bullet_left")){
			System.out.println(imgPath);
			return fire_bullet_left;
		}else if(imgPath.contains("fire_bullet_right")){
			System.out.println(imgPath);
			return fire_bullet_right;
		}else if(imgPath.contains("fire_bullet_up")){
			System.out.println(imgPath);
			return fire_bullet_up;
		}else if(imgPath.contains("fire_bullet_down")){
			System.out.println(imgPath);
			return fire_bullet_down;
		}
		else if(imgPath.contains("ice_bullet_left")){
			
			return ice_bullet_left;
		}else if(imgPath.contains("ice_bullet_right")){
			System.out.println(imgPath);
			return ice_bullet_right;
		}else if(imgPath.contains("ice_bullet_up")){
			System.out.println(imgPath);
			return ice_bullet_up;
		}else if(imgPath.contains("ice_bullet_down")){
			return ice_bullet_down;
		}
		
		return null;
	}
	
}
