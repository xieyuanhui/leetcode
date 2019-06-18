package cn.edu.xd.myy.heap;

import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 * q347
 * @author myy
 * @date 2019/6/18
 */
public class q347TopKFrequentElement {
    /**
     * 利用hashMap存储列表中元素出现的频率，然后根据频率构建大顶堆，结果为前k大元素
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums==null || nums.length < k){
            return null;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }

        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue(new Comparator<Map.Entry<Integer,Integer>>(){

            @Override
            public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            queue.offer(entry);
        }
        List<Integer> res = new ArrayList<>();
        while(res.size() < k){
            Integer num = queue.poll().getKey();
            res.add(num);
        }
        return res;

    }
}
