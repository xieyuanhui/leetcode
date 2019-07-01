package cn.edu.xd.huffman_tree;

/**
 * @author LitheLight
 * @date 2019/7/1
 */
public class HuffmanTree {

    /**
     * 最大权值
     */
    static final int MAXVALUE = 1000;
    /**
     * 叶子结点个数
     */
    int nodeNum;

    public HuffmanTree(int n) {
        this.nodeNum = n;
    }

    /**
     * 构造哈夫曼树
     * @param weight 权值数组
     * @param nodes 所有结点数组
     */
    public void huffman(int[] weight, HuffNode[] nodes) {
        int n = this.nodeNum;
        // m1 m2表示两个最小的权值，x1 x2表示两个最小权值对应的编号，m1最小，m2次之
        int m1, m2, x1, x2;
        // 初始化所有结点，对应有n个叶子结点的哈夫曼树，有2n-1个结点
        for (int i = 0; i < 2 * n - 1; i++) {
            HuffNode temp = new HuffNode();
            // 初始化n个叶子结点，就是输入的结点
            if (i < n) {
                temp.weight = weight[i];
            } else {
                temp.weight = 0;
            }
            temp.parent = 0;
            temp.flag = 0;
            temp.left = -1;
            temp.right = -1;
            nodes[i] = temp;
        }
        // 初始化n-1个非叶子结点，n-1表示要循环n-1次求的n-1个数
        for (int i = 0; i < n - 1; i++) {
            m1 = m2 = MAXVALUE;
            x1 = x2 = 0;
            // 求得这n-1个数时，每次都是从0到n+i-1，并且flag=0的数中求，flag=1表示已经加入到二叉树
            for (int j = 0; j < n + i; j++) {
                if (nodes[j].weight < m1 && nodes[j].flag == 0) {
                    // 比m1小，则更新m1 m2 x1 x2
                    m2 = m1;
                    x2 = x1;
                    m1 = nodes[j].weight;
                    x1 = j;
                } else if (nodes[j].weight < m2 && nodes[j].flag == 0) {
                    // 比m1大，比m2小，则更新m2 x2
                    m2 = nodes[j].weight;
                    x2 = j;
                }
            }
            // 将权值最小的两个组合成一个二叉树
            nodes[x1].parent = n + i;
            nodes[x2].parent = n + i;
            nodes[x1].flag = 1;
            nodes[x2].flag = 1;
            nodes[n + i].weight = nodes[x1].weight + nodes[x2].weight;
            nodes[n + i].left = x1;
            nodes[n + i].right = x2;
        }
    }

    /**
     * 哈夫曼编码算法
     * @param nodes
     * @param huffCode
     */
    public void huffmanCode(HuffNode[] nodes, Code[] huffCode) {
        int n = this.nodeNum;
        Code code = new Code(n);
        int child, parent;

        // 给前面n个输入的结点进行编码
        for (int i = 0; i < n; i++) {
            code.start = n - 1;
            code.weight = nodes[i].weight;
            child = i;
            parent = nodes[child].parent;
            // 从叶子结点向上走来生成编码
            while (parent != 0) {
                if (nodes[parent].left == child) {
                    code.bit[code.start] = 0;
                } else {
                    code.bit[code.start] = 1;
                }
                code.start--;
                child = parent;
                parent = nodes[child].parent;
            }
            Code temp = new Code(n);
            for (int j = code.start + 1; j < n; j++) {
                temp.bit[j] = code.bit[j];
            }
            temp.weight = code.weight;
            temp.start = code.start;
            huffCode[i] = temp;
        }
    }

    public static void main(String[] args) {

        int n = 4;
        int[] weight = {1,3,5,7};
        HuffmanTree haffTree = new HuffmanTree(n);
        HuffNode[] nodes = new HuffNode[2*n-1];
        Code[] codes = new Code[n];
        //构造哈夫曼树
        haffTree.huffman(weight, nodes);
        //生成哈夫曼编码
        haffTree.huffmanCode(nodes, codes);

        //打印哈夫曼编码
        for(int i=0;i<n;i++)
        {
            System.out.print("Weight="+codes[i].weight+" Code=");
            for(int j=codes[i].start+1;j<n;j++)
            {
                System.out.print(codes[i].bit[j]);
            }
            System.out.println();
        }
    }
}

class HuffNode {
    /**
     * 权值
     */
    int weight;
    /**
     * 双亲
     */
    int parent;
    /**
     * 标志是否为叶子节点
     */
    int flag;
    /**
     * 左孩子
     */
    int left;
    /**
     * 右孩子
     */
    int right;
}

class Code {
    /**
     * 编码的数组
     */
    int[] bit;
    /**
     * 编码的开始下标
     */
    int start;
    /**
     * 权值
     */
    int weight;
    Code(int n) {
        bit = new int[n];
        start = n - 1;
    }
}
