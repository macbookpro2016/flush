package medium;

/**
 * @description:
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 * @author: mskj-fengzhihang
 * @create: 2020-08-06 14:38
 **/

/**
 * idea：从第一个字符开始，从后向前遍历第一次找到这个字符时停下开始依次比较距离第一个和最后一个字符相同距离的字符是否相等，若有不想等的继续向前滑动
 * 当剩余的长度小于已存在的最大回文长度时，停止
 * 每次循环时若已经小于等于当前最大长度时，停止
 * 若没有回文则返回第一个字符
 */
public class MaxHuiWen {


    public static String solution(String s){
        if(null == s || s.equals("")){
            return "";
        }
        int maxStart = 0;
        int maxEnd = 0;
        int maxLen = 0;
        int sLength = s.length();
        for(int i = 0; i < sLength; i ++){
            if(maxLen > sLength - i){
                break;
            }
            int j = sLength - 1;
            for(; j > i && (j - i + 1) > maxLen; j--){
                // 判断是否是回文
                if(s.charAt(i) == s.charAt(j)){
                    boolean matched = true;
                    int n = 1;
                    while ((j - i) != 1 && (i + n) < (j - n)){
                        matched = s.charAt(i + n) == s.charAt(j - n);
                        if(!matched){
                            break;
                        }
                        n ++;
                    }
                    if(matched){
                        maxStart = i;
                        maxEnd = j;
                        maxLen = j - i + 1;
                        break;
                    }
                }else {
                    continue;
                }
            }
        }
        // 含头不含尾
        return s.substring(maxStart, maxEnd + 1);
    }

    public static void main(String[] args) {
        String s = solution("aaaa");
        System.out.println(s);
    }
}