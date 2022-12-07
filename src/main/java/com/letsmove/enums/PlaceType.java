package com.letsmove.enums;

public enum PlaceType {
    ATTRACTION("Достопримечательность"),
    HOTEL("Отель"),
    CAFE("Кафе"),
    MARKET("Супермаркет"),
    SHOPPING_CENTER("Торговый центр"),
    STATE_INSTITUTIONS("Гос.Учреждения");

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    PlaceType(String name) {
        this.name = name;
    }
}
