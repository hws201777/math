package cn.hws.math.demo;

public class ThreadTest2 {


    public static class TakePrint {

        private static Boolean flag = true;

        private static int count = 0;
        public synchronized void print1() {
            for (int i = 0; i < 50; i++) {
                while (!flag){
                    try {
                        System.out.println("print1: wait before");
                        wait();
                        System.out.println("print1: wait after");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("print1 count = " + ++count);
                flag = !flag;
                notifyAll();
            }
        }

        public synchronized void print2() {
            for (int i = 0; i < 50; i++) {
                while (flag){
                    try {
                        System.out.println("print2: wait before");
                        wait();
                        System.out.println("print2: wait after");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("print2 count = " + ++count);
                flag = !flag;
                notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        TakePrint takePrint = new TakePrint();
        new Thread(() -> takePrint.print1(),"1").start();
        new Thread(() -> takePrint.print2(),"2").start();
    }

}
