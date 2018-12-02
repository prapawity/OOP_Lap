package labOOP_11;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class MyClock extends JLabel implements Runnable {
    Calendar calendar;
    int sec,min,hour;
    JFrame frame;
    JLabel label = new JLabel();
    @Override
    public void run() {
        frame = new JFrame();
        frame.setSize(300,100);
        Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 20);
        Font newFont = myFont.deriveFont(50F);
        label.setFont(newFont);
        label.setVerticalTextPosition(CENTER);


        while (true){
            calendar = Calendar.getInstance();
            sec = calendar.get(Calendar.SECOND);
            min = calendar.get(Calendar.MINUTE);
            hour = calendar.get(Calendar.HOUR_OF_DAY);
            setText();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            frame.add(label, BorderLayout.CENTER);

            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);

        }
    }
    public void setText(){
        String second="",minute="",hours = "";
        if(hour<10)
            hours = "0"+hour;
        else hours = String.valueOf(hour);
        if(min<10)
            minute = "0"+min;
        else minute = String.valueOf(min);
        if(sec<10)
            second = "0"+sec;
        else second = String.valueOf(sec);
        label.setText(hours+":"+minute+":"+second);
        label.setHorizontalAlignment(CENTER);
    }
    public static void main(String[] args) {
        MyClock myClock = new MyClock();
        myClock.run();

    }
}
