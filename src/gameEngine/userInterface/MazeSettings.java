package gameEngine.userInterface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import drawables.dynamic_drawables.character.player.Player;
import drawables.dynamic_drawables.character.player.derivatives.Knight;
import drawables.dynamic_drawables.character.player.derivatives.Princess;
import gameEngine.controller.ImageIconFactory;
import grid.Levels.builder.ILevelBuilder;
import grid.Levels.builder.derivatives.EasyLevel;
import grid.Levels.builder.derivatives.HardLevel;
import grid.Levels.builder.derivatives.MediumLevel;

public class MazeSettings extends JFrame {

	private StartingImagePanel contentPane;
	public static MazeSettings frame2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame2 = new MazeSettings();
					frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MazeSettings() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 544, 389);
		Image img = new ImageIcon( System.getProperty("user.dir") 
				+ "/src/assets/start/textureBackground.jpg").getImage();
		contentPane = new StartingImagePanel(img);
		contentPane.setBackground(new Color(204, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCharacter = new JLabel("Choose Your Character : ");
		lblCharacter.setHorizontalAlignment(SwingConstants.LEADING);
		lblCharacter.setBounds(57, 70, 152, 40);
		lblCharacter.setForeground(Color.BLACK);
		contentPane.add(lblCharacter);
		
		JLabel lblLevel = new JLabel("Choose the Level :");
		lblLevel.setForeground(Color.BLACK);
		lblLevel.setBounds(57, 189, 152, 40);
		contentPane.add(lblLevel);
		
		JComboBox comboCharacter = new JComboBox();
		comboCharacter.setFocusable(false);
		comboCharacter.setModel(new DefaultComboBoxModel(new String[] {"Ahmed", "Bassam", "Alaa", "Bassant"}));
		comboCharacter.setBounds(333, 70, 173, 40);
		contentPane.add(comboCharacter);
		
		JComboBox comboLevel = new JComboBox();
		comboLevel.setFocusable(false);
		comboLevel.setModel(new DefaultComboBoxModel(new String[] {"Easy", "Medium", "Hard"}));
		comboLevel.setBounds(333, 189, 173, 40);
		contentPane.add(comboLevel);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFocusable(false);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String xLevel = (String) comboLevel.getSelectedItem();
				if(xLevel.equals("Easy")){
					MazeRunner.level = new EasyLevel();
				} else if(xLevel.equals("Medium")){
					MazeRunner.level = new MediumLevel();
				} else{
					MazeRunner.level = new HardLevel();
				}
				String xPlayer = (String) comboCharacter.getSelectedItem();
				if(xPlayer.equals("Bassam") || xPlayer.equals("Ahmed")){
					MazeRunner.player = Knight.getInstance();
				} else{
					MazeRunner.player = Princess.getInstance();
				}
				dispose();
				ImageIconFactory.yourchar = "\\" + xPlayer + "\\";
				System.out.println(xLevel + " " + xPlayer);
			}
		});
		btnOk.setBounds(207, 255, 95, 70);
		contentPane.add(btnOk);
	}
}
