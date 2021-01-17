# Net2GridEvaluationTest

## Table of contents
* [Description](#description)
* [Technologies](#technologies)
* [Setup](#setup)

## Description
Net2GridEvaluationTest is a maven project created in the context of the interview with Net2Grid. 

The project contains the following classes together with the corresponding test classes:

1. *StatisticUtilsArray.java*, which provides a set of statistical values for an array of double values.
  - The statistical metrics implemented are the following: minimum, maximum, median, mean and standard deviation.
  - All metrices were implementing using the [commons-math3](http://commons.apache.org/proper/commons-math/javadocs/api-3.6.1/index.html) library
2. *StatisticUtilsArrayList.java*, which provides the aforementioned statistical values for an array list of double values.
3. *AscendingMinima.java*, which implements the Ascending Minima algorithm for an array of doubles and a sliding window k
4. *StatisticUtilsArrayListGenerics.java*, which provides the aforementioned statistical values for an array list for all numerical types
5. *StatisticUtilsArrayStreams.java*, which provides the aforementioned statical values for an array of doubles using Java Streams for its implementation.

## Technologies

The technologies used for the implementation of the assignment is the following
- Programming Language: Java, Version: 15
- Maven, Version 3.6.3
- Testing Tool: JUnit, Version: 5

## Setup

The setup for the implementation of the assignment is the following:
1. Integrated Development Environment: JetBrains IntelliJ, Version: 2020.3
2. Git Framework: GitKraken, Version: 7.4.1
