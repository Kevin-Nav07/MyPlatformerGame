package Utilz;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import main.TheGame;

public class LoadSave {
	public static final String PLAYER_ATLAS = "player_sprites.png";
	public static final String LEVEL_ONE_DATA = "level_one_data.png";
	public static final String LEVEL_ATLAS = "outside_sprites.png";
	public static BufferedImage GetSpriteAtLast(String filename) {
		BufferedImage img = null;
		   InputStream is = LoadSave.class.getResourceAsStream("/" + filename);			
				   try{
			
				img = ImageIO.read(is);
				
			}
			catch(IOException e) {
				e.printStackTrace();
			} 
			finally {
				try {
					is.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
			return img;
	}
	public static int[][]GetLevelData(){
		
		int[][] lvlData = new int[TheGame.TILES_IN_HEIGHT][TheGame.TILES_IN_WIDTH];
		BufferedImage img = GetSpriteAtLast(LEVEL_ONE_DATA);
		for(int j = 0; j < img.getHeight(); j ++) {
			for(int i = 0; i < img.getWidth(); i ++) {
				Color color = new Color(img.getRGB(i,  j));
				int value = color.getRed();
				if(value >= 48) {
					value = 0;
				}
				lvlData[j][i] = value;
			}
		}
		return lvlData;
	}

}
