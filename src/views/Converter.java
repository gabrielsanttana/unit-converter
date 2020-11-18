package views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Converter {

  private JFrame frame;
  private JPanel panel;
  private JLabel fromLabel;
  private JLabel toLabel;
  private JTextField fromInput;
  private JTextField toInput;
  private JComboBox fromSelect;
  private JComboBox toSelect;
  private int count;

  public Converter() {
    frame = new JFrame();

    fromLabel = new JLabel("Convert from");
    toLabel = new JLabel("to");

    fromInput = new JTextField();
    toInput = new JTextField();

    fromSelect = new JComboBox();
    toSelect = new JComboBox();

    fromSelect.addItem("Unidade 1");
    fromSelect.addItem("Unidade 2");
    fromSelect.addItem("Unidade 3");

    toSelect.addItem("Unidade 1");
    toSelect.addItem("Unidade 2");
    toSelect.addItem("Unidade 3");

    toInput.setEditable(false);

    fromInput
      .getDocument()
      .addDocumentListener(
        new DocumentListener() {
          @Override
          public void insertUpdate(DocumentEvent event) {
            setToInputValue();
          }

          @Override
          public void removeUpdate(DocumentEvent event) {
            setToInputValue();
          }

          @Override
          public void changedUpdate(DocumentEvent event) {
            setToInputValue();
          }
        }
      );

    fromSelect.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
          setToInputValue();
        }
      }
    );

    toSelect.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
          setToInputValue();
        }
      }
    );

    panel = new JPanel();
    panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
    panel.setLayout(new GridLayout(0, 1));

    panel.add(fromLabel);
    panel.add(fromInput);
    panel.add(fromSelect);
    panel.add(toLabel);
    panel.add(toSelect);
    panel.add(toInput);

    frame.add(panel, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Converter");
    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String args[]) {
    new Converter();
  }

  public void setToInputValue() {
    count++;
    toInput.setText("Number of changes: " + count);
  }
}
