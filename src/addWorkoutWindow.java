import javax.swing.*;
import java.awt.*;

public class addWorkoutWindow extends JFrame
{
    JButton addExerciseB;
    JButton saveWorkoutB;
    JButton cancelWorkoutB;

    JLabel workoutNameL;
    JLabel exerciseNameL;
    JLabel noSetsL;
    JLabel noRepsL;
    JLabel noRestL;

    // text fields will be repeated...
    JTextField workoutNameTF;
    JTextField exerciseNameTF;
    JTextField noSetsTF;
    JTextField noRepsTF;
    JTextField noRestTF;


    int bY = 200; // todo: change according to the size of the boxes

    addWorkoutWindow()
    {

        // --- --- LABEL PROPERTIES --- ---
        workoutNameL = new JLabel();
        workoutNameL.setText("Workout Name: ");
        workoutNameL.setFont(new Font("Calibri", Font.BOLD, 21));
        workoutNameL.setForeground(new Color(230, 230, 230));
        workoutNameL.setBounds(70, 0, 200, 100);
        this.add(workoutNameL);

        exerciseNameL = new JLabel("Exercise Name");
        exerciseNameL.setFont(new Font("Calibri", Font.BOLD, 18));
        exerciseNameL.setForeground(new Color(230, 230, 230));
        exerciseNameL.setBounds(60, 50, 200, 100);
        this.add(exerciseNameL);

        noSetsL = new JLabel("Sets");
        noSetsL.setFont(new Font("Calibri", Font.BOLD, 18));
        noSetsL.setForeground(new Color(230, 230, 230));
        noSetsL.setBounds(240, 50, 200, 100);
        this.add(noSetsL);

        noRepsL = new JLabel("Reps");
        noRepsL.setFont(new Font("Calibri", Font.BOLD, 18));
        noRepsL.setForeground(new Color(230, 230, 230));
        noRepsL.setBounds(315, 50, 200, 100);
        this.add(noRepsL);

        noRestL = new JLabel("Rest");
        noRestL.setFont(new Font("Calibri", Font.BOLD, 18));
        noRestL.setForeground(new Color(230, 230, 230));
        noRestL.setBounds(400, 50, 200, 100);
        this.add(noRestL);
        // --------------------------------



        // --- --- TEXTFIELD PROPERTIES --- ---
        workoutNameTF = new JTextField();
        workoutNameTF.setBounds(230, 30, 200, 40);
        workoutNameTF.setFont(new Font("Calibri", Font.PLAIN, 23));
        this.add(workoutNameTF);

        exerciseNameTF = new JTextField();
        exerciseNameTF.setBounds(45, 120, 145, 25);
        exerciseNameTF.setFont(new Font("Calibri", Font.PLAIN, 18));
        this.add(exerciseNameTF);
        
        noSetsTF = new JTextField();
        noSetsTF.setBounds(235, 120, 40, 25);
        noSetsTF.setFont(new Font("Calibri", Font.PLAIN, 18));
        this.add(noSetsTF);
        
        noRepsTF = new JTextField();
        noRepsTF.setBounds(315, 120, 40, 25);
        noRepsTF.setFont(new Font("Calibri", Font.PLAIN, 18));
        this.add(noRepsTF);
        
        noRestTF = new JTextField();
        noRestTF.setBounds(400, 120, 40, 25);
        noRestTF.setFont(new Font("Calibri", Font.PLAIN, 18));
        this.add(noRestTF);
        // ------------------------------------




        // ---  ---  BUTTON PROPERTIES  ---  ---
        addExerciseB = new JButton("Add Exercise");
        addExerciseB.setFont(new Font("Calibri", Font.BOLD, 21));
        addExerciseB.setBounds(160, bY, 180, 40);
        addExerciseB.setFocusable(false);
        this.add(addExerciseB);

        saveWorkoutB = new JButton("Save");
        saveWorkoutB.setFont(new Font("Calibri", Font.BOLD, 21));
        saveWorkoutB.setBounds(20, bY, 100, 40);
        saveWorkoutB.setFocusable(false);
        this.add(saveWorkoutB);

        cancelWorkoutB = new JButton("Cancel");
        cancelWorkoutB.setFont(new Font("Calibri", Font.BOLD, 21));
        cancelWorkoutB.setBounds(380, bY, 100, 40);
        cancelWorkoutB.setFocusable(false);
        this.add(cancelWorkoutB);
        // --------------------------------------




        // ---  ---  BUTTON ACTIONS  ---  ---
        addExerciseB.addActionListener(

                (e) -> {
                        this.setSize(this.getWidth(), this.getHeight() + 80);
                        bY += 80;
                        addExerciseB.setBounds(160, bY, 180, 40);
                        saveWorkoutB.setBounds(20, bY, 100, 40);
                        cancelWorkoutB.setBounds(380, bY, 100, 40);
                        this.setLocationRelativeTo(null);
                }
        );

        cancelWorkoutB.addActionListener(
                (e) -> {
                    dispose();
                }
        );

        // --------------------------------------




        // ---  ---  WINDOW PROPERTIES  ---  ---
        this.setLayout(null);
        this.setSize(520, 300);

        this.getContentPane().setBackground(new Color(44, 43, 64));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.setVisible(true);
        // --------------------------------------
    }
}
