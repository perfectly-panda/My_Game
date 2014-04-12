package Cards;

public class Blank extends Cards{

	public void blank(){
		setCardName("Blank");
		setCardValue(0);
		setCardCost(0);
		setCardDamage(0);
		setCardImage("/Resources/blankCard.jpg");
	}
}
