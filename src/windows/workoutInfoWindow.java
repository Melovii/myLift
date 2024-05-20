package windows;

import data.dataManipulation;
import data.exercise;
import data.workout;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

public class workoutInfoWindow extends JFrame {
    JLabel workoutNameL, exerciseNameL, noSetsL, noRepsL, noRestL;
    JLabel workoutNameML, exerciseNameML, noSetsML, noRepsML, noRestML;  //ML = Main Label
    JLabel[] exerciseNameMLi = new JLabel[10];
    JLabel[] noSetsMLi = new JLabel[10];
    JLabel[] noRepsMLi = new JLabel[10];
    JLabel[] noRestMLi = new JLabel[10];
    dataManipulation dataManipulator = new dataManipulation();

    int bY = 200;

    workoutInfoWindow(int index)
    {
        dataManipulator.loadData(index);
        dataManipulator.loadWorkoutNames();

        // --- --- LABEL PROPERTIES --- ---
        workoutNameL = new JLabel();
        workoutNameL.setText("Workout Name: "+dataManipulator.workoutNames[index-1]);
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



        // --- --- TEXTFIELD PROPERTIES --- ---
        workoutNameML = new JLabel();
        workoutNameML.setBounds(230, 30, 200, 40);
        workoutNameML.setFont(new Font("Calibri", Font.PLAIN, 23));
        this.add(workoutNameML);

        exerciseNameML = new JLabel();
        exerciseNameML.setBounds(45, 120, 145, 25);
        exerciseNameML.setFont(new Font("Calibri", Font.PLAIN, 18));
        this.add(exerciseNameML);

        noSetsML = new JLabel();
        noSetsML.setBounds(235, 120, 40, 25);
        noSetsML.setFont(new Font("Calibri", Font.PLAIN, 18));
        this.add(noSetsML);

        noRepsML = new JLabel();
        noRepsML.setBounds(315, 120, 40, 25);
        noRepsML.setFont(new Font("Calibri", Font.PLAIN, 18));
        this.add(noRepsML);

        noRestML = new JLabel();
        noRestML.setBounds(400, 120, 40, 25);
        noRestML.setFont(new Font("Calibri", Font.PLAIN, 18));
        this.add(noRestML);
        // ------------------------------------

        int excButtonWidth = 180;

        AtomicInteger i = new AtomicInteger();


        // ---  ---  WINDOW PROPERTIES  ---  ---
        this.setLayout(null);
        this.setSize(520, 300);

        this.getContentPane().setBackground(new Color(44, 43, 64));
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

        exerciseNameMLi[i] = new JLabel();
        exerciseNameMLi[i].setBounds(45, yPosition, 145, 25);
        exerciseNameMLi[i].setFont(new Font("Calibri", Font.PLAIN, 18));
        this.add(exerciseNameMLi[i]);

        noSetsMLi[i] = new JLabel();
        noSetsMLi[i].setBounds(235, yPosition, 40, 25);
        noSetsMLi[i].setFont(new Font("Calibri", Font.PLAIN, 18));
        this.add(noSetsMLi[i]);

        noRepsMLi[i] = new JLabel();
        noRepsMLi[i].setBounds(315, yPosition, 40, 25);
        noRepsMLi[i].setFont(new Font("Calibri", Font.PLAIN, 18));
        this.add(noRepsMLi[i]);

        noRestMLi[i] = new JLabel();
        noRestMLi[i].setBounds(400, yPosition, 40, 25);
        noRestMLi[i].setFont(new Font("Calibri", Font.PLAIN, 18));
        this.add(noRestMLi[i]);
    }

    public void removeBoxRow(int i)
    {
        if (exerciseNameMLi[i] != null) {
            this.remove(exerciseNameMLi[i]);
        }
        if (noSetsMLi[i] != null) {
            this.remove(noSetsMLi[i]);
        }
        if (noRepsMLi[i] != null) {
            this.remove(noRepsMLi[i]);
        }
        if (noRestMLi[i] != null) {
            this.remove(noRestMLi[i]);
        }
        // Set to null to avoid null pointer exceptions
        exerciseNameMLi[i] = null;
        noSetsMLi[i] = null;
        noRepsMLi[i] = null;
        noRestMLi[i] = null;
    }
}