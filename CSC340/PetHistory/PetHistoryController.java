package CSC340.PetHistory;

/*
* The purpose of this class to have the view and the model connect to the controller
* which responds to buttons clicked from the user from the view.
* Last updated: 11/23/2020
* Author: Yngrid Corrales
 */
import CSC340.APIParcer.Animal;
import static CSC340.APIParcer.Animal.callAnimal;
import CSC340.ChangePreference.PetChangePreferencesController;
import CSC340.ChangePreference.PetChangePreferencesModel;
import CSC340.ChangePreference.PetChangePreferencesView;
import static CSC340.DB.DBController.getFavoritesAnimalList;
import CSC340.InteractionPage.ImageModel;
import CSC340.InteractionPage.InteractionPageController;
import CSC340.InteractionPage.InteractionPageModel;
import CSC340.InteractionPage.InteractionPageView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;

public class PetHistoryController {

    private PetHistoryView theView;
    private PetHistoryModel theModel;
    private String id;
    private ArrayList<Animal> animalList;
    
    /* The Controller coordinates interactions between the view and model */
    public PetHistoryController(PetHistoryView _theView,PetHistoryModel _theModel, String _id, ArrayList<Animal> _animalList) throws SQLException {
        this.animalList = _animalList;
        this.theView = _theView;
        this.theModel= _theModel;
        this.id = _id;
        this.theView.addBackListener(new backListener());
        this.theView.addUpdateListener(new updateListener());
        this.theView.addPreviousListener(new previousListener());
        this.theView.addNextListener(new nextListener());
        this.animalList = _animalList;
        
        theModel.setAnimalList(_animalList);
        theModel.setFavorites();
    }

    /* When the back to home page button is clicked, go back to the InteractionPage view */
    class backListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

           
                theView.dispose();
                    ImageModel imageModel =  new ImageModel();
                    InteractionPageView theView = new InteractionPageView(imageModel);
                    InteractionPageModel theModel = new InteractionPageModel(theView,imageModel);
                InteractionPageController theController = new InteractionPageController(theView, theModel, getId());
                theView.setVisible(true);
            
            
        }
    }

    /* When the update preference button is clicked, go to the PetChangePreferences view */
    class updateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            PetChangePreferencesView theView = new PetChangePreferencesView();
            PetChangePreferencesModel theModel = new PetChangePreferencesModel(theView);
            PetChangePreferencesController theController = new PetChangePreferencesController(theView,theModel,getId());
            theView.setVisible(true);
        }

    }

    class previousListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            theModel.previous();
            try {
                theModel.setFavorites();
            } catch (SQLException ex) {
                Logger.getLogger(PetHistoryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    class nextListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            theModel.next();
            try {
                theModel.setFavorites();
            } catch (SQLException ex) {
                Logger.getLogger(PetHistoryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
