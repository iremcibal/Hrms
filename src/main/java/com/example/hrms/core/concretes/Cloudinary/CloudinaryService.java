package com.example.hrms.core.concretes.Cloudinary;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.cloudinary.utils.ObjectUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryService {

    Cloudinary cloudinary;
    private Map<String , String> valuesMap = new HashMap<>();

    @Autowired
    public CloudinaryService(){
        valuesMap.put("cloud_name","stanbul");
        valuesMap.put("api_key","751135642641689");
        valuesMap.put("api_secret","kwAiiwj4J6XDXmjSudAxilTTmdM");
        this.cloudinary=new Cloudinary("cloudinary://343745471297952:dU21SZt_wM2Y0lrfZ7aMc1igovY@dw2jquesf");
        cloudinary = new Cloudinary(valuesMap);
    }

    public Map upload(MultipartFile multipartFile) throws Exception{
        File file = convert(multipartFile);
        Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        file.delete();
        return result;
    }

    public Map delete(String id) throws IOException{
        Map result = cloudinary.uploader().destroy(id,ObjectUtils.emptyMap());
        return result;
    }

    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream fo =new FileOutputStream(file);
        fo.write(multipartFile.getBytes());
        fo.close();
        return file;
    }
}
