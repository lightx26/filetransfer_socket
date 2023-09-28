package ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class dataAccess {
    private Connection connection;

    public dataAccess(String url, String user, String password) {
        connect(url, user, password);
    }

    public Connection getConnection() {
        if (this.connection != null)
            return this.connection;
        else return null;
    }

    public void connect(String url, String user, String password) {
        if (connection != null) {
            closeConnection();
            connection = null;
        }

        try {
            connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Connect to database [" + url.substring(1 + url.lastIndexOf("/")) + "] successfully!");
            } else {
                System.out.println("Cannot connect to database");
            }
        }

        catch (Exception e) {
            System.err.println("Cannot connect to database.");
            e.printStackTrace();
        }
    }

    public ResultSet ExecuteQuery(String query) {
        ResultSet res = null;
        if (connection != null) {
            try {
                Statement st = connection.createStatement();
                res = st.executeQuery(query);
        
            } catch (Exception e) {
                System.err.println("Cannot execute the query");
                e.printStackTrace();
            }
        }
        return res;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Disconnected to database");
            } catch (Exception e) {
                System.err.println("Cannot close connection.");
                e.printStackTrace();
            }
        }
    }
}
