package cn.edu.xd.myy.dynamic_programming;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author myy
 * @date 2019/6/21
 */
public class q121 {
    public int maxProfit(int[] prices) {
        if(prices.length <2){
            return 0;
        }
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i] < minprice){
                minprice = prices[i];
            }else if(prices[i]-minprice > maxprofit){
                maxprofit = prices[i]-minprice;
            }
        }
        return maxprofit;
    }
}
