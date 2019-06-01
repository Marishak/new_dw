package com.spring.task.new_dw.entity.enums;

public enum Role {
    ADMIN ("admin"),
    CLIENT ("client");

    private String title;

    Role(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Role: " + title;
    }
}
