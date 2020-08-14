package easy;

/**
 * @description:�����ǰ׺
 * ��дһ�������������ַ��������е������ǰ׺��
 *
 * ��������ڹ���ǰ׺�����ؿ��ַ���?""��
 *
 * ʾ��?1:
 *
 * ����: ["flower","flow","flight"]
 * ���: "fl"
 * ʾ��?2:
 *
 * ����: ["dog","racecar","car"]
 * ���: ""
 * ����: ���벻���ڹ���ǰ׺��
 * ˵��:
 *
 * ��������ֻ����Сд��ĸ?a-z?��
 *
 * idea:�����бȽϷ�
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
                // ��ͷ����β
                end = j + 1;
            }
        }
        return example.substring(start, end);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"a","b"}));
    }
}