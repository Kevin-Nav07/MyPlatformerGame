package entities;

import static Utilz.Constants.Directions.UP;
import static Utilz.Constants.Directions.LEFT;
import static Utilz.Constants.Directions.RIGHT;
import static Utilz.Constants.Directions.UP;
import static Utilz.Constants.PlayerConstants.GetSpriteAmount;
import static Utilz.Constants.PlayerConstants.IDLE;
import static Utilz.Constants.PlayerConstants.RUNNING;
import static Utilz.Constants.PlayerConstants.ATTACK_1;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import Utilz.LoadSave;

public class Player extends Entity{
	private int aniTick, aniIndex, aniSpeed = 30;
	private int playerAction = IDLE;
	
	private boolean moving = false, attacking = false;
	private boolean left,up,right, down;
    private BufferedImage[][] animations;
    private float playerSpeed = 2.0f;
    public Player(float x, float y) {
		super(x, y);
		loadAnimations();
		// TODO Auto-generated constructor stub
	}
	public void update() {
		updatePos();
		updateAnimationTick();
		setAnimation();
		
		
	}
	public void render(Graphics g) {
		
		//subimg = img.getSubimage(1*64, 40*8, 64, 40);
	
		g.drawImage(animations[playerAction][aniIndex], (int)x, (int)y,120,80, null);
		
	}
	
	public void setAttacking(boolean attacking) {
		this.attacking = attacking;
		
	}

	private void setAnimation() {
		int startAni = playerAction;
		if(this.moving) {
			playerAction = RUNNING;
		}
			else {
				playerAction = IDLE; //to signify player idle
				//amother comment
			}
		if(attacking) {
			playerAction = ATTACK_1;
		}
		
		if(startAni != playerAction) {
			resetAniTick();
		}
		
		
	}
	private void resetAniTick() {
		aniTick = 0;
		aniIndex = 0;
	}
	public void resetDirectionBooleans() {
		left = false;
		right = false;
		up = false;
		down = false;
	}
	
	private void updatePos() {
		moving = false;
		if(left && !right) {
			x-=playerSpeed;
			moving = true;
		}
		else if(right && !left) {
			x+=playerSpeed;
			moving = true;
			
		}
		if(up && !down) {
			y-=playerSpeed;
			moving = true;
		}
		else if(down && !up) {
			y+=playerSpeed;
			moving = true;
			
		}
	
	}
	private void updateAnimationTick() {
		// TODO Auto-generated method stub
     	aniTick++;
		if(aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex++;
			if(aniIndex >= GetSpriteAmount(playerAction)) {
				aniIndex =0;
				attacking = false;
			}
		}
	}
	private void loadAnimations() {
		
       
		
			BufferedImage img = LoadSave.GetSpriteAtLast(LoadSave.PLAYER_ATLAS);
			animations = new BufferedImage[9][6];
			
			for(int j = 0; j < animations.length; j++) {
				for(int i = 0; i < animations[j].length; i++) {
					animations[j][i] = img.getSubimage(i*64, j*40, 64, 40);
				}
			}
		
		
		
		
		
	}
	public boolean isLeft() {
		return left;
	}
	public void setLeft(boolean left) {
		this.left = left;
	}
	public boolean isUp() {
		return up;
	}
	public void setUp(boolean up) {
		this.up = up;
	}
	public boolean isRight() {
		return right;
	}
	public void setRight(boolean right) {
		this.right = right;
	}
	public boolean isDown() {
		return down;
	}
	public void setDown(boolean down) {
		this.down = down;
	}

}
