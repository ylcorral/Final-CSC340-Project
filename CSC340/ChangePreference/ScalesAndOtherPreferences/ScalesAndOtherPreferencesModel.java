package CSC340.ChangePreference.ScalesAndOtherPreferences;

/**
 * 12/1/2020
 *
 * @author David Bowles
 */
import CSC340.DB.PropertiesDBConnector;
import java.sql.SQLException;

public class ScalesAndOtherPreferencesModel {

    String gender = "";
    String age = "";
    String size = "";

    private ScalesAndOtherPreferencesView theView;

    public ScalesAndOtherPreferencesModel(ScalesAndOtherPreferencesView _theView) {
        this.theView = _theView;
    }

    //Adds info to DB
    public void addToDB(String id) throws SQLException {
        String preferances = gender + "," + age + "," + size;

        PropertiesDBConnector.updateUserInfoDB("SCALES_PARAMETERS", preferances, id);
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
