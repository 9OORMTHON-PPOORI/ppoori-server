package dev.goormthon.jejucart.domain.policy.dto;

import dev.goormthon.jejucart.domain.comment.dto.CommentResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class PolicyResponse {

    // 추천 정책 정보 반환 dto
    @Getter @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RecommendPolicyDto {
        private Long id;  // PK
        private String target;  // 정책명
        private String title;  // 제목
    }

    // 정책 상세 정보 반환 dto
    @Getter @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PolicyDetailDto {
        private Long id;  // PK
        private String name;  // 정책명
        private String title;  // 제목
        private String subject;  // 지원 대상
        private List<String> detail;  // 지원 내용
        private String department;  // 부서
        private String contact;  // 문의처
        private int hateRate;  // 관심 없어요
        private int likeRate;  // 맘에 들어요
        private List<CommentResponse.ShowDto> comments;
    }

    // 정첵 전체 정보 반환 dto
    @Getter @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PoliciesDetailDto {
        private Long id;  // PK
        private String name;  // 정책명
        private String title;  // 제목
        private String category;  // 카테고리
        private int hateRate;  // 관심 없어요
        private int likeRate;  // 맘에 들어요
    }
}
