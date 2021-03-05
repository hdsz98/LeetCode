package ordered;
/*
    easy
        编写一个函数来查找字符串数组中的最长公共前缀
 */
public class LeetCode0014 {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 0)
            return "";
        String res = strs[0];
        for (int i = 1; i < n; i++){
            while (!strs[i].startsWith(res)) {
                if (res.length() == 0)
                    return "";
                res = res.substring(0, res.length() - 1);
            }
        }
        return res;
    }
}
