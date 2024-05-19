package data;

import java.util.ArrayList;

public class workout {
    public String workoutName;
    public ArrayList<exercise> exercises; // ArrayList to store exercise objects

    // Constructor
    public workout(String workoutName)
    {
        this.workoutName = workoutName;
        this.exercises = new ArrayList<exercise>();
    }
}
// TODO: check if getters are necessary
//public String getWorkoutName() {
//    return workoutName;
//}
//
//public void setWorkoutName(String name) {
//    workoutName = name;
//}
