package dev.goormthon.ppoori.domain.policy;

import dev.goormthon.ppoori.domain.comment.Comment;
import dev.goormthon.ppoori.domain.comment.CommentRepository;
import dev.goormthon.ppoori.domain.policy.converter.PolicyConverter;
import dev.goormthon.ppoori.domain.policy.dto.PolicyRequest;
import dev.goormthon.ppoori.domain.policy.dto.PolicyResponse;
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
    private final CommentRepository commentRepository;

    public List<PolicyResponse.RecommendPolicyDto> recommend(PolicyRequest.RecommendDto recommendDto) {
        List<Policy> policies = policyRepository.findPolicies(recommendDto.getTarget(), recommendDto.getCategory().getValue());
        List<PolicyResponse.RecommendPolicyDto> recommendPolicyDtos = new ArrayList<>();
        for (Policy policy : policies) {
            PolicyResponse.RecommendPolicyDto recommendPolicyDto = PolicyConverter.toRecommendPolicyDto(policy);
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
}
