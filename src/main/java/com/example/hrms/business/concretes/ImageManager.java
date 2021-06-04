package com.example.hrms.business.concretes;


import com.example.hrms.business.abstracts.ImageService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.core.results.SuccessDataResult;
import com.example.hrms.core.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.ImageDao;
import com.example.hrms.entities.concretes.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImageManager implements ImageService {

    private ImageDao imageDao;

    @Autowired
    public ImageManager(ImageDao imageDao) {
        this.imageDao = imageDao;
    }

    @Override
    public DataResult<List<Image>> getByImageList() {
        return new SuccessDataResult<List<Image>>(imageDao.findImageBy(),"Data listelendi");
    }

    @Override
    public Result add(Image image) {
        imageDao.save(image);
        return new SuccessResult("Resim eklendi");
    }

    @Override
    public Result delete(int id) {
        imageDao.deleteById(id);
        return new SuccessResult("Resim Silindi");
    }

    @Override
    public DataResult<Image> getByImageId(int imageId) {
        return new SuccessDataResult<Image>(imageDao.getByImageId(imageId));
    }


}

