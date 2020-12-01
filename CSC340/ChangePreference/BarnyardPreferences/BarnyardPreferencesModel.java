
package CSC340.ChangePreference.BarnyardPreferences;

/**
 * 
 * @author David Bowles 12/1/2020
 */

import CSC340.DB.PropertiesDBConnector;
import java.sql.SQLException;


public class BarnyardPreferencesModel {

    private String gender = "";
    private String age = "";
    private String size = "";

    private BarnyardPreferencesView theView;

    public BarnyardPreferencesModel(BarnyardPreferencesView _theView) {
        this.theView = _theView;
    }

    //Adds info to DB
    public void addToDB(String _id) throws SQLException {
        String preferances = gender + "," + age + "," + size;
        PropertiesDBConnector.updateUserInfoDB("BARNYARD_PARAMETERS", preferances, _id);
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
