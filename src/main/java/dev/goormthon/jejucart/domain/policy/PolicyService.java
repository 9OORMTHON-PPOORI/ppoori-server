package dev.goormthon.jejucart.domain.policy;

import dev.goormthon.jejucart.domain.comment.Comment;
import dev.goormthon.jejucart.domain.comment.CommentRepository;
import dev.goormthon.jejucart.domain.policy.converter.PolicyConverter;
import dev.goormthon.jejucart.domain.policy.dto.PolicyRequest;
import dev.goormthon.jejucart.domain.policy.dto.PolicyResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@AllArgsConstructor
@Service
public class PolicyService {

    private final PolicyRepository policyRepository;
    private final CommentRepository commentRepository;

//    @Value("${secret.gpt-key}")
//    private String key;

//    public List<String> recommendPolicy(PolicyRequest.RecommendDto recommendDto) {
//        List<Policy> policies = policyRepository.findPolicies(recommendDto.getTarget(), recommendDto.getCategory());
//        List<PolicyResponse.RecommendPolicyDto> recommendPolicyDtos = new ArrayList<>();
//
//        List<String> summaries = new ArrayList<>();
//
//        for (Policy policy : policies) {
//            List<Comment> comments = commentRepository.findByPolicy_Id(policy.getId())
//                    .orElseThrow(() -> new EntityNotFoundException("Entity not found"));
//
//            StringBuilder stringBuilder = new StringBuilder();
//            for (Comment comment : comments) {
//                stringBuilder.append(comment).append(", ");
//
//            }
//
//            String string = stringBuilder.toString() + "를 한 줄로 요약해줘";
//            System.out.println(string);
//            String result = gpt(string);
//            System.out.println(result);
//
//            summaries.add(result);
//        }
//
//        return summaries;
//    }

//    private String gpt(String prompt) {
//        // 1. 레포지토리에서 target 검색어로 검색
//        // 2. 가져온 정책 리스트의 댓글에 대해 GPT 응답 생성
//        // 3. 리스트에 dto 담아서 반환
//        String text = "";
//        // HttpClient 생성
//        HttpClient client = HttpClient.newHttpClient();
//
//        String code = "c2stcHJvai04bzEwU014d1NZbkFTZGZyWkEzalQzQmxia0ZKYXNPSFc2dTFlRnVwQzB4SjVtSmE=";
//
//        try {
//            // JSON 객체 생성
//            JSONObject json = new JSONObject();
//            json.put("model", "gpt-3.5-turbo-instruct");
//            json.put("max_tokens", 100);
//            json.put("temperature", 0);
//            json.put("prompt", prompt);
//
//            String key = new String(Base64.getDecoder().decode(code.getBytes()));
//
//            // POST 요청 생성
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create("https://api.openai.com/v1/completions")) // 요청을 보낼 URL로 바꾸세요
//                    .header("Content-Type", "application/json")
//                    .header("Authorization", "Bearer " + key) // Authorization 헤더 추가
//                    .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
//                    .build();
//
//            // 요청 보내기 및 응답 받기
//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//            JSONObject responseBody = new JSONObject(response.body());
//            JSONArray choices = responseBody.getJSONArray("choices");
//            JSONObject firstChoice = choices.getJSONObject(0);
//            text = firstChoice.getString("text").replace("\n", "");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return text;
//    }

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
