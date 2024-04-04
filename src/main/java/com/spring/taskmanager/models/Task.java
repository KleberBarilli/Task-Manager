package com.spring.taskmanager.models;

import org.springframework.data.annotation.Id;

public class Task {
    @Id
    private String id;
    private String title;
    private String description;
    private int priority;
    private TaskState state;

    public Task() {
    }

    public Task(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.priority = builder.priority;
        this.state = builder.state;
    }

    public Task insert() {
        return builderFrom(this).withState(TaskState.TO_DO).build();
    }

    public String getId() {
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

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builderFrom(Task task) {
        return new Builder()
                .withId(task.getId())
                .withTitle(task.getTitle())
                .withDescription(task.getDescription())
                .withPriority(task.getPriority())
                .withState(task.getState());
    }

    public static class Builder {
        private String id;
        private String title;
        private String description;
        private int priority;
        private TaskState state;

        public Builder() {
        }

        public Builder(Task task) {
            this.id = task.getId();
            this.title = task.getTitle();
            this.description = task.getDescription();
            this.priority = task.getPriority();
            this.state = task.getState();
        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withPriority(int priority) {
            this.priority = priority;
            return this;
        }

        public Builder withState(TaskState state) {
            this.state = state;
            return this;
        }

        public Task build() {
            Task task = new Task(this);
            task.setTitle(this.title);
            task.setDescription(this.description);
            task.setPriority(this.priority);
            task.setState(this.state);
            return task;
        }
    }
}