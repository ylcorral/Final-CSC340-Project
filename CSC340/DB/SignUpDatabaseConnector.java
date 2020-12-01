package CSC340.DB;

/**
 *
 * @author David Bowles 12/1/2020 DB SignUpDB table connector
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class SignUpDatabaseConnector implements DBConnectorInterface {

    // Creating a connection to login database   
    public static boolean DBLogIn(String _email, String _password) throws SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            PreparedStatement ps = null;
            ResultSet result = null;
            String login = "SELECT * FROM USERSIGNUP WHERE email =? AND password=?";
            /* Checks to see if the email and password inserted matches the database */
            try {
                ps = con.prepareStatement(login);
                ps.setString(1, _email);
                ps.setString(2, _password);
                result = ps.executeQuery();
                if (_email.equals("") && _password.equals("")) {
                    return false;
                } else if (result.next()) {

                    return true;

                } else {

                    return false;
                }

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, ex);
            }
            return false;
        }
    }

    public static String getID(String _label, String _value) throws SQLException {
        String id = "";
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("SELECT ID FROM USERSIGNUP WHERE " + _label + "=" + "'" + _value + "'");
            results.next();
            id = results.getString("ID");
            System.out.println(id);
            results.close();
            stmt.close();
            return id;
        }
    }

    //reads a specific value of user info
    public static String readUserParameters(String _label, int _rowNum) throws SQLException {
        String userInfo;
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("SELECT " + _label + " FROM USERSIGNUP");
            for (int i = 0; i < _rowNum; i++) {
                results.next();
            }
            userInfo = results.getString(_label);
            results.close();
            stmt.close();
        }
        return userInfo;
    }

    //returns a hashmap of a users info
    public static HashMap<String, String> readUserInfoDB(String _id) throws SQLException {
        HashMap<String, String> map = new HashMap<>();
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM USERSIGNUP");
            int rowNum = Integer.parseInt(_id);
            for (int i = 0; i <= rowNum; i++) {
                results.next();
            }
            map.put("FIRST_NAME", results.getString("FIRST_NAME"));
            map.put("LAST_NAME", results.getString("LAST_NAME"));
            map.put("EMAIL", results.getString("EMAIL"));
            map.put("PHONENUMBER", results.getString("PHONENUMBER"));
            map.put("PASSWORD", results.getString("PASSWORD"));
            map.put("ZIPCODE", results.getString("ZIPCODE"));
            map.put("RADIUS", results.getString("RADIUS"));

            results.close();
            stmt.close();
        }
        return map;
    }

    //updates user info
    public static void updateUserInfoDB(String _label, String _variable, String _id) throws SQLException {

        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            if (_label.equals("PHONENUMBER") || _label.equals("ZIPCODE") || _label.equals("RADIUS") || _label.equals("ID")) {
                System.out.println("UPDATE USERSIGNUP \nSET " + _label + " = " + _variable + " \nWHERE ID = " + _id);
                stmt.executeUpdate("UPDATE USERSIGNUP SET " + _label + " = " + _variable + " WHERE ID = " + _id);
            } else {
                System.out.println("UPDATE USERSIGNUP \nSET " + _label + " = " + "'" + _variable + "'" + " \nWHERE ID = " + _id);
                stmt.executeUpdate("UPDATE USERSIGNUP SET " + _label + " = " + "'" + _variable + "'" + " WHERE ID = " + _id);
            }
            stmt.close();
            System.out.println("DB Info Updated");
        }
    }

    //deletes a user from DB
    public static void deleteUserInfoDB(String _id) throws SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            System.out.println("DELETE FROM USERSIGNUP WHERE id =" + _id);
            stmt.executeUpdate("DELETE FROM USERSIGNUP WHERE id =" + _id);
            stmt.close();
            System.out.println("DB Info Deleted");
        }

        /**
         *
         * @param map
         * @throws SQLException
         */
    }

    //Adds a User to the DB
    public static void addUserInfoDB(HashMap<String, String> _map, String _id) throws SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            String statementLabels = "";
            String statementValues = "";

            if (_map.containsKey("FIRST_NAME")) {
                statementLabels = "FIRST_NAME";
                statementValues = "'" + _map.get("FIRST_NAME") + "'";
            }
            if (_map.containsKey("LAST_NAME")) {
                statementLabels = statementLabels + ",LAST_NAME";
                statementValues = statementValues + "," + "'" + _map.get("LAST_NAME") + "'";
            }
            if (_map.containsKey("EMAIL")) {
                statementLabels = statementLabels + ",EMAIL";
                statementValues = statementValues + "," + "'" + _map.get("EMAIL") + "'";
            }
            if (_map.containsKey("PHONENUMBER")) {
                statementLabels = statementLabels + ",PHONENUMBER";
                statementValues = statementValues + "," + "'" + _map.get("PHONENUMBER") + "'";
            }
            if (_map.containsKey("PASSWORD")) {
                statementLabels = statementLabels + ",PASSWORD";
                statementValues = statementValues + "," + "'" + _map.get("PASSWORD") + "'";
            }
            if (_map.containsKey("ZIPCODE")) {
                statementLabels = statementLabels + ",ZIPCODE";
                statementValues = statementValues + "," + _map.get("ZIPCODE");
            }
            if (_map.containsKey("RADIUS")) {
                statementLabels = statementLabels + ",RADIUS";
                statementValues = statementValues + "," + _map.get("RADIUS");
            }

            statementLabels = statementLabels + ",ID";
            statementValues = statementValues + "," + _id;

            System.out.println(statementLabels);
            System.out.println(statementValues);

            System.out.println("INSERT INTO USERSIGNUP(" + statementLabels + ") VALUES (" + statementValues + ")");
            stmt.executeUpdate("INSERT INTO USERSIGNUP(" + statementLabels + ") VALUES (" + statementValues + ")");

            stmt.close();
            System.out.println("DB info added");

        }

    }

    public static boolean checkForValue(String _parameter, String _value) throws SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("SELECT " + _parameter + " FROM USERSIGNUP");

            while (results.next()) {
                if (results.getString(_parameter).equals(_value)) {
                    return true;
                }

            }
            results.close();
            stmt.close();
            return false;
        }
    }

}
