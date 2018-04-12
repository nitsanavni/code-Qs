package com.papaya;

import java.io.*;
import java.util.HashSet;

public class PapayaExercise {

    final static String LOC_INPUT = "./files/";
    final static String LOC_OUTPUT = "./files/";

    // args should be ["Q1", "Small" or "Large"]
    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new FileReader(LOC_INPUT + args[0] + "/" + args[1] + ".in"));
             BufferedWriter bw = new BufferedWriter(new FileWriter(LOC_OUTPUT + args[0] + "/" + args[1] + ".out"));) {

            int numberOfCases = Integer.valueOf(bf.readLine());

            for (int caseNum = 1; caseNum <= numberOfCases; caseNum++) {
                String result = solve(bf.readLine());

                bw.write("Case #" + (caseNum) + ": " + result + "\n");

                System.out.println("Case #" + (caseNum) + ": " + result); // for your convenience

            }
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    // we will need to delete it before the interview..
    static String solve(String input) {
        int n = Integer.valueOf(input);
        if (n == 0) {
            return "INSOMNIA";
        }

        HashSet<Integer> seen = new HashSet<>();
        int cur = n;
        while (true) {
            int m = cur;
            while (m > 0) {
                seen.add(m%10);
                m /= 10;
            }
            boolean ok = true;
            for (int i = 0; i <= 9; i++) {
                if (!seen.contains(i)) {
                    ok = false;
                }
            }
            if (ok) break;
            cur += n;
        }

        return "" + cur;
    }
}
