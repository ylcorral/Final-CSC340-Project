package CSC340.DB;

/**
 *
 * @author David Bowles 12/1/2020 Grabs Information from the Database Tables
 */
import CSC340.APIParcer.Animal;
import static CSC340.APIParcer.Animal.hashMapToAnimal;
import static CSC340.DB.FavoritesDBConnector.createNum;
import static CSC340.DB.PropertiesDBConnector.readUserInfoDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DBFactory {

    //Reads the Labels from a specific user in the database
    public static String getUserFirst_Name(int _rowNum) throws SQLException {
        String s = SignUpDatabaseConnector.readUserParameters("FIRST_NAME", _rowNum);
        return s;
    }

    public static String getUserAnimalType(int _rowNum) throws SQLException {
        String s = SignUpDatabaseConnector.readUserParameters("ANIMALTYPE", _rowNum);
        return s;
    }

    public static String getUserZipCode(int _rowNum) throws SQLException {
        String s = SignUpDatabaseConnector.readUserParameters("ZIPCODE", _rowNum);
        return s;
    }

    public static String getUserLast_Name(int _rowNum) throws SQLException {
        String s = SignUpDatabaseConnector.readUserParameters("LAST_NAME", _rowNum);
        return s;
    }

    public static String getUserEmail(int _rowNum) throws SQLException {
        String s = SignUpDatabaseConnector.readUserParameters("EMAIL", _rowNum);
        return s;
    }

    public static String getUserPhonenumber(int _rowNum) throws SQLException {
        String s = SignUpDatabaseConnector.readUserParameters("PHONENUMBER", _rowNum);
        return s;
    }

    public static String getUserPassword(int _rowNum) throws SQLException {
        String s = SignUpDatabaseConnector.readUserParameters("PASSWORD", _rowNum);
        return s;
    }

    public static String getUserRadius(int _rowNum) throws SQLException {
        String s = SignUpDatabaseConnector.readUserParameters("RADIUS", _rowNum);
        return s;
    }

    //Gets the Typesd of animal of a specific user
    public static ArrayList<String> getAnimalTypeList(String _id) throws SQLException {
        HashMap<String, String> map = readUserInfoDB(_id);
        String parametersString = map.get("ANIMALTYPE");
        ArrayList<String> list = new ArrayList<String>();
        if (parametersString.contains("Dog")) {
            list.add("Dog");
        }
        if (parametersString.contains("Cat")) {
            list.add("Cat");
        }
        if (parametersString.contains("Rabbit")) {
            list.add("Rabbit");
        }
        if (parametersString.contains("Bird")) {
            list.add("Bird");
        }
//        if (parametersString.contains("Scales, Fins & Other")) {
//            list.add("Scales, Fins & Other");
//        }
//        if (parametersString.contains("Small & Furry")) {
//            list.add("Small & Furry");
//        }
        if (parametersString.contains("Horse")) {
            list.add("Horse");
        }
        if (parametersString.contains("Barnyard")) {
            list.add("Barnyard");
        }

        return list;
    }

    //gets the parameters for the api from the user in the database
    public static HashMap<String, String> getAPIParameters(int _rowNum) throws SQLException {
        HashMap<String, String> parameters = new HashMap<>();

        String s = getUserAnimalType(_rowNum);
        if (s != "NULL") {
            parameters.put("ANIMALTYPE", s);
        }
        s = getUserZipCode(_rowNum);
        if (s != "NULL") {
            parameters.put("ZIPCODE", s);
        }
        s = getUserRadius(_rowNum);
        if (s != "NULL") {
            parameters.put("RADIUS", s);
        }

        return parameters;

    }

    public static ArrayList<Animal> getAnimalList(String _id) throws SQLException {
        String total = createNum(_id);
        int totalNum = Integer.parseInt(total);
        HashMap<String, String> animalMap;
        Animal animal;
        ArrayList<Animal> animalList = new ArrayList<Animal>();

        int i = 0;
        while (i < totalNum) {
            animalMap = FavoritesDBConnector.readUserInfoDB(_id, Integer.toString(i));
            animal = hashMapToAnimal(animalMap);
            animalList.add(animal);
            i++;
        }
        return animalList;
    }

}
