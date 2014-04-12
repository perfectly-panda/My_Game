package EncounterHandler;


import java.awt.Graphics;
import java.awt.Image;

import Cards.Blank;
import Cards.Cards;
import Characters.Character;
import MainFiles.Encounter;
import MainFiles.MainClass;

public class PlayerEnergy {
	
	Cards[] playerEnergy;
	Blank b = new Blank();
	
	public PlayerEnergy(){
		playerEnergy = new Cards[7];
		for (int i = 0; i < 7; i++){
			setPlayerEnergy(i, b);
		}
	}
	
	public void addEnergy(Cards card, Character p)
	{
		int currentEnergy = 0;
		for(int i=0; i<7; i++)
		{
			//find the next empty slot
			if (getPlayerEnergy(i) == b)
			{
				playerEnergy[i] = card;
				//System.out.println(this.getPlayerEnergy(i).getCardName());
				i = 10;
			}
		}
		
		//set current total
		for(int i=0; i<7; i++)
		{
			if (getPlayerEnergy(i) != b)
			{
				int cardEnergy = getPlayerEnergyValue(i);
				currentEnergy = currentEnergy + cardEnergy;
			}
		}
		p.setCurrentEnergy(currentEnergy);
	}
	
	public void energyEndTurn(Character p)
	{
		for(int i=0; i<7; i++)
		{
			this.setPlayerEnergy(i, b);
		}
		p.setCurrentEnergy(0);
	}
	
	public void drawEnergyHandler(Encounter e, Graphics g, MainClass mc){
		
		//column one
			g.drawImage(this.getPlayerEnergyImage(1), 140, 320, 85, 85, mc);
			g.drawImage(this.getPlayerEnergyImage(3), 160, 340, 85, 85, mc);
			g.drawImage(this.getPlayerEnergyImage(5), 180, 360, 85, 85, mc);
			g.drawImage(this.getPlayerEnergyImage(6), 200, 380, 85, 85, mc);
			
		//column two
			g.drawImage(this.getPlayerEnergyImage(0), 50, 320, 85, 85, mc);
			g.drawImage(this.getPlayerEnergyImage(2), 70, 340, 85, 85, mc);
			g.drawImage(this.getPlayerEnergyImage(5), 90, 360, 85, 85, mc);
	}
	
	public Cards getPlayerEnergy(int i){
		return this.playerEnergy[i];
	}
	
	public void setPlayerEnergy(int i, Cards c){
		this.playerEnergy[i] = c;
	}
	
	public Image getPlayerEnergyImage(int i){
		return this.playerEnergy[i].getCardImage();
	}
	
	public int getPlayerEnergyValue (int i){
		return this.playerEnergy[i].getCardValue();
	}

}
