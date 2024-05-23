package dev.goormthon.jejucart.domain.policy;

import dev.goormthon.jejucart.domain.policy.dto.PolicyResponse;
import dev.goormthon.jejucart.global.common.BaseResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static dev.goormthon.jejucart.global.status.SuccessStatus.POLICY_FIND_ALL_SUCCESS;
import static dev.goormthon.jejucart.global.status.SuccessStatus.POLICY_FIND_SUCCESS;

@AllArgsConstructor
@RestController
public class PolicyController {

    private final PolicyService policyService;

    // 추천 기능
//    @PostMapping("/api/v1/recommend")
//    public ResponseEntity<?> recommendPolicy() {
//
//    }

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

//    // 정책 관심 없어요
//    @PatchMapping("/api/v1/policy/{id}/hate")
//
//    // 정책 맘에 들어요
//    @PatchMapping("/api/v1/policy/{id}/like")

}
