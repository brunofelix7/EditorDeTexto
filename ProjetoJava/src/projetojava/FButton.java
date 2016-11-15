package projetojava;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**Classe de botões formatados
 *@author Emerson Lemos 
 */
public class FButton extends JButton{
	
	private Icon fIcon;
	
	public FButton(String iconNormal, String iconHover, String iconPress) throws IOException{
		super();
		
		this.setIcon(new ImageIcon(iconNormal));
		this.setRolloverIcon(new ImageIcon(iconHover));
		this.setPressedIcon(new ImageIcon(iconPress));
		
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setPreferredSize(new Dimension(50, 50));
		
		this.setBorder(new EmptyBorder(2, 2, 2, 2));
	}
	
}