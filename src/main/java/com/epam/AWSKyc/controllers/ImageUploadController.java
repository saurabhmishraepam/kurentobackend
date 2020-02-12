package com.epam.AWSKyc.controllers;


import com.epam.AWSKyc.beans.UploadFileResponse;
import com.epam.AWSKyc.beans.UploadInfo;
import com.epam.AWSKyc.service.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ImageUploadController {

    private static final Logger logger = LoggerFactory.getLogger(ImageUploadController.class);
    @Autowired
    private FileStorageService uploadFile;

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files, @RequestBody UploadInfo uploadInfo) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file
                        //        , uploadInfo
                ))
                .collect(Collectors.toList());
    }

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file
                                         //,
                                         //                                     @RequestBody UploadInfo uploadInfo
    ) {
        // logger.info(uploadInfo.toString());
        logger.info(file.getContentType());
        uploadFile.upload(multipartToFile(file));
        return new UploadFileResponse();
    }


    public File multipartToFile(MultipartFile file) {
        try {
            File convFile = new File(System.getProperty("java.io.tmpdir") + "/" + file.getOriginalFilename());
            file.transferTo(convFile);
            return convFile;
        } catch (IOException exc) {

        }
        return  null;
    }

}
