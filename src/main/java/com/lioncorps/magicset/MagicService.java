package com.lioncorps.magicset;

import com.lioncorps.magicset.model.Card;
import com.lioncorps.magicset.model.CardBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by b.bassac on 05/04/2017.
 */
@Service
public class MagicService {
    @Autowired
    private ResourceLoader resourceLoader;
    private static String CRLF = System.getProperty("line.separator");

    public String displayFile(String fileName) throws IOException {
        StringBuilder toReturn = new StringBuilder();
        InputStream inputStram = resourceLoader.getResource(fileName).getInputStream();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStram, "UTF8"))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                toReturn.append(line).append(CRLF);
            }
        }
        return toReturn.toString();
    }

    public Card getCard() {

        Card c2 = CardBuilder.newCard("Kakashi Atake")
                .hasStyle("false")
                .notes("")
                .borderColor("rgb(0,0,0")
                .cardColor("white, multicolor")
                .castingCost("5")
                .image("")
                .superType("<word-list-type>Capitaine</word-list-type>")
                .subType("")
                .rarity("rare")
                .ruleText("Instantané:\n" +
                        "\t\t<sym>T</sym><i>Peut copier n’importe quel pouvoir sur le champs de bataille</i>")
                .flavorText("")
                .power("10")
                .toughness("5")
                .copyright("")

                .build();
        return c2;
    }
}
