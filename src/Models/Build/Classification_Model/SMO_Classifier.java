package Models.Build.Classification_Model;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.SMO;
import Models.Build.OutputFormat;

public class SMO_Classifier {
    public static void buildSMO(String trainPath, String testPath) throws Exception {
        // Load train data
        DataSource source = new DataSource(trainPath);
        Instances trainData = source.getDataSet();
        trainData.setClassIndex(trainData.numAttributes() - 1);

        // Load test data
        DataSource testSource = new DataSource(testPath);
        Instances testData = testSource.getDataSet();
        testData.setClassIndex(testData.numAttributes() - 1);

        // Build and evaluate classifier
        SMO smo = new SMO();
        long startTime = System.currentTimeMillis();
        smo.buildClassifier(trainData);

        // save model
        String modelPath = "C://DATA MINING//Project//src//Models//Saved Models//Classification//smo_model.model";
        weka.core.SerializationHelper.write(modelPath, smo);

        // Evaluate model
        Evaluation eval = new Evaluation(trainData);
        eval.crossValidateModel(smo, testData, 10, new java.util.Random(1)); // 10-fold cross-validation
        long endTime = System.currentTimeMillis();

        // Print results
        OutputFormat.printResults("SMO", eval, endTime - startTime);
    }

}
