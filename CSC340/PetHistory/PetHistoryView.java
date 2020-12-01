package CSC340.PetHistory;

/*
* The purpose of this class to display the view for the favorites page
* Last updated: 11/29/2020
* Author: Yngrid Corrales & David Bowles
 */
import javax.swing.*;
import java.awt.event.ActionListener;

public class PetHistoryView extends JFrame {

    /* All the buttons, text fields, checkboxes, and labels created to display window */
    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame("");
    private JLabel petNameLabel = new JLabel("pet name");
    private JLabel typeLabel = new JLabel("TYPE: ");
    private JLabel breedLabel = new JLabel("BREED: ");
    private JLabel contactLabel = new JLabel("CONTACT: ");
    private JLabel contactinfoLabel = new JLabel(".");
    private JLabel typeinfoLabel = new JLabel(".");
    private JLabel breedinfoLabel = new JLabel(".");

    private JLabel petName2Label = new JLabel("pet name");
    private JLabel type2Label = new JLabel("TYPE: ");
    private JLabel breed2Label = new JLabel("BREED: ");
    private JLabel contact2Label = new JLabel("CONTACT: ");
    private JLabel contactinfo2Label = new JLabel(".");
    private JLabel typeinfo2Label = new JLabel(".");
    private JLabel breedinfo2Label = new JLabel(".");

    private JLabel petName3Label = new JLabel("pet name");
    private JLabel type3Label = new JLabel("TYPE: ");
    private JLabel breed3Label = new JLabel("BREED: ");
    private JLabel contact3Label = new JLabel("CONTACT: ");
    private JLabel contactinfo3Label = new JLabel(".");
    private JLabel typeinfo3Label = new JLabel(".");
    private JLabel breedinfo3Label = new JLabel(".");

    private JLabel petName4Label = new JLabel("pet name");
    private JLabel type4Label = new JLabel("TYPE: ");
    private JLabel breed4Label = new JLabel("BREED: ");
    private JLabel contact4Label = new JLabel("CONTACT: ");
    private JLabel contactinfo4Label = new JLabel(".");
    private JLabel typeinfo4Label = new JLabel(".");
    private JLabel breedinfo4Label = new JLabel(".");

    private JLabel pic = new JLabel("");
    JButton updateButton = new JButton("Update Preferences");
    JButton backButton = new JButton("Back to Homepage");
    JButton nextButton = new JButton("Next Page");
    JButton previousButton = new JButton("Previous Page");

    /* This constructor formats and displays the buttons, text fields, checkboxes, and labels */
    public PetHistoryView() {

        String myimgpath;
        myimgpath = "C:\\Users\\biscu\\Downloads\\Pet_Matcher_logo.png";
        Icon myimgicon = new ImageIcon(myimgpath);
        pic.setIcon(myimgicon);

        setTitle("Favorites");
        this.setSize(780, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        pic.setBounds(130, 00, 210, 180);
        panel.add(pic);

        updateButton.setBounds(600, 10, 150, 25);
        panel.add(updateButton);

        backButton.setBounds(10, 10, 150, 25);
        panel.add(backButton);

        nextButton.setBounds(600, 650, 150, 25);
        panel.add(nextButton);

        previousButton.setBounds(10, 650, 150, 25);
        panel.add(previousButton);

        petNameLabel.setBounds(120, 160, 700, 25);
        panel.add(petNameLabel);

        typeLabel.setBounds(220, 160, 700, 25);
        panel.add(typeLabel);

        typeinfoLabel.setBounds(280, 160, 700, 25);
        panel.add(typeinfoLabel);

        breedLabel.setBounds(220, 180, 700, 25);
        panel.add(breedLabel);

        breedinfoLabel.setBounds(280, 179, 700, 25);
        panel.add(breedinfoLabel);

        contactLabel.setBounds(220, 200, 700, 25);
        panel.add(contactLabel);

        contactinfoLabel.setBounds(290, 200, 1000, 25);
        panel.add(contactinfoLabel);

        petName2Label.setBounds(120, 260, 700, 25);
        panel.add(petName2Label);

        type2Label.setBounds(220, 260, 700, 25);
        panel.add(type2Label);

        typeinfo2Label.setBounds(280, 260, 700, 25);
        panel.add(typeinfo2Label);

        breed2Label.setBounds(220, 280, 700, 25);
        panel.add(breed2Label);

        breedinfo2Label.setBounds(280, 280, 700, 25);
        panel.add(breedinfo2Label);

        contact2Label.setBounds(220, 300, 700, 25);
        panel.add(contact2Label);

        contactinfo2Label.setBounds(290, 300, 1000, 25);
        panel.add(contactinfo2Label);

        petName3Label.setBounds(120, 360, 700, 25);
        panel.add(petName3Label);

        type3Label.setBounds(220, 360, 700, 25);
        panel.add(type3Label);

        typeinfo3Label.setBounds(280, 360, 700, 25);
        panel.add(typeinfo3Label);

        breed3Label.setBounds(220, 380, 700, 25);
        panel.add(breed3Label);

        breedinfo3Label.setBounds(280, 380, 700, 25);
        panel.add(breedinfo3Label);

        contact3Label.setBounds(220, 400, 700, 25);
        panel.add(contact3Label);

        contactinfo3Label.setBounds(290, 400, 1000, 25);
        panel.add(contactinfo3Label);

        petName4Label.setBounds(120, 460, 700, 25);
        panel.add(petName4Label);

        type4Label.setBounds(220, 460, 700, 25);
        panel.add(type4Label);

        typeinfo4Label.setBounds(280, 460, 700, 25);
        panel.add(typeinfo4Label);

        breed4Label.setBounds(220, 480, 700, 25);
        panel.add(breed4Label);

        breedinfo4Label.setBounds(280, 480, 700, 25);
        panel.add(breedinfo4Label);

        contact4Label.setBounds(220, 500, 700, 25);
        panel.add(contact4Label);

        contactinfo4Label.setBounds(290, 500, 1000, 25);
        panel.add(contactinfo4Label);

        this.add(panel);

    }

    /* If the update preference button is clicked execute a method in the controller named actionPerformed in class updateListener */
    void addUpdateListener(ActionListener _listenForUpdateButton) {
        updateButton.addActionListener(_listenForUpdateButton);
    }

    /* If the back home button is clicked execute a method in the controller named actionPerformed in class backListener */
    void addBackListener(ActionListener _listenForBackButton) {
        backButton.addActionListener(_listenForBackButton);
    }

    /* If the previous button is clicked execute a method in the controller named actionPerformed in class previousListener */
    void addPreviousListener(ActionListener _listenForPreviousButton) {
        previousButton.addActionListener(_listenForPreviousButton);
    }

    /* If the next button is clicked execute a method in the controller named actionPerformed in class nextListener */
    void addNextListener(ActionListener _listenForNextButton) {
        nextButton.addActionListener(_listenForNextButton);
    }

    // ================================ GETTERS ====================================
    public JLabel getPetNameLabel() {
        return petNameLabel;
    }

    public JLabel getTypeLabel() {
        return typeLabel;
    }

    public JLabel getBreedLabel() {
        return breedLabel;
    }

    public JLabel getContactLabel() {
        return contactLabel;
    }

    public JLabel getContactinfoLabel() {
        return contactinfoLabel;
    }

    public JLabel getTypeinfoLabel() {
        return typeinfoLabel;
    }

    public JLabel getBreedinfoLabel() {
        return breedinfoLabel;
    }

    public JLabel getPetName2Label() {
        return petName2Label;
    }

    public JLabel getType2Label() {
        return type2Label;
    }

    public JLabel getBreed2Label() {
        return breed2Label;
    }

    public JLabel getContact2Label() {
        return contact2Label;
    }

    public JLabel getContactinfo2Label() {
        return contactinfo2Label;
    }

    public JLabel getTypeinfo2Label() {
        return typeinfo2Label;
    }

    public JLabel getBreedinfo2Label() {
        return breedinfo2Label;
    }

    public JLabel getPetName3Label() {
        return petName3Label;
    }

    public JLabel getType3Label() {
        return type3Label;
    }

    public JLabel getBreed3Label() {
        return breed3Label;
    }

    public JLabel getContact3Label() {
        return contact3Label;
    }

    public JLabel getContactinfo3Label() {
        return contactinfo3Label;
    }

    public JLabel getTypeinfo3Label() {
        return typeinfo3Label;
    }

    public JLabel getBreedinfo3Label() {
        return breedinfo3Label;
    }

    public JLabel getPetName4Label() {
        return petName4Label;
    }

    public JLabel getType4Label() {
        return type4Label;
    }

    public JLabel getBreed4Label() {
        return breed4Label;
    }

    public JLabel getContact4Label() {
        return contact4Label;
    }

    public JLabel getContactinfo4Label() {
        return contactinfo4Label;
    }

    public JLabel getTypeinfo4Label() {
        return typeinfo4Label;
    }

    public JLabel getBreedinfo4Label() {
        return breedinfo4Label;
    }

    public JLabel getPic() {
        return pic;
    }

    // ================================ SETTERS ====================================
    public void setPetNameLabel(String petNameLabel) {
        this.petNameLabel.setText(petNameLabel);
    }

    public void setTypeLabel(String typeLabel) {
        this.typeLabel.setText(typeLabel);
    }

    public void setBreedLabel(String breedLabel) {
        this.breedLabel.setText(breedLabel);
    }

    public void setContactLabel(String contactLabel) {
        this.contactLabel.setText(contactLabel);
    }

    public void setContactinfoLabel(String contactinfoLabel) {
        this.contactinfoLabel.setText(contactinfoLabel);
    }

    public void setTypeinfoLabel(String typeinfoLabel) {
        this.typeinfoLabel.setText(typeinfoLabel);
    }

    public void setBreedinfoLabel(String breedinfoLabel) {
        this.breedinfoLabel.setText(breedinfoLabel);
    }

    public void setPetName2Label(String petName2Label) {
        this.petName2Label.setText(petName2Label);
    }

    public void setType2Label(String type2Label) {
        this.type2Label.setText(type2Label);
    }

    public void setBreed2Label(String breed2Label) {
        this.breed2Label.setText(breed2Label);
    }

    public void setContact2Label(String contact2Label) {
        this.contact2Label.setText(contact2Label);
    }

    public void setContactinfo2Label(String contactinfo2Label) {
        this.contactinfo2Label.setText(contactinfo2Label);
    }

    public void setTypeinfo2Label(String typeinfo2Label) {
        this.typeinfo2Label.setText(typeinfo2Label);
    }

    public void setBreedinfo2Label(String breedinfo2Label) {
        this.breedinfo2Label.setText(breedinfo2Label);
    }

    public void setPetName3Label(String petName3Label) {
        this.petName3Label.setText(petName3Label);
    }

    public void setType3Label(String type3Label) {
        this.type3Label.setText(type3Label);
    }

    public void setBreed3Label(String breed3Label) {
        this.breed3Label.setText(breed3Label);
    }

    public void setContact3Label(String contact3Label) {
        this.contact3Label.setText(contact3Label);
    }

    public void setContactinfo3Label(String contactinfo3Label) {
        this.contactinfo3Label.setText(contactinfo3Label);
    }

    public void setTypeinfo3Label(String typeinfo3Label) {
        this.typeinfo3Label.setText(typeinfo3Label);
    }

    public void setBreedinfo3Label(String breedinfo3Label) {
        this.breedinfo3Label.setText(breedinfo3Label);
    }

    public void setPetName4Label(String petName4Label) {
        this.petName4Label.setText(petName4Label);
    }

    public void setType4Label(String type4Label) {
        this.type4Label.setText(type4Label);
    }

    public void setBreed4Label(String breed4Label) {
        this.breed4Label.setText(breed4Label);
    }

    public void setContact4Label(String contact4Label) {
        this.contact4Label.setText(contact4Label);
    }

    public void setContactinfo4Label(String contactinfo4Label) {
        this.contactinfo4Label.setText(contactinfo4Label);
    }

    public void setTypeinfo4Label(String typeinfo4Label) {
        this.typeinfo4Label.setText(typeinfo4Label);
    }

    public void setBreedinfo4Label(String breedinfo4Label) {
        this.breedinfo4Label.setText(breedinfo4Label);
    }

    public void setPic(String pic) {
        this.pic.setText(pic);
    }

}
