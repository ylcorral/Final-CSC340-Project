package CSC340.DB;

/**
 *
 * @author David Bowles 12/1/2020 DB Properties table connector
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class PropertiesDBConnector implements DBConnectorInterface {

    public static String readUserParameters(String _label, int _rowNum) throws SQLException {
        String userInfo;
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("SELECT " + _label + " FROM PROPERTIES");
            for (int i = 0; i < _rowNum; i++) {
                results.next();
            }
            userInfo = results.getString(_label);
            results.close();
            stmt.close();
        }
        return userInfo;
    }

    //reads whole row
    public static HashMap<String, String> readUserInfoDB(String id) throws SQLException {
        HashMap<String, String> map = new HashMap<>();
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM PROPERTIES");
            int rowNum = Integer.parseInt(id);
            for (int i = 0; i <= rowNum; i++) {
                results.next();
            }

            map.put("DOG_PARAMETERS", results.getString("DOG_PARAMETERS"));
            map.put("CAT_PARAMETERS", results.getString("CAT_PARAMETERS"));
            map.put("BIRD_PARAMETERS", results.getString("BIRD_PARAMETERS"));
            map.put("BARNYARD_PARAMETERS", results.getString("BARNYARD_PARAMETERS"));
            map.put("HORSES_PARAMETERS", results.getString("HORSES_PARAMETERS"));
            map.put("RABBIT_PARAMETERS", results.getString("RABBIT_PARAMETERS"));
            map.put("SCALES_PARAMETERS", results.getString("SCALES_PARAMETERS"));
            map.put("SMALLANDFURRY_PARAMETERS", results.getString("SMALLANDFURRY_PARAMETERS"));
            map.put("ID", results.getString("ID"));
            map.put("ANIMALTYPE", results.getString("ANIMALTYPE"));

            results.close();
            stmt.close();
        }
        return map;
    }

    //Changes the User Info
    public static void updateUserInfoDB(String label, String variable, String id) throws SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            System.out.println("UPDATE PROPERTIES \nSET " + label + " = " + "'" + variable + "'" + " \nWHERE ID = " + id);
            stmt.executeUpdate("UPDATE PROPERTIES SET " + label + " = " + "'" + variable + "'" + " WHERE ID = " + id);
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

    public static void addUserInfoDB(HashMap<String, String> map, String id) throws SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/logindb", "root", "root")) {
            Statement stmt = con.createStatement();
            String statementLabels = "";
            String statementValues = "";

            if (map.containsKey("DOG_PARAMETERS")) {
                statementLabels = "DOG_PARAMETERS";
                statementValues = "'" + map.get("DOG_PARAMETERS") + "'";
            }
            if (map.containsKey("CAT_PARAMETERS")) {
                statementLabels = "CAT_PARAMETERS";
                statementValues = "'" + map.get("CAT_PARAMETERS") + "'";
            }
            if (map.containsKey("BIRD_PARAMETERS")) {
                statementLabels = "BIRD_PARAMETERS";
                statementValues = "'" + map.get("BIRD_PARAMETERS") + "'";
            }
            if (map.containsKey("BARNYARD_PARAMETERS")) {
                statementLabels = "BARNYARD_PARAMETERS";
                statementValues = "'" + map.get("BARNYARD_PARAMETERS") + "'";
            }
            if (map.containsKey("HORSES_PARAMETERS")) {
                statementLabels = "HORSES_PARAMETERS";
                statementValues = "'" + map.get("HORSES_PARAMETERS") + "'";
            }
            if (map.containsKey("RABBIT_PARAMETERS")) {
                statementLabels = "RABBIT_PARAMETERS";
                statementValues = "'" + map.get("RABBIT_PARAMETERS") + "'";
            }
            if (map.containsKey("SCALES_PARAMETERS")) {
                statementLabels = "SCALES_PARAMETERS";
                statementValues = "'" + map.get("SCALES_PARAMETERS") + "'";
            }
            if (map.containsKey("SAMLLANDFURRY_PARAMETERS")) {
                statementLabels = "SAMLLANDFURRY_PARAMETERS";
                statementValues = "'" + map.get("SAMLLANDFURRY_PARAMETERS") + "'";
            }
            if (map.containsKey("ANIMALTYPE")) {
                statementLabels = "ANIMALTYPE";
                statementValues = "'" + map.get("ANIMALTYPE") + "'";
            }

            statementLabels = statementLabels + ",ID";
            statementValues = statementValues + "," + id;

            System.out.println("INSERT INTO PROPERTIES(" + statementLabels + ") VALUES (" + statementValues + ")");
            stmt.executeUpdate("INSERT INTO PROPERTIES(" + statementLabels + ") VALUES (" + statementValues + ")");

            stmt.close();
            System.out.println("DB info added");

        }

    }
}
