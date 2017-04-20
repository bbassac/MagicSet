package com.lioncorps.magicset.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by b.bassac on 06/04/2017.
 */
public class FileUtils {
    public static String UPLOADED_FOLDER = "D://TMPSET//";

    public static void writeFile(String toReturn, String outputFullPath) throws IOException {
        Writer out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(outputFullPath), "UTF-8"));
        try {
            out.write(toReturn);
        } finally {
            out.close();
        }
    }

    public static void writeFile(MultipartFile file) throws IOException {
        Path path = Paths.get(FileUtils.UPLOADED_FOLDER + file.getOriginalFilename());
        Files.write(path, file.getBytes());
    }

    public static void zipFile(String fullPathFileInput, String fullPathFileOutput){
        byte[] buffer = new byte[1024];

        try{
            File fileInput = new File(fullPathFileInput);
            FileOutputStream fos = new FileOutputStream(fullPathFileOutput);
            ZipOutputStream zos = new ZipOutputStream(fos);
            ZipEntry ze = new ZipEntry(fileInput.getName());
            zos.putNextEntry(ze);
            FileInputStream in = new FileInputStream(fullPathFileInput);

            int len;
            while ((len = in.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }

            in.close();
            zos.closeEntry();

            //remember close it
            zos.close();

            System.out.println("Done");

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

}
