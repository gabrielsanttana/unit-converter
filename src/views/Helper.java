package views;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.border.TitledBorder;
import java.awt.Cursor;
import javax.swing.UIManager;


public class Helper extends JPanel {

	//private BufferedImage image;
	
	public Helper() {
		//try {                
	          //image = ImageIO.read(new File("..\\resources\\unicamp-logo.png"));
	       //} catch (IOException ex) { 
	            // handle exception..
	    	  //System.out.println(ex);
	    	   //return;
	       //}
		setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(366, 197, 89, 23);
		add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Info", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(260, 11, 555, 186);
		panel.setLayout(null);
		add(panel);
		
		//JLabel picLabel = new JLabel(new ImageIcon(image));
		//picLabel.setBounds(23, 182, 227, -150);
		//add(picLabel);

		
		JTextArea helpInfo = new JTextArea();
		helpInfo.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		helpInfo.setBackground(Color.WHITE);
		helpInfo.setEditable(false);
		helpInfo.setAutoscrolls(true);
		helpInfo.setBounds(6, 16, 543, 163);
		helpInfo.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. In id leo metus. Quisque est enim, porttitor id dolor ac, lobortis aliquet tortor. Proin eu leo blandit, efficitur lacus a, viverra metus. Maecenas euismod maximus justo non vulputate. Vivamus ac lacinia velit. Mauris lobortis placerat turpis fermentum faucibus. Nullam aliquet quam ante, eu dignissim tellus iaculis nec. Nulla interdum risus eget ipsum aliquam mattis. Mauris suscipit accumsan nisl, nec dictum augue suscipit id. Maecenas ac diam ornare, malesuada diam vel, posuere purus. Lorem ipsum dolor sit amet, consectetur adipiscing elit.Lorem ipsum dolor sit amet, consectetur adipiscing elit. In id leo metus. Quisque est enim, porttitor id dolor ac, lobortis aliquet tortor. Proin eu leo blandit, efficitur lacus a, viverra metus. Maecenas euismod maximus justo non vulputate. Vivamus ac lacinia velit. Mauris lobortis placerat turpis fermentum faucibus. Nullam aliquet quam ante, eu dignissim tellus iaculis nec. Nulla interdum risus eget ipsum aliquam mattis. Mauris suscipit accumsan nisl, nec dictum augue suscipit id. Maecenas ac diam ornare, malesuada diam vel, posuere purus. Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		helpInfo.setColumns(1);
		helpInfo.setLineWrap(true);
		panel.add(helpInfo);

		
		JPanel unitConverterImage = new JPanel();
		unitConverterImage.setBorder(new TitledBorder(null, "Unit Converter", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		unitConverterImage.setBounds(10, 11, 250, 186);
		add(unitConverterImage);

  }
  public static void start() {
    new Helper();
  }
}
