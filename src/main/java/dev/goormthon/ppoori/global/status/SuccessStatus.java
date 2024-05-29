package dev.goormthon.ppoori.global.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessStatus {

    POLICY_RECOMMEND_SUCCESS(HttpStatus.OK, 200, "리뷰를 추천하였습니다."),
    POLICY_FIND_ALL_SUCCESS(HttpStatus.OK, 200, "정책 전체보기에 성공했습니다."),
    POLICY_FIND_SUCCESS(HttpStatus.OK, 200, "정책 조회에 성공했습니다."),
    COMMENT_HATE_REQUEST_SUCCESS(HttpStatus.OK, 200, "관심 없음 버튼을 눌렀습니다."),
    COMMENT_LIKE_REQUEST_SUCCESS(HttpStatus.OK, 200, "맘에 들음 버튼을 눌렀습니다."),
    COMMENT_SAVE_SUCCESS(HttpStatus.CREATED, 201, "댓글 작성에 성공했습니다.");

    private final HttpStatus httpStatus;
    private final int code;
    private final String message;
}
