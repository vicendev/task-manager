package org.ua.task.manager.entities;

public class Task {

    private static int sequenceId = 0;

    private int id;

    private String title;

    private String description;

    private boolean isCompleted;

    public Task(){
        this.id = sequenceId++;
        this.isCompleted = false;
    }

    public Task(String title, String description, boolean isCompleted) {

        this.title = title;
        this.description = description;
        this.isCompleted = isCompleted;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
