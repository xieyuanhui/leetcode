package cn.edu.xd.kmp;

/**
 * @author LitheLight
 * @date 2019/6/20
 * 如何更好的理解和掌握 KMP 算法? - 海纳的回答 - 知乎
 * https://www.zhihu.com/question/21923021/answer/281346746
 */
public class Kmp {

    public static int kmp(String t, String p) {
        int i = 0;
        int j = 0;
        int[] next = getNext(p);
        while (i < t.length() && j < p.length()) {
            if (j == -1 || t.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == p.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    private static int[] getNext(String p) {
        int[] next = new int[p.length() + 1];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < p.length()) {
            if (j == -1 || p.charAt(i) == p.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        int[] next = getNext("caba");
        System.out.println(next);
        String t = "abcvbasdf";
        String p = "abcvbasd";
        System.out.println(kmp(t, p));
    }
}
