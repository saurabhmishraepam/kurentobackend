package com.epam.AWSKyc.configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSConfiguration {

    @Bean
    public AWSCredentials getAWSCredential(){
        AWSCredentials credentials = new BasicAWSCredentials(
                "AKIAJAE55E6ZSKKSPZWA",
                "6yJw1D4b1+UNwoEnjc1qwAhxZJ25P3ph0wkWD1FG"
        );
        return credentials;
    }
    @Bean
    public AmazonS3 getAmazonS3Client(@Autowired AWSCredentials awsCredentials){
        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .withRegion(Regions.AP_SOUTH_1)
                .build();
        return s3client;
    }



}
