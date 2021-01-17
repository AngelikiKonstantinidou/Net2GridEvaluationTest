import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * StatisticUtilsArrayList provides a set of statistical values for an array list of double values by extending the
 * {@link StatisticUtilsArray} class. The supported statistical metrics are the following:
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
public class StatisticUtilsArrayList extends StatisticUtilsArray {

    /**
     * list of doubles used as input
     */
    private List<Double> list;

    /**
     * Class constructor specifying array list of double.
     *
     * @param list Array list of double values
     */
    public StatisticUtilsArrayList(ArrayList<Double> list) {
        this.list = list;
        super.setArray(ArrayUtils.toPrimitive(list.toArray(new Double[0])));
    }

    /**
     * Sets the array list of values
     *
     * @param values The array list of doubles
     */
    public void setArrayList(ArrayList<Double> values) {
        this.list = values;
    }

    /**
     * Gets the array list of values
     *
     * @return List of doubles
     */
    public List<Double> getArrayList() {
        return this.list;
    }


}
