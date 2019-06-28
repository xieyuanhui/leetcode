package cn.edu.xd.xyh.sort.q179;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author LitheLight
 * @date 2019/6/28
 * https://leetcode.com/problems/largest-number/
 * 思路：
 * 还是先排序的思路，排序的过程中需要定义好规则，因为不一定s1大于s2时s1就要放在s2前面，
 * 比如s1 = 30， s2 = 3，s1 > s2,但是330会比303更大，所以定义比较规则时可以将 尝试将
 * s1和s2拼接在一起以及s2和s1拼接在一起进行比较。定义完比较规则就是排序了，然后拼接在一起就是最大数
 */
public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        // 定义比较规则
        Comparator<String> comparator = new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {
                String str1 = s1 + s2;
                String str2 = s2 + s1;
                return str2.compareTo(str1);
            }
        };
        Arrays.sort(str, comparator);
        StringBuffer res = new StringBuffer();
        // 可能有都是0的情况，这时候只要返回一个0即可
        if (str[0].charAt(0) == '0') {
            return "0";
        }
        for (String s : str) {
            res.append(s);
        }
        return res.toString();
    }

}
