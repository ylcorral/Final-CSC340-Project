package CSC340.DBtoAPI;

/**
 * DBToAPI Controller
 *
 * @author David Bowles 12/1/2020
 */
import static CSC340.DB.DBController.getAllDBInfo;
import static CSC340.DBtoAPI.SignUpDBPetFinderTranslator.animalPropertiesListToString;
import static CSC340.DBtoAPI.SignUpDBPetFinderTranslator.animalPropertiesListToStringBarnyard;
import static CSC340.DBtoAPI.SignUpDBPetFinderTranslator.animalPropertiesListToStringBird;
import static CSC340.DBtoAPI.SignUpDBPetFinderTranslator.animalPropertiesListToStringCat;
import static CSC340.DBtoAPI.SignUpDBPetFinderTranslator.animalPropertiesListToStringDog;
import static CSC340.DBtoAPI.SignUpDBPetFinderTranslator.animalPropertiesListToStringHorse;
import static CSC340.DBtoAPI.SignUpDBPetFinderTranslator.animalPropertiesListToStringRabbit;
import static CSC340.DBtoAPI.SignUpDBPetFinderTranslator.animalPropertiesListToStringScales;
import static CSC340.DBtoAPI.SignUpDBPetFinderTranslator.animalPropertiesListToStringSmallF;
import static CSC340.DBtoAPI.SignUpDBPetFinderTranslator.animalPropertiesParced;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class DBtoAPIController {

    //Calls preferences API and formates it to send to API
    public static String DBtoAPI(String _id) throws SQLException {
        System.out.println("DBToAPI Called");
        HashMap<String, String> properties;
        properties = getAllDBInfo(_id);
        System.out.println("DBToAPI Properties HashMap: " + properties);
        ArrayList<String> apiParametersList = animalPropertiesParced(properties);
        System.out.println("DBToAPI Properties parced" + apiParametersList.toString());
        String apiParameters = animalPropertiesListToString(apiParametersList, "0");

        return apiParameters;
    }

    public static String DBtoAPIPage(String _id, String _page) throws SQLException {
        HashMap<String, String> properties;
        properties = getAllDBInfo(_id);
        ArrayList<String> apiParametersList = animalPropertiesParced(properties);
        String apiParameters = animalPropertiesListToString(apiParametersList, _page);

        return apiParameters;
    }

    public static String DBToAPIDog(String _id, String _page) throws SQLException {
        HashMap<String, String> properties;
        properties = getAllDBInfo(_id);
        ArrayList<String> apiParametersList = animalPropertiesParced(properties);
        String apiParameters = animalPropertiesListToStringDog(apiParametersList, _page);
        return apiParameters;
    }

    public static String DBToAPICat(String _id, String _page) throws SQLException {
        HashMap<String, String> properties;
        properties = getAllDBInfo(_id);
        ArrayList<String> apiParametersList = animalPropertiesParced(properties);
        String apiParameters = animalPropertiesListToStringCat(apiParametersList, _page);
        return apiParameters;
    }

    public static String DBToAPIRabbit(String _id, String _page) throws SQLException {
        HashMap<String, String> properties;
        properties = getAllDBInfo(_id);
        ArrayList<String> apiParametersList = animalPropertiesParced(properties);
        String apiParameters = animalPropertiesListToStringRabbit(apiParametersList, _page);
        return apiParameters;
    }

    public static String DBToAPIBird(String _id, String _page) throws SQLException {
        HashMap<String, String> properties;
        properties = getAllDBInfo(_id);
        ArrayList<String> apiParametersList = animalPropertiesParced(properties);
        String apiParameters = animalPropertiesListToStringBird(apiParametersList, _page);
        return apiParameters;
    }

    public static String DBToAPIScales(String _id, String _page) throws SQLException {
        HashMap<String, String> properties;
        properties = getAllDBInfo(_id);
        ArrayList<String> apiParametersList = animalPropertiesParced(properties);
        String apiParameters = animalPropertiesListToStringScales(apiParametersList, _page);
        return apiParameters;
    }

    public static String DBToAPISmallF(String _id, String _page) throws SQLException {
        HashMap<String, String> properties;
        properties = getAllDBInfo(_id);
        ArrayList<String> apiParametersList = animalPropertiesParced(properties);
        String apiParameters = animalPropertiesListToStringSmallF(apiParametersList, _page);
        return apiParameters;
    }

    public static String DBToAPIHorse(String _id, String _page) throws SQLException {
        HashMap<String, String> properties;
        properties = getAllDBInfo(_id);
        ArrayList<String> apiParametersList = animalPropertiesParced(properties);
        String apiParameters = animalPropertiesListToStringHorse(apiParametersList, _page);
        return apiParameters;
    }

    public static String DBToAPIBarnyard(String _id, String _page) throws SQLException {
        HashMap<String, String> properties;
        properties = getAllDBInfo(_id);
        ArrayList<String> apiParametersList = animalPropertiesParced(properties);
        String apiParameters = animalPropertiesListToStringBarnyard(apiParametersList, _page);
        return apiParameters;
    }
}
