package dev.goormthon.jejucart.domain.policy.dto;

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
        private String name;  // 정책명
        private String title;  // 제목
        private String summary;  // AI의 리뷰 요약
    }

    // 정책 상세 정보 반환 dto
    @Getter @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PolicyDetailDto {
        private String name;  // 정책명
        private String title;  // 제목
        private String subject;  // 지원 대상
        private List<String> detail;  // 지원 내용
        private String contact;  // 문의처
        private int hateRate;  // 관심 없어요
        private int likeRate;  // 맘에 들어요
    }

    // 정첵 전체 정보 반환 dto
    @Getter @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PoliciesDetailDto {
        private String name;  // 정책명
        private String title;  // 제목
        private String category;  // 카테고리
        private int hateRate;  // 관심 없어요
        private int likeRate;  // 맘에 들어요
    }
}
