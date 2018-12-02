package Practice_Final;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class LapClock extends Label implements Runnable, ActionListener {
    JFrame frame = new JFrame("StopWatch");
    JLabel label = new JLabel("00:00:00");
    JButton button1,button2;
    JPanel panel2,panel3;
    JTextArea textArea = new JTextArea(0,1);
    JScrollPane scrollPane;
    int hour,min,sec;
    int state = 0;
    @Override
    public void run() {
        init();
        Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 20);
        Font newFont = myFont.deriveFont(50F);
        label.setFont(newFont);
        label.setVerticalTextPosition(CENTER);
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(state==1){
                if(min==59)hour++;
                if(sec==59){
                    min++;
                    sec = -1;
                }
                sec++;
                setTextLable();
            }

            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.pack();
            System.out.println(state);
        }

    }
    public void init(){
        panel2 = new JPanel(new FlowLayout());
        panel3 = new JPanel();
        button1 = new JButton("Reset");
        button2 = new JButton("Start");
        button1.addActionListener(this);
        button2.addActionListener(this);
        scrollPane = new JScrollPane(textArea);
        panel2.add(button1);
        panel2.add(button2);
        frame.add(label,BorderLayout.NORTH);
        frame.add(panel2,BorderLayout.CENTER);
        frame.add(scrollPane,BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        LapClock lapClock = new LapClock();
        Thread thread = new Thread(lapClock);
        thread.start();
    }
    public void setTextLable(){
        String hour1 = "",min1="",sec1="";
        hour1 = hour+"";
        min1= min+"";
        sec1 = sec+"";
        if(sec<10)sec1="0"+sec;
        if(min<10)min1="0"+min;
        if(hour<10)hour1="0"+hour;
        label.setText(hour1+":"+min1+":"+sec1);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if(e.getActionCommand().equals("Start")){
            state = 1;
            button2.setText("Pause");
            button1.setText("Lap");
        }
        else if(e.getActionCommand().equals("Pause")){
            state = 2;
            button2.setText("Start");
            button1.setText("Reset");

        }
        else if(e.getActionCommand().equals("Reset")){
            button2.setText("Start");
            state = 0;
            hour = 0;
            min = 0;
            sec = 0;
            label.setText("0"+hour+":"+"0"+min+":"+"0"+sec);

        }else if(e.getActionCommand().equals("Lap")){
            String hour1 = "",min1="",sec1="";
            hour1 = hour+"";
            min1= min+"";
            sec1 = sec+"";
            if(sec<10)sec1="0"+sec;
            if(min<10)min1="0"+min;
            if(hour<10)hour1="0"+hour;
            textArea.append(hour1+":"+min1+":"+sec1+"\n");
        }
    }
}
