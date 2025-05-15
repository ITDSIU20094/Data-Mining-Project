package Models.Build.Classification_Model;

import weka.classifiers.Evaluation;
import weka.classifiers.lazy.IBk;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import Models.Build.OutputFormat;

public class IBK_Classifier {
    public static void buildIBK(String trainPath, String testPath) throws Exception {
        // Load train data
        DataSource source = new DataSource(trainPath);
        Instances trainData = source.getDataSet();
        trainData.setClassIndex(trainData.numAttributes() - 1);

        // Load test data
        DataSource testSource = new DataSource(testPath);
        Instances testData = testSource.getDataSet();
        testData.setClassIndex(testData.numAttributes() - 1);

        // Build and evaluate classifier
        IBk ibk = new IBk();
        long startTime = System.currentTimeMillis();
        ibk.buildClassifier(trainData);

        // Save model
        String modelPath = "C://DATA MINING//Project//src//Models//Saved Models//Classification//ibk_model.model";
        weka.core.SerializationHelper.write(modelPath, ibk);

        // Evaluate model
        Evaluation eval = new Evaluation(trainData);
        eval.crossValidateModel(ibk, testData, 10, new java.util.Random(1)); // 10-fold cross-validation
        long endTime = System.currentTimeMillis();

        // Print results
        OutputFormat.printResults("IBK", eval, endTime - startTime);
    }
}
