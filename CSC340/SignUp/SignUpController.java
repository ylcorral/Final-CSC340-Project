package CSC340.SignUp;

/*
* The purpose of this class to have the view and the model connect to the controller
* which responds to buttons clicked from the user from the view.
* Last updated: 11/28/2020
* Author: Yngrid Corrales
 */
import static CSC340.APIParcer.Animal.callAnimal;
import CSC340.InteractionPage.ImageModel;
import CSC340.InteractionPage.InteractionPageController;
import CSC340.InteractionPage.InteractionPageModel;
import CSC340.InteractionPage.InteractionPageView;
import CSC340.LogIn.LoginController;
import CSC340.LogIn.LoginModel;
import java.awt.event.ActionEvent;
import CSC340.LogIn.LoginView;
import java.awt.event.ActionListener;

public class SignUpController {

    private SignUpView theView;
    private SignUpModel theModel;

    /* The Controller coordinates interactions between the view and model */
    public SignUpController(SignUpView _theView, SignUpModel _theModel) {
        this.theView = _theView;
        this.theModel = _theModel;

        /*This runs the test case */
        //theModel.testCaseSearchDistance();
        /* This tells the view that when these buttons are clicked on, to execute the
         * actionPerformed methods created from the classes created below
         */
        this.theView.addBackListener(new backListener());
        this.theView.addSignUpListener(new signUpListener());
        this.theView.addCancelListener(new cancelListener());
        this.theView.addDogListener(new dogListener());
        this.theView.addCatListener(new catListener());
        this.theView.addBirdsListener(new birdsListener());
        this.theView.addRabbitsListener(new rabbitListener());
        this.theView.addHorsesListener(new horsesListener());
        this.theView.addBarnyardListener(new barnyardListener());
    }

    /* When the back button is clicked, go back to the login view */
    class backListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            LoginView theView = new LoginView();
            LoginModel theModel = new LoginModel(theView);
            LoginController theController = new LoginController(theView, theModel);
            theView.setVisible(true);
        }
    }


    /* When the sign up button is clicked, excute the methods in the model */
    class signUpListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            /* The theView.getTypes() are the getter and setters that were created
             * in the view class to get the user info
             */
            if (theModel.emptyFirstName(theView.getFirstName())) {
            } else if (theModel.emptyLastName(theView.getLastName())) {
            } else if (theModel.emptyPhoneNo(theView.getPhoneNo())) {
            } else if (theModel.emptyZip(theView.getZipCode())) {
            } else if (theModel.emptyRadius(theView.getRadius())) {
            } else if (theModel.emptyPass(theView.getPassword())) {
            } else if (theModel.emptyRePass(theView.getRePass())) {
            } else if (theModel.emailExists(theView.getEmail())) {
            } else if (theModel.inValidZip(theView.getZipCode())) {
            } else if (theModel.outOfBoundsRadius(theView.getRadius())) {
            } else if (theModel.validEmail(theView.getEmail())) {
            } else if (theModel.noMatch(theView.getPassword(), theView.getRePass())) {
            } else {
                try {
                    theModel.emailPhoneNo(theView.getEmail(), theView.getPhoneNo());
                    theModel.firstAndLastName(theView.getFirstName(), theView.getLastName());
                    theModel.passAndRePass(theView.getPassword(), theView.getRePass());
                    theModel.zipCodeAndRadius(theView.getZipCode(), theView.getRadius());
                    theModel.addToDB();
                    String id = theModel.getSignUpID(theView.getEmail());
                    /* This will display the Interaction page and it's features */
                    theView.dispose();
                    ImageModel imageModel = new ImageModel();
                    InteractionPageView theView = new InteractionPageView(imageModel);
                    InteractionPageModel theModel = new InteractionPageModel(theView, imageModel);
                    InteractionPageController theController = new InteractionPageController(theView, theModel, id);
                    theView.setVisible(true);
                } catch (Exception ex) {
                    System.out.println("Error" + ex);
                }
            }
        }
    }

    /* When the cancel button is clicked, exit */
    class cancelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();

        }
    }

    /* When the dogs checkbox is clicked, excute the method in the model */
    class dogListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String dog = " Dog ";
            theModel.animalSelected(dog);

        }
    }


    /* When the cats checkbox is clicked, excute the method in the model */
    class catListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String cat = " Cat ";
            theModel.animalSelected(cat);

        }
    }

    /* When the rabbits checkbox is clicked, excute the method in the model */
    class rabbitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String rabbit = " Rabbit ";
            theModel.animalSelected(rabbit);

        }
    }

    /* When the birds checkbox is clicked, excute the method in the model */
    class birdsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String birds = " Bird ";
            theModel.animalSelected(birds);

        }
    }


    /* When the horses checkbox is clicked, excute the method in the model */
    class horsesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String horse = " Horse ";
            theModel.animalSelected(horse);

        }
    }

    /* When the barnyard checkbox is clicked, excute the method in the model */
    class barnyardListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String barnyard = " Barnyard ";
            theModel.animalSelected(barnyard);

        }
    }
}
