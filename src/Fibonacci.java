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

  public static BigInteger fib ( int n){
    BigInteger n2 = BigInteger.ONE;
    BigInteger n1 = BigInteger.ONE;
    BigInteger temp;

    for (int i = n; i >2; i--){
      temp = n2;
      n2 = n1;
      n1 = n1.add(temp);
    }
    return n2.add(n1);
  }

  public static void main(String[] args) {
    for (int i = 0; i < 201; i++) {
    }
  }

}
