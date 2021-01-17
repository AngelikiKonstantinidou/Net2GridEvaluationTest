import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.util.FastMath;

/**
 * StatisticUtilsArray provides a set of statistical values for an array of double values.
 * More specifically, the statistical metrics that StatisticUtilsArray implements are the following:
 * <p>
 * a. Minimum Value
 * b. Maximum Value
 * c. Median Value
 * d. Mean Value
 * e. Standard Deviation
 * <p>
 * The library that is used to estimate the aforementioned metrics is the commons-math3 3.6.1. The corresponding documentation
 * can be found at the following link:
 * http://commons.apache.org/proper/commons-math/javadocs/api-3.6.1/index.html
 *
 * @author Angeliki Konstantinidou
 */
public class StatisticUtilsArray {

    /**
     * array of doubles used as input
     */
    private double[] values;

    /**
     * Class default constructor
     *
     */
    public StatisticUtilsArray() {}

    /**
     * Class constructor specifying array of doubles.
     *
     * @param values Array of doubles
     */
    public StatisticUtilsArray(double[] values) {
        this.values = values;
    }

    /**
     * Sets the array of values
     * @param values The array of doubles
     */
    public void setArray(double[] values){
        this.values = values;
    }

    /**
     * Gets the array of values
     * @return Array of doubles
     */
    public double[] getArray(){
        return this.values;
    }

    /**
     * Returns the minimum of the entries in the input array, or Double.NaN if the array is empty.
     *
     * @return double The minimum value of an array of doubles
     */
    public double minimumValue() {
        return StatUtils.min(this.values);
    }

    /**
     * Returns the maximum of the entries in the input array, or Double.NaN if the array is empty.
     *
     * @return double The maximum value of an array of doubles
     */
    public double maximumValue() {
        return StatUtils.max(this.values);
    }

    /**
     * Returns an estimate of the 50th percentile of the values in the values array,
     * starting with the element in (0-based) position begin in the array and including length values.
     *
     * @return double The median value of an array of doubles
     */
    public double medianValue() {
        return StatUtils.percentile(this.values, 50);
    }

    /**
     * Returns the arithmetic mean of the entries in the input array, or Double.NaN if the array is empty.
     *
     * @return double The mean of an array of doubles
     */
    public double meanValue() {
        return StatUtils.mean(this.values);
    }

    /**
     * Returns the standard deviation of the entries in the input array by calculating the square root
     * of the populationVariance of the input array entries.
     *
     * @return double The standard deviation of an array of doubles
     */
    public double standardDeviationValue() {
        return FastMath.sqrt(StatUtils.populationVariance(this.values));
    }
}
