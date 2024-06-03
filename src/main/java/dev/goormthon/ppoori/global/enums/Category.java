package dev.goormthon.ppoori.global.enums;

public enum Category {

    ACTIVITY_SUPPORT("활동 지원"),
    COMPETENCY_DEVELOPMENT("역량 개발"),
    LIVING_SUPPORT("생활 지원"),
    CAREER_SUPPORT("진로 지원");

    private String value;

    Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
