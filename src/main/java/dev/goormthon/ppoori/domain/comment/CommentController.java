package dev.goormthon.ppoori.domain.comment;

import dev.goormthon.ppoori.domain.comment.dto.CommentRequest;
import dev.goormthon.ppoori.global.common.BaseResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static dev.goormthon.ppoori.global.status.SuccessStatus.COMMENT_SAVE_SUCCESS;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;

    /**
     * 댓글을 작성하는 컨트롤러입니다.
     * @param writeDto
     * @return
     */
    @PostMapping("/api/v1/policy/comment")
    public BaseResponseDto<?> saveComment(@RequestBody CommentRequest.WriteDto writeDto) {
        commentService.save(writeDto);
        return BaseResponseDto.SuccessResponse(COMMENT_SAVE_SUCCESS);
    }
}
