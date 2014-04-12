package MainFiles;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventListener;

import javax.swing.JComponent;

public class ImageShowingComponent extends JComponent implements EventListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// The image to display
	  private Image img;

	  // The MouseListener that handles the click, etc.
	  private MouseListener listener = new MouseAdapter(){
	    public void mouseClicked(MouseEvent e) {
	      // Do what should be done when the image is clicked.
	    }
	  }

	  // Instantiate the panel and perform initialization
	  ImageShowingComponent() {
	    addMouseListener(listener);
	    //img = ... // Load the image.
	  }

	  public void paintComponent(Graphics g) {
	    g.drawImage(img, 0, 0, null);
	  }

	  // This method override will tell the LayoutManager how large this component
	  // should be. We'll want to make this component the same size as the `img`.
	  public Dimension getPreferredSize() {
	    return new Dimension(img.getWidth(null), img.getHeight());
	  }

}
