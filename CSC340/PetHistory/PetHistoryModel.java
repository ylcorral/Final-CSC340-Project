/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSC340.PetHistory;

/**
 * PetHistoryModel
 *
 * @author David Bowles 12/1/2020
 */

import CSC340.APIParcer.Animal;
import CSC340.DB.DBController;
import static CSC340.DB.DBController.getFavoritesAnimalList;
import java.sql.SQLException;
import java.util.ArrayList;

public class PetHistoryModel {

    ArrayList<Animal> animalList = new ArrayList<Animal>();
    int animalListLength;
    int animalListIndex = 0;

    private PetHistoryView theView;

    public PetHistoryModel(PetHistoryView _theView) {
        this.theView = _theView;
    }

    public void setFavorites() throws SQLException {
        animalListLength = animalList.size();
        int length;
        if (animalListIndex + 4 < animalListLength) {
            length = animalListIndex + 4;
        } else {
            length = animalList.size();
        }
        String name = "";
        String type = "";
        String breed = "";
        String contact = "";

        theView.setPetNameLabel("");
        theView.setBreedinfoLabel("");
        theView.setTypeinfoLabel("");
        theView.setContactinfoLabel("");

        theView.setPetName2Label("");
        theView.setBreedinfo2Label("");
        theView.setTypeinfo2Label("");
        theView.setContactinfo2Label("");

        theView.setPetName3Label("");
        theView.setBreedinfo3Label("");
        theView.setTypeinfo3Label("");
        theView.setContactinfo3Label("");

        theView.setPetName4Label("");
        theView.setBreedinfo4Label("");
        theView.setTypeinfo4Label("");
        theView.setContactinfo4Label("");

        for (int i = animalListIndex; i < length; i++) {
            if (i % 4 == 0) {
                theView.setPetNameLabel(animalList.get(i).getName());
                theView.setBreedinfoLabel(animalList.get(i).getBreeds());
                theView.setTypeinfoLabel(animalList.get(i).getType());
                theView.setContactinfoLabel(animalList.get(i).getContact());
            }
            if (i % 4 == 1) {
                theView.setPetName2Label(animalList.get(i).getName());
                theView.setBreedinfo2Label(animalList.get(i).getBreeds());
                theView.setTypeinfo2Label(animalList.get(i).getType());
                theView.setContactinfo2Label(animalList.get(i).getContact());
            }
            if (i % 4 == 2) {
                theView.setPetName3Label(animalList.get(i).getName());
                theView.setBreedinfo3Label(animalList.get(i).getBreeds());
                theView.setTypeinfo3Label(animalList.get(i).getType());
                theView.setContactinfo3Label(animalList.get(i).getContact());
            }
            if (i % 4 == 3) {
                theView.setPetName4Label(animalList.get(i).getName());
                theView.setBreedinfo4Label(animalList.get(i).getBreeds());
                theView.setTypeinfo4Label(animalList.get(i).getType());
                theView.setContactinfo4Label(animalList.get(i).getContact());
            }
        }
    }

    public void previous() {
        if (animalListIndex - 4 < 0) {
        } else {
            //System.out.println("previous initiated");
            animalListIndex = animalListIndex - 4;
        }
    }

    public void next() {
        //System.out.println("Next animalListIndex: " +animalListIndex+ " animalListLength: "+animalListLength+" , "+animalListLength / 4.0+" "+ (animalListIndex + 4) / 4.0);
        if ((animalListIndex + 4) / 4.0 > animalListLength / 4.0) {
        } else {
            //System.out.println("next initiated");
            animalListIndex = animalListIndex + 4;
        }
    }

    public int getAnimalListIndex() {
        return animalListIndex;
    }

    public void setAnimalListIndex(int _animalListIndex) {
        this.animalListIndex = _animalListIndex;
    }

    public int getAnimalListLength() {
        return animalListLength;
    }

    public void setAnimalListLength(int _animalListLength) {
        this.animalListLength = _animalListLength;
    }

    public ArrayList<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(ArrayList<Animal> _animalList) {
        this.animalList = _animalList;
    }

}
