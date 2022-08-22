package main;

import java.awt.Graphics;

import entities.Player;
import levels.LevelManager;

public class TheGame implements Runnable {
	private GameWindow gamewindow;
	private GamePanel gamepanel;
	private Thread gameThread;
	private Player player;
	private final int FPS_SET=120;
	private final int UPS_SET= 200;
	private LevelManager levelManager;
	
	public final static int TILES_DEFAULT_SIZE = 32;
	public final static float SCALE = 1.5F;
	public  final static int TILES_IN_WIDTH = 26;
	public final static int TILES_IN_HEIGHT = 14;
	public final static int TILES_SIZE = (int)(TILES_DEFAULT_SIZE*SCALE);
    public final static int GAME_WIDTH = TILES_SIZE*TILES_IN_WIDTH;
    public final static int GAME_HEIGHT = TILES_SIZE*TILES_IN_HEIGHT;

	public TheGame() {
		initClasses();
		gamepanel = new GamePanel(this);
		gamewindow = new GameWindow(gamepanel);
		gamepanel.setFocusable(true);
		gamepanel.requestFocus();
		
		startGameLoop();
		
	}
	private void initClasses() {
		// TODO Auto-generated method stub
		player = new Player(200,200);
		levelManager = new LevelManager(this);
	}
	public void update() {
		player.update();
		levelManager.update();
	}
	
	public void render(Graphics g) {
	
		levelManager.draw(g);
		player.render(g);
		
		
		
	}
	public void run() {
		double timePerFrame = 1000000000.0/FPS_SET;
		double timePerUpdate = 1000000000.0/UPS_SET;
		long lastFrame = System.nanoTime();
		long now = System.nanoTime();
		long previousTime = System.currentTimeMillis();
		int frames = 0;
		int updates = 0;
		double deltaU = 0;
		double deltaF = 0;
		
		long lastCheck = System.currentTimeMillis();
		
		
		while(true) {
			now = System.nanoTime();
			long currentTime = System.nanoTime();
			
			deltaU += (currentTime - previousTime)/timePerUpdate;
			deltaF+=(currentTime - previousTime)/timePerFrame;
			previousTime = currentTime;
			
			if(deltaU >=1) {
				update();
				updates++;
				deltaU--;
			}
			
			if(deltaF >=1) {
				
				gamepanel.repaint();
				
				frames++;
				deltaF--;
			}
			
			
			
			
			if(System.currentTimeMillis()-lastCheck >=1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " +frames + "| UPS: " + updates);
				frames =0;
				updates = 0;
			}
		}
	}
	
	public void windowFocusLost() {
		player.resetDirectionBooleans();
	}
	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
public Player getPlayer() {
		return player;
	}

}
