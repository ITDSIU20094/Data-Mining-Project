import weka.core.Instances;
import weka.core.Instance;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.Classifier;

public class Test_Model {
    public static void main(String[] args) throws Exception {
        // Load dữ liệu từ file ARFF (có thể là train hoặc test file)
        DataSource source = new DataSource(
                "C://DATA MINING//Project//data//TrainTest_Dataset//Test_dataset.arff");
        Instances data = source.getDataSet();

        // Đặt chỉ số cột class (ví dụ cột cuối cùng)
        if (data.classIndex() == -1)
            data.setClassIndex(data.numAttributes() - 1);

        // Load classifier đã train sẵn (hoặc train trực tiếp ở đây)
        // Ví dụ: load từ file serialized
        Classifier classifier = (Classifier) weka.core.SerializationHelper
                .read("C://DATA MINING//Project//src//Models//Saved Models//naiveBayes_model.model");

        // Chọn instance mà bạn muốn dự đoán (ví dụ instance thứ 0)
        Instance inst = data.instance(data.numInstances() - 12);

        // Dự đoán class index
        double predIndex = classifier.classifyInstance(inst);

        // Lấy tên class dự đoán
        String predClassLabel = data.classAttribute().value((int) predIndex);

        // In ra kết quả
        System.out.println("Predict Class Index: " + (int) predIndex);
        System.out.println("Label class prediction: " + predClassLabel);

        // Nếu muốn đối chiếu với nhãn thực tế của instance
        String realClassLabel = inst.stringValue(data.classIndex());
        System.out.println("Actual label: " + realClassLabel);

        // So sánh 2 nhãn này để kiểm tra mô hình
        if (predClassLabel.equals(realClassLabel)) {
            System.out.println("Predict accurate!");
        } else {
            System.out.println("Wrong prediction!");
        }
    }
}
