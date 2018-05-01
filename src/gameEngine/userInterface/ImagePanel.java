/**
 *
 */
package gameEngine.userInterface;

import drawables.dynamic_drawables.bullet.Bullet;
import drawables.dynamic_drawables.character.monster.Monster;
import drawables.static_drawables.emptyMaze.Empty;
import gameEngine.controller.Controller;
import gameEngine.controller.ImageIconFactory;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

/**
 * @author a7med
 */
public class ImagePanel extends JPanel {
    //for camera
    private static int camX = 0, camY = 0, camH = 670, camW = 660;
    private Image img;
    //private Controller Controller;
    private GameWindow gui;
    private Point oldPlayerPosition;
    private Point viewPort = new Point(660, 670);
    private Point mazeSize = new Point(31 * 60, 31 * 60);

    public ImagePanel(Image img, GameWindow g) {
        //this.Controller = c;
        this.img = img;
        this.gui = g;
        Dimension size = new Dimension(660, 670);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);

        setFocusable(true);
        requestFocusInWindow();

        addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                myKeyEvt(e, "keyPressed");
            }

            private void myKeyEvt(KeyEvent e, String text) {
                int key = e.getKeyCode();
                Point destination = new Point(Controller.player.getCenterPoint().x, Controller.player.getCenterPoint().y);
                oldPlayerPosition = new Point(Controller.player.getCenterPoint().x, Controller.player.getCenterPoint().y);
                if (key == KeyEvent.VK_KP_LEFT || key == KeyEvent.VK_LEFT) {
                    destination.x = destination.x - 1;
                    Controller.player.setMovingDirection(3);
                } else if (key == KeyEvent.VK_KP_RIGHT || key == KeyEvent.VK_RIGHT) {
                    destination.x = destination.x + 1;
                    Controller.player.setMovingDirection(2);
                } else if (key == KeyEvent.VK_KP_UP || key == KeyEvent.VK_UP) {
                    destination.y = destination.y - 1;
                    Controller.player.setMovingDirection(0);
                } else if (key == KeyEvent.VK_KP_DOWN || key == KeyEvent.VK_DOWN) {
                    destination.y = destination.y + 1;
                    Controller.player.setMovingDirection(1);

                } else if (key == KeyEvent.VK_SPACE) {
                    fireBullet();
                }
                if (Controller.validDestination(destination)) {
                    Point cam = Controller.changeCameraView(camX, camY, e.getKeyCode());
                    camX = cam.x;
                    camY = cam.y;
                    JLabel b = Controller.guiMaze[oldPlayerPosition.x][oldPlayerPosition.y];
                    b.setIcon(null);
                    Controller.player.moveTo(destination);
                    String imgPath = System.getProperty("user.dir") + Controller.player.getImageDirectory();
                    
                    b = Controller.guiMaze[destination.x][destination.y];
                    ImageIconFactory.charWanted = true;
                    b.setIcon(ImageIconFactory.getImageIcon(imgPath));
                    Controller.map[oldPlayerPosition.x][oldPlayerPosition.y].setIcon(null);
	            	Controller.map[destination.x][destination.y].setIcon(ImageIconFactory.getImageIcon(imgPath));
                    play();
                    ImageIconFactory.charWanted = true;
                    //Controller.render(b, destination);
                    repaint();
                }
            }
        });
    }

    public int getCamX() {
        return camX;
    }

    public void setCamX(int camX) {
        ImagePanel.camX = camX;
    }

    public int getCamY() {
        return camY;
    }

    public void setCamY(int camY) {
        ImagePanel.camY = camY;
    }

    public int getCamH() {
        return camH;
    }

    public void setCamH(int camH) {
        ImagePanel.camH = camH;
    }

    public int getCamW() {
        return camW;
    }

    public void setCamW(int camW) {
        ImagePanel.camW = camW;
    }

    private void play() {

        try {
            File file = new File(System.getProperty("user.dir") + "\\src\\assets\\Audio\\Footstep01.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
            //Thread.sleep(clip.getMicrosecondLength());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
        Graphics2D g2d = (Graphics2D) g;
        if (Controller.gameStarted) {
            g2d.translate(-camX, -camY);
              /*	Controller.render();
              g2d.translate(-camX, -camY);*/
        }
    }

    public Point getNextCell(Point bulletPosition) {
        int movingDirection = Controller.player.getMovingDirection();
        Point nextCell = new Point(bulletPosition.x, bulletPosition.y);
        if (movingDirection == 0) {
            //system.out.println("up");
            nextCell.y = nextCell.y - 1;
            return nextCell;
        } else if (movingDirection == 1) {
            //system.out.println("down");
            nextCell.y = nextCell.y + 1;
            return nextCell;
        } else if (movingDirection == 2) {
            //system.out.println("right");
            nextCell.x = nextCell.x + 1;
            return nextCell;
        } else if (movingDirection == 3) {
            //system.out.println("left");
            nextCell.x = nextCell.x - 1;
            return nextCell;
        }
        return null;
    }

    public void applyDamage(Point nextCell, Point bulletPosition, Bullet bullet) {
        String objectType = Controller.maze[nextCell.x][nextCell.y].getType().toString();
        if (objectType.contains("monster")) {
            ((Monster) ((Controller.maze[nextCell.x][nextCell.y]).getType())).causeDamage(bullet.getBulletDamage());
            if (((Monster) ((Controller.maze[nextCell.x][nextCell.y]).getType())).getCharacterHealth() == 0) {
                Controller.maze[nextCell.x][nextCell.y].setType(new Empty());
                Controller.maze[nextCell.x][nextCell.y].setValidity(true);
                Controller.guiMaze[nextCell.x][nextCell.y] = null;
                //system.out.println("HIT TREE");
                SwingUtilities.updateComponentTreeUI(gui);
                //repaint();
            }

        } else if (objectType.contains("Bomb") || objectType.contains("Tree") || objectType.contains("mysterious")) {
            Controller.maze[nextCell.x][nextCell.y].setType(new Empty());
            Controller.maze[nextCell.x][nextCell.y].setValidity(true);
            Controller.guiMaze[nextCell.x][nextCell.y].setIcon(null);
            SwingUtilities.updateComponentTreeUI(gui);

        } else if (objectType.contains("Stone")) {
            //system.out.println("HIT WALL");
        }
    }

    public void fireBullet() {
    	playFireSound();
        Thread firingBulletThread = new Thread(new BulletMovement(), "Bullet Moving Runnable");
        firingBulletThread.start();
    }

    private void playFireSound() {
    	try {
 		   File file = new File(System.getProperty("user.dir") + "\\src\\assets\\Audio\\sounds\\explosion.wav");
 		   Clip clip = AudioSystem.getClip();
 		   clip.open(AudioSystem.getAudioInputStream(file));
 		   clip.start();
 		   //Thread.sleep(clip.getMicrosecondLength());
 		  } catch (Exception e) {
 		   System.err.println(e.getMessage());
 		  }
	}

    private class BulletMovement implements Runnable {
        @Override
        public void run() {
            Bullet bullet;
            if (Controller.player.hasBullets()) {
                bullet = Controller.player.getNextBullet();
                Point bulletPosition = Controller.player.getCenterPoint();
                Point nextCell = getNextCell(bulletPosition);
                String objectType = Controller.maze[nextCell.x][nextCell.y].getType().toString();
                boolean hit = false;
                //system.out.println(objectType);
                while (objectType.contains("Empty")) {
                    Controller.guiMaze[bulletPosition.x][bulletPosition.y].setIcon(ImageIconFactory.getImageIcon(Empty.getEmptyAssetsDirectory()));
                    bulletPosition = new Point(nextCell);
                    nextCell = getNextCell(bulletPosition);
                    Controller.guiMaze[bulletPosition.x][bulletPosition.y].setIcon(ImageIconFactory.getImageIcon(bullet.getImageOfDirection(Controller.player.getMovingDirection())));
                    objectType = Controller.maze[nextCell.x][nextCell.y].getType().toString();
                    //System.out.println(objectType);
                    SwingUtilities.updateComponentTreeUI(gui);
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Controller.guiMaze[bulletPosition.x][bulletPosition.y].setIcon(ImageIconFactory.getImageIcon(Empty.getEmptyAssetsDirectory()));
                applyDamage(nextCell, bulletPosition, bullet);
            }
        }
    }
}
