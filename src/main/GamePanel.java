package main;

import java.awt.Color;
import static main.TheGame.GAME_HEIGHT;
import static main.TheGame.GAME_WIDTH;
import static Utilz.Constants.PlayerConstants.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;
import static Utilz.Constants.Directions.*;

public class GamePanel extends JPanel{
	private MouseInputs mouseInputs;

	private TheGame game;
	public GamePanel(TheGame game){
		this.game = game;
		
		mouseInputs = new MouseInputs(this);
		
		setPanelSize();
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
		
			
		
		
	}
	
	
	
	
	private void setPanelSize() {
		Dimension size = new Dimension(GAME_WIDTH,GAME_HEIGHT);
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
		
		
	}
	
	
	
	public void updateGame() {
		
		
	}
	

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		game.render(g);
		
		//subimg = img.getSubimage(1*64, 40*8, 64, 40);
		
		
		
		
	}
	public TheGame getGame() {
		return game;
	}
	
	
	
	

}
