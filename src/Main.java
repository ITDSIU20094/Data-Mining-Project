import Models.Build.NaiveBayes_Classifier;
import Models.Build.RandomTree_Classifier;
import Models.Build.SMO_Classifier;
import Processing.*;

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

            // Run classifiers with specified class index
            NaiveBayes_Classifier.buildNaiveBayes(trainPath, testPath);
            RandomTree_Classifier.buildRandomTree(trainPath, testPath);
            SMO_Classifier.buildSMO(trainPath, testPath);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
