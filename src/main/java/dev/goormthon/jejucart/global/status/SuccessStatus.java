package dev.goormthon.jejucart.global.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessStatus {

    POLICY_FIND_ALL_SUCCESS(HttpStatus.OK, 200, "정책 전체보기에 성공했습니다."),
    POLICY_FIND_SUCCESS(HttpStatus.OK, 200, "정책 조회에 성공했습니다."),
    COMMENT_SAVE_SUCCESS(HttpStatus.CREATED, 201, "댓글 작성에 성공했습니다.");

    private final HttpStatus httpStatus;
    private final int code;
    private final String message;
}
