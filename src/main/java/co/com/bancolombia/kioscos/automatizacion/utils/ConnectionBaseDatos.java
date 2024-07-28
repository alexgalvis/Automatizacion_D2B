package co.com.bancolombia.kioscos.automatizacion.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBaseDatos {
    private static final String url = "jdbc:mysql://localhost:3306/autokioscos?serverTimezone=America/Bogota";
    private static final String username = "root";
    private static final String password = "Santafe11";
    private static Connection connection;

    public static Connection getInstance() throws SQLException {
        return DriverManager.getConnection(url,username,password);
        /*
        if (connection == null){
            connection = DriverManager.getConnection(url,username,password);
        }
        return connection;

         */
    }

}
