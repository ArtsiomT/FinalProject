package by.epam.terehovich.internetprovider.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by aterehovich on 16.7.15.
 */
public class ConnectionPool {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
    private static String url = resourceBundle.getString("db.url");
    private static String user = resourceBundle.getString("db.user");
    private static String password = resourceBundle.getString("db.password");
    private static String driver = resourceBundle.getString("db.driver");
    private static int poolSize = Integer.parseInt(resourceBundle.getString("db.poolsize"));
    private static BlockingQueue<Connection> pool = new ArrayBlockingQueue<>(poolSize, true);

    private static ConnectionPool instance = new ConnectionPool();

    public static ConnectionPool getInstance() {
        if(instance!=null){
            return instance;
        } else {
            instance = new ConnectionPool();
            return instance;
        }
    }

    private ConnectionPool() {
        try {
            Class.forName(driver).newInstance();
            for (int i = 0; i < poolSize; i++) {
                try {
                    pool.add(DriverManager.getConnection(url, user, password));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {

        }
    }

    public Connection getConnection(){
        Connection connection = null;
        try {
            connection = pool.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection){
        if (connection != null){
            try {
                pool.put(connection);
                System.out.println("connection closed");
            } catch (InterruptedException e) {
                System.out.println("error with returning connection");
                e.printStackTrace();
            }
        }
    }
}
