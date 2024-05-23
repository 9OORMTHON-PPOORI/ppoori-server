package dev.goormthon.jejucart.domain.policy.converter;

import dev.goormthon.jejucart.domain.comment.Comment;
import dev.goormthon.jejucart.domain.comment.converter.CommentConverter;
import dev.goormthon.jejucart.domain.comment.dto.CommentResponse;
import dev.goormthon.jejucart.domain.policy.Policy;
import dev.goormthon.jejucart.domain.policy.dto.PolicyResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PolicyConverter {

    public static List<PolicyResponse.PoliciesDetailDto> toPoliciesDetailDtoList(List<Policy> policies) {

        List<PolicyResponse.PoliciesDetailDto> policiesDetailDtos = new ArrayList<>();

        for (Policy policy : policies) {
            PolicyResponse.PoliciesDetailDto policiesDetailDto = PolicyResponse.PoliciesDetailDto.builder()
                    .id(policy.getId())
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
                .title(policy.getTitle())
                .subject(policy.getSubject())
                .detail(details)
                .contact(policy.getContact())
                .hateRate(policy.getHateRate())
                .likeRate(policy.getLikeRate())
                .comments(commentStrings)
                .build();
    }
}
