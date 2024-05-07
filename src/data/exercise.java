package data;

public class exercise {
    String exerciseName;
    Integer numSets;
    Integer numReps;
    Integer restTime;

    // Constructor that takes exercise name, sets, reps, and rest time as arguments
    public exercise(String exerciseName, int numSets, int numReps, int restTime) {
        this.exerciseName = exerciseName;
        this.numSets = numSets;
        this.numReps = numReps;
        this.restTime = restTime;
    }
}

// add getters and setters for member variables
// perform calculations or manipulations on exercise data
