package cn.edu.xd.myy.binary_search;

/**
 * @author myy
 * @date 2019/6/22
 */
public class q69 {
    public int mySqrt(int x){
        // x为0和1的情况单独考虑，这样后面的数开根号的值不会超过x/2
        if(x <=1){
            return x;
        }
        //左边界1
        int left =1;
        //有边界 x/2
        int right = x>>1;

        while(left<=right){
            // 取中位数，不是直接（right+left）/2是为了防止溢出
            int mid = left+(right-left)/2;
            // 这里比较mid和x/mid的值而不是 x和mid平方的值也是为了防止溢出
            if(mid > x/mid){
                right = mid-1;
            }else{
                if((mid+1)>x/(mid+1)){
                    return mid;
                }
                left = mid+1;
            }

        }
        return right;

    }
}
