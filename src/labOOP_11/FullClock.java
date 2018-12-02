package labOOP_11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class FullClock extends JLabel implements Runnable , ActionListener {
    JFrame frame;
    Calendar calendar;
    JLabel label = new JLabel();
    JButton time,lap,counter;
    JPanel panel;
    int hour,min,sec,hour2,min2,sec2,hour3 = 2,min3,sec3;
    int state = 0;


    @Override
    public void run() {
        init();
        Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 20);
        Font newFont = myFont.deriveFont(50F);
        label.setFont(newFont);
        label.setVerticalTextPosition(CENTER);
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(state == 0) {
                calendar = Calendar.getInstance();
                hour = calendar.get(Calendar.HOUR);
                min = calendar.get(Calendar.MINUTE);
                sec = calendar.get(Calendar.SECOND);
                setText(hour, min, sec);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
            else if(state==1){
                setTime(hour2,min2,sec2);
                setText(hour2,min2,sec2);
            }
            else if(state==2){
                Counter();
                setText(hour3,min3,sec3);
            }
            label.setHorizontalAlignment(CENTER);
        }



    }

    public void init(){
        frame = new JFrame("FullClock");
        time = new JButton("Time");
        lap = new JButton("Lap");
        counter = new JButton("Counter");
        panel = new JPanel();
        panel.add(lap,BorderLayout.WEST);
        panel.add(time,BorderLayout.CENTER);
        panel.add(counter,BorderLayout.EAST);
        frame.setSize(400,200);
        frame.add(label,BorderLayout.NORTH);
        frame.add(panel,BorderLayout.SOUTH);
        time.addActionListener(this);
        lap.addActionListener(this);
        counter.addActionListener(this);

    }
    public void setText(int hour,int min,int sec){
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

    }
    public void setTime(int hourq,int minq,int secq){
        if(minq==0)hour++;
        if(secq==59)min++;
        if(secq == 59) sec2=-1;
        sec2++;

    }

    public void Counter(){
        if (sec3 == 0) {
            sec3 = 59;
            min3--;
        }
        if (min3 == -1) min3 = 0;
        if (min3 == 0 && sec3 == 0) hour3--;
        sec3--;
    }

    public static void main(String[] args) {
        FullClock fullClock = new FullClock();
        Thread t = new Thread(fullClock);
        t.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if(e.getActionCommand().equals("Lap"))state = 1;
        else if(e.getActionCommand().equals("Time"))state = 0;
        else if(e.getActionCommand().equals("Counter"))state = 2;

    }
}
