package CSC340.APIParcer;

/**
 * Calls API and Formats Animal
 *
 * @author David Bowles 12/1/2020
 */
import static CSC340.APIParcer.Animal.formatAnimal;
import static CSC340.apiCall.PetFinderAPIController.callAPI;
import static CSC340.apiCall.PetFinderAPIController.callAPIPage;
import static CSC340.apiCall.PetFinderAPIController.callBarnyardAPIPage;
import static CSC340.apiCall.PetFinderAPIController.callBirdAPIPage;
import static CSC340.apiCall.PetFinderAPIController.callCatAPIPage;
import static CSC340.apiCall.PetFinderAPIController.callDogAPIPage;
import static CSC340.apiCall.PetFinderAPIController.callHorseAPIPage;
import static CSC340.apiCall.PetFinderAPIController.callRabbitAPIPage;
import static CSC340.apiCall.PetFinderAPIController.callScaleAPIPage;
import static CSC340.apiCall.PetFinderAPIController.callSmallFAPIPage;
import static CSC340.apiCall.PetFinderAPIController.getApiToken;
import java.io.IOException;
import java.sql.SQLException;
import org.json.JSONException;

public class AnimalController {

    //Calls a random animal with the parameters of the id
    public static Animal callAnimal(String _id) throws SQLException, IOException, JSONException {
        String animalSubString = callAPI(_id);
        System.out.println("Call Animal");
        Animal animal = formatAnimal(animalSubString);
        return animal;
    }

    //Calls a random animal with the parameters of the id and specific page
    public static Animal callAnimalPage(String _id, String _page, String _token) throws SQLException, IOException, JSONException {
        String animalSubString = callAPIPage(_id, _page, _token);
        System.out.println("Call Animal Page");
        Animal animal = formatAnimal(animalSubString);
        return animal;
    }

    //calls Dog 
    public static Animal callDogPage(String _id, String _page, String _token) throws SQLException, IOException, JSONException {
        String animalSubString = callDogAPIPage(_id, _page, _token);
        System.out.println("Call Animal Page");
        Animal animal = formatAnimal(animalSubString);
        return animal;
    }

    //calls Cat
    public static Animal callCatPage(String _id, String _page, String _token) throws SQLException, IOException, JSONException {
        String animalSubString = callCatAPIPage(_id, _page, _token);
        System.out.println("Call Animal Page");
        Animal animal = formatAnimal(animalSubString);
        return animal;
    }

    public static Animal callRabbitPage(String _id, String _page, String _token) throws SQLException, IOException, JSONException {
        String animalSubString = callRabbitAPIPage(_id, _page, _token);
        System.out.println("Call Animal Page");
        Animal animal = formatAnimal(animalSubString);
        return animal;
    }

    public static Animal callBirdPage(String _id, String _page, String _token) throws SQLException, IOException, JSONException {
        String animalSubString = callBirdAPIPage(_id, _page, _token);
        System.out.println("Call Animal Page");
        Animal animal = formatAnimal(animalSubString);
        return animal;
    }

    public static Animal callScalePage(String _id, String _page, String _token) throws SQLException, IOException, JSONException {
        String animalSubString = callScaleAPIPage(_id, _page, _token);
        System.out.println("Call Animal Page");
        Animal animal = formatAnimal(animalSubString);
        return animal;
    }

    public static Animal callSmallFPage(String _id, String _page, String _token) throws SQLException, IOException, JSONException {
        String animalSubString = callSmallFAPIPage(_id, _page, _token);
        System.out.println("Call Animal Page");
        Animal animal = formatAnimal(animalSubString);
        return animal;
    }

    public static Animal callHorsePage(String _id, String _page, String _token) throws SQLException, IOException, JSONException {
        String animalSubString = callHorseAPIPage(_id, _page, _token);
        System.out.println("Call Animal Page");
        Animal animal = formatAnimal(animalSubString);
        return animal;
    }

    public static Animal callBarnyardPage(String _id, String _page, String _token) throws SQLException, IOException, JSONException {
        String animalSubString = callBarnyardAPIPage(_id, _page, _token);
        System.out.println("Call Animal Page");
        Animal animal = formatAnimal(animalSubString);
        return animal;
    }

    //Retrives token for Api
    public static String getAnimalToken() {
        return getApiToken();
    }

}
