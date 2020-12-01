package CSC340.LogIn;

/*
* The purpose of this class to grab data from login database, where the user
* inserts their information and is granted access or not.
* Last updated: 11/17/2020
* Author: Yngrid Corrales
 */
import static CSC340.DB.DBController.getIDController;
import static CSC340.DB.DBController.loginUserDB;
import java.sql.SQLException;

public class LoginModel {

    /* The Model coordinates interactions with the view */
    private LoginView theView;

    public LoginModel(LoginView _theView) {
        this.theView = _theView;
    }

    /* This method grabs data from login database and checks to see if user exists */
    public boolean checkDB(String _email, String _password) throws SQLException {

        /* Checks to see if the email and password inserted matches the database */
        boolean login = loginUserDB(_email, _password);
        if (login == false) {

            theView.displayLoginUnsuccessful("Login Failed... Please type in your information");
            return false;

        } else if (login == true) {

            theView.displayLoginSuccessful("Login Successful");
            return true;

        } else {

            theView.displayLoginUnsuccessful("Login Failed..");
            return false;
        }

    }

    public String getLoginID(String _email) throws SQLException {
        String id;
        id = getIDController(_email);
        return id;
    }
}
