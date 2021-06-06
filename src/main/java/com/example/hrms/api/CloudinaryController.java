package com.example.hrms.api;


import com.example.hrms.business.abstracts.ImageService;
import com.example.hrms.core.concretes.Cloudinary.CloudinaryService;
import com.example.hrms.business.concretes.ImageManager;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.Candidates;
import com.example.hrms.entities.concretes.Image;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cloudinary")
@CrossOrigin
public class CloudinaryController {

    private CloudinaryService cloudinaryService;
    private ImageService imageService;

    public CloudinaryController(CloudinaryService cloudinaryService, ImageService imageService) {
        this.cloudinaryService = cloudinaryService;
        this.imageService = imageService;
    }

    @GetMapping("/list")
    public DataResult<List<Image>> list(){
        return imageService.getByImageList();
    }

    @PostMapping("/upload")
    public Result upload(@RequestParam MultipartFile multipartFile) throws Exception {
        Map result = cloudinaryService.upload(multipartFile);
        Image image = new Image((String) result.get("original_filename"),
                (String) result.get("url"),(String) result.get("public_id"));
        return imageService.add(image);
    }

    @DeleteMapping("/delete{imageId}")
    public Result delete(@PathVariable("imageId") int imageId) throws IOException{
        Image image = imageService.getByImageId(imageId).getData();
        Map result = cloudinaryService.delete(image.getPublicId());
        return imageService.delete(imageId);
    }

}
