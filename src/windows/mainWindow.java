package windows;

import javax.swing.*;
import java.awt.*;

public class mainWindow extends JFrame
{

    JButton addWorkoutB, workoutB, viewWorkoutsB, infoB; // let it be small and closable
    JLabel mainTitle, mainTitleShadow;

    Color BackgroundC = new Color(0x2b3439);
    Color LabelC = new Color(0x35abff);
    Color WhiteC = new Color(0xfbffff);
    Color ButtonC = new Color(0x374049);
    Color CancelC = new Color(0xe85d69);
    Color ShadowC = new Color(0x191C1D);
    Color TERTIARY = new Color(0x3d464b);


    public mainWindow()
    {
        this.setLayout(null);
        this.setSize(520, 520);

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
        infoB = new JButton("i");
        infoB.setFont(new Font("Times New Roman", Font.BOLD, 26));
        infoB.setForeground(WhiteC);
        infoB.setBounds(20, 420, 44, 44);
        infoB.setFocusable(false);
        infoB.setBackground(ButtonC);
        this.add(infoB);

        addWorkoutB = new JButton("Add Workout");
        addWorkoutB.setForeground(WhiteC);
        addWorkoutB.setBounds(120, 140, 280, 60);
        addWorkoutB.setFocusable(false);
        addWorkoutB.setBackground(ButtonC);
        this.add(addWorkoutB);

        workoutB = new JButton("Start Workout");
        workoutB.setForeground(WhiteC);
        workoutB.setBounds(120, 240, 280, 60);
        workoutB.setFocusable(false);
        workoutB.setBackground(ButtonC);
        this.add(workoutB);

        viewWorkoutsB = new JButton("Workouts List");
        viewWorkoutsB.setForeground(WhiteC);
        viewWorkoutsB.setBounds(120, 340, 280, 60);
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
                    dispose();

                        new addWorkoutWindow();
                }
        );

        workoutB.addActionListener(
                (e) -> {
                    dispose();
                    new workoutWindow(1); // TODO: ASK USER FOR INDEX (VIEW WORKOUTS)
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
        this.getContentPane().setBackground(BackgroundC);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("myLift");
        this.setVisible(true);
        // --------------------------------------
    }
}