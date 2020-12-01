package CSC340.DB;

/**
 * Controller For DB
 *
 * @author David Bowles Last Updated 12/1/2020
 */

import CSC340.APIParcer.Animal;
import static CSC340.DB.DBConnector.createID;
import static CSC340.DB.SignUpDatabaseConnector.getID;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class DBController {

    //Creates a new user out of the sign up model data
    public static void createUserDB(HashMap<String, String> _signUp) throws SQLException {
        String id = createID();
        SignUpDatabaseConnector.addUserInfoDB(_signUp, id);
        PropertiesDBConnector.addUserInfoDB(_signUp, id);

    }

    //Checks to make sure login is same in DB as it is in model
    public static boolean loginUserDB(String _username, String _password) throws SQLException {
        return SignUpDatabaseConnector.DBLogIn(_username, _password);
    }

    //Gets the id of a specific username when user logs in
    public static String getIDController(String _username) throws SQLException {
        System.out.println("getIDController");
        return getID("EMAIL", _username);
    }

    //gets all info about a user from both DBs
    public static HashMap<String, String> getAllDBInfo(String _id) throws SQLException {
        HashMap<String, String> map = SignUpDatabaseConnector.readUserInfoDB(_id);
        HashMap<String, String> propertiesMap = PropertiesDBConnector.readUserInfoDB(_id);
        map.putAll(propertiesMap);
        return map;
    }

    //Adds a new animal to Favorites DB
    public static void addToFavoritesDB(HashMap<String, String> _animalMap) throws SQLException {
        FavoritesDBConnector.addUserInfoDB(_animalMap);
    }

    //Gets all the Favorites animal from a specific user ID
    public static ArrayList<Animal> getFavoritesAnimalList(String _id) throws SQLException {
        ArrayList<Animal> animal = DBFactory.getAnimalList(_id);
        System.out.println("Animal List DB Controller: " + animal.toString());
        return animal;
    }
}
