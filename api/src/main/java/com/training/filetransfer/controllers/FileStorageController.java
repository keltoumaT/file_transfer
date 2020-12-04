package com.training.filetransfer.controllers;


import com.training.filetransfer.dtos.FileDto;
import com.training.filetransfer.services.AmazonClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/api/storage")
public class FileStorageController {

    private final AmazonClient amazonClient;

    public FileStorageController(AmazonClient amazonClient) {
        this.amazonClient = amazonClient;
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestPart(value = "file")MultipartFile file, @RequestPart(value = "recipientEmail") String recipientEmail)throws Exception{
        return amazonClient.uploadFile(file, recipientEmail);
    }

    @DeleteMapping("/deleteFile")
    public String deleteFile(@RequestPart(value = "url")String fileUrl) throws Exception{
        return amazonClient.deleteFileFromS3Bucket(fileUrl);
    }

    @GetMapping
    public File getFile(@RequestPart(value = "fileName")String fileName){
      return amazonClient.objectToFile(fileName);
    }
}
