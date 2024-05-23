package dev.goormthon.jejucart.domain.policy.converter;

import dev.goormthon.jejucart.domain.policy.Policy;
import dev.goormthon.jejucart.domain.policy.dto.PolicyResponse;

import java.util.ArrayList;
import java.util.List;

public class PolicyConverter {

    public static List<PolicyResponse.PoliciesDetailDto> toPoliciesDetailDtoList(List<Policy> policies) {

        List<PolicyResponse.PoliciesDetailDto> policiesDetailDtos = new ArrayList<>();

        for (Policy policy : policies) {
            PolicyResponse.PoliciesDetailDto policiesDetailDto = PolicyResponse.PoliciesDetailDto.builder()
                    .name(policy.getName())
                    .title(policy.getTitle())
                    .category(policy.getCategory().getValue())
                    .hateRate(policy.getHateRate())
                    .likeRate(policy.getLikeRate())
                    .build();

            policiesDetailDtos.add(policiesDetailDto);
        }

        return policiesDetailDtos;
    }

    public static PolicyResponse.PolicyDetailDto toPolicyDetailDto(Policy policy) {
        return PolicyResponse.PolicyDetailDto.builder()
                .name(policy.getName())
                .title(policy.getTitle())
                .subject(policy.getSubject())
                .detail(policy.getDetail())
                .contact(policy.getContact())
                .hateRate(policy.getHateRate())
                .likeRate(policy.getLikeRate())
                .build();
    }
}
