package main;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import  javax.swing.JFrame;
public class GameWindow {
	private JFrame jframe;
	public GameWindow(GamePanel gamepanel) {
		jframe = new JFrame();
		//jframe.setSize(450,450);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.add(gamepanel);
		jframe.setLocationRelativeTo(null);
		jframe.setResizable(false);
		
		
		jframe.pack();
		
		jframe.setVisible(true);
        jframe.addWindowFocusListener(new WindowFocusListener(){
			
			public void windowLostFocus(WindowEvent e) {
				gamepanel.getGame().windowFocusLost();
			}
			
			public void windowGainedFocus(WindowEvent e) {
				
			}
			
		});
		
		}
	

}
