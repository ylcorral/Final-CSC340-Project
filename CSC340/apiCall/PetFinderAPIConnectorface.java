/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.apiCall;

/**
 * Interface for API Call
 *
 * @author David Bowles 12/1/2020
 */
import java.io.IOException;
import org.json.JSONException;

public interface PetFinderAPIConnectorface {

    //get Token
    public static String getToken() {
        return null;
    }

    //get apiCall
    public static String apiCall(String _urlString) throws IOException, JSONException {
        return null;
    }
}
