package beerzeit.utils.filters;

import org.apache.commons.io.IOUtils;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import java.io.*;

/**
 * Created by pedro on 27/11/16.
 */
public class BeerRecipeStorage {
    private static final String FILES_DIR = "/home/pedro/DESENVOLVIMENTOWEB/uploads/";

    public static String save(UploadedFile picture, String filename) throws IOException {
        InputStream avatarIS = picture.getInputstream();

        String[] split = picture.getFileName().split("\\.");

        String format = split[split.length - 1];
        String finalFileName = "picture/" + filename + "." + format;

        File f = new File(FILES_DIR, finalFileName);
        f.createNewFile();
        OutputStream avatarOS = new FileOutputStream(f);
        IOUtils.copy(avatarIS, avatarOS);

        return finalFileName;
    }

    public static StreamedContent showFile(String filename) throws FileNotFoundException {
        File f = new File(FILES_DIR, "picture/" + filename);
        FileInputStream fis = new FileInputStream(f);
        return new DefaultStreamedContent(fis);
    }
}
