package com.lioncorps.magicset;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.lioncorps.magicset.model.Card;
import com.lioncorps.magicset.model.CardBuilder;

import com.lioncorps.magicset.model.MasterCard.CardProject;
import com.lioncorps.magicset.utils.CellExtractor;
import com.lioncorps.magicset.utils.MagicSetEditorUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.ArrayList;

import java.util.List;

/**
 * Created by b.bassac on 05/04/2017.
 */
@Service
public class MagicService {
    @Autowired
    private ResourceLoader resourceLoader;
    private static String CRLF = System.getProperty("line.separator");

    public String getFileAsString(String fileName) throws IOException {
        StringBuilder toReturn = new StringBuilder();
        InputStream inputStram = resourceLoader.getResource(fileName).getInputStream();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStram, "UTF8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                toReturn.append(line).append(CRLF);
            }
        }
        return toReturn.toString();
    }

    public List<Card> loadCardsFromExcelFile(String filePath) {
        List<Card> toReturn = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(file);
        //Get first sheet from the workbook
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if(row.getRowNum()!=0 && !StringUtils.isEmpty(row.getCell(CellExtractor.NAME).toString())) {
                   Card c = MagicSetEditorUtils.convertExcelRowToCard(row);
                    toReturn.add(c);
                }
            }
        } catch (InvalidFormatException | IOException e) {
            System.out.println(e);

        }
        return toReturn;
    }

    public String loadMasterCardsFromExcelFile(String filePath) throws JsonProcessingException {
        CardProject project = new CardProject();
        try {
            FileInputStream file = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(file);
            //Get first sheet from the workbook
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if(row.getRowNum()!=0 && !StringUtils.isEmpty(row.getCell(CellExtractor.NAME).toString())) {
                    com.lioncorps.magicset.model.MasterCard.Card c = MagicSetEditorUtils.convertExcelRowToMasterCard(row);
                    project.getCards().add(c);
                }
            }
        } catch (InvalidFormatException | IOException e) {
            System.out.println(e);

        }



        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String uniJSON = mapper.writeValueAsString(project);
        return uniJSON;

    }


}
