package com.epam.AWSKyc.service;

import com.epam.AWSKyc.beans.UploadFileResponse;

import java.io.File;

public interface FileStorageService {
        UploadFileResponse upload(File file);
}
