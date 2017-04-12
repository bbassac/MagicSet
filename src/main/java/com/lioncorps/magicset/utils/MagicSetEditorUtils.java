package com.lioncorps.magicset.utils;

import com.lioncorps.magicset.model.Card;
import com.lioncorps.magicset.model.CardBuilder;
import org.apache.poi.ss.usermodel.Row;

/**
 * Created by b.bassac on 11/04/2017.
 */
public class MagicSetEditorUtils {
    //RARITY
    public static final String RARITY_COMMON = "common";
    public static final String RARITY_BASIC_LAND = "basic land";
    public static final String RARITY_UNCOMMON = "uncommon";
    public static final String RARITY_RARE = "rare";
    public static final String RARITY_MYTHIC_RARE = "mythic rare";
    public static final String RARITY_SPECIAL = "special";

    //CARD COLORS
    //VIOLET
    public static final String CARD_COLOR_SPECIAL = "blue,red,artifact,radial";
    //VERT
    public static final String CARD_COLOR_WIND = "green";
    //BLEU
    public static final String CARD_COLOR_WATER = "blue";
    //ROUGE
    public static final String CARD_COLOR_FIRE = "red";
    //MARRON
    public static final String CARD_COLOR_HEARTH = "black, red, land, multicolor, horizontal";
    //JAUNE
    public static final String CARD_COLOR_THUNDER = "white, multicolor";
    //BLANC
    public static final String CARD_COLOR_PHYSIC = "white";
    //NOIR
    public static final String CARD_COLOR_EQUIPMENT = "black";

    public static String SYMB_ACTIVATE = "<sym>T</sym> ";
    public static String SYMB_X_COST = "<sym>X</sym> ";
    public static String SYMB_INSTANT = "<sym>C</sym> ";
    public static String SYMB_INFINITE = "<sym>I</sym> ";
    public static String SYMB_COST(int cost){
        return "<sym>"+cost+"</sym> ";
    }

    public static int CITATION_MAX_LENGTH = 50;

    public static Card convertExcelRowToCard(Row row) {
        Card c = CardBuilder.newCard(CellExtractor.extractBasicStringValue(row.getCell(CellExtractor.NAME)))
                .hasStyle("false")
                .notes("")
                .borderColor("rgb(0,0,0")
                .cardColor(CellExtractor.extractCardColor(row.getCell(CellExtractor.NATURE_CHAKRA)))
                .castingCost(CellExtractor.extractIntegerPart(row.getCell(CellExtractor.COUT)))
                .image("")
                .superType(CellExtractor.extractTypeStringValue(row.getCell(CellExtractor.EQUIPE),row.getCell(CellExtractor.NATURE_CHAKRA),row.getCell(CellExtractor.ELEMENT)))
                .subType("")
                .rarity(CellExtractor.extractRarityStringValue(row.getCell(CellExtractor.RARETE)))
                .ruleText(CellExtractor.extractPowerStringValue(row.getCell(CellExtractor.POUVOIR)))
                .flavorText(CellExtractor.extractFlavorStringValue(row.getCell(CellExtractor.CITATION)))
                .power(CellExtractor.extractIntegerPart(row.getCell(CellExtractor.ATTAQUE)))
                .toughness(CellExtractor.extractIntegerPart(row.getCell(CellExtractor.DEFENSE)))
                .copyright("Lioncorps")

                .build();
        return c;
    }
}
