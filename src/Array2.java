class Array2 {

    private final int max_elements = 200;
    private int size = 0;
    private int[] arr;

    public Array2(int n) {
        if ((n < 0) || (n > max_elements)) {
            throw new IllegalArgumentException("Array size must be non-negative");
        }
        arr = new int[max_elements];
        size = n;
    }


    /**
     * @return the size of the Array
     */

    public int size() {
        return size;
    }


    /**
     * Set the i-th element to x We are not checking whether the index is in bounds,
     * because dereferencing the array element does it for us.
     *
     * @param i the index of the element
     * @param x the element we're adding
     */

    public void set(int i, int x) {
        arr[i] = x;
    }


    /**
     * Get the i-th element, Again, we are not checking if the index is in bounds.
     *
     * @param i the index of the element to get
     * @return the element found
     */

    public int get(int i) {
        return arr[i];
    }


    /**
     * @return the content of the array as a String
     */

    public String toString() {
        StringBuilder res = new StringBuilder("{");
        if (size > 0) {
            res.append(arr[0]);
            for (int i = 1; i < size; ++i) {
                res.append(", ");
                res.append(arr[i]);
            }
        }
        res.append("}");
        return res.toString();
    }


    /**
     * Hands on session 1 Exercise 1 - Insert element x at index i assuming i is max
     * the size of the array.
     *
     * @param i the index where to insert
     * @param x the element to insert
     */

    public void insert(int i, int x) {

        if (i < 0 || i > size()) {
            throw new IllegalArgumentException("Cant be negative");
        }
        if (i == max_elements) {
            throw new IllegalArgumentException("to high of a number");
        }
        for (int j = size; i < j; j--) {
            arr[j] = arr[j - 1];

        }
        arr[i] = x;
        size++;

        throw new UnsupportedOperationException();

    }


    /**
     * Hands on session 1 Exercise 2
     *
     * @return true if the array is sorted
     */

    public boolean isSorted() {
        for (int i = 0; i < size() - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;

    }


    /**
     * Hands on session 1 Exercise 3
     *
     * @return the length of longest increasing sub array
     */

    public int maxNonDecreasing() {
        int currentMax = 1;
        int max = 0;
        if (size() > 0) {
            for (int i = 0; i < size() - 1; i++) {
                if (get(i) <= get(i + 1)) {
                    currentMax++;
                } else {
                    if (currentMax > max) {
                        max = currentMax;
                        currentMax = 1;
                    }
                }
            }
            if (currentMax > max) {
                return currentMax;
            } else {
                return max;
            }
        } else {
            return 0;
        }
    }


    /**
     * Hands on session 1 Exercise 4 - returns the index of the first number in the
     * first matching subarray
     *
     * @param b The subarray to compare with
     * @return the index where the subarray starts
     */

    public int subArrayIndex(Array2 b) {
        for (int i = 0; i <= (size - (b.size() - 1)); i++) {
            boolean isEqual = true;
            int j = 0;
            while (isEqual && (j <= b.size() - 1)) {
                if (arr[i + j] == b.get(j)) {
                    j++;
                } else {
                    isEqual = false;
                }
            }
            if (isEqual) {
                return i;
            }
        }
        return -1;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


/**
 * Hands on Session 3 Exercise 2 Return the maximum sum of all contiguous
 * subarrays of the array.
 *
 * @param array the array
 * @param lo    the index of the low boundary of the subarray
 * @param hi    the index of the high boundary of the subarray
 * @return the sum of the subarray


 */


    /**
     * Assignment 1 Question 1 Reverse the array
     */

    public void reverse() {

        int j = size() - 1;
        for (int i = 0; i < j; i++) {
            swap(this.arr, i, j);
            j--;
        }
    }

    /**
     * Assignment 1 Question 2 Remove the element of index i from the array.
     *
     * @param i the element to remove
     */

    public void remove(int i) {

        for (int j = 0; j < this.size - 1; j++) {
            if (j == i) {
                swap(this.arr, j, j + 1);
            }
            if (i < j) {
                swap(this.arr, j, j + 1);
            }
        }
        set(this.size - 1, 0);
        this.size--;
    }


    /**
     * Assignment 1 Question 2 Remove the element of index i from the array. This
     * method may change the order of the other elements of the array.
     *
     * @param i the element to remove
     */

    public void remove2(int i) {
        if (i == this.size() - 1) {
            set(this.size - 1, 0);
            this.size--;

        } else {
            swap(this.arr, i, size() - 1);
            set(this.size() - 1, 0);
            this.size--;
        }
    }


    /**
     * Assignment 1 Question 3 Return the index of the first occurrence of x in the
     * array, or -1 if x does not occur.
     *
     * @param x the element to find
     * @return the index of the first occurrence
     */

    public int find(int x) {

        for (int i = 0; i < size(); i++) {
            if (x == get(i)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Assignment 1 Question 4 Find the length of the longest palindrome that is a
     * contiguous subsequence of the array.
     *
     * @return The length of the palindrome
     */

    public int maxPalindrome() {

        int longestPalindrome = 0;
        if (size > 0) {
            if (size == 1) {
                longestPalindrome = 1;
                return longestPalindrome;
            } else {
                for (int i = 0; i < size() - 1; i++) {
                    int matchCounter = 0;
                    int k = i;
                    for (int j = size() - 1; j >= k; j--) {
                        if (get(k) != get(j)) {
                            k = i;
                            matchCounter = 0;
                        } else {
                            if (k == j) {
                                k++;
                                matchCounter += 1;
                            } else {
                                k++;
                                matchCounter += 2;
                            }
                        }
                    }
                    if (matchCounter > longestPalindrome) {
                        longestPalindrome = matchCounter;
                    }
                }
                return longestPalindrome;
            }
        } else {
            return longestPalindrome;
        }
    }


    /**
     * Assignment 2 Question 3 returns the sum off the largest contiguous ascending
     * array
     *
     * @return the sum
     */

    public int [] auxillary(int[]arr) {

        int [] tempArray = new int [size];

        int j = 0;
        int i = tempArray.length-1;

        while(i-1 > -1 && get(i) > get(i-1)){
            tempArray[j] = get(i);
            j++;
            i--;
        }
        tempArray[j] = get(i);

        int [] copyArray = new int [j+1];
        int k = 0;

        for (; k < copyArray.length-1; k++){
            copyArray[k] = tempArray[j];
            j--;
        }
        copyArray[k] = tempArray[j];


        return copyArray;
    }

    private int maxSumFromTo(int a, int b) {

        if (a == b){
            return 0;

        } else {
            int m = ((b+a)-1)/ 2;
            int maxLeft = maxSumFromTo(a, m);
            int maxRight = maxSumFromTo(m+1, b);
            int maxCenter = maxSumCenter(a, b);
            return Math.max(maxCenter, Math.max(maxLeft, maxRight));
        }
    }


    private int maxSumCenter(int a, int b) {

        int j = b;
        int i = a;
        int maxDiff = 0;

        for (; i < j ;i++){
            int k = i;
            int currentmax = 0;
            while(k < size()-1 && arr[k] < arr[k+1]){
                k++;
                currentmax = arr[k]-arr[i];
            }
            j--;
            if (currentmax > maxDiff){
                maxDiff = currentmax;
            }
        }

        return maxDiff;
    }

    public int maxInterval() {
        if (size() <= 0 || (size()==1 && arr[0] < 0)) {
            return -1;
        } else if (size()==1){
            return arr[0];
        } else {
            return maxSumFromTo(0,size());
        }
    }*/

    public int maxSumFromTo(int a, int b) {
        if (a == b)
            return 0;
        else {
            int m = ((b+a)-1) / 2;
            int maxLeft = maxSumFromTo(a, m);
            int maxRight = maxSumFromTo(m+1, b);
            int maxCenter = maxSumCenter(a, b);
            return Math.max(maxCenter, Math.max(maxLeft, maxRight));
        }
    }

    private int maxSumCenter(int a, int b) {

        int j = b;
        int i = a;
        int maxDiff = 0;

        for (; i < j ;i++){
            int k = i;
            int currentmax = 0;
            while(k < size()-1 && arr[k] < arr[k+1]){
                    k++;
                    currentmax = arr[k] - arr[i];
            }
            j--;
            if (currentmax > maxDiff){
                maxDiff = currentmax;
            }
        }

        return maxDiff;
    }

    public int maxInterval() {

        if(size() <= 0 || (size() == 1 && arr[0] < 0)){
            return -1;
        } else if(size() ==1) {
            return arr[0];
        } else{
            return maxSumFromTo(0,size());
        }
    }


    /**
     * Assignment 2 Question 3 Return the median value of an array.
     *
     * @return the median
     */

    public int median(){

        int median = quickselect(arr,0,size-1,(size-1)/2);

        return median;
    }

    private int partition(int[] array, int begin, int end) {
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


    public int quickselect(int[] array, int begin, int end, int median){

        int arrayIndex = partition(array, begin, end);

        if ( arrayIndex == median){
            return array[arrayIndex];
        } else if ( arrayIndex < median){
            return quickselect(array, arrayIndex+1, end, median);
        } else {
            return quickselect(array, begin, arrayIndex-1, median);
        }



    }

    public static void main(String[] args) {



    }
}

