package dev.goormthon.jejucart.domain.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CommentRequest {

    @Getter @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class WriteDto {
        private String content;
    }
}
