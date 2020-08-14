package easy;

/**
 * @description:最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串?""。
 *
 * 示例?1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例?2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母?a-z?。
 *
 * idea:纵向列比较法
 * @author: mskj-fengzhihang
 * @create: 2020-08-14 10:18
 **/
public class MaxGongGongQianZhui {

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length < 1){
            return "";
        }
        if(strs.length == 1) return strs[0];
        for(int i = 0; i < strs.length; i++){
            if(strs[i].length() == 0) return "";
        }
        int start = 0,end = 0;
        boolean matched = true;
        String example = strs[0];
        for(int j = 0; ; j++){
            for (int k = 1; k < strs.length; k++){
                if(j >= strs[k].length() || j >= example.length() || strs[k].charAt(j) != example.charAt(j)){
                    matched = false;
                    break;
                }
            }
            if(!matched){
                end = j;
                break;
            }else {
                // 含头不含尾
                end = j + 1;
            }
        }
        return example.substring(start, end);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"a","b"}));
    }
}