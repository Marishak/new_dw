package com.spring.task.new_dw.entity.enums;

public enum Gender {
    MALE ("man"),
    FEMALE ("woman");

    private String title;

    Gender(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Gender: " + title;
    }
}
