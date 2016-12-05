package beerzeit.utils;

import org.apache.commons.io.IOUtils;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import java.io.*;

/**
 * Created by pedro on 27/11/16.
 */
public class AvatarStorage {
    public static final String FILES_DIR = "/home/pedro/DESENVOLVIMENTOWEB/uploads/";

    public static String save(UploadedFile avatar, String filename) throws IOException {
        InputStream avatarIS = avatar.getInputstream();

        String[] split = avatar.getFileName().split("\\.");

        String format = split[split.length - 1];
        String finalFileName = filename + "." + format;

        File f = new File(FILES_DIR, finalFileName);
        if (f.delete()) {
            System.out.println("deleted!");
        } else {
            System.out.println("didn't delete");
        }
        f.createNewFile();
        OutputStream avatarOS = new FileOutputStream(f);
        IOUtils.copy(avatarIS, avatarOS);

        return finalFileName;
    }


    public static StreamedContent showFile(String filename) throws FileNotFoundException {
        File f = new File(FILES_DIR, filename);
        FileInputStream fis = new FileInputStream(f);
        return new DefaultStreamedContent(fis);
    }
}
