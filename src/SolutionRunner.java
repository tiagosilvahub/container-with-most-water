package src;

import src.solutions.SmartSinglePass;
import src.solutions.Solution;
import src.solutions.BruteForce;

import java.util.Arrays;

public class SolutionRunner {
    public static void main(String[] args) {
        Solution[] solutions =
                new Solution[]{
                        new BruteForce(),
                        new SmartSinglePass()
                };

        // add test cases
        var input = new int[][]{
                new int[]{
                        1,8,6,2,5,4,8,3,7
                },
                new int[]{
                        20, 1, 30
                },
                new int[]{
                        1, 1, 1, 1, 99
                },
                new int[]{
                        99, 99
                },
        };
        // add test case results
        var output = new int[]{
            49, 40, 4, 99
        };

        // add the type of result here and in src.SolutionStrategy.java
        int result;

        int errors = 0;
        int nTestCases = input.length;
        for (Solution s : solutions) {
            for (int i = 0; i < nTestCases; i++) {
                // put input arguments into solution
                result = s.solve(input[i]);
                // implement equals if needed
                if( output[i] != result) {
                    System.out.println("Solution " + s.getClass().getName() + " wrong for input " + Arrays.toString(input[i]));
                    System.out.println("Expected: " + output[i] + " but got: " + result);
                    System.out.println();
                    errors++;
                }
            }
        }
        printResults(errors, nTestCases);
    }

    private static void printResults(int errors, int nTestCases) {
        if(errors == 0) {
            System.out.println("All tests passed!");
        } else {
            System.out.println(nTestCases - errors + " tests passed.");
        }
        System.out.println(errors + " tests failed.");
        System.out.println((0.0 + nTestCases - errors) / nTestCases * 100  + "% of tests passed.");
    }
}

