package Inventory;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import Items.Item;
import MainFiles.MainClass;

public class StoreInventory extends Inventory{
	
	private MainInvFrame mainStoreFrame;
	private MainClass mc;

	public StoreInventory(){
		
	}
	
	public StoreInventory(int i, MainClass main){
		this.setSlots(new Item[i]);
		mc = main;
		//System.out.println("inventory constructor");
		this.emptyInventory();
		//mainStoreFrame = new MainInvFrame();
	}
	
	public MainInvFrame getMainFrame() {
		return mainStoreFrame;
	}

	public void setMainFrame(MainInvFrame mainFrame) {
		this.mainStoreFrame = mainFrame;
	}
	
	public void turnOnFrame(){
		//System.out.println("we are getting this far");
		mainStoreFrame = new MainInvFrame();
	}
	
	public void reloadInventory(){
		this.mainStoreFrame.onLoad();
	}
	

	@SuppressWarnings("serial")
	public class MainInvFrame extends JInternalFrame{
		
		JTabbedPane mainInvTabs;
		JScrollPane mainBag;
		JPanel mainBagPanel;
		
		MainInvFrame(){
			super("Store", false, true, false, false);
			//Container c1 = this.getContentPane();
			mainInvTabs = new JTabbedPane();
			this.add(mainInvTabs);
			
			mainBagPanel = new JPanel();
			setupFrame(mainBagPanel);
			mainBagPanel.setVisible(true);
			
			mainBag= new JScrollPane(mainBagPanel);
			mainBag.setPreferredSize(new Dimension(302,200));
			mainBag.setVisible(true);
			mainInvTabs.addTab("General", mainBag);
			
			mc.setStoreOpen(true);
			
			this.setBounds(320, 10, 302, 200);
			this.setName("storeMainInventory");
			mc.getATW().add(this);
			this.setVisible(true);
			
			//System.out.println(this.getName());
		}
		
		private void setupFrame(JPanel thisPanel){
			thisPanel.setLayout(new GridLayout(0, 4, 4, 4));
			for (int i = 0; i < getInventorySize(); i++){
				thisPanel.add(getInventorySlot(i).getInvClass());
				//System.out.println(i);
			}
		}
		
		private void onLoad(){
			mainBagPanel.removeAll();
			for (int i = 0; i < getInventorySize(); i++){
				mainBagPanel.add(getInventorySlot(i).getInvClass());
			}
			mainBagPanel.revalidate();
		}	
	}
}
