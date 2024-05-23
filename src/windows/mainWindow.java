package windows;

import data.dataManipulation;

import javax.swing.*;
import java.awt.*;

public class mainWindow extends JFrame
{

    JButton addWorkoutB, viewWorkoutsB, infoB;
    JLabel mainTitle, mainTitleShadow;

    Color BackgroundC = new Color(0xFF2B2D30);
    Color LabelC = new Color(0x73fbfd);
    Color WhiteC = new Color(0xfbffff);
    Color ButtonC = new Color(0x363A3D);
    Color ShadowC = new Color(0x191C1D);

    dataManipulation dataManipulator;

    public mainWindow()
    {
        dataManipulator = new dataManipulation();

        mainTitle = new JLabel();
        mainTitle.setText("myLift");
        mainTitle.setFont(new Font("Calibri", Font.BOLD , 44));
        mainTitle.setBounds(200, 50, 280, 60);
        mainTitle.setForeground(LabelC);
        this.add(mainTitle);

        mainTitleShadow = new JLabel();
        mainTitleShadow.setText("myLift");
        mainTitleShadow.setFont(new Font("Calibri", Font.BOLD , 44));
        mainTitleShadow.setBounds(198, 52, 280, 60);
        mainTitleShadow.setForeground(ShadowC);
        this.add(mainTitleShadow);

        // ---  ---  BUTTON PROPERTIES  ---  ---
        infoB = new JButton("About myLift");
        infoB.setForeground(WhiteC);
        infoB.setBounds(120, 340, 280, 60);
        infoB.setFocusable(false);
        infoB.setBackground(ButtonC);
        this.add(infoB);

        addWorkoutB = new JButton("Add Workout");
        addWorkoutB.setForeground(WhiteC);
        addWorkoutB.setBounds(120, 240, 280, 60);
        addWorkoutB.setFocusable(false);
        addWorkoutB.setBackground(ButtonC);
        this.add(addWorkoutB);

        viewWorkoutsB = new JButton("Start Workout");
        viewWorkoutsB.setForeground(WhiteC);
        viewWorkoutsB.setBounds(120, 140, 280, 60);
        viewWorkoutsB.setFocusable(false);
        viewWorkoutsB.setBackground(ButtonC);
        this.add(viewWorkoutsB);
        // -------------------------------------



        // ---  ---  BUTTON ACTIONS  ---  ---
        infoB.addActionListener(
                (e) -> new infoWindow()
        );


        addWorkoutB.addActionListener(
                (e) -> {
                    new addWorkoutWindow();
                }
        );



        String[] responses = {"OK", "Create Workout"};
        ImageIcon icon = new ImageIcon("src/resources/images/error.png");
        viewWorkoutsB.addActionListener(
                (e) -> {
                    if (dataManipulator.noOfFiles()==0) {
                        int choice = JOptionPane.showOptionDialog(null, "You don't have any workouts saved!", "Error", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,icon, responses, 0);
                        if(choice ==1 ) {
                            dispose();
                            new addWorkoutWindow();
                        }
                    } else {
                        dispose();
                        new viewWorkoutsWindow();
                    }
                }
        );
        // -----------------------------------



        // ---  ---  WINDOW PROPERTIES  ---  ---
        this.setLayout(null);
        this.setTitle("myLift");
        this.setSize(520, 520);
        this.getContentPane().setBackground(BackgroundC);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("myLift");
        this.setVisible(true);
        // --------------------------------------
    }

}