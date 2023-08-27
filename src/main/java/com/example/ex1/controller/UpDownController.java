package com.example.ex1.controller;


import com.example.ex1.util.CustomFileUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/updown")
@RequiredArgsConstructor
@Log4j2
public class UpDownController {


    private final CustomFileUtil fileUtil;

    @PostMapping("/upload")
    public List<String> uploadFiles ( List<MultipartFile> files ) {

        List<String> fileNames = fileUtil.saveFiles(files);

        log.info("------------------------------");
        log.info("------------------------------");
        log.info("------------------------------");
        log.info(fileNames);

        return fileNames;
    }




    @GetMapping("/view/{fileName}")
    public ResponseEntity<Resource> viewFileGET(@PathVariable String fileName){

        return fileUtil.getFile(fileName);

    }



}
