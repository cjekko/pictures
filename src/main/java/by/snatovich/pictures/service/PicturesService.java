package by.snatovich.pictures.service;

import by.snatovich.pictures.domain.Picture;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PicturesService {

    private final JpaRepository<Picture, Long> picturesRepository;

    public Long addPicture(MultipartFile file) throws IOException {
        final Picture addedPicture = this.picturesRepository.save(Picture.builder()
                .imageData(file.getBytes())
                .build());

        return addedPicture.getId();
    }

    public Optional<Picture> getPictureById(Long pictureId) {
        return this.picturesRepository.findById(pictureId);
    }

    public List<Picture> getAllPictures() {
        return this.picturesRepository.findAll();
    }
}
