package com.liuc.leetcode.recursion;

import java.util.Stack;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 示例:
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
public class DecodeString {
    public String decodeString(String s) {
        Stack<String> stack=new Stack<String>();
        String result="";
        for (int i = 0;i<s.length();i++){
            if (s.charAt(i)==']'){
                String str1 = "";
                while (!"[".equals(stack.peek())){
                    str1 = stack.pop() + str1;
                }
                stack.pop();
                String sum = "";
                while ((!stack.isEmpty())&&(stack.peek().charAt(0) >='0'&& stack.peek().charAt(0) <='9')){
                    sum = stack.pop()+sum;
                }
                int count = Integer.parseInt(sum);
                String str2 ="";
                for (int j = 0;j<count;j++){
                    str2 = str2 + str1;
                }
                stack.push(str2);
            }else {
                String str = ""+s.charAt(i);
                stack.push(str);
            }
        }
        while(!stack.isEmpty()) {
            result=stack.pop()+result;
        }
        return result;
    }

    public static void main(String[] args) {
        new DecodeString().decodeString("100[leetcode]");
    }
}
