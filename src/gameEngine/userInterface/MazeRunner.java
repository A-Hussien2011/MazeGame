package gameEngine.userInterface;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import drawables.dynamic_drawables.character.player.Player;
import drawables.dynamic_drawables.character.player.derivatives.Knight;
import gameEngine.controller.Controller;
import grid.Levels.builder.ILevelBuilder;
import grid.Levels.builder.derivatives.EasyLevel;

public class MazeRunner extends JFrame {

	private JPanel contentPane;
	private Image img;
	public static ILevelBuilder level = new EasyLevel();
	public static Player player = Knight.getInstance();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MazeRunner frame = new MazeRunner();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MazeRunner() {
		setResizable(false);
		img = new ImageIcon( System.getProperty("user.dir") 
				+ "/src/assets/start/start.jpg").getImage();
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 367);
		contentPane = new StartingImagePanel(img);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSettings = new JButton("");
		btnSettings.setIcon(new ImageIcon(((new ImageIcon(
	            "src/assets/start/settings.png").getImage()
	            .getScaledInstance(89, 45,
	                    java.awt.Image.SCALE_SMOOTH)))));
		btnSettings.setFocusable(false);
		btnSettings.setContentAreaFilled(false);
		btnSettings.setOpaque(false);
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MazeSettings settings = new MazeSettings();
				settings.setVisible(true);
			}
		});
		btnSettings.setBounds(220, 150, 115, 71);
		contentPane.add(btnSettings);
		
		JButton btnStart = new JButton("");
		btnStart.setContentAreaFilled(false);
		btnStart.setFocusable(false);
		btnStart.setIcon(new ImageIcon(((new ImageIcon(
	            "src/assets/start/startBtn.png").getImage()
	            .getScaledInstance(89, 45,
	                    java.awt.Image.SCALE_SMOOTH)))));
		btnStart.setOpaque(false);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				GameWindow play = new GameWindow();
				Controller controller = new Controller(play, player);
				controller.level = level;
				
				controller.startGame();
				controller.generateInitialGUIgrid();
				Controller.generateMap(GameWindow.panelMap);
				play.setVisible(true); 
			}
		});
		btnStart.setBounds(220, 42, 115, 71);
		contentPane.add(btnStart);
	}
	
	  public void paintComponent(Graphics g) {
		  g.drawImage(img, 10, 30, this.getWidth(), this.getHeight(), null);
	  }

}
