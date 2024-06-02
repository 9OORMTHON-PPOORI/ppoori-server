package dev.goormthon.ppoori.domain.policy;

import dev.goormthon.ppoori.domain.policy.dto.PolicyRequest;
import dev.goormthon.ppoori.domain.policy.dto.PolicyResponse;
import dev.goormthon.ppoori.global.common.BaseResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static dev.goormthon.ppoori.global.status.SuccessStatus.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
@RestController
public class PolicyController {

    private final PolicyService policyService;

    // 추천 기능
    @PostMapping("/api/v1/recommend")
    public BaseResponseDto<List<PolicyResponse.RecommendPolicyDto>> recommendPolicy(@RequestBody PolicyRequest.RecommendDto recommendDto) {
        return BaseResponseDto.SuccessResponse(POLICY_RECOMMEND_SUCCESS, policyService.recommend(recommendDto));
    }

    // 전체 정책 조회
    @GetMapping("/api/v1/policy/all")
    public BaseResponseDto<List<PolicyResponse.PoliciesDetailDto>> findAllPolicy() {
        return BaseResponseDto.SuccessResponse(POLICY_FIND_ALL_SUCCESS, policyService.findAllPolicy());
    }

    // 상세 정책 조회
    @GetMapping("/api/v1/policy/{id}")
    public BaseResponseDto<PolicyResponse.PolicyDetailDto> findPolicyById(@PathVariable("id") Long id) {
        return BaseResponseDto.SuccessResponse(POLICY_FIND_SUCCESS, policyService.findPolicyById(id));
    }

    // 정책 관심 없어요
    @PatchMapping("/api/v1/policy/{id}/hate")
    public BaseResponseDto<?> hatePolicy(@PathVariable("id") Long id, boolean status) {
        return BaseResponseDto.SuccessResponse(COMMENT_HATE_REQUEST_SUCCESS, policyService.hatePolicy(id, status));
    }

    // 정책 맘에 들어요
    @PatchMapping("/api/v1/policy/{id}/like")
    public BaseResponseDto<?> likePolicy(@PathVariable("id") Long id, boolean status) {
        return BaseResponseDto.SuccessResponse(COMMENT_LIKE_REQUEST_SUCCESS, policyService.likePolicy(id, status));
    }
}
