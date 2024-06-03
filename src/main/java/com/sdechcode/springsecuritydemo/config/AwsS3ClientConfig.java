package com.sdechcode.springsecuritydemo.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsS3ClientConfig {

    @Value("${aws.access}")
    private String accessKeyId;
    @Value("${aws.secret}")
    private String secretKeyId;
    @Value("${aws.account-no}")
    private String accountId;

    @Bean
    public AmazonS3 s3Client() {
        BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(accessKeyId, secretKeyId);
        return AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("https://" + accountId + ".r2.cloudflarestorage.com", "auto"))
                .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
                .build();
    }

}
