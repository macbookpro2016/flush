package easy;

import java.util.Stack;

/**
 * @description:回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例?2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * idea:使用栈先进后出的特点将数字反转
 * 负数肯定不是回文因为对应的不是一个数字
 * 溢出条件有两个，一个是大于整数最大值MAX_VALUE，另一个是小于整数最小值MIN_VALUE，设当前计算结果为ans，下一位为pop。
 * 从ans * 10 + pop > MAX_VALUE这个溢出条件来看
 * 当出现 ans > MAX_VALUE / 10 且 还有pop需要添加 时，则一定溢出
 * 当出现 ans == MAX_VALUE / 10 且 pop > 7 时，则一定溢出，7是2^31 - 1的个位数
 * 从ans * 10 + pop < MIN_VALUE这个溢出条件来看
 * 当出现 ans < MIN_VALUE / 10 且 还有pop需要添加 时，则一定溢出
 * 当出现 ans == MIN_VALUE / 10 且 pop < -8 时，则一定溢出，8是-2^31的个位数
 *
 *
 * @author: mskj-fengzhihang
 * @create: 2020-08-13 15:17
 **/
public class HuiWenShu {

    public static boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x == 0) return true;
        boolean result = false;
        int origin = x;
        int last = 0;
        while (x > 0){
            if(last  > Integer.MAX_VALUE / 10){
                System.out.println("yichu1");
                return false;
            }else if(last  == Integer.MAX_VALUE / 10 && (x % 10) > Integer.MAX_VALUE % 10){
                System.out.println("yichu2");
                return false;
            }
            last = last * 10 + x % 10;
            x /= 10;
        }
        return last == origin;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(2147483647));
    }

}