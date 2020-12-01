
package CSC340.ChangePreference.CatPreferences;

/**
 * 12/1/2020
 * @author David Bowles
 */

import CSC340.ChangePreference.PetChangePreferencesController;
import CSC340.ChangePreference.PetChangePreferencesModel;
import CSC340.ChangePreference.PetChangePreferencesView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CatPreferencesController {

    private CatPreferencesView theView;
    private CatPreferencesModel theModel;
    private String id;

    public CatPreferencesController(CatPreferencesView theView, CatPreferencesModel theModel, String _id) {
        this.theView = theView;
        this.theModel = theModel;
        this.id = _id;

        this.theView.addSaveListiner(new saveListener());
        this.theView.addCancelListiner(new cancelListener());
        this.theView.addMaleListiner(new maleListener());
        this.theView.addFemaleListiner(new femaleListener());
//        this.theView.addBabyListiner(new babyListener());
//        this.theView.addYoungListiner(new youngListener());
//        this.theView.addAdultListiner(new adultListener());
//        this.theView.addSeniorListiner(new seniorListener());
//        this.theView.addSmallListiner(new smallListener());
//        this.theView.addMediumListiner(new mediumListener());
//        this.theView.addLargeListiner(new largeListener());
//        this.theView.addXLargeListiner(new xLargeListener());

        System.out.println("Activated Listeners");
    }

    class saveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                theModel.addToDB(getId());
                theView.dispose();
                PetChangePreferencesView theView = new PetChangePreferencesView();
                PetChangePreferencesModel theModel = new PetChangePreferencesModel(theView);
                PetChangePreferencesController theController = new PetChangePreferencesController(theView, theModel, getId());
                theView.setVisible(true);
            } catch (Exception ex) {
                System.out.println("Error" + ex);
            }
        }
    }

    class cancelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            PetChangePreferencesView theView = new PetChangePreferencesView();
            PetChangePreferencesModel theModel = new PetChangePreferencesModel(theView);
            PetChangePreferencesController theController = new PetChangePreferencesController(theView, theModel, getId());
            theView.setVisible(true);
        }
    }

    class maleListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String male = "Male ";
            try {
                theModel.genderSelected(male);

            } catch (NullPointerException ex) {
                System.out.println("Error" + ex);
            }
        }
    }

    class femaleListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String female = "Female ";
            try {
                theModel.genderSelected(female);

            } catch (NullPointerException ex) {
                System.out.println("Error" + ex);
            }
        }
    }

    class babyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String baby = "Baby ";
            try {
                theModel.ageSelected(baby);

            } catch (NullPointerException ex) {
                System.out.println("Error" + ex);
            }
        }
    }

    class youngListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String young = "Young ";
            try {
                theModel.ageSelected(young);

            } catch (NullPointerException ex) {
                System.out.println("Error" + ex);
            }
        }
    }

    class adultListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String adult = "Adult ";
            try {
                theModel.ageSelected(adult);

            } catch (NullPointerException ex) {
                System.out.println("Error" + ex);
            }
        }
    }

    class seniorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String senior = "Senior ";
            try {
                theModel.ageSelected(senior);

            } catch (NullPointerException ex) {
                System.out.println("Error" + ex);
            }
        }
    }

    class smallListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String small = "Small ";
            try {
                theModel.sizeSelected(small);

            } catch (NullPointerException ex) {
                System.out.println("Error" + ex);
            }
        }
    }

    class mediumListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String medium = "Medium ";
            try {
                theModel.sizeSelected(medium);

            } catch (NullPointerException ex) {
                System.out.println("Error" + ex);
            }
        }
    }

    class largeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String large = "Large ";
            try {
                theModel.sizeSelected(large);

            } catch (NullPointerException ex) {
                System.out.println("Error" + ex);
            }
        }
    }

    class xLargeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String xLarge = "XLarge ";
            try {
                theModel.sizeSelected(xLarge);

            } catch (NullPointerException ex) {
                System.out.println("Error" + ex);
            }
        }
    }

    public String getId() {
        return id;
    }

}
