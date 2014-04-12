package Cards;
import java.awt.Image;


public class Deck {
	

	public Deck(){}

	
public Cards[] createNewDeck()
{
	//create a new deck of cards
	 Cards[] d = new Cards[60];
	
	//create the cards themselves
	for (int a=0; a<=19; a++)
	{
	d[a] = new Punch();
	d[a+20] = new Kick();
	d[a+40] = new Block();
	}
	//System.out.println(d.length);
	return d;
}

public Image getImage(Cards d[], int c)
{
	Image cardImage;
	cardImage = d[c].getCardImage();
	
	return cardImage;
}

public String getName(Cards d[], int c)
{
	String cardName;
	cardName = d[c].getCardName();
	
	return cardName;
}

public int getEnergy (Cards d[], int c)
{
	int cardValue;
	cardValue = d[c].getCardValue();
	return cardValue;
}

public int getCost (Cards d[], int c)
{
	int cardValue;
	cardValue = d[c].getCardCost();
	return cardValue;
}

public int getDamage (Cards d[], int c)
{
	int cardValue;
	cardValue = d[c].getCardDamage();
	return cardValue;
}

public void updateImage (Cards c[], int a, Image i)
{
	c[a].cardImage=i;
}
	
}

