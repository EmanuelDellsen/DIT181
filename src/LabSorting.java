import java.util.Arrays;

public class LabSorting {
    /*
     *
     * Private help-method that swaps two elements in an array
     *
     * @param array the array in question
     * @param i     one of the elements to swap
     * @param j     the other element to swap

     */

    static int counter = 0;
    static int partitionCounter = 0;
    static int medianCounter = 0;
    static int quicksortCounter = 0;
    private static void swap(int[] array, int i, int j) {
        int x = array[i];
        array[i] = array[j];
        array[j] = x;
    }

    /*
     *
     * Hands on session 2 Exercise 1 Bubble sort
     *
     * @param array the array to sort

     */
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

    public static void bubbleSortOnCrack(int[] array) {

        boolean swapped = true;

        for (int i = 0; swapped && i < array.length; i++) {
            swapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {

                    int temporary = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temporary;
                    swapped = true;
                }
            }
        }
    }

    /*
     *
     * Hands on session 2 Exercise 2 Insertion sort
     *
     * @param array The array to sort
     */

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
    /*
     *
     * Hands on session 4 & Assignment 2 Question 5 Quicksort
     *
     * @param array the array to sort
     */

    public static void selectSort(int [] array, int begin, int end){


    }



   /* public static int median(int[] array){


        if (array.length <= 5){
            return array[(array.length-1)/2];
        }

        int[] medians;

        if (array.length % 5 == 0){
            medians = new int [array.length/5];
        } else {
            medians = new int [array.length/5+1];
        }

        int k = 0;
        int j = 0;
        int [] tempArray = new int [5];
        int [] tempArrayMatrix = new int [array.length-5];

        for (int i = 0; i < array.length;i++){

            if (j == 5){
                medians[k] = median(tempArray);
                k++;
                j = 0;

            }
            if (array.length+j-i >= 1 && array.length+j-i <= 4){
                tempArrayMatrix[j] = array[i];
                *//*if (i == array.length-1){
                    medians[k] = median(tempArrayMatrix);
                }*//*

            }

            tempArray[j] = array[i];
            j++;
        }
        medians[k] = median(tempArrayMatrix);

        return medians[(medians.length-1)/2];
    }*/

    public static int median(int [] array){

        int median = 0;

        if (array.length == 1){
            median =  array[0];
            return median;
        } else if (array.length % 2 == 0){
            int position = (array.length/2) -1;
            median = quickselectGood(array,0,array.length-1, position);


        } else {
            int position = array.length/2;
            median = quickselectGood(array,0,array.length-1, position);
        }
        return median;

    }

    public static int theRealMedian(int [] array, int begin, int end) {
        return quickselectGood(array, begin, end, (end+begin)/2);
    }

    public static int quickselectGood(int [] array, int left, int right, int k){

        if ( left == right || right < left) {
            return left;
        }

            int pivot = partition(array, left, right);

            if (pivot == k) {
                return pivot;
            } else  if (k < pivot) {
                return quickselectGood(array, left, pivot-1, k);
            } else {
                return quickselectGood(array, pivot+1, right, k-pivot-left+1);
            }


    }
  /* public static int quickselect(int[] array, int begin, int end, int pos){

        int arrayIndex = partition(array, begin, end);

        if ( arrayIndex == median){
            return array[arrayIndex];
        } else if ( arrayIndex < median){
            return quickselect(array, arrayIndex+1, end, median);
        } else {
            return quickselect(array, begin, arrayIndex-1, median);
        }

    }*/

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1, false);
    }

    public static void quickSortMedian(int[] array) {
        quickSort(array, 0, array.length - 1, true);
    }

    // Quicksort part of an array
    private static void quickSort(int[] array, int begin, int end, final boolean useMedian) {
        // Base case.
        if (begin >= end) {
            return;
        }
        int pivotInd;
        if (useMedian) {
            pivotInd = theRealMedian(array, begin, end);

        } else {
            pivotInd = partition(array, begin, end);
        }

        partition(array,begin,end);
        quickSort(array, begin,pivotInd-1,false);
        quickSort(array, pivotInd+1, end,false);

            // Now recursively quicksort the two partitions.

    }

  /*  private static int partition(int[] array, int begin, int end) {
        // Assumes that the pivot is located att array[begin]
        int low = begin;
        int high = end;
        int pivot = array[begin];
        int storeIndex = low;

        for (int i = low; i < high; i++) {
            if (array[i] < pivot) {
                swap(array, storeIndex, i);
                storeIndex++;
            }
        }
        swap(array, high, storeIndex);
        return storeIndex;

    }*/



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



    /*
     *

     * Assignment 2 Question 5, Mergesort
     *
     * @param array the array to sort
     */

    public static void mergeSort(int[] array) {
        // Recursevily mergesort



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
                /*if (array.length % 2 == 0) {
                    right[i] = array[mid + i ];
                }
                else {*/ // needed if we are supposed to merge by the left side
                    right[i] = array[mid + i ];

            }
            mergeSort(left);
            mergeSort(right);
            merge(array, left, right);

        }

    }

    /*
     * Private help method that merge two sorted arrays into one
     *
     * @param array How far we have got in the result array
     * @param left  How far we have got in the left array
     * @param right How far we have got in the right array

     */
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


    public static void fillTheArray(int [] array, int a, int b){

        for (int i = 0; i < array.length ; i++) {
            array[i] = randomInteger(a, b);
        }
    }

    public static int randomInteger(int a, int b){

        return (int) (Math.random() * Math.random() * 100000);
     }

    public static void benchmarkBubblesort(int [] array){

        long start = System.nanoTime();
        bubbleSort(array);
        long end = System.nanoTime();
        System.out.println("Bubblesort completed in : " + (end - start));

    }

    public static void benchmarkMergesort(int [] array){

        long start = System.nanoTime();
        mergeSort(array);
        long end = System.nanoTime();
        System.out.println("Mergesort completed in : " + (end - start));

    }

    public static void benchmarkInsertionsort(int [] array){

        long start = System.nanoTime();
        insertionSort(array);
        long end = System.nanoTime();
        System.out.println("Insertionsort completed in : " + (end - start));

    }

     public static void benchmarkQuicksortWithMedian(int [] array){

         long start = System.nanoTime();
         quickSort(array, 0, array.length-1, true);
         long end = System.nanoTime();
         System.out.println("Quicksort with median completed in : " + (end - start));

     }
    public static void benchmarkQuicksortWithoutMedian(int [] array){

        long start = System.nanoTime();
        quickSort(array, 0, array.length-1, false);
        long end = System.nanoTime();
        System.out.println("Quicksort without median completed in : " + (end - start));

    }








    public static void main(String[] args) {
        int [] insertionTestArray = {-22, -17, 46, 34, -5};
        int [] bubbleArray = new int [100];
        int [] mergeArray = new int [100];
        int [] insertionArray = new int [100];
        int [] quickMedian = new int [100];
        int [] quickOriginal = new int [100];

        fillTheArray(bubbleArray,4,3);
        fillTheArray(mergeArray,4,3);
        fillTheArray(insertionArray,4,3);
        fillTheArray(quickMedian,4,3);
        fillTheArray(quickOriginal,4,3);




       benchmarkQuicksortWithMedian(quickMedian);
        benchmarkQuicksortWithoutMedian(quickOriginal);

        //System.out.println(Arrays.toString(bubbleArray));



      //  System.out.println(Arrays.toString(mergeArray));




    }
}
