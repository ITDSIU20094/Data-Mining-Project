import weka.core.Instances;
import weka.core.Instance;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.Classifier;

public class Regression_Test {
    public static void main(String[] args) throws Exception {
        // Load data from ARFF file (can be train or test file)
        DataSource source = new DataSource(
                "C://DATA MINING//Project//data//TrainTest_Dataset//Test_dataset.arff");
        Instances data = source.getDataSet();

        // Set the class index (e.g., "units_sold" column)
        if (data.classIndex() == -1)
            data.setClassIndex(data.attribute("units_sold").index());

        // Load trained regression model (for example: load from serialized file)
        Classifier regressor = (Classifier) weka.core.SerializationHelper
                .read("C://DATA MINING//Project//src//Models//Saved Models//Regression//decision_tree_regression_model.model");

        // Select instance for prediction
        Instance inst = data.instance(data.numInstances() - 1);

        // Predict numeric value
        double predictedValue = regressor.classifyInstance(inst);

        // Print the result
        System.out.println("Predicted units_sold: " + predictedValue);

        // Compare with the actual value of the instance
        double actualValue = inst.classValue();
        System.out.println("Actual units_sold: " + actualValue);

        // Check the accuracy of the prediction (accepting a small deviation)
        double tolerance = 0.1; // 10% tolerance
        double percentDiff = Math.abs(predictedValue - actualValue) / actualValue;
        if (percentDiff <= tolerance) {
            System.out.println("Predict accurate! (Difference: " + String.format("%.2f%%", percentDiff * 100) + ")");
        } else {
            System.out.println("Wrong prediction! (Difference: " + String.format("%.2f%%", percentDiff * 100) + ")");
        }
    }
}