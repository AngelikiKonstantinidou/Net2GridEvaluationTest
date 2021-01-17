# Net2GridEvaluationTest

## Table of contents
* [Description](#description)
* [Technologies](#technologies)
* [Setup](#setup)

## Description
Net2GridEvaluationTest is a demo maven repository created as an assessement project.

The project contains the following classes along with the corresponding test classes:

- **StatisticUtilsArray.java**, which provides a set of statistical values for an array of double values.
  1. The statistical metrics implemented are the following: minimum, maximum, median, mean and standard deviation.
  2. All metrics were implemented using the [commons-math3](http://commons.apache.org/proper/commons-math/javadocs/api-3.6.1/index.html) library
- **StatisticUtilsArrayList.java**, which provides the aforementioned statistical values for an array list of double values.
- **AscendingMinima.java**, which implements the *Ascending Minima* algorithm for an array of doubles and a sliding window of size 'k'
- **StatisticUtilsArrayListGenerics.java**, which provides the required values for an array list for all numerical types
- **StatisticUtilsArrayStreams.java**, which provides the statical values for an array of doubles using *Java Streams* for its implementation.

## Technologies

The following technologies were employed for this project:
- Programming Language: Java, Version: 15
- Maven, Version 3.6.3
- Testing Tool: JUnit, Version: 5

## Environment

The following tools were used for development:
- Integrated Development Environment: JetBrains IntelliJ, Version: 2020.3
- Git Framework: GitKraken, Version: 7.4.1
