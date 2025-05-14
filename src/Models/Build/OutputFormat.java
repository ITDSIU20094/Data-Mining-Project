package Models.Build;

import weka.classifiers.Evaluation;

public class OutputFormat {
    /**
     * Prints the results of the classifier evaluation.
     *
     * @param classifierName The name of the classifier.
     * @param eval           The Evaluation object containing the results.
     * @param runtime        The runtime of the classifier in milliseconds.
     */
    public static void printResults(String classifierName, Evaluation eval, long runtime) {
        System.out.println("\n" + classifierName + " Results:");
        System.out.println("Accuracy: " + String.format("%.4f", eval.pctCorrect()) + "%");
        System.out.println("Precision: " + String.format("%.4f", eval.weightedPrecision()));
        System.out.println("Recall: " + String.format("%.4f", eval.weightedRecall()));
        System.out.println("Runtime: " + runtime + " ms");
    }
}