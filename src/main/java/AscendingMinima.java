import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * AscendingMinima is the main entity used to calculate the ascending minima for a given array of doubles A with sliding
 * window K. The ascending minima problem is briefly described as follows:
 * - having as input an array of size n and a sliding window of size k,
 * - find the n-k+1 minimum values for the windows created with sliding window k.
 * For example the ascending minima of the array is 5,1,3,2,6,8,4,6 with sliding window 3 is 1,1,2,2,4,4.
 *
 * @author Angeliki Konstantinidou
 */
public class AscendingMinima {

    /**
     * array of double used as input
     */
    private double[] array;
    /**
     * sliding window
     */
    private int k;

    /**
     * Class constructor specifying the array of doubles and the sliding window
     *
     * @param array
     * @param k
     */
    public AscendingMinima(double[] array, int k) {
        this.array = array;
        this.k = k;
    }

    /**
     * Calculates the ascending minima of an array of double values for a sliding window k.
     * This is a wrapper method that creates the sub windows based on the sliding window, finds the minima of
     * each sub window by calling the getMinima method. Then, it stores the first value of the current minima in the
     * final minima and continues this process until it finds the minima for all the sub windows of the initial window.
     *
     * @return the final ascending minima
     */
    public Queue<Double> ascendingMinimaWrapper() {

        Queue<Double> ascendingMinimaTemp = new LinkedList<>();
        // The final ascending minima that the method returns
        Queue<Double> ascendingMinimaFinal = new LinkedList<>();

        // In case of invalid sliding window or empty input array, return an empty minima
        if (this.k <= 0 || this.array.length < 0)
            return ascendingMinimaFinal;

        //initialization
        int from = 0;
        int to = this.k;
        double[] tempArray;

        // iterate on the initial array to create the sub arrays for sliding window k
        while (to <= this.array.length) {
            //create the sub array
            tempArray = Arrays.copyOfRange(this.array, from, to);
            //get the minima and store it to a temporary queue
            ascendingMinimaTemp = getMinima(tempArray, ascendingMinimaTemp);
            //get the current array minima and store it to the final minima
            ascendingMinimaFinal.add(ascendingMinimaTemp.peek());
            //initialize the temporary minima queue
            ascendingMinimaTemp = new LinkedList<>();
            //update the indexes to create the new sub array
            from++;
            to++;
        }

        return ascendingMinimaFinal;
    }

    /**
     * Calculates recursively the ascending minima queue of a given array window.
     * The algorithm finds the index i of the minimum element of the whole window and adds the element to the minima.
     * From the index i+1 to k elements, the algorithm finds the minimum element and adds it to the minima. The process
     * is repeated until the last element of the window is added to minima.
     *
     * @param window the array for which the ascending minima is calculated
     * @param minima the current array minima
     * @return the ascending minima
     */
    public Queue<Double> getMinima(double[] window, Queue<Double> minima) {
        /*
         * if the window is empty return null and if the window contains only one
         * element, add the element to the minima and return it
         */
        if (window.length == 0)
            return null;
        else if (window.length == 1) {
            minima.add(window[window.length - 1]);
            return minima;
        }

        //find the index of the minimum element in the current window
        int minIndex = 0;
        for (int i = 0; i < window.length; i++) {
            if (window[i] < window[minIndex]) {
                minIndex = i;
            }
        }

        //add the minimum element to the minima
        minima.add(window[minIndex]);

        //create the new sub window
        double[] newWindow = Arrays.copyOfRange(window, minIndex + 1, window.length);

        /*
         * Repeat the process of finding the next minimum of the new window,
         * until the last element of the window is added as an entry to the queue.
         */
        getMinima(newWindow, minima);

        return minima;
    }

}
