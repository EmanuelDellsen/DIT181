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
       // System.out.println(System.nanoTime());


        // throw new UnsupportedOperationException();
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

        for (int i = 1; i < array.length - 1; i++) {


            int j = i - 1;

            while (j >= 0 && array[j] > array[i]) {

                array[j + 1] = array[j];
                j = j - 1;
                j++;
            }

            array[j + 1] = array[i];

        }

       // System.out.println(System.nanoTime());

        // throw new UnsupportedOperationException();
    }
    /*
     *
     * Hands on session 4 & Assignment 2 Question 5 Quicksort
     *
     * @param array the array to sort
     */

    public static void selectSort(int [] array, int begin, int end){


    }

   /* public static int medianAuxiliary(int [] array, int begin, int end, int middle){

        if ( begin == end){
            return array[begin];
        }
        int k = partition(array, begin, end);
        int arrayLength = k - begin + 1 ;

        if (arrayLength == k){
            return array[k];
        }

        if ( arrayLength > middle) {

            return medianAuxiliary(array,middle, begin, k -1);

        } else{
            return  medianAuxiliary(array, middle-arrayLength, end, k );

        }

    }*/

    public static int median(int[] array){

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
                /*if (i == array.length-1){
                    medians[k] = median(tempArrayMatrix);
                }*/
            }

            tempArray[j] = array[i];
            j++;
        }
        medians[k] = median(tempArrayMatrix);

        return medians[(medians.length-1)/2];
    }

    public static int quickselect(int[] array, int begin, int end, int median){

        int arrayIndex = partition(array, begin, end);

        if ( arrayIndex == median){
            return array[arrayIndex];
        } else if ( arrayIndex < median){
            return quickselect(array, arrayIndex+1, end, median);
        } else {
            return quickselect(array, begin, arrayIndex-1, median);
        }



    }
    public int findMedianSize5(int [] array, int n){

        return n;


    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1, false);
       // System.out.println(System.nanoTime());

    }

    public static void quickSortMedian(int[] array) {
        quickSort(array, 0, array.length - 1, true);
       // System.out.println(System.nanoTime());


    }

    // Quicksort part of an array
    private static void quickSort(int[] array, int begin, int end, final boolean useMedian) {
        // Base case.
        if (begin >= end) {
            return;
        }
        // Use median as pivot
        if (useMedian) {
            median(array);
        }
            // Put the pivot item at begin index
            int pivot = array[begin];
            // Partition the array.
            int pivotInd = partition(array, begin, end);
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
                else {*/
                    right[i] = array[mid + i ];

            }
            mergeSort(left);
            //System.out.println(Arrays.toString(left));
            mergeSort(right);
           // System.out.println(Arrays.toString(right));
            merge(array, left, right);

        }


        //System.out.println(System.nanoTime());

        // Merge the left and right sub-arrays
    }

    /* public static void mergeSortLecture ( int [] a, int [] tempArray, int left, int right){
         if (left < right ){
             int center = (left+right) / 2;
             mergeSortLecture(a, tempArray, left, center);
             mergeSortLecture(a, tempArray, center + 1, right);
             mergeLecture(a, tempArray, left, center + 1, right);

         }
     }*/
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

    /*  public static void mergeLecture ( int [] a, int [] tempArray, int leftPos, int rightPos, int rightEnd){
          int leftEnd = rightPos -1 ;
          int tmpPos = leftPos;
          int numElements = rightEnd - leftPos +1 ;

          while(leftPos <= leftEnd && rightPos <= rightEnd){
              if (a[leftPos] <= a[rightPos]){
                  tempArray[tmpPos++] = a[leftPos++];
              } else{
                  tempArray[tmpPos++] = a[rightPos++];
              }
          }
          while(leftPos <= leftEnd){
              tempArray
          }
      }
  */

    public static void benchmarkBubblesort(int [] array){

        long start = System.nanoTime();
        bubbleSort(array);
        long end = System.nanoTime();
        System.out.println("Bubblesort took: " + (end - start) + " nanoseconds" );
    }

    public static void benchmarkMerge(int [] array){

        long start = System.nanoTime();
        mergeSort(array);
        long end = System.nanoTime();
        System.out.println("MergeSort took: " + (end - start) + " nanoseconds" );
    }

    public static void benchmarkInsertionsort(int [] array){

        long start = System.nanoTime();
        insertionSort(array);
        long end = System.nanoTime();
        System.out.println("Insertionssort took: " + (end - start) + " nanoseconds" );
    }

    public static void benchmarkQuicksortWithMedian(int [] array){


        long start = System.nanoTime();
        quickSort(array,0, array.length-1, true);
        long end = System.nanoTime();
        System.out.println("Quicksort with median took: " + (end - start) + " nanoseconds" );
    }

    public static void benchmarkQuicksortWithoutMedian(int [] array){

        long start = System.nanoTime();
        quickSort(array,0, array.length-1, false);
        long end = System.nanoTime();
        System.out.println("Quicksort without median took: " + (end - start) + " nanoseconds" );
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

        int [] superArray = {20,5,12,1,3,6,8};

        System.out.println(Arrays.toString(superArray));
        insertionSort(superArray);
        System.out.println(Arrays.toString(superArray));


    }
}
