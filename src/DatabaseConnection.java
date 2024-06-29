import java.sql.*;
public class DatabaseConnection{

    public static Connection getConnection(){
        try {
            String url = "jdbc:postgresql://localhost/postgresdb1?user=postgres&password=password&ssl=false";
            Connection connection = DriverManager.getConnection(url);
            return connection;
        } catch (Exception e) {
          //  e.printStackTrace();
        }
        return null;
    }
}