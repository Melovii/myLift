import javax.swing.*;
import java.awt.*;

public class mainWindow extends JFrame {

    JButton addWorkout;
    JButton workout;
    JButton viewWorkouts;

    mainWindow() {

        this.setLayout(new FlowLayout());


        addWorkout = new JButton("Add Workout");
        workout = new JButton("Workout!");
        viewWorkouts = new JButton("View Workout");

        addWorkout.addActionListener(
                (e) -> {
                    dispose();
                    new addWorkoutWindow();
                }
        );

        workout.addActionListener(
                (e) -> {
                    dispose();
                    new workoutWindow();
                }
        );

        viewWorkouts.addActionListener(
                (e) -> {
                    dispose();
                    new viewWorkoutsWindow();
                }
        );


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(addWorkout);
        this.add(workout);
        this.add(viewWorkouts);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);

    }
}