package windows;

import data.dataManipulation;
import data.exercise;
import data.workout;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

public class addWorkoutWindow extends JFrame {
    JButton delExerciseB; // TODO: check if necessary
    JButton addExerciseB, cancelWorkoutB, saveWorkoutB;
    JLabel workoutNameL, exerciseNameL, noSetsL, noRepsL, noRestL;
    JTextField workoutNameTF, exerciseNameTF, noSetsTF, noRepsTF, noRestTF;
    JTextField[] exerciseNameTFi = new JTextField[10];
    JTextField[] noSetsTFi = new JTextField[10];
    JTextField[] noRepsTFi = new JTextField[10];
    JTextField[] noRestTFi = new JTextField[10];
    dataManipulation dataManipulator = new dataManipulation();

    Color BackgroundC = new Color(0x2b3439);
    Color LabelC = new Color(0x35abff);
    Color WhiteC = new Color(0xfbffff);
    Color ButtonC = new Color(0x374049);
    Color CancelC = new Color(0xe85d69);
    Color ShadowC = new Color(0x191C1D);
    Color TERTIARY = new Color(0x3d464b);

    int bY = 200;

    addWorkoutWindow()
    {
        // --- --- LABEL PROPERTIES --- ---
        workoutNameL = new JLabel();
        workoutNameL.setText("Workout Name: ");
        workoutNameL.setFont(new Font("Calibri", Font.BOLD, 21));
        workoutNameL.setForeground(WhiteC);
        workoutNameL.setBounds(70, 0, 200, 100);
        this.add(workoutNameL);

        exerciseNameL = new JLabel("Exercise Name");
        exerciseNameL.setFont(new Font("Calibri", Font.BOLD, 18));
        exerciseNameL.setForeground(WhiteC);
        exerciseNameL.setBounds(60, 50, 200, 100);
        this.add(exerciseNameL);

        noSetsL = new JLabel("Sets");
        noSetsL.setFont(new Font("Calibri", Font.BOLD, 18));
        noSetsL.setForeground(WhiteC);
        noSetsL.setBounds(240, 50, 200, 100);
        this.add(noSetsL);

        noRepsL = new JLabel("Reps");
        noRepsL.setFont(new Font("Calibri", Font.BOLD, 18));
        noRepsL.setForeground(WhiteC);
        noRepsL.setBounds(315, 50, 200, 100);
        this.add(noRepsL);

        noRestL = new JLabel("Rest");
        noRestL.setFont(new Font("Calibri", Font.BOLD, 18));
        noRestL.setForeground(WhiteC);
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
        
        
        int excButtonWidth = 180;

        // ---  ---  BUTTON PROPERTIES  ---  ---
        addExerciseB = new JButton("Add Exercise");
        addExerciseB.setFont(new Font("Calibri", Font.BOLD, 21));
        addExerciseB.setForeground(WhiteC);
        addExerciseB.setBounds(160, bY, excButtonWidth, 40);
        addExerciseB.setFocusable(false);
        addExerciseB.setBackground(ButtonC);
        this.add(addExerciseB);

        cancelWorkoutB = new JButton("Cancel");
        cancelWorkoutB.setFont(new Font("Calibri", Font.BOLD, 21));
        cancelWorkoutB.setForeground(WhiteC);
        cancelWorkoutB.setBounds(20, bY, 100, 40);
        cancelWorkoutB.setFocusable(false);
        cancelWorkoutB.setBackground(ButtonC);
        this.add(cancelWorkoutB);

        saveWorkoutB = new JButton("Save");
        saveWorkoutB.setFont(new Font("Calibri", Font.BOLD, 21));
        saveWorkoutB.setForeground(WhiteC);
        saveWorkoutB.setBounds(380, bY, 100, 40);
        saveWorkoutB.setFocusable(false);
        saveWorkoutB.setBackground(ButtonC);
        this.add(saveWorkoutB);

        delExerciseB = new JButton("Delete Exercise");
        delExerciseB.setFont(new Font("Calibri", Font.BOLD, 21));
        delExerciseB.setForeground(WhiteC);
        delExerciseB.setBounds(280, bY, excButtonWidth, 40);
        delExerciseB.setFocusable(false);
        delExerciseB.setBackground(ButtonC);
//        this.add(delExerciseB);
        // --------------------------------------



        AtomicInteger i = new AtomicInteger();

        // ---  ---  BUTTON ACTIONS  ---  ---
        addExerciseB.addActionListener(
                (e) -> {
                        try {
                            i.getAndIncrement();
                            addBoxRow(i.get());
                            this.setSize(this.getWidth(), this.getHeight() + 50);
                            bY += 50;
                            addExerciseB.setBounds(160, bY, excButtonWidth, 40);
                            cancelWorkoutB.setBounds(20, bY, 100, 40);
                            saveWorkoutB.setBounds(380, bY, 100, 40);
                            delExerciseB.setBounds(280, bY, excButtonWidth, 40);
                            this.setLocationRelativeTo(null);
                        } catch (Exception excess) {
                            addExerciseB.setEnabled(false);
                            System.out.println("Error adding exercise: " +excess.getMessage());
                        }
                }
        );

        delExerciseB.addActionListener(
                (e) -> {
                    try {
                        i.getAndDecrement();
                        removeBoxRow(i.get());
                        this.setSize(this.getWidth(), this.getHeight() - 50);
                        bY -= 50;
                        addExerciseB.setBounds(160, bY, excButtonWidth, 40);
                        cancelWorkoutB.setBounds(20, bY, 100, 40);
                        saveWorkoutB.setBounds(380, bY, 100, 40);
                        delExerciseB.setBounds(280, bY, excButtonWidth, 40);
                        this.setLocationRelativeTo(null);
                    } catch (Exception lack) {
                        System.out.println("Error deleting exercise: " +lack.getMessage());
                    }
                }
        );


        cancelWorkoutB.addActionListener(
                (e) -> {
                    dispose();
                    new mainWindow();
                }
        );


        saveWorkoutB.addActionListener(
                (e) -> {
                    try {
                        // Create a new workout object
                        workout workoutToSave = new workout(workoutNameTF.getText());

                        // Add data from the first row of JTextFields
                        String exerciseName = exerciseNameTF.getText();
                        int numSets = Integer.parseInt(noSetsTF.getText());
                        int numReps = Integer.parseInt(noRepsTF.getText());
                        int restTime = Integer.parseInt(noRestTF.getText());
                        exercise firstExercise = new exercise(exerciseName, numSets, numReps, restTime);
                        workoutToSave.exercises.add(firstExercise);

                        // Add data from the rest of the JTextFields
                        for (int k = 0; k < exerciseNameTFi.length; k++) {
                            if (exerciseNameTFi[k] != null && noSetsTFi[k] != null && noRepsTFi[k] != null && noRestTFi[k] != null) {
                                String name = exerciseNameTFi[k].getText();
                                int sets = Integer.parseInt(noSetsTFi[k].getText());
                                int reps = Integer.parseInt(noRepsTFi[k].getText());
                                int rest = Integer.parseInt(noRestTFi[k].getText());
                                exercise additionalExercise = new exercise(name, sets, reps, rest);
                                workoutToSave.exercises.add(additionalExercise);
                            }
                        }

                        // Call dataManipulation to save the workout (assuming dataManipulation is instantiated)
                        dataManipulator.saveData(workoutToSave);

                        // Show success message
                        JOptionPane.showMessageDialog(null, "Workout saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        new mainWindow();

                    } catch (Exception ex) {
                        // Show error message
                        JOptionPane.showMessageDialog(null, "Error saving workout: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
        );

        // --------------------------------------



        // ---  ---  WINDOW PROPERTIES  ---  ---
        this.setLayout(null);
        this.setSize(520, 300);

        this.getContentPane().setBackground(BackgroundC);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Add Workout");

        this.setVisible(true);
        // --------------------------------------
    }



    // Add a row of JTextFields
    public void addBoxRow(int i)
    {
        int yPosition = i * 50 + 120;

        exerciseNameTFi[i] = new JTextField();
        exerciseNameTFi[i].setBounds(45, yPosition, 145, 25);
        exerciseNameTFi[i].setFont(new Font("Calibri", Font.PLAIN, 18));
        this.add(exerciseNameTFi[i]);

        noSetsTFi[i] = new JTextField();
        noSetsTFi[i].setBounds(235, yPosition, 40, 25);
        noSetsTFi[i].setFont(new Font("Calibri", Font.PLAIN, 18));
        this.add(noSetsTFi[i]);

        noRepsTFi[i] = new JTextField();
        noRepsTFi[i].setBounds(315, yPosition, 40, 25);
        noRepsTFi[i].setFont(new Font("Calibri", Font.PLAIN, 18));
        this.add(noRepsTFi[i]);

        noRestTFi[i] = new JTextField();
        noRestTFi[i].setBounds(400, yPosition, 40, 25);
        noRestTFi[i].setFont(new Font("Calibri", Font.PLAIN, 18));
        this.add(noRestTFi[i]);
    }

    public void removeBoxRow(int i)
    {
        if (exerciseNameTFi[i] != null) {
            this.remove(exerciseNameTFi[i]);
        }
        if (noSetsTFi[i] != null) {
            this.remove(noSetsTFi[i]);
        }
        if (noRepsTFi[i] != null) {
            this.remove(noRepsTFi[i]);
        }
        if (noRestTFi[i] != null) {
            this.remove(noRestTFi[i]);
        }
        // Set to null to avoid null pointer exceptions
        exerciseNameTFi[i] = null;
        noSetsTFi[i] = null;
        noRepsTFi[i] = null;
        noRestTFi[i] = null;
    }
}