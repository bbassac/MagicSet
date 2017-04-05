package com.lioncorps.magicset.utils;

import org.apache.poi.ss.usermodel.Cell;

/**
 * Created by b.bassac on 05/04/2017.
 */
public class CellExtractor {
    private static String CRLF = System.getProperty("line.separator");

    public static String extractTypeStringValue(Cell cell1, Cell cell2) {
        if (cell1 == null) return "";
        if (cell2 == null) return cell1.toString();
        return cell1.toString()+" :  "+cell2.toString();
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
}
