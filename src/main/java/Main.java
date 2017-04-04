import model.Card;

import java.io.*;

/**
 * Created by b.bassac on 04/04/2017.
 */
public class Main {
    private static String CRLF = System.getProperty("line.separator");
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        StringBuilder toReturn = new StringBuilder();
        toReturn.append(main.displayFile(main,"headers.txt"));
        toReturn.append(displayCards());
        toReturn.append(main.displayFile(main,"footers.txt"));

        Writer out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("d:\\set"), "UTF-8"));
        try {
            out.write(toReturn.toString());
        } finally {
            out.close();
        }
    }

    private static String displayCards() {
        Card c1 = new Card("false",
                "","rgb(0,0,0",
                "white, multicolor","Kakashi Atake",
                "5","",
                "<word-list-type>Capitaine</word-list-type>","","rare",
                "Instantané:\n" +
                        "\t\t<sym>T</sym><i>Peut copier n’importe quel pouvoir sur le champs de bataille</i>",
                "","10","10","");
        return (c1.toString());
    }

    private String displayFile(Main main,String fileName) throws IOException {
        StringBuilder toReturn = new StringBuilder();
        File header = main.getFile(fileName);
        try (BufferedReader br = new BufferedReader( new InputStreamReader(
                new FileInputStream(header), "UTF8"))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                toReturn.append(line).append(CRLF);
            }
        }
        return toReturn.toString();
    }

    private File getFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource(fileName).getFile());
    }
}
