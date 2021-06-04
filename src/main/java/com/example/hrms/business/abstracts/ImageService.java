package com.example.hrms.business.abstracts;

import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.Image;

import java.util.List;
import java.util.Optional;

public interface ImageService {
    DataResult<List<Image>> getByImageList();
    Result add(Image image);
    Result delete(int id);
    DataResult<Image> getByImageId(int imageId);


}
