package com.shareExp.backend.service;

import com.shareExp.backend.exception.FileNullException;
import com.shareExp.backend.exception.FileTypeInappropriateException;
import com.shareExp.backend.model.Category;
import com.shareExp.backend.model.Experience;
import com.shareExp.backend.utils.FileConfig;
import com.shareExp.backend.utils.FileUtils;
import com.shareExp.backend.utils.MD5;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
@Service
@Transactional
@AllArgsConstructor
public class ImageService {
    @Autowired
    FileConfig fileConfig;

    public String uploadExpImage(Experience offer, MultipartFile file) throws IOException, NoSuchAlgorithmException {
        if (file == null || file.getContentType() == null) throw new FileNullException();
        if(!file.getContentType().startsWith("image") && !file.getContentType().startsWith("application/pdf")){
            throw new FileTypeInappropriateException(file.getContentType().toLowerCase(),"image","pdf");
        }
        String documentName = MD5.getMD5Hash(offer.getTitle() )+ "." + FileUtils.getExtension(file);
        String documentPath = fileConfig.getDirectory();
        FileUtils.saveFile(file,documentPath, documentName);
        return documentName;



    }

    public String uploadCategoryImage(Category offer, MultipartFile file) throws IOException, NoSuchAlgorithmException {
        if (file == null || file.getContentType() == null) throw new FileNullException();
        if(!file.getContentType().startsWith("image") && !file.getContentType().startsWith("application/pdf")){
            throw new FileTypeInappropriateException(file.getContentType().toLowerCase(),"image","pdf");
        }
        String documentName = MD5.getMD5Hash(offer.getName() )+ "." + FileUtils.getExtension(file);
        String documentPath = fileConfig.getDirectory();
        FileUtils.saveFile(file,documentPath, documentName);
        return documentName;



    }
}
