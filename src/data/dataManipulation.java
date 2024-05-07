package data;

import java.io.*;

public class dataManipulation {
    // method to save data using ArrayList
    public void saveData(workout newWorkout) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("workouts.txt"));

//            bw.write("workout name: ");
            bw.write(newWorkout.workoutName);
            bw.newLine();

//            bw.write("exercises:\n");
            for (exercise exc : newWorkout.exercises) {
                bw.write(exc.exerciseName);
                bw.write(", ");
                bw.write("" + exc.numSets);
                bw.write(", ");
                bw.write("" + exc.numReps);
                bw.write(", ");
                bw.write("" + exc.restTime);
                bw.newLine();
            }

            bw.close();

        } catch (Exception e) {
            System.out.println("Error saving data: " + e.getMessage());
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
            int restTime = Integer.parseInt(br.readLine());

            br.close();
        }
        catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage()); // display error message
        }
    }

//        testcases
//        saveData("lower body powertrophy", "squat", 4, 5, 240);
//        saveData("upper body hypertrophy", "benchpress", 4, 5, 240);
//        saveData("full body", "psuedo push-up", 3, 10, 90);
//        appendData("upper body hypertrophy", "bench press", 3, 21, 120);
//        loadData(int workoutCount);
}
