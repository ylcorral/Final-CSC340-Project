package CSC340.LogIn;

/*
* The purpose of this class to use the model, the view, and the controller all in
* one.
* Last updated: 11/10/2020
* Author: Yngrid Corrales
 */

public class LogIn {

    public static void main(String[] args) {
        LoginView theView = new LoginView();
        LoginModel theModel = new LoginModel(theView);
        LoginController theController = new LoginController(theView, theModel);
        theView.setVisible(true);
    }
}
