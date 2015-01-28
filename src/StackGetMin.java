import java.util.Stack;

/**
 * Created by dheeraj on 28/1/15.
 */
public class StackGetMin {
    private Stack<Integer> mainStack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    private int getMin(){
        return minStack.peek();
    }

    private void push(int n){
        mainStack.push(n);
        minStack.push(Math.min(n,minStack.peek()));
    }

    private int pop(){
        minStack.pop();
        return mainStack.pop();
    }



}
