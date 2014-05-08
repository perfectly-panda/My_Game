package MainFiles;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import Items.Item;

import java.io.File;
import java.lang.reflect.Constructor;
 
public class ReadXMLFile {
	
	public ReadXMLFile(){}
 
	public void loadGame(MainClass mc) {
 
    try {
 
	File fXmlFile = new File("c://gameSaves/file.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
 
	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();
 
	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
 
	NodeList nList = doc.getElementsByTagName("Player");
 
	System.out.println("----------------------------");
 
	for (int temp = 0; temp < nList.getLength(); temp++) {
 
		Node nNode = nList.item(temp);
 
		System.out.println("\nCurrent Element :" + nNode.getNodeName());
 
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
 
			Element eElement = (Element) nNode;
 
			mc.getPlayer().setTotalHP(Integer.parseInt(eElement.getElementsByTagName("Total_HP").item(0).getTextContent()));
			mc.getPlayer().setCurrentHP(Integer.parseInt(eElement.getElementsByTagName("Current_HP").item(0).getTextContent()));
			mc.getPlayer().setAttack(Integer.parseInt(eElement.getElementsByTagName("Attack").item(0).getTextContent()));
			mc.getPlayer().setDefence(Integer.parseInt(eElement.getElementsByTagName("Defence").item(0).getTextContent()));
			mc.getPlayer().setCardsPerTurn(Integer.parseInt(eElement.getElementsByTagName("Cards_per_Turn").item(0).getTextContent()));
			mc.getPlayer().setLevel(Integer.parseInt(eElement.getElementsByTagName("Level").item(0).getTextContent()));
			mc.getPlayer().setCurrentGold(Integer.parseInt(eElement.getElementsByTagName("Gold").item(0).getTextContent()));
		}
	}
	
	NodeList nList2 = doc.getElementsByTagName("Location");
	 
	System.out.println("----------------------------");
 
	for (int temp = 0; temp < nList2.getLength(); temp++) {
		 
		Node nNode = nList2.item(temp);
 
		System.out.println("\nCurrent Element :" + nNode.getNodeName());
 
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
 
			Element eElement = (Element) nNode;
 
			for (int i = 0; i < mc.getMapHandler().getMaxMon(); i++){
				if (mc.getMapHandler().getMonster(i) != null){
					mc.getMapHandler().getMonster(i).setAlive(false);
					mc.getMapHandler().maps.get(mc.getMapHandler().getCurMap()).getTile(mc.getMapHandler().getMonster(i).getCurTileX(), mc.getMapHandler().getMonster(i).getCurTileY()).clearChar1();
				}
			}
			
			mc.getMapHandler().setCurMap(Integer.parseInt(eElement.getElementsByTagName("CurrentMap").item(0).getTextContent()), mc);
			mc.getMapHandler().maps.get(mc.getMapHandler().getCurMap()).theTile[Integer.parseInt(eElement.getElementsByTagName("PlayerX").item(0).getTextContent())][Integer.parseInt(eElement.getElementsByTagName("PlayerY").item(0).getTextContent())].setChar1(mc.getPlayer());	
			
			mc.getMapHandler().maps.get(mc.getMapHandler().getCurMap()).onLoad(mc.getMapHandler(), mc);
			mc.getPlayer().setCurTileX(Integer.parseInt(eElement.getElementsByTagName("PlayerX").item(0).getTextContent()));
			mc.getPlayer().setCurTileY(Integer.parseInt(eElement.getElementsByTagName("PlayerY").item(0).getTextContent()));
			mc.getMapHandler().updateCamera(mc.getPlayer());
			
			mc.getMapHandler().revalidate();
		}
	}
	
	NodeList nList3 = doc.getElementsByTagName("Inventory");
	 
	System.out.println("----------------------------");
 
	for (int temp = 0; temp < nList3.getLength(); temp++) {
		 
		Node nNode = nList3.item(temp);
 
		System.out.println("\nCurrent Element :" + nNode.getNodeName());
		
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			 
			Element eElement = (Element) nNode;

			if (eElement.getElementsByTagName("item").item(temp).getTextContent() != "Empty Spot"){
				Class<?> clazz = Class.forName(eElement.getElementsByTagName("item").item(temp).getTextContent());
				Constructor<?> constructor = clazz.getConstructor();
				Object instance = constructor.newInstance();
				
				mc.getPlayer().getInv().setInventorySlot((Item) instance, temp);
			}
		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
  }
 
}
