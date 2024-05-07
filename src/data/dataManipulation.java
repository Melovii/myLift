package data;

import java.io.*;

public class dataManipulation {
    private static final String INDEX_FILE = "index.txt";
    // method to save data using ArrayList
        public void saveData(workout newWorkout) {
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

    // method to load data from a specific file
    public void loadData(int index)
    {
        // TODO: ASK FOR INDEX FROM GUI AND DISPLAY BASED ON INDEX
        // TODO: FIND A WAY TO DELETE/VIEW INDEXES

        try {
            String fileName = "workouts_" + index + ".txt";
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            String workoutName = br.readLine();
            System.out.println(workoutName);
            String exerciseName = br.readLine();
            System.out.println(exerciseName);
            int numSets = Integer.parseInt(br.readLine());
            System.out.println(numSets);
            int numReps = Integer.parseInt(br.readLine());
            System.out.println(numReps);
            int restTime = Integer.parseInt(br.readLine());
            System.out.println(restTime);

            br.close();

        }
        catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
