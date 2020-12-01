package CSC340.prototype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * DJ Bowles
 * API prototype
 */
public class apiPrototype {

    //main class calls get request for API
    public static void main(String[] args) throws IOException {
        apiGetPrototype();
    }

    //getToken aquires the berar authentication token 
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

            //HTTP Post Request
            HttpResponse response = httpclient.execute(httppost);

            //JSON to string
            JSONObject json_auth = new JSONObject(EntityUtils.toString(response.getEntity()));
            token = json_auth.getString("access_token");
            System.out.println(token);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return token;
    }
    
    //calls get request from prototype and puts authorizationtoken on teh Http Header.
    public static void apiGetPrototype() throws IOException {//String token, String catagory, String action) throws IOException {

        String token = getToken();
        URL url = new URL("https://api.petfinder.com/v2/animals?type=dog&page=2");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestProperty("Authorization", "Bearer " + token);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String output;

        StringBuffer apiResponse = new StringBuffer();
        while ((output = in.readLine()) != null) {
            apiResponse.append(output);
        }

        in.close();
        // printing result from response
        System.out.println(apiResponse.toString());

    }
}
