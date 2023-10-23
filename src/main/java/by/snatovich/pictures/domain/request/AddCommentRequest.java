package by.snatovich.pictures.domain.request;

import lombok.Data;

@Data
public class AddCommentRequest {
    private Long pictureId;
    private String creatorName;
    private String text;
}
