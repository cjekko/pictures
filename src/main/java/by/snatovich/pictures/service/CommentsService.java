package by.snatovich.pictures.service;

import by.snatovich.pictures.domain.Comment;
import by.snatovich.pictures.domain.Picture;
import by.snatovich.pictures.domain.request.AddCommentRequest;
import by.snatovich.pictures.repository.CommentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentsService {

    private final CommentsRepository commentsRepository;

    public Long addComment(AddCommentRequest request) {
        final Comment addedComment = this.commentsRepository.save(Comment.builder()
                .creatorName(request.getCreatorName())
                .picture(Picture.builder().id(request.getPictureId()).build())
                .text(request.getText())
                .build());
        return addedComment.getId();
    }
}
