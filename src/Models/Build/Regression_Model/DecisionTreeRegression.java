package Models.Build.Regression_Model;

import weka.classifiers.trees.M5P;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.Evaluation;
import Models.Build.OutputFormat;

public class DecisionTreeRegression extends M5P {
    public static void buildDecisionTree(String trainPath, String testPath) throws Exception {
        // Load train data
        DataSource source = new DataSource(trainPath);
        Instances trainData = source.getDataSet();
        trainData.setClassIndex(trainData.attribute("units_sold").index());

        // Load test data
        DataSource testSource = new DataSource(testPath);
        Instances testData = testSource.getDataSet();
        testData.setClassIndex(testData.attribute("units_sold").index());

        // Build and evaluate classifier
        DecisionTreeRegression dtReg = new DecisionTreeRegression();
        long startTime = System.currentTimeMillis();
        dtReg.buildClassifier(trainData);

        // Save model
        String modelPath = "C://DATA MINING//Project//src//Models//Saved Models//Regression//decision_tree_regression_model.model";
        weka.core.SerializationHelper.write(modelPath, dtReg);

        // Evaluate model
        Evaluation eval = new Evaluation(trainData);
        eval.crossValidateModel(dtReg, testData, 10, new java.util.Random(1)); // 10-fold cross-validation
        long endTime = System.currentTimeMillis();

        // Print results
        OutputFormat.printResults("Decision Tree Regression", eval, endTime - startTime);
    }

}
