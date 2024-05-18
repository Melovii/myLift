package windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.TimerTask;

import data.*;

public class workoutWindow extends JFrame {

    JButton startB, setB, restB;
    JLabel currentExL, nextExL, setsL, repsL, restL, elapsedTimeL, setsLeftL;
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
        dataManipulator.loadData(2); // TODO: INPUT INDEX FROM USER


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

        setsLeftL = new JLabel();
        setsLeftL.setText("Sets left: ");
        setsLeftL.setFont(new Font("Calibri", Font.BOLD, 25));
        setsLeftL.setForeground(new Color(230, 230, 230));
        setsLeftL.setBounds(100, 200, 300, 100);
        setsLeftL.setVisible(true);
        this.add(setsLeftL);

        repsL = new JLabel();
        repsL.setText("Reps: ");
        repsL.setFont(new Font("Calibri", Font.BOLD, 25));
        repsL.setForeground(new Color(230, 230, 230));
        repsL.setBounds(300, 100, 100, 100);
        repsL.setVisible(false);
        this.add(repsL);


        restL = new JLabel();
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

        setB = new JButton("Start set");
        setB.setFont(new Font("Calibri", Font.BOLD, 21));
        setB.setBounds(275, 225 - 16, 250, 150);
        setB.setFocusable(false);
        setB.setVisible(false);
        this.add(setB);

        restB = new JButton("Rest");
        restB.setFont(new Font("Calibri", Font.BOLD, 21));
        restB.setBounds(275, 225 - 16, 250, 150);
        restB.setFocusable(false);
        restB.setVisible(false);
        this.add(restB);
        // --------------------------------



        // --- --- BUTTON ACTIONS --- ---
        // TODO: make a breakpoint for when next and current exercise are equal (in terms of index)
        AtomicInteger i = new AtomicInteger();
        AtomicInteger j = new AtomicInteger();
        startB.addActionListener(
                (e) -> {

                    try {
                        i.getAndIncrement();

                        currentExL.setVisible(true);
                        currentExL.setText("Current Exercise: " + dataManipulator.exerciseName[i.get() - 1]);

                        setsL.setVisible(true);
                        int sets = dataManipulator.numSets[i.get() - 1];
                        setsL.setText("Sets: " + sets);

                        j.set(0);
                        sets += j.getAndIncrement();
                        setsLeftL.setText("Sets left: "+sets);

                        repsL.setVisible(true);
                        repsL.setText("Reps: " + dataManipulator.numReps[i.get() - 1]);

                        nextExL.setVisible(true);
                        int indexo = i.get() + 1;
                        nextExL.setText("Next Exercise: " + dataManipulator.exerciseName[indexo - 1]);

                        restL.setVisible(false);
                        startB.setVisible(false);
                        restB.setVisible(true);
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        System.out.println("brauh");;
                        dispose();
                        JOptionPane.showMessageDialog(null, "You finished your workout!");
                    }
                }
        );

        setB.addActionListener(
                (e) -> {
                    int setsLeft = dataManipulator.numSets[i.get()-1] - j.getAndIncrement();
                    setsLeftL.setText("Sets left: "+setsLeft);
                    setB.setVisible(false);
                    restB.setVisible(true);
                    restL.setVisible(false);
                }
        );

        restB.addActionListener(
                (e) -> {
                    timeLeft = dataManipulator.restTime[i.get() - 1];
                    restL.setText(""+timeLeft);
                    timeLeft--;
                    startTimer();
                    restL.setVisible(true);
                    restB.setVisible(false);
                    if(setsLeftL.getText().equals("Sets left: 1")) {
                        startB.setVisible(true);
                    } else {
                        setB.setVisible(true);
                    }
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
            restL.setText("" + timeLeft);
            if (timeLeft == 0) {
                timer.stop();
                restL.setText("TIMER ENDED");
            }
            timeLeft -= 1;
        }
    }
    );

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