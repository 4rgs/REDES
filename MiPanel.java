package udpreceptor;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class MiPanel extends JPanel{
        @Override
	public void paint(Graphics g) {
		update(g);
	}
        @Override
        public void update(Graphics g) {

            g.drawImage(UDPReceptor.receivedImage,0,0,null);

        }
        public MiPanel(){
            super();
            this.setBackground(Color.BLACK);
        }
    
}