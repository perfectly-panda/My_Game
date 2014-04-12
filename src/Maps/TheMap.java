package Maps;

import java.awt.Graphics;

import Characters.Character;
import MainFiles.MainClass;
import MainFiles.MapHandler;

public class TheMap {
	public int[][] tileMap;
	public int mWidth;
	public int mHeight;
	public int[] tileNum;
	
	int randomNum;
	
	public TheMap(){
		mWidth = 32;
		mHeight = 24;
		tileMap = new int[mWidth][mHeight];
		tileNum = new int[mWidth * mHeight];
	}
	
	public int[][] loadMap(int[] tN)
	{
		int [][] tM = new int[mWidth][mHeight];
		for ( int row = 0; row < mHeight; row++)
		{
			for (int col = 0; col < mWidth; col++)
			{
				tM[col][row]=tN[col + (row*(mWidth))];
			}
		}
		return tM;
	}
	
	public void draw(Graphics g, MainClass mc){
		int xPos, yPos;
		xPos = 0;
		yPos = 0;
		for (int col = 0; col < mWidth; col ++)
		{
			for (int row = 0; row < mHeight; row++)
			{
				g.drawImage(mc.mapTiles, xPos, yPos, xPos + 25, yPos + 25, (tileMap[col][row] * 25), 0, (tileMap[col][row] * 25)+ 25, 25, null);
				yPos += 25;
			}
			xPos += 25;
			yPos = 0;
		}
		
	}
	
	public void checkExit(int i, int j, Character c, MapHandler mapHandler, MainClass mc){
		System.out.println("its going here");
	}
	
	public int getWidth()
	{
		return mWidth;
	}
	
	public int getHeight()
	{
		return mHeight;
	}
	
	public int getTile(int x, int y)
	{
		return tileMap[x][y];
	}

	public void onLoad(MapHandler mh, MainClass mc) {
		//  Auto-generated method stub
		
	}
	
}
