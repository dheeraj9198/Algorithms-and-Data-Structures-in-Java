package LeetCode;

import java.util.Stack;

/**
 * Created by dheeraj on 19/1/15.
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}"
 * are all valid but "(]" and "([)]" are not.
 */
public class ValidParenthesis {

    private char reverse(Character i){
        if(i == '(')return  ')';
        if(i == '{')return '}';
        if(i == '[')return ']';
        return '.';
    }

    public boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<Character>();
        for(int i = 0;i<s.length();i++){
            if (characterStack.isEmpty()){
                characterStack.add(s.charAt(i));
            }else{
                if(s.charAt(i)  == reverse(characterStack.peek())){
                    characterStack.pop();
                }else{
                    characterStack.add(s.charAt(i));
                }
            }
        }
        if(characterStack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        ValidParenthesis validParenthesis = new ValidParenthesis();
        System.out.println(validParenthesis.isValid("()"));
    }
}
