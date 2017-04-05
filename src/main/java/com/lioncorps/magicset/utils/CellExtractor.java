package com.lioncorps.magicset.utils;

import org.apache.poi.ss.usermodel.Cell;

/**
 * Created by b.bassac on 05/04/2017.
 */
public class CellExtractor {

    public static final String SEPARATOR = " :   ";
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
        if (cell.toString().equals("Special")) return "blue,red,artifact,radial";
        if (cell.toString().equals("Vent")) return "green";
        if (cell.toString().equals("Eau")) return "blue";
        if (cell.toString().equals("Feu")) return "red";
        if (cell.toString().equals("Terre")) return "black, red, land, multicolor, horizontal";
        if (cell.toString().equals("Foudre")) return "white, multicolor";
        if (cell.toString().equals("Physique")) return "white";
        if (cell.toString().equals("Equipement")) return "black";
        return "";
    }

    public static String extractFlavorStringValue(Cell cell) {

            return cell ==null ? "" : cell.toString()
                    .replaceAll("ō","ô")
                    .replaceAll("ū","û");

    }
}
