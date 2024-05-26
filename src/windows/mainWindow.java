package windows;

import data.dataManipulation;

import javax.swing.*;
import java.awt.*;

public class mainWindow extends JFrame
{

    JButton addWorkoutB, viewWorkoutsB, infoB;

    Color BackgroundC = new Color(0xFF2B2D30);
    Color WhiteC = new Color(0xfbffff);
    Color ButtonC = new Color(0x363A3D);

    Image title;
    ImageIcon icon = new ImageIcon("src/resources/images/icon.png");

    dataManipulation dataManipulator;

    public mainWindow()
    {
        dataManipulator = new dataManipulation();

        title = new ImageIcon("src/resources/images/cropped_icon.png").getImage();


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
                (e) -> new addWorkoutWindow()
        );



        String[] responses = {"OK", "Create Workout"};
        ImageIcon error = new ImageIcon("src/resources/images/error.png");

        // Show Option Dialog if there are no workouts to list
        viewWorkoutsB.addActionListener(
                (e) -> {
                    if (dataManipulator.noOfFiles()==0) {
                        int choice = JOptionPane.showOptionDialog(null, "You don't have any workouts saved!", "Error", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,error, responses, 0);
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
        this.setIconImage(icon.getImage());
        this.setSize(520, 520);
        this.getContentPane().setBackground(BackgroundC);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("myLift");
        this.setVisible(true);
        // --------------------------------------
    }


    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(title, 155, 55, null);  // Draw image using panel dimensions
    }

}