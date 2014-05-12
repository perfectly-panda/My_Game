package MainFiles;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import Characters.Player;
 
public class WriteXMLFile {
 
	
	public WriteXMLFile() {}
		
	public void saveGame(MainClass mc){
 
	  try {
 
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("gameSave");
		doc.appendChild(rootElement);

		// create Player
		Element player = doc.createElement("Player");
		rootElement.appendChild(player);
		
		//add stats
		Element totalHP = doc.createElement("Total_HP");
		totalHP.appendChild(doc.createTextNode(Integer.toString(MainClass.getPlayer().getTotalHP())));
		player.appendChild(totalHP);
		
		Element currentHP = doc.createElement("Current_HP");
		currentHP.appendChild(doc.createTextNode(Integer.toString(MainClass.getPlayer().getCurrentHP())));
		player.appendChild(currentHP);
		
		Element attack = doc.createElement("Attack");
		attack.appendChild(doc.createTextNode(Integer.toString(MainClass.getPlayer().getAttack())));
		player.appendChild(attack);
		
		Element defence = doc.createElement("Defence");
		defence.appendChild(doc.createTextNode(Integer.toString(MainClass.getPlayer().getDefence())));
		player.appendChild(defence);
		
		Element cardsPerTurn = doc.createElement("Cards_per_Turn");
		cardsPerTurn.appendChild(doc.createTextNode(Integer.toString(MainClass.getPlayer().getCardsPerTurn())));
		player.appendChild(cardsPerTurn);

		Element level = doc.createElement("Level");
		level.appendChild(doc.createTextNode(Integer.toString(MainClass.getPlayer().getLevel())));
		player.appendChild(level);
		
		Element gold = doc.createElement("Gold");
		gold.appendChild(doc.createTextNode(Integer.toString(MainClass.getPlayer().getCurrentGold())));
		player.appendChild(gold);
		
		/*
		 * 
		 */
		
		// add location
		Element location = doc.createElement("Location");
		rootElement.appendChild(location);
				
		Element playerX = doc.createElement("PlayerX");
		playerX.appendChild(doc.createTextNode(Integer.toString(MainClass.getPlayer().getCurTileX())));
		location.appendChild(playerX);
		
		Element playerY = doc.createElement("PlayerY");
		playerY.appendChild(doc.createTextNode(Integer.toString(MainClass.getPlayer().getCurTileY())));
		location.appendChild(playerY);
		
		Element currentMap = doc.createElement("CurrentMap");
		currentMap.appendChild(doc.createTextNode(Integer.toString(mc.getMapHandler().getCurMap())));
		location.appendChild(currentMap);
		
		// add inventory
		Element inventory = doc.createElement("Inventory");
		rootElement.appendChild(inventory);
		
		for (int i = 0; i < Player.getInv().getInventorySize(); i++){
			Element item = doc.createElement("item");
			item.appendChild(doc.createTextNode(Player.getInv().getInventorySlotName(i)));
			inventory.appendChild(item);
		}
		

		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("c:\\GameSaves\\file.xml"));
 
		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);
 
		transformer.transform(source, result);
 
		System.out.println("File saved!");
 
	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
	}
}