package com.mjiang.email.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * This is created by mjiang on 1/05/18.
 */
public class FileUtil {

    public static ClassLoader getClassLoader() {
        return FileUtil.class.getClassLoader();
    }

    public static String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (resultStringBuilder.length() > 0) {
                    resultStringBuilder.append("\n");
                }
                resultStringBuilder.append(line);
            }
        }

        return resultStringBuilder.toString();
    }

    public static String readFileByClasspath(String file) throws Exception {
        return readFromInputStream(getClassLoader().getResourceAsStream(file));
    }

    public static String readFileByJdk7(String file) throws Exception {
        Path path = Paths.get(getClassLoader().getResource(file).toURI());
        byte[] fileBytes = Files.readAllBytes(path);

        return new String(fileBytes);
    }

    public static String readFileByJdk8(String file) throws Exception {
        Path path = Paths.get(getClassLoader().getResource(file).toURI());

        StringBuilder data = new StringBuilder();

        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(data::append);
        }

        return data.toString();
    }
}
