
package CSC340.ChangePreference.CatPreferences;

import CSC340.DB.PropertiesDBConnector;
import java.sql.SQLException;

/**
 * 12/1/2020
 * @author David Bowles
 */
public class CatPreferencesModel {

    String gender = "";
    String age = "";
    String size = "";

    private CatPreferencesView theView;

    public CatPreferencesModel(CatPreferencesView _theView) {
        this.theView = _theView;
    }

    //Adds info to DB
    public void addToDB(String id) throws SQLException {
        String preferances = gender + "," + age + "," + size;

        PropertiesDBConnector.updateUserInfoDB("CAT_PARAMETERS", preferances, id);
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
