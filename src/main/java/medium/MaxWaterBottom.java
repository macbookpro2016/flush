package medium;

/**
 * @description:盛水最多的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 *
 * idea：双指针法：
 *      从两侧开始，，所以根据初始两侧数据，
 *      由于向内移动必定会导致底边变短，且面积取决于短板的长度，向内移动较短一侧，可能下一个短板比较长使得面积变大，
 *      移动长板一侧则短板长度不变（或者变为移动过后更短的）；所以移动短板一侧不断更新面积直到j=i时，得到最大的面积时多少
 * @author: mskj-fengzhihang
 * @create: 2020-08-13 16:47
 **/
public class MaxWaterBottom {

    public static int maxArea(int[] height) {
        if(height == null || height.length < 2) return 0;
        if(height.length == 2) return Math.min(height[0], height[1]);
        int max = 0;
        int i =0,j = height.length - 1;
        boolean continued = false;
        while (j > i){
            // 判断这个可以省略，为了节省一次计算，要进行逻辑判断反而3ms -> 4ms 就是说这次挡板相同，移动一次后一定小于这次因为底变短了，高还是最长这次
            if(continued){
                i ++;
                continued = false;
                continue;
            }
            if(height[j] == height[i]) {
                continued = true;
            }
            max = Math.max((j - i) *
                            (height[j] > height[i] ? height[i++] : height[j--]),
                    max);

        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,3,2,5,25,24,5}));
    }

}