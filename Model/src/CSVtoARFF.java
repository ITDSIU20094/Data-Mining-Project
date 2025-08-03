import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import java.io.File;

public class CSVtoARFF {
    public static void main(String[] args) throws Exception {
        // load CSV
        CSVLoader loader = new CSVLoader();
        loader.setSource(
                new File("/home/quan/PROJECT/Data-Mining-Project/Model/data/cleaned_summer_products.csv"));
        Instances data = loader.getDataSet();

        // save ARFF
        ArffSaver saver = new ArffSaver();
        saver.setInstances(data);

        for (int i = 0; i < Math.min(5, data.numInstances()); i++) {
            System.out.println("Instance " + i + ": " + data.instance(i));
        }

        saver.setFile(
                new File("/home/quan/PROJECT/Data-Mining-Project/Model/data/cleaned_summer_products.arff"));
        saver.writeBatch();

    }
}
