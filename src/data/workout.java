package data;

import java.util.ArrayList;

public class workout {
    public String workoutName;
    public ArrayList<exercise> exercises; // ArrayList to store exercise objects

    public workout(String workoutName)
    {
        this.workoutName = workoutName;
        this.exercises = new ArrayList<>();
    }
}
