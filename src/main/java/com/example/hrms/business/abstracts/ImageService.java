package com.example.hrms.business.abstracts;

import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.Image;

import java.util.List;

public interface ImageService {
    DataResult<List<Image>> getByImageList();
    Result add(Image image);
    Result delete(int id);
    DataResult<Image> getByImageId(int imageId);

    DataResult<List<Image>> getByCandidatesId(int id);

    DataResult<List<Image>> getByCandidatesIdAndStatusTrue(int id);
    DataResult<List<Image>> getByCandidatesIdAndStatusFalse(int id);

}
