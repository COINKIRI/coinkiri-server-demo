package coinkiri.api.controller.comment

import coinkiri.api.controller.comment.dto.request.CommentRequestDto
import coinkiri.api.service.comment.CommentService
import coinkiri.common.response.ApiResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Comment")
@RestController
@RequestMapping("/api/v1/comment")
class CommentController(
    private val commentService: CommentService
) {

    // 댓글 작성 API
    @Operation(summary = "댓글 작성")
    @PostMapping("/save")
    fun saveComment(request: CommentRequestDto): ResponseEntity<ApiResponse<Any>>{
        commentService.saveComment(request)
        return ResponseEntity.ok(ApiResponse.success())
    }

}