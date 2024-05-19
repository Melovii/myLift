package windows;

import data.dataManipulation;

import javax.swing.*;
import java.awt.*;

public class viewWorkoutsWindow extends JFrame
{
    JButton returnB, deleteB;
    JButton[] infoB = new JButton[10];
    JButton[] startB = new JButton[10];
    JPanel[] workoutNameP;
    dataManipulation dataManipulator = new dataManipulation();

    viewWorkoutsWindow()
    {
        // ---  ---  WINDOW PROPERTIES  ---  ---
        this.setLayout(null);
        this.setSize(520, 600);

        this.setTitle("Workouts List");
        this.getContentPane().setBackground(new Color(44, 43, 64));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.setVisible(true);
        // --------------------------------------



        // ---  ---  ---  ---  BUTTONS AND ACTIONS ---  ---  ---  ---

        returnB = new JButton("←");
        returnB.setFont(new Font("Calibri", Font.BOLD, 21));
        returnB.setBounds(10, 510, 40, 40);
        returnB.setFocusable(false);
        returnB.setBackground(Color.WHITE);
        returnB.setBorder(BorderFactory.createLineBorder(new Color(27, 127, 222), 4));
        this.add(returnB);

        returnB.addActionListener(
                (e) -> {
                    dispose();
                    new mainWindow();
                }
        );

        int windowWidth = getWidth();
        int buttonWidth = 220; // deleteB.getWidth();
        int xPosition = (windowWidth - buttonWidth) / 2;

        deleteB = new JButton("Delete All Workouts");
        deleteB.setFont(new Font("Calibri", Font.BOLD, 21));
        deleteB.setBounds(xPosition, 510, buttonWidth, 40);
        deleteB.setFocusable(false);
        deleteB.setBackground(Color.WHITE);
        deleteB.setBorder(BorderFactory.createLineBorder(new Color(27, 127, 222), 4));
        this.add(deleteB);

        deleteB.addActionListener(
                (e) -> {
                    // code here
                    dataManipulator.deleteFiles();
                }
        );



        workoutNameP = new JPanel[6];
        int height = 50;
        int numWorkouts = dataManipulator.noOfFiles();

        for (int i=0; i < numWorkouts; i++) {
            startB[i] = new JButton("▶");
            startB[i].setFocusable(false);
            startB[i].setBackground(Color.WHITE);
            startB[i].setBounds(420, height, 50, 50);
            startB[i].setBorder(BorderFactory.createLineBorder(new Color(27, 127, 222), 4));
            this.add(startB[i]);

            final int index = i + 1;
            startB[i].addActionListener(
                    (e) -> {
                        dispose();
                        new workoutWindow(index);
                    }
            );

            infoB[i] = new JButton("i");
            infoB[i].setFocusable(false);
            infoB[i].setBackground(Color.WHITE);
            infoB[i].setFont(new Font("Times New Roman", Font.BOLD, 31));
            infoB[i].setBounds(30, height, 50, 50);
            infoB[i].setBorder(BorderFactory.createLineBorder(new Color(27, 127, 222), 4));
            this.add(infoB[i]);

            infoB[i].addActionListener(
                    (e) -> {
                        new workoutInfoWindow(); // TODO: add index for parameter
                        System.out.println(numWorkouts);
                    }
            );


            workoutNameP[i] = new JPanel();
            workoutNameP[i].setBorder(BorderFactory.createLineBorder(new Color(27, 127, 222), 4));
            workoutNameP[i].setBounds(100, height, 300, 50);
            this.add(workoutNameP[i]);

            height += 75;
        }
        // ---------------------------------------------------
    }
}