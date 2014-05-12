package MainFiles;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import BottomBar.BottomBar;
import Characters.Bunny;
import Characters.Monster;
import Characters.Player;
import SideBar.SideBar;

/* Credits:
 *  http://opengameart.org/ license: Public Domain
 * Textures: rubberduck, para, Duion; Buttons: Kindland; Round Animals: ryan.dansie; RPG Items: anubisky
 * RussPupp_rpg: Russpuppy; Glitch Icons: rubberduck; Potions: Buch; Medals: Kenney character sprites: icedman
 * 
 * "Part of (or All) the graphic tiles used in this program is the Public domain roguelike tileset "RLTiles". Some of the tiles have been modified by YOURNAME. You can find the original tileset at: http://rltiles.sf.net You can find Dungeon Crawl Stone Soup modified tilesets at: http://code.google.com/p/crawl-tiles/downloads/list"
 */

@SuppressWarnings("serial")
public class MainClass extends JFrame implements Runnable, KeyListener, MouseListener, WindowListener
{
	Dimension size = new Dimension(1000, 700);
	public boolean running = false;
	public boolean loadSave;
	
	private static BufferedImageLoader loader;
	
	private BufferedImage mapTiles;
	private Image background;
	private JLabel backgroundLabel;
	private JPanel backgroundPanel;
	private JPanel foregroundPanel;
	private JPanel mainPanel;
	
	private JLayeredPane thePane;
	private JDesktopPane allTheWindows;
	
	private static MapHandler mh;
	private static Player p;
	private Monster m;
	private Encounter enc;
	private static SideBar sb;
	private static BottomBar bb;
	
	private WriteXMLFile writer;
	private ReadXMLFile reader;
	
	int keys;
	private int xPos=0;
	private int yPos=0;
	public boolean clicked = false;
	private boolean movable;
	private boolean tmap;
	private boolean tenc;
	String location;
	
	private static boolean storeOpen;
	private boolean active;
	
	public  MainClass() {
		setStoreOpen(false);
		
		//setup the frame
		this.setMinimumSize(size);
		this.setMaximumSize(size);
		this.setPreferredSize(size);		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		this.setLayout(new BorderLayout(0, 0));
		this.setIgnoreRepaint(true);
		
		//create the pane and panels
		thePane = new JLayeredPane();
		thePane.setPreferredSize(size);
		this.add(thePane, BorderLayout.PAGE_START);
		
		backgroundPanel = new JPanel();
		backgroundPanel.setPreferredSize(size);
		backgroundPanel.setLayout(new BorderLayout());
		thePane.add(backgroundPanel, new Integer(0));
		backgroundPanel.setBounds(0, 0, getWidth(), getHeight());

		//backgroundPanel.add(testing);
		
		foregroundPanel = new JPanel();
		foregroundPanel.setPreferredSize(size);
		foregroundPanel.setLayout(new GridBagLayout());
		thePane.add(foregroundPanel, new Integer(1));
		foregroundPanel.setBounds(0, 0, getWidth(), getHeight());
		foregroundPanel.setOpaque(false);
		//foregroundPanel.add(testing);
		
		//add the Desktop layout to handle inventory, shops and messages.
		allTheWindows = new JDesktopPane();
		allTheWindows.setPreferredSize(new Dimension(800, 600));
		allTheWindows.setBounds(0, 0, 800, 600);
		allTheWindows.setOpaque(false);
		thePane.add(allTheWindows, new Integer(2));
		
		
		//set up the main panel
		mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(800, 600));
		mainPanel.setLayout(new BorderLayout());
		
		//load images
		loader = new BufferedImageLoader();
		mapTiles = loader.loadImage("/Resources/tiles.png");
		
		//take care of window background
		background = loader.loadImage("/Resources/diffuse.png");
		ImageIcon icon = new ImageIcon(background);
		backgroundLabel = new JLabel(icon);
		backgroundPanel.add(backgroundLabel);

		
		//check for saved game, if none found, create new player
		writer = new WriteXMLFile();
		reader = new ReadXMLFile();
		//loadSave= sg.loadGame(this);

		p = new Player(this);
		
		//start main classes
		
		mh = new MapHandler(this);
		m = new Bunny();
		m.createMonster(this);
		sb = new SideBar(this);
		bb = new BottomBar(this);
		enc = new Encounter(this, mh, p, m);
		
		GridBagConstraints c0 = new GridBagConstraints();
		c0.gridx = 0;
		c0.gridy = 0;
		c0.gridwidth = 1;
		c0.gridheight = 1;
		c0.weightx =1;
		c0.weighty = 1;
		//c0.fill = GridBagConstraints.BOTH;
		c0.anchor = GridBagConstraints.FIRST_LINE_START;
		c0.insets = new Insets(0, 0, 0, 0);
		foregroundPanel.add(mainPanel, c0);
		mainPanel.add(mh);

		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx = GridBagConstraints.RELATIVE;
		c1.gridy = 0;
		c1.gridwidth = 1;
		c1.gridheight = 1;
		c1.weightx =1;
		c1.weighty = 1;
		//c1.fill = GridBagConstraints.BOTH;
		c1.anchor = GridBagConstraints.FIRST_LINE_START;
		c1.insets = new Insets(0, 0, 0, 0);
		foregroundPanel.add(sb, c1);
		
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx = 0;
		c2.gridy = 1;
		c2.gridwidth = 2;
		c2.gridheight = 1;
		c2.weightx =1;
		c2.weighty = 1;
		//c2.fill = GridBagConstraints.BOTH;
		c2.anchor = GridBagConstraints.PAGE_END;
		foregroundPanel.add(bb, c2);
		
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addWindowListener(this);
		location = "Map";
		movable = true;
		
		//myFont1 = new Font("Serif", Font.BOLD, 24);
		//myFont2 = new Font("Serif", Font.BOLD, 12);
		
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		//reader.loadGame(this);
	}
	
	public static void main( final String[] args){
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainClass().start();
            }
        });
	}
	
	public void start(){
		running = true;
		new Thread(this).start();
	}
	/*
	public void paint(){
		BufferStrategy bs = getBufferStrategy();
		if (bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		//g.setColor(Color.WHITE);
		//g.fillRect(0, 0, 1015, 815);
		//mh.repaint();
    	//bb.paint(g,  this);
    	sb.repaint();
    	/*
		if (location == "Map")
    	{*/
    		//mh.repaint();
    	/*}
		else if (location == "Encounter"){
    		enc.paint(g, this, p, m);
    	}
    	*//*
    	g.dispose();
    	bs.show();
	}
*/
 
	public void run() {
		// TODO Auto-generated method stub
		//thread information
		while(true)
		{
			//map handler
			if(location == "Map"){
				if(!tmap){
					mainPanel.removeAll();
					mainPanel.add(mh);
					mainPanel.revalidate();
					tmap = true;
					tenc = false;
				}
				mh.update(this);
			}
			//encounter handler
			else if(location == "Encounter"){
				if(!tenc){
					mainPanel.removeAll();
					mainPanel.add(enc);
					mainPanel.revalidate();
					tenc = true;
					tmap = false;
					//System.out.println("entered encounter");
				}
				enc.update(this, mh, m, p);
			}
			
			sb.update(this);
			bb.update(this);
			
			if (allTheWindows.getSelectedFrame() == null && isActive()){
				//System.out.println(allTheWindows.getSelectedFrame());
				this.requestFocus();
			}
			
			//System.out.println(this.isStoreOpen());
			
			//System.out.println(this.isFocusOwner());
			
			//main thread
			this.repaint();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		int curKeys = e.getKeyCode();
		if (location == "Map" && movable == true)
		{
			p.setKeyPress(curKeys);
		}
		if (location == "Encounter" && movable == true){
			enc.setKeyPress(curKeys);
			clicked = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		setXPos(e.getX());
		setYPos(e.getY());
		clicked = true;
		//System.out.println("clicked");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public int getKeys()
	{
		return keys;
	}
	
	public String getScreen(){
		return location;
	}
	
	public void setScreen(String s){
		location = s;
	}
	
	public void setMovable(boolean b){
		this.movable = b;
	}
	
	public int getXPos(){
		return this.xPos;
	}
	
	public void setXPos(int i){
		this.xPos = i;
	}
	
	public int getYPos(){
		return this.yPos;
	}
	
	public void setYPos(int i){
		this.yPos = i;
	}
	
	public static Player getPlayer(){
		return p;
	}
	
	public MapHandler getMapHandler(){
		return mh;
	}
	
	public Encounter getEncounter(){
		return enc;
	}
	
	public void setEncounter(Encounter e){
		this.enc = e;
	}
	
	public Monster getMonster(){
		return m;
	}
	
	public void setMonster(Monster monster){
		this.m = monster;
	}
	
	public BufferedImageLoader getBIL(){
		return loader;
	}
	
	public BufferedImage getMapTiles(){
		return mapTiles;
	}
	
	public WriteXMLFile getWriter(){
		return writer;
	}
	
	public ReadXMLFile getReader(){
		return reader;
	}
	
	public BottomBar getBottomBar(){
		return bb;
	}
	
	public JDesktopPane getATW(){
		return allTheWindows;
	}

	public static boolean isStoreOpen() {
		return storeOpen;
	}

	public void setStoreOpen(boolean storeOpen) {
		MainClass.storeOpen = storeOpen;
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		this.setActive(true);
		//System.out.println("activated");
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		this.setActive(false);
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}