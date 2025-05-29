package leetcode.roadmap._8_queue_and_stack;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class _6_1249_MinimumRemoveToMakeValidParentheses {

    public static void main(String[] args) {
//        String s = "lee(t(c)o)de)";
        String s = "a)b(c)d";
//        String s = "))((";
        System.out.println(minRemoveToMakeValid(s));
    }

    /*
    cnt = 1+1-1-1
    notClosedIndex = 3, 5,
    setToRemove =
    l
    e
    e
    (
    t
    (
    c
    )
    o
    )
    d
    e
     */
    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> notClosedIndex = new Stack<>();
        Set<Integer> indxToRemove = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                notClosedIndex.push(i);
            }
            if (ch == ')') {
                if (notClosedIndex.isEmpty()){
                    indxToRemove.add(i);
                } else {
                    notClosedIndex.pop();
                }
            }
        }

        while (!notClosedIndex.isEmpty()){
            indxToRemove.add(notClosedIndex.pop());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if (!indxToRemove.contains(i)){
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
