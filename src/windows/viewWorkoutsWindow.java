package windows;

import javax.swing.*;
import java.awt.*;

public class viewWorkoutsWindow extends JFrame
{
    JButton returnB, infoB, startB;
    JPanel workoutNameP;

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



        // ---  ---  BUTTON PROPERTIES  ---  ---
        returnB = new JButton("←");
        returnB.setFont(new Font("Calibri", Font.BOLD, 25));
        returnB.setBounds(10, 495, 59, 59);
        returnB.setFocusable(false);
        returnB.setBackground(Color.WHITE);
        returnB.setBorder(BorderFactory.createLineBorder(new Color(27, 127, 222), 4));
        this.add(returnB);

        startB = new JButton("▶");
        startB.setFocusable(false);
        startB.setBackground(Color.WHITE);
        startB.setBounds(420, 60, 50, 50);
        startB.setBorder(BorderFactory.createLineBorder(new Color(27, 127, 222), 4));
        this.add(startB);

        infoB = new JButton("i");
        infoB.setFocusable(false);
        infoB.setBackground(Color.WHITE);
        infoB.setFont(new Font("Times New Roman", Font.BOLD, 31));
        infoB.setBounds(30, 60, 50, 50);
        infoB.setBorder(BorderFactory.createLineBorder(new Color(27, 127, 222), 4));
        this.add(infoB);
        // -------------------------------------



        // ---  ---  BUTTON ACTIONS  ---  ---
        returnB.addActionListener(
                (e) -> {
                    dispose();
                    new mainWindow();
                }
        );

        startB.addActionListener(
                (e) -> {
                    dispose();
                    new workoutWindow(1); // TODO: add index for parameter
                }
        );

        infoB.addActionListener(
                (e) -> {
                    new workoutInfoWindow(); // TODO: add index for parameter
                }
        );
        // ----------------------------------



        // ---  ---  PANEL PROPERTIES  ---  ---
        workoutNameP = new JPanel();
        workoutNameP.setBorder(BorderFactory.createLineBorder(new Color(27, 127, 222), 4));
        workoutNameP.setBounds(100, 60, 300, 50);
        this.add(workoutNameP);
        // ------------------------------------
    }
}