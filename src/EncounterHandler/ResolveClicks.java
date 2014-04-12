package EncounterHandler;

import MainFiles.Encounter;
import MainFiles.MainClass;

public class ResolveClicks {
	
	public void resolveClicks(){}
	
	public void rc(Encounter e, MainClass mc){
		mc.clicked = false;
		mc.setMovable(false);
		
		
		int x = mc.getXPos();
		int y = mc.getYPos();
		int k = e.getKeyPress();
		//change turn
		//System.out.println(x + "     " + y);
			if (x >= 680 && x <= 744)
			{
				if (y >= 290 && y <= 311)
				{
					e.changeTurnOver(e.turnComplete);
				}
			}
			else if(k == 10)
			{
				e.changeTurnOver(e.turnComplete);
				e.setKeyPress(0);
			}

			
		// change between energy and attack
			else if (y >= 285 && y <= 285+190)
			{
				//System.out.println("switching energy and attack"); //debug
				if (x >= 40 && x <= 40+250)
				{
					//System.out.println("switching to energy"); //debug
					e.setActiveArea(1);
				}
				if (x >= 295 && x <= 295+250)
				{
					//System.out.println("switching to attack"); //debug
					e.setActiveArea(2);
				}
			}
			else if (k == 32){
				if (e.getActiveArea() == 1){
					e.setActiveArea(2);
				}
				else{
					e.setActiveArea(1);
				}
			}
			
		//click on cards in hand
			else if (y >= 500 && y <=585)
			{
				if (x >= 50 && x <= 135)
				{
					if(e.getTurnOver() == e.turnComplete)
					{
						e.setHandClick(0);
						e.ph.cardHandler(e, e.pe, e.pa, e.p);
						// System.out.println("Mouse has clicked hand 1"); // debug
					}
				}
				else if (x >= 150 && x <= 235)
				{
					if(e.getTurnOver() == e.turnComplete)
					{
						e.setHandClick(1);
						e.ph.cardHandler(e, e.pe, e.pa, e.p);
						// System.out.println("Mouse has clicked hand 1"); // debug
					}
				}
				else if (x >= 250 && x <= 335)
				{
					if(e.getTurnOver() == e.turnComplete)
					{
						e.setHandClick(2);
						e.ph.cardHandler(e, e.pe, e.pa, e.p);
						// System.out.println("Mouse has clicked hand 1"); // debug
					}
				}
				else if (x >= 350 && x <= 435)
				{
					if(e.getTurnOver() == e.turnComplete)
					{
						e.setHandClick(3);
						e.ph.cardHandler(e, e.pe, e.pa, e.p);
						// System.out.println("Mouse has clicked hand 1"); // debug
					}
				}
				else if (x >= 450 && x <= 535)
				{
					if(e.getTurnOver() == e.turnComplete)
					{
						e.setHandClick(4);
						e.ph.cardHandler(e, e.pe, e.pa, e.p);
						// System.out.println("Mouse has clicked hand 1"); // debug
					}
				}
				else if (x >= 550 && x <= 635)
				{
					if(e.getTurnOver() == e.turnComplete)
					{
						e.setHandClick(5);
						e.ph.cardHandler(e, e.pe, e.pa, e.p);
						// System.out.println("Mouse has clicked hand 1"); // debug
					}
				}
				else if (x >= 650 && x <= 735)
				{
					if(e.getTurnOver() == e.turnComplete)
					{
						e.setHandClick(6);
						e.ph.cardHandler(e, e.pe, e.pa, e.p);
						// System.out.println("Mouse has clicked hand 1"); // debug
					}
				}
				
			}
			
			else if (k == 49)
			{
				if(e.getTurnOver() == e.turnComplete)
				{
					e.setKeyPress(0);
					e.setHandClick(0);
					e.ph.cardHandler(e, e.pe, e.pa, e.p);
					// System.out.println("Mouse has clicked hand 1"); // debug
				}
			}
			else if (k == 50)
			{
				if(e.getTurnOver() == e.turnComplete)
				{
					e.setKeyPress(0);
					e.setHandClick(1);
					e.ph.cardHandler(e, e.pe, e.pa, e.p);
					// System.out.println("Mouse has clicked hand 1"); // debug
				}
			}
			else if (k == 51)
			{
				if(e.getTurnOver() == e.turnComplete)
				{
					e.setKeyPress(0);
					e.setHandClick(2);
					e.ph.cardHandler(e, e.pe, e.pa, e.p);
					// System.out.println("Mouse has clicked hand 1"); // debug
				}
			}
			else if (k == 52)
			{
				if(e.getTurnOver() == e.turnComplete)
				{
					e.setKeyPress(0);
					e.setHandClick(3);
					e.ph.cardHandler(e, e.pe, e.pa, e.p);
					// System.out.println("Mouse has clicked hand 1"); // debug
				}
			}
			else if (k == 53){
				if(e.getTurnOver() == e.turnComplete)
				{
					e.setKeyPress(0);
					e.setHandClick(4);
					e.ph.cardHandler(e, e.pe, e.pa, e.p);
					// System.out.println("Mouse has clicked hand 1"); // debug
				}
			}
			else if (k == 54)
			{
				if(e.getTurnOver() == e.turnComplete)
				{
					e.setKeyPress(0);
					e.setHandClick(5);
					e.ph.cardHandler(e, e.pe, e.pa, e.p);
					// System.out.println("Mouse has clicked hand 1"); // debug
				}
			}
			else if (k == 55)
			{
				if(e.getTurnOver() == e.turnComplete)
				{
					e.setKeyPress(0);
					e.setHandClick(6);
					e.ph.cardHandler(e, e.pe, e.pa, e.p);
					// System.out.println("Mouse has clicked hand 1"); // debug
				}
			}
			else {
				e.setKeyPress(0);
			}
				
			mc.clicked = false;
	}
	
	public void mt(int x, int y, Encounter e, MainClass mc){
		mc.clicked = false;
		//change turn
		System.out.println(e.getKeyPress());
			if (x >= 680 && x <= 744)
			{
				if (y >= 290 && y <= 311)
				{
					e.changeTurnOver(e.nextTurn);
				}
			}
			else if(e.getKeyPress() == 10)
			{
				e.changeTurnOver(e.nextTurn);
				e.setKeyPress(0);
			}
			mc.clicked = false;
	}
	
	public void wc(MainClass mc, Encounter e){
		
		int x = mc.getXPos();
		int y = mc.getYPos();
		int k = e.getKeyPress();
		//System.out.println(k);
			
			if (x >= 300 && x <= 450){
				if (y >= 40 && y <= 140){
					e.win = false;
					mc.getPlayer().addXP(e.m.calculateXP());
					mc.getPlayer().addGold(e.m.getGold());
					mc.getPlayer().setCurrentHP(e.p.getCurrentHP());
					mc.setScreen("Map");
					 //System.out.println(e.p.getCurrentXP());
				}
			}
			else if(k == 10)
			{
				e.win = false;
				e.setKeyPress(0);
				mc.getPlayer().addXP(e.m.calculateXP());
				mc.getPlayer().addGold(e.m.getGold());
				mc.getPlayer().setCurrentHP(e.p.getCurrentHP());
				mc.setScreen("Map");
				 //System.out.println(e.p.getCurrentXP());
			}
		}
	
}
