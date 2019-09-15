package Util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class HelpClass {

    public static void clrFields(JTextField... tf) {

        for (JTextField t : tf) {
            t.setText("");
        }

    }

    public static boolean isNum(String x) {

        boolean num = true;

        try {
            Integer.parseInt(x);
        } catch (NumberFormatException e) {
            num = false;
        }

        return num;
    }

    public static String localDateFormatter(LocalDate date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY");

        String dateString = formatter.format(date);

        return dateString;
    }
    
        public static String dateFormatter(Date date) {

          DateFormat dateFormat = new SimpleDateFormat("dd.MM.YYYY");  
        String strDate = dateFormat.format(date);  

        return strDate;
    }

    public static java.sql.Date stringToDate(String date) throws ParseException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);

        java.sql.Date mySqlDate = java.sql.Date.valueOf(localDate);

        return mySqlDate;
    }

    public static boolean dateMatcher(String date) {

        Pattern DATE_PATTERN = Pattern.compile("^\\d{2}.\\d{2}.\\d{4}$");

        return DATE_PATTERN.matcher(date).matches();

    }


    public static void Writer(JTable jTable1) throws FileNotFoundException, IOException {

        String defaultDir = System.getProperty("user.home");

        JFileChooser fileChooser = new JFileChooser(defaultDir + "/Desktop");
        fileChooser.setDialogTitle("Specify a file to save");
        String location;
        int userSelection = fileChooser.showSaveDialog(jTable1);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = new File(fileChooser.getSelectedFile().toString() + ".xls");
            if (fileToSave.exists()) {
                int response = JOptionPane.showConfirmDialog(null, //
                        "Do you want to replace the existing file?", //
                        "Confirm", JOptionPane.YES_NO_OPTION, //
                        JOptionPane.QUESTION_MESSAGE);
                if (response != JOptionPane.YES_OPTION) {
                    return;
                }
            }
            location = fileChooser.getSelectedFile().toString() + ".xls";

        } else {
            return;
        }

        HSSFWorkbook fWorkbook = new HSSFWorkbook();
        HSSFSheet fSheet = fWorkbook.createSheet("new Sheet");
        HSSFFont sheetTitleFont = fWorkbook.createFont();
        HSSFCellStyle cellStyle = fWorkbook.createCellStyle();

        //sheetTitleFont.setColor();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        //Get Header
        TableColumnModel tcm = jTable1.getColumnModel();
        HSSFRow hRow = fSheet.createRow((short) 0);
        for (int j = 0; j < tcm.getColumnCount(); j++) {
            HSSFCell cell = hRow.createCell((short) j);
            cell.setCellValue(tcm.getColumn(j).getHeaderValue().toString());
            cell.setCellStyle(cellStyle);
        }

        //Get Other details
        for (int i = 0; i < model.getRowCount(); i++) {
            HSSFRow fRow = fSheet.createRow((short) i + 1);
            for (int j = 0; j < model.getColumnCount(); j++) {
                HSSFCell cell = fRow.createCell((short) j);
                cell.setCellValue(model.getValueAt(i, j).toString());
                cell.setCellStyle(cellStyle);
            }
        }
        FileOutputStream fileOutputStream;
        fileOutputStream = new FileOutputStream(location);
        try (BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream)) {
            fWorkbook.write(bos);
        }
        fileOutputStream.close();
    }

    public static String dateFormatter(String datum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
