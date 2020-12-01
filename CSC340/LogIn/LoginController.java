package CSC340.LogIn;

/*
* The purpose of this class to have the view and the model connect to the controller
* which responds to buttons clicked from the user from the view.
* Last updated: 11/18/2020
* Author: Yngrid Corrales
 */
import static CSC340.APIParcer.Animal.callAnimal;
import CSC340.InteractionPage.ImageModel;
import CSC340.InteractionPage.InteractionPageController;
import CSC340.InteractionPage.InteractionPageModel;
import CSC340.InteractionPage.InteractionPageView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import CSC340.SignUp.SignUpController;
import CSC340.SignUp.SignUpModel;
import CSC340.SignUp.SignUpView;

public class LoginController {

    private LoginView theView;
    private LoginModel theModel;

    /* The Controller coordinates interactions between the view and model */
    public LoginController(LoginView _theView, LoginModel _theModel) {

        this.theView = _theView;
        this.theModel = _theModel;

        /* This tells the view that when these buttons are clicked on, to execute the
         * actionPerformed methods created from the classes created below
         */
        this.theView.addsignInListener(new signInListener());
        this.theView.addsignUpListener(new signUpListener());
    }

    /* When the sign in button is clicked, excute the methods in the model and
     * if successful display interaction page
     */
    class signInListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String email;
            String password;

            try {
                email = theView.getEmail();
                password = theView.getPassword();
                Boolean checkDB = theModel.checkDB(email, password);
                if (checkDB == true) {

                    String id = theModel.getLoginID(email);
                    theView.dispose();
                    ImageModel imageModel = new ImageModel();
                    InteractionPageView theView = new InteractionPageView(imageModel);
                    InteractionPageModel theModel = new InteractionPageModel(theView, imageModel);
                    InteractionPageController theController = new InteractionPageController(theView, theModel, id);
                    theView.setVisible(true);
                }
            } catch (Exception ex) {
                System.out.println("Error" + ex);
            }

        }
    }

    /* When the sign up button is clicked, show the signup view */
    class signUpListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            SignUpView theView = new SignUpView();
            SignUpModel theModel = new SignUpModel(theView);
            SignUpController theController = new SignUpController(theView, theModel);
            theView.setVisible(true);
        }

    }
}
