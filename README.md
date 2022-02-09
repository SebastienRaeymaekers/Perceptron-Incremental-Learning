# Perceptron-Incremental-Learning

<!-- PROJECT LOGO -->
<br />
<p align="center">
  <h3 align="center">Perceptron incremental learning algorithm</h3>

  <p align="center">
    Given an example and a corresponding class value, train a perceptron incrementally with the delta rule and stochastic gradient descent which can handle both binary and continuous features.
    <br />
    <br />
  </p>
</p>


<!-- ABOUT THE PROJECT -->
## About The Project

A Perceptron class which can be used to create a binary classifier that linearly separates one class from the other using the examples to learn weigths.

### Built With
* [Java](https://www.java.com/)
* [Java.io](https://https://docs.oracle.com/javase/7/docs/api/java/io/package-summary.html)


<!-- GETTING STARTED -->
## Getting Started

The Perceptron class can be instantiated to make a new perceptron entity on which:
* update can be called to update its weigth given an example and class value.
* makePrediction can be called to predict the class value of a given example using the current weights.
* write can be called to write the model into a text file.
* read can be called to read a written model from a text file.

<!-- LICENSE -->
## License

Distributed under the MIT License.
