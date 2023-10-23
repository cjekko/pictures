package by.snatovich.pictures.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String creatorName;

    private String text;

    @ToString.Exclude
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "picture_id", nullable = false)
    private Picture picture;
}
