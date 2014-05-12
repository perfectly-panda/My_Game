package Inventory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import Inventory.Bags.Bags;
import Items.Item;
import MainFiles.MainClass;

public class PlayerMainInventory extends Inventory{
	
	private Bags[] playerBags;
	private MainInvFrame mainPlayerFrame;
	public MainClass mc;
	
	public PlayerMainInventory(MainClass main){
		this.setSlots(new Item[24]);
		this.setPlayerBags(new Bags[8]);
		this.emptyInventory();
		//mainPlayerFrame = new MainInvFrame();
		mc = main;
	}

	public Bags[] getPlayerBags() {
		return playerBags;
	}

	public void setPlayerBags(Bags[] playerBags) {
		this.playerBags = playerBags;
	}
	
	public MainInvFrame getMainFrame() {
		return mainPlayerFrame;
	}

	public void setMainFrame(MainInvFrame mainFrame) {
		this.mainPlayerFrame = mainFrame;
	}
	
	public void turnOnFrame(){
		mainPlayerFrame = new MainInvFrame();
	}
	
	public void reloadInventory(){
		this.mainPlayerFrame.onLoad();
	}
	

	@SuppressWarnings("serial")
	public class MainInvFrame extends JInternalFrame implements InternalFrameListener{
		
		JTabbedPane mainInvTabs;
		JScrollPane mainBag;
		JPanel mainBagPanel;
		
		MainInvFrame(){
			super("Inventory", false, true, false, false);
			//Container c1 = this.getContentPane();
			mainInvTabs = new JTabbedPane();
			this.add(mainInvTabs);
			
			mainBagPanel = new JPanel();
			setupFrame(mainBagPanel);
			mainBagPanel.setVisible(true);
			
			mainBag= new JScrollPane(mainBagPanel);
			mainBag.setPreferredSize(new Dimension(302,200));
			mainBag.setBackground(Color.red);
			mainBag.setVisible(true);
			mainInvTabs.addTab("Main", mainBag);
			
			this.setBounds(10, 10, 302, 200);
			this.setName("playerMainInventory");
			//this.setDefaultCloseOperation(HIDE_ON_CLOSE);
			mc.getATW().add(this);
			this.setVisible(true);
			
			//System.out.println(this.getName());
		}
		
		private void setupFrame(JPanel thisPanel){
			thisPanel.setLayout(new GridLayout(0, 4, 4, 4));
			for (int i = 0; i < getInventorySize(); i++){
				thisPanel.add(getInventorySlot(i).getInvClass());
			}
		}
		
		private void onLoad(){
			mainBagPanel.removeAll();
			for (int i = 0; i < getInventorySize(); i++){
				mainBagPanel.add(getInventorySlot(i).getInvClass());
			}
			mainBagPanel.revalidate();
		}

		@Override
		public void internalFrameActivated(InternalFrameEvent e) {
			System.out.println("activated");
			
		}

		@Override
		public void internalFrameClosed(InternalFrameEvent e) {
			System.out.println("closed");
			try {
				this.setSelected(false);
			} catch (PropertyVetoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}

		@Override
		public void internalFrameClosing(InternalFrameEvent e) {
			System.out.println("closing");
			
		}

		@Override
		public void internalFrameDeactivated(InternalFrameEvent e) {
			System.out.println("deactivated");
			
		}

		@Override
		public void internalFrameDeiconified(InternalFrameEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void internalFrameIconified(InternalFrameEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void internalFrameOpened(InternalFrameEvent e) {
			// TODO Auto-generated method stub
			
		}
			
	}

}
