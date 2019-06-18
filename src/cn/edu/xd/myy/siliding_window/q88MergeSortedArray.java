package cn.edu.xd.myy.siliding_window;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 * q88
 *
 * 合并两个排序的 数组，尾插法，数组1的大小足够大能够放下num1和num2的所有数字
 * @author myy
 * @date 2019/6/17
 */
public class q88MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while(i>=0 && j>=0){
            if(nums1[i] > nums2[j]){
                nums1[k]=nums1[i];
                k--;
                i--;
            }else{
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
        while(j>=0){
            nums1[k]=nums2[j];
            k--;
            j--;
        }
        /**
         * 可以不用判断下面这个循环
         * 循环判断了ia&&ib还有ib，为什么没有判断ia的情况呢，因为ia&&ib为假的情况，要么就是ia已经判断完了，要么是ib判断完了，因为是直接插入到数组1中的，所以ib判断完了，也就完了，不需要再判断ia
         */
//        while(i>=0){
//            nums1[k]=nums1[i];
//            k--;
//            i--;
//        }
    }
}
