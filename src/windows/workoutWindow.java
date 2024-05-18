package windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.TimerTask;

import data.*;

public class workoutWindow extends JFrame {

    JButton startB;
    JLabel currentExL, nextExL, setsL, repsL, restL, elapsedTimeL;
    JPanel currentExP, nextExP;
    int elapsed_timeE, hoursE, minutesE, secondsE, timeLeft;

    Timer elapsedTimer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            elapsed_timeE += 1000;
            hoursE = elapsed_timeE/3600000;
            minutesE = (elapsed_timeE/60000)%60;
            secondsE = (elapsed_timeE/1000)%60;

            String hours_string = String.format("%02d", hoursE);
            String minutes_string = String.format("%02d", minutesE);
            String seconds_string = String.format("%02d", secondsE);

            elapsedTimeL.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        }
    });


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

        setsL = new JLabel();
        setsL.setText("Sets: ");
        setsL.setFont(new Font("Calibri", Font.BOLD, 25));
        setsL.setForeground(new Color(230, 230, 230));
        setsL.setBounds(100, 100, 100, 100);
        setsL.setVisible(false);
        this.add(setsL);

        repsL = new JLabel();
        repsL.setText("Reps: ");
        repsL.setFont(new Font("Calibri", Font.BOLD, 25));
        repsL.setForeground(new Color(230, 230, 230));
        repsL.setBounds(300, 100, 100, 100);
        repsL.setVisible(false);
        this.add(repsL);

        restL = new JLabel();
        restL.setText("Rest: ");
        restL.setFont(new Font("Calibri", Font.BOLD, 25));
        restL.setForeground(new Color(230, 230, 230));
        restL.setBounds(400, 100, 100, 100);
        restL.setVisible(false);
        this.add(restL);

        elapsedTimeL = new JLabel();
        elapsedTimeL.setText("00:00:00");
        elapsedTimeL.setFont(new Font("Calibri", Font.BOLD, 25));
        elapsedTimeL.setForeground(new Color(230, 230, 230));
        elapsedTimeL.setBounds(25, 0, 100, 100);
        elapsedTimer.start();
        this.add(elapsedTimeL);
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
                    if ((i.get()) % 2 == 0) {
                        startB.setText("Start");
                        int rest = dataManipulator.restTime[i.get() - 1];

                    } else {
                        startB.setText("Rest");
                    }

                    currentExL.setVisible(true);
                    currentExL.setText("Current Exercise: " + dataManipulator.exerciseName[i.get() - 1]);

                    setsL.setVisible(true);
                    setsL.setText("Sets: " + dataManipulator.numSets[i.get() - 1]);

                    repsL.setVisible(true);
                    repsL.setText("Reps: " + dataManipulator.numReps[i.get() - 1]);

                    nextExL.setVisible(true);
                    int indexo = i.get() + 1;
                    nextExL.setText("Next Exercise: " + dataManipulator.exerciseName[indexo - 1]);

                    restL.setVisible(true);
                    timeLeft = dataManipulator.restTime[i.get()-1];
                    startTimer();
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

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            timeLeft -= 1;
            restL.setText("" +timeLeft);
            if (timeLeft == 0)
            {
                timer.stop();
                restL.setText("TIMER ENDED");
            }
        }
    });

    public void startTimer()
    {
        timer.start();
    }

    public void stopTimer()
    {
        timer.stop();
    }
}


// TODO: change line datamanpulator to take variable "index"