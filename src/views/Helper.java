package views;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.Cursor;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Helper extends JPanel {

	private BufferedImage image;
	private JFrame frame;
	private JPanel panel;

	public Helper() {
		setLayout(null);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(366, 197, 89, 23);
		add(btnNewButton);

		panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Info", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(260, 11, 555, 186);
		panel.setLayout(null);

		// JLabel picLabel = new JLabel(new ImageIcon(image));
		// picLabel.setBounds(23, 182, 227, -150);
		// add(picLabel);

		JTextArea helpInfo = new JTextArea();
		helpInfo.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		helpInfo.setBackground(Color.WHITE);
		helpInfo.setEditable(false);
		helpInfo.setAutoscrolls(true);
		helpInfo.setBounds(6, 16, 543, 163);
		helpInfo.setText(
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. In id leo metus. Quisque est enim, porttitor id dolor ac, lobortis aliquet tortor. Proin eu leo blandit, efficitur lacus a, viverra metus. Maecenas euismod maximus justo non vulputate. Vivamus ac lacinia velit. Mauris lobortis placerat turpis fermentum faucibus. Nullam aliquet quam ante, eu dignissim tellus iaculis nec. Nulla interdum risus eget ipsum aliquam mattis. Mauris suscipit accumsan nisl, nec dictum augue suscipit id. Maecenas ac diam ornare, malesuada diam vel, posuere purus. Lorem ipsum dolor sit amet, consectetur adipiscing elit.Lorem ipsum dolor sit amet, consectetur adipiscing elit. In id leo metus. Quisque est enim, porttitor id dolor ac, lobortis aliquet tortor. Proin eu leo blandit, efficitur lacus a, viverra metus. Maecenas euismod maximus justo non vulputate. Vivamus ac lacinia velit. Mauris lobortis placerat turpis fermentum faucibus. Nullam aliquet quam ante, eu dignissim tellus iaculis nec. Nulla interdum risus eget ipsum aliquam mattis. Mauris suscipit accumsan nisl, nec dictum augue suscipit id. Maecenas ac diam ornare, malesuada diam vel, posuere purus. Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		helpInfo.setColumns(1);
		helpInfo.setLineWrap(true);
		// panel.add(helpInfo);

		try {
			String url = this.getClass().getResource("/resources/unicamp-logo.png").toString();
			image = ImageIO.read(new File(url));
			JLabel picLabel = new JLabel(new ImageIcon(image));
			System.out.println('1');
			panel.add(picLabel);
			System.out.println('2');
		} catch (IOException ex) {
			// handle exception...
		}

		JPanel unitConverterImage = new JPanel();
		unitConverterImage
				.setBorder(new TitledBorder(null, "Unit Converter", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		unitConverterImage.setBounds(10, 11, 250, 186);
		// panel.add(unitConverterImage);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Converter.class.getResource("/resources/ruler.png")));
		frame.add(panel, BorderLayout.CENTER);
		frame.setPreferredSize(new Dimension(1000, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Unit Converter");
		frame.pack();
		frame.setVisible(true);
		frame.setLocation(screenSize.width / 2 - frame.getSize().width / 2,
				screenSize.height / 2 - frame.getSize().height / 2);

	}

	public static void start() {
		new Helper();
	}
}
