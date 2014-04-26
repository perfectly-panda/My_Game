package MainFiles;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class ImageShowingComponent extends JPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// The image to display
	  private Image img;
	  private boolean iClick;

	  // Instantiate the panel and perform initialization
	  protected ImageShowingComponent() {
	    //img = ... // Load the image.
		  this.addMouseListener(this);
	  }

	  public void paintComponent(Graphics g) {
		  super.paintComponent(g);
	    g.drawImage(img, 0, 0, null);
	  }

	  // This method override will tell the LayoutManager how large this component
	  // should be. We'll want to make this component the same size as the `img`.
	  public Dimension getPreferredSize() {
	    return new Dimension(img.getWidth(null), img.getHeight(null));
	  }
	  
	  public Image getImage(){
			return img;
		}
		
		public void setImage(Image i){
			img = i;
		}
		  
		public boolean getClick(){
			return iClick;
		}
		
		public void setClick(boolean b){
			iClick = b;
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			//iClick = true;
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			iClick = true;
			//System.out.println(this);
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			iClick = false;
			
		}

}
