package easy;

import java.util.Stack;

/**
 * @description:
 * ������ת
 * ����һ�� 32 λ���з�������������Ҫ�����������ÿλ�ϵ����ֽ��з�ת��
 *
 * ʾ��?1:
 *
 * ����: 123
 * ���: 321
 * ?ʾ�� 2:
 *
 * ����: -123
 * ���: -321
 * ʾ�� 3:
 *
 * ����: 120
 * ���: 21
 * ע��:
 *
 * �������ǵĻ���ֻ�ܴ洢���� 32 λ���з���������������ֵ��ΧΪ?[?231,? 231?? 1]�������������裬�����ת�����������ô�ͷ��� 0��
 *
 *
 * idea��ʹ��stack��filoԭ�����洢�������10��n�η���ʵ��
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