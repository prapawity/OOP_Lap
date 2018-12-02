package lecture11.Lecture_Work;

public class Consumer implements Runnable {
    MyStack s;
    public Consumer(MyStack s){
        this.s = s;
    }
    @Override
    public void run() {
        for (int i = 1; i<=1000;i++)
            System.out.println("POP : "+s.pop());

    }
}
