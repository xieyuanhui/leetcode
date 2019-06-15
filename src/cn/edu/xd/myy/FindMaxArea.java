package cn.edu.xd.myy;

/**
 * @author myy
 * @date 2019/6/15
 *
 * https://leetcode.com/problems/container-with-most-water/
 * q11 找出最大区域
 */
public class FindMaxArea {
    /**
     * 暴力法遍历数组，找出最大的区域
     * @param height
     * @return
     */
    public int maxArea(int[] height){
        int maxarea=0;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                maxarea=Math.max(maxarea,Math.min(height[i],height[j])*(j-i));
            }
        }
        return maxarea;
    }

    /**
     * 由于影响最大区域的主要因素是两条直线中的较短者，设置两个指针，分别指向头和尾
     * 每一次更新maxarea时，将较短直线的指针前内一步
     * @param height
     * @return
     */
    public int maxArea2(int[] height){
        int maxarea =0;
        int left =0;
        int right =height.length-1;
       while(left<right){
            maxarea = Math.max(maxarea,Math.min(height[left],height[right])*(right-left));
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
       return maxarea;
    }
}
