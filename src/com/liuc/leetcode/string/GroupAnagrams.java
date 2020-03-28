package com.liuc.leetcode.string;

import java.util.*;

/**
 * leetcode no.49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> maps = new HashMap<>();
        for (String str : strs) {
            // 将当前字符串进行排序处理
            String sortStr = getStringSort(str);
            // 如果在map中不存在，则先插入一个key和一个空的value
            if (!maps.containsKey(sortStr)) maps.put(sortStr,new ArrayList<>());
            maps.get(sortStr).add(str);
        }
        // 将map为结果输出
        for (String s : maps.keySet()) result.add(maps.get(s));
        return result;
    }

    private String getStringSort(String str) {
        char[] ss = str.toCharArray() ;
        Arrays.sort(ss) ;
        return String.valueOf(ss) ;
    }



    /*public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        groupAnagrams(result,strs,new ArrayList<Integer>(),0);
        return result;
    }

    private void groupAnagrams(List<List<String>> result, String[] strs, ArrayList<Integer> integers, int index) {

        for (int i = index; i < strs.length; i++) {

        }
    }*/

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = new GroupAnagrams().groupAnagrams(strs);
        System.out.println(result);

    }
}
