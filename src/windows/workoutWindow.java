package windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicInteger;

import data.*;

public class workoutWindow extends JFrame {

    JButton startB, setB, restB;
    JLabel currentExL, nextExL, repsL, restL, elapsedTimeL, setsLeftL;
    JPanel currentExP, nextExP;
    int elapsed_timeE, hoursE, minutesE, secondsE, timeLeft;
    sound sound;

    Color BackgroundC = new Color(0xFF2B2D30);
    Color ButtonC = new Color(0x363A3D);
    Color LabelC = new Color(0x73fbfd);
        Color WhiteC = new Color(0xfbffff);

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
        dataManipulator.loadData(index);
        sound = new sound();

        // --- --- PANEL PROPERTIES --- ---
        currentExP = new JPanel(new BorderLayout());
        currentExP.setBounds(100, 25, 550, 50);
        currentExP.setOpaque(false);
        this.add(currentExP);

        nextExP = new JPanel(new BorderLayout());
        nextExP.setBounds(100, 445, 550, 50);
        nextExP.setOpaque(false);
        this.add(nextExP);
        // --------------------------------



        // --- --- LABEL PROPERTIES --- ---
        currentExL = new JLabel();
        currentExL.setText("Current Exercise:");
        currentExL.setFont(new Font("Gadugi", Font.BOLD, 30));
        currentExL.setForeground(WhiteC);
        currentExL.setHorizontalAlignment(SwingConstants.CENTER);
        currentExL.setVerticalAlignment(SwingConstants.TOP);
        currentExL.setVisible(false);
        currentExP.add(currentExL);

        nextExL = new JLabel();
        nextExL.setText("Next Exercise:");
        nextExL.setFont(new Font("Gadugi", Font.BOLD, 30));
        nextExL.setForeground(WhiteC);
        nextExL.setHorizontalAlignment(SwingConstants.CENTER);
        nextExL.setVerticalAlignment(SwingConstants.TOP);
        nextExL.setVisible(false);
        nextExP.add(nextExL);

        setsLeftL = new JLabel();
        setsLeftL.setText("Sets left: ");
        setsLeftL.setFont(new Font("Gadugi", Font.BOLD, 22));
        setsLeftL.setForeground(WhiteC);
        setsLeftL.setBounds(383, 100, 200, 100);
        setsLeftL.setVisible(false);
        this.add(setsLeftL);

        repsL = new JLabel();
        repsL.setText("Reps: ");
        repsL.setFont(new Font("Gadugi", Font.BOLD, 22));
        repsL.setForeground(WhiteC);
        repsL.setBounds(250, 100, 100, 100);
        repsL.setVisible(false);
        this.add(repsL);


        restL = new JLabel();
        restL.setFont(new Font("Gadugi", Font.BOLD, 22));
        restL.setForeground(WhiteC);
        restL.setBounds(317, 310, 250, 100);
        restL.setVisible(false);
        this.add(restL);

        elapsedTimeL = new JLabel();
        elapsedTimeL.setText("00:00:00");
        elapsedTimeL.setFont(new Font("Gadugi", Font.BOLD, 22));
        elapsedTimeL.setForeground(WhiteC);
        elapsedTimeL.setBounds(8, 0, 100, 40);
        elapsedTimeL.setVisible(false);
        this.add(elapsedTimeL);
        // --------------------------------



        // --- --- BUTTON PROPERTIES --- ---
        startB = new JButton("Start");
        startB.setFont(new Font("Gadugi", Font.BOLD, 21));
        startB.setBounds(250, 200 - 16, 250, 150);
        startB.setFocusable(false);
        startB.setBackground(ButtonC);
        startB.setForeground(LabelC);
        this.add(startB);

        setB = new JButton("Start Set");
        setB.setFont(new Font("Gadugi", Font.BOLD, 21));
        setB.setBounds(250, 200 - 16, 250, 150);
        setB.setFocusable(false);
        setB.setVisible(false);
        setB.setBackground(ButtonC);
        setB.setForeground(LabelC);
        this.add(setB);

        restB = new JButton("Rest");
        restB.setFont(new Font("Gadugi", Font.BOLD, 21));
        restB.setBounds(250, 200 - 16, 250, 150);
        restB.setFocusable(false);
        restB.setVisible(false);
        restB.setBackground(ButtonC);
        restB.setForeground(LabelC);
        this.add(restB);
        // --------------------------------



        // --- --- BUTTON ACTIONS --- ---
        // TODO: make a breakpoint for when next and current exercise are equal (in terms of index)
        AtomicInteger i = new AtomicInteger();
        AtomicInteger j = new AtomicInteger();
        AtomicInteger elapsedTimeFlag = new AtomicInteger();
        startB.addActionListener(
                (e) -> {
                    if(elapsedTimeFlag.get() == 0) {
                        elapsedTimer.start();
                        elapsedTimeL.setVisible(true);
                        setsLeftL.setVisible(true);
                        elapsedTimeFlag.incrementAndGet();
                    }
                    try {
                        timer.stop();
                        i.getAndIncrement();
                        int indexo = i.get() + 1;

                        int sets = dataManipulator.numSets[i.get() - 1];
                        int numOfReps = dataManipulator.numReps[i.get() - 1];
                        String nextExercise = dataManipulator.exerciseName[indexo - 1];

                        currentExL.setVisible(true);
                        currentExL.setText("Current: " + dataManipulator.exerciseName[i.get() - 1]);

                        j.set(0);
                        sets += j.getAndIncrement();
                        setsLeftL.setText("Sets left: "+sets);

                        repsL.setVisible(true);
                        repsL.setText("Reps: " + numOfReps);

                        nextExL.setVisible(true);
                        nextExL.setText("Next: " + nextExercise);

                        restL.setVisible(false);
                        startB.setVisible(false);
                        restB.setVisible(true);
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        System.out.println("ERROR: Array Index Out of Bounds");
                        nextExL.setText("Next exercise: Done!");
                        restL.setVisible(false);
                        startB.setVisible(false);
                        restB.setVisible(true);
                    }
                }
        );

        setB.addActionListener(
                (e) -> {
                    int setsLeft = dataManipulator.numSets[i.get() - 1] - j.getAndIncrement();
                    timer.stop();
                    setsLeftL.setText("Sets left: " + setsLeft);
                    setB.setVisible(false);
                    restB.setVisible(true);
                    restL.setVisible(false);
                }
        );

        restB.addActionListener(
                (e) -> {
                    try {
                        timeLeft = dataManipulator.restTime[i.get() - 1];
                        setB.setText(""+timeLeft);
                        startB.setText(""+timeLeft);
                        timeLeft--;
                        startTimer();
                        restL.setVisible(true);
                        restL.setText("Click to skip");
                        restB.setVisible(false);
                        if(setsLeftL.getText().equals("Sets left: 1")) {
                            startB.setVisible(true);
                        } else {
                            setB.setVisible(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        elapsedTimer.stop();
                        JOptionPane.showMessageDialog(null, "You finished your workout in "+elapsedTimeL.getText()+"!");
                        System.exit(0);
                    }
                }
        );
        // --------------------------------



        // ---  ---  WINDOW PROPERTIES  ---  ---
        this.setSize(750, 550);
        this.setLayout(null);

        this.getContentPane().setBackground(BackgroundC);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.setVisible(true);
        // --------------------------------------

    }

    // ---  ---  Rest Timer  ---  ---
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            startB.setText(""+timeLeft);
            setB.setText("" + timeLeft);
            if (startB.getText().equals("0") || setB.getText().equals("0")) {
                timer.stop();
                restL.setText("Rest Done!");
                setB.setText("Start Set");
                startB.setText("Start Next Exercise");
                playSFX(0);
            }
            timeLeft -= 1;
        }
    }
    );

    public void startTimer()
    {
        timer.start();
    }
    // --------------------------------


    // ---  ---  SFX  ---  ---
    public void playSFX(int i) {
        sound.setFile(i);
        sound.play();
    }
}