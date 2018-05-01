package gameEngine.controller;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import drawables.Drawable;
import drawables.dynamic_drawables.character.player.Player;
import drawables.static_drawables.coin.Coin;
import drawables.static_drawables.emptyMaze.Empty;
import drawables.static_drawables.wall.Wall;
import gameEngine.userInterface.GameWindow;
import gameEngine.userInterface.StartingImagePanel;
import grid.Levels.builder.ILevelBuilder;
import grid.cellComponent.Cell;
import grid.generation.GenerateGame;

/**
 * @author a7med
 *
 */
public class Controller {
	
	public static ILevelBuilder level;
	public static Cell[][] maze;
	public static GameWindow gui;
	public static Player player;
	public static JLabel[][] guiMaze;
	public static ImageIcon wallImage = new ImageIcon( (new ImageIcon(System.getProperty("user.dir") +
			Wall.getWallsAssetsDirectory() + "stone_wall.jpg"))
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
	public static boolean gameStarted = false;
	private static boolean playerDied = false;
	public static JLabel[][] map = new JLabel[31][31];
	
	public Controller(GameWindow m, Player p){
		gui = m;
		player = p;
		player.setCenterPoint(new Point(1,1));
		guiMaze = new JLabel[31][31];
	}
	
	public ILevelBuilder getLevel() {
		return level;
	}

	public void setLevel(ILevelBuilder level) {
		this.level = level;
	}

	public Cell[][] getMaze() {
		return maze;
	}

	public void setMaze(Cell[][] maze) {
		this.maze = maze;
		maze[0][1].setValidity(false);
		maze[1][0].setValidity(false);
	}

	public GameWindow getGui() {
		return gui;
	}

	public void setGui(GameWindow gui) {
		this.gui = gui;
	}

	public void startGame(){
		gameStarted = true;
		GenerateGame g = new GenerateGame(level, player);
		g.generateMaze();
		maze = g.getMaze();
	}
	
	public static void generateInitialGUIgrid(){
		SharedIcons icons;
		//long start = System.currentTimeMillis();
		for (int i = 0; i < 31; i++) {
			for(int j = 0; j < 31; j++){
				guiMaze[i][j] = new JLabel();
				guiMaze[i][j].setBounds(i*60, j*60, 60, 60);
				String imgPath = (System.getProperty("user.dir") + ((Drawable)maze[i][j].getType()).getImageDirectory());
				
				guiMaze[i][j].setOpaque(false);
				icons = new SharedIcons(imgPath);
				if(i == 1 && j == 1){
					//System.out.println();
					ImageIconFactory.charWanted = true;
					guiMaze[i][j].setIcon(icons.getIcon());
					ImageIconFactory.charWanted = false;
				}else{
					guiMaze[i][j].setIcon(icons.getIcon());
				}
				
				
				gui.contentPane.add(guiMaze[i][j]);
				SwingUtilities.updateComponentTreeUI(gui);
			}
        }
//		guiMaze[2][5].setIcon(new ImageIcon( (new ImageIcon("F:\\CSED\\1stSem\\ProgrammingII\\MazeGameJar\\src\\assets\\players\\Characters\\Bassam\\knight_right.png"))
//				.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
//		guiMaze[4][2].setIcon(new ImageIcon( (new ImageIcon("F:\\CSED\\1stSem\\ProgrammingII\\MazeGameJar\\src\\assets\\players\\Characters\\Ahmed\\knight_left.png"))
//				.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
//		guiMaze[1][1].setIcon(new ImageIcon( (new ImageIcon("F:\\CSED\\1stSem\\ProgrammingII\\MazeGameJar\\src\\assets\\players\\Characters\\Alaa\\Princess_right.png"))
//				.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
//		guiMaze[6][6].setIcon(new ImageIcon( (new ImageIcon("F:\\CSED\\1stSem\\ProgrammingII\\MazeGameJar\\src\\assets\\players\\Characters\\Bassant\\princess_left.png"))
//				.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		SwingUtilities.updateComponentTreeUI(gui);
		//System.out.println(System.currentTimeMillis() - start);
	}
	
	public static boolean validDestination (Point destinationPoint) {
		if(destinationPoint.x >= 31 || destinationPoint.y >= 31){
			JOptionPane.showMessageDialog(gui, "You Won\n" + "Your score : " + player.getPlayerScore());
			gui.dispatchEvent(new WindowEvent(gui, WindowEvent.WINDOW_CLOSING));
		}
    	if (destinationPoint.x < 0 || destinationPoint.x > 31 || destinationPoint.y < 0 || destinationPoint.y > 31) {
    		return false;
    	}
//    	System.out.println(destinationPoint.x + " " + destinationPoint.y);
    	if (!maze[destinationPoint.x][destinationPoint.y].getValidity()) {
    		return false;
    	} 
		checkType(maze[destinationPoint.x][destinationPoint.y], destinationPoint.x, destinationPoint.y);	
    	return true;
    }
	
	private static void checkType (Cell c,int x, int y) {
		String info = c.getType().toString();
		if (info.contains("bomb") ||
			c.getType().toString().contains("monster")) {
			player.decreaseHealth(10);
			guiMaze[x][y].setIcon(null);
			maze[x][y].setType(new Empty());
			maze[x][y].setValidity(true);
			GameWindow.lblHealth.setText("Your Health : " + player.getCharacterHealth());
			if (player.decreaseHealth(10) == 0) {
				JOptionPane.showMessageDialog(gui, "You lost\n" + "Your score : " + player.getPlayerScore());
				gui.dispatchEvent(new WindowEvent(gui, WindowEvent.WINDOW_CLOSING));
				playerDied   = true;
			}
		} else if (info.contains("coin")) {
			player.addCoinScore((Coin) c.getType());
			guiMaze[x][y].setIcon(null);
			maze[x][y].setType(new Empty());
			maze[x][y].setValidity(true);
			GameWindow.lblScore.setText("Your Score : " + "Your score : " + player.getPlayerScore()/5 + player.getCharacterHealth() + player.getAllBullets().size()*10);
		}
	}

	public static Point changeCameraView(int camx, int camy, int direction){
		Point playerPosition = player.getCenterPoint();
		Point newCam = new Point(camx, camy);
		if (direction == KeyEvent.VK_KP_LEFT || direction == KeyEvent.VK_LEFT)
        {
//			newCam.x -= 60;
			if(playerPosition.x > 5 && playerPosition.x <= 26){
				newCam.x = camx - 60;
			}
        	
        }
        else if (direction == KeyEvent.VK_KP_RIGHT || direction == KeyEvent.VK_RIGHT)
        {
//        	newCam.x += 60;
        	if(playerPosition.x >= 5 && playerPosition.x <= 25){
        		newCam.x = camx + 60;
			}
        }
        else if (direction == KeyEvent.VK_KP_UP || direction == KeyEvent.VK_UP)
        {
//        	newCam.y -= 60;
        	if(playerPosition.y > 5 && playerPosition.y <= 26){
        		newCam.y = camy - 60;
        	}
        	
        }
        else if (direction == KeyEvent.VK_KP_DOWN || direction == KeyEvent.VK_DOWN)
        {
//        	newCam.y += 60;
        	if(playerPosition.y >= 5 && playerPosition.y <= 25){
        		newCam.y = camy + 60;
        	}
        }
		return newCam;
	}
	public static void generateMap(StartingImagePanel mapPanel){
		SharedIcons icons;
		//System.out.println(mapPanel.getX());
		for (int i = 0; i < 31; i++) {
			for(int j = 0; j < 31; j++){
				map[i][j] = new JLabel();
				map[i][j].setBounds(i*7, j*7, 7, 7);
				String imgPath = (System.getProperty("user.dir") + ((Drawable)maze[i][j].getType()).getImageDirectory());
			//	if(imgPath.contains("players")) System.out.println("yes");
				map[i][j].setOpaque(false);
				icons = new SharedIcons(imgPath);
				map[i][j].setIcon(icons.getIcon());
				mapPanel.add(map[i][j]);
			}
        }
	}

}
