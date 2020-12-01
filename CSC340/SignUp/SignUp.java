package CSC340.SignUp;

/*
* The purpose of this class to use the model, the view, and the controller all in
* one.
* Last updated: 11/10/2020
* Author: Yngrid Corrales
 */
public class SignUp {

    public static void main(String[] args) {
        SignUpView theView = new SignUpView();
        SignUpModel theModel = new SignUpModel(theView);
        SignUpController theController = new SignUpController(theView, theModel);
        theView.setVisible(true);
    }
}
