package Db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyProperties {

    File configFile = new File("config.properties");
    Properties configProps;

    public MyProperties() throws IOException {
        if (!configFile.exists()) {
            configFile.createNewFile();
            try {
                loadProperties();
            } catch (IOException ex) {
                Logger.getLogger(MyProperties.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public File getConfigFile() {
        return configFile;
    }

    public Properties getConfigProps() {
        return configProps;
    }

    public void loadProperties() throws IOException {
        Properties defaultProps = new Properties();
        // sets default properties
        defaultProps.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        defaultProps.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        defaultProps.setProperty("hibernate.connection.url", "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "protokol" + "?useSSL=false");
        defaultProps.setProperty("hibernate.connection.username", "root");
        defaultProps.setProperty("hibernate.connection.password", "");
        defaultProps.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
        defaultProps.setProperty("show_sql", "true");
        defaultProps.setProperty("host", "localhost");
        defaultProps.setProperty("port", "3306");
        defaultProps.setProperty("baza", "protokol");

        configProps = new Properties(defaultProps);
        try (InputStream inputStream = new FileInputStream(configFile)) {
            configProps.load(inputStream);
        }

    }

    public void saveProperties(String port, String host, String baza, String username, String pass) throws IOException {
        configProps = new Properties();
        configProps.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        configProps.setProperty("hibernate.connection.url", "jdbc:mysql://" + host + ":" + port + "/" + baza + "?useSSL=false");
        configProps.setProperty("hibernate.connection.username", username);
        configProps.setProperty("hibernate.connection.password", pass);
        configProps.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
        configProps.setProperty("show_sql", "true");
        configProps.setProperty("host", host);
        configProps.setProperty("port", port);
        configProps.setProperty("baza", baza);

        try (OutputStream outputStream = new FileOutputStream(configFile)) {
            configProps.store(outputStream, "host setttings");
        }

    }

    public Properties myprop() throws FileNotFoundException, IOException {
        configProps = new Properties();

        try (InputStream inputStream = new FileInputStream(configFile)) {
            configProps.load(inputStream);
        }

        return configProps;

    }

}
