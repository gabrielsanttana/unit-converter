package views;

import controllers.Controller;
import converters.AbstractConverter;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import models.ClassSorter;
import models.MeasureType;
import utils.MultiMap;
import utils.lang.Lang;

/**
 * A class that renders the program main view, which receives the unit
 * types and prints out the conversion result
 */
public class Converter {

  private JFrame frame;
  private JMenuBar menuBar;
  private JMenu fileMenu;
  private JMenu helpMenu;
  private JMenuItem menuCloseItem;
  private JMenuItem menuHelpItem;
  private JMenuItem portugueseLanguageItem;
  private JMenuItem englishLanguageItem;
  private JPanel panel;
  private JLabel fromLabel;
  private JLabel toLabel;
  private JTextField fromInput;
  private JTextField toInput;
  private JComboBox<String> fromSelect;
  private JComboBox<String> toSelect;
  private Controller controller = new Controller();

  private MultiMap<MeasureType, Class<AbstractConverter>> sortedClasses;

  /**
   * Constructs the converter view
   */
  public Converter() {
    fromLabel = new JLabel(Lang.get(Lang.convertFrom));
    toLabel = new JLabel(Lang.get(Lang.to));

    fromInput = new JTextField();
    toInput = new JTextField();

    fromSelect = new JComboBox<>();
    toSelect = new JComboBox<>();

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

    menuCloseItem = new JMenuItem(Lang.get(Lang.close));
    menuHelpItem = new JMenuItem(Lang.get(Lang.help));
    portugueseLanguageItem = new JMenuItem(Lang.get(Lang.pt_br));
    englishLanguageItem = new JMenuItem(Lang.get(Lang.en_us));

    fileMenu = new JMenu(Lang.get(Lang.file));
    helpMenu = new JMenu(Lang.get(Lang.help));

    fileMenu.add(menuCloseItem);
    helpMenu.add(menuHelpItem);

    menuBar = new JMenuBar();
    menuBar.setBounds(0, 0, 658, 22);
    menuBar.add(fileMenu);
    menuBar.add(helpMenu);

    menuCloseItem.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          System.exit(0);
        }
      }
    );

    englishLanguageItem.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          //Set program language
          //Lang.setLanguage(ELang.EN_US);
          //SwingUtilities.updateComponentTreeUI(frame);
        }
      }
    );

    portugueseLanguageItem.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          //Set program language
          //Lang.setLanguage(ELang.PT_BR);
          //SwingUtilities.updateComponentTreeUI(frame);
        }
      }
    );

    menuHelpItem.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          Helper helper = new Helper();
          helper.setVisible(true);
        }
      }
    );

    panel = new JPanel();
    panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
    panel.setLayout(new GridLayout(0, 1));
    panel.add(menuBar);
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
    frame.setTitle(Lang.get(Lang.unit_converter));
    frame.pack();
    frame.setVisible(true);
    frame.setLocation(
      screenSize.width / 2 - frame.getSize().width / 2,
      screenSize.height / 2 - frame.getSize().height / 2
    );
  }

  private String getConversionResult() {
    Controller controller = new Controller();

    String inputValue = fromInput.getText();
    if (inputValue.equals("")) {
      return "";
    }

    if (inputValue.toLowerCase().contains("e")) {
      return Lang.get(Lang.insert_valid_input);
    }

    double fromValue = 0.0;
    try {
      fromValue = Double.parseDouble(fromInput.getText());
    } catch (NumberFormatException e) {
      return Lang.get(Lang.insert_valid_input);
    }

    AbstractConverter fromConverter = null;
    AbstractConverter toConverter = null;
    try {
      fromConverter = getConverterName(fromSelect.getSelectedItem().toString());
      toConverter = getConverterName(toSelect.getSelectedItem().toString());
    } catch (Exception e) {
      return Lang.get(Lang.converter_not_found);
    }

    if (fromConverter != null && toConverter != null) {
      return controller.convert(fromConverter, toConverter, fromValue);
    }

    return Lang.get(Lang.conversion_failed);
  }

  /**
   * Sets the options for the from unit type
   */
  private void setFromComboBox() {
    sortedClasses = controller.getClassesOrderedByUnitType();

    for (MeasureType measureType : sortedClasses.getKeySet()) {
      for (Class<AbstractConverter> converters : sortedClasses.get(
        measureType
      )) {
        fromSelect.addItem(
          measureType.getType() +
          ": " +
          converters
            .getName()
            .replace("converters.", "")
            .replace("Converter", "")
        );
      }
    }
  }

  /**
   * Sets the options for the to unit type
   */
  private void setToComboBox() {
    toSelect.removeAllItems();

    String selectedType = fromSelect.getSelectedItem().toString().split(":")[0];

    sortedClasses = controller.getClassesOrderedByUnitType();

    for (MeasureType measureType : sortedClasses.getKeySet()) {
      for (Class<AbstractConverter> converters : sortedClasses.get(
        measureType
      )) {
        String type = measureType + "";
        if (type.toUpperCase().equals(selectedType.toUpperCase())) {
          toSelect.addItem(
            measureType.getType() +
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

  /**
   * Prints out the conversion result for the user
   */
  private void printConversionResult() {
    String result = getConversionResult();

    toInput.setText(result);
  }

  /**
   * Gets the converter class name to be instanciated
   * @param name the name of the converter class
   * @return the converter class name ready to be instanciated
   * @throws Exception
   */
  private AbstractConverter getConverterName(String name) throws Exception {
    String[] splittedValues = name.replaceAll(" +", "").trim().split(":");
    String className = splittedValues[1];

    List<Class<AbstractConverter>> converterValues = new ArrayList<>();
    for (Collection<Class<AbstractConverter>> absConverter : sortedClasses.values()) {
      for (Class<AbstractConverter> item : absConverter) {
        converterValues.add(item);
      }
    }

    for (Class<AbstractConverter> absConverter : converterValues) {
      if (absConverter.getCanonicalName().contains(className)) {
        return absConverter.getDeclaredConstructor().newInstance();
      }
    }

    return null;
  }
}
