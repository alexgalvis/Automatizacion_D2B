package co.com.bancolombia.kioscos.automatizacion.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionIseriesBD {
    private static final String url = AppProperties.getStrConexionIseries();
    private static final String username = AppProperties.getUserIseries();
    private static final String password = AppProperties.getPasswordIseries();

    public static Connection getInstance() throws ClassNotFoundException, SQLException {
        Class.forName("com.ibm.as400.access.AS400JDBCDriver");
        return DriverManager.getConnection(url,username,password);
    }
}
