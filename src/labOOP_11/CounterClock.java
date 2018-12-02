package labOOP_11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class CounterClock extends JLabel implements Runnable, ActionListener {
    int hour=1,min=59,sec=59,state = 0;
    JFrame frame ;
    JButton button = new JButton("START");
    JLabel label = new JLabel("02:00:00");
    String second = "01", minute = "59", hours = "59";
    @Override
    public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (sec == 0) {
                    sec = 59;
                    min--;
                }
                if (min == -1)
                    min = 0;
                if (min == 0 && sec == 0)
                    hour--;
                if (hour == -1)
                    break;
                sec--;
                if (hour < 10)
                    hours = "0" + hour;
                else hours = String.valueOf(hour);
                if (min < 10)
                    minute = "0" + min;
                else minute = String.valueOf(min);
                if (sec < 10)
                    second = "0" + sec;
                else second = String.valueOf(sec);


                label.setText(hours + ":" + minute + ":" + second);
                if (state==0) {
                    label.setText("02:00:00");
                    hour=1;
                    min=59;
                    sec=60;
                    state = 0;
                }
                frame.add(label, BorderLayout.CENTER);
                frame.add(button, BorderLayout.SOUTH);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        }
    public void init(){
        frame = new JFrame();
        frame.setSize(300,100);
        Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 20);
        Font newFont = myFont.deriveFont(50F);
        button.addActionListener(this);
        label.setFont(newFont);
        label.setVerticalTextPosition(CENTER);
        label.setHorizontalAlignment(CENTER);
        frame.add(label, BorderLayout.CENTER);
        frame.add(button,BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("START")) {
            state = 1;
        }
    }

    public static void main(String[] args) {
        CounterClock counterClock = new CounterClock();
        Thread t = new Thread(counterClock);
        counterClock.init();
        t.start();
    }
}
