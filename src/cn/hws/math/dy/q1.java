package cn.hws.math.dy;

public class q1 {

    /**
     * 斐波拉契
     */

    /**
     * 1.0 递归
     */
    public static int f1(int n) {
        return n <= 1 ? n : f1(n - 1) + f1(n - 2);
    }

    /**
     * 2.0 递归 + 记忆化
     * 记录表
     */
    public static int f2(int n) {
        int[] attr = new int[n+1];

        if(n <=1){
            return n;
        }else{
            if(attr[n]==0){
                attr[n] = f2(n-1) + f2(n-2);
            }
            return attr[n];
        }
    }

    /**
     * 2.0 动态规划
     * 记录表
     */
    public static int f3(int n) {
        int[] attr = new int[n+1];
        attr[0] = 0;
        attr[1] = 1;
        for(int i=2;i<=n;i++){
            attr[i] = attr[i-1] + attr[i-2];
        }
        return attr[n];
    }

    public static void main(String[] args) {
        System.out.println(f3(10));
    }


}
