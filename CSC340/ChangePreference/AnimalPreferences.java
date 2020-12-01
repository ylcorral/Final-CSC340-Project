package CSC340.ChangePreference;

/*
* The purpose of this class to use the model, the view, and the controller all in
* one.
* Last updated: 11/24/2020
* Author: Yngrid Corrales
 */
public class AnimalPreferences {

    public static void main(String[] args) {
        PetChangePreferencesView theView = new PetChangePreferencesView();
        PetChangePreferencesModel theModel = new PetChangePreferencesModel(theView);
        // PetChangePreferencesController theController = new PetChangePreferencesController(theView,theModel);
        theView.setVisible(true);
    }

}
