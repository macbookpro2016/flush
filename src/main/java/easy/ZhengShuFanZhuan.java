package easy;

import java.util.Stack;

/**
 * @description:
 * 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例?1:
 *
 * 输入: 123
 * 输出: 321
 * ?示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为?[?231,? 231?? 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 *
 * idea：使用stack的filo原则来存储数据配合10的n次放来实现
 *
 * @author: mskj-fengzhihang
 * @create: 2020-08-11 16:05
 **/
public class ZhengShuFanZhuan {

    public static int solution(int x){
        int fushu = 1;
        int result = 0;
        if (x < 0){
            x *= -1;
            fushu = -1;
        }
        Stack stack = new Stack();
        int maxi = 0;
        for(; x > 0; x = x / 10 ){
            stack.push(x % 10);
            maxi ++;
        }
        for(int j = 0; j < maxi ; j ++){
            int y = (Integer)stack.pop();
            if(Integer.MAX_VALUE - result < y * Math.pow(10 , j)){
                result = 0;
                break;
            }else {
                result += y * Math.pow(10 , j);
            }
        }
        result = result * fushu;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(1534236469));
//        System.out.println(Integer.MAX_VALUE + 2);
    }

}