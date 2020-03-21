package com.liuc.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode no.17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明：
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class LetterCombinations {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    // 回溯算法
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() != 0)
            letterCombinations("", digits, result);
        return result;
    }

    private void letterCombinations(String curr_digit, String digits, List<String> result) {
        if (digits.length() == 0) {
            result.add(curr_digit);
        } else {
            String digit = digits.substring(0, 1);
            String curr_phones = phone.get(digit);
            for (int i = 0; i < curr_phones.length(); i++) {
                String curr_phone = phone.get(digit).substring(i,i+1);
                letterCombinations(curr_digit+curr_phone,digits.substring(1),result);
            }
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(new LetterCombinations().letterCombinations(digits));
    }
}
