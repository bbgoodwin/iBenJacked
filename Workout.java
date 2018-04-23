package com.example.benjamin.databasemanager;

public class Workout {

    private String workout;
    private int sets;
    private int reps;

    public Workout(String workoutPassed, int setsPassed, int repsPassed) {
        workout = workoutPassed;
        sets = setsPassed;
        reps = repsPassed;
    }

    public String getWorkout() {
        return workout;
    }

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }

    public void setWorkout(String workoutPassed) {
        workout = workoutPassed;
    }

    public void setSets(int setsPassed) {
        sets = setsPassed;
    }

    public void setReps(int repsPassed) {
        reps = repsPassed;
    }

}
