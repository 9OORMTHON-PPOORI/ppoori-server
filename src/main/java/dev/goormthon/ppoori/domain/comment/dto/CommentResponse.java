package dev.goormthon.ppoori.domain.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CommentResponse {

    @Getter @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ShowDto {
        private String writer;
        private String content;
    }
}
