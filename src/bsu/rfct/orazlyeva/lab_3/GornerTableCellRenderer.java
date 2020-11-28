package bsu.rfct.orazlyeva.lab_3;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
public class GornerTableCellRenderer
        implements TableCellRenderer {
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    // Ищем ячейки, строковое представление которых совпадает с needle
// (иголкой). Применяется аналогия поиска иголки в стоге сена, в роли
// стога сена - таблица
    private String needle = null;
    private DecimalFormat formatter =
            (DecimalFormat)NumberFormat.getInstance();
    // Дополнительный метод для проверки, совпадает ли дробная часть числа с целой
    private boolean isCoincideFractionalAndIntegerPartsOfNumber(String number) {
        String[] str = number.split("\\.");
        if (str.length == 2) {
            if (str[0].compareTo(str[1]) == 0) {
                return true;
            }
        }
        return false;
    }