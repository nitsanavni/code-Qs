package com.papaya;

import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.papaya.PapayaExercise.LOC_INPUT;
import static com.papaya.PapayaExercise.LOC_OUTPUT;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PapayaExerciseQ1Test {

    // no need to change this
    private void shouldAllCasesInput(String question, Boolean smallInput) throws IOException {
        String smallOrLarge = smallInput ? "Small" : "Large";
        try (BufferedReader bf = new BufferedReader(new FileReader(LOC_INPUT + question + "/" +  smallOrLarge + ".in"));
             BufferedWriter bw = new BufferedWriter(new FileWriter(LOC_OUTPUT + question + "/" +  smallOrLarge + ".out"));
             BufferedReader bfTestSolution = new BufferedReader(new FileReader(LOC_OUTPUT + question + "/" + smallOrLarge + "Result" + ".out"))) {

            int numberOfCases = Integer.valueOf(bf.readLine());

            for (int caseNum = 1; caseNum <= numberOfCases; caseNum++) {
                String result = PapayaExercise.solve(bf.readLine());

                String writeResult = "Case #" + (caseNum) + ": " + result + "\n";
                bw.write(writeResult);

                String solutionLine = bfTestSolution.readLine();

                assertThat(writeResult.trim(), is(solutionLine.trim()));
            }
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        } finally {
            Files.deleteIfExists(Paths.get(LOC_OUTPUT + question + "/" + smallOrLarge + ".out"));
        }
    }

    @Test
    public void checkSmallInputQ1() throws IOException {
        shouldAllCasesInput("Q1", true);
    }

    @Test
    public void checkLInputQ1() throws IOException {
        shouldAllCasesInput("Q1", false);
    }

    @Test
    public void shouldSpecificCase() {
        assertThat(PapayaExercise.solve("165"), is("2475"));
    }
}