package easy;

import java.util.Stack;

/**
 * @description:������
 * �ж�һ�������Ƿ��ǻ���������������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������
 *
 * ʾ�� 1:
 *
 * ����: 121
 * ���: true
 * ʾ��?2:
 *
 * ����: -121
 * ���: false
 * ����: �������Ҷ�, Ϊ -121 �� ���������, Ϊ 121- �����������һ����������
 * ʾ�� 3:
 *
 * ����: 10
 * ���: false
 * ����: ���������, Ϊ 01 �����������һ����������
 * ����:
 *
 * ���ܲ�������תΪ�ַ�����������������
 *
 * idea:ʹ��ջ�Ƚ�������ص㽫���ַ�ת
 * �����϶����ǻ�����Ϊ��Ӧ�Ĳ���һ������
 * ���������������һ���Ǵ����������ֵMAX_VALUE����һ����С��������СֵMIN_VALUE���赱ǰ������Ϊans����һλΪpop��
 * ��ans * 10 + pop > MAX_VALUE��������������
 * ������ ans > MAX_VALUE / 10 �� ����pop��Ҫ��� ʱ����һ�����
 * ������ ans == MAX_VALUE / 10 �� pop > 7 ʱ����һ�������7��2^31 - 1�ĸ�λ��
 * ��ans * 10 + pop < MIN_VALUE��������������
 * ������ ans < MIN_VALUE / 10 �� ����pop��Ҫ��� ʱ����һ�����
 * ������ ans == MIN_VALUE / 10 �� pop < -8 ʱ����һ�������8��-2^31�ĸ�λ��
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