package Models.Build.Regression_Model;

import Models.Build.OutputFormat;
import weka.classifiers.Evaluation;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.functions.LinearRegression;
// import Models.Build.OutputFormat;

public class LinearRegression_model extends LinearRegression {
    public static void buildLinearRegression(String trainPath, String testPath) throws Exception {
        // Load train data
        DataSource source = new DataSource(trainPath);
        Instances trainData = source.getDataSet();
        trainData.setClassIndex(trainData.attribute("units_sold").index());

        // Load test data
        DataSource testSource = new DataSource(testPath);
        Instances testData = testSource.getDataSet();
        testData.setClassIndex(testData.attribute("units_sold").index());

        // Build and evaluate classifier
        LinearRegression_model lr = new LinearRegression_model();
        long startTime = System.currentTimeMillis();
        lr.buildClassifier(trainData);

        // Save model
        String modelPath = "C://DATA MINING//Project//src//Models//Saved Models//Regression//linear_regression_model.model";
        weka.core.SerializationHelper.write(modelPath, lr);

        // Evaluate model
        Evaluation eval = new Evaluation(trainData);
        eval.crossValidateModel(lr, testData, 10, new java.util.Random(1)); // 10-fold cross-validation
        long endTime = System.currentTimeMillis();

        // Print results
        OutputFormat.printResults("Linear Regression", eval, endTime - startTime);
    }
}
