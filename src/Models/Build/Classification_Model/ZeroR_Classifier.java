package Models.Build.Classification_Model;

import weka.classifiers.Evaluation;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.rules.ZeroR;
import Models.Build.OutputFormat;

public class ZeroR_Classifier {
    public static void buildZeroR(String trainPath, String testPath) throws Exception {
        // Load train data
        DataSource source = new DataSource(trainPath);
        Instances trainData = source.getDataSet();
        trainData.setClassIndex(trainData.numAttributes() - 1);

        // Load test data
        DataSource testSource = new DataSource(testPath);
        Instances testData = testSource.getDataSet();
        testData.setClassIndex(testData.numAttributes() - 1);

        // Build and evaluate classifier
        ZeroR zeroR = new ZeroR();
        long startTime = System.currentTimeMillis();
        zeroR.buildClassifier(trainData);

        // Save model
        String modelPath = "C://DATA MINING//Project//src//Models//Saved Models//Classification//zeroR_model.model";
        weka.core.SerializationHelper.write(modelPath, zeroR);

        // Evaluate model
        Evaluation eval = new Evaluation(trainData);
        eval.crossValidateModel(zeroR, testData, 10, new java.util.Random(1)); // 10-fold cross-validation
        long endTime = System.currentTimeMillis();

        // Print results
        OutputFormat.printResults("ZeroR", eval, endTime - startTime);
    }
}
