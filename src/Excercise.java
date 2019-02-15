

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;


public class Excercise {
    public static ArrayList getStrings() {
        Scanner in = new Scanner(System.in);
        ArrayList<String> stringList = new ArrayList<String>();
        int itemsRead = 0;

        System.out.println("Enter strings, one per line; ");
        System.out.println("Terminate with empty line; ");

        while (in.hasNextLine()) {
            String oneLine = in.nextLine();
            if(oneLine.equals("")){
                break;
        }

            stringList.add(oneLine);
        }
        return stringList;
    }
//Resize a String[] array; return new array[]

    public static long factorial(int n){
        int x, c, fact = 1;
        if ( n < 0) {
            throw new IllegalArgumentException("Number should be non negative");
        } else{
            for ( c = 1 ; c <= n ; c++ )
            fact = fact * c;
        }
            return fact;
    }
    public static long factorialRec ( int n) {

        if ( n == 1) {
            return 1;
        }
        else {
            return factorialRec(n - 1) * n ;
        }

    }

    public static int binarySearch(int [] a, int x){
        int low = 0;
        int high = a.length - 1;
        int mid;
            while(low <= high) {
            mid = (low + high)/2;
            if(a[mid] <= x)
                low = mid +1;
            if(a[mid] >= x)
             high = mid -1;
            else
                return mid;
            }
        return  -1;
    }

    public static int binarySearchRec ( int [ ] a, int x, int low, int high) {

        low = 0;
        int mid = ( high - low ) /2;
        high = a.length-1;

            if (a[mid] == x) {
                return mid;
            }
             if(a[mid] >= x) {
                 return binarySearchRec(a, x, low, high = mid) ;
             }
            if(a[mid] <= x) {
                return binarySearchRec(a, x, low = mid, high) + mid;
            }

return -1;
    }

    public static int calcPolynomialInc(int x, int[] a) {
        int term= 1;
        int sum= a[0];
        for(int i= 1; i< a.length; i++) {
            term= term* x;
            sum+= a[i]*term;
        }
        return sum;
    }

    public static int calcPolynomialDec(int x, int[] a) {
        int base = x;
        int exponent = a.length-1;

        int term = 1;
        for (;exponent !=0;exponent--){
            term *= base;
        }

        int sum =  a[0] ;

        for(int i= a.length-1; i>0; i--) {
            sum += a[i] * term;
            term = term/x;
        }
        return  sum;
    }

    public static int calcPolynomialHorner (int x, int[]a, int n){

        int i = a.length-1;
        if ( n == i){
            return x * a[n];
        } else {
            int sum = x * (a[n] + calcPolynomialHorner(x, a, n+1)) ;
            if (n==1){
                sum += a[0];
            }
            return sum;
        }
    }

    public static BigInteger fib ( int n) {
        if ( n <= 1)
            return BigInteger.ONE;
        return fib ( n-1).add(fib ( n - 2));


    }

    public static int fibFast ( int n, int [] memory) {
        if (n <= 1) {
            return 1;
        } else {
           memory [0] = fibFast(n-2,memory);
           memory [1] = fibFast(n-1, memory);
           int sum = memory[0] + memory[1] ;
           memory[0] = memory[1];
           return sum;
        }
    }




 public static int calcPolynomialRec ( int x, int [] a ){

        int term=1;

        int n = a.length;

        if (n == 1) {
            term = term * x;
            return a [a.length-1] * term;
        } else {

            int [] tempA = a;
            //term = term * x * 1;

            return calcPolynomialRec(x, a );


        }
    }


        public static int maxContiguousSum (int [] array) {

            int maxSum = 0;
            int previous = array[0];
            for (int i = 1; i < array.length; i++) {
                if (previous <= 0) {
                    previous = array[0];
                } else {
                    previous += array[i];
                    maxSum = Math.max(previous, maxSum);
                }
            }
            return maxSum;
        }

        public static int maxSumRec (int [] a, int left, int right){

        int maxLeftBorderSum = 0;
        int maxRightBorderSum = 0;
        int leftBorderSum = 0;
        int rightBorderSum = 0;
        int center = (left + right) / 2;

        //base case
        if (left == right){
            return a[left] > 0 ? a[left] : 0;

            // T(1) = 1, this will always be called 1 time no matter size of N

            //if (a[left] > 0){
            //return a[left];
            // } else {
            //return 0;
            // }
        }
        int maxLeftSum = maxSumRec(a, left, center); // T(n/2) no matter size of N it still divides in 2
        int maxRightSum = maxSumRec(a, center + 1, right); // T(n/2) no matter size of N it still divides in 2
                // 2 * T(n/2) for the two T(n/2) recursive calls

            for (int i = center; i >= left; i--) {
                leftBorderSum += a[i];
            if (leftBorderSum > maxLeftBorderSum);
            maxLeftBorderSum = leftBorderSum;
            }    // both forloops run n/2 but the complexity is n/2 + n/2 = O(n)
            for (int i = center+1; i <= right; i++) {
                rightBorderSum += a[i];
                if (rightBorderSum > maxRightBorderSum);
                maxRightBorderSum = rightBorderSum;
            }

            return Math.max(maxLeftSum, Math.max(maxRightSum, (maxLeftBorderSum + maxRightBorderSum)));

            // T(1) = 1 for n = 1 (BASE CASE)
            // T(n) = 2T(n/2) + 0(n)
            // => T(n) = nlogn + n

        }



    public static void main(String[] args) {

 ArrayList<String> myArrayList= getStrings();
            System.out.println(myArrayList);


       int [] a =  {1,2,3,4,4,3,2,5,5,6,6,2,4,2,4,3,3,2,3,5,4,4,3,5,3,5,3,5,3,4,3,4,3,2,1,1,2} ;
       //binarySearchRec(a,4, 0,6 );


        int [] memory = new int [2];
        System.out.println(calcPolynomialInc(3, a));
        System.out.println(calcPolynomialDec(3, a));
        System.out.println(calcPolynomialHorner(3,a,1));


        System.out.println(fib(0));
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(5));
        System.out.println(fib(6));
        System.out.println(fib(7));
        System.out.println(fib(8));

        System.out.println(fibFast(0, memory));
        System.out.println(fibFast(1, memory));
        System.out.println(fibFast(2, memory));
        System.out.println(fibFast(3, memory));
        System.out.println(fibFast(4, memory));
        System.out.println(fibFast(5, memory));
        System.out.println(fibFast(6, memory));
        System.out.println(fibFast(7, memory));
        System.out.println(fibFast(8, memory));




    }
}
