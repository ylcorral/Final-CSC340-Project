package CSC340.apiCall;

/*
* The purpose of this class is to call the api with specific parameters.
* Last updated: 12/1/2020
* Author: David Bowles
 */
import static CSC340.apiCall.PetFinderAPIConnector.apiCall;
import CSC340.DBtoAPI.DBtoAPIController;
import static CSC340.DBtoAPI.DBtoAPIController.DBToAPIBarnyard;
import static CSC340.DBtoAPI.DBtoAPIController.DBToAPIBird;
import static CSC340.DBtoAPI.DBtoAPIController.DBToAPICat;
import static CSC340.DBtoAPI.DBtoAPIController.DBToAPIDog;
import static CSC340.DBtoAPI.DBtoAPIController.DBToAPIHorse;
import static CSC340.DBtoAPI.DBtoAPIController.DBToAPIRabbit;
import static CSC340.DBtoAPI.DBtoAPIController.DBToAPIScales;
import static CSC340.DBtoAPI.DBtoAPIController.DBToAPISmallF;
import static CSC340.DBtoAPI.DBtoAPIController.DBtoAPI;
import static CSC340.DBtoAPI.DBtoAPIController.DBtoAPIPage;
import static CSC340.apiCall.PetFinderAPIConnector.apiCallWithToken;
import static CSC340.apiCall.PetFinderAPIConnector.getToken;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;

public class PetFinderAPIController {

    //Calls random api url with user id parameters
    public static String callAPI(String _id) throws SQLException, IOException, JSONException {
        String s = DBtoAPI(_id);
        System.out.println("DBtoAPI: " + s);
        String s1 = apiCall(s);
        return s1;
    }

    //Calls random api url with user id parameters with a specific page in the api
    public static String callAPIPage(String _id, String _page, String _token) throws SQLException, IOException, JSONException {
        String s = DBtoAPIPage(_id, _page);
        System.out.println("DBtoAPIPage: " + s);
        String s1 = apiCallWithToken(s, _token);
        //System.out.println(s1);
        return s1;
    }

    //Calls Dog url with user id parameters and specific dog page
    public static String callDogAPIPage(String _id, String _page, String _token) throws SQLException, IOException, JSONException {
        String s = DBToAPIDog(_id, _page);
        System.out.println("DBtoAPIPage: " + s);
        String s1 = apiCallWithToken(s, _token);
        //System.out.println(s1);
        return s1;
    }
    //Calls Cat url with user id parameters and specific Cat page

    public static String callCatAPIPage(String _id, String _page, String _token) throws SQLException, IOException, JSONException {
        String s = DBToAPICat(_id, _page);
        System.out.println("DBtoAPIPage: " + s);
        String s1 = apiCallWithToken(s, _token);
        //System.out.println(s1);
        return s1;
    }

    //Calls Rabbit url with user id parameters and specific Rabbit page
    public static String callRabbitAPIPage(String _id, String _page, String _token) throws SQLException, IOException, JSONException {
        String s = DBToAPIRabbit(_id, _page);
        System.out.println("DBtoAPIPage: " + s);
        String s1 = apiCallWithToken(s, _token);
        //System.out.println(s1);
        return s1;
    }

    //Calls Bird url with user id parameters and specific Bird page
    public static String callBirdAPIPage(String _id, String _page, String _token) throws SQLException, IOException, JSONException {
        String s = DBToAPIBird(_id, _page);
        System.out.println("DBtoAPIPage: " + s);
        String s1 = apiCallWithToken(s, _token);
        //System.out.println(s1);
        return s1;
    }

    //Calls Scales url with user id parameters and specific Scales page
    public static String callScaleAPIPage(String _id, String _page, String _token) throws SQLException, IOException, JSONException {
        String s = DBToAPIScales(_id, _page);
        System.out.println("DBtoAPIPage: " + s);
        String s1 = apiCallWithToken(s, _token);
        //System.out.println(s1);
        return s1;
    }

    //Calls Small and Furry url with user id parameters and specific Small and Furry page
    public static String callSmallFAPIPage(String _id, String _page, String _token) throws SQLException, IOException, JSONException {
        String s = DBToAPISmallF(_id, _page);
        System.out.println("DBtoAPIPage: " + s);
        String s1 = apiCallWithToken(s, _token);
        //System.out.println(s1);
        return s1;
    }

    //Calls Horse url with user id parameters and specific Horse page
    public static String callHorseAPIPage(String _id, String _page, String _token) throws SQLException, IOException, JSONException {
        String s = DBToAPIHorse(_id, _page);
        System.out.println("DBtoAPIPage: " + s);
        String s1 = apiCallWithToken(s, _token);
        //System.out.println(s1);
        return s1;
    }

    //Calls Barnyard url with user id parameters and specific Barnyard page
    public static String callBarnyardAPIPage(String _id, String _page, String _token) throws SQLException, IOException, JSONException {
        String s = DBToAPIBarnyard(_id, _page);
        System.out.println("DBtoAPIPage: " + s);
        String s1 = apiCallWithToken(s, _token);
        //System.out.println(s1);
        return s1;
    }

    public static String getApiToken() {
        return getToken();
    }
}
