
package CSC340.ChangePreference.BirdPreferences;

/**
 * 12/1/2020
 * BirdPreferences Model
 * @author David Bowles
 */

import CSC340.DB.PropertiesDBConnector;
import java.sql.SQLException;


public class BirdPreferencesModel {

    private String gender = "";
    private String age = "";
    private String size = "";

    private BirdPreferencesView theView;

    public BirdPreferencesModel(BirdPreferencesView _theView) {
        this.theView = _theView;
    }
    //Adds info to DB

    public void addToDB(String id) throws SQLException {
        String preferances = gender + "," + age + "," + size;

        PropertiesDBConnector.updateUserInfoDB("BIRD_PARAMETERS", preferances, id);
    }

    public void genderSelected(String _gender) {
        gender = gender + _gender;
    }

    public void ageSelected(String _age) {
        age = age + _age;
    }

    public void sizeSelected(String _size) {
        size = size + _size;
    }
}
