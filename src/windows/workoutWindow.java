package windows;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

import data.*;

public class workoutWindow extends JFrame {

    JButton startB;
    JLabel currentExL, nextExL, elapsedTime;
    JPanel currentExP, nextExP;

    workoutWindow(int index) {

        dataManipulation dataManipulator = new dataManipulation(index);
        dataManipulator.loadData(1); // TODO: INPUT INDEX FROM USER


        this.setLayout(null);


        // --- --- PANEL PROPERTIES --- ---
        currentExP = new JPanel(new BorderLayout());
        currentExP.setBounds(0, 30, 800, 50);
        currentExP.setOpaque(false);
        this.add(currentExP);

        nextExP = new JPanel(new BorderLayout());
        nextExP.setBounds(0, 490, 800, 50);
        nextExP.setOpaque(false);
        this.add(nextExP);
        // --------------------------------



        // --- --- LABEL PROPERTIES --- ---
        currentExL = new JLabel();
        currentExL.setText("Current Exercise:");
        currentExL.setFont(new Font("Calibri", Font.BOLD, 35));
        currentExL.setForeground(new Color(230, 230, 230));
        currentExL.setHorizontalAlignment(SwingConstants.CENTER);
        currentExL.setVerticalAlignment(SwingConstants.TOP);
        currentExL.setVisible(false);
        currentExP.add(currentExL);

        nextExL = new JLabel();
        nextExL.setText("Next Exercise:");
        nextExL.setFont(new Font("Calibri", Font.BOLD, 35));
        nextExL.setForeground(new Color(230, 230, 230));
        nextExL.setHorizontalAlignment(SwingConstants.CENTER);
        nextExL.setVerticalAlignment(SwingConstants.TOP);
        nextExL.setVisible(false);
        nextExP.add(nextExL);

        elapsedTime = new JLabel();
        elapsedTime.setText("00:00");
        elapsedTime.setFont(new Font("Calibri", Font.BOLD, 25));
        elapsedTime.setForeground(new Color(230, 230, 230));
        elapsedTime.setBounds(25, 0, 100, 100);
        this.add(elapsedTime);
        // --------------------------------



        // --- --- BUTTON PROPERTIES --- ---
        startB = new JButton("Start");
        startB.setFont(new Font("Calibri", Font.BOLD, 21));
        startB.setBounds(275, 225 - 16, 250, 150);
        startB.setFocusable(false);
        this.add(startB);
        // --------------------------------



        // --- --- BUTTON ACTIONS --- ---
        // TODO: make a breakpoint for when next and current exercise are equal (in terms of index)
        AtomicInteger i = new AtomicInteger();
        startB.addActionListener(
                (e) -> {
                    i.getAndIncrement();
                    if ((i.get())%2 == 0) {
                        startB.setText("Start");
                    } else {
                        startB.setText("Rest");
                    }
                    currentExL.setVisible(true);
                    currentExL.setText("Current Exercise: "+dataManipulator.exerciseName[i.get()]);
                    nextExL.setVisible(true);
                    int indexo = i.get() + 1;
                    nextExL.setText("Next Exercise: "+dataManipulator.exerciseName[indexo]);
                }
        );
        // --------------------------------




        // ---  ---  WINDOW PROPERTIES  ---  ---
        this.setSize(800, 600);

        this.getContentPane().setBackground(new Color(44, 43, 64));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.setVisible(true);
        // --------------------------------------

    }
}


// TODO: change line datamanpulator to take variable "index"