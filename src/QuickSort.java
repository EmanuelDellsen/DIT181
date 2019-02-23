public class QuickSort {

    private static void quickSort(int[] array, int begin, int end, final boolean useMedian) {
        // Base case.
        if (begin >= end) {
            return;
        }
        int pivotInd;
        if (useMedian) {
            //pivotInd = indexOfMedian(array,begin,end,pivotInd);
            quickSort(array,begin,pivotInd-1,useMedian);
            quickSort(array,begin,pivotInd-1,useMedian);
        } else {
            pivotInd = partition(array,begin,end);
        }
        quickSort(array, begin,pivotInd-1,useMedian);
        quickSort(array, pivotInd+1, end,useMedian);

        // Now recursively quicksort the two partitions.

    }



    private static int partition(int[] array, int begin, int end) {
        // Assumes that the pivot is located att array[begin]
        int pivot = array[begin];
        int i = begin-1;
        int j = begin;

        while( j <= end){
            if (array[j] <= pivot){
                i++;
                swap(array,i,j);

            }
            j++;
        }
        swap(array,i,begin);

        return i;
    }

    // Auxillary methods

    private static void swap(int[] array, int i, int j) {
        int x = array[i];
        array[i] = array[j];
        array[j] = x;
    }

    public static void fillTheArray(int [] array, int a, int b){

        for (int i = 0; i < array.length ; i++) {
            array[i] = randomInteger(a, b);
        }
    }

    public static int randomInteger(int a, int b){

        return (int) (Math.random() * Math.random() * 100000);
    }

    public static void main(String[] args) {

    }
}
