package com.epam.AWSKyc.beans;

import com.epam.AWSKyc.beans.constants.UploadImageType;
import lombok.Data;

@Data
public class UploadInfo {
    private String userId;
    private String sessionId;
    private UploadImageType uploadImageType;


}
