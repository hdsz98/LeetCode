package com.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Medium
        给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：

        每次转换只能改变一个字母。
        转换后得到的单词必须是字典中的单词。
        说明:

        如果不存在这样的转换序列，返回一个空列表。
        所有单词具有相同的长度。
        所有单词只由小写字母组成。
        字典中不存在重复的单词。
        你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 */
public class LeetCode0126 {
    List<List<String>> res = new ArrayList<>();
    public int min = Integer.MAX_VALUE;
    List<String> path = new ArrayList<>();
    int[] flag = null;
    public boolean judge(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (count > 0)
                    return false;
                count++;
            }
        }
        return true;
    }

    public void backtrack (String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            if (path.size() == min) {
                res.add(new ArrayList<>(path));
                return;
            }
            else if (path.size() < min) {
                res.clear();
                res.add(new ArrayList<>(path));
                min = path.size();
                return;
            }
        }
        for (int i = 0; i < wordList.size(); i++) {
            if (flag[i] == 0 && judge(beginWord, wordList.get(i))) {
                path.add(wordList.get(i));
                flag[i] = 1;
                backtrack(wordList.get(i), endWord, wordList);
                path.remove(path.size() - 1);
                flag[i] = 0;
            }
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        int flag2 = 0;
        for (int i = 0; i < n; i++) {
            if (endWord.equals(wordList.get(i))) {
                flag2 = 1;
                break;
            }
        }
        if (flag2 == 0)
            return res;
        flag = new int[n];
        path.add(beginWord);
        for (int i = 0; i < n; i++) {
            if (judge(beginWord, wordList.get(i))) {
                path.add(wordList.get(i));
                flag[i] = 1;
                backtrack(wordList.get(i), endWord, wordList);
                path.remove(path.size() - 1);
                flag[i] = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] s = {"hot","dot","dog","lot","log","cog"};
        List<List<String>> res = new LeetCode0126().findLadders("hit", "cog", Arrays.asList(s));
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++)
                System.out.print(res.get(i).get(j) + " ");
            System.out.println(" ");
        }
    }
}
