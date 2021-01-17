import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * StatisticUtilsArrayStreams provides a set of statistical values for an array of double values using Java Streams for
 * the estimation of the statistical metrics. More specifically, the supported statistical metrics are the following:
 * <p>
 * a. Minimum Value
 * b. Maximum Value
 * c. Median Value
 * d. Mean Value
 * e. Standard Deviation
 * <p>
 *
 * @author Angeliki Konstantinidou
 */
public class StatisticUtilsArrayStreams {

    /**
     * array of double used as input
     */
    private double[] array;

    /**
     * Default Constructor
     */
    public StatisticUtilsArrayStreams() {
    }

    /**
     * Constructor specifying array of double.
     *
     * @param values Array of doubles
     */
    public StatisticUtilsArrayStreams(double[] values) {
        this.array = values;
    }

    /**
     * Sets the array of values
     *
     * @param values The array of doubles
     */
    public void setArray(double[] values) {
        this.array = values;
    }

    /**
     * Gets the array of values
     *
     * @return Array of doubles
     */
    public double[] getArray() {
        return this.array;
    }

    /**
     * Returns the minimum of the entries in the input array, or Double.NaN if the array is empty.
     *
     * @return double The minimum value of an array
     */
    public double minimumValue() {
        return ArrayUtils.isNotEmpty(this.array) ? Arrays.stream(this.array).min().getAsDouble() : Double.NaN;
    }

    /**
     * Returns the maximum of the entries in the input array, or Double.NaN if the array is empty.
     *
     * @return double The maximum value of an array
     */
    public double maximumValue() {
        return ArrayUtils.isNotEmpty(this.array) ? Arrays.stream(this.array).max().getAsDouble() : Double.NaN;
    }

    /**
     * Returns the median of the entries in the input array, or Double.NaN if the array is empty.
     *
     * @return double The median value of an array
     */
    public double medianValue() {
        return ArrayUtils.isNotEmpty(this.array) ? this.array.length % 2 == 0 ?
                Arrays.stream(this.array).sorted().skip((this.array.length / 2) - 1).limit(2).average().getAsDouble() :
                Arrays.stream(this.array).sorted().skip(this.array.length / 2).findFirst().getAsDouble() : Double.NaN;
    }

    /**
     * Returns the mean of the entries in the input array, or Double.NaN if the array is empty.
     *
     * @return double The mean value of an array
     */
    public double meanValue() {
        return ArrayUtils.isNotEmpty(this.array) ? Arrays.stream(this.array).average().getAsDouble() : Double.NaN;
    }

    /**
     * Returns the mean of the entries in the input array, or Double.NaN if the array is empty.
     *
     * @return double The standard deviation of an array
     */
    public double standardDeviationValue() {
        return ArrayUtils.isNotEmpty(this.array) ? Math.sqrt(Arrays.stream(this.array)
                .map(i -> i - this.meanValue())
                .map(i -> i * i)
                .average().getAsDouble()) : Double.NaN;
    }

}
