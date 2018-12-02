package Practice_Final;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AccountGUI implements ActionListener, ItemListener {
    JFrame frame;

    JMenuBar menuBar;
    JMenu menu1,menu2;
    JMenuItem menuItem1,menuItem2;
    JLabel label,label2,label3,label4;
    JButton button,button2,button3;
    JPanel panel1,panel2;
    JComboBox<String> comboBox = new JComboBox<>(),comboBox2 = new JComboBox<>();
    JTextField textField1 = new JTextField(),textField2 = new JTextField();
    int i = 1;


    public void init(){
        frame = new JFrame();
        frame.setSize(800,600);
        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        menu1 = new JMenu("File");
        menu2 = new JMenu("Option");
        menuItem1 = new JMenuItem("Save");
        menuItem2 = new JMenuItem("Exit");
        menuItem2.addActionListener(this);
        label = new JLabel("Account");
        label2 = new JLabel("Balacne");
        label3 = new JLabel("Amount");
        label4 = new JLabel("Tranfer to");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setHorizontalAlignment(SwingConstants.CENTER);

        panel1 = new JPanel(new GridLayout(4,2));
        panel2 = new JPanel(new FlowLayout());

        button = new JButton("New");
        button2 = new JButton("Deposite");
        button3 = new JButton("WithDraw");

        button.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        panel1.add(label);
        panel1.add(comboBox);
        panel1.add(label2);
        panel1.add(textField1);
        panel1.add(label3);
        panel1.add(textField2);
        panel1.add(label4);
        panel1.add(comboBox2);
        menuItem1.addActionListener(this);

        menu1.add(menuItem1);
        menu1.add(menuItem2);
        menuBar.add(menu1);
        menuBar.add(menu2);

        comboBox.addItem("Choose Account");
        comboBox2.addItem("Choose Account");
        try {
            Save.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(ListAccount.listMyAccount != null){
            for(int index=0;index<ListAccount.listMyAccount.size();index++){
                System.out.println(ListAccount.getAccount(index).getName());
                comboBox.addItem(ListAccount.getAccount(index).getName());
                comboBox2.addItem(ListAccount.getAccount(index).getName());
                i++;
            }
        }

        comboBox.addItemListener(this);




        panel2.add(button);
        panel2.add(button2);
        panel2.add(button3);
        frame.add(panel1,BorderLayout.NORTH);
        frame.add(panel2,BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
        textField1.setEditable(false);

    }

    public static void main(String[] args) {
        AccountGUI accountGUI = new AccountGUI();
        accountGUI.init();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getActionCommand().equals("New") && !textField2.getText().equals("") ){
         comboBox.addItem("Account"+i);
         ListAccount.addAccount(new MyAccount("Account"+i));
         comboBox2.addItem("Account"+i);
         ListAccount.getAccount(i-1).deposite(Double.parseDouble(textField2.getText()));
         textField2.setText("");
         i++;

     }else if(e.getActionCommand().equals("Deposite")){
         if(comboBox2.getSelectedItem().equals("Choose Account")){
             ListAccount.getAccount(comboBox.getSelectedIndex()-1).deposite(Double.parseDouble(textField2.getText()));
             textField2.setText("");
             textField1.setText(ListAccount.getAccount(comboBox.getSelectedIndex()-1).getBalance()+"");
         }
         else{
             if(ListAccount.getAccount(comboBox.getSelectedIndex()-1).getBalance()-Double.parseDouble(textField2.getText()) >=0) {
                 ListAccount.getAccount(comboBox2.getSelectedIndex() - 1).deposite(Double.parseDouble(textField2.getText()));
                 ListAccount.getAccount(comboBox.getSelectedIndex()-1).withDraw(Double.parseDouble(textField2.getText()));
                 textField2.setText("");
                 textField1.setText(ListAccount.getAccount(comboBox.getSelectedIndex()-1).getBalance()+"");
             }
         }

     }else if(e.getActionCommand().equals("WithDraw")){

     }
     else if(e.getActionCommand().equals("Exit")){
         System.exit(0);
     }else if(e.getActionCommand().equals("Save")){
         Save.write(ListAccount.allAccount());
     }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        for (int j = 1;j<=i;j++){
            if(e.getItem().equals("Account"+j)) {
                textField1.setText(ListAccount.getAccount(j - 1).getBalance() + "");
            }
        }
    }
    public  void setCommobox(){

    }
}
