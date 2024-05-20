package windows;

import javax.swing.*;
import java.awt.*;

public class mainWindow extends JFrame
{

    JButton addWorkoutB, workoutB, viewWorkoutsB, infoB; // let it be small and closable
    JLabel mainTitle;


    public mainWindow()
    {
        this.setLayout(null);
        this.setSize(520, 520);

        mainTitle = new JLabel();
        mainTitle.setText("myLift");
        mainTitle.setFont(new Font("Calibri", Font.BOLD , 44));
        mainTitle.setBounds(200, 50, 280, 60);
        mainTitle.setForeground(new Color(27, 127, 222));
        this.add(mainTitle);

        // ---  ---  BUTTON PROPERTIES  ---  ---
        infoB = new JButton("i");
        infoB.setFont(new Font("Times New Roman", Font.BOLD, 26));
        infoB.setBounds(20, 420, 44, 44);
        infoB.setFocusable(false);
        infoB.setBackground(Color.WHITE);
        this.add(infoB);

        addWorkoutB = new JButton("Add Workout");
        addWorkoutB.setBounds(120, 140, 280, 60);
        addWorkoutB.setFocusable(false);
        addWorkoutB.setBackground(Color.WHITE);
        this.add(addWorkoutB);

        workoutB = new JButton("Start Workout");
        workoutB.setBounds(120, 240, 280, 60);
        workoutB.setFocusable(false);
        workoutB.setBackground(Color.WHITE);
        this.add(workoutB);

        viewWorkoutsB = new JButton("Workouts List");
        viewWorkoutsB.setBounds(120, 340, 280, 60);
        viewWorkoutsB.setFocusable(false);
        viewWorkoutsB.setBackground(Color.WHITE);
        this.add(viewWorkoutsB);
        // -------------------------------------



        // ---  ---  BUTTON ACTIONS  ---  ---
        infoB.addActionListener(
                (e) -> new infoWindow()
        );

        addWorkoutB.addActionListener(
                (e) -> {
                    dispose();
                    new addWorkoutWindow();
                }
        );

        workoutB.addActionListener(
                (e) -> {
                    dispose();
                    new workoutWindow(2); // TODO: ASK USER FOR INDEX (VIEW WORKOUTS)
                }
        );

        viewWorkoutsB.addActionListener(
                (e) -> {
                    dispose();
                    new viewWorkoutsWindow();
                }
        );
        // -----------------------------------



        // ---  ---  WINDOW PROPERTIES  ---  ---
        this.getContentPane().setBackground(new Color(44, 43, 64));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("myLift");
        this.setVisible(true);
        // --------------------------------------
    }
}