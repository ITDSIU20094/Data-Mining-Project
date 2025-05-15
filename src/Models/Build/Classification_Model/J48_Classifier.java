package Models.Build.Classification_Model;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import Models.Build.OutputFormat;

public class J48_Classifier {
    public static void PrunedJ48(String trainPath, String testPath) throws Exception {
        // Load train data
        DataSource source = new DataSource(trainPath);
        Instances trainData = source.getDataSet();
        trainData.setClassIndex(trainData.numAttributes() - 1);

        // Load test data
        DataSource testSource = new DataSource(testPath);
        Instances testData = testSource.getDataSet();
        testData.setClassIndex(testData.numAttributes() - 1);

        // Build and evaluate classifier
        J48 j48 = new J48();

        // Set pruning options
        String[] options = new String[2];
        options[0] = "-C"; // confidence factor
        options[1] = "0.25"; // default confidence factor
        j48.setOptions(options);

        long startTime = System.currentTimeMillis();
        j48.buildClassifier(trainData);

        // Save model
        String modelPath = "C://DATA MINING//Project//src//Models//Saved Models//Classification//j48_pruned_model.model";
        weka.core.SerializationHelper.write(modelPath, j48);

        // Evaluate model
        Evaluation eval = new Evaluation(trainData);
        eval.crossValidateModel(j48, testData, 10, new java.util.Random(1));
        long endTime = System.currentTimeMillis();

        // Print results
        OutputFormat.printResults("J48 (Pruned)", eval, endTime - startTime);
    }

    public static void UnprunedJ48(String trainPath, String testPath) throws Exception {
        // Load train data
        DataSource source = new DataSource(trainPath);
        Instances trainData = source.getDataSet();
        trainData.setClassIndex(trainData.numAttributes() - 1);

        // Load test data
        DataSource testSource = new DataSource(testPath);
        Instances testData = testSource.getDataSet();
        testData.setClassIndex(testData.numAttributes() - 1);

        // Build and evaluate classifier
        J48 j48 = new J48();

        // Set unpruning options
        String[] options = new String[1];
        options[0] = "-U"; // unpruned tree
        j48.setOptions(options);

        long startTime = System.currentTimeMillis();
        j48.buildClassifier(trainData);

        // Save model
        String modelPath = "C://DATA MINING//Project//src//Models//Saved Models//Classification//j48_unpruned_model.model";
        weka.core.SerializationHelper.write(modelPath, j48);

        // Evaluate model
        Evaluation eval = new Evaluation(trainData);
        eval.crossValidateModel(j48, testData, 10, new java.util.Random(1));
        long endTime = System.currentTimeMillis();

        // Print results
        OutputFormat.printResults("J48 (Unpruned)", eval, endTime - startTime);
    }
}
