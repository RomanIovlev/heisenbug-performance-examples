package org.mytests.uiobjects.example;

import com.epam.jdi.tools.func.JAction;
import com.epam.jdi.tools.func.JFunc;
import org.apache.commons.lang3.time.StopWatch;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.String.format;
import static java.lang.System.getProperty;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.apache.commons.io.FileUtils.writeStringToFile;

public class FileUtils {
    public static long EXECUTION_TIME = 0;
    public static final int COUNT = 3;
    public static void writeInFile(String author, String taskName) {
        writeInFile(format("%s %s(%s) Average time: %s, ", new SimpleDateFormat("MM/dd HH:mm:ss")
                .format(new Date()), taskName, author, getAverageTime()));
    }
    private static long getAverageTime() {
        long result = EXECUTION_TIME / COUNT;
        EXECUTION_TIME = 0;
        return result;
    }
    private static void writeInFile(String text) {
        try {
            writeStringToFile(new File("results.csv"), text + getProperty("line.separator"), UTF_8, true);
        } catch (Exception ignore) { }
    }
    public static void process(JAction action, String author, String taskName) {
        process(() -> {action.invoke(); return null; }, author, taskName);
    }
    public static <T> T process(JFunc<T> func, String author, String taskName) {
        StopWatch timer = StopWatch.createStarted();
        T result = func.execute();
        long timePassed = timer.getTime();
        System.out.println(author + "; Time: " + timePassed);
        EXECUTION_TIME += timePassed;
        return result;
    }
}
