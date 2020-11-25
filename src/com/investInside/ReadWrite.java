package com.investInside;

import java.io.*;
import java.nio.file.Files;
import java.util.TreeMap;

public class ReadWrite {
    public static String[] readInput() throws IOException {
        File input = new File("input.txt");
        return new String(Files.readAllBytes(input.toPath())).split("\n");
    }

    public static void writeResult(String order) throws IOException {
        File output = new File("output.txt");
        OutputStream os = new FileOutputStream(output, true);
        os.write((order.getBytes()));
        os.close();
    }
}