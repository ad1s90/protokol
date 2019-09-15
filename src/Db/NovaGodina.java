package Db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class NovaGodina {

    private Connection conn;
    private Statement stm;

    public void openNewYear() throws ClassNotFoundException, IOException, SQLException {

        conn = TestConnection.getConn();
        stm = conn.createStatement();

        LocalDate date = LocalDate.now();
        String dateString = String.valueOf(date.getYear() - 1);

        String alterKU = "ALTER TABLE `protokol`.`knjiga_ulaz` RENAME TO  `protokol`.`knjiga_ulaz" + dateString + "`";
        String alterKI = "ALTER TABLE `protokol`.`knjiga_izlaz` RENAME TO  `protokol`.`knjiga_izlaz" + dateString + "`";
        String alterPI = "ALTER TABLE `protokol`.`protokol_ulaz` RENAME TO  `protokol`.`protokol_ulaz" + dateString + "`";
        String alterPU = "ALTER TABLE `protokol`.`protokol_izlaz` RENAME TO  `protokol`.`protokol_izlaz" + dateString + "`";

        String createKU = "CREATE TABLE `knjiga_ulaz` ("
                + "`id_ku` int(15) NOT NULL AUTO_INCREMENT,"
                + "`osnovni_broj` int(15) DEFAULT NULL,"
                + " `opis` varchar(300) DEFAULT NULL,"
                + " `podbroj` int(15) DEFAULT NULL,"
                + " `datum_prijema` date DEFAULT NULL,"
                + " `posiljalac` varchar(300) DEFAULT NULL,"
                + " `broj_akta` varchar(45) DEFAULT NULL,"
                + "`org_jedinica` varchar(45) DEFAULT NULL,"
                + "PRIMARY KEY (`id_ku`),"
                + "UNIQUE KEY `id_UNIQUE` (`id_ku`)"
                + ") ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4";

        String createKI = "CREATE TABLE `knjiga_izlaz` ("
                + "`id_ki` int(11) NOT NULL AUTO_INCREMENT,"
                + "`redni_broj` int(11) DEFAULT NULL,"
                + "`primalac` varchar(100) DEFAULT NULL,"
                + "`opis` varchar(100) DEFAULT NULL,"
                + "`datum_slanja` date DEFAULT NULL,"
                + " `kolicina` int(11) DEFAULT NULL,"
                + "`vrsta` varchar(45) DEFAULT NULL,"
                + "`poslao` varchar(45) DEFAULT NULL,"
                + "  PRIMARY KEY (`id_ki`),"
                + "  UNIQUE KEY `id_ki_UNIQUE` (`id_ki`)"
                + ") ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4";

        String createPI = "CREATE TABLE `protokol_izlaz1` ("
                + "`id_protokol_izlaz` int(11) NOT NULL AUTO_INCREMENT,"
                + "`redni_broj` int(11) DEFAULT NULL,"
                + "`datum` date DEFAULT NULL,"
                + " `opis` varchar(300) DEFAULT NULL,"
                + " `org_jedinica` varchar(45) DEFAULT NULL,"
                + "`uradio` varchar(45) DEFAULT NULL,"
                + " `registrator` varchar(45) DEFAULT NULL,"
                + " PRIMARY KEY (`id_protokol_izlaz`)"
                + ") ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4";

        String createPU = "CREATE TABLE `protokol_ulaz` ("
                + "`id_protokol_ulaz` int(11) NOT NULL AUTO_INCREMENT,"
                + " `redni_broj` int(11) DEFAULT NULL,"
                + "`datum` date DEFAULT NULL,"
                + "`dostavljeno` varchar(45) DEFAULT NULL,"
                + "`naziv_dokumenta` varchar(45) DEFAULT NULL,"
                + "`org_jedinica` varchar(45) DEFAULT NULL,"
                + " PRIMARY KEY (`id_protokol_ulaz`),"
                + " UNIQUE KEY `idprotokol_ulaz_UNIQUE` (`id_protokol_ulaz`)"
                + ") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4";

        stm.executeUpdate(alterKI);
        stm.executeUpdate(alterKU);
        stm.executeUpdate(alterPI);
        stm.executeUpdate(alterPU);
        stm.executeUpdate(createKU);
        stm.executeUpdate(createKI);
        stm.executeUpdate(createPI);
        stm.executeUpdate(createPU);

    }

}
