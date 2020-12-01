package CSC340.DB;

/**
 * Favorites DBtable
 *
 * @author David Bowles 12/1/2020
 */
import CSC340.APIParcer.Animal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class FavoritesDBConnector implements DBConnectorInterface {

    //Reads a specific label
    public static String readUserParameters(String _label, String _id) throws SQLException {
        String userInfo;
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM FAVORITES WHERE ID = " + _id);
            userInfo = results.getString(_label);
            results.close();
            stmt.close();
        }
        return userInfo;
    }

    //reads whole row
    public static HashMap<String, String> readUserInfoDB(String _id, String _animalNum) throws SQLException {
        HashMap<String, String> map = new HashMap<>();
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM FAVORITES WHERE ID=" + _id + " AND ANIMALNUM=" + _animalNum);
            results.next();
            map.put("NAME", results.getString("NAME"));
            map.put("GENDER", results.getString("GENDER"));
            map.put("SIZE", results.getString("SIZE"));
            map.put("AGE", results.getString("AGE"));
            map.put("DISTANCE", results.getString("DISTANCE"));
            map.put("TYPE", results.getString("TYPE"));
            map.put("COLORS", results.getString("COLORS"));
            map.put("BREEDS", results.getString("BREEDS"));
            map.put("DESCRIPTION", results.getString("DESCRIPTION"));
            map.put("PRIMARY_PHOTO_CROPPED", results.getString("PRIMARY_PHOTO_CROPPED"));
            map.put("ATTRIBUTES", results.getString("ATTRIBUTES"));
            map.put("CONTACT", results.getString("CONTACT"));
            map.put("PUBLISHED_AT", results.getString("PUBLISHED_AT"));
            results.close();
            stmt.close();
        }
        return map;
    }

    //Changes the User Info
    public static void updateUserInfoDB(String _label, String _variable, String _id) throws SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            System.out.println("UPDATE FAVORITES \nSET " + _label + " = " + "'" + _variable + "'" + " \nWHERE ID = " + _id);
            stmt.executeUpdate("UPDATE FAVORITES SET " + _label + " = " + "'" + _variable + "'" + " WHERE ID = " + _id);
            stmt.close();
            System.out.println("DB Info Updated");
        }
    }
    //Deletes the User

    public static void deleteUserInfoDB(int id) throws SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            System.out.println("DELETE FROM PROPERTIES WHERE id =" + id);
            stmt.executeUpdate("DELETE FROM PROPERTIES WHERE id =" + id);
            stmt.close();
            System.out.println("DB Info Deleted");
        }
    }
    //Adds a New Row in DB

    public static void addUserInfoDB(HashMap<String, String> map) throws SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            String statementLabels = "";
            String statementValues = "";

            if (map.containsKey("NAME")) {
                statementLabels = statementLabels + "NAME";
                statementValues = statementValues + "'" + map.get("NAME") + "'";
            }
            if (map.containsKey("GENDER")) {
                statementLabels = statementLabels + ",GENDER";
                statementValues = statementValues + ",'" + map.get("GENDER") + "'";
            }
            if (map.containsKey("SIZE")) {
                statementLabels = statementLabels + ",SIZE";
                statementValues = statementValues + ",'" + map.get("SIZE") + "'";
            }
            if (map.containsKey("AGE")) {
                statementLabels = statementLabels + ",AGE";
                statementValues = statementValues + ",'" + map.get("AGE") + "'";
            }
            if (map.containsKey("DISTANCE")) {
                statementLabels = statementLabels + ",DISTANCE";
                statementValues = statementValues + ",'" + map.get("DISTANCE") + "'";
            }
            if (map.containsKey("TYPE")) {
                statementLabels = statementLabels + ",TYPE";
                statementValues = statementValues + ",'" + map.get("TYPE") + "'";
            }
            if (map.containsKey("COLORS")) {
                statementLabels = statementLabels + ",COLORS";
                statementValues = statementValues + ",'" + map.get("COLORS") + "'";
            }
            if (map.containsKey("BREEDS")) {
                statementLabels = statementLabels + ",BREEDS";
                statementValues = statementValues + ",'" + map.get("BREEDS") + "'";
            }
            if (map.containsKey("DESCRIPTION")) {
                statementLabels = statementLabels + ",DESCRIPTION";
                statementValues = statementValues + ",'" + map.get("DESCRIPTION") + "'";
            }
            if (map.containsKey("PRIMARY_PHOTO_CROPPED")) {
                statementLabels = statementLabels + ",PRIMARY_PHOTO_CROPPED";
                statementValues = statementValues + ",'" + map.get("PRIMARY_PHOTO_CROPPED") + "'";
            }
            if (map.containsKey("ATTRIBUTES")) {
                statementLabels = statementLabels + ",ATTRIBUTES";
                statementValues = statementValues + ",'" + map.get("ATTRIBUTES") + "'";
            }
            if (map.containsKey("CONTACT")) {
                statementLabels = statementLabels + ",CONTACT";
                statementValues = statementValues + ",'" + map.get("CONTACT") + "'";
            }
            if (map.containsKey("PUBLISHED_AT")) {
                statementLabels = statementLabels + ",PUBLISHED_AT";
                statementValues = statementValues + ",'" + map.get("PUBLISHED_AT") + "'";
            }
            if (map.containsKey("ID")) {
                statementLabels = statementLabels + ",ID";
                statementValues = statementValues + "," + map.get("ID");
            }

            statementLabels = statementLabels + ",ANIMALNUM";
            statementValues = statementValues + "," + createNum(map.get("ID"));

            System.out.println("INSERT INTO FAVORITES(" + statementLabels + ") VALUES (" + statementValues + ")");
            stmt.executeUpdate("INSERT INTO FAVORITES(" + statementLabels + ") VALUES (" + statementValues + ")");

            stmt.close();
            System.out.println("DB info added");

        }
    }

    //Creates a new number for specific saved animal
    public static String createNum(String id) throws SQLException {
        int i = 0;
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM FAVORITES WHERE ID=" + id);

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
