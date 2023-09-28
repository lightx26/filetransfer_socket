import java.sql.ResultSet;

import ConnectDB.dataAccess;

public class App {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/users";
        String user = "root";
        String password = "admin";

        dataAccess dal = new dataAccess(url, user, password);
        String query = "select username from user";
        ResultSet res = dal.ExecuteQuery(query);
        while (res.next()) {
            System.out.println(res.getString(1));
        }
        dal.closeConnection();
    }
}
