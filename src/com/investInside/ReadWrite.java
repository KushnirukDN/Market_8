package com.investInside;

import java.io.*;
import java.nio.file.Files;
import java.util.TreeMap;

public class ReadWrite {
    public static String[] readInput() throws IOException {
        File input = new File("input.txt");
        String[] units = new String(Files.readAllBytes(input.toPath())).split("\n");
        return units;
    }

    public static void writeResult(String order) throws IOException {
        File output = new File("output.txt");
        OutputStream os = new FileOutputStream(output, true);
        try {
            os.write((order.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            os.close();
        }

    }
}