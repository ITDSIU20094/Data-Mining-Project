import weka.core.Instances;
import weka.core.Instance;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.Classifier;

public class Classification_Test {
    public static void main(String[] args) throws Exception {
        // Load test dataset
        DataSource source = new DataSource(
                "C://DATA MINING//Project//data//TrainTest_Dataset//Test_dataset.arff");
        Instances data = source.getDataSet();

        // Set class index to the last attribute
        if (data.classIndex() == -1)
            data.setClassIndex(data.numAttributes() - 1);

        // Load the saved model
        Classifier classifier = (Classifier) weka.core.SerializationHelper
                .read("C://DATA MINING//Project//src//Models//Saved Models//Classification//oneR_model.model");

        // Classify the last instance in the dataset
        Instance inst = data.instance(data.numInstances() - 1);

        // Predict class index
        double predIndex = classifier.classifyInstance(inst);

        // Take the name of the predicted class
        String predClassLabel = data.classAttribute().value((int) predIndex);

        // Print the results
        System.out.println("Predict Class Index: " + (int) predIndex);
        System.out.println("Label class prediction: " + predClassLabel);

        // Compare with the actual label of instance
        String realClassLabel = inst.stringValue(data.classIndex());
        System.out.println("Actual label: " + realClassLabel);

        // Compare these 2 labels to check the model
        if (predClassLabel.equals(realClassLabel)) {
            System.out.println("Predict accurate!");
        } else {
            System.out.println("Wrong prediction!");
        }
    }
}
