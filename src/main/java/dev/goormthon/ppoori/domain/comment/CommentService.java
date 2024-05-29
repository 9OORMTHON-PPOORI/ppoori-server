package dev.goormthon.ppoori.domain.comment;

import dev.goormthon.ppoori.domain.comment.converter.CommentConverter;
import dev.goormthon.ppoori.domain.comment.dto.CommentRequest;
import dev.goormthon.ppoori.domain.policy.Policy;
import dev.goormthon.ppoori.domain.policy.PolicyRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PolicyRepository policyRepository;

    public void save(CommentRequest.WriteDto writeDto, Long policyId) {
        Policy policy = policyRepository.findById(policyId)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        Comment comment = CommentConverter.toEntity(writeDto, policy);
        commentRepository.save(comment);
    }
}
