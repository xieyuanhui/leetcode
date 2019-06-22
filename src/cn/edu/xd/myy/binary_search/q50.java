package cn.edu.xd.myy.binary_search;

/**
 * @author myy
 * @date 2019/6/22
 */
public class q50 {
    /**
     * 递归实现
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x,int n){
        if(n==0){
            return 1;
        }
        //当n小于0的时候要把x变成1/x，n变成-n,就可以和n是整数一起执行l
        if(n<0){
            //当n是负数的最小值的时候需要单独考虑，因为-n会溢出
            if(n==Integer.MIN_VALUE){
                ++n;
                n=-n;
                x=1/x;
                return x*x*myPow(x*x,n/2);
            }
            n=-n;
            x=1/x;
        }
        //n如果是偶数，直接x*x,n变成一半；如果是奇数需要多乘以一个x
        return (n%2==0)?myPow(x*x,n/2):x*myPow(x*x,n/2);
    }
}
