package windows;

import data.dataManipulation;

import javax.swing.*;
import java.awt.*;

public class workoutInfoWindow extends JFrame {
    JLabel workoutNameL, exerciseNameL, noSetsL, noRepsL, noRestL;
    JLabel exerciseNameML, noSetsML, noRepsML, noRestML;  //ML = Main Label
    JLabel[] exerciseNameMLi = new JLabel[10];
    JLabel[] noSetsMLi = new JLabel[10];
    JLabel[] noRepsMLi = new JLabel[10];
    JLabel[] noRestMLi = new JLabel[10];
    dataManipulation dataManipulator;

    Color BackgroundC = new Color(0x2b3439);
    Color LabelC = new Color(0x35abff);
    Color WhiteC = new Color(0xfbffff);
    Color ButtonC = new Color(0x374049);
    Color CancelC = new Color(0xe85d69);
    Color ShadowC = new Color(0x191C1D);
    Color TERTIARY = new Color(0x3d464b);

    workoutInfoWindow(int index)
    {
        dataManipulator = new dataManipulation(index);
        dataManipulator.loadData(index);
        dataManipulator.loadWorkoutNames();

        // --- --- VARIABLES --- ---
        String workoutName = dataManipulator.workoutNames[index-1];
        // -------------------------

        // --- --- LABEL PROPERTIES --- ---
        workoutNameL = new JLabel();
        workoutNameL.setText("Workout Name: " + workoutName);
        workoutNameL.setFont(new Font("Calibri", Font.BOLD, 21));
        workoutNameL.setForeground(new Color(230, 230, 230));
        workoutNameL.setBounds(70, 0, 400, 100);
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



        // --- --- EXERCISE LABEL PROPERTIES --- ---

        exerciseNameML = new JLabel();
        exerciseNameML.setBounds(45, 120, 145, 25);
        exerciseNameML.setFont(new Font("Calibri", Font.PLAIN, 18));
        exerciseNameML.setForeground(new Color(230, 230, 230));
        exerciseNameML.setText(""+dataManipulator.exerciseName[0]);
        this.add(exerciseNameML);

        noSetsML = new JLabel();
        noSetsML.setBounds(235, 120, 40, 25);
        noSetsML.setFont(new Font("Calibri", Font.PLAIN, 18));
        noSetsML.setForeground(new Color(230, 230, 230));
        noSetsML.setText(""+dataManipulator.numSets[0]);
        this.add(noSetsML);

        noRepsML = new JLabel();
        noRepsML.setBounds(315, 120, 40, 25);
        noRepsML.setFont(new Font("Calibri", Font.PLAIN, 18));
        noRepsML.setForeground(new Color(230, 230, 230));
        noRepsML.setText(""+dataManipulator.numReps[0]);
        this.add(noRepsML);

        noRestML = new JLabel();
        noRestML.setBounds(400, 120, 40, 25);
        noRestML.setFont(new Font("Calibri", Font.PLAIN, 18));
        noRestML.setForeground(new Color(230, 230, 230));
        noRestML.setText(""+dataManipulator.restTime[0]);
        this.add(noRestML);
        // ------------------------------------



        // ---  ---  WINDOW PROPERTIES  ---  ---
        this.setLayout(null);
        this.setSize(520, 300);

        this.getContentPane().setBackground(BackgroundC);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Add Workout");

        this.setVisible(true);
        // --------------------------------------



        // ---  ---  Calls addBoxRow & Resizes Window according to exercise count  ---  ---
        for(int i = 0; i < dataManipulator.noOfExercises(index)-1; i++) {
            addBoxRow(i);
            this.setSize(this.getWidth(), this.getHeight() + 15);
        }

    }

    // Adds a row of exercises
    public void addBoxRow(int i)
    {
        int yPosition = (i+1) *50 + 120;

        exerciseNameMLi[i] = new JLabel();
        exerciseNameMLi[i].setBounds(45, yPosition, 145, 25);
        exerciseNameMLi[i].setFont(new Font("Calibri", Font.PLAIN, 18));
        exerciseNameMLi[i].setForeground(new Color(230, 230, 230));
        exerciseNameMLi[i].setText(""+dataManipulator.exerciseName[i+1]);
        this.add(exerciseNameMLi[i]);

        noSetsMLi[i] = new JLabel();
        noSetsMLi[i].setBounds(235, yPosition, 40, 25);
        noSetsMLi[i].setFont(new Font("Calibri", Font.PLAIN, 18));
        noSetsMLi[i].setForeground(new Color(230, 230, 230));
        noSetsMLi[i].setText(""+dataManipulator.numSets[i+1]);
        this.add(noSetsMLi[i]);

        noRepsMLi[i] = new JLabel();
        noRepsMLi[i].setBounds(315, yPosition, 40, 25);
        noRepsMLi[i].setFont(new Font("Calibri", Font.PLAIN, 18));
        noRepsMLi[i].setForeground(new Color(230, 230, 230));
        noRepsMLi[i].setText(""+dataManipulator.numReps[i+1]);
        this.add(noRepsMLi[i]);

        noRestMLi[i] = new JLabel();
        noRestMLi[i].setBounds(400, yPosition, 40, 25);
        noRestMLi[i].setFont(new Font("Calibri", Font.PLAIN, 18));
        noRestMLi[i].setForeground(new Color(230, 230, 230));
        noRestMLi[i].setText(""+dataManipulator.restTime[i+1]);
        this.add(noRestMLi[i]);
    }
}