package dev.goormthon.jejucart.domain.comment.converter;

import dev.goormthon.jejucart.domain.comment.Comment;
import dev.goormthon.jejucart.domain.comment.dto.CommentRequest;
import dev.goormthon.jejucart.domain.comment.dto.CommentResponse;
import dev.goormthon.jejucart.domain.policy.Policy;

public class CommentConverter {

    public static Comment toEntity(CommentRequest.WriteDto writeDto, Policy policy) {
        return Comment.builder()
                .policy(policy)
                .content(writeDto.getContent())
                .build();
    }

    public static CommentResponse.ShowDto toShowDto(Comment comment) {
        return CommentResponse.ShowDto.builder()
                .writer(comment.getWriter())
                .content(comment.getContent())
                .build();
    }
}
