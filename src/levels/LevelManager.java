package levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import main.TheGame;
import Utilz.LoadSave;



public class LevelManager {
	private BufferedImage[] levelSprite;
	private TheGame game;
	private Level levelOne;
   public LevelManager(TheGame game) {
	   this.game = game;
	   //levelSprite = LoadSave.GetSpriteAtLast(LoadSave.LEVEL_ATLAS);
	   importOutsideSprites();
	   levelOne = new Level(LoadSave.GetLevelData());
	   
	 
   }
   private void importOutsideSprites() {
	// TODO Auto-generated method stub
	BufferedImage img = LoadSave.GetSpriteAtLast(LoadSave.LEVEL_ATLAS);
	levelSprite = new BufferedImage[48];
	for(int j = 0; j < 4; j ++) {
		for(int i = 0;  i < 12; i++) {
			int index = j*12 +i;
			levelSprite[index]= img.getSubimage(i*32, j *32, 32, 32)
;		}
	}
}
public void draw(Graphics g) {
	for(int j = 0; j < game.TILES_IN_HEIGHT; j ++) {
		for(int i = 0; i < game.TILES_IN_WIDTH; i++) {
			int index = levelOne.GetSpriteIndex(i, j);
			 g.drawImage(levelSprite[index], game.TILES_SIZE*i, game.TILES_SIZE*j,game.TILES_SIZE, game.TILES_SIZE, null);
		}
	}
	  
   }
   public void update() {
	   
   }
}
