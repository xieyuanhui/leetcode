package cn.edu.xd.xyh.sort.q350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author LitheLight
 * @date 2019/6/28
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * 思路：
 * 用hashmap记录一个数组中元素以及出现的次数，遍历另外一个数组，如果map中存在这个key并且数量大于0，
 * 那么就添加到结果列表中
 *
 * 延伸思考：
 * 1. 如果nums1 nums2都是有序的，应该如何优化？
 * 思路：可以用双指针法，nums1和nums2起始位置各设一个指针，如果nums1的值小于nums2的值，则移动nums1的指针，
 * 如果相等，则记录这个值，nums1和nums2都移动，如果是nums1大于nums2的指针的值，则移动nums2的指针。
 * 一直下去直到其中一个指针到达末尾则结束
 * 2. 如果nums1的长度小于nums2的长度，哪种算法好？（比较的是使用hashmap的算法和1中的双指针算法）
 * 思路：假设nums1长度为N，nums2长度为M，N<M，使用hashMap的算法时间复杂度为 O(M),
 * 空间复杂度使用短数组做计数hashmap时最大为 O(N)，
 * 使用1中的双指针算法时间复杂度最坏为O(M+N)，空间复杂度最大为O(N)，因此hashmap算法更好
 * 3. 如果nums2存在硬盘，内存一次存不下？
 * 思路：使用分治法，切片nums2直到它能适应内存
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int item : nums1) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        for (int item : nums2) {
            if (map.containsKey(item) && map.get(item) > 0) {
                result.add(item);
                map.put(item, map.get(item) - 1);
            }
        }
        int[] res = new int[result.size()];
        int i = 0;
        for (Integer item : result) {
            res[i++] = item;
        }
        return res;
    }
}
