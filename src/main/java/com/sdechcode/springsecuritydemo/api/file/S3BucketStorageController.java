package com.sdechcode.springsecuritydemo.api.file;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.SneakyThrows;
import lombok.val;

@RestController
@RequestMapping(value = "${api.endpoint.base-url}/s3bucketstorage")
public class S3BucketStorageController {

    @Autowired
    private S3BucketStorageService service;

    @GetMapping(value = "/{bucketName}")
    public ResponseEntity<?> listFiles(
        @PathVariable("bucketName") String bucketName
    ) {
        val body = service.listFiles(bucketName);
        return ResponseEntity.ok(body);
    }
    
    @PostMapping(value = "/{bucketName}/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @SneakyThrows(IOException.class)
    public ResponseEntity<?> uploadFile(
        @PathVariable("bucketName") String bucketName,
        @RequestPart("file") MultipartFile file,
        @RequestPart("fileName") String fileName
    ) {
        service.uploadFile(bucketName, fileName, file.getSize(), file.getContentType(), file.getInputStream());
        return ResponseEntity.ok().build();
    }

    @SneakyThrows
    @GetMapping(value = "/{bucketName}/download/{fileName}")
    public ResponseEntity<?> downloadFile(
        @PathVariable("bucketName") String bucketName,
        @PathVariable("fileName") String fileName
    ) {
        val body = service.downloadFile(bucketName, fileName);

        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
            .contentType(FileMediaType.fromFilename(fileName))
            .body(body.toByteArray());
    }

    @DeleteMapping(value = "/{bucketName}/{fileName}")
    public ResponseEntity<?> deleteFile(
        @PathVariable("bucketName") String bucketName,
        @PathVariable("fileName") String fileName
    ) {
        service.deleteFile(bucketName, fileName);
        return ResponseEntity.ok().build();
    }

}
