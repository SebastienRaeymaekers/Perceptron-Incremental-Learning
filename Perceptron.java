import java.io.*;

public class Perceptron {

    private int nbExamplesProcessed;

    private double learningRate;
    private double[] weights;
    private double bias;

    public Perceptron(int numFeatures, double learningRate) {
        this.nbExamplesProcessed = 0;
        this.learningRate = learningRate;
        // Initialize array for the weights
        this.weights = new double[numFeatures+1];
        for(int i=0; i < numFeatures+1; i++){
            this.weights[i] = 0;
        }
        // Initialize the bias
        this.bias = 1;
    }

    public void update(Double[] example, Double classValue) {
        //Update the parameters given the new data to improve J(weights)
        double predicted = activationFunction(makePrediction(example)); // make prediction and pass through activation function
        double adjustedClassValue = classValue*2-1;
        double error = adjustedClassValue - predicted; // check error (gradient descent rule)
        // update weights and bias
        for (int i = 0; i < this.weights.length-1; i++) {
            this.weights[i] += this.learningRate * error * example[i]; //Delta Rule: delta_weight = this.learningRate * error * example.attributeValues[i]
        }
        this.weights[this.weights.length-1] += this.learningRate * error;
    }

    public double activationFunction(Double value){
        return value > 0 ? 1.0 : -1.0;
    }

    public double makePrediction(Double[] example) {
        double sumOfDot = 0;
        // perform dot product of weights and inputs and sum it to form the dot product.
        for (int i = 0; i < this.weights.length-1; i++) {
            sumOfDot += this.weights[i]*example[i];
        }
        // add bias (which is extra weight with input equal to the bias (=1)).
        sumOfDot += this.weights[this.weights.length-1]*this.bias;
        return sumOfDot;
    }

    public void writeModel(String path) throws IOException {
        // convert perceptron model (i.e. weights) to string
        String perceptionModel = "";
        for (double weight : this.weights) {
            perceptionModel += weight + " ";
        }
        // add number of examples as last number
        perceptionModel += this.nbExamplesProcessed;
        // write perceptron model to file
        try {
            FileWriter myWriter = new FileWriter(path);
            myWriter.write(perceptionModel);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readModel(String path) throws IOException {
        // read perceptron model from file
        try {
            File myObj = new File(path);
            BufferedReader brTest = new BufferedReader(new FileReader(myObj));
            String perceptronModel = brTest.readLine();
            // split string into individual weights and add each of them to this.weights[i] .
            String[] weightsOfModel = perceptronModel.split(" ");
            for (int i = 0; i < weightsOfModel.length-1; i++) {
                this.weights[i] = Double.parseDouble(weightsOfModel[i]);
            }
            // last read number is number of examples processed.
            this.nbExamplesProcessed = Integer.parseInt(weightsOfModel[weightsOfModel.length-1]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
