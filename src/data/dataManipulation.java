package data;

import java.io.*;

public class dataManipulation
{

    // ---  ---  loadData Variables  ---  ---

    int noOfLines = 0;
    public String[] exerciseName;
    public int[] numSets;
    public int[] numReps;
    public int[] restTime;

    public dataManipulation(int index){

        // getting numberoflines of the workout
        try {
            String fileName = "workouts_" + index + ".txt";
            BufferedReader br1 = new BufferedReader(new FileReader(fileName));

            while(br1.readLine() != null) {
                noOfLines++;
            }
            br1.close();

        }
        catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // no clue why we dont need the -2 anymore but it works
        this.exerciseName = new String[(noOfLines)/4];
        this.numSets = new int[(noOfLines)/4];
        this.numReps = new int[(noOfLines)/4];
        this.restTime = new int[(noOfLines)/4];

    }

    private static final String INDEX_FILE = "index.txt";


    // VVVV constructor without a parameter, its needed apperantly
    public dataManipulation() {}

    public void saveData(workout newWorkout)
    // method to save data using ArrayList
        {
            try {
                int index = getNextIndex();
                String fileName = "workouts_" + index + ".txt";
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));

                bw.write(newWorkout.workoutName);
                bw.newLine();

                for (exercise exc : newWorkout.exercises)
                {
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

        private int getNextIndex()
        {
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

        private void updateIndex (int index)
        {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(INDEX_FILE));
                bw.write(String.valueOf(index));
                bw.close();
            } catch (IOException e) {
                System.out.println("Error updating index file: " + e.getMessage());
            }
        }

    public void loadData(int index)
    // method to load data from a specific file
    {
        System.out.println("Value of noOfLines "+(noOfLines)/4);

        try {
            String fileName = "workouts_" + index + ".txt";
            BufferedReader br2 = new BufferedReader(new FileReader(fileName));

            String workoutName = br2.readLine();
            System.out.println(workoutName);

            for (int k = 0; k< (noOfLines)/4; k++) {
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
        }
        catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}