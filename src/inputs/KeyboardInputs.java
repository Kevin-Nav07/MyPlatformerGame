package inputs;

import java.awt.event.KeyEvent;
import static Utilz.Constants.Directions.*;
import java.awt.event.KeyListener;

import entities.Player;
import main.GamePanel;

public class KeyboardInputs implements KeyListener{
	private GamePanel gamePanel;
	
	
	public KeyboardInputs(GamePanel g) {
		this.gamePanel = g;
	}
		public void keyTyped(KeyEvent e) {
			
		}
		
		public void keyReleased(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_W:
				gamePanel.getGame().getPlayer().setUp(false);
				break;
				
				
			case KeyEvent.VK_A:
				gamePanel.getGame().getPlayer().setLeft(false);
				break;
			
			
			case KeyEvent.VK_D: 
				gamePanel.getGame().getPlayer().setRight(false);
				break;

			case KeyEvent.VK_S:	
				gamePanel.getGame().getPlayer().setDown(false);
				
				break;
			}
			
		}
		
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_W:
				gamePanel.getGame().getPlayer().setUp(true);
				break;
				
				
			case KeyEvent.VK_A:
				gamePanel.getGame().getPlayer().setLeft(true);
				break;
			
			
			case KeyEvent.VK_D: 
				gamePanel.getGame().getPlayer().setRight(true);
				break;

			case KeyEvent.VK_S:	
				gamePanel.getGame().getPlayer().setDown(true);
				
				break;
			}
		}
		
	
	

}
