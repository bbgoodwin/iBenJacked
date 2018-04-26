package com.example.benjamin.databasemanager;

public class Workout {

    private String workout;
    private String user;
    private int sets;
    private int reps;
    private String category;
    private int id;
    private int weight;

    public Workout(int idPassed, String userPassed, String workoutPassed, String categoryPassed, int weightPassed, int setsPassed, int repsPassed) {
        id = idPassed;
        user = userPassed;
        workout = workoutPassed;
        category = categoryPassed;
        weight = weightPassed;
        sets = setsPassed;
        reps = repsPassed;
    }

    public String getWorkout() {
        return workout;
    }

    public String getUser() {
        return user;
    }

    public String getCategory() {
        return category;
    }

    public int getWeight() {
        return weight;
    }

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }

    public int getId() {
        return id;
    }

    public void setWorkout(String workoutPassed) {
        workout = workoutPassed;
    }

    public void setWeight(int weightPassed) {
        weight = weightPassed;
    }

    public void setSets(int setsPassed) {
        sets = setsPassed;
    }

    public void setReps(int repsPassed) {
        reps = repsPassed;
    }

    public void setCategory(String categoryPassed) {
        category = categoryPassed;
    }

}
