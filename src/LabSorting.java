import java.lang.reflect.Array;
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
                j = i - 1;
            }

            array[j + 1] = array[i];

        }

        // throw new UnsupportedOperationException();
    }
    /*
     *
     * Hands on session 4 & Assignment 2 Question 5 Quicksort
     *
     * @param array the array to sort
     */

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
        // Use median as pivot
        if (useMedian) {
            int median = (end+begin)/2;
            swap(array,begin,median);
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
        if ( array.length == 1){
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
            System.out.println(Arrays.toString(left));
            mergeSort(right);
            System.out.println(Arrays.toString(right));
            merge(array, left, right);

        }



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
    public static void main(String[] args) {
        // Put code here to try out your algorithms
        /* int[] arr = new int[]{3, 7, 8, 5, 2, 1, 9, 5, 4,  4, 3, 1, 11, 22, 31, 5121, 776,233, 43, 12, 2 ,1, 6};

        System.out.println(Arrays.toString(arr));
        quickSort(arr,0,arr.length-1,false);
        System.out.println(Arrays.toString(arr));

        System.out.println("SKILJESTRECK");

        int[] arr2 = new int[]{3, 7, 8, 5, 2, 1, 9, 5, 4, 4, 3, 1, 11, 22, 31, 5121, 776,233, 43, 12, 2 ,1, 6};


        System.out.println(Arrays.toString(arr2));
        quickSort(arr2,0,arr2.length-1,true);
        System.out.println(Arrays.toString(arr2));
        */

        int [] arr = new int [] {2,3,5,2,4,3,1};

       // System.out.println(arr);
        mergeSort(arr);

        System.out.println(Arrays.toString(arr));

        //System.out.println(arr);

    }
}


/*   int currentMax = 0;

            for (int i = 0; i < array.length-1 ; i++) {
               currentMax += i;
                for (int j = 0; j < i; j++) {
                }
                if (array[i+1] > max){
                    max = array[i+1];
                }
                currentMax -= max;
                if (array[i+1] < min){
                    min = array[i+1];
                }
                currentMax -= min;
                System.out.println(currentMax);
            }
*/