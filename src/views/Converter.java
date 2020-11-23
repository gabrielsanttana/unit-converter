package views;

import converters.AbstractConverter;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import models.ClassSorter;
import models.MeasureType;
import utils.MultiMap;

/**
 * A class that renders the program main view, the one that receives the unit
 * types and prints out the conversion result
 */
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
  private MeasureType conversionType;

  public Converter() {
    fromLabel = new JLabel("Convert from");
    toLabel = new JLabel("to");

    fromInput = new JTextField();
    toInput = new JTextField();

    fromSelect = new JComboBox();
    toSelect = new JComboBox();

    toInput.setEditable(false);

    setFromComboBox();

    fromInput
      .getDocument()
      .addDocumentListener(
        new DocumentListener() {
          @Override
          public void insertUpdate(DocumentEvent event) {
            printConversionResult();
          }

          @Override
          public void removeUpdate(DocumentEvent event) {
            printConversionResult();
          }

          @Override
          public void changedUpdate(DocumentEvent event) {
            printConversionResult();
          }
        }
      );

    fromSelect.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
          setToComboBox();
        }
      }
    );

    toSelect.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
          printConversionResult();
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

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    frame = new JFrame();
    frame.setIconImage(
      Toolkit
        .getDefaultToolkit()
        .getImage(Converter.class.getResource("/resources/ruler.png"))
    );
    frame.add(panel, BorderLayout.CENTER);
    frame.setPreferredSize(new Dimension(1000, 500));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Unit Converter");
    frame.pack();
    frame.setVisible(true);
    frame.setLocation(
      screenSize.width / 2 - frame.getSize().width / 2,
      screenSize.height / 2 - frame.getSize().height / 2
    );
  }

  private String getConversionResult() {
    return "100";
  }

  public void setFromComboBox() {
    ClassSorter classSorter = new ClassSorter();

    MultiMap<MeasureType, Class<AbstractConverter>> sortedClasses = classSorter.getClassesOrderedByUnitType();

    for (MeasureType measureType : sortedClasses.getKeySet()) {
      for (Class<AbstractConverter> converters : sortedClasses.get(
        measureType
      )) {
        fromSelect.addItem(
          measureType +
          ": " +
          converters
            .getName()
            .replace("converters.", "")
            .replace("Converter", "")
        );
      }
    }
  }

  public void setToComboBox() {
    // Clear ComboBox
    toSelect.removeAllItems();

    // Add in ComboBox all item with type equals selected type
    String selectedType = fromSelect.getSelectedItem().toString().split(":")[0];

    ClassSorter classSorter = new ClassSorter();

    MultiMap<MeasureType, Class<AbstractConverter>> sortedClasses = classSorter.getClassesOrderedByUnitType();

    for (MeasureType measureType : sortedClasses.getKeySet()) {
      for (Class<AbstractConverter> converters : sortedClasses.get(
        measureType
      )) {
        String type = measureType + "";
        if (type.equals(selectedType)) {
          toSelect.addItem(
            measureType +
            ": " +
            converters
              .getName()
              .replace("converters.", "")
              .replace("Converter", "")
          );
        }
      }
    }
  }

  public void printConversionResult() {
    String result = getConversionResult();

    toInput.setText(result);
  }
}
