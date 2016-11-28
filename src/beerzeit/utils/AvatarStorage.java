package beerzeit.utils;

import org.apache.commons.io.IOUtils;
import org.primefaces.model.UploadedFile;

import java.io.*;

/**
 * Created by pedro on 27/11/16.
 */
public class AvatarStorage {
    private static final String FILES_DIR = "/home/pedro/DESENVOLVIMENTOWEB/uploads/";

    public static String save(UploadedFile avatar, String filename) throws IOException {
        InputStream avatarIS = avatar.getInputstream();

        String[] split = avatar.getFileName().split("\\.");

        String format = split[split.length - 1];
        String finalFileName = filename + "." + format;

        File f = new File(FILES_DIR, filename);
        f.createNewFile();
        OutputStream avatarOS = new FileOutputStream(f);
        IOUtils.copy(avatarIS, avatarOS);

        return FILES_DIR + filename;
    }
}
