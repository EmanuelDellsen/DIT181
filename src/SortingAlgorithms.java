public class SortingAlgorithms {

    private final static int NR_OF_BENCHMARK = 10;
    private final static int AMOUNT_OF_VALUES = 10000000;

    private static void quickSort(int[] array, int begin, int end, final boolean useMedian) {
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

    public static long benchmarkQuicksortWithMedian(int [] array){

        long start = System.nanoTime();
        quickSort(array, 0, array.length-1, true);
        long end = System.nanoTime();

        return end-start;

    }
    public static long benchmarkQuicksortWithoutMedian(int [] array){

        long start = System.nanoTime();
        quickSort(array, 0, array.length-1, false);
        long end = System.nanoTime();

        return end-start;

    }
    public static void reverse(int [] array){

        int j = array.length-1;
        for(int i = 0; i < j; i++){
            swap(array,i,j);
            j--;
        }
    }

    public static void reverseAllArrays(int [][] arrayOfArrays){

        for (int i = 0; i < arrayOfArrays.length; i++){
                reverse(arrayOfArrays[i]);
            }
    }


    public static void benchmarkAverageMedian(int [][] arrayOfArrays){

        long average = 0;
        for (int i = 0; i < NR_OF_BENCHMARK+1; i++){
            if (i == 0){
                benchmarkQuicksortWithMedian(arrayOfArrays[i]);
            } else {
                average += benchmarkQuicksortWithMedian(arrayOfArrays[i]);
            }
        }
        System.out.println(average/ NR_OF_BENCHMARK);

    }

    public static void benchmarkAverageNoMedian(int [][] arrayOfArrays){

        long average = 0;
        for (int i = 0; i < NR_OF_BENCHMARK+1; i++){
            if (i == 0){
                benchmarkQuicksortWithoutMedian(arrayOfArrays[i]);
            } else {
                average += benchmarkQuicksortWithoutMedian(arrayOfArrays[i]);
            }
        }
        System.out.println(average/ NR_OF_BENCHMARK);

    }

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

    public static void benchmarkAverageInsertionSort(int [][] arrayOfArrays){

        long average = 0;
        for (int i = 0; i < NR_OF_BENCHMARK+1; i++){
            if (i == 0){
                benchmarkInsertionSOrt(arrayOfArrays[i]);
            } else {
                average += benchmarkInsertionSOrt(arrayOfArrays[i]);
            }
        }
        System.out.println(average/ NR_OF_BENCHMARK);

    }


    public static long benchmarkInsertionSOrt(int [] array){

        long start = System.nanoTime();
        insertionSort(array);
        long end = System.nanoTime();
        System.out.println("Insertion sort completed in : " + (end - start));

        return end-start;

    }

    public static long benchmarkBubbleSort(int [] array){

        long start = System.nanoTime();
        bubbleSort(array);
        long end = System.nanoTime();
        System.out.println("Bubblesort completed in : " + (end - start));

        return end-start;

    }

    public static void benchmarkAverageBubbleSort(int [][] arrayOfArrays){

        long average = 0;
        for (int i = 0; i < NR_OF_BENCHMARK+1; i++){
            if (i == 0){
                benchmarkBubbleSort(arrayOfArrays[i]);
            } else {
                average += benchmarkBubbleSort(arrayOfArrays[i]);
            }
        }
        System.out.println(average/ NR_OF_BENCHMARK);

    }


    public static long benchmarkMergeSort(int [] array){

        long start = System.nanoTime();
        mergeSort(array);
        long end = System.nanoTime();
        System.out.println("Mergesort completed in : " + (end - start));

        return end-start;

    }

    public static void benchmarkAvergeMergeSort(int [][] arrayOfArrays){

        long average = 0;
        for (int i = 0; i < NR_OF_BENCHMARK+1; i++){
            if (i == 0){
                benchmarkMergeSort(arrayOfArrays[i]);
            } else {
                average += benchmarkMergeSort(arrayOfArrays[i]);
            }
        }
        System.out.println(average/ NR_OF_BENCHMARK);

    }

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

    private static void merge(int[] array, int[] left, int[] right) {
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



        // Idea: repeatedly copy one element from either the left or right array to the
        // result array.

    }



    public static void main(String[] args) {

        int [] array1 = new int [AMOUNT_OF_VALUES];
        fillTheArray(array1,4,3);
        int [] array2 = new int [AMOUNT_OF_VALUES];
        fillTheArray(array2,4,3);
        int [] array3 = new int [AMOUNT_OF_VALUES];
        fillTheArray(array3,4,3);
        int [] array4 = new int [AMOUNT_OF_VALUES];
        fillTheArray(array4,4,3);
        int [] array5 = new int [AMOUNT_OF_VALUES];
        fillTheArray(array5,4,3);
        int [] array6 = new int [AMOUNT_OF_VALUES];
        fillTheArray(array6,4,3);
        int [] array7 = new int [AMOUNT_OF_VALUES];
        fillTheArray(array7,4,3);
        int [] array8 = new int [AMOUNT_OF_VALUES];
        fillTheArray(array8,4,3);
        int [] array9 = new int [AMOUNT_OF_VALUES];
        fillTheArray(array9,4,3);
        int [] array10 = new int [AMOUNT_OF_VALUES];
        fillTheArray(array10,4,3);
        int [] array11 = new int [AMOUNT_OF_VALUES];
        fillTheArray(array11,4,3);

        int[][] arrayOfArrays = {array1,array2,array3,array4,array5,array6,array7,array8,array9,array10,array11};

        benchmarkAverageNoMedian(arrayOfArrays);


    }
}
