package dev.goormthon.jejucart.domain.policy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class PolicyRequest {

    // 추천 데이터 dto
    @Getter @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RecommendDto {
        private String category;  // 카테고리
        private String target;  // 타겟
    }
}
