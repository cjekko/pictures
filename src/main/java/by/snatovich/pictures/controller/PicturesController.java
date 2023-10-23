package by.snatovich.pictures.controller;

import by.snatovich.pictures.domain.Picture;
import by.snatovich.pictures.service.PicturesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/pictures")
@RequiredArgsConstructor
public class PicturesController {

    private final PicturesService picturesService;

    @PostMapping("/add")
    public Long addPicture(@RequestParam("image") MultipartFile file) throws IOException {
        return this.picturesService.addPicture(file);
    }

    @GetMapping("/get")
    public List<Picture> getAllPictures() {
        return this.picturesService.getAllPictures();
    }

    @GetMapping("/get/{id}")
    public Picture getPictureById(@PathVariable Long id) {
        return this.picturesService.getPictureById(id).orElse(null);
    }
}
