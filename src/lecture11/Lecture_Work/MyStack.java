package lecture11.Lecture_Work;

import java.util.ArrayList;
import java.util.Stack;

public class MyStack
{
    private int stack[];
    private ArrayList<Character> list = new ArrayList<>();
    private int index;

    public synchronized void push(char ch){
        list.add(ch);
        index++;
        notify();
    }
    public synchronized char pop(){
        while (list.size()==0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        index--;

        return (Character) list.remove(index);

    }
}
