package CSC340.SignUp;

/*
* The purpose of this class to display messages and create the view for our
* sign up form.
* Last updated: 11/28/2020
* Author: Yngrid Corrales
 */
import java.awt.event.ActionListener;
import javax.swing.*;

public class SignUpView extends JFrame {

    /* All the buttons, text fields, checkboxes, and labels created to display window */
    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame("");
    private JLabel emailLabel = new JLabel("Email:");
    private JTextField email = new JTextField();
    private JLabel firstNameLabel = new JLabel("First Name:");
    private JTextField firstName = new JTextField();
    private JLabel phoneNumberLabel = new JLabel("Phone Number:");
    private JTextField phoneNumber = new JTextField();
    private JLabel lastNameLabel = new JLabel("Last Name:");
    private JTextField lastName = new JTextField();
    private JLabel zipCodeLabel = new JLabel("Zip Code:");
    private JTextField zipCode = new JTextField();
    private JLabel passwordLabel = new JLabel("Password:");
    private JTextField password = new JPasswordField();
    private JLabel rePassLabel = new JLabel("Re-Type Password:");
    private JTextField rePass = new JPasswordField();
    private JLabel radiusLabel = new JLabel("Enter seach radius:");
    private JTextField searchDistance = new JTextField();
    private JLabel rangeLabel = new JLabel("Range from 100-500miles");
    private JLabel checkBoxesLabel = new JLabel("Check boxes for desired pets:");
    private JCheckBox jCheckBoxDogs = new JCheckBox("Dogs");
    private JCheckBox jCheckBoxCats = new JCheckBox("Cats");
    private JCheckBox jCheckBoxRabbits = new JCheckBox("Rabbits");
    private JCheckBox jCheckBoxBirds = new JCheckBox("Birds");
    private JCheckBox jCheckBoxHorses = new JCheckBox("Horses");
    private JCheckBox jCheckBoxBarnyard = new JCheckBox("Barnyard");

    private JButton signUpButton = new JButton("Sign Up");
    private JButton cancelButton = new JButton("Cancel");
    private JButton backButton = new JButton("Back");

    /* This constructor formats and displays the buttons, text fields, checkboxes, and labels */
    public SignUpView() {

        setTitle("Registration Form");
        this.setSize(560, 790);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        emailLabel.setBounds(30, 03, 80, 25);
        panel.add(emailLabel);
        email.setBounds(30, 25, 165, 25);
        panel.add(email);

        firstNameLabel.setBounds(30, 60, 80, 25);
        panel.add(firstNameLabel);
        firstName.setBounds(30, 80, 165, 25);
        panel.add(firstName);

        phoneNumberLabel.setBounds(280, 03, 90, 25);
        panel.add(phoneNumberLabel);
        phoneNumber.setBounds(280, 25, 165, 25);
        panel.add(phoneNumber);

        lastNameLabel.setBounds(280, 60, 80, 25);
        panel.add(lastNameLabel);
        lastName.setBounds(280, 80, 165, 25);
        panel.add(lastName);

        passwordLabel.setBounds(30, 120, 80, 25);
        panel.add(passwordLabel);
        password.setBounds(30, 140, 165, 25);
        panel.add(password);

        rePassLabel.setBounds(280, 120, 120, 25);
        panel.add(rePassLabel);
        rePass.setBounds(280, 140, 165, 25);
        panel.add(rePass);

        zipCodeLabel.setBounds(30, 180, 80, 25);
        panel.add(zipCodeLabel);
        zipCode.setBounds(30, 200, 165, 25);
        panel.add(zipCode);

        radiusLabel.setBounds(30, 240, 200, 25);
        panel.add(radiusLabel);
        searchDistance.setBounds(30, 260, 165, 25);
        panel.add(searchDistance);

        rangeLabel.setBounds(30, 280, 200, 25);
        panel.add(rangeLabel);

        checkBoxesLabel.setBounds(30, 330, 200, 25);
        panel.add(checkBoxesLabel);

        jCheckBoxDogs.setBounds(30, 350, 200, 25);
        panel.add(jCheckBoxDogs);

        jCheckBoxCats.setBounds(30, 370, 200, 25);
        panel.add(jCheckBoxCats);

        jCheckBoxBirds.setBounds(30, 390, 200, 25);
        panel.add(jCheckBoxBirds);

        jCheckBoxRabbits.setBounds(30, 410, 200, 25);
        panel.add(jCheckBoxRabbits);

        jCheckBoxHorses.setBounds(30, 430, 200, 25);
        panel.add(jCheckBoxHorses);

        jCheckBoxBarnyard.setBounds(30, 450, 200, 25);
        panel.add(jCheckBoxBarnyard);

        signUpButton.setBounds(320, 600, 90, 25);
        panel.add(signUpButton);

        backButton.setBounds(100, 600, 90, 25);
        panel.add(backButton);

        cancelButton.setBounds(210, 650, 90, 25);
        panel.add(cancelButton);

        this.add(panel);
    }

    /* If barnyard checkbox is clicked execute a method in the controller named actionPerformed under barnyardListener */
    void addBarnyardListener(ActionListener _listenForBarnyardButton) {
        jCheckBoxBarnyard.addActionListener(_listenForBarnyardButton);
    }

    /* If horse checkbox is clicked execute a method in the controller named actionPerformed under horsesListener */
    void addHorsesListener(ActionListener _listenForHorsesButton) {
        jCheckBoxHorses.addActionListener(_listenForHorsesButton);
    }


    /* If birds checkbox is clicked execute a method in the controller named actionPerformed under birdListener */
    void addBirdsListener(ActionListener _listenForBirdsButton) {
        jCheckBoxBirds.addActionListener(_listenForBirdsButton);
    }

    /* If rabbit checkbox is clicked execute a method in the controller named actionPerformed under rabbitListener */
    void addRabbitsListener(ActionListener _listenForRabbitsButton) {
        jCheckBoxRabbits.addActionListener(_listenForRabbitsButton);
    }

    /* If cat checkbox is clicked execute a method in the controller named actionPerformed under catListener */
    void addCatListener(ActionListener _listenForCatButton) {
        jCheckBoxCats.addActionListener(_listenForCatButton);
    }

    /* If dog checkbox is clicked execute a method in the controller named actionPerformed under dogListener */
    void addDogListener(ActionListener _listenForDogButton) {
        jCheckBoxDogs.addActionListener(_listenForDogButton);
    }

    /* If the sign up button is clicked execute a method in the controller named actionPerformed under signUpListener */
    void addSignUpListener(ActionListener _listenForSignUpButton) {
        signUpButton.addActionListener(_listenForSignUpButton);
    }

    /* If the back button is clicked execute a method in the controller named actionPerformed under backListener */
    void addBackListener(ActionListener _listenForBackButton) {
        backButton.addActionListener(_listenForBackButton);
    }

    /* If the cancel button is clicked execute a method in the controller named actionPerformed under cancelListener */
    void addCancelListener(ActionListener _listenForCancelButton) {
        cancelButton.addActionListener(_listenForCancelButton);
    }

    /* Opens a popup that contains the message passed through */
    void displayLoginSuccessful(String _message) {
        JOptionPane.showMessageDialog(this, _message);

    }

    /* Open a popup that contains the error message passed */
    void displayLoginUnsuccessful(String _message) {
        JOptionPane.showMessageDialog(this, _message);

    }
    // ================================ GETTERS ====================================

    public String getEmail() {
        return email.getText();
    }

    public String getPassword() {
        return password.getText();
    }

    public String getRePass() {
        return rePass.getText();
    }

    public String getFirstName() {
        return firstName.getText();
    }

    public String getPhoneNo() {
        return phoneNumber.getText();
    }

    public String getLastName() {
        return lastName.getText();
    }

    public String getZipCode() {
        return zipCode.getText();
    }

    public String getRadius() {
        return searchDistance.getText();
    }

    // ================================ SETTERS ====================================
    public void setEmail(String _email) {

        this.email.setText(_email);
    }

    public void setPassword(String _password) {
        this.password.setText(_password);
    }

    public void setRePass(String _rePass) {

        this.rePass.setText(_rePass);
    }

    public void setFirstName(String _firstName) {

        this.firstName.setText(_firstName);
    }

    public void setPhoneNo(String _phoneNo) {
        this.phoneNumber.setText(_phoneNo);
    }

    public void setLastName(String _lastName) {
        this.lastName.setText(_lastName);
    }

    public void setZipCode(String _zipCode) {
        this.zipCode.setText(_zipCode);
    }

    public void setRadius(String _searchDistance) {
        this.searchDistance.setText(_searchDistance);
    }

}
