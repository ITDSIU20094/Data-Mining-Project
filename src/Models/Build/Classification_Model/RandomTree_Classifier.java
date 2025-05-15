package Models.Build.Classification_Model;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.RandomTree;
import Models.Build.OutputFormat;

public class RandomTree_Classifier {
    public static void buildRandomTree(String trainPath, String testPath) throws Exception {
        // Load train data
        DataSource source = new DataSource(trainPath);
        Instances trainData = source.getDataSet();
        trainData.setClassIndex(trainData.numAttributes() - 1);

        // Load test data
        DataSource testSource = new DataSource(testPath);
        Instances testData = testSource.getDataSet();
        testData.setClassIndex(testData.numAttributes() - 1);

        // Build and evaluate classifier
        RandomTree rt = new RandomTree();
        long startTime = System.currentTimeMillis();
        rt.buildClassifier(trainData);

        // save model
        String modelPath = "C://DATA MINING//Project//src//Models//Saved Models//Classification//randomTree_model.model";
        weka.core.SerializationHelper.write(modelPath, rt);

        // evaluate model
        Evaluation eval = new Evaluation(trainData);
        eval.crossValidateModel(rt, testData, 10, new java.util.Random(1)); // 10-fold cross-validation
        long endTime = System.currentTimeMillis();

        // Print results
        OutputFormat.printResults("RandomTree", eval, endTime - startTime);
    }
}
