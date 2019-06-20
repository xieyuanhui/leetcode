package cn.edu.xd.rabin_karp;

/**
 * @author LitheLight
 * @date 2019/6/20
 * 如何更好的理解和掌握 KMP 算法? - 施佳鑫的回答 - 知乎
 * https://www.zhihu.com/question/21923021/answer/37428741
 */
public class RabinKarp {

    public static final int d = 256;

    public static void search(String pat, String txt, int q) {
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int p = 0;
        int t = 0;
        int h = 1;
        for (i = 0; i < M - 1; i++) {
            h = (h * d) % q;
        }
        for (i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }
        for (i = 0; i <= N - M; i++) {
            if (p == t) {
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j)) {
                        break;
                    }
                }
                if (j == M) {
                    System.out.println("Pattern found at index " + i);
                }
            }
            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;
                if (t < 0) {
                    t = t + q;
                }
            }
        }
    }

    public static void main(String[] args) {
        String txt = "geeks for geeks";
        String pat = "geek";
        int q = 101;
        search(pat, txt, q);
    }
}
