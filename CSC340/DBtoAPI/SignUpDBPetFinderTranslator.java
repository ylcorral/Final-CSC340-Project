package CSC340.DBtoAPI;

/**
 * DBToAPI Translator
 *
 * @author David Bowles 12/1/2020
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class SignUpDBPetFinderTranslator {

    public static String animalPropertiesListToStringDog(ArrayList<String> _animalList, String _pageNum) {
        return _animalList.get(0) + "page=" + _pageNum;
    }

    public static String animalPropertiesListToStringCat(ArrayList<String> _animalList, String _pageNum) {
        int i = 0;
        while (!(_animalList.get(i).contains("Cat"))) {
            i++;
        }
        return _animalList.get(i) + "page=" + _pageNum;
    }

    public static String animalPropertiesListToStringRabbit(ArrayList<String> _animalList, String _pageNum) {
        int i = 0;
        while (!(_animalList.get(i).contains("Rabbit"))) {
            i++;
        }
        return _animalList.get(i) + "page=" + _pageNum;
    }

    public static String animalPropertiesListToStringBird(ArrayList<String> _animalList, String _pageNum) {
        int i = 0;
        while (!(_animalList.get(i).contains("Bird"))) {
            i++;
        }
        return _animalList.get(i) + "page=" + _pageNum;
    }

    public static String animalPropertiesListToStringScales(ArrayList<String> _animalList, String _pageNum) {
        int i = 0;
        while (!(_animalList.get(i).contains("Scales, Fins & Other"))) {
            i++;
        }
        return _animalList.get(i) + "page=" + _pageNum;
    }

    public static String animalPropertiesListToStringSmallF(ArrayList<String> _animalList, String _pageNum) {
        int i = 0;
        while (!(_animalList.get(i).contains("Small & Furry"))) {
            i++;
        }
        return _animalList.get(i) + "page=" + _pageNum;
    }

    public static String animalPropertiesListToStringHorse(ArrayList<String> _animalList, String _pageNum) {
        int i = 0;
        while (!(_animalList.get(i).contains("Horse"))) {
            i++;
        }
        return _animalList.get(i) + "page=" + _pageNum;
    }

    public static String animalPropertiesListToStringBarnyard(ArrayList<String> _animalList, String _pageNum) {
        int i = 0;
        while (!(_animalList.get(i).contains("Barnyard"))) {
            i++;
        }
        return _animalList.get(i) + "page=" + _pageNum;
    }

    public static String animalPropertiesListToString(ArrayList<String> _animalList, String _pageNum) {
        String animalProperties = "";
        int listSize = _animalList.size();

        Random rand = new Random();
        animalProperties = _animalList.get(rand.nextInt(listSize));
        System.out.println();
        System.out.println(animalProperties);
        return animalProperties;
    }

    public static ArrayList<String> animalPropertiesParced(HashMap<String, String> _parameters) {
        ArrayList<String> parcedArray = new ArrayList<String>();
        String parsedString = "";
        System.out.println("animalPropertiesParced parameters.toString(): " + _parameters.toString());
        String parametersString = _parameters.toString();

        parsedString = parsedString + zipCodeParced(_parameters) + radiusParced(_parameters);
        System.out.println("animalPropertiesParced parced string: " + parsedString);
        if (parametersString.contains("Dog")) {
            System.out.println("animalPropertiesParced type dog called");
            parcedArray.add(parsedString + "type=" + "Dog&" + dogPropertiesParced(_parameters));
        }
        if (parametersString.contains("Cat")) {
            System.out.println("animalPropertiesParced type cat called");
            parcedArray.add(parsedString + "type=" + "Cat&" + catPropertiesParced(_parameters));
            System.out.println("catPropertiesParced type cat called: " + parsedString + "type=" + "Cat&" + catPropertiesParced(_parameters));
        }
        if (parametersString.contains("Rabbit")) {
            parcedArray.add(parsedString + "type=" + "Rabbit&" + rabbitPropertiesParced(_parameters));
        }
        if (parametersString.contains("Bird")) {
            parcedArray.add(parsedString + "type=" + "Bird&" + birdPropertiesParced(_parameters));
        }
        if (parametersString.contains("Scales, Fins & Other")) {
            parcedArray.add(parsedString + "type=" + "Scales, Fins \\u0026 Other&" + scalePropertiesParced(_parameters));
        }
        if (parametersString.contains("Small & Furry")) {
            parcedArray.add(parsedString + "type=" + "Small\\u0026Furry&" + smallFPropertiesParced(_parameters));
        }
        if (parametersString.contains("Horse")) {
            parcedArray.add(parsedString + "type=" + "Horse&" + horsePropertiesParced(_parameters));
        }
        if (parametersString.contains("Barnyard")) {
            parcedArray.add(parsedString + "type=" + "Barnyard&" + barnyardPropertiesParced(_parameters));
        }

        System.out.println(parcedArray.toString());
        return parcedArray;

    }

    //parces the Zip code to fit the API
    public static String zipCodeParced(HashMap<String, String> _parameters) {
        if (_parameters.containsKey("ZIPCODE")) {
            String s = _parameters.get("ZIPCODE");
            return "location=" + s + "&";
        }
        return null;

    }

    public static String radiusParced(HashMap<String, String> _parameters) {
        if (_parameters.containsKey("RADIUS")) {
            String s = _parameters.get("RADIUS");
            return "distance=" + s + "&";
        }
        return null;

    }

    public static String dogPropertiesParced(HashMap<String, String> _parameters) {
        System.out.println("dogProperties parced " + _parameters.toString());
        String parsedString = "";
        String parametersString = "";
        System.out.println("dogPropertiesParced(HashMap<String, String> parameters: " + _parameters.get("DOG_PARAMETERS"));
        if (_parameters.containsKey("DOG_PARAMETERS")) {
            parametersString = parametersString + _parameters.get("DOG_PARAMETERS");
            System.out.println("parametersString = parameters.get(\"DOG_PARAMETERS\");  " + parametersString);

            //Gender
            if (parametersString.contains("Male") && !(parametersString.contains("Female"))) {
                parsedString = parsedString + "Gender=" + "Male&";
            }
            if (!(parametersString.contains("Male")) && parametersString.contains("Female")) {
                parsedString = parsedString + "Gender=" + "Female&";
            }

            //Age
//            if(parametersString.contains("Baby")){
//                parsedString = parsedString + "Age=" + "Baby&";
//            }
//            if(parametersString.contains("Young")){
//                parsedString = parsedString + "Age=" + "Young&";
//            }
//            if(parametersString.contains("Adult")){
//                parsedString = parsedString + "Age=" + "Adult&";
//            }
//            if(parametersString.contains("Senior")){
//                parsedString = parsedString + "Age=" + "Senior&";
//            }
//            
//            //Size
//            if(parametersString.contains("Small")){
//                parsedString = parsedString + "Size=" + "Small&";
//            }
//            if(parametersString.contains("Medium")){
//                parsedString = parsedString + "Size=" + "Medium&";
//            }
//            if(parametersString.contains("Large")){
//                parsedString = parsedString + "Size=" + "Large&";
//            }
//            if(parametersString.contains("XLarge")){
//                parsedString = parsedString + "Size=" + "XLarge&";
//            }
        }

        //TODO:Preferences Parcer
        return parsedString;
    }

    public static String catPropertiesParced(HashMap<String, String> _parameters) {
        String parsedString = "";
        String parametersString = "";
        if (_parameters.containsKey("CAT_PARAMETERS")) {
            parametersString = parametersString + _parameters.get("CAT_PARAMETERS");
            System.out.println("Cat Parameters String " + parametersString);
            //Gender
            if (parametersString.contains("Male") && !(parametersString.contains("Female"))) {
                parsedString = parsedString + "Gender=" + "Male&";
            }
            if (!(parametersString.contains("Male")) && parametersString.contains("Female")) {
                parsedString = parsedString + "Gender=" + "Female&";
            }

            //Age
//            if(parametersString.contains("Baby")){
//                parsedString = parsedString + "Age=" + "Baby&";
//            }
//            if(parametersString.contains("Young")){
//                parsedString = parsedString + "Age=" + "Young&";
//            }
//            if(parametersString.contains("Adult")){
//                parsedString = parsedString + "Age=" + "Adult&";
//            }
//            if(parametersString.contains("Senior")){
//                parsedString = parsedString + "Age=" + "Senior&";
//            }
//            
//            //Size
//            if(parametersString.contains("Small")){
//                parsedString = parsedString + "Size=" + "Small&";
//            }
//            if(parametersString.contains("Medium")){
//                parsedString = parsedString + "Size=" + "Medium&";
//            }
//            if(parametersString.contains("Large")){
//                parsedString = parsedString + "Size=" + "Large&";
//            }
//            if(parametersString.contains("XLarge")){
//                parsedString = parsedString + "Size=" + "XLarge&";
//            }
        }

        //TODO:Preferences Parcer
        System.out.println("catPropertiesParced: " + parsedString);

        return parsedString;
    }

    public static String rabbitPropertiesParced(HashMap<String, String> _parameters) {
        String parsedString = "";
        String parametersString = "";
        if (_parameters.containsKey("RABBIT_PARAMETERS")) {
            parametersString = parametersString + _parameters.get("RABBIT_PARAMETERS");

            //Gender
            if (parametersString.contains("Male") && !(parametersString.contains("Female"))) {
                parsedString = parsedString + "Gender=" + "Male&";
            }
            if (!(parametersString.contains("Male")) && parametersString.contains("Female")) {
                parsedString = parsedString + "Gender=" + "Female&";
            }

            //Age
//            if(parametersString.contains("Baby")){
//                parsedString = parsedString + "Age=" + "Baby&";
//            }
//            if(parametersString.contains("Young")){
//                parsedString = parsedString + "Age=" + "Young&";
//            }
//            if(parametersString.contains("Adult")){
//                parsedString = parsedString + "Age=" + "Adult&";
//            }
//            if(parametersString.contains("Senior")){
//                parsedString = parsedString + "Age=" + "Senior&";
//            }
//            
//            //Size
//            if(parametersString.contains("Small")){
//                parsedString = parsedString + "Size=" + "Small&";
//            }
//            if(parametersString.contains("Medium")){
//                parsedString = parsedString + "Size=" + "Medium&";
//            }
//            if(parametersString.contains("Large")){
//                parsedString = parsedString + "Size=" + "Large&";
//            }
//            if(parametersString.contains("XLarge")){
//                parsedString = parsedString + "Size=" + "XLarge&";
//            }
        }

        //TODO:Preferences Parcer
        return parsedString;
    }

    public static String birdPropertiesParced(HashMap<String, String> _parameters) {
        String parsedString = "";
        String parametersString = "";
        if (_parameters.containsKey("BIRD_PARAMETERS")) {
            parametersString = parametersString + _parameters.get("BIRD_PARAMETERS");

            //Gender
            if (parametersString.contains("Male") && !(parametersString.contains("Female"))) {
                parsedString = parsedString + "Gender=" + "Male&";
            }
            if (!(parametersString.contains("Male")) && parametersString.contains("Female")) {
                parsedString = parsedString + "Gender=" + "Female&";
            }

            //Age
//            if(parametersString.contains("Baby")){
//                parsedString = parsedString + "Age=" + "Baby&";
//            }
//            if(parametersString.contains("Young")){
//                parsedString = parsedString + "Age=" + "Young&";
//            }
//            if(parametersString.contains("Adult")){
//                parsedString = parsedString + "Age=" + "Adult&";
//            }
//            if(parametersString.contains("Senior")){
//                parsedString = parsedString + "Age=" + "Senior&";
//            }
//            
//            //Size
//            if(parametersString.contains("Small")){
//                parsedString = parsedString + "Size=" + "Small&";
//            }
//            if(parametersString.contains("Medium")){
//                parsedString = parsedString + "Size=" + "Medium&";
//            }
//            if(parametersString.contains("Large")){
//                parsedString = parsedString + "Size=" + "Large&";
//            }
//            if(parametersString.contains("XLarge")){
//                parsedString = parsedString + "Size=" + "XLarge&";
//            }
        }

        //TODO:Preferences Parcer
        return parsedString;
    }

    public static String scalePropertiesParced(HashMap<String, String> _parameters) {
        String parsedString = "";
        String parametersString = "";
        if (_parameters.containsKey("SCLAES_PARAMETERS")) {
            parametersString = parametersString + _parameters.get("SCLAES_PARAMETERS");

            //Gender
            if (parametersString.contains("Male") && !(parametersString.contains("Female"))) {
                parsedString = parsedString + "Gender=" + "Male&";
            }
            if (!(parametersString.contains("Male")) && parametersString.contains("Female")) {
                parsedString = parsedString + "Gender=" + "Female&";
            }

            //Age
//            if(parametersString.contains("Baby")){
//                parsedString = parsedString + "Age=" + "Baby&";
//            }
//            if(parametersString.contains("Young")){
//                parsedString = parsedString + "Age=" + "Young&";
//            }
//            if(parametersString.contains("Adult")){
//                parsedString = parsedString + "Age=" + "Adult&";
//            }
//            if(parametersString.contains("Senior")){
//                parsedString = parsedString + "Age=" + "Senior&";
//            }
//            
//            //Size
//            if(parametersString.contains("Small")){
//                parsedString = parsedString + "Size=" + "Small&";
//            }
//            if(parametersString.contains("Medium")){
//                parsedString = parsedString + "Size=" + "Medium&";
//            }
//            if(parametersString.contains("Large")){
//                parsedString = parsedString + "Size=" + "Large&";
//            }
//            if(parametersString.contains("XLarge")){
//                parsedString = parsedString + "Size=" + "XLarge&";
//            }
        }

        //TODO:Preferences Parcer
        return parsedString;
    }

    public static String smallFPropertiesParced(HashMap<String, String> _parameters) {
        String parsedString = "";
        String parametersString = "";
        if (_parameters.containsKey("SMALLANDFURRY_PARAMETERS")) {
            parametersString = parametersString + _parameters.get("SMALLANDFURRY_PARAMETERS");

            //Gender
            if (parametersString.contains("Male") && !(parametersString.contains("Female"))) {
                parsedString = parsedString + "Gender=" + "Male&";
            }
            if (!(parametersString.contains("Male")) && parametersString.contains("Female")) {
                parsedString = parsedString + "Gender=" + "Female&";
            }

            //Age
//            if(parametersString.contains("Baby")){
//                parsedString = parsedString + "Age=" + "Baby&";
//            }
//            if(parametersString.contains("Young")){
//                parsedString = parsedString + "Age=" + "Young&";
//            }
//            if(parametersString.contains("Adult")){
//                parsedString = parsedString + "Age=" + "Adult&";
//            }
//            if(parametersString.contains("Senior")){
//                parsedString = parsedString + "Age=" + "Senior&";
//            }
//            
//            //Size
//            if(parametersString.contains("Small")){
//                parsedString = parsedString + "Size=" + "Small&";
//            }
//            if(parametersString.contains("Medium")){
//                parsedString = parsedString + "Size=" + "Medium&";
//            }
//            if(parametersString.contains("Large")){
//                parsedString = parsedString + "Size=" + "Large&";
//            }
//            if(parametersString.contains("XLarge")){
//                parsedString = parsedString + "Size=" + "XLarge&";
//            }
        }

        //TODO:Preferences Parcer
        return parsedString;
    }

    public static String horsePropertiesParced(HashMap<String, String> _parameters) {
        String parsedString = "";
        String parametersString = "";
        if (_parameters.containsKey("HORSES_PARAMETERS")) {
            parametersString = parametersString + _parameters.get("HORSES_PARAMETERS");

            //Gender
            if (parametersString.contains("Male") && !(parametersString.contains("Female"))) {
                parsedString = parsedString + "Gender=" + "Male&";
            }
            if (!(parametersString.contains("Male")) && parametersString.contains("Female")) {
                parsedString = parsedString + "Gender=" + "Female&";
            }

            //Age
//            if(parametersString.contains("Baby")){
//                parsedString = parsedString + "Age=" + "Baby&";
//            }
//            if(parametersString.contains("Young")){
//                parsedString = parsedString + "Age=" + "Young&";
//            }
//            if(parametersString.contains("Adult")){
//                parsedString = parsedString + "Age=" + "Adult&";
//            }
//            if(parametersString.contains("Senior")){
//                parsedString = parsedString + "Age=" + "Senior&";
//            }
//            
//            //Size
//            if(parametersString.contains("Small")){
//                parsedString = parsedString + "Size=" + "Small&";
//            }
//            if(parametersString.contains("Medium")){
//                parsedString = parsedString + "Size=" + "Medium&";
//            }
//            if(parametersString.contains("Large")){
//                parsedString = parsedString + "Size=" + "Large&";
//            }
//            if(parametersString.contains("XLarge")){
//                parsedString = parsedString + "Size=" + "XLarge&";
//            }
        }

        //TODO:Preferences Parcer
        return parsedString;
    }

    public static String barnyardPropertiesParced(HashMap<String, String> _parameters) {
        String parsedString = "";
        String parametersString = "";
        if (_parameters.containsKey("BARNYARD_PARAMETERS")) {
            parametersString = parametersString + _parameters.get("BARNYARD_PARAMETERS");

            //Gender
            if (parametersString.contains("Male") && !(parametersString.contains("Female"))) {
                parsedString = parsedString + "Gender=" + "Male&";
            }
            if (!(parametersString.contains("Male")) && parametersString.contains("Female")) {
                parsedString = parsedString + "Gender=" + "Female&";
            }

            //Age
//            if(parametersString.contains("Baby")){
//                parsedString = parsedString + "Age=" + "Baby&";
//            }
//            if(parametersString.contains("Young")){
//                parsedString = parsedString + "Age=" + "Young&";
//            }
//            if(parametersString.contains("Adult")){
//                parsedString = parsedString + "Age=" + "Adult&";
//            }
//            if(parametersString.contains("Senior")){
//                parsedString = parsedString + "Age=" + "Senior&";
//            }
//            
//            //Size
//            if(parametersString.contains("Small")){
//                parsedString = parsedString + "Size=" + "Small&";
//            }
//            if(parametersString.contains("Medium")){
//                parsedString = parsedString + "Size=" + "Medium&";
//            }
//            if(parametersString.contains("Large")){
//                parsedString = parsedString + "Size=" + "Large&";
//            }
//            if(parametersString.contains("XLarge")){
//                parsedString = parsedString + "Size=" + "XLarge&";
//            }
        }

        //TODO:Preferences Parcer
        return parsedString;
    }

    //TODO:Preferences Parcer
}
