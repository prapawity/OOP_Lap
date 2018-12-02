package lecture11;
class PrintName implements Runnable{
    private String name;

    PrintName(String name){
        this.name = name;
    }


    public void run(){
        for (int i =0;i<=100;i++) {
            System.out.println(name + " : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadClass {

    public static void main(String[] args) {

        PrintName printName = new PrintName("OOP");
        Thread t1 = new Thread(printName);
        t1.start();
        PrintName printName2 = new PrintName("WEB");
        Thread t2 = new Thread(printName2);
        t2.start();

    }
}
