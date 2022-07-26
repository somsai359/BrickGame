package brick;
import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import java.awt.Rectangle;
/**
 * 
 * @author somas
 *
 */
public class Play extends JPanel implements KeyListener,ActionListener {
	private boolean  play = false;
	private int score =0;
	private int totalBricks =21;
	private Timer time;
	private int  delay =8;
	private int playerX=310;
	private int ballposX = 120;
	private int ballposY = 350;
	private int ballXdir =-1;
	private int ballYdir =-2;
	
	
	public Play(){
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		 time = new Timer(delay,this);
		 time.start();	
	}
	@SuppressWarnings("null") 
	public void paint(Graphics g) {
		//back ground
		g.setColor(Color.black);
		g.fillRect(1,2,692,592);
		// border
		g.setColor(Color.red);
		g.fillRect(0,0,3,592);
		g.fillRect(0,0,692,3);
		g.fillRect(0,0,4,592);
		//the paddle	
		g.setColor(Color.orange);
		g.fillRect(playerX,550,100,8);
		
		//the ball
		g.setColor(Color.red);
		g.fillOval(ballposX,ballposY,20,20);
		g.dispose();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		time.start();
    	if(play) {
    		if(new Rectangle(ballposX,ballposY,20,20).intersects(new Rectangle(playerX,550,100,8))) {
    			ballYdir =-ballYdir;
    		}
		ballposX += ballXdir;
 		ballposY += ballYdir;
 		if(ballposX <0) {
				ballXdir = -ballXdir;
			}
        	}
    	if(ballposY <0) {
			ballYdir = -ballYdir;
    	}
    	if(ballposY > 670) {
			ballXdir = -ballXdir;
    	}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
	if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
		if(playerX >=600) {
			playerX =600;
			
		}
		else {
			moveRight();
		}
	}
     if(e.getKeyCode() == KeyEvent.VK_LEFT) {
    	 if(playerX <10) {
 			playerX =10;
 			
 		}
 		else {
 			moveLeft();
 		}
	}
		
	}
	private void moveRight() {
		play = true;
		playerX +=20;
		
	}
	private void moveLeft() {
		play = true;
		playerX -=20;
		
	}
	

}
