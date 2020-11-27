package com.investInside;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        long time = System.nanoTime();

        ReadWrite readWrite = new ReadWrite();
        Solve solve = new Solve(new UpdateBooks(), readWrite, new Query(), new MarketOder());


        solve.solving(readWrite.readInput());

        time = System.nanoTime() - time;
        System.out.printf("Elapsed %,9.3f ms\n", time/1_000_000.0);
    }

}

