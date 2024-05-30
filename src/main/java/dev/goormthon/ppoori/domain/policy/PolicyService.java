package dev.goormthon.ppoori.domain.policy;

import dev.goormthon.ppoori.domain.comment.Comment;
import dev.goormthon.ppoori.domain.comment.CommentRepository;
import dev.goormthon.ppoori.domain.policy.converter.PolicyConverter;
import dev.goormthon.ppoori.domain.policy.dto.PolicyRequest;
import dev.goormthon.ppoori.domain.policy.dto.PolicyResponse;
import dev.goormthon.ppoori.domain.relativity.RelativityRepository;
import dev.goormthon.ppoori.global.enums.Target;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class PolicyService {

    private final PolicyRepository policyRepository;
    private final RelativityRepository relativityRepository;
    private final CommentRepository commentRepository;

    public List<PolicyResponse.RecommendPolicyDto> recommend(PolicyRequest.RecommendDto recommendDto) {

        String target = getColumnNameFromTarget(recommendDto.getTarget());
        String category = "" + recommendDto.getCategory() + "";

        System.out.println("target = " + target);
        System.out.println("category = " + category);

        // List<Long> policyIds = relativityRepository.findPolicyIdsByRelativity(category, target);
        List<Long> policyIds = relativityRepository.findPolicyIdsByRelativity(category, target);

        List<PolicyResponse.RecommendPolicyDto> recommendPolicyDtos = new ArrayList<>();

        int index = 0;
        int policyLength = policyIds.size();

        System.out.println("policyLength = " + policyLength);

        for (Long policyId : policyIds) {
            index = index + 1;
            String indexString = index + "/" + policyLength;

            Policy policy = policyRepository.findById(policyId).orElseThrow(EntityNotFoundException::new);
            PolicyResponse.RecommendPolicyDto recommendPolicyDto = PolicyConverter.toRecommendPolicyDto(policy, indexString);
            recommendPolicyDtos.add(recommendPolicyDto);
        }

        return recommendPolicyDtos;
    }

    public List<PolicyResponse.PoliciesDetailDto> findAllPolicy() {
        List<Policy> policies = policyRepository.findAll();
        return PolicyConverter.toPoliciesDetailDtoList(policies);
    }

    public PolicyResponse.PolicyDetailDto findPolicyById(Long id) {
        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));

        List<Comment> comments = commentRepository.findByPolicy_Id(policy.getId())
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));

        return PolicyConverter.toPolicyDetailDto(policy, comments);
    }

    @Transactional
    public int hatePolicy(Long id, boolean status) {
        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));

        if (!status)  // 아직 안 누른 버튼
            policy.plusHateRate();
        else
            policy.minusHateRate();

        return policy.getHateRate();
    }

    @Transactional
    public int likePolicy(Long id, boolean status) {
        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));

        if (!status)
            policy.plusLikeRate();
        else
            policy.minusLikeRate();

        return policy.getLikeRate();
    }

    private String getColumnNameFromTarget(Target target) {
        return switch (target) {
            case STUDENT -> "rate_student";
            case JOBSEEKER -> "rate_jobseeker";
            case WORKER -> "rate_worker";
            case NEWLYWEDS -> "rate_newlyweds";
            case INDUSTRY -> "rate_industry";
            case ARTIST -> "rate_artist";
        };
    }
}
