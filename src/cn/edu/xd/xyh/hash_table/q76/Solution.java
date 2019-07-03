package cn.edu.xd.xyh.hash_table.q76;

/**
 * @author LitheLight
 * @date 2019/7/3
 * https://leetcode.com/problems/minimum-window-substring/
 * 思路：
 * 用一个长度为128的数组freq来记录字符出现的次数，数组下标为字符，数组的值为对应下标元素出现的次数。
 * 首先遍历t字符串，将里面字符出现次数记录下来。然后设置两个指针start 和 end，end用来遍历s字符串，
 * start指针用于指示最短结果字符串的开始位置。同时设置一个最短长度变量，初始值为最大值，用于保存最短长度。
 * 再设置一个counter变量，值为t字符串长度，用于表示t字符串中所有字符是否都已出现过
 * 1. 开始遍历s字符串，如果是在t中的字符（freq[c]>0），那么counter减一，执行第2步
 * 2. 每个字符的出现次数-1，这样那些没有在t中出现的字符在freq数组中的元素都小于0了，
 * 在t中出现的字符最后会为0，end指针往后移动
 * 3. 当counter==0时，说明t中字符都已经出现过了一次，那么这时候就要记录长度，与minLen比较大小去小的那一个。
 * 同时还要找到start到end之间第一个出现在t字符串中的字符（寻找方法：由2知道在t中出现的字符此时在freq中元素为0，
 * 其他的小于0，这个时候start指针就开始使用了，start指针对应的字符在freq数组中的元素+1，如果大于0，说明这是在t中
 * 出现的字符），此时counter+1，继续进入第1步开始往下执行，这次执行只有找到下一个与它相同的字符counter才会变为0，
 * 此时我们就找到了一个新的包含t中所有字符的子串。
 * 如此循环就可以找到最短的字符串，这个方法最差时间复杂度为O(n^2)
 */
public class Solution {

    public String minWindow(String s, String t) {
        int[] freq = new int[128];
        // 将t中字符放入freq数组
        for (char c : t.toCharArray()) {
            freq[c]++;
        }
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        while (end < s.length()) {
            final char c1 = s.charAt(end);
            // 如果是t中出现的字符，counter--，counter=0说明t中所有字符都已经出现过了
            if (freq[c1] > 0) {
                counter--;
            }
            freq[c1]--;
            end++;
            while (counter == 0) {
                // 保存最小长度
                if (minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }
                // 下面是为了找到s中第一个不重复出现在s中的字符(这里可能会疑惑一个不在t中出现的字符如果连续出现两次会不会freq大于0，这个不用担心，因为如果重复出现的话在前面的步骤中就减了多少个1，也就是最后最多加回到0)
                final char c2 = s.charAt(start);
                freq[c2]++;
                if (freq[c2] > 0) {
                    counter++;
                }
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(solution.minWindow(s, t));
    }
}
