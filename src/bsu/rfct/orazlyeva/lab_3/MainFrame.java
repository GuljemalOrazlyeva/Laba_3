package bsu.rfct.orazlyeva.lab_3;

package bsu.rfct.orazlyeva.Laba_3;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import javax.swing.*;

@SuppressWarnings("serial")

public class MainFrame extends JFrame {

  private static final int WIDTH = 700;
  private static final int HEIGHT = 500;

  private Double[] coefficients;

  private JFileChooser fileChooser = null;
  private JMenuItem saveToTextMenuItem;
  private JMenuItem saveToGraphicsMenuItem;
  private JMenuItem searchValueMenuItem;

  private JTextField textFieldFrom;
  private JTextField textFieldTo;
  private JTextField textFieldStep;
  private Box hBoxResult;
  private JMenuItem aboutProgramMenuItem;
  private GornerTableCellRenderer renderer = new
          GornerTableCellRenderer();
  private GornerTableModel data;
  public <e> MainFrame(Double[] coefficients) {

    super("Табулирование многочлена на отрезке по схеме Горнера");
    this.coefficients = coefficients;

    setSize(WIDTH, HEIGHT);
    Toolkit kit = Toolkit.getDefaultToolkit();

    setLocation((kit.getScreenSize().width - WIDTH) / 2,
            (kit.getScreenSize().height - HEIGHT) / 2);

    JMenuBar menuBar = new JMenuBar();

    setJMenuBar(menuBar);

    JMenu fileMenu = new JMenu("Файл");

    menuBar.add(fileMenu);

    JMenu tableMenu = new JMenu("Таблица");

    menuBar.add(tableMenu);

    JMenu helpMenu = new JMenu("Справка");
    menuBar.add(helpMenu);

    Action saveToTextAction = new AbstractAction("Сохранить в текстовый файл") {
      public void actionPerformed(ActionEvent event) {
        if (fileChooser==null) {


          fileChooser = new JFileChooser();
          fileChooser.setCurrentDirectory(new File("."));
        }

        if (fileChooser.showSaveDialog(MainFrame.this) ==
                JFileChooser.APPROVE_OPTION)


          saveToTextFile(fileChooser.getSelectedFile());
      }
    };


    saveToTextMenuItem = fileMenu.add(saveToTextAction);

    saveToTextMenuItem.setEnabled(false);


    Action aboutProgramAction = new AbstractAction("О программе") {
      @Override
      public void actionPerformed(ActionEvent event ) {
        JOptionPane.showMessageDialog(MainFrame.this,
                new String[]{"Оразлыева Гулджемал Мыратдурдыевна", "6 группа"},
                "О программе", JOptionPane.INFORMATION_MESSAGE);
      }
    };

    aboutProgramMenuItem=helpMenu.add(aboutProgramAction);
    aboutProgramMenuItem.setEnabled(true);

