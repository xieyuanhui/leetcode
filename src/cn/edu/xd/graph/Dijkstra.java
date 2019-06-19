package cn.edu.xd.graph;

/**
 * @author LitheLight
 * @date 2019/6/19
 * https://www.jianshu.com/p/ff6db00ad866
 */
public class Dijkstra {

    /**
     * M代表正无穷
     */
    public static final int M = 10000;

    public static void main(String[] args) {
        /**
         * 二维数组每一行分别是 0、1、2、3、4各点到其余点的距离。
         * A->A的距离为0， 常量M为正无穷
         */
        int[][] weight1 = {
                {0,4,M,2,M},
                {4,0,4,1,M},
                {M,4,0,1,3},
                {2,1,1,0,7},
                {M,M,3,7,0}
        };
        int start = 0;
        int[] shortPath = dijkstra(weight1, start);
        for (int i = 0; i < shortPath.length; i++) {
            System.out.println("从" + start + "出发到" + i + "的最短距离为：" + shortPath[i]);
        }
    }

    /**
     * 接收一个有向图的权重矩阵和一个起点编码start（从0开始编号，顶点存在数组中）
     * 返回一个int[]数组，表示从start到它的最短路径长度
     * @param weight
     * @param start
     * @return
     */
    private static int[] dijkstra(int[][] weight, int start) {
        // 顶点个数
        int n = weight.length;
        // 保存start到其他各点的最短路径
        int[] shortPath = new int[n];
        // 保存start到其他各点最短路径的字符串表示
        String[] path = new String[n];
        for (int i = 0; i < n; i++) {
            path[i] = start + "->" + i;
        }
        // 标记当前顶点的最短路径是否已经求出，true表示已经求出
        boolean[] visited = new boolean[n];
        // 初始化，自己这个顶点已经求出
        shortPath[start] = 0;
        visited[start] = true;
        for (int count = 1; count < n; count++) {
            // 选出一个距离初始顶点start最近的未标记的顶点
            int k = -1;
            int dMin = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && weight[start][i] < dMin) {
                    dMin = weight[start][i];
                    k = i;
                }
            }
            // 将新选出的顶点标记为已求出最短路径，且到start的最短路径就是dMin
            shortPath[k] = dMin;
            visited[k] = true;
            // 以k为中间点，修正从start到未访问各点的距离
            for (int i = 0; i < n; i++) {
                // 如果 ‘起始点到当前点距离’+ ‘当前点到某点距离’< ‘起始点到某点距离’，则更新
                if (!visited[i] && weight[start][k] + weight[k][i] < weight[start][i]) {
                    weight[start][i] = weight[start][k] + weight[k][i];
                    path[i] = path[k] + "->" + i;
                }
            }
        }
        for (int i = 0; i < n; i++) {

            System.out.println("从" + start + "出发到" + i + "的最短路径为：" + path[i]);
        }
        System.out.println("=====================================");
        return shortPath;
    }
}

#include <sys/types.h>
#include <sys/wait.h>
pid_t wait(int *status);
        pid_t waitpid(pid_t pid, int *status, int options);