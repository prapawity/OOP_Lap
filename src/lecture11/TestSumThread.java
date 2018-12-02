package lecture11;

class SumThread implements Runnable{
    int sum;
    @Override
    public void run() {
        for (int i = 0; i<=10;i++)
            sum+=i;
    }
}

public class TestSumThread {
    public static void main(String[] args) {
        SumThread sumThread = new SumThread();
        Thread thread1 = new Thread(sumThread);
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sumThread.sum);
    }


}
