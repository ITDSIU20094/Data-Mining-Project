package Models.Build.Classification_Model;

import weka.classifiers.Evaluation;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.rules.OneR;
import Models.Build.OutputFormat;

public class OneR_Classifier {
    public static void buildOneR(String trainPath, String testPath) throws Exception {
        // Load train data
        DataSource source = new DataSource(trainPath);
        Instances trainData = source.getDataSet();
        trainData.setClassIndex(trainData.numAttributes() - 1);

        // Load test data
        DataSource testSource = new DataSource(testPath);
        Instances testData = testSource.getDataSet();
        testData.setClassIndex(testData.numAttributes() - 1);

        // Build and evaluate classifier
        OneR oneR = new OneR();
        long startTime = System.currentTimeMillis();
        oneR.buildClassifier(trainData);

        // Save model
        String modelPath = "C://DATA MINING//Project//src//Models//Saved Models//Classification//oneR_model.model";
        weka.core.SerializationHelper.write(modelPath, oneR);

        // Evaluate model
        Evaluation eval = new Evaluation(trainData);
        eval.crossValidateModel(oneR, testData, 10, new java.util.Random(1)); // 10-fold cross-validation
        long endTime = System.currentTimeMillis();

        // Print results
        OutputFormat.printResults("OneR", eval, endTime - startTime);
    }
}
