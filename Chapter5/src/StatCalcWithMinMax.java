/**
 * An object of class StatCalc can be used to compute several simple statistics
 * for a set of numbers.  Numbers are entered into the dataset using
 * the enter(double) method.  Methods are provided to return the following
 * statistics for the set of numbers that have been entered: The number
 * of items, the sum of the items, the average, and the standard deviation
 */

class StatCalcWithMinMax extends StatCalc {

    private double max ;// = Double.NEGATIVE_INFINITY; // The largest of all the items
    private double min; // = Double.POSITIVE_INFINITY;; // The smallest of all the items

    /**
     * Add a number to the dataset.  The statistics will be computed for all
     * the numbers that have been added to the dataset using this method.
     */
    public void enter(double num) {
        super.enter(num);
        if(num > max){
            max = num;
        }
        else if (num < min){
            min = num;
        }

    }


    public double getMax(){
        return max;
    }
    public double getMin() { return min; }

}  // end class StatCalc
