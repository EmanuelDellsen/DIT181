import java.math.BigInteger;

public class Fibonacci {
  // A naive implementation
  public static BigInteger fib ( int n, BigInteger [] memory) {
    if (n <= 1) {
      return BigInteger.ONE;
    } else {
      memory [0] = fib(n-2,memory);
      memory [1] = fib(n-1, memory);
      BigInteger sum = memory[0].add(memory[1]) ;
      memory[0] = memory[1];
      return sum;
    }
  }

  public static void main(String[] args) {
    for (int i = 0; i < 201; i++) {
    }
  }

}
