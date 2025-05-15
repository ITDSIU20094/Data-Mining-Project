package Models.Build.Regression_Model;

import weka.classifiers.functions.SMOreg;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.Evaluation;
import Models.Build.OutputFormat;

public class SupportVectorRegression extends SMOreg {
    public static void buildSMOreg(String trainPath, String testPath) throws Exception {
        // Load train data
        DataSource source = new DataSource(trainPath);
        Instances trainData = source.getDataSet();
        trainData.setClassIndex(trainData.attribute("units_sold").index());

        // Load test data
        DataSource testSource = new DataSource(testPath);
        Instances testData = testSource.getDataSet();
        testData.setClassIndex(testData.attribute("units_sold").index());

        // Build and evaluate classifier
        SupportVectorRegression smoReg = new SupportVectorRegression();
        long startTime = System.currentTimeMillis();
        smoReg.buildClassifier(trainData);

        // Save model
        String modelPath = "C://DATA MINING//Project//src//Models//Saved Models//Regression//smo_regression_model.model";
        weka.core.SerializationHelper.write(modelPath, smoReg);

        // Evaluate model
        Evaluation eval = new Evaluation(trainData);
        eval.crossValidateModel(smoReg, testData, 10, new java.util.Random(1)); // 10-fold cross-validation
        long endTime = System.currentTimeMillis();

        // Print results
        OutputFormat.printResults("Support Vector Regression", eval, endTime - startTime);
    }
}
