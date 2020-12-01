package CSC340.apiCall;

/*
* The purpose of this class is to connect to the API
* Last updated: 12/1/2020
* Author: David Bowles
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class PetFinderAPIConnector implements PetFinderAPIConnectorface {

    //grabs token for OAuth2.0
    /**
     *
     * @return token
     */
    public static String getToken() {
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost("https://api.petfinder.com/v2/oauth2/token");
        String token = "";
        String clientID = "Zd59vsTWRs3lDnXER0z7tzIfV781lN5DyT7k4IFKqHF8WNS1PR";
        String clientSecret = "lWNEFV2h9b4QU6fqkBZV1rqtfoMC7jVPWnwsUgeg";

        try {

            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("grant_type", "client_credentials"));
            nameValuePairs.add(new BasicNameValuePair("client_id", clientID));
            nameValuePairs.add(new BasicNameValuePair("client_secret", clientSecret));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            //HTTP Request
            HttpResponse response = httpclient.execute(httppost);

            //JSON to string
            JSONObject json_auth = new JSONObject(EntityUtils.toString(response.getEntity()));
            token = json_auth.getString("access_token");
            //System.out.println(token);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return token;
    }

    //calls the api then returns it as a string
    /**
     *
     * @param apiUrl
     * @return
     * @throws IOException
     * @throws org.json.JSONException
     */
    public static String apiCall(String _parameters) throws IOException, JSONException {
        String token = getToken();
        ArrayList<String> list = new ArrayList<String>();
        String url = "";
        String animalString = "";

        url = "https://api.petfinder.com/v2/animals?" + _parameters;
        animalString = runApi(token, url);
        //System.out.println("List: " + animalString);
        return animalString;
    }

    public static String apiCallWithToken(String _parameters, String _token) throws IOException, JSONException {
        //String token = getToken();
        ArrayList<String> list = new ArrayList<String>();
        String url = "";
        String animalString = "";

        url = "https://api.petfinder.com/v2/animals?" + _parameters;
        System.out.println(url);
        animalString = runApi(_token, url);
        //System.out.println("List: " + animalString);
        return animalString;
    }

    public static String runApi(String _token, String _urlString) throws IOException, JSONException {

        URL url = new URL(_urlString);
        Map<String, String> myMap = new HashMap<String, String>();

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Authorization", "Bearer " + _token);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String output;

        StringBuffer apiResponse = new StringBuffer();
        while ((output = in.readLine()) != null) {
            apiResponse.append(output);
            System.out.println(apiResponse);
        }

        in.close();
        //apiResponse.

        return apiResponse.toString();
    }
}
