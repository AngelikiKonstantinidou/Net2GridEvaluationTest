import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * StatisticUtilsArrayTest is test class created to {@link StatisticUtilsArray}. The class contains factory methods
 * which generate the arguments of each test and the test methods for the following functionalities:
 * <p>
 * a. Minimum Value
 * b. Maximum Value
 * c. Median Value
 * d. Mean Value
 * e. Standard Deviation
 * </p>
 *
 * @author Angeliki Konstantinidou
 */
public class StatisticUtilsArrayTest {

    /**
     * Generates and returns a stream with possible arguments for testing the implementation of the min functionality
     * of {@link StatisticUtilsArray}. Specifically, each argument is a combination of the input array of doubles
     * and the expected min value. The generated arguments cover the following cases:
     * 1. calculate min value in an array of positive values
     * 2. calculate min value in an array of negative values
     * 3. calculate min value in an array of positive and negative values
     * 4. calculate min in empty array
     *
     * @return Stream A stream of arguments
     */
    private static Stream<Arguments> getMinArguments() {
        return Stream.of(
                Arguments.of(new double[]{1.0, 2.0, 1.1, 4.8, 9.2}, 1.0),
                Arguments.of(new double[]{-1.0, -2.0, -1.1, -4.8, -9.2}, -9.2),
                Arguments.of(new double[]{-1.0, 100.0, 1.1, -4.5, 0.0}, -4.5),
                Arguments.of(new double[]{}, Double.NaN));
    }

    /**
     * Generates and returns a stream with possible arguments for testing the implementation of the max functionality
     * of {@link StatisticUtilsArray}. Specifically, each argument is a combination of the input array of doubles
     * and the expected max value. The generated arguments cover the following cases:
     * 1. calculate max value in an array of positive values
     * 2. calculate max value in an array of negative values
     * 3. calculate max value in an array of positive and negative values
     * 4. calculate max in empty array
     *
     * @return Stream A stream of arguments
     */
    private static Stream<Arguments> getMaxArguments() {
        return Stream.of(
                Arguments.of(new double[]{1.0, 2.0, 1.1, 4.8, 9.2}, 9.2),
                Arguments.of(new double[]{-1.0, -2.0, -1.1, -4.8, -9.2}, -1.0),
                Arguments.of(new double[]{-1.0, 100.0, 1.1, -4.5, 0.0}, 100.0),
                Arguments.of(new double[]{}, Double.NaN));
    }

    /**
     * Generates and returns a stream with possible arguments for testing the implementation of the median functionality
     * of {@link StatisticUtilsArray}. Specifically, each argument is the combination of the input array of doubles
     * and the expected median value. The generated arguments cover the following cases:
     * 1. calculate median value in an array of positive values
     * 2. calculate median value in an array of negative values
     * 3. calculate median value in an array of positive and negative values
     * 4. calculate median value in an array containing odd number of values
     * 5. calculate median value in an array containing even number of values
     * 6. calculate median in empty array
     *
     * @return Stream A stream of arguments
     */
    private static Stream<Arguments> getMedianArguments() {
        return Stream.of(
                Arguments.of(new double[]{1.0, 2.0, 1.1, 4.8, 9.2}, 2.0),
                Arguments.of(new double[]{-1.0, -2.0, -1.1, -4.8, -9.2}, -2.0),
                Arguments.of(new double[]{-1.0, 100.0, 1.1, -4.5, 0.0}, 0.0),
                Arguments.of(new double[]{4.1, 2.5, 6.45, 5.6668, 1.01, 1.02, 6.4}, 4.1),
                Arguments.of(new double[]{4.1, 2.5, 6.45, 5.6668, 1.01, 1.02}, 3.3),
                Arguments.of(new double[]{}, Double.NaN));
    }

    /**
     * Generates and returns a stream with possible arguments for testing the implementation of the mean functionality
     * of {@link StatisticUtilsArray}. Specifically, each argument is the combination of the input array of doubles
     * and the expected mean value. The generated arguments cover the following cases:
     * 1. calculate mean value in an array of positive values
     * 2. calculate mean value in an array of negative values
     * 3. calculate mean value in an array of positive and negative values
     * 4. calculate mean in empty array
     *
     * @return Stream A stream of arguments
     */
    private static Stream<Arguments> getMeanArguments() {
        return Stream.of(
                Arguments.of(new double[]{1.0, 2.0, 1.1, 4.8, 9.2}, 3.62),
                Arguments.of(new double[]{-1.0, -2.0, -1.1, -4.8, -9.2}, -3.62),
                Arguments.of(new double[]{-1.0, 100.0, 1.1, -4.5}, 23.9),
                Arguments.of(new double[]{}, Double.NaN));
    }

    /**
     * Generates and returns a stream with arguments for testing the implementation of the standard deviation
     * functionality of {@link StatisticUtilsArray}. Specifically, each argument is the combination of the input array
     * of doubles and the expected standard deviation. The generated arguments cover the following cases:
     * 1. calculate standard deviation in an array of positive values
     * 2. calculate standard deviation in an array of negative values
     * 3. calculate standard deviation in an array of positive and negative values
     * 4. calculate standard deviation in empty array
     *
     * @return Stream A stream of arguments
     */
    private static Stream<Arguments> getStandardDeviationArguments() {
        return Stream.of(
                Arguments.of(new double[]{1.0, 2.0, 1.1, 4.0, 5.5}, 1.758863269273652),
                Arguments.of(new double[]{-1.0, -2.0, -1.1, -4.8, -9.2}, 3.1102411482070003),
                Arguments.of(new double[]{-1.0, 100.0, 1.1, -4.5, 0.0}, 40.4835472754056),
                Arguments.of(new double[]{}, Double.NaN));
    }

    /**
     * Tests the min implementation by examining different cases of arguments provided by the factory
     * method getMinArguments.
     *
     * @param array         The input array of doubles
     * @param expectedValue The expected min value
     */
    @DisplayName("Executes all the minimum value test cases")
    @ParameterizedTest(name = "{index} => array =''{0}'', expectedValue=''{1}''")
    @MethodSource("getMinArguments")
    public void testMinimumValue(double[] array, double expectedValue) {
        StatisticUtilsArray stats = new StatisticUtilsArray(array);
        assertEquals(expectedValue, stats.minimumValue());
    }

    /**
     * Tests the max implementation by examining different cases of arguments provided by the factory
     * method getMaxArguments.
     *
     * @param array         The input array of doubles
     * @param expectedValue The expected max value
     */
    @DisplayName("Executes all the maximum value test cases")
    @ParameterizedTest(name = "{index} => array =''{0}'', expectedValue=''{1}''")
    @MethodSource("getMaxArguments")
    public void testMaximumValue(double[] array, double expectedValue) {
        StatisticUtilsArray stats = new StatisticUtilsArray(array);
        assertEquals(expectedValue, stats.maximumValue());
    }

    /**
     * Tests the median implementation by examining different cases of arguments provided by the factory
     * method getMedianArguments.
     *
     * @param array         The input array of doubles
     * @param expectedValue The expected median value
     */
    @DisplayName("Executes all the median value test cases")
    @ParameterizedTest(name = "{index} => array =''{0}'', expectedValue=''{1}''")
    @MethodSource("getMedianArguments")
    public void testMedianValue(double[] array, double expectedValue) {
        StatisticUtilsArray stats = new StatisticUtilsArray(array);
        assertEquals(expectedValue, stats.medianValue());
    }

    /**
     * Tests the mean implementation by examining different cases of arguments provided by the factory
     * method getMeanArguments.
     *
     * @param array         The input array of doubles
     * @param expectedValue The expected mean value
     */
    @DisplayName("Executes all the mean value test cases")
    @ParameterizedTest(name = "{index} => array =''{0}'', expectedValue=''{1}''")
    @MethodSource("getMeanArguments")
    public void testMeanValue(double[] array, double expectedValue) {
        StatisticUtilsArray stats = new StatisticUtilsArray(array);
        assertEquals(expectedValue, stats.meanValue());
    }

    /**
     * Tests the standard deviation implementation by examining different cases of arguments provided by the factory
     * method getStandardDeviationArguments.
     *
     * @param array         The input array of doubles
     * @param expectedValue The expected median value
     */
    @DisplayName("Executes all the standard deviation test cases")
    @ParameterizedTest(name = "{index} => array =''{0}'', expectedValue=''{1}''")
    @MethodSource("getStandardDeviationArguments")
    public void testStandardDeviationValue(double[] array, double expectedValue) {
        StatisticUtilsArray stats = new StatisticUtilsArray(array);
        assertEquals(expectedValue, stats.standardDeviationValue());
    }

}
