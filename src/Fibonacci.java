import java.lang.reflect.Array;
import java.math.BigInteger;

public class Fibonacci {
  // A naive implementation

  static BigInteger storedValue = BigInteger.ZERO;

  static BigInteger [] memory = new BigInteger[2];

  public static int fibonacci ( int n, int [] memory) {
    if (n <= 1) {
      return 1;
    } else {
      memory [0] = fibonacci(n-2,memory);
      memory [1] = fibonacci(n-1, memory);
      int sum = memory[0] + memory[1] ;
      memory[0] = memory[1];
      return sum;
    }
  }

  public static BigInteger fib ( int n ){

    if (n <= 1){
      storedValue = BigInteger.ZERO;
      return BigInteger.ONE.multiply(BigInteger.valueOf(n));
    } else {
      BigInteger valueAtN = fib(n-1);
      BigInteger previous = storedValue;
      storedValue = valueAtN;
      return valueAtN.add(previous);
    }
  }

  public static BigInteger fibCrack ( int n) {
    if (n <= 2) {
      memory[1] = BigInteger.ONE;
      return BigInteger.ONE;
    } else {

      memory [0] = fibCrack(n-1);
      memory [1].add(memory[0]);

      return memory[0].add(memory[1]);
    }
  }

  public static BigInteger fib3 ( int n) {
    if (n <= 1) {
      return BigInteger.ONE;

    } else {
      BigInteger [] memory2 = new BigInteger[2];
      memory2[0] = fib3(n-1);
      memory2[1] = memory2[0];

      if (memory2[1].equals(BigInteger.ONE)){
        return memory2[0].add(memory2[1]);
      }
      return memory2[0].add(memory2[1]).subtract(BigInteger.ONE);
    }
  }


  /*public static BigInteger fib ( int n){
    BigInteger n2 = BigInteger.ZERO;
    BigInteger n1 = BigInteger.ONE;
    BigInteger temp;

    if (n == 0){
      return BigInteger.ZERO;
    }

    if (n == 1){
      return BigInteger.ONE;
    }

    for (int i = n; i > 2; i--){
      temp = n2;
      n2 = n1;
      n1 = n1.add(temp);
    }
    return n2.add(n1);
  }*/

  public static void main(String[] args) {

    System.out.println(fib(1));
    System.out.println(fib(2));

    System.out.println(fib(3));

    System.out.println(fib(4));

    System.out.println(fib(5));



  }

}
