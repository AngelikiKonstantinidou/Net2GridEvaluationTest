import java.util.List;

/**
 * StatisticUtilsArrayListGenerics provides a set of statistical values for an array list of all
 * Numerical data types by extending the {@link StatisticUtilsArray}. The supported statistical metrics are the following:
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
public class StatisticUtilsArrayListGenerics<T extends Number> extends StatisticUtilsArray {

    /**
     * Class constructor specifying array list of all numerical data types.
     *
     * @param listOfValues list of <T> type of values
     */
    public StatisticUtilsArrayListGenerics(List<T> listOfValues) {
        double[] arrayOfValues = new double[listOfValues.size()];
        for (int i = 0; i < listOfValues.size(); i++) {
            arrayOfValues[i] = listOfValues.get(i).doubleValue();
        }
        super.setArray(arrayOfValues);
    }

}
