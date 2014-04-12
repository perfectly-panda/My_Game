package Cards;
import java.awt.Image;

import MainFiles.BufferedImageLoader;

public class Cards {
	
	private String cardName;
	public int cardValue;
	public int cardCost;
	public int cardDamage;
	public Image cardImage;
	
	private BufferedImageLoader il = new BufferedImageLoader();
	
	public Cards () {}
	
	public String getCardName(){
		return this.cardName;
	}
	
	public void setCardName(String s){
		this.cardName = s;
	}
	
	public int getCardValue(){
		return this.cardValue;
	}
	
	public void setCardValue(int i){
		this.cardValue = i;
	}
	
	public int getCardCost(){
		return this.cardCost;
	}
	
	public void setCardCost(int i){
		this.cardCost = i;
	}
	
	public int getCardDamage(){
		return this.cardDamage;
	}
	
	public void setCardDamage(int i){
		this.cardDamage = i;
	}
	
	public Image getCardImage(){
		return cardImage;
	}
	
	public void setCardImage(String s){
		cardImage = il.loadImage(s);
	}

	public int getCardAttack() {
		return this.cardDamage;
	}
	
}
