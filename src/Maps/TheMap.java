package Maps;

import Characters.Character;
import MainFiles.MainClass;
import MainFiles.MapHandler;
import Tiles.Tiles;

public class TheMap {
	public int[][] tileMap;
	public int mWidth;
	public int mHeight;
	public int[] tileNum;
	public Tiles[] theTile;
	
	int randomNum;
	
	public TheMap(){
		mWidth = 32;
		mHeight = 24;
		tileMap = new int[mWidth][mHeight];
		tileNum = new int[mWidth * mHeight];
		theTile = new Tiles[mWidth * mHeight];
	}
	
	public void reset(){}
	
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
	
	public Tiles getTile(int x)
	{
		return theTile[x];
	}

	public void onLoad(MapHandler mh, MainClass mc) {
		//  Auto-generated method stub
		
	}
	
}
