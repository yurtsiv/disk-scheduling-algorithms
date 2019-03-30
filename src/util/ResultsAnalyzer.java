package util;

import java.util.ArrayList;

public class ResultsAnalyzer {
    public static void analyzeAndPrint(ArrayList<Integer> headPath) {
       for (int position : headPath) {
           System.out.print(position + " | ");
       }

       System.out.println();
    }
}
