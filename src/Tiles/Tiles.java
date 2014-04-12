package Tiles;


public class Tiles {
		public String bName;
		public Boolean bCollision;
		public int imgX, imgY;
		public int tileNum;
		
		public Tiles(){};
		
		public Tiles(String n, Boolean b, int x, int y, int tN){
			imgX = x;
			imgY = y;
			bName = n;
			bCollision = b;
			tileNum =tN;
		}
		
		public String getbName() {
			return bName;
		}
		
		public Boolean getbCollision() {
			return bCollision;
		}
		
		
		
}
