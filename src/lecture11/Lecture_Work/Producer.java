package lecture11.Lecture_Work;

public class Producer implements Runnable {

    MyStack s;
    char ch = 'A';
    Producer(MyStack s){
        this.s = s;
    }
    @Override
    public void run() {
        for(int i = 0; i<1000;i++){
            System.out.println("Push : "+ch++);
            if(ch > 'Z')
                ch = 'A';
            s.push(ch);
        }
    }
}
