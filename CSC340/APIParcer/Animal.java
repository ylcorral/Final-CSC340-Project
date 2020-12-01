package CSC340.APIParcer;

/**
 * Creates Animal Object and formates api string to animal object
 *
 * @author David Bowles Last Updated 12/1/20
 */

import static CSC340.apiCall.PetFinderAPIController.callAPI;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;

public class Animal {

    private String name;
    private String gender;
    private String size;
    private String age;
    private String distance;
    private String type;
    private String colors;
    private String breeds;
    private String description;
    private String photo;
    private String attributes;
    private String contact;
    private String published_at;
    private String total_pages;
    private String total_count;

    public Animal(String _name, String _gender, String _size, String _age, String _distance, String _type, String _colors, String _breeds, String _description, String _photo, String _attributes, String _contact, String _published_at, String _total_pages, String _total_count) {
        this.name = _name;
        this.gender = _gender;
        this.size = _size;
        this.age = _age;
        this.distance = _distance;
        this.type = _type;
        this.colors = _colors;
        this.breeds = _breeds;
        this.description = _description;
        this.photo = _photo;
        this.attributes = _attributes;
        this.contact = _contact;
        this.published_at = _published_at;
        this.total_pages = _total_pages;
        this.total_count = _total_count;
    }

    public static Animal callAnimal(String _id) throws SQLException, IOException, JSONException {
        System.out.println("Call Animal Method");
        String animalSubString = callAPI(_id);
        System.out.println("Call Animal Method animalSubString: " + animalSubString);
        Animal animal = formatAnimal(animalSubString);
        return animal;
    }

    public static ArrayList<Animal> getAnimalObjectFromHashMap(String _animalString) throws JSONException {
        ArrayList<Animal> animalList = new ArrayList();
        int i = 0;
        int j = 1;
        int k = 0;

        while (j < _animalString.length()) {
            if (_animalString.charAt(j) == 123) {
                i--;
            }
            if (_animalString.charAt(j) == 125) {
                i++;
            }

            if (i == 0) {
                String animalSubString = _animalString.substring(k, j);
                System.out.println("\nCompleted a Animal String: " + animalSubString + "\n");
                animalList.add(formatAnimal(animalSubString));
                k = j + 1;
                i = i - 2;
            }

            j++;

        }

        System.out.println(j);

        return animalList;
    }

    public static Animal formatAnimal(String _animalSubString) {
        int i = 0;
        int j = 1;
        int k = 0;
        Animal animal = new Animal("", "", "", "", "", "", "", "", "", "", "", "", "", "", "");

        if (_animalSubString.contains("gender")) {
            k = _animalSubString.indexOf("gender") + 8;
            String s = "";

            while (_animalSubString.charAt(k) != 44) {
                s = s + _animalSubString.charAt(k);
                k++;
            }
            //System.out.println("gender of animal: " + s);
            s = s.replaceAll("\"", "");
            animal.setGender(s);
        }

        if (_animalSubString.contains("name")) {
            k = _animalSubString.indexOf("name") + 6;
            String s = "";

            while (_animalSubString.charAt(k) != 44) {
                s = s + _animalSubString.charAt(k);
                k++;
            }
            //System.out.println("name of animal: " + s);
            s = s.replaceAll("\"", "");
            animal.setName(s);
        }
        if (_animalSubString.contains("size")) {
            k = _animalSubString.indexOf("size") + 6;
            String s = "";

            while (_animalSubString.charAt(k) != 44) {
                s = s + _animalSubString.charAt(k);
                k++;
            }
            //System.out.println("size of animal: " + s);
            s = s.replaceAll("\"", "");
            animal.setSize(s);
        }
        if (_animalSubString.contains("age")) {
            k = _animalSubString.indexOf("age") + 5;
            String s = "";

            while (_animalSubString.charAt(k) != 44) {
                s = s + _animalSubString.charAt(k);
                k++;
            }
            //System.out.println("age of animal: " + s);
            s = s.replaceAll("\"", "");
            animal.setAge(s);
        }
        if (_animalSubString.contains("distance")) {

            k = _animalSubString.indexOf("distance") + 10;
            String s = "";

            while (_animalSubString.charAt(k) != 44) {
                s = s + _animalSubString.charAt(k);
                k++;
            }
            //System.out.println("distance of animal: " + s);
            s = s.replaceAll("\"", "");
            animal.setDistance(s);
        }
        if (_animalSubString.contains("type")) {
            k = _animalSubString.indexOf("type") + 6;
            String s = "";

            while (_animalSubString.charAt(k) != 44) {
                s = s + _animalSubString.charAt(k);
                k++;
            }
            //System.out.println("type of animal: " + s);
            s = s.replaceAll("\"", "");
            animal.setType(s);
        }

        if (_animalSubString.contains("colors")) {
            k = _animalSubString.indexOf("colors") + 9;
            String s = "";

            while (_animalSubString.charAt(k) != 125) {
                s = s + _animalSubString.charAt(k);
                k++;
            }
            //System.out.println("colors of animal: " + s);
            s = s.replaceAll("\"", "");
            animal.setColors(s);
        }
        if (_animalSubString.contains("breeds")) {
            k = _animalSubString.indexOf("breeds") + 9;
            String s = "";

            while (_animalSubString.charAt(k) != 125) {
                s = s + _animalSubString.charAt(k);
                k++;
            }
            //System.out.println("breeds of the animal: " + s);
            s = s.replaceAll("\"", "");
            s = s.replaceAll("primary:", "");
            s = s.replaceAll("secondary:null,", "");
            s = s.replaceAll("mixed:false,", "");
            s = s.replaceAll("mixed:true,", "mixed,");
            s = s.replaceAll("unknown:false", "");
            s = s.replaceAll("secondary:", " Secondary ");
            s = s.replaceAll(",", ", ");
            s = s.trim();
            if (s.charAt(s.length() - 1) == ',') {
                s = s.substring(0, s.length() - 1);
            }
            animal.setBreeds(s);
        }

        if (_animalSubString.contains("description")) {
            k = _animalSubString.indexOf("description") + 14;
            String s = "";

            while (_animalSubString.charAt(k) != 34) {
                s = s + _animalSubString.charAt(k);
                k++;
            }
            //System.out.println("description of the animal: " + s);
            s = s.replaceAll("\"", "");
            animal.setDescription(s);
        }

        if (_animalSubString.contains("primary_photo_cropped")) {
            k = _animalSubString.indexOf("primary_photo_cropped") + 24;
            String s = "";
            while (_animalSubString.charAt(k) != 125) {
                s = s + _animalSubString.charAt(k);
                k++;
            }
            //System.out.println("primary_photo_cropped of the animal: " + s);
            if (s.contains("small")) {
                k = s.indexOf("small") + 7;
                String small = "";
                while (s.charAt(k) != 44) {
                    small = small + s.charAt(k);
                    k++;
                }
                //small = small.replaceAll("\"", "");
                //small = small.replaceAll("\\", "/");
                animal.setPhoto(small);
                System.out.println("small: " + small);

            }
        }
        if (_animalSubString.contains("attributes")) {
            k = _animalSubString.indexOf("attributes") + 13;
            String s = "";

            while (_animalSubString.charAt(k) != 125) {
                s = s + _animalSubString.charAt(k);
                k++;
            }
            //System.out.println("attributes of the animal: " + s);
            s = s.replaceAll("\"", "");
            animal.setAttributes(s);
        }

        if (_animalSubString.contains("contact")) {
            k = _animalSubString.indexOf("contact") + 10;
            String s = "";

            while (_animalSubString.charAt(k) != 125) {
                s = s + _animalSubString.charAt(k);
                k++;
            }
            System.out.println("contact of the animal: " + s);
            s = s.replaceAll("\"", "");
//            s = s.replaceAll("email:null", "");
//            s = s.replaceAll("phone:null", "");
//            s = s.replaceAll(",phone:", " phone ");
//            s = s.replaceAll("email:", "email ");
//            s = s.replaceAll("address2:null", "");
//            s = s.replaceAll("city:", "city ");
//            s = s.replaceAll(",country:US", "");
//            s = s.replaceAll("address:{", "");
//            s = s.replaceAll("address1:", "address ");
            animal.setContact(s);
        }
        if (_animalSubString.contains("published_at")) {
            k = _animalSubString.indexOf("published_at") + 14;
            String s = "";

            while (_animalSubString.charAt(k) != 84) {
                s = s + _animalSubString.charAt(k);
                k++;
            }
            //System.out.println("publised_at of animal: " + s);
            s = s.replaceAll("\"", "");
            animal.setPublished_at(s);
        }
        String s = "";
        if (_animalSubString.contains("total_pages")) {
            k = _animalSubString.indexOf("total_pages");
            s = _animalSubString.substring(k, k + 16);

            s = s.replaceAll("}", "");
            s = s.replaceAll(",", "");

            s = s.replaceAll("total_pages\":", "");
            System.out.println("total_pages of animal: " + s);
            animal.setTotal_pages(s);
        }

        //String s = "";
        if (_animalSubString.contains("total_count")) {
            k = _animalSubString.indexOf("total_count");
            s = _animalSubString.substring(k, k + 16);

            s = s.replaceAll("}", "");
            s = s.replaceAll(",", "");

            s = s.replaceAll("total_count\":", "");
            s = s.replaceAll("\"", "");
            System.out.println("total_count of animal: " + s);
            animal.setTotal_count(s);
        }

        //animal.setTotal_pages(s);
        return animal;

    }

    public static HashMap<String, String> animalToHashMap(Animal _animal, String _id) {
        HashMap<String, String> animalMap = new HashMap<String, String>();
        animalMap.put("NAME", _animal.getName());
        animalMap.put("GENDER", _animal.getGender());
        animalMap.put("SIZE", _animal.getSize());
        animalMap.put("AGE", _animal.getAge());
        animalMap.put("DISTANCE", _animal.getDistance());
        animalMap.put("TYPE", _animal.getType());
        animalMap.put("COLORS", _animal.getColors());
        animalMap.put("BREEDS", _animal.getBreeds());
        animalMap.put("DESCRIPTION", _animal.getDescription());
        animalMap.put("PRIMARY_PHOTO_CROPPED", _animal.getPhoto());
        animalMap.put("ATTRIBUTES", _animal.getAttributes());
        animalMap.put("CONTACT", _animal.getContact());
        animalMap.put("PUBLISHED_AT", _animal.getPublished_at());
        animalMap.put("ID", _id);

        return animalMap;
    }

    public static Animal hashMapToAnimal(HashMap<String, String> _animalMap) {
        Animal animal = new Animal("", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
        animal.setName(_animalMap.get("NAME"));
        animal.setGender(_animalMap.get("GENDER"));
        animal.setSize(_animalMap.get("SIZE"));
        animal.setAge(_animalMap.get("AGE"));
        animal.setDistance(_animalMap.get("DISTANCE"));
        animal.setType(_animalMap.get("TYPE"));
        animal.setColors(_animalMap.get("COLORS"));
        animal.setBreeds(_animalMap.get("BREEDS"));
        animal.setDescription(_animalMap.get("DESCRIPTION"));
        animal.setPhoto(_animalMap.get("PRIMARY_PHOTO_CROPPED"));
        animal.setAttributes(_animalMap.get("ATTRIBUTES"));
        animal.setContact(_animalMap.get("CONTACT"));
        animal.setPublished_at(_animalMap.get("PUBLISHED_AT"));
        return animal;
    }

    public String getTotal_pages() {
        return total_pages;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getSize() {
        return size;
    }

    public String getAge() {
        return age;
    }

    public String getDistance() {
        return distance;
    }

    public String getType() {
        return type;
    }

    public String getColors() {
        return colors;
    }

    public String getBreeds() {
        return breeds;
    }

    public String getDescription() {
        return description;
    }

    public String getPhoto() {
        return photo;
    }

    public String getAttributes() {
        return attributes;
    }

    public String getContact() {
        return contact;
    }

    public String getPublished_at() {
        return published_at;
    }

    public String getTotal_count() {
        return total_count;
    }

    public void setTotal_pages(String _total_pages) {
        this.total_pages = _total_pages;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public void setGender(String _gender) {
        this.gender = _gender;
    }

    public void setSize(String _size) {
        this.size = _size;
    }

    public void setAge(String _age) {
        this.age = _age;
    }

    public void setDistance(String _distance) {
        this.distance = _distance;
    }

    public void setType(String _type) {
        this.type = _type;
    }

    public void setColors(String _colors) {
        this.colors = _colors;
    }

    public void setBreeds(String _breeds) {
        this.breeds = _breeds;
    }

    public void setDescription(String _description) {
        this.description = _description;
    }

    public void setPhoto(String _photo) {
        this.photo = _photo;
    }

    public void setAttributes(String _attributes) {
        this.attributes = _attributes;
    }

    public void setContact(String _contact) {
        this.contact = _contact;
    }

    public void setTotal_count(String _total_count) {
        this.total_count = _total_count;
    }

    public void setPublished_at(String _published_at) {
        this.published_at = _published_at;
    }
}
