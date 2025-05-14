package Processing;

import weka.attributeSelection.AttributeSelection;
import weka.attributeSelection.CfsSubsetEval;
import weka.attributeSelection.GreedyStepwise;
import weka.attributeSelection.InfoGainAttributeEval;
import weka.attributeSelection.Ranker;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
// import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;

public class AttrSelection {
    public static void performAttrSelection(String inputPath, String outputPath) throws Exception {
        // Load dataset
        DataSource source = new DataSource(inputPath);
        Instances data = source.getDataSet();
        data.setClassIndex(data.numAttributes() - 1); // Set last attribute as class

        // --- Filter method ---
        AttributeSelection filterSelection = new AttributeSelection();
        InfoGainAttributeEval infoGainEval = new InfoGainAttributeEval();
        Ranker ranker = new Ranker();
        filterSelection.setEvaluator(infoGainEval);
        filterSelection.setSearch(ranker);
        filterSelection.SelectAttributes(data);
        Instances filterData = filterSelection.reduceDimensionality(data);
        printSelectedAttributes("Filter Method", data, filterSelection.selectedAttributes());

        // --- Wrapper method ---
        AttributeSelection wrapperSelection = new AttributeSelection();
        CfsSubsetEval cfsEval = new CfsSubsetEval();
        GreedyStepwise search = new GreedyStepwise();
        search.setSearchBackwards(true);
        wrapperSelection.setEvaluator(cfsEval);
        wrapperSelection.setSearch(search);
        wrapperSelection.SelectAttributes(data);
        Instances wrapperData = wrapperSelection.reduceDimensionality(data);
        printSelectedAttributes("Wrapper Method", data, wrapperSelection.selectedAttributes());

        // Save the selected attributes to a new ARFF file
        saveInstances(filterData, outputPath.replace(".arff", "_filter.arff"));
        saveInstances(wrapperData, outputPath.replace(".arff", "_wrapper.arff"));
    }

    private static void printSelectedAttributes(String methodName, Instances data, int[] selectedAttributes) {
        System.out.println(methodName + " selected attributes:");
        for (int i : selectedAttributes) {
            System.out.println(data.attribute(i).name());
        }
        System.out.println();
    }

    private static void saveInstances(Instances instances, String outputPath) throws Exception {
        ArffSaver saver = new ArffSaver();
        saver.setInstances(instances);
        saver.setFile(new java.io.File(outputPath));
        saver.writeBatch();
    }
}
