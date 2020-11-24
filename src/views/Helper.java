package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import utils.lang.Lang;

/**
 * A class that renders the helper view, which shows to the user the program's general information
 */
public class Helper extends JPanel {

  private BufferedImage image;
  private JFrame frame;
  private JPanel panel;

  /**
   * Constructs the helper view
   */
  public Helper() {
    setLayout(null);

    JButton btnNewButton = new JButton("New button");
    btnNewButton.setBounds(366, 197, 89, 23);
    add(btnNewButton);

    panel = new JPanel();
    panel.setForeground(Color.BLACK);
    panel.setBorder(
      new TitledBorder(
        UIManager.getBorder("TitledBorder.border"),
        Lang.get(Lang.unit_converter),
        TitledBorder.LEADING,
        TitledBorder.TOP,
        null,
        new Color(0, 0, 0)
      )
    );
    panel.setBounds(260, 11, 555, 186);
    panel.setLayout(null);

    JPanel unitConverterImage = new JPanel();
    unitConverterImage.setBounds(16 * 2, 16, 250, 350);

    JLabel picLabel = new JLabel();
    picLabel.setIcon(
      new ImageIcon(this.getClass().getResource("/resources/unicamp-logo.png"))
    );
    unitConverterImage.add(picLabel);

    panel.add(unitConverterImage);

    JPanel helpPanel = new JPanel();
    helpPanel.setBorder(
      new TitledBorder(
        null,
        Lang.get(Lang.about),
        TitledBorder.LEADING,
        TitledBorder.TOP,
        null,
        Color.BLACK
      )
    );
    helpPanel.setBounds(250 + (16 * 4), 16, 468, 400);
    helpPanel.setLayout(new GridLayout(1, 0));

    JTextArea helpInfo = new JTextArea();
    helpInfo.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    helpInfo.setBackground(Color.WHITE);
    helpInfo.setEditable(false);
    helpInfo.setAutoscrolls(true);
    helpInfo.setBounds(6, 16, 543, 163);
    helpInfo.setText(
      Lang.get(Lang.helper_text)
    );
    helpInfo.setColumns(1);
    helpInfo.setLineWrap(true);
    helpInfo.setWrapStyleWord(true);

    JScrollPane scrollView = new JScrollPane(helpInfo);
    scrollView.setVerticalScrollBarPolicy(
      JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
    );
    helpPanel.add(scrollView);
    panel.add(helpPanel);

    frame = new JFrame();
    JButton button = new JButton(Lang.get(Lang.close));
    button.setBounds((800 / 2) - 50, 400 + 24, 100, 30);
    button.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          frame.dispose();
        }
      }
    );
    panel.add(button);

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setIconImage(
      Toolkit
        .getDefaultToolkit()
        .getImage(Converter.class.getResource("/resources/ruler.png"))
    );
    frame.add(panel, BorderLayout.CENTER);
    frame.setPreferredSize(new Dimension(800, 500));
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setTitle(Lang.get(Lang.unit_converter));
    frame.pack();
    frame.setVisible(true);
    frame.setLocation(
      screenSize.width / 2 - frame.getSize().width / 2,
      screenSize.height / 2 - frame.getSize().height / 2
    );
  }
}
