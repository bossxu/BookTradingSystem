package com.booktrading.demo.Controller;

import com.booktrading.demo.util.FileUtils;
import lombok.Value;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传
 */
@RestController
public class UploadController {


    private String path = "/var/www/images";

    /**
     * @param file 要上传的文件
     * @return
     */

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        String filename = FileUtils.upload(file, path, file.getOriginalFilename());
        if (!filename.equals("error")) {
            // 上传成功，给出页面提示
            return  "{\"state\":\"success\",\"response\":\""+filename+"\"}";
        } else {
            throw new ServiceException("图片上传失败");
        }
    }
}

