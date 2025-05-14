package Processing;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import java.io.File;

public class DataConverter {
    public static void CSVtoArff(String csvPath, String arffPath) throws Exception {
        // Load CSV
        CSVLoader loader = new CSVLoader();
        loader.setSource(new File(csvPath));
        Instances data = loader.getDataSet();

        // save ARFF
        ArffSaver saver = new ArffSaver();
        saver.setInstances(data);
        saver.setFile(new File(arffPath));
        saver.writeBatch();

        // Print summary
        System.out.println("Conversion completed. Dataset summary:");
        System.out.println(data.toSummaryString());
    }
}