import Models.Build.Classification_Model.*;
import Models.Build.Regression_Model.DecisionTreeRegression;
import Models.Build.Regression_Model.LinearRegression_model;
import Models.Build.Regression_Model.SupportVectorRegression;
import Processing.*;
import weka.core.pmml.jaxbbindings.Decision;
import weka.core.pmml.jaxbbindings.SupportVector;

public class Main {
    public static void main(String[] args) throws Exception {
        // Set Weka properties
        WekaUtil.setWekaProperties();

        try {
            // Define paths
            String csvPath = "C://DATA MINING//Project//data//Data Project//cleaned_summer_products.csv";
            String arffPath = "C://DATA MINING//Project//data//Data Project//cleaned_summer_products.arff";
            String selectedArffPath = "C://DATA MINING//Project//data//Data Project//attribute.arff";
            String filterPath = "C://DATA MINING//Project//data//Data Project//attribute_filter.arff";
            String wrapperPath = "C://DATA MINING//Project//data//Data Project//attribute_wrapper.arff";
            String trainPath = "C://DATA MINING//Project//data//TrainTest_Dataset//Train_dataset.arff";
            String testPath = "C://DATA MINING//Project//data//TrainTest_Dataset//Test_dataset.arff";

            // Convert CSV to ARFF
            DataConverter.CSVtoArff(csvPath, arffPath);

            // Perform attribute selection
            AttrSelection.performAttrSelection(arffPath, selectedArffPath);

            // Split data (80% train, 20% test)
            // Split_TrainTest.splitData(filterPath, trainPath, testPath, 0.8);
            Split_TrainTest.splitData(wrapperPath, trainPath, testPath, 0.8);

            // Run classifiers
            NaiveBayes_Classifier.buildNaiveBayes(trainPath, testPath);
            RandomTree_Classifier.buildRandomTree(trainPath, testPath);
            J48_Classifier.PrunedJ48(trainPath, testPath);
            J48_Classifier.UnprunedJ48(trainPath, testPath);
            SMO_Classifier.buildSMO(trainPath, testPath);
            IBK_Classifier.buildIBK(trainPath, testPath);
            ZeroR_Classifier.buildZeroR(trainPath, testPath);
            OneR_Classifier.buildOneR(trainPath, testPath);

            // Run regression model
            LinearRegression_model.buildLinearRegression(trainPath, testPath);
            DecisionTreeRegression.buildDecisionTree(trainPath, testPath);
            SupportVectorRegression.buildSMOreg(trainPath, testPath);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
