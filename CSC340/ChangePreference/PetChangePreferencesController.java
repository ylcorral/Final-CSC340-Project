package CSC340.ChangePreference;

/*
* The purpose of this class to have the view and the model connect to the controller
* which responds to buttons clicked from the user from the view.
* Last updated: 11/29/2020
* Author: David Bowles 
 */
import CSC340.ChangePreference.BirdPreferences.BirdPreferencesModel;
import CSC340.ChangePreference.BirdPreferences.BirdPreferencesController;
import CSC340.ChangePreference.BirdPreferences.BirdPreferencesView;
import CSC340.ChangePreference.CatPreferences.CatPreferencesController;
import CSC340.ChangePreference.CatPreferences.CatPreferencesModel;
import CSC340.ChangePreference.CatPreferences.CatPreferencesView;
import CSC340.ChangePreference.DogPreferences.DogPreferencesModel;
import CSC340.ChangePreference.DogPreferences.DogPreferencesController;
import CSC340.ChangePreference.DogPreferences.DogPreferencesView;
import CSC340.ChangePreference.HorsesPreferences.HorsesPreferencesController;
import CSC340.ChangePreference.HorsesPreferences.HorsesPreferencesView;
import CSC340.ChangePreference.HorsesPreferences.HorsesPreferencesModel;
import CSC340.ChangePreference.RabbitPreferences.RabbitPreferencesController;
import CSC340.ChangePreference.RabbitPreferences.RabbitPreferencesModel;
import CSC340.ChangePreference.RabbitPreferences.RabbitPreferencesView;
import CSC340.ChangePreference.ScalesAndOtherPreferences.ScalesAndOtherPreferencesView;
import CSC340.ChangePreference.ScalesAndOtherPreferences.ScalesAndOtherPreferencesModel;
import CSC340.ChangePreference.ScalesAndOtherPreferences.ScalesAndOtherPreferencesController;
import CSC340.ChangePreference.SmallAndFurryPreferences.SmallAndFurryPreferencesView;
import CSC340.ChangePreference.SmallAndFurryPreferences.SmallAndFurryPreferencesModel;
import CSC340.ChangePreference.SmallAndFurryPreferences.SmallAndFurryPreferencesController;
import CSC340.ChangePreference.BarnyardPreferences.BarnyardPreferencesView;
import CSC340.ChangePreference.BarnyardPreferences.BarnyardPreferencesModel;
import CSC340.ChangePreference.BarnyardPreferences.BarnyardPreferencesController;
import CSC340.InteractionPage.ImageModel;
import CSC340.InteractionPage.InteractionPageController;
import CSC340.InteractionPage.InteractionPageModel;
import CSC340.InteractionPage.InteractionPageView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PetChangePreferencesController {

    private PetChangePreferencesView theView;
    private PetChangePreferencesModel theModel;
    private String id;

    /* The Controller coordinates interactions between the view and model */
    public PetChangePreferencesController(PetChangePreferencesView _theView, PetChangePreferencesModel _theModel, String _id) {
        this.theView = _theView;
        this.theModel = _theModel;
        this.id = _id;

        /* This tells the view that when these buttons are clicked on, to execute the
         * actionPerformed methods created from the classes created below
         */
        this.theView.addSaveListiner(new saveListener());
        this.theView.addCancelListiner(new cancelListener());
        this.theView.addDogCheckListener(new dogListener());
        this.theView.addCatCheckListener(new catListener());
        this.theView.addRabbitsCheckListener(new rabbitListener());
//        this.theView.addScalesCheckListener(new scalesListener());
        this.theView.addBirdsCheckListener(new birdsListener());
//        this.theView.addSmallFCheckListener(new smallFListener());
        this.theView.addHorsesCheckListener(new horsesListener());
        this.theView.addBarnyardCheckListener(new barnyardListener());
        this.theView.addBarnyardParametersButtonListener(new barnyardPreferencesListener());
        this.theView.addDogParametersButtonListener(new dogPreferencesListener());
        this.theView.addCatParametersButtonListener(new catPreferencesListener());
        this.theView.addRabbitParametersButtonListener(new rabbitPreferencesListener());
//        this.theView.addScalesParametersButtonListener(new scalesAndOtherPreferencesListener());
        this.theView.addBirdsParametersButtonListener(new birdPreferencesListener());
//        this.theView.addSmallFParametersButtonListener(new samllAndFurryPreferencesListener());
        this.theView.addHorsesParametersButtonListener(new horsesPreferencesListener());
    }

    public String getId() {
        return id;
    }

    /* When the cancel button is clicked, go to the Interaction page view */
    class cancelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            ImageModel imageModel = new ImageModel();
            InteractionPageView theView = new InteractionPageView(imageModel);
            InteractionPageModel theModel = new InteractionPageModel(theView, imageModel);
            InteractionPageController theController = new InteractionPageController(theView, theModel, getId());

            theView.setVisible(true);
        }
    }

    /* When the save button is clicked, it saves all changes the user made */
    class saveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (theModel.emptyRadius(theView.getRadius())) {
            } else if (theModel.emptyZip(theView.getZipCode())) {
            } else if (theModel.inValidZip(theView.getZipCode())) {
            } else if (theModel.outOfBoundsRadius(theView.getRadius())) {

            } else {
                try {
                    theModel.zipCodeAndRadius(theView.getZipCode(), theView.getRadius());
                    theModel.addToDB(getId());
                } catch (Exception ex) {
                    System.out.println("Error" + ex);
                }

                theView.dispose();
                ImageModel imageModel = new ImageModel();
                InteractionPageView theView = new InteractionPageView(imageModel);
                InteractionPageModel theModel = new InteractionPageModel(theView, imageModel);
                InteractionPageController theController = new InteractionPageController(theView, theModel, getId());
                theView.setVisible(true);

            }
        }
    }

    /* When the edit dog parameters button is clicked, go to the Dog preference view */
    class dogPreferencesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            DogPreferencesView theView = new DogPreferencesView();
            DogPreferencesModel theModel = new DogPreferencesModel(theView);
            DogPreferencesController theController = new DogPreferencesController(theView, theModel, getId());
            theView.setVisible(true);
        }
    }

    /* When the edit cat parameters button is clicked, go to the Cat preference view */
    class catPreferencesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            CatPreferencesView theView = new CatPreferencesView();
            CatPreferencesModel theModel = new CatPreferencesModel(theView);
            CatPreferencesController theController = new CatPreferencesController(theView, theModel, getId());
            theView.setVisible(true);
        }
    }

    /* When the edit bird parameters button is clicked, go to the Bird preference view */
    class birdPreferencesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            BirdPreferencesView theView = new BirdPreferencesView();
            BirdPreferencesModel theModel = new BirdPreferencesModel(theView);
            BirdPreferencesController theController = new BirdPreferencesController(theView, theModel, getId());
            theView.setVisible(true);
        }
    }

    /* When the edit horse parameters button is clicked, go to the Horse preference view */
    class horsesPreferencesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            HorsesPreferencesView theView = new HorsesPreferencesView();
            HorsesPreferencesModel theModel = new HorsesPreferencesModel(theView);
            HorsesPreferencesController theController = new HorsesPreferencesController(theView, theModel, getId());
            theView.setVisible(true);
        }
    }

    /* When the edit Rabbit parameters button is clicked, go to the Rabbit preference view */
    class rabbitPreferencesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            RabbitPreferencesView theView = new RabbitPreferencesView();
            RabbitPreferencesModel theModel = new RabbitPreferencesModel(theView);
            RabbitPreferencesController theController = new RabbitPreferencesController(theView, theModel, getId());
            theView.setVisible(true);
        }
    }

    /* When the edit scales parameters button is clicked, go to the ScalesAndOthers preference view */
    class scalesAndOtherPreferencesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            ScalesAndOtherPreferencesView theView = new ScalesAndOtherPreferencesView();
            ScalesAndOtherPreferencesModel theModel = new ScalesAndOtherPreferencesModel(theView);
            ScalesAndOtherPreferencesController theController = new ScalesAndOtherPreferencesController(theView, theModel, getId());
            theView.setVisible(true);
        }
    }

    /* When the edit barnyard parameters button is clicked, go to the Barnyard preference view */
    class barnyardPreferencesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            BarnyardPreferencesView theView = new BarnyardPreferencesView();
            BarnyardPreferencesModel theModel = new BarnyardPreferencesModel(theView);
            BarnyardPreferencesController theController = new BarnyardPreferencesController(theView, theModel, getId());
            theView.setVisible(true);
        }
    }

    /* When the edit parameters button is clicked, go to the SmallAndFurry preference view */
    class samllAndFurryPreferencesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            SmallAndFurryPreferencesView theView = new SmallAndFurryPreferencesView();
            SmallAndFurryPreferencesModel theModel = new SmallAndFurryPreferencesModel(theView);
            SmallAndFurryPreferencesController theController = new SmallAndFurryPreferencesController(theView, theModel, getId());
            theView.setVisible(true);
        }
    }

    /* When the dogs checkbox is clicked, excute the method in the model */
    class dogListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String dog = " Dog ";
            try {
                theModel.animalSelected(dog);

            } catch (NullPointerException ex) {
                System.out.println("Error" + ex);
            }
        }
    }

    /* When the cats checkbox is clicked, excute the method in the model */
    class catListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String cat = " Cat ";
            try {
                theModel.animalSelected(cat);

            } catch (Exception ex) {
                System.out.println("Error" + ex);
            }
        }
    }

    /* When the rabbits checkbox is clicked, excute the method in the model */
    class rabbitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String rabbit = " Rabbit ";
            try {

                theModel.animalSelected(rabbit);

            } catch (Exception ex) {
                System.out.println("Error" + ex);
            }
        }
    }

    /* When the Scales, Fins & Other checkbox is clicked, excute the method in the model */
    class scalesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String scales = " Scales, Fins & Other ";
            try {
                theModel.animalSelected(scales);

            } catch (Exception ex) {
                System.out.println("Error" + ex);
            }
        }
    }

    /* When the birds checkbox is clicked, excute the method in the model */
    class birdsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String birds = " Bird ";
            try {
                theModel.animalSelected(birds);

            } catch (Exception ex) {
                System.out.println("Error" + ex);
            }
        }
    }

    /* When the small & furry checkbox is clicked, excute the method in the model */
    class smallFListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String smallF = " Small & Furry ";
            try {
                theModel.animalSelected(smallF);

            } catch (Exception ex) {
                System.out.println("Error" + ex);
            }
        }
    }

    /* When the horses checkbox is clicked, excute the method in the model */
    class horsesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String horse = " Horse ";
            try {
                theModel.animalSelected(horse);

            } catch (Exception ex) {
                System.out.println("Error" + ex);
            }
        }
    }

    /* When the barnyard checkbox is clicked, excute the method in the model */
    class barnyardListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String barnyard = " Barnyard ";
            try {
                theModel.animalSelected(barnyard);

            } catch (Exception ex) {
                System.out.println("Error" + ex);
            }
        }
    }

}
