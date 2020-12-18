package cn.hws.math.dy;

public class q2 {
    /**
     * 图的路径问题解法
     */

    /**
     * 一步一步地进行
     *
     * 1.0 递归
     */
    public static int f1(int[][] att,int i,int j) {

        //如果是石头
        if(att[i][j] == 111){
            return 0;
        }

        //如果是终点
        if(att[i][j] == 111){
            return 1;
        }

        //向下走一步 + 向右走一步
        return f1(att,i+1,j) + f1(att,i,j+1);
    }

    /**
     * 2.0 地推-动态规划
     * 记录表
     * 状态定义 opt[n]
     * 状态转移方程 opt[i,j] = opt[i-1,j] + opt[i,j-1]
     *
     * if a[i,j] = '空地':
     *      opt[i,j] = opt[i-1,j] + opt[i,j-1]
     * else [石头]
     *      opt[i,j] = 0
     *
     */


    public int minDistDP(int[][] matrix, int n) {
        int[][] states = new int[n][n];
        int sum = 0;
        for (int j = 0; j < n; ++j) { // 初始化states的第一行数据
            sum += matrix[0][j];
            states[0][j] = sum;
        }
        sum = 0;
        for (int i = 0; i < n; ++i) { // 初始化states的第一列数据
            sum += matrix[i][0];
            states[i][0] = sum;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < n; ++j) {
                states[i][j] =
                        matrix[i][j] + Math.min(states[i][j-1], states[i-1][j]);
            }
        }
        return states[n-1][n-1];
    }


}
