import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * StatisticUtilsArrayListGenericsTest is a test class created for {@link StatisticUtilsArrayListGenerics}. The purpose
 * of this test class is to make sure that StatisticUtilsArrayListGenerics can handle all numerical input types by
 * examining only one statistical metric since the aforementioned class extends the {@link StatisticUtilsArray},
 * which is extensively tested in {@link StatisticUtilsArrayTest}. The current class contains a factory method which
 * generates the arguments of the test method and a test method for a sample functionality (i.e. min)
 *
 * @author Angeliki Konstantinidou
 */
public class StatisticUtilsArrayListGenericsTest {

    /**
     * Generates and returns a stream with possible arguments for testing the implementation of the min functionality
     * of {@link StatisticUtilsArrayListGenerics}. Specifically, each argument is a combination of the input array list
     * of different numerical types and the expected min value. The generated arguments cover the following cases:
     * a. list of integer
     * b. list of double
     * c. list of long
     * d. list of float
     * e. list of short
     * f. empty list
     *
     * @return Stream A stream of arguments
     */
    private static Stream<Arguments> getMinArguments() {
        return Stream.of(
                Arguments.of(new TestObject(new ArrayList<>(Arrays.asList(1, 2, 1, 4, 9)), 1.0)),
                Arguments.of(new TestObject(new ArrayList<>(Arrays.asList(-1.0, -2.0, -1.1, -4.8, -9.2)), -9.2)),
                Arguments.of(new TestObject(new ArrayList<>(Arrays.asList(-6375650285862366954L, 1645916649773713770L, -4405693082669724792L)),
                        -6375650285862366954L)),
                Arguments.of(new TestObject(new ArrayList<>(Stream.of(27515, -17162, 9839, 67, -24632).map(value -> value.shortValue()).
                        collect(Collectors.toList())), -24632.0)),
                Arguments.of(new TestObject(new ArrayList<>(Arrays.asList(0.553389f, 0.9925707f, 0.24594128f, 0.91674095f, 0.47179967f)),
                        0.24594128131866455)),
                Arguments.of(new TestObject(new ArrayList<Double>(), Double.NaN)));
    }

    /**
     * Tests the min implementation in terms of supporting arguments of all numerical types that are coming as input from
     * the factory method getMinArguments.
     *
     * @param test The input test object containing the list of values and the expected output
     */
    @DisplayName("Executes all the minimum value test cases")
    @ParameterizedTest(name = "{index} => TestObject =''{0}''")
    @MethodSource("getMinArguments")
    public void testMinimumValue(TestObject test) {
        StatisticUtilsArrayListGenerics stats = new StatisticUtilsArrayListGenerics(test.getInputList());
        assertEquals(test.getExpectedValue(), stats.minimumValue());
    }

    /**
     * TestObject is a helper class used to form the arguments for the testing purposes of the outer class
     *
     * @param <T>
     */
    private static class TestObject<T extends Number> {
        /**
         * list of <T> type of values
         */
        private List<T> inputList;
        /**
         * double value representing the expected value
         */
        private double expectedValue;

        /**
         * Constructor that specifies the class fields
         *
         * @param list          list of <T> type of values
         * @param expectedValue double value representing the expected value
         */
        public TestObject(List<T> list, double expectedValue) {
            this.inputList = list;
            this.expectedValue = expectedValue;
        }

        /**
         * Getter method for inputList field
         *
         * @return inputList
         */
        public List<T> getInputList() {
            return this.inputList;
        }

        /**
         * Getter method for expectedValue field
         *
         * @return expectedValue
         */
        public double getExpectedValue() {
            return this.expectedValue;
        }

    }
}
