public class LabSorting {

    // Auxillary method to switch positions of integers in the array

    private static void swap(int[] array, int i, int j) {
        int x = array[i];
        array[i] = array[j];
        array[j] = x;
    }


    //******* QUICK SORT START ********

    public static void quickSort(int [] array){
        quickSort(array,0,array.length-1,false);
    }

    public static void quickSortMedian(int [] array){
        quickSort(array,0,array.length-1,true);
    }
    public static void quickSort(int[] array, int begin, int end, final boolean useMedian) {
        // Base case.
        if (begin >= end) {
            return;
        }
        int pivotInd;
        if (useMedian) {
            pivotInd = findMedianValue(array,begin,end,(end+begin)/2);
        } else {
            pivotInd = partition(array,begin,end);
        }
        quickSort(array, begin,pivotInd-1,useMedian);
        quickSort(array, pivotInd+1, end,useMedian);

    }

    public static int findMedianValue(int[] array, int left, int right, int n){
        if (left == right){
            return left;
        }
        int pivotIndex = n;
        pivotIndex = partitionMedian(array,left,right,pivotIndex);

        if (n == pivotIndex){
            return n;
        } else if (n < pivotIndex){
            return findMedianValue(array,left,pivotIndex-1,n);
        } else {
            return findMedianValue(array,pivotIndex+1,right,n);
        }
    }

    public static int partitionMedian (int [] array, int left, int right, int pivotindex){
        int pivotValue = array[pivotindex];
        swap(array,pivotindex,right);
        int storeIndex = left;
        for (int i = left; i < right; i++){
            if (array[i] < pivotValue){
                swap(array,storeIndex,i);
                storeIndex++;
            }
        }
        swap(array,right,storeIndex);
        return storeIndex;

    }

    public static int partition(int[] array, int begin, int end) {
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

    //******* QUICK SORT END ********

    //******* BUBBLE SORT START ********


    public static void bubbleSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {

                    int temporary = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temporary;
                }
            }
        }
    }

    //******* BUBBLE SORT END ********

    //******* INSERTION SORT START ********


    public static void insertionSort(int[] array) {


        for (int i = 0; i < array.length-1; i++) {
            int j = i+1;

            if (array[j] < array[i]){
                swap(array,j,i);
                j--;
                while(j > 0 && array[j-1] > array[j]){
                    swap(array,j-1,j);
                    j--;
                }
            }
        }
    }
    //******* INSERTION SORT END ********

    //******* MERGE SORT START ********

    public static void mergeSort(int[] array) {

        if ( array.length <= 1){
            return;

        } else{

            int mid = array.length/2;
            int [] right = new int[array.length-mid];
            int [] left = new int [mid];


            for (int i = 0; i < left.length; i++) {
                left[i] = array[i];
            }
            for (int i = 0; i < right.length; i++) {
                right[i] = array[mid + i ];

            }
            mergeSort(left);
            mergeSort(right);
            merge(array, left, right);

        }
    }

    public static void merge(int[] array, int[] left, int[] right) {
        int l = 0;
        int r = 0;
        int k = 0;

        while (l < left.length && r < right.length){
            if (left[l] <= right[r]){
                array[k] = left[l];
                k++;
                l++;
            } else {
                array[k] = right[r];
                k++;
                r++;
            }
        }

        while(l < left.length){
            array[k] = left[l];
            k++;
            l++;
        }

        while(r < right.length){
            array[k] = right[r];
            k++;
            r++;
        }
    }

    //******* MERGE SORT END ********

    public static void main(String[] args) {

    }
}
