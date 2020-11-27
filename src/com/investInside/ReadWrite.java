package com.investInside;

import java.io.*;
import java.nio.file.Files;

public class ReadWrite {
    public static String[] readInput() throws IOException {
        File input = new File("input.txt");
        String[] inputsList = new String(Files.readAllBytes(input.toPath())).split("\n");
        return inputsList;
    }

    public static void writeZeroResult() {
        File output = new File("output.txt");
        try {
        OutputStream os = new FileOutputStream(output, true);
        os.write(("0\n").getBytes());
        os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeOutput(String order) {
        File output = new File("output.txt");
        try {
            OutputStream os = new FileOutputStream(output, true);
            os.write((order.getBytes()));
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}