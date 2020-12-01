package CSC340.ChangePreference.ScalesAndOtherPreferences;

/*
* The purpose of this class to display the ScalesAndOtherPreferences page
* Last updated: 11/25/2020
* Author: Yngrid Corrales & David Bowles
 */
import java.awt.event.ActionListener;
import javax.swing.*;

public class ScalesAndOtherPreferencesView extends JFrame {

    /* All the buttons, text fields, checkboxes, and labels created to display window */
    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame("");
    private JLabel genderLabel = new JLabel("Gender:");
//    private JLabel ageLabel = new JLabel("Age:");
//    private JLabel sizeLabel = new JLabel("Size:");
    private JCheckBox jCheckBoxMale = new JCheckBox("Male");
    private JCheckBox jCheckBoxFemale = new JCheckBox("Female");
//    private JCheckBox jCheckBoxBaby = new JCheckBox("Baby");
//    private JCheckBox jCheckBoxYoung = new JCheckBox("Young");
//    private JCheckBox jCheckBoxAdult = new JCheckBox("Adult");
//    private JCheckBox jCheckBoxSenior = new JCheckBox("Senior");
//    private JCheckBox jCheckBoxSmall = new JCheckBox("Small");
//    private JCheckBox jCheckBoxMedium = new JCheckBox("Medium");
//    private JCheckBox jCheckBoxLarge = new JCheckBox("Large");
//    private JCheckBox jCheckBoxXLarge = new JCheckBox("XLarge");

    JButton cancelButton = new JButton("Cancel");
    JButton saveButton = new JButton("Save");

    /* This constructor formats and displays the buttons, text fields, checkboxes, and labels */
    public ScalesAndOtherPreferencesView() {
        setTitle("Scales and other Preferences");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        genderLabel.setBounds(63, 30, 80, 25);
        panel.add(genderLabel);

//        ageLabel.setBounds(80, 60, 80, 25);
//        panel.add(ageLabel);
//
//        sizeLabel.setBounds(75, 160, 80, 25);
//        panel.add(sizeLabel);
        jCheckBoxMale.setBounds(120, 30, 80, 25);
        panel.add(jCheckBoxMale);

        jCheckBoxFemale.setBounds(200, 30, 170, 25);
        panel.add(jCheckBoxFemale);

//        jCheckBoxBaby.setBounds(120, 60, 100, 25);
//        panel.add(jCheckBoxBaby);
//
//        jCheckBoxYoung.setBounds(120, 80, 100, 25);
//        panel.add(jCheckBoxYoung);
//
//        jCheckBoxAdult.setBounds(120, 100, 100, 25);
//        panel.add(jCheckBoxAdult);
//
//        jCheckBoxSenior.setBounds(120, 120, 100, 25);
//        panel.add(jCheckBoxSenior);
//
//        jCheckBoxSmall.setBounds(120, 160, 100, 25);
//        panel.add(jCheckBoxSmall);
//
//        jCheckBoxMedium.setBounds(120, 180, 100, 25);
//        panel.add(jCheckBoxMedium);
//
//        jCheckBoxLarge.setBounds(120, 200, 100, 25);
//        panel.add(jCheckBoxLarge);
//
//        jCheckBoxXLarge.setBounds(120, 220, 100, 25);
//        panel.add(jCheckBoxXLarge);
        cancelButton.setBounds(90, 300, 80, 25);
        panel.add(cancelButton);

        saveButton.setBounds(200, 300, 80, 25);
        panel.add(saveButton);

        this.add(panel);

    }

    /* If the male checkbox is clicked execute a method in the controller named actionPerformed under maleListener */
    void addMaleListiner(ActionListener _listenForMaleListener) {
        jCheckBoxMale.addActionListener(_listenForMaleListener);
    }

    /* If the female checkbox is clicked execute a method in the controller named actionPerformed under femaleListener */
    void addFemaleListiner(ActionListener _listenForFemaleListener) {
        jCheckBoxFemale.addActionListener(_listenForFemaleListener);
    }

    /* If the baby checkbox is clicked execute a method in the controller named actionPerformed under babyListener */
//    void addBabyListiner(ActionListener _listenForBabyListener) {
//        jCheckBoxBaby.addActionListener(_listenForBabyListener);
//    }
//
//    /* If the young checkbox is clicked execute a method in the controller named actionPerformed under youngListener */
//    void addYoungListiner(ActionListener _listenForYoungListener) {
//        jCheckBoxYoung.addActionListener(_listenForYoungListener);
//    }
//
//    /* If the adult checkbox is clicked execute a method in the controller named actionPerformed under adultListener */
//    void addAdultListiner(ActionListener _listenForAdultListener) {
//        jCheckBoxAdult.addActionListener(_listenForAdultListener);
//    }
//
//    /* If the senior checkbox is clicked execute a method in the controller named actionPerformed under seniorListener */
//    void addSeniorListiner(ActionListener _listenForSeniorListener) {
//        jCheckBoxSenior.addActionListener(_listenForSeniorListener);
//    }
//
//    /* If the small checkbox is clicked execute a method in the controller named actionPerformed under smallListener */
//    void addSmallListiner(ActionListener _listenForSmallListener) {
//        jCheckBoxSmall.addActionListener(_listenForSmallListener);
//    }
//
//    /* If the medium checkbox is clicked execute a method in the controller named actionPerformed under mediumListener */
//    void addMediumListiner(ActionListener _listenForMediumListener) {
//        jCheckBoxMedium.addActionListener(_listenForMediumListener);
//    }
//
//    /* If the large checkbox is clicked execute a method in the controller named actionPerformed under largeListener */
//    void addLargeListiner(ActionListener _listenForLargeListener) {
//        jCheckBoxLarge.addActionListener(_listenForLargeListener);
//    }
//
//    /* If the xlarge checkbox is clicked execute a method in the controller named actionPerformed under xLargeListener */
//    void addXLargeListiner(ActionListener _listenForXLargeListener) {
//        jCheckBoxXLarge.addActionListener(_listenForXLargeListener);
//    }

    /* If the save button is clicked execute a method in the controller named actionPerformed under saveListener */
    void addSaveListiner(ActionListener _listenForSaveListener) {
        saveButton.addActionListener(_listenForSaveListener);
    }

    /* If the cancel button is clicked execute a method in the controller named actionPerformed under cancelListener */
    void addCancelListiner(ActionListener _listenForCancelListener) {
        cancelButton.addActionListener(_listenForCancelListener);
    }

}
