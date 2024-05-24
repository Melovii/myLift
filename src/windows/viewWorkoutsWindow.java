package windows;

import data.dataManipulation;

import javax.swing.*;
import java.awt.*;

public class viewWorkoutsWindow extends JFrame
{
    JButton returnB, deleteB;
    JLabel workoutNameTitleL;
    JButton[] infoB = new JButton[10];
    JButton[] startB = new JButton[10];
    JPanel[] workoutNameP;
    JLabel[] workoutNameL;

    Color BackgroundC = new Color(0xFF2B2D30);
    Color LabelC = new Color(0x73fbfd);
    Color WhiteC = new Color(0xfbffff);
    Color ButtonC = new Color(0x363A3D);

    ImageIcon icon = new ImageIcon("src/resources/images/icon.png");

    viewWorkoutsWindow()
    {

        dataManipulation dataManipulator = new dataManipulation();
        // ---  ---  WINDOW PROPERTIES  ---  ---
        this.setLayout(null);
        this.setSize(520, 600);
        this.setTitle("Workouts List");
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(BackgroundC);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.setVisible(true);
        // --------------------------------------



        // ---  ---  ---  ---  BUTTONS AND ACTIONS ---  ---  ---  ---

        returnB = new JButton("←");
        returnB.setFont(new Font("Calibri", Font.BOLD, 17));
        returnB.setBounds(10, 500, 51, 51);
        returnB.setFocusable(false);
        returnB.setBackground(ButtonC);
        returnB.setForeground(WhiteC);
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
        deleteB.setBackground(ButtonC);
        deleteB.setForeground(WhiteC);
        this.add(deleteB);

        deleteB.addActionListener(
                (e) -> {
                    dataManipulator.deleteFiles();
                    dispose();
                    new mainWindow();
                }
        );


        workoutNameP = new JPanel[6];
        workoutNameL = new JLabel[6];
        dataManipulator.loadWorkoutNames();
        int height = 75;
        int numWorkouts = dataManipulator.noOfFiles();

        for (int i=0; i < numWorkouts; i++) {

            String workoutName = dataManipulator.workoutNames[i];

            startB[i] = new JButton("▶");
            startB[i].setFocusable(false);
            startB[i].setBounds(420, height, 50, 50);
            startB[i].setBackground(ButtonC);
            startB[i].setForeground(WhiteC);
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
            infoB[i].setFont(new Font("Times New Roman", Font.BOLD, 31));
            infoB[i].setBackground(ButtonC);
            infoB[i].setForeground(WhiteC);
            infoB[i].setBounds(30, height, 50, 50);
            this.add(infoB[i]);

            infoB[i].addActionListener(
                    (e) -> {
                        new workoutInfoWindow(index); // TODO: add index for parameter
                        System.out.println(index);
                    }
            );


            workoutNameP[i] = new JPanel();
            workoutNameP[i].setLayout(new BorderLayout());
            workoutNameP[i].setBounds(100, height, 300, 50);
            workoutNameP[i].setBackground(ButtonC);

            workoutNameL[i] = new JLabel();
            workoutNameL[i].setText(workoutName);
            workoutNameL[i].setForeground(WhiteC);
            workoutNameL[i].setFont(new Font("Calibri", Font.PLAIN, 21)); // 21
            workoutNameL[i].setVerticalAlignment(SwingConstants.CENTER);
            workoutNameL[i].setHorizontalAlignment(SwingConstants.CENTER);

            workoutNameP[i].add(workoutNameL[i], BorderLayout.CENTER);
            this.add(workoutNameP[i]);

            height += 75;
        }
        // ---------------------------------------------------

        workoutNameTitleL = new JLabel("Workout Name");
        workoutNameTitleL.setBounds(175, 20, 200, 50);
        workoutNameTitleL.setFont(new Font("Calibri", Font.BOLD , 24));
        workoutNameTitleL.setForeground(LabelC);
        this.add(workoutNameTitleL);

    }
}