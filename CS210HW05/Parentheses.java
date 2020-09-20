
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Parentheses {
    // Return true if s has matching parentheses, and false otherwise.
    private static boolean match(String s) {
        Stack<Character> stack = new Stack<Character>();


        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
            {
                stack.push(s.charAt(i));
            }
            else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) return false;
                if (stack.pop() != '(') return false;
                }
                else if (s.charAt(i) == '}') {
                if (stack.isEmpty()) return false;
                if (stack.pop() != '{') return false;
                }
                else if (s.charAt(i) == ']') {
                if (stack.isEmpty()) return false;
                if (stack.pop() != '[') return false;
                }
        }
        return stack.isEmpty();
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        StdOut.println(match(StdIn.readAll().trim()));
    }
}