package com.letsmove.enums;

public enum Role {
    ADMIN("Админ"),
    MANAGER("Менеджер"),
    GUIDE("Гид"),
    USER("Пользователь");

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Role(String name) {
        this.name = name;
    }
}
