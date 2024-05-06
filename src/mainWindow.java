import javax.swing.*;
import java.awt.*;
import java.io.*;

public class mainWindow extends JFrame
{

    JButton addWorkoutB, workoutB, viewWorkoutsB, infoB; // let it be small and closable
    JLabel mainTitle;


    mainWindow()
    {
        this.setLayout(null);
        this.setSize(520, 520);

        mainTitle = new JLabel();
        mainTitle.setText("myLift");
        mainTitle.setFont(new Font("Calibri", Font.BOLD , 44));
        mainTitle.setBounds(200, 50, 280, 60);
        mainTitle.setForeground(new Color(27, 127, 222));
        this.add(mainTitle);

        // ---  ---  BUTTON PROPERTIES  ---  ---
        infoB = new JButton("i");
        infoB.setFont(new Font("Times New Roman", Font.BOLD, 26));
        infoB.setBounds(20, 420, 44, 44);
        infoB.setFocusable(false);
        this.add(infoB);

        addWorkoutB = new JButton("Add Workout");
        addWorkoutB.setBounds(120, 140, 280, 60);
        addWorkoutB.setFocusable(false);
        this.add(addWorkoutB);

        workoutB = new JButton("Start Workout");
        workoutB.setBounds(120, 240, 280, 60);
        workoutB.setFocusable(false);
        this.add(workoutB);

        viewWorkoutsB = new JButton("Workouts List");
        viewWorkoutsB.setBounds(120, 340, 280, 60);
        viewWorkoutsB.setFocusable(false);
        this.add(viewWorkoutsB);
        // -------------------------------------



        // ---  ---  BUTTON ACTIONS  ---  ---
        infoB.addActionListener(
                (e) -> {
                    new infoWindow();
                }
        );

        addWorkoutB.addActionListener(
                (e) -> {
                    dispose();
                    new addWorkoutWindow();
                }
        );

        workoutB.addActionListener(
                (e) -> {
                    dispose();
                    new workoutWindow();
                }
        );

        viewWorkoutsB.addActionListener(
                (e) -> {
                    dispose();
                    new viewWorkoutsWindow();
                }
        );
        // -----------------------------------



        // ---  ---  WINDOW PROPERTIES  ---  ---
        this.getContentPane().setBackground(new Color(44, 43, 64));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.setVisible(true);
        // --------------------------------------



//        saveData("lower body powertrophy", "squat", 4, 5, 240);
//        saveData("upper body hypertrophy", "benchpress", 4, 5, 240);
//        saveData("full body", "psuedo push-up", 3, 10, 90);
//        appendData("upper body hypertrophy", "bench press", 3, 21, 120);
//        loadData(int workoutCount);
    }

// beginning of methods for data manipulation
    int workoutCount;
    // method to append data onto a file
    public void appendData(String workoutName, String exerciseName, int numSets, int numReps, int secRest)
    {
        try {
            // todo: FIND A WAY TO APPEND DATA ON THE SAVED FILE
            BufferedWriter bwAppend = new BufferedWriter(new FileWriter("C:/Users/Melovi/Desktop/test.txt/"));

            bwAppend.write(workoutName); bwAppend.newLine();
            bwAppend.write(exerciseName); bwAppend.newLine();
            bwAppend.write(""+numSets); bwAppend.newLine();
            bwAppend.write(""+numReps); bwAppend.newLine();
            bwAppend.write(""+secRest); bwAppend.newLine();

            bwAppend.close();

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage()); // display error message
        }
    }

    // method to save the data onto a separate file
    public void saveData(String workoutName, String exerciseName, int numSets, int numReps, int secRest)
    {
        try {
            String filename = String.format("workout_%d.txt", workoutCount);
            workoutCount++;

            File file = new File(filename);
            if(!file.exists()){
                file.createNewFile(); // create file if it doesn't exist
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));

            bw.write(workoutName); bw.newLine();
            bw.write(exerciseName); bw.newLine();
            bw.write(""+numSets); bw.newLine();
            bw.write(""+numReps); bw.newLine();
            bw.write(""+secRest); bw.newLine();

            bw.close();

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage()); // display error message
        }
    }

    // method to load data from a specific file
    public void loadData()
    {
        // todo: FIND A WAY TO LOAD A SPECIFIC FILE SINCE THEY'RE DIFFERENT INDEXES

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:/Users/Melovi/Desktop/test.txt/"));

            String workoutName = br.readLine();
            String exerciseName = br.readLine();
            int numSets = Integer.parseInt(br.readLine());
            int numReps = Integer.parseInt(br.readLine());
            int secRest = Integer.parseInt(br.readLine());

            br.close();
        }
        catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage()); // display error message
        }
    }
// end of methods for data manipulation
}