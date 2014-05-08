package Tiles;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import Characters.Character;
import MainFiles.ImageShowingComponent;
import MainFiles.MainClass;


public class Tiles {
		public String bName;
		public Boolean bCollision;
		public Boolean bInside;
		public int imgX, imgY;
		public int tileX;
		public int tileY;
		public Boolean exitTile = false;
		public int exitMap;
		public int exitTileNumberX;
		public int exitTileNumberY;
		public TileClass tileClass;
		Character char1;
		Character char2;
		Image block;
		
		public Tiles(){}
		
		public Tiles(MainClass mc){
			this.block = mc.getMapTiles().getSubimage(75, 0, 25, 25);
			this.bCollision = true;
			tileClass = new TileClass(block);
		};
		
		public Tiles(String n, Boolean b, int x, int y, int tX, int tY){
			imgX = x;
			imgY = y;
			bName = n;
			bCollision = b;
			tileX =tX;
			tileX =tY;
			tileClass = new TileClass();
		}
		
		public String getbName() {
			return bName;
		}
		
		public Boolean getbCollision() {
			return bCollision;
		}
		
		public void setExitTile(int i, int j, int k){
			exitMap = i;
			exitTileNumberX = j;
			exitTileNumberY = k;
			exitTile = true;	
		}
		
		public Boolean isExitTile(){
			return exitTile;
		}
		
		public int getExitTileNumberX(){
			return exitTileNumberX;
		}
		public int getExitTileNumberY(){
			return exitTileNumberY;
		}
		
		public int getExitMap(){
			return exitMap;
		}
		
		public void setChar1(Character c){
			this.tileClass.removeAll();
			this.tileClass.add(c.charClass);
			char1 = c;
			this.tileClass.revalidate();
		}
		public void setChar2(Character c){
			char2 = c;
		}
		
		public Character getChar1(){
			return char1;
		}
		public Character getChar2(){
			return char2;
		}
		public void clearChar1(){
			this.char1=null;
			this.tileClass.removeAll();
			this.tileClass.revalidate();
		}
		
		@SuppressWarnings("serial")
		class TileClass extends ImageShowingComponent{
			TileClass(){
			}
			
			TileClass(Image i){
				this.setImage(i);
				this.setPreferredSize(new Dimension(25, 25));
				this.setMaximumSize(new Dimension(25, 25));
				this.setLayout(new GridLayout(1,1));
				this.setVisible(true);
				//this.setBorder(BorderFactory.createLineBorder(Color.black));
				//System.out.println(this);
			}
			
			  public void paintComponent(Graphics g) {
				  super.paintComponent(g);
				  g.drawImage(this.getImage(), 0, 0, null);
			  }
		}
		
		
}
