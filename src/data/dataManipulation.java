package data;

import javax.swing.*;
import java.io.*;

public class dataManipulation {

    // ---  ---  loadData Variables  ---  ---

    int noOfLines = 0;
    public String[] exerciseName;
    public String[] workoutNames;
    public int[] numSets;
    public int[] numReps;
    public int[] restTime;

    public dataManipulation(int index) {

        // getting numberoflines of the workout
        try {
            String fileName = "src/resources/workouts/workout_" + index + ".txt";
            BufferedReader br1 = new BufferedReader(new FileReader(fileName));

            while (br1.readLine() != null) {
                noOfLines++;
            }
            br1.close();

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // no clue why we dont need the -2 anymore but it works
        this.exerciseName = new String[(noOfExercises(index))];
        this.numSets = new int[(noOfExercises(index))];
        this.numReps = new int[(noOfExercises(index))];
        this.restTime = new int[(noOfExercises(index))];
        this.workoutNames = new String[noOfFiles()];

    }

    private static final String INDEX_FILE = "index.txt";


    // VVVV constructor without a parameter, its needed apperantly
    public dataManipulation() {
        this.workoutNames = new String[noOfFiles()];
    }

    public void saveData(workout newWorkout)
    // method to save data using ArrayList
    {
        try {
            int index = getNextIndex();
            String fileName = "src/resources/workouts/workout_" + index + ".txt";
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));

            bw.write(newWorkout.workoutName);
            bw.newLine();

            for (exercise exc : newWorkout.exercises) {
                bw.write(exc.exerciseName);
                bw.newLine();
                bw.write("" + exc.numSets);
                bw.newLine();
                bw.write("" + exc.numReps);
                bw.newLine();
                bw.write("" + exc.restTime);
                bw.newLine();
            }

            bw.close();

            System.out.println("Data saved to file: " + fileName);

            updateIndex(index + 1);

        } catch (Exception e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    private int getNextIndex() {
        try {
            File file = new File(INDEX_FILE);
            if (!file.exists()) {
                return 1; // starts from index 1 if file doesn't exist
            }

            BufferedReader br = new BufferedReader(new FileReader(INDEX_FILE));
            int index = Integer.parseInt(br.readLine());
            br.close();
            return index;
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading index file: " + e.getMessage());
            return -1;
        }
    }

    private void updateIndex(int index) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(INDEX_FILE));
            bw.write(String.valueOf(index));
            bw.close();
        } catch (IOException e) {
            System.out.println("Error updating index file: " + e.getMessage());
        }
    }

    private void resetIndex() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(INDEX_FILE));
            bw.write("1");
            bw.close();
        } catch (IOException e) {
            System.out.println("Error resetting index: " + e.getMessage());
        }
    }

    public void loadData(int index)
    // method to load data from a specific file
    {
        System.out.println("Value of noOfLines " + noOfLines);

        try {
            String fileName = "src/resources/workouts/workout_" + index + ".txt";
            BufferedReader br2 = new BufferedReader(new FileReader(fileName));

            String workoutName = br2.readLine();
            System.out.println(workoutName);

            for (int k = 0; k < noOfExercises(index); k++) {
                exerciseName[k] = br2.readLine();
                System.out.println(exerciseName[k]);
                numSets[k] = Integer.parseInt(br2.readLine());
                System.out.println(numSets[k]);
                numReps[k] = Integer.parseInt(br2.readLine());
                System.out.println(numReps[k]);
                restTime[k] = Integer.parseInt(br2.readLine());
                System.out.println(restTime[k]);
            }
            br2.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public int noOfFiles() {
        int noOfWorkouts = 0;
        int i = 1;
        String fileName;
        File file;
        do {
            fileName = "src/resources/workouts/workout_" + i + ".txt";
            file = new File(fileName);
            noOfWorkouts++;
            i++;
        } while (file.exists());
        return noOfWorkouts - 1;
    }

    public void deleteFiles() {
        resetIndex();
        int fileCount = noOfFiles();
        String fileName;
        File file;

        for (int i = 0; i <= fileCount; i++) {
            fileName = "src/resources/workouts/workout_" + i + ".txt";
            file = new File(fileName);
            try {
                file.delete();
            } catch (Exception e) {
                System.out.println("Error deleting file: " + e.getMessage());
            }
        }
        JOptionPane.showMessageDialog(null, "Deleted all workouts successfully!");
    }


    public void loadWorkoutNames() {
        for(int i = 1; i <= noOfFiles(); i++) {
            String test = "src/resources/workouts/workout_" + i + ".txt";
            try {
                BufferedReader br = new BufferedReader(new FileReader(test));
                workoutNames[i-1] = br.readLine();
                System.out.println(workoutNames[i-1]);
                br.close();
            } catch(Exception e) {
                e.printStackTrace();  // Print the stack trace for better debugging
            }
        }
    }

    public int noOfExercises(int index) {
        noOfLines=0;
        try {
            String fileName = "src/resources/workouts/workout_" + index + ".txt";
            BufferedReader br1 = new BufferedReader(new FileReader(fileName));

            while (br1.readLine() != null) {
                noOfLines++;
            }
            br1.close();

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return noOfLines/4;
    }
}
