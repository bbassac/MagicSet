package com.lioncorps.magicset.utils;

import org.apache.poi.ss.usermodel.Cell;

/**
 * Created by b.bassac on 05/04/2017.
 */
public class CellExtractor {

    public static final String SEPARATOR = " :   ";
    //RARITY
    public static final String RARITY_COMMON = "common";
    public static final String RARITY_BASIC_LAND = "basic land";
    public static final String RARITY_UNCOMMON = "uncommon";
    public static final String RARITY_RARE = "rare";
    public static final String RARITY_MYTHIC_RARE = "mythic rare";
    public static final String RARITY_SPECIAL = "special";

    //CARD COLORS
    public static final String CARD_COLOR_SPECIAL = "blue,red,artifact,radial";
    public static final String CARD_COLOR_WIND = "green";
    public static final String CARD_COLOR_WATER = "blue";
    public static final String CARD_COLOR_FIRE = "red";
    public static final String CARD_COLOR_HEARTH = "black, red, land, multicolor, horizontal";
    public static final String CARD_COLOR_THUNDER = "white, multicolor";
    public static final String CARD_COLOR_PHYSIC = "white";
    public static final String CARD_COLOR_EQUIPMENT = "black";

    //COLUMN NUMBER
    public static int NAME = 0;
    public static int TYPE = 1;
    public static int EQUIPE = 2;
    public static int RARETE = 3;
    public static int NATURE_CHAKRA = 4;
    public static int ELEMENT = 5;
    public static int COUT = 6;
    public static int ATTAQUE = 7;
    public static int DEFENSE = 8;
    public static int POUVOIR = 9;
    public static int CITATION = 10;


    private static String CRLF = System.getProperty("line.separator");

    public static String extractTypeStringValue(Cell equipe, Cell nature, Cell element) {
        if (equipe == null) return "";
        if (element == null) return equipe.toString()+ SEPARATOR + nature.toString();
        if(nature.toString().equals(element.toString())) return equipe.toString()+SEPARATOR+nature.toString();
        return equipe.toString()+SEPARATOR+nature.toString()+" ("+element.toString()+")";
    }

    public static String extractBasicStringValue(Cell cell) {
        return cell ==null ? "" : cell.toString();
    }

    public static String extractPowerStringValue(Cell cell) {
        if(cell==null){
            return "";
        }else {
            String powerString = cell.toString();
            String[] lines = powerString.split("\n");
            StringBuilder builder = new StringBuilder();
            builder.append("\r\n");
            for(String line : lines){
                builder.append("\t\t")
                        .append(line)
                        .append(CRLF);

            }

            return builder.toString();
        }
    }

    public static String extractIntegerPart(Cell toParse){
        if (toParse == null) return "";
        String st = toParse.toString();
        if(st.equals("X")|| st.equals("-") || st.equals("")){
            return st;
        }else {
            Double doub = Double.parseDouble(st);
            return String.valueOf(doub.intValue());
        }
    }

    public static String extractCardColor(Cell cell) {
        if (cell.toString().equals("Special")) return CARD_COLOR_SPECIAL;
        if (cell.toString().equals("Vent")) return CARD_COLOR_WIND;
        if (cell.toString().equals("Eau")) return CARD_COLOR_WATER;
        if (cell.toString().equals("Feu")) return CARD_COLOR_FIRE;
        if (cell.toString().equals("Terre")) return CARD_COLOR_HEARTH;
        if (cell.toString().equals("Foudre")) return CARD_COLOR_THUNDER;
        if (cell.toString().equals("Physique")) return CARD_COLOR_PHYSIC;
        if (cell.toString().equals("Equipement")) return CARD_COLOR_EQUIPMENT;
        return "";
    }

    public static String extractFlavorStringValue(Cell cell) {

            return cell ==null ? "" : cell.toString()
                    .replaceAll("ō","ô")
                    .replaceAll("ū","û");

    }

    public static String extractRarityStringValue(Cell cell) {
        if (cell == null ) return RARITY_COMMON;
        if (cell.toString().equals("Invocation")) return RARITY_BASIC_LAND;
        if (cell.toString().equals("Capitaine")) return RARITY_UNCOMMON;
        if (cell.toString().equals("Sanin")) return RARITY_RARE;
        if (cell.toString().equals("Kage")) return RARITY_MYTHIC_RARE;
        if (cell.toString().equals("Jinchûriki")) return RARITY_SPECIAL;
        return RARITY_COMMON;

    }
}
