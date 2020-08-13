package medium;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * �ַ���ת������
 * ������ʵ��һ��?atoi?������ʹ���ܽ��ַ���ת����������
 *
 * ���ȣ��ú����������Ҫ�������õĿ�ͷ�ո��ַ���ֱ��Ѱ�ҵ���һ���ǿո���ַ�Ϊֹ����������ת���������£�
 *
 * �����һ���ǿ��ַ�Ϊ�����߸���ʱ���򽫸÷�����֮���澡���ܶ�����������ַ�����������γ�һ���з���������
 * �����һ���ǿ��ַ������֣���ֱ�ӽ�����֮�������������ַ�����������γ�һ��������
 * ���ַ�������Ч����������֮��Ҳ���ܻ���ڶ�����ַ�����ô��Щ�ַ����Ա����ԣ����ǶԺ�����Ӧ�����Ӱ�졣
 * ע�⣺������ַ����еĵ�һ���ǿո��ַ�����һ����Ч�����ַ����ַ���Ϊ�ջ��ַ����������հ��ַ�ʱ������ĺ�������Ҫ����ת�������޷�������Чת����
 *
 * ���κ�����£����������ܽ�����Ч��ת��ʱ���뷵�� 0 ��
 *
 * ��ʾ��
 *
 * �����еĿհ��ַ�ֻ�����ո��ַ� ' ' ��
 * �������ǵĻ���ֻ�ܴ洢 32 λ��С���з�����������ô����ֵ��ΧΪ?[?231,? 231?? 1]�������ֵ���������Χ���뷵�� ?INT_MAX (231?? 1) ��?INT_MIN (?231) ��
 *
 * @author: mskj-fengzhihang
 * @create: 2020-08-11 17:23
 **/
public class ZhuanHuanZhengShu {

    public static int solution(String str){
        if(str==null || str.length()<=0) return 0;
        //�������������Сֵ
        int MAX=Integer.MAX_VALUE,MIN=Integer.MIN_VALUE;
        int res=0,index=0;
        //���˿ո�
        while(index<str.length()&&str.charAt(index)==' ')index++;
        if(index==str.length()) return 0;
        //ȡ������
        char firstChar=str.charAt(index);
        boolean positive=true;
        if(!isDigit(firstChar)){
            if(firstChar!='+'&&firstChar!='-') return 0;
            index++;
            positive = firstChar!='-';
        }
        //�ø��������������ı߽磬�����������
        //���� -2147483647
        //���� -2147483648
        int limit=positive?-MAX:MIN;
        //����0
        while(index<str.length()&&str.charAt(index)=='0')index++;
        //ȡÿһλ,�ڷ��ַ���ֹ
        while(index<str.length()&&isDigit(str.charAt(index))){
            int digit=str.charAt(index++)-'0';
            if(res<(limit+digit)/10){
                return positive?MAX:MIN;
            }
            //�����res>=limit
            res=res*10-digit; //�ü���
        }
        return positive?-res:res;
    }

    public static boolean isDigit(char c){
        return c>='0' && c<='9';
    }

    public static void main(String[] args) {
        System.out.println(solution("+21321"));
    }

}