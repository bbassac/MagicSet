package com.lioncorps.magicset.controller;


import com.lioncorps.magicset.MagicService;
import com.lioncorps.magicset.model.Card;
import com.lioncorps.magicset.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by b.bassac on 05/04/2017.
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    MagicService service;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {


        FileUtils.writeFile(file);

        StringBuilder toReturn = new StringBuilder();
        toReturn.append(service.getFileAsString("classpath:headers.txt"));
        for(Card c : service.loadCardsFromExcelFile(FileUtils.UPLOADED_FOLDER+file.getOriginalFilename())) {
            toReturn.append(c.toMseCard());
        }
        toReturn.append(service.getFileAsString("classpath:footers.txt"));

        FileUtils.writeFile(toReturn, FileUtils.UPLOADED_FOLDER+"\\set");
        FileUtils.zipFile(FileUtils.UPLOADED_FOLDER+"\\set",FileUtils.UPLOADED_FOLDER+"\\set.mse-set");

        File fileToReturn = new File(FileUtils.UPLOADED_FOLDER+"\\set.mse-set");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment","set.mse-set");
        headers.setContentLength(fileToReturn.length());
        InputStreamResource resource = new InputStreamResource(new FileInputStream(fileToReturn));

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(fileToReturn.length())
                .contentType(MediaType.parseMediaType(MediaType.APPLICATION_OCTET_STREAM_VALUE))
                .body(resource);

    }
}