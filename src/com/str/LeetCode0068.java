package com.str;

import java.util.ArrayList;
import java.util.List;

/*
    Hard
        给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。

        你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。

        要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。

        文本的最后一行应为左对齐，且单词之间不插入额外的空格。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/text-justification
 */
public class LeetCode0068 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        int low = 0;
        while (low < n) {
            int len = words[low].length();
            if (len == maxWidth) {
                res.add(words[low]);
                low++;
                continue;
            }
            if (low == n - 1) {
                for (int i = 0; i < maxWidth - len; i++)
                    words[low] += " ";
                res.add(words[low]);
                low++;
                continue;
            }
            int sum = len, sum_word = len, high = low + 1, count = 1;
            while (high < n) {
                if (sum + words[high].length() + 1 <= maxWidth) {
                    sum += words[high].length() + 1;
                    sum_word += words[high].length();
                    count++;
                    high++;
                }
                else
                    break;
            }
            String temp = "";
            if (count == 1) {
                temp += words[low];
                for (int i = 0; i < maxWidth - words[low].length(); i++)
                    temp += " ";
                res.add(temp);
                low++;
                continue;
            }
            if (high >= n) {
                for (int i = low; i < high; i++){
                    if (i < high - 1)
                        temp += words[i] + " ";
                    else
                        temp += words[i];
                }
                int len_temp = temp.length();
                for (int i = 0; i < maxWidth - len_temp; i++)
                    temp += " ";
                res.add(temp);
                low = high;
                continue;
            }
            int space = (maxWidth - sum_word) / (count - 1);
            int more = (maxWidth - sum_word) % (count - 1);
            for (int i = 0; i < high - low; i++) {
                temp += words[low + i];
                if (i != high - low - 1) {
                    if (i < more) {
                        for (int j = 0; j < space + 1; j++)
                            temp += " ";
                    } else {
                        for (int j = 0; j < space; j++)
                            temp += " ";
                    }
                }
            }
            res.add(temp);
            low = high;
        }
        return res;
    }
    public static void main(String[] args) {
        String[] words = {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
        List<String> res = new LeetCode0068().fullJustify(words, 16);
        for (int i = 0; i < res.size(); i++)
            System.out.println(res.get(i));
    }
}
