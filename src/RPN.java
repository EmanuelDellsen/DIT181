import java.util.Stack;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RPN {
  private Stack<String> evaluationStack = new Stack<String>();
  private Stack<Integer> integerStack = new Stack<>();

  // Main input loop
  public void loop() {
    Scanner in = new Scanner(System.in);

    final String prompt = "> ";
    System.out.print(prompt);

    while (in.hasNext()) {
      String s = in.next();
      if (s.equals("quit") || s.equals("q")) {
        System.out.println("Quitting");
        break;
      }
      if (isValidInput(s) && !(integerStack.size() <= 1 && s.matches("[-+*/]"))) {
        System.out.println("Got a string: " + s);
        inputMethod(s);
        System.out.println(integerStack);
        System.out.print(prompt);
      } else if (integerStack.size() <= 1 && s.matches("[-+*/]")){
        System.out.println("You cannot use an operator at this point. Please use an integer.");
      } else {
        System.out.println("Please enter a digit or one of following math operators: + - / *");
      }
    }
    in.close();
  }

  public static boolean isValidInput(String input) {
    Pattern p = Pattern.compile("-[0-9]+|[0-9]+|[-+*/]");
    Matcher matcher = p.matcher(input);
    boolean matches = matcher.matches();
    return matches;
  }

  public void inputMethod(String s){

    final String ADDITION = "+";
    final String SUBTRACTION = "-";
    final String DIVISION = "/";
    final String MULTIPLICATION = "*";

    int firstPop;

    switch (s){

      case ADDITION:
        firstPop = integerStack.pop();
        integerStack.push((integerStack.pop()+firstPop));
        break;

      case SUBTRACTION:
        firstPop = integerStack.pop();
        integerStack.push(integerStack.pop()-firstPop);
        break;

      case DIVISION:
        if(integerStack.peek() == 0){
          System.out.println("Cannot divide by zero, please use another integer greater than zero");
          break;
        }
        firstPop = integerStack.pop();
        integerStack.push(integerStack.pop()/firstPop);
        break;

      case MULTIPLICATION:
        firstPop = integerStack.pop();
        integerStack.push(integerStack.pop() * firstPop);
        break;

      default:
        integerStack.push(Integer.valueOf(s));

    }
  }



  // Evaluate the stack and push the result back in the same stack
  public void evaluate() {
    System.out.println("Tokens: ");
    System.out.println(this.toString());
  }

  // To visualise the token stack
  public String toString() {
    StringBuilder res = new StringBuilder(integerStack.peek());
    return res.toString();
  }

  // For unit test purposes
  public void addToken(String token) {
    evaluationStack.add(token);
  }

  // For unit test purposes
  public Stack<String> getEvaluationStack() {
    Stack<String> copy = new Stack<String>();
    copy.addAll(evaluationStack);
    return copy;
  }


  public static void main(String[] args) {
    RPN calc = new RPN();
    calc.loop();
  }
}
