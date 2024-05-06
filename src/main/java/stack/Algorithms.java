package stack;

import java.util.Stack;

public class Algorithms {
    // Built in stack data structure
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();  // is also generic
        // we will use function names to roughly emulate the runtime stack

        System.out.println("START main");
        stack.push("main");

        System.out.println("START builder");
        stack.push("builder");

        System.out.println("START external-service");
        stack.push("external-service"); // print END with whatever function is ending its execution
        // once we get a response back, the execution for external service will be finished.
        System.out.println("END " + stack.pop());

        // then we parse the response
        System.out.println("START parse-external-data");
        stack.push("parse-external-data");

        System.out.println("END " + stack.pop()); // finished parsing
        System.out.println("END " + stack.pop()); // also conclude the builders function so we pop it off.
        System.out.println("END " + stack.pop()); // pop main method

        // If an error ever occurred in the program, the stack would help us find out exactly where the error occurred.
        // Since it keeps track of the state of the program.

        // stack.peek(): peeks the top of the stack without removing the item.

        System.out.println("PRINT NEXT GREATER ELEMENT FUNCTION ");
        printNextGreaterElement(new int[]{16,7,2,15});


        // Has Matching Parentheses function
        System.out.println();
        System.out.println("HAS MATCHING PARENTHESES FUNCTION");

        System.out.println(hasMatchingParentheses("((algorithm()))"));
        System.out.println(hasMatchingParentheses("()(algorithm())"));
        System.out.println(hasMatchingParentheses("((algorithm))"));
        System.out.println(hasMatchingParentheses("(algorithm)"));

        System.out.println();

        System.out.println(hasMatchingParentheses("(algorithm("));
        System.out.println(hasMatchingParentheses(")algorithm)"));
        System.out.println(hasMatchingParentheses(")algorithm("));
        System.out.println(hasMatchingParentheses("algorithm(("));
        System.out.println(hasMatchingParentheses("(algorithm"));
        System.out.println(hasMatchingParentheses("((algorithm)"));



    }

    public static void printNextGreaterElement(int[] arr) {
        // check base case
        if (arr.length == 0) {
            System.out.println();
            return;
        }
        // If the array has items, initialise stack and push the first element
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);

        for (int i = 0; i < arr.length; i++) {
            // checking whether the current item in the array is the next greater element for the item
            // at the top of the stack
            // if it is, display it to the console
            // no matter what, we want to push this next element onto the stack.
            int next = arr[i]; // could hold the next greater element for multiple items in the stack
            if (!stack.isEmpty()){
                int popped = stack.pop();
                while(popped < next) {
                    System.out.println(popped + " --> " + next );
                    if(stack.isEmpty()) {
                        break;
                    }
                    popped = stack.pop(); // next item in the stack
                }
                if (popped > next) {
                    // if popped element is greater then next element
                    // push it back onto the stack
                    stack.push(popped);
                }

            }
            stack.push(next); // so we can find its next greater element
        }

        // At this point, we have printed out all items that have a next greater element
        // current items in the stack are the items that do not have a next greater element.
        // empty stack and print, display each items next as -1

        while(!stack.isEmpty()) {
            System.out.println(stack.pop() + " --> " + -1);
        }

        // In this, the assumption of the next greater element always being to the right, played a
        // significant role in our implementation

    }

    // Returns true or false depending on depending on whether the parentheses are matching
    public static boolean hasMatchingParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        // stack will keep track of the opening characters we have seen
        // pop stack if we run into a closing character
        // if stack is not empty by the end of the execution, there must be more opening than closing symbols

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(') {
                stack.push(current);
            } else if (current == ')') {
                // make sure there is an opening symbol associated with it
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false; // parentheses are not matching
                }

            }
        }

        return stack.isEmpty();

    }

    public static boolean hasMatchingParenthesesInt(String s) {
        // we can use an integer instead of a stack
        // since we are only dealing with one symbol type
        int matchingSymbolTracker = 0;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(') {
                matchingSymbolTracker++;
            } else if (current == ')') {
                // make sure there is an opening symbol associated with it
                if (matchingSymbolTracker > 0) {
                    matchingSymbolTracker--;
                } else {
                    return false; // parentheses are not matching
                }

            }
        }
        return matchingSymbolTracker == 0;
        //O(n) times
        // O(1) space, more efficient.
    }






}
