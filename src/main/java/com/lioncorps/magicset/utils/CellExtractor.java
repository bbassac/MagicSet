package com.lioncorps.magicset.utils;

import com.lioncorps.magicset.model.MasterCard.Power;
import org.apache.poi.ss.usermodel.Cell;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by b.bassac on 05/04/2017.
 */
public class CellExtractor {

    public static final String SEPARATOR = " :   ";
    public static final String PERMANENT = "Permanent : ";
    public static final String UNEFOIS = "1 fois : ";
    public static final String INSTANTANE = "Instantané : ";


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
        if(nature.toString().equals("Environnement")) return  equipe.toString()+SEPARATOR+element.toString();
        if(nature.toString().equals("Lieu légendaire")) return  equipe.toString()+SEPARATOR+element.toString();
        if(nature.toString().equals("Quête")) return  nature.toString();
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
            for(int i=0;i<lines.length;i++){
                builder.append("\t\t").append(processMSEPower(lines[i]));
                if(i != lines.length-1){
                    builder.append(CRLF);
                }

            }

            return builder.toString();
        }
    }

    private static String processMSEPower(String line) {
        return line
                .replaceAll(PERMANENT, MagicSetEditorUtils.SYMB_INFINITE)
                .replaceAll(UNEFOIS, MagicSetEditorUtils.SYMB_ACTIVATE)
                .replaceAll(INSTANTANE, MagicSetEditorUtils.SYMB_INSTANT);
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
        if (cell.toString().equals("Special")) return MagicSetEditorUtils.CARD_COLOR_SPECIAL;
        if (cell.toString().equals("Vent")) return MagicSetEditorUtils.CARD_COLOR_WIND;
        if (cell.toString().equals("Eau")) return MagicSetEditorUtils.CARD_COLOR_WATER;
        if (cell.toString().equals("Feu")) return MagicSetEditorUtils.CARD_COLOR_FIRE;
        if (cell.toString().equals("Terre")) return MagicSetEditorUtils.CARD_COLOR_HEARTH;
        if (cell.toString().equals("Foudre")) return MagicSetEditorUtils.CARD_COLOR_THUNDER;
        if (cell.toString().equals("Physique")) return MagicSetEditorUtils.CARD_COLOR_PHYSIC;
        if (cell.toString().equals("Equipement")) return MagicSetEditorUtils.CARD_COLOR_EQUIPMENT;
        return "";
    }

    public static String extractFlavorStringValue(Cell flavorCell,Cell powerCell) {
        String toReturn = flavorCell ==null ? "" : flavorCell.toString()
                .replaceAll("ō","ô")
                .replaceAll("ū","û");
        int nbPouvoirs = getNbPouvoirs(powerCell);
        int nbSpaceToCenter = (MagicSetEditorUtils.CITATION_MAX_LENGTH - toReturn.length())/2;

        return "<i-flavor>"+getSpace(nbSpaceToCenter)+toReturn+"</i-flavor>";


    }

    private static int getNbPouvoirs(Cell powerCell) {
        String[] lines = powerCell.toString().split("\n");
        return lines.length;
    }

    private static String getSpace(int count)
    {
        String space="";
        for(int i=0;i<count;i++)
            space+=" ";
        return space;
    }

    public static String extractRarityStringValue(Cell cell) {
        if (cell == null ) return MagicSetEditorUtils.RARITY_COMMON;
        if (cell.toString().equals("Invocation")) return MagicSetEditorUtils.RARITY_BASIC_LAND;
        if (cell.toString().equals("Capitaine")) return MagicSetEditorUtils.RARITY_UNCOMMON;
        if (cell.toString().equals("Sanin")) return MagicSetEditorUtils.RARITY_RARE;
        if (cell.toString().equals("Kage")) return MagicSetEditorUtils.RARITY_MYTHIC_RARE;
        if (cell.toString().equals("Epique")) return MagicSetEditorUtils.RARITY_MYTHIC_RARE;
        if (cell.toString().equals("Jinchûriki")) return MagicSetEditorUtils.RARITY_SPECIAL;
        return MagicSetEditorUtils.RARITY_COMMON;

    }

    public static String extractCardType(Cell cell) {
        return  cell ==null ? "" : cell.toString();
    }

    public static List<Power> extractPowers(Cell cell) {
        List<Power> toReturn = new ArrayList<>();
        if(cell!=null) {
            String powerString = cell.toString();
            String[] lines = powerString.split("\n");

            for(int i=0;i<lines.length;i++){
                Power p = new Power();
                p.setDescription(lines[i]);
                toReturn.add(p);
            }


        }
        return toReturn;
    }
}
