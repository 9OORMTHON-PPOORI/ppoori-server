package dev.goormthon.ppoori.domain.policy.dto;

import dev.goormthon.ppoori.global.enums.Category;
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
        private Category category;  // 카테고리
        private String target;  // 타겟
    }
}
