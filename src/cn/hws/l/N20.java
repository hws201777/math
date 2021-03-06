package cn.hws.l;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class N20 {
    /**
     * 20. 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * 示例 1:
     *
     * 输入: "()"
     * 输出: true
     * 示例 2:
     *
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     *
     * 输入: "(]"
     * 输出: false
     * 示例 4:
     *
     * 输入: "([)]"
     * 输出: false
     * 示例 5:
     *
     * 输入: "{[]}"
     * 输出: true
     */


    public boolean isValid(String s) {
        Map map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack stack = new Stack();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if(map.containsKey(chars[i])){
                if(stack.isEmpty() || !stack.pop().equals(map.get(chars[i]))) {
                    return false;
                }
            }else{
                stack.add(chars[i]);
            }
        }
        return stack.isEmpty();
    }
}
