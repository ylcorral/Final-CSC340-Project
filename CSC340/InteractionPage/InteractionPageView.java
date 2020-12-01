package CSC340.InteractionPage;

/*
* The purpose of this class to display the interaction page
* Last updated: 12/1/2020
* Author: Yngrid Corrales & David Bowles
 */
import java.awt.event.ActionListener;

import javax.swing.*;

public class InteractionPageView extends JFrame {

    private ImageModel imageModel;

    /* All the buttons, text fields, checkboxes, and labels created to display window */
    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame("");
    private JLabel petNameLabel = new JLabel("pet name", SwingConstants.CENTER);
    private JLabel sexLabel = new JLabel("SEX: ");
    private JLabel sizeLabel = new JLabel("SIZE: ");
    private JLabel typeLabel = new JLabel("TYPE: ");
    private JLabel ageLabel = new JLabel("AGE: ");
    private JLabel breedLabel = new JLabel("BREED: ");
    private JLabel statusLabel = new JLabel("LISTED ON: ");
    private JLabel statusInfoLabel = new JLabel(".");
    private JLabel typeInfoLabel = new JLabel(".");
    private JLabel breedInfoLabel = new JLabel(".");
    private JLabel sexInfoLabel = new JLabel(".");
    private JLabel sizeInfoLabel = new JLabel(".");
    private JLabel ageInfoLabel = new JLabel(".");
    private JLabel photo = new JLabel("");
    private JLabel picLogo = new JLabel("");
    private JLabel petPic = new JLabel(new ImageIcon());
    private String urlString = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/49924499/1/?bust=1606775475u0026width=300";

    private JButton updateButton = new JButton("Update Preferences");
    private JButton noButton = new JButton("No");
    private JButton signOutButton = new JButton("Sign Out");
    private JButton yesButton = new JButton("Yes");
    private JButton favoriteButton = new JButton("See Favorites");

    /* This constructor formats and displays the buttons, text fields, checkboxes, and labels */
    public InteractionPageView(ImageModel _imageModel) {
        setTitle("Homepage page");

        /* Displays pets picture */
        petPic = new JLabel(_imageModel.urlStringToImageIcon(urlString));
        this.imageModel = _imageModel;

        /* Displays pet matcher logo */
        String myimgpath;
        myimgpath = "C:\\Users\\biscu\\Downloads\\Pet_Matcher_logo.png";
        Icon myimgicon = new ImageIcon(myimgpath);
        picLogo.setIcon(myimgicon);

        this.setSize(900, 950);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        picLogo.setBounds(220, 00, 210, 180);
        panel.add(picLogo);

        updateButton.setBounds(40, 15, 150, 25);
        panel.add(updateButton);

        yesButton.setBounds(650, 820, 150, 25);
        panel.add(yesButton);

        noButton.setBounds(40, 820, 150, 25);
        panel.add(noButton);

        favoriteButton.setBounds(650, 10, 150, 25);
        panel.add(favoriteButton);

        signOutButton.setBounds(650, 40, 150, 25);
        panel.add(signOutButton);

        petNameLabel.setBounds(295, 140, 200, 25);
        panel.add(petNameLabel);

        typeLabel.setBounds(200, 600, 210, 180);
        panel.add(typeLabel);

        typeInfoLabel.setBounds(300, 600, 500, 180);
        panel.add(typeInfoLabel);

        breedLabel.setBounds(200, 620, 210, 180);
        panel.add(breedLabel);

        breedInfoLabel.setBounds(300, 620, 700, 180);
        panel.add(breedInfoLabel);

        ageLabel.setBounds(200, 640, 210, 180);
        panel.add(ageLabel);

        ageInfoLabel.setBounds(300, 640, 500, 180);
        panel.add(ageInfoLabel);

        sexLabel.setBounds(200, 660, 210, 180);
        panel.add(sexLabel);

        sexInfoLabel.setBounds(300, 660, 500, 180);
        panel.add(sexInfoLabel);

        sizeLabel.setBounds(200, 680, 210, 180);
        panel.add(sizeLabel);

        sizeInfoLabel.setBounds(300, 680, 500, 180);
        panel.add(sizeInfoLabel);

        statusLabel.setBounds(200, 700, 210, 180);
        panel.add(statusLabel);

        statusInfoLabel.setBounds(300, 700, 700, 180);
        panel.add(statusInfoLabel);

        petPic.setBounds(100, 175, 700, 500);
        panel.add(petPic);

        this.add(panel);

    }

    /* If the update preference button is clicked execute a method in the controller named actionPerformed under updateListener*/
    void addUpdateListener(ActionListener _listenForUpdateButton) {
        updateButton.addActionListener(_listenForUpdateButton);
    }

    /* If the no button is clicked execute a method in the controller named actionPerformed under noListener */
    void addNoListener(ActionListener _listenForNoButton) {
        noButton.addActionListener(_listenForNoButton);
    }

    /* If the yes button is clicked execute a method in the controller named actionPerformed under yesListener */
    void addYesListener(ActionListener _listenForYesButton) {
        yesButton.addActionListener(_listenForYesButton);
    }

    /* If the see favorites button is clicked execute a method in the controller named actionPerformed under favoriteListener*/
    void addFavoriteListener(ActionListener _listenForFavoriteButton) {
        favoriteButton.addActionListener(_listenForFavoriteButton);
    }

    /* If the sign out button is clicked execute a method in the controller named actionPerformed under signOutListener */
    void addSignOutListener(ActionListener _listenForSignOutButton) {
        signOutButton.addActionListener(_listenForSignOutButton);
    }

    // ================================ GETTERS ====================================
    public JLabel getNameInfo() {
        return petNameLabel;
    }

    public JLabel getTypeInfo() {
        return typeInfoLabel;
    }

    public JLabel getStatusInfo() {
        return statusInfoLabel;
    }

    public JLabel getBreedInfo() {
        return breedInfoLabel;
    }

    public JLabel getSexInfo() {
        return sexInfoLabel;
    }

    public JLabel getSizeInfo() {
        return sizeInfoLabel;
    }

    public JLabel getAgeInfo() {
        return ageInfoLabel;
    }

    public JLabel getPhoto() {
        return photo;
    }

    // ================================ SETTERS ====================================
    public void setTypeInfo(String _info) {
        typeInfoLabel.setText(_info);
    }

    public void setStatusInfo(String _status) {
        statusInfoLabel.setText(_status);
    }

    public void setBreedInfo(String _breed) {
        breedInfoLabel.setText(_breed);
    }

    public void setSexInfo(String _sex) {
        sexInfoLabel.setText(_sex);
    }

    public void setSizeInfo(String _size) {
        sizeInfoLabel.setText(_size);
    }

    public void setAgeInfo(String _age) {
        ageInfoLabel.setText(_age);
    }

    public void setNameInfo(String _name) {
        petNameLabel.setText(_name);
    }

    public void setPetPic(String _urlString) {
        _urlString = _urlString.replaceAll("\"", "");
        _urlString = _urlString.replace("\\", "");
        System.out.println("SetPetPic: " + _urlString);
        petPic.setIcon(imageModel.urlStringToImageIcon(_urlString));
    }

    public void setPhoto(String _photo) {
        photo.setText(_photo);
    }

}
