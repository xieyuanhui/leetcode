package cn.edu.xd.myy.depth_first_search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author myy
 * @date 2019/6/18
 */
public class q200NumberOfIslands {
        public int numIslands(char[][] grid) {
            int row = grid.length;
            if(row==0) return 0;
            int col = grid[0].length;
            int count =  0;
            Queue<Integer[]> queue = new LinkedList<>();        ///记录已经被遍历的区域的点索引
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(grid[i][j]=='1'){      //找到某块为1的区域,遍历过后改为'2'
                        count++; //每次遇到新的区域便加1
                        Integer[] indexs={i,j};
                        queue.offer(indexs);
                        while(!queue.isEmpty()){
                            Integer[] temp = queue.poll();
                            int m=temp[0],n=temp[1];
                            if(grid[m][n]=='1'){
                                grid[m][n]='2';
                                if(m-1>=0&&grid[m-1][n]=='1'){
                                    Integer[] index = {m-1,n};
                                    queue.offer(index);
                                }
                                if(m+1<row&&grid[m+1][n]=='1'){
                                    Integer[] index = {m+1,n};
                                    queue.offer(index);
                                }
                                if(n-1>=0&&grid[m][n-1]=='1'){
                                    Integer[] index = {m,n-1};
                                    queue.offer(index);
                                }
                                if(n+1<col&&grid[m][n+1]=='1'){
                                    Integer[] index = {m,n+1};
                                    queue.offer(index);
                                }
                            }
                        }
                    }
                }
            }
            return count;
        }
    }

