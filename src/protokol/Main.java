package protokol;

import Db.NovaGodina;
import GUI.Main.MainFrame;
import java.io.IOException;
import java.text.ParseException;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException, ParseException, IOException, ClassNotFoundException {

//
               MainFrame mf = new MainFrame();
               mf.setTitle("Protokol");
               mf.setLocationRelativeTo(mf);
               mf.setVisible(true);




//             File configFile = new File("config.properties");
//             configFile.getAbsolutePath();
//             
//             System.out.println(configFile.getPath());
//            MyProperties p = new MyProperties();
//           
//prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/protokol");
//             p.saveProperties("3306", "localhost", "protokol", "root", "");


        // JDBC driver name and database URL
//        String driver = "com.mysql.jdbc.Driver";
//        String url = "jdbc:mysql://localhost/protokol";
//
//        //  Database credentials
//        String USER = "root";
//        String PASS = "";
//
//        Connection conn = null;
//        Statement stmt = null;

//        try {
//            //STEP 2: Register JDBC driver
//            Class.forName("com.mysql.jdbc.Driver");
//
//            //STEP 3: Open a connection
//            System.out.println("Connecting to a selected database...");
//            conn = DriverManager.getConnection(url, USER, PASS);
//            System.out.println("Connected database successfully...");
//
//            //STEP 4: Execute a query
//            System.out.println("Creating table in given database...");
//            stmt = conn.createStatement();
//
////            String sql = "CREATE TABLE REGISTRATION "
////                    + "(id INTEGER not NULL, "
////                    + " first VARCHAR(255), "
////                    + " last VARCHAR(255), "
////                    + " age INTEGER, "
////                    + " PRIMARY KEY ( id ))";
//            String openNewYear = "ALTER TABLE `protokol`.`knjiga_ulaz` RENAME TO  `protokol`.`knjiga_ulaz2017`";
//
//            String createTable = "CREATE TABLE `knjiga_ulaz` (\n"
//                    + "   `id_ku` int(15) NOT NULL AUTO_INCREMENT,\n"
//                    + "   `osnovni_broj` int(15) DEFAULT NULL,\n"
//                    + "   `opis` varchar(300) DEFAULT NULL,\n"
//                    + "   `podbroj` int(15) DEFAULT NULL,\n"
//                    + "   `datum_prijema` date DEFAULT NULL,\n"
//                    + "   `posiljalac` varchar(300) DEFAULT NULL,\n"
//                    + "   `broj_akta` varchar(45) DEFAULT NULL,\n"
//                    + "   `org_jedinica` varchar(45) DEFAULT NULL,\n"
//                    + "   PRIMARY KEY (`id_ku`),\n"
//                    + "   UNIQUE KEY `id_UNIQUE` (`id_ku`)\n"
//                    + " ) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=latin1";
//            
//
//            stmt.executeUpdate(openNewYear);
//              stmt.executeUpdate(createTable);
//            System.out.println("Created table in given database...");
//        } catch (SQLException se) {
//            //Handle errors for JDBC
//            se.printStackTrace();
//        } catch (Exception e) {
//            //Handle errors for Class.forName
//            e.printStackTrace();
//        } finally {
//            //finally block used to close resources
//            try {
//                if (stmt != null) {
//                    conn.close();
//                }
//            } catch (SQLException se) {
//            }// do nothing
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }//end finally try
//        }//end try
//        System.out.println("Goodbye!");


    }

}
