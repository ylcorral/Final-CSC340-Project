package CSC340.apiCall;

/**
 * Api Interface
 *
 * @author David Bowles 12/1/2020
 */
import java.io.IOException;
import org.json.JSONException;

public interface PetFinderAPIInterface {

    //adds parameter to url  
    public String addParameter(String _apiUrl, String _parameter, String _value);

    //deletes parameter on url
    public String deleteParameter(String _apiUrl, String _parameter, String _value);

    //changes parameter on url
    public String changeValue(String _apiUrl, String _parameter, String _value1, String _value2);

    //loads parameter on url
    public String loadAPI(String _urlString) throws IOException, JSONException;
}
