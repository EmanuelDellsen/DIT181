
public class Recursion {

    /**
     * Hands-on session 3 Exercise 1a returns the factorial of n, uses recursion
     *
     * @param n the number to calculate the factorial on
     * @return the factorial of n
     */
    public static int factorial(int n) {

        if (n == 0){
            return 1;
        } else {
            return n * factorial(n - 1);
        }
       // throw new UnsupportedOperationException();
    }


    /**
     * Hands-on session 3 Exercise 1b reverts a string
     *
     * @param word the string to revert
     * @return the reverted string
     */
    public static String reverse(String word) {


       if( word.length() == 1 ) {
           return word;

       } else {
           char lastLetter = word.charAt(word.length()-1);
           String last = String.valueOf(lastLetter);

           return last.concat( reverse(word.substring(0,word.length()-1)));



       }

      //  throw new UnsupportedOperationException();
    }

    /**
     * Hands-on session 3 Exercise 1c repeats the input string n times
     *
     * @param n the amount of repetitions
     * @param word the string to repeat
     * @return a string containing word repeated n times
     */
    public static String repeat(int n, String word) {

        if ( n == 1){
            return word;
        } else {
            word = word.concat(repeat(n-1,word));
            return word;
        }

       // throw new UnsupportedOperationException();
    }

    /**
     * Hands-on session 3 Exercise 1d checks if a string contains a character
     *
     * @param word the string to check
     * @param letter the letter to find
     * @return true if character is found in string
     */
    public static Boolean contains(String word, char letter) {

        if (word.charAt(0) == letter) {
            return true;
        }
        if (word.length() > 1) {
            return contains(word.substring(1), letter);
        } else {
            return false;

            // throw new UnsupportedOperationException();
        }
    }

    /**
     * Hands on Session 3 Exercise 2 Return the maximum sum of all contiguous
     * subarrays of the array.
     *
     * @param array the array
     * @param lo the index of the low boundary of the subarray
     * @param hi the index of the high boundary of the subarray
     * @return the sum of the subarray
     */
    public static int maxSubarraySum(int[] array, int lo, int hi) {

        throw new UnsupportedOperationException();
    }

    /**
     * Hands-on session 3 Exercise 3 The towers of Hanoi Watch the videos linked
     * in the description of this problem.
     *
     * @param n amount of discs
     * @param sourcePole
     * @param destinationPole
     * @param auxiliaryPole
     */
    static void tower(int n, char sourcePole, char destinationPole, char auxiliaryPole) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {


        int[] arr = {2, -8, 1, 7, 1, 8, 2};
        int n = arr.length;

        System.out.println(factorial(5));
        System.out.println(reverse("Paris"));

        System.out.println(repeat(5,"Hej Niklas"));
        System.out.println(contains("Hej", 'e'));
    }

}
