package cn.hws.math;

import org.junit.Test;

/**
 * Created by hws on 2017/3/31.
 */
public class MathDemo {
    private int b1;

    /**
     * 1.古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
     * 这是一个菲波拉契数列问题
     * 1    2	3	4	5	6	7	8	9	10
     * 2	2	4	6	10	16
     * 1	1	2	3	5	8
     */
    @Test
    public void test01() {
        System.out.println("第1个月兔子对数为:" + 1);
        System.out.println("第2月的兔子对数为:" + 1);
        int f;
        int f1 = 1;
        int f2 = 1;
        int m = 24;//统计24个月
        for (int i = 3; i <= m; i++) {
            f = f2;
            f2 = f1 + f2;
            f1 = f;
            System.out.println("第" + i + "个月兔子对数为:" + f2);
        }
    }

    /**
     * 2.判断101-200之间有多少个素数，并输出所有素数。
     * 判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除， 则表明此数不是素数，
     * 反之是素数。
     */
    @Test
    public void test02() {
        int count = 0;
        for (int i = 101; i < 200; i += 2) {
            boolean flag = false;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                } else {
                    flag = true;
                }
            }
            if (flag) {
                count++;
                System.out.println(i);
            }
        }
        System.out.println("素数为:" + count);
    }

    /**
     * 3.打印出所有的 "水仙花数 "，所谓 "水仙花数 "是指一个三位数，其各位数字立方和等于该数本身。
     * 例如：153是一个 "水仙花数 "，因为153=1的三次方＋5的三次方＋3的三次方。
     * 153   bai 153/100=1   shi 153%100/10  ge 153%10
     */
    @Test
    public void test03() {
        int b1, b2, b3;
        for (int i = 101; i < 1000; i++) {
            b3 = i / 100;
            b2 = i % 100 / 10;
            b1 = i % 10;
            if (b1 * b1 * b1 + b2 * b2 * b2 + b3 * b3 * b3 == i) {
                System.out.println(i);
            }
        }

    }

    /**
     * 4.题目：将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。   
     * 程序分析：对n进行分解质因数，应先找到一个最小的质数k，然后按下述步骤完成：   
     * (1)如果这个质数恰等于n，则说明分解质因数的过程已经结束，打印出即可。   
     * (2)如果n <> k，但n能被k整除，则应打印出k的值，并用n除以k的商,作为新的正整数你n,重复执行第一步。   
     * (3)如果n不能被k整除，则用k+1作为k的值,重复执行第一步。  
     */
    @Test
    public void test04() {
        int n = 78;
        System.out.print(n + "=");
        int k = 2;
        while (k <= n) {
            if (k == n) {
                System.out.print(n);
                break;
            } else if (n % k == 0) {
                System.out.print(k + "*");
                n = n / k;
            } else {
                k++;
            }

        }
    }

    /**
     * 5.题目：输入两个正整数m和n，求其最大公约数和最小公倍数。   
     * 在循环中，只要除数不等于0，用较大数除以较小的数，将小的一个数作为下一轮循环的大数，
     * 取得的余数作为下一轮循环的较小的数，如此循环直到较小的数的值为0，
     * 返回较大的数，此数即为最大公约数，最小公倍数为两数之积除以最大公约数。
     * 6   4  k=6%4    4  2  k=4%2 2  2
     * 辗转相除法和更相减损术以及短除法都可以求最大公约数
     */
    @Test
    public void test05() {
        int a = 80;
        int b = 36;
        int max = deff(a, b);
        int min = a * b / max;
        System.out.print("MAX=" + max + "MIN=" + min);
    }

    private int deff(int a, int b) {
        int t;
        if (a < b) {
            t = a;
            a = b;
            b = t;
        }
        while (b != 0) {
            if (a == b) {
                return a;
            } else {
                int k = a % b;
                a = b;
                b = k;

            }
        }
        return a;
    }
    /**
     *     6.题目：输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
     */
    @Test
    public void test06() {
        int digital = 0;
        int character = 0;
        int other = 0;
        int blank = 0;
        char[] ch = null;
        String s = "1231312dfsaf fsdfs fgsdg32423 gththrt?.,,.";
        ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= '0' && ch[i] <= '9') {
                digital++;
            } else if ((ch[i] >= 'a' && ch[i] <= 'z') || ch[i] > 'A' && ch[i] <= 'Z') {
                character++;
            } else if (ch[i] == ' ') {
                blank++;
            } else {
                other++;
            }
        }
        System.out.println("数字个数: " + digital);
        System.out.println("英文字母个数: " + character);
        System.out.println("空格个数: " + blank);
        System.out.println("其他字符个数:" + other);
    }

    /**
     * 7 .求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。例如2+22+222+2222+22222
     */
    @Test
    public void test07(){
        System.out.print(this.pow(2,4));
    }
    public int pow(int a,int b){
        int sum=0;
        int k = 0;
        while((b-k)!=0){
            sum += a*(b-k)*Math.pow(10,k);
            k++;
        }
        return sum;
    }
}
