package com.epam.AWSKyc.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.epam.AWSKyc.beans.UploadFileResponse;
import com.epam.AWSKyc.service.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class S3FileStorageService implements FileStorageService {

    private static final Logger logger = LoggerFactory.getLogger(S3FileStorageService.class);

    @Autowired
    private AmazonS3 s3Client;

    private String bucketName="kyc-amz";

    @Override
    public UploadFileResponse upload(File file) {
        logger.info(s3Client.listBuckets().toString());
        logger.info(file.getName());
        logger.info(s3Client.getRegionName());
        s3Client.putObject(
                bucketName,
                "Images/"+file.getName(),
                file
        );
        return null;
    }
}
