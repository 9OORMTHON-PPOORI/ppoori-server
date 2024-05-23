package dev.goormthon.jejucart.global.enums;

public enum Category {

    ACTIVITY_SUPPORT("활동지원"),
    COMPETENCY_DEVELOPMENT("역량개발"),
    LIVING_SUPPORT("생활지원"),
    CAREER_SUPPORT("진로지원");

    private String value;

    Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
