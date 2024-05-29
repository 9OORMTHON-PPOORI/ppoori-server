package dev.goormthon.ppoori.global.status;

import dev.goormthon.ppoori.global.common.BaseErrorCode;
import dev.goormthon.ppoori.global.common.ErrorReasonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    CANNOT_FOUND_USER(HttpStatus.UNAUTHORIZED, 401, "등록된 사용자가 아닙니다."),
    NO_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, 401, "Refresh Token이 없습니다."),
    ANOTHER_USER(HttpStatus.UNAUTHORIZED, 401, "토큰 탈취 위협이 있습니다."),
    USER_NOT_FOUND(HttpStatus.UNAUTHORIZED, 401, "사용자를 찾을 수 없습니다.");

    private final HttpStatus httpStatus;
    private final int code;
    private final String message;

    @Override
    public ErrorReasonDto getReason(){
        return ErrorReasonDto.builder()
                .message(message)
                .code(code)
                .success(false)
                .build();
    }

    @Override
    public ErrorReasonDto getReasonHttpStatus(){
        return ErrorReasonDto.builder()
                .httpStatus(httpStatus)
                .message(message)
                .code(code)
                .success(false)
                .build();
    }
}
