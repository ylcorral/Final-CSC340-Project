package CSC340.apiCall;

/*
* The purpose of this class Create methods to change the url parameters 
* Last updated: 12/1/2020
* Author: David Bowles
 */
import static CSC340.apiCall.PetFinderAPIConnector.getToken;
import static CSC340.apiCall.PetFinderAPIConnector.runApi;
import java.io.IOException;
import org.json.JSONException;

public class PetFinderAPI implements PetFinderAPIInterface {

    //adds a parameter and value to the url
    public String addParameter(String _apiUrl, String _parameter, String _value) {
        String urlString = _apiUrl;
        urlString = urlString + "&" + _parameter + "=" + _value;
        _apiUrl = urlString;
        return _apiUrl;
    }

    //deletes the parameter and value out of the url
    @Override
    public String deleteParameter(String _apiUrl, String _parameter, String _value) {
        String urlString = _apiUrl;
        String remove = "&" + _parameter + "=" + _value;
        String replace = urlString.replace(remove, "");
        _apiUrl = replace;
        return _apiUrl;
    }

    //cahnges a value for a specific parameter
    @Override
    public String changeValue(String _apiUrl, String _parameter, String _value1, String _value2) {
        String urlString = _apiUrl;
        String replace = urlString.replace(_value1, _value2);
        _apiUrl = replace;
        return _apiUrl;
    }

    public String loadAPI(String _apiUrl) throws IOException, JSONException {
        String s;
        s = runApi(getToken(), _apiUrl);
        return s;
    }

    public Boolean conatinsParameter(String _apiUrl, String _parameter) {
        if (_parameter.contains(_apiUrl)) {
            return true;
        } else {
            return false;
        }

        //public void addPetType(String value){
        //  if(value=="Rabbit"||value=="Bird"||value=="Dog"||value=="Cat"||value=="Small & Furry"||value=="Horse"||value=="Barnyard"){
        //       addParameter("types", value);
        //   }
        //   else{
        //   }
        //}
    }
}
