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
    JPanel workoutP;
    dataManipulation dataManipulator;

    Color BackgroundC = new Color(0xFF2B2D30);
    Color LabelC = new Color(0x73fbfd);
    Color WhiteC = new Color(0xfbffff);

    ImageIcon icon = new ImageIcon("src/resources/images/icon.png");

    workoutInfoWindow(int index)
    {
        // Instantiate dataManipulator class and load workout data
        dataManipulator = new dataManipulation(index);
        dataManipulator.loadData(index);
        dataManipulator.loadWorkoutNames();

        String workoutName = dataManipulator.workoutNames[index-1];

        workoutP = new JPanel(new BorderLayout());
        workoutP.setBackground(BackgroundC);
        workoutP.setBounds(0, 0, 520, 75);
        this.add(workoutP);

        // --- --- LABEL PROPERTIES --- ---
        workoutNameL = new JLabel();
        workoutNameL.setText("" + workoutName);
        workoutNameL.setFont(new Font("Gadugi", Font.BOLD, 21));
        workoutNameL.setForeground(WhiteC);
        workoutNameL.setHorizontalAlignment(SwingConstants.CENTER);
        workoutNameL.setVerticalAlignment(SwingConstants.CENTER);
        workoutP.add(workoutNameL);

        exerciseNameL = new JLabel("Exercise Name");
        exerciseNameL.setFont(new Font("Gadugi", Font.BOLD, 16));
        exerciseNameL.setForeground(LabelC);
        exerciseNameL.setBounds(60, 40, 200, 100);
        this.add(exerciseNameL);

        noSetsL = new JLabel("Sets");
        noSetsL.setFont(new Font("Gadugi", Font.BOLD, 16));
        noSetsL.setForeground(LabelC);
        noSetsL.setBounds(240, 40, 200, 100);
        this.add(noSetsL);

        noRepsL = new JLabel("Reps");
        noRepsL.setFont(new Font("Gadugi", Font.BOLD, 16));
        noRepsL.setForeground(LabelC);
        noRepsL.setBounds(315, 40, 200, 100);
        this.add(noRepsL);

        noRestL = new JLabel("Rest");
        noRestL.setFont(new Font("Gadugi", Font.BOLD, 16));
        noRestL.setForeground(LabelC);
        noRestL.setBounds(400, 40, 200, 100);
        this.add(noRestL);
        // --------------------------------



        // --- --- EXERCISE LABEL PROPERTIES --- ---
        exerciseNameML = new JLabel();
        exerciseNameML.setBounds(62, 120, 145, 25);
        exerciseNameML.setFont(new Font("Gadugi", Font.PLAIN, 16));
        exerciseNameML.setForeground(WhiteC);
        exerciseNameML.setText(""+dataManipulator.exerciseName[0]);
        this.add(exerciseNameML);

        noSetsML = new JLabel();
        noSetsML.setBounds(248, 120, 40, 25);
        noSetsML.setFont(new Font("Gadugi", Font.PLAIN, 16));
        noSetsML.setForeground(WhiteC);
        noSetsML.setText(""+dataManipulator.numSets[0]);
        this.add(noSetsML);

        noRepsML = new JLabel();
        noRepsML.setBounds(323, 120, 40, 25);
        noRepsML.setFont(new Font("Gadugi", Font.PLAIN, 16));
        noRepsML.setForeground(WhiteC);
        noRepsML.setText(""+dataManipulator.numReps[0]);
        this.add(noRepsML);

        noRestML = new JLabel();
        noRestML.setBounds(407, 120, 40, 25);
        noRestML.setFont(new Font("Gadugi", Font.PLAIN, 16));
        noRestML.setForeground(WhiteC);
        noRestML.setText(""+dataManipulator.restTime[0]);
        this.add(noRestML);
        // ------------------------------------



        // ---  ---  WINDOW PROPERTIES  ---  ---
        this.setLayout(null);
        this.setSize(520, 300);
        this.setTitle("Workout Info");
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(BackgroundC);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Add Workout");

        this.setVisible(true);
        // --------------------------------------



        // ---  ---  Calls addBoxRow & resizes window according to number of exercises  ---  ---
        for(int i = 0; i < dataManipulator.noOfExercises(index)-1; i++) {
            addBoxRow(i);
        }

    }

    // Adds a row of exercise labels
    public void addBoxRow(int i)
    {
        int yPosition = (i+1) *50 + 120;
        this.setSize(this.getWidth(), yPosition+88);

        exerciseNameMLi[i] = new JLabel();
        exerciseNameMLi[i].setBounds(62, yPosition, 145, 25);
        exerciseNameMLi[i].setFont(new Font("Gadugi", Font.PLAIN, 16));
        exerciseNameMLi[i].setForeground(WhiteC);
        exerciseNameMLi[i].setText(""+dataManipulator.exerciseName[i+1]);
        this.add(exerciseNameMLi[i]);

        noSetsMLi[i] = new JLabel();
        noSetsMLi[i].setBounds(248, yPosition, 40, 25);
        noSetsMLi[i].setFont(new Font("Gadugi", Font.PLAIN, 16));
        noSetsMLi[i].setForeground(WhiteC);
        noSetsMLi[i].setText(""+dataManipulator.numSets[i+1]);
        this.add(noSetsMLi[i]);

        noRepsMLi[i] = new JLabel();
        noRepsMLi[i].setBounds(323, yPosition, 40, 25);
        noRepsMLi[i].setFont(new Font("Gadugi", Font.PLAIN, 16));
        noRepsMLi[i].setForeground(WhiteC);
        noRepsMLi[i].setText(""+dataManipulator.numReps[i+1]);
        this.add(noRepsMLi[i]);

        noRestMLi[i] = new JLabel();
        noRestMLi[i].setBounds(407, yPosition, 40, 25);
        noRestMLi[i].setFont(new Font("Gadugi", Font.PLAIN, 16));
        noRestMLi[i].setForeground(WhiteC);
        noRestMLi[i].setText(""+dataManipulator.restTime[i+1]);
        this.add(noRestMLi[i]);
    }
}