package com.example.ex1.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/sample")
@Log4j2
public class SampleController {


    @GetMapping("/ex1")
    public String[] ex1() {

        log.info("Sample Controller ex1....");


        String path = null;
        try {
            path = SampleController.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        return new String[]{"AAA","BBB","CCC", path};
    }
}
