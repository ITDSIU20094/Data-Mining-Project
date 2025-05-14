package Processing;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import java.util.Random;
import weka.core.converters.ArffSaver;
import java.io.File;

public class Split_TrainTest {
    public static void splitData(String inputPath, String trainPath, String testPath, double trainPercent)
            throws Exception {
        // Load dataset
        DataSource source = new DataSource(inputPath);
        Instances dataset = source.getDataSet();
        dataset.setClassIndex(dataset.numAttributes() - 1);

        // Randomize dataset
        Random rand = new Random(1);
        dataset.randomize(rand);

        // Split dataset
        int trainSize = (int) Math.round(dataset.numInstances() * trainPercent);
        int testSize = dataset.numInstances() - trainSize;
        Instances trainDataset = new Instances(dataset, 0, trainSize);
        Instances testDataset = new Instances(dataset, trainSize, testSize);

        // Save training dataset
        ArffSaver saver = new ArffSaver();
        saver.setInstances(trainDataset);
        saver.setFile(new File(trainPath));
        saver.writeBatch();

        // Save testing dataset
        saver.setInstances(testDataset);
        saver.setFile(new File(testPath));
        saver.writeBatch();

        System.out.println("Dataset split complete:");
        System.out.println("Training dataset size: " + trainDataset.numInstances());
        System.out.println("Testing dataset size: " + testDataset.numInstances());
    }
}