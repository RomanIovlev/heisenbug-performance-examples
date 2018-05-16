package org.mytests.uiobjects.example;

import java.io.File;
import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.*;
import static org.apache.commons.io.FileUtils.writeStringToFile;

public class FileUtils {
    public static void writeInFile(String text) {
        try {
            writeStringToFile(new File("results.csv"), text, UTF_8);
        } catch (Exception ignore) { }
    }
}
