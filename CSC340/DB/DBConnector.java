package CSC340.DB;

/**
 * Connection to DB
 *
 * @author David Bowles 12/1/2020
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

//connects to the DB
public class DBConnector {

    public static Connection connectdb() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(SignUpDatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Creates the ID for the user when they sign up
    public static String createID() throws SQLException {
        int i = 0;
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM USERSIGNUP");

            while (results.next()) {
                i++;
            }
            results.close();
            stmt.close();
        }
        String num = String.valueOf(i);
        return num;
    }

}
