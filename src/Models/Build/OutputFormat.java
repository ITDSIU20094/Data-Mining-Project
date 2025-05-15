package Models.Build;

import weka.classifiers.Evaluation;

public class OutputFormat {
    public static void printResults(String classifierName, Evaluation eval, long executionTime) {
        System.out.println("\n" + classifierName + " Results:");

        try {
            if (eval.getHeader().classAttribute().isNumeric()) {
                // Regression metrics
                System.out.printf("Correlation coefficient: %.4f\n", eval.correlationCoefficient());
                System.out.printf("Mean absolute error: %.4f\n", eval.meanAbsoluteError());
                System.out.printf("Root mean squared error: %.4f\n", eval.rootMeanSquaredError());
                System.out.printf("Relative absolute error: %.4f\n", eval.relativeAbsoluteError());
                System.out.printf("Root relative squared error: %.4f\n", eval.rootRelativeSquaredError());
            } else {
                // Classification metrics
                System.out.printf("Accuracy: %.2f%%\n", eval.pctCorrect());
                System.out.printf("Precision: %.4f\n", eval.weightedPrecision());
                System.out.printf("Recall: %.4f\n", eval.weightedRecall());
                System.out.printf("F1 Score: %.4f\n", eval.weightedFMeasure());
            }

            System.out.printf("Runtime: %d ms\n", executionTime);
        } catch (Exception e) {
            System.out.println("Error calculating metrics: " + e.getMessage());
            e.printStackTrace();
        }
    }
}