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

import java.util.List;

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

    @Override
    public DataResult<List<Image>> getByCandidatesId(int id) {
        return new SuccessDataResult<List<Image>>(this.imageDao.getByCandidatesId(id),"Data listelendi");
    }

    @Override
    public DataResult<List<Image>> getByCandidatesIdAndStatusTrue(int id) {
        return new SuccessDataResult<List<Image>>(this.imageDao.getByCandidatesIdAndStatusTrue(id),"Status True");
    }

    @Override
    public DataResult<List<Image>> getByCandidatesIdAndStatusFalse(int id) {
        return new SuccessDataResult<List<Image>>(this.imageDao.getByCandidatesIdAndStatusFalse(id),"Status False");
    }


}

