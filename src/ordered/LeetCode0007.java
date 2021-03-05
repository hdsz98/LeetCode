package ordered;
/*
    Easy
        给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。

        如果反转后整数超过 32 位的有符号整数的范围[−2^31, 2^31− 1] ，就返回 0。

        假设环境不允许存储 64 位整数（有符号或无符号）。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/reverse-integer
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode0007 {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            res = res * 10 + x % 10;
        }
        return res;
    }
}
