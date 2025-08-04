import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.Evaluation;
import weka.core.Instances;
import java.io.BufferedReader;

public class NB {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(
                new java.io.FileReader(
                        "/home/quan/PROJECT/Data-Mining-Project/Model/data/cleaned_summer_products.arff"));
        Instances train_data = new Instances(reader);
        train_data.setClassIndex(train_data.numAttributes() - 1);

        NaiveBayes nb = new NaiveBayes();

        long startTime = System.currentTimeMillis();
        nb.buildClassifier(train_data);
        Evaluation eval = new Evaluation(train_data);
        eval.crossValidateModel(nb, train_data, 10, new java.util.Random(1));
        long endTime = System.currentTimeMillis();
        double runtime = (endTime - startTime) / 1000.0;

        System.out.println("=== NaiveBayes Classifier ===");
        System.out.println("Accuracy  = " + String.format("%.4f", eval.pctCorrect() / 100));
        System.out.println("Precision = " + String.format("%.4f", eval.precision(1)));
        System.out.println("Recall    = " + String.format("%.4f", eval.recall(1)));
        System.out.println("F1-Score  = " + String.format("%.4f", eval.fMeasure(1)));
        System.out.println("Runtime   = " + String.format("%.2f", runtime) + " seconds");
    }

}
