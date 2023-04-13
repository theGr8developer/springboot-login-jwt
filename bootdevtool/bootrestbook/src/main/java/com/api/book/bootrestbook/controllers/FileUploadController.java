package com.api.book.bootrestbook.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.book.bootrestbook.helper.fileUpload;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;;

@RestController
public class FileUploadController {

    @Autowired
    fileUpload fileupload;
    @PostMapping("/file-upload")
    public ResponseEntity<String> FileUpload(@RequestParam("file") MultipartFile file){

       String s =  fileupload.createFile(file);

        return ResponseEntity.ok(s);

    }
    
}
