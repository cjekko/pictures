package by.snatovich.pictures.controller;


import by.snatovich.pictures.domain.request.AddCommentRequest;
import by.snatovich.pictures.service.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentsController {

    private final CommentsService commentsService;

    @PostMapping("/add")
    public Long addComment(@RequestBody AddCommentRequest request) {
        return this.commentsService.addComment(request);
    }
}
