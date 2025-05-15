package Models.Build.Classification_Model;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import Models.Build.OutputFormat;

public class NaiveBayes_Classifier {
    public static void buildNaiveBayes(String trainPath, String testPath) throws Exception {
        // Load train data
        DataSource source = new DataSource(trainPath);
        Instances trainData = source.getDataSet();
        trainData.setClassIndex(trainData.numAttributes() - 1);

        // Load test data
        DataSource testSource = new DataSource(testPath);
        Instances testData = testSource.getDataSet();
        testData.setClassIndex(testData.numAttributes() - 1);

        // Build and evaluate classifier
        NaiveBayes nb = new NaiveBayes();
        long startTime = System.currentTimeMillis();

        // Train model
        nb.buildClassifier(trainData);

        // Save model
        String modelPath = "C://DATA MINING//Project//src//Models//Saved Models//Classification//naiveBayes_model.model";
        weka.core.SerializationHelper.write(modelPath, nb);

        // Evaluate model
        Evaluation eval = new Evaluation(trainData);
        eval.crossValidateModel(nb, testData, 10, new java.util.Random(1)); // 10-fold cross-validation
        long endTime = System.currentTimeMillis();

        // Print results format
        OutputFormat.printResults("Naive Bayes", eval, endTime - startTime);
    }
}
