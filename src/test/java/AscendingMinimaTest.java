import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * AscendingMinimaTest is test class created to {@link AscendingMinima}. The class contains a factory
 * method which generates the arguments of the test method and the actual test method
 *
 * @author Angeliki Konstantinidou
 */
public class AscendingMinimaTest {

    /**
     * Generates and returns a stream with possible arguments for testing the implementation of the ascending minima
     * algorithm of {@link AscendingMinima}. Specifically, each argument is a combination of the input array
     * of doubles, the sliding window and the expected ascending minima in a queue. The generated arguments cover the
     * following cases:
     * 1. valid input arrays and sliding windows combinations
     * 2. valid input array combined with invalid sliding window
     * 3. empty input array combined with valid sliding window
     *
     * @return Stream A stream of arguments
     */
    private static Stream<Arguments> getAscendingMinimaArguments() {
        return Stream.of(
                Arguments.of(new double[]{1, 3, 3, 2, 5, 8, 7, 8, 9}, 3,
                        new LinkedList<>(new ArrayList<>(Arrays.asList(1.0, 2.0, 2.0, 2.0, 5.0, 7.0, 7.0)))),
                Arguments.of(new double[]{5, 1, 3, 2, 6, 8, 4, 6}, 3,
                        new LinkedList<>(new ArrayList<>(Arrays.asList(1.0, 1.0, 2.0, 2.0, 4.0, 4.0)))),
                Arguments.of(new double[]{8, 9, 5, 3, 6, 5, 1, 1, 0}, 3,
                        new LinkedList<>(new ArrayList<>(Arrays.asList(5.0, 3.0, 3.0, 3.0, 1.0, 1.0, 0.0)))),
                Arguments.of(new double[]{7, 4, 8, 6, 3, 4, 2, 1, 2}, 3,
                        new LinkedList<>(new ArrayList<>(Arrays.asList(4.0, 4.0, 3.0, 3.0, 2.0, 1.0, 1.0)))),
                Arguments.of(new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 3,
                        new LinkedList<>(new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0)))),
                Arguments.of(new double[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, 3,
                        new LinkedList<>(new ArrayList<>(Arrays.asList(7.0, 6.0, 5.0, 4.0, 3.0, 2.0, 1.0)))),
                Arguments.of(new double[]{9, 1, 1, 3, 4, 2, 6, 8, 9}, 3,
                        new LinkedList<>(new ArrayList<>(Arrays.asList(1.0, 1.0, 1.0, 2.0, 2.0, 2.0, 6.0)))),
                Arguments.of(new double[]{9, 1, 1, 3, 4, 2, 6, 8, 9}, -1, new LinkedList<>()),
                Arguments.of(new double[]{}, 3, new LinkedList<>()));

    }

    /**
     * Tests the ascending minima implementation by examining different cases of arguments that are coming as input from
     * the factory method getAscendingMinimaArguments.
     *
     * @param array          The input array of doubles
     * @param k              The sliding window
     * @param expectedResult The expected result in the form of a queue
     */
    @DisplayName("Executes ascending minima test cases")
    @ParameterizedTest
    @MethodSource("getAscendingMinimaArguments")
    public void ascendingMinimaTests(double[] array, int k, Queue<Double> expectedResult) {
        AscendingMinima ascendingMinima = new AscendingMinima(array, k);
        assertEquals(expectedResult, ascendingMinima.ascendingMinimaWrapper());
    }

}
