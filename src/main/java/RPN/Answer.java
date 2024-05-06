package RPN;

import java.util.Stack;

public class Answer {

    private static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isOperator(String token) {
        return "+-*/".contains(token);
    }

    private static double performOperation(String operator, double operand1, double operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    // Return the result of the Reverse Polish notation expression
    static double evaluateRPN(String expression) {

        // a given operation can only have two operands or two inputs, intead of a stack
        // we could also use variables to keep track of the intermediate data and operands. Takes less space, harder to read and understand

        // base case
        if (expression == null || expression == "" ) {
            return 0;
        }

        // keep track of eac number until we see the operator
        Stack<Double> stack = new Stack<>();
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if (isNumber(token)) {
                // push it onto the stack
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                // pop from stack
                double operand2 = stack.pop();
                double operand1 = stack.pop();

                double result = performOperation(token, operand1, operand2);
                stack.push(result);

            }
        }

        return stack.pop();
    }


    public static void main(String[] args) {
        System.out.println(evaluateRPN("3 4 +"));
        System.out.println(evaluateRPN(""));
        System.out.println(evaluateRPN("3 4 + 2 *"));
        System.out.println(evaluateRPN("3 4 + 2 * 7 /"));
    }


}
