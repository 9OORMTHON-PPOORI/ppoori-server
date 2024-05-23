package dev.goormthon.jejucart.global.common;

public interface BaseErrorCode {
    ErrorReasonDto getReason();
    ErrorReasonDto getReasonHttpStatus();
}
