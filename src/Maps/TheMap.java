package Maps;

import Characters.Character;
import MainFiles.MainClass;
import MainFiles.MapHandler;
import Tiles.Tiles;

public class TheMap {
	public int mWidth;
	public int mHeight;
	public Tiles[][] theTile;
	
	int randomNum;
	
	public TheMap(){
		mWidth = 32;
		mHeight = 24;
		theTile = new Tiles[mWidth][mHeight];
	}
	
	public void reset(){}
	
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
	
	public Tiles getTile(int x, int y)
	{
		return theTile[x][y];
	}

	public void onLoad(MapHandler mh, MainClass mc) {
		//  Auto-generated method stub
		
	}
	
}
