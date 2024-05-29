package dev.goormthon.ppoori.global.enums;

public enum Category {

    ACTIVITY_SUPPORT("ACTIVITY_SUPPORT"),
    COMPETENCY_DEVELOPMENT("COMPETENCY_DEVELOPMENT"),
    LIVING_SUPPORT("LIVING_SUPPORT"),
    CAREER_SUPPORT("CAREER_SUPPORT");

    private String value;

    Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
