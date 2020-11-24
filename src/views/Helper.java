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
        "Unit Converter",
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
        "About",
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
      "Unit Converter\nConversor de Unidades\n\n-------------------------------\n\nThis program was written to be a simple educational project that shows how to use some resources of Graphical User Interface (Swing) from Java language and some software engineering techniques. The aim of the program is performing the conversion between two measure units.\n\nAll teh action is placed int the background panel of the main screen. The user interacts woth this screen most of time.\n\nThe menu options are very straight:\n* From the 'File' menu, one can choose to finish the program;\n* From the 'Help' menu, one can choose see standard texts: 'Help', 'Disclaimer' and 'About'\n\nEste programa foi escrito para ser um projeto educacional simples que mostra como usar alguns recursos da Interface Gráfica do Usuário (Swing) da linguagem Java e algumas técnicas de engenharia de software. O objetivo do programa é realizar a conversão entre duas unidades de medida.\n\nToda a ação é colocada no painel de fundo da tela principal. O usuário interage com esta tela na maioria das vezes.\n\nAs opções do menu são muito simples:\n* No menu 'Arquivo', pode-se optar por finalizar o programa;\n* No menu 'Ajuda', pode-se escolher ver os textos padrão: 'Ajuda', 'Aviso Legal' e 'Sobre'"
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
    JButton button = new JButton("Close");
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
    frame.setTitle("Unit Converter");
    frame.pack();
    frame.setVisible(true);
    frame.setLocation(
      screenSize.width / 2 - frame.getSize().width / 2,
      screenSize.height / 2 - frame.getSize().height / 2
    );
  }
}
