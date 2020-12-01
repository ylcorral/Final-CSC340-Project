package CSC340.InteractionPage;

/*
* The purpose of this class is to display and save the animals description
* based on the api
* pets.
* Last updated: 11/25/2020
* Authors: Yngrid Corrales & David Bowles
 */
import CSC340.APIParcer.Animal;
import static CSC340.APIParcer.AnimalController.*;
import CSC340.DB.DBController;
import static CSC340.DB.DBFactory.getAnimalTypeList;
import java.awt.Image;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import org.json.JSONException;

public class InteractionPageModel {

    private Animal animal;
    private Image image = null;
    private String info;
    private int dogPageNum = 1;
    private int catPageNum = 1;
    private int rabbitPageNum = 1;
    private int birdPageNum = 1;
    private int scalesPageNum = 1;
    private int smallFPageNum = 1;
    private int horsePageNum = 1;
    private int barnyardPageNum = 1;

    private ImageModel imageModel;
    private InteractionPageController theController;
    private InteractionPageView theView;
    private ArrayList<String> animalTypes;

    public InteractionPageModel(InteractionPageView _theView, ImageModel _imageModel) {
        this.theView = _theView;
        this.imageModel = _imageModel;

    }

    public ArrayList<String> getAnimalTypes() {
        return animalTypes;
    }

    public void setAnimalTypes(ArrayList<String> _animalTypes) {
        this.animalTypes = _animalTypes;
    }

    //private LoginController theController;
    public void addToDB(String id) throws SQLException {
        HashMap<String, String> animalMap = Animal.animalToHashMap(animal, id);
        DBController.addToFavoritesDB(animalMap);
    }

    public void nextAnimal(String _id, String _token) throws SQLException, IOException, JSONException {
        String animalType = "";
        Animal animal = null;
        Random rand = new Random();
        if (animalTypes == null) {
            animalTypes = getAnimalTypeList(_id);
        }
        try {
            int randomInt = rand.nextInt(animalTypes.size());
            animalType = animalTypes.get(randomInt);
            if (animalType.contains("Dog")) {
                animal = callDogPage(_id, Integer.toString(dogPageNum), _token);
                if (Integer.parseInt(animal.getTotal_count()) == 0) {
                    animalTypes.remove("Rabbit");
                    nextAnimal(_id, _token);
                } else {
                    if (dogPageNum < Integer.parseInt(animal.getTotal_pages())) {
                        dogPageNum++;
                    } else {
                        animalTypes.remove("Dog");
                    }
                }
            }
            if (animalType.contains("Cat")) {
                animal = callCatPage(_id, Integer.toString(catPageNum), _token);
                if (Integer.parseInt(animal.getTotal_count()) == 0) {
                    animalTypes.remove("Rabbit");
                    nextAnimal(_id, _token);
                } else {
                    if (catPageNum < Integer.parseInt(animal.getTotal_pages())) {
                        catPageNum++;
                    } else {
                        animalTypes.remove("Cat");
                    }
                }
            }
            if (animalType.contains("Rabbit")) {
                animal = callRabbitPage(_id, Integer.toString(rabbitPageNum), _token);
                if (Integer.parseInt(animal.getTotal_count()) == 0) {
                    animalTypes.remove("Rabbit");
                    nextAnimal(_id, _token);
                } else {
                    if (rabbitPageNum < Integer.parseInt(animal.getTotal_pages())) {
                        rabbitPageNum++;
                        System.out.println("Rabbit animal Name: " + animal.getName());
                    } else {
                        animalTypes.remove("Rabbit");
                    }
                }
            }
            if (animalType.contains("Bird")) {
                animal = callBirdPage(_id, Integer.toString(birdPageNum), _token);
                if (Integer.parseInt(animal.getTotal_count()) == 0) {
                    animalTypes.remove("Rabbit");
                    nextAnimal(_id, _token);
                } else {
                    if (birdPageNum < Integer.parseInt(animal.getTotal_pages())) {
                        birdPageNum++;
                        System.out.println("Bird animal Name: " + animal.getName());
                    } else {
                        animalTypes.remove("Bird");
                    }
                }
            }
            if (animalType.contains("Scales, Fins & Other")) {
                if (Integer.parseInt(animal.getTotal_count()) == 0) {
                    animalTypes.remove("Rabbit");
                    nextAnimal(_id, _token);
                } else {
                    animal = callScalePage(_id, Integer.toString(scalesPageNum), _token);
                    if (scalesPageNum < Integer.parseInt(animal.getTotal_pages())) {
                        scalesPageNum++;
                    } else {
                        animalTypes.remove("Scales, Fins & Other");
                    }
                }
            }
            if (animalType.contains("Small & Furry")) {
                if (Integer.parseInt(animal.getTotal_count()) == 0) {
                    animalTypes.remove("Rabbit");
                    nextAnimal(_id, _token);
                } else {
                    animal = callSmallFPage(_id, Integer.toString(smallFPageNum), _token);
                    if (smallFPageNum < Integer.parseInt(animal.getTotal_pages())) {
                        smallFPageNum++;
                    } else {
                        animalTypes.remove("Small & Furry");
                    }
                }
            }
            if (animalType.contains("Horse")) {
                animal = callHorsePage(_id, Integer.toString(horsePageNum), _token);
                if (Integer.parseInt(animal.getTotal_count()) == 0) {
                    animalTypes.remove("Rabbit");
                    nextAnimal(_id, _token);
                } else {
                    if (horsePageNum < Integer.parseInt(animal.getTotal_pages())) {
                        horsePageNum++;
                    } else {
                        animalTypes.remove("Horse");
                    }
                }
            }
            if (animalType.contains("Barnyard")) {
                animal = callBarnyardPage(_id, Integer.toString(barnyardPageNum), _token);
                if (Integer.parseInt(animal.getTotal_count()) == 0) {
                    animalTypes.remove("Rabbit");
                    nextAnimal(_id, _token);
                } else {
                    if (barnyardPageNum < Integer.parseInt(animal.getTotal_pages())) {
                        barnyardPageNum++;
                    } else {
                        animalTypes.remove("Barnyard");
                    }
                }
            }
            Animal previousAnimal = this.animal;
            setAnimal(animal);
            System.out.println("AnimalTypes size: " + animalTypes.size());
            if (animal.getName().equals("")) {
                if (animalTypes.size() == 0) {
                    System.out.println("If statement No Animals of this type in radius found");
                    theView.setNameInfo("No Animals of this type in radius found");
                } else {
                    System.out.println("Calling a new animal");
                    nextAnimal(_id, _token);
                }
            }
            if ((animal.getName().equals(previousAnimal.getName()) && (animal.getType().equals(previousAnimal.getType())))) {
                System.out.println("Animal is the same");
                nextAnimal(_id, _token);
            }
        } catch (Exception IllegalArgumentException) {
            if (animalTypes.size() != 0) {
                nextAnimal(_id, _token);
            } else {
                System.out.println("No Animals in radius found");
                theView.setNameInfo("No Animals of this type in radius found");
                theView.setAgeInfo("");
                theView.setTypeInfo("");
                theView.setStatusInfo("");
                theView.setBreedInfo("");
                theView.setSexInfo("");
                theView.setSizeInfo("");
                theView.setPhoto("");

            }
        }
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal _animal) {
        this.animal = _animal;
        theView.setTypeInfo(_animal.getType());
        theView.setStatusInfo(_animal.getPublished_at());
        theView.setBreedInfo(_animal.getBreeds());
        theView.setSexInfo(_animal.getGender());
        theView.setSizeInfo(_animal.getSize());
        theView.setAgeInfo(_animal.getAge());
        theView.setNameInfo(_animal.getName());
        theView.setPetPic(_animal.getPhoto());
    }
}
