package cn.edu.xd.myy.sort;

/**二分查找,返回数组中的下标
 * 博客 中包含二分查找的变种
 *https://www.cnblogs.com/luoxn28/p/5767571.html
 * https://www.jianshu.com/p/0f823fbd4d20
 *
 * @author myy
 * @date 2019/6/18
 */
public class binarySearch {
    public static int binarySearch(int[] array,int key){
        int left =0;
        int right = array.length-1;
        //while循环必须为<=
        while(left <= right){
            int mid=left+(right-left)/2;
            if(array[mid] == key){
                return mid;
            }else if(array[mid]>key){
                right = mid-1;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] array={1,2,3,4,5,6,7};
        int a = binarySearch(array,6);
        System.out.println(a);
    }
}
