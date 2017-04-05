package com.lioncorps.magicset.controller;

import com.lioncorps.magicset.MagicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
@RequestMapping("/export")
public class ExportController {

    @Autowired
    MagicService service;



    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public ResponseEntity<byte[]> getCollections() throws IOException {

        StringBuilder toReturn = new StringBuilder();
        toReturn.append(service.displayFile("classpath:headers.txt"));
        toReturn.append(service.getCard().toString());
        toReturn.append(service.displayFile("classpath:footers.txt"));

        ResponseEntity<byte[]> responseEntity = buildResponseFromString(toReturn);
        return responseEntity;
    }

    private ResponseEntity<byte[]> buildResponseFromString(StringBuilder toReturn) throws IOException {
        Writer out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("d:\\set"), "UTF-8"));
        try {
            out.write(toReturn.toString());
        } finally {
            out.close();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment:filename=set");
        return new ResponseEntity<>(toReturn.toString().getBytes(), headers, HttpStatus.OK);
    }


}