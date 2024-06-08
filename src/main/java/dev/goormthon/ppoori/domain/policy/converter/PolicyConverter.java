package dev.goormthon.ppoori.domain.policy.converter;

import dev.goormthon.ppoori.domain.comment.Comment;
import dev.goormthon.ppoori.domain.comment.converter.CommentConverter;
import dev.goormthon.ppoori.domain.comment.dto.CommentResponse;
import dev.goormthon.ppoori.domain.policy.Policy;
import dev.goormthon.ppoori.domain.policy.dto.PolicyResponse;

import java.util.*;

public class PolicyConverter {

    public static PolicyResponse.RecommendPolicyDto toRecommendPolicyDto(Policy policy, int currIdx, int totalIdx) {
        return PolicyResponse.RecommendPolicyDto.builder()
                .id(policy.getId())
                .curr_idx(currIdx)
                .total_idx(totalIdx)
                .name(policy.getName())
                .title(policy.getTitle())
                .summary(policy.getSummary())
                .build();
    }

    public static PolicyResponse.PolicyDetailDto toPolicyDetailDto(Policy policy, List<Comment> comments) {

        String[] split = policy.getDetail().split("/");
        List<String> details = new ArrayList<>(Arrays.asList(split));
        List<CommentResponse.ShowDto> commentStrings = new ArrayList<>();

        for (Comment comment : comments) {
            commentStrings.add(CommentConverter.toShowDto(comment));
        }

        return PolicyResponse.PolicyDetailDto.builder()
                .id(policy.getId())
                .name(policy.getName())
                .category(policy.getCategory().getValue())
                .title(policy.getTitle())
                .subject(policy.getSubject())
                .detail(details)
                .department(policy.getDepartment())
                .contact(policy.getContact())
                .hate_count(policy.getHateRate())
                .like_count(policy.getLikeRate())
                .comments(commentStrings)
                .build();
    }

    public static List<PolicyResponse.PoliciesDetailDto> toPoliciesDetailDtoList(List<Policy> policies) {

        List<PolicyResponse.PoliciesDetailDto> policiesDetailDtos = new ArrayList<>();

        for (Policy policy : policies) {
            PolicyResponse.PoliciesDetailDto policiesDetailDto = PolicyResponse.PoliciesDetailDto.builder()
                    .id(policy.getId())
                    .name(policy.getName())
                    .title(policy.getTitle())
                    .category(policy.getCategory().getValue())
                    .hate_count(policy.getHateRate())
                    .like_count(policy.getLikeRate())
                    .total_comment(policy.getComments().size())
                    .build();

            policiesDetailDtos.add(policiesDetailDto);
        }

        policiesDetailDtos.sort((o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));

        return policiesDetailDtos;
    }
}
