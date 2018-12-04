package Practice_Final.FullBank;

import Practice_Final.ListAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

public class GUIBANK extends JLabel implements ActionListener, ItemListener {
    int i = 1;
    String hour, min,sec;
    JFrame frame = new JFrame("BankGUI");
    JMenuBar menuBar = new JMenuBar();
    JMenu menu1,menu2;
    JMenuItem menuItem1,menuItem2,menuItem3;
    JComboBox comboBox1 = new JComboBox(),comboBox2 = new JComboBox();
    JTextField textField1 = new JTextField(),textField2 = new JTextField();
    JPanel panel1 = new JPanel(new GridLayout(4,2)),panel2 = new JPanel(new FlowLayout());
    JLabel label = new JLabel("Account"),label2 = new JLabel("Balance"),label3 = new JLabel("Amount"),label4 = new JLabel("Tranfer to");
    JButton button1 = new JButton("New"), button2 = new JButton("Deposite"),button3 = new JButton("WithDraw");
    JTextArea textArea = new JTextArea(5, 35);
    JScrollPane scrollPane;
    JFileChooser chooser = new JFileChooser();
    File file;
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Save")){
            SaveFull.write(ArrayOfaccount.allAccount());

        }
        else if(e.getActionCommand().equals("Open")){
            int test = 0;
            test = chooser.showDialog(null,"Open");
            if(test == JFileChooser.APPROVE_OPTION) {
                file = chooser.getSelectedFile();
                try {
                    SaveFull.read(file);
                    if(ArrayOfaccount.listAccountBank != null){
                        for(int indexy=0;indexy<ArrayOfaccount.listAccountBank.size();indexy++)
                        {
                            comboBox1.addItem(ArrayOfaccount.listAccountBank.get(indexy).getName());
                            comboBox2.addItem(ArrayOfaccount.listAccountBank.get(indexy).getName());
                            i++;
                        }
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                JOptionPane.showMessageDialog(null,"Load Complete");
            }

        }
        else if(e.getActionCommand().equals("Exit")){
            System.exit(0);

        }
        else if(e.getActionCommand().equals("New")){
            if(!textField2.getText().isEmpty()) if(Double.parseDouble(textField2.getText())>=0){
                ArrayOfaccount.listAccountBank.add(new AccountBank("Account"+i,Double.parseDouble(textField2.getText())));
                ArrayOfaccount.listAccountBank.get(i-1).setLog("Register!! Account "+i+" "+Calendar.getInstance().getTime()+"\nDeposite: "+Double.parseDouble(textField2.getText()),i-1);
                comboBox1.addItem("Account"+i);
                comboBox2.addItem("Account"+i);
                textField2.setText("");
                textField1.setText(ArrayOfaccount.listAccountBank.get(i-1).getBalance()+"");
                comboBox1.setSelectedIndex(i);
                i++;
            }


        }else if(e.getActionCommand().equals("Deposite")){
            if(!textField2.getText().isEmpty()) if(Double.parseDouble(textField2.getText())>=0) {
                if (comboBox2.getSelectedIndex() == 0) {
                    ArrayOfaccount.listAccountBank.get(comboBox1.getSelectedIndex()-1).setBalance(Double.parseDouble(textField2.getText()));
                    ArrayOfaccount.listAccountBank.get(comboBox1.getSelectedIndex()-1).setLog("Deposite: "+Double.parseDouble(textField2.getText())+" "+Calendar.getInstance().getTime(),comboBox1.getSelectedIndex()-1);
                    textField1.setText(ArrayOfaccount.listAccountBank.get(comboBox1.getSelectedIndex()-1).getBalance()+"");
                    textField2.setText("");
                    textArea.setText("");
                    textArea.setText(ArrayOfaccount.listAccountBank.get(comboBox1.getSelectedIndex()-1).getLog(comboBox1.getSelectedIndex()-1));

                } else {
                    if(ArrayOfaccount.listAccountBank.get(comboBox1.getSelectedIndex()-1).getBalance()>=Double.parseDouble(textField2.getText())){
                        ArrayOfaccount.listAccountBank.get(comboBox2.getSelectedIndex()-1).setBalance(Double.parseDouble(textField2.getText()));
                        ArrayOfaccount.listAccountBank.get(comboBox1.getSelectedIndex()-1).setBalance(-Double.parseDouble(textField2.getText()));
                        ArrayOfaccount.listAccountBank.get(comboBox1.getSelectedIndex()-1).setLog("Tranfer to: "+comboBox2.getSelectedItem()+" for "+Double.parseDouble(textField2.getText())+" "+Calendar.getInstance().getTime(),comboBox1.getSelectedIndex()-1);
                        ArrayOfaccount.listAccountBank.get(comboBox2.getSelectedIndex()-1).setLog("Deposite: "+Double.parseDouble(textField2.getText())+" By "+comboBox1.getSelectedItem()+" "+Calendar.getInstance().getTime(),comboBox2.getSelectedIndex()-1);
                        textField1.setText(ArrayOfaccount.listAccountBank.get(comboBox1.getSelectedIndex()-1).getBalance()+"");
                        textField2.setText("");
                        textArea.setText("");
                        textArea.setText(ArrayOfaccount.listAccountBank.get(comboBox1.getSelectedIndex()-1).getLog(comboBox1.getSelectedIndex()-1));
                    }else textArea.setText("Your Credit is not Enough");

                }
            }

        }else if(e.getActionCommand().equals("WithDraw")){
            if(!textField2.getText().isEmpty()) if(Double.parseDouble(textField2.getText())>=0){
                if(ArrayOfaccount.listAccountBank.get(comboBox1.getSelectedIndex()-1).getBalance()>=Double.parseDouble(textField2.getText())){
                    ArrayOfaccount.listAccountBank.get(comboBox1.getSelectedIndex()-1).setBalance(-Double.parseDouble(textField2.getText()));
                    ArrayOfaccount.listAccountBank.get(comboBox1.getSelectedIndex()-1).setLog("WithDraw: "+Double.parseDouble(textField2.getText())+" "+Calendar.getInstance().getTime(),comboBox1.getSelectedIndex()-1);
                    textField1.setText(ArrayOfaccount.listAccountBank.get(comboBox1.getSelectedIndex()-1).getBalance()+"");
                    textField2.setText("");
                    textArea.setText(ArrayOfaccount.listAccountBank.get(comboBox1.getSelectedIndex()-1).getLog(comboBox1.getSelectedIndex()-1));

                }
                else textArea.setText("Your Credit is not Enough");
            }
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        textArea.setText("");
        if(comboBox1.getSelectedItem().equals(e.getItem()) & comboBox1.getSelectedIndex()!=0){
            textField1.setText(ArrayOfaccount.listAccountBank.get(comboBox1.getSelectedIndex()-1).getBalance()+"");
            textArea.setText(ArrayOfaccount.listAccountBank.get(comboBox1.getSelectedIndex()-1).getLog(comboBox1.getSelectedIndex()-1)+"");
        }
    }

    public void init(){
        frame.setJMenuBar(menuBar);
        menu1 = new JMenu("File");
        menu2 = new JMenu("Option");
        textField1.addActionListener(this);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        textField1.setEditable(false);
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuItem1 = new JMenuItem("Open");
        menuItem2 = new JMenuItem("Save");
        menuItem3 = new JMenuItem("Exit");
        menu1.add(menuItem1);
        menu1.add(menuItem2);
        menu1.add(menuItem3);
        panel1.add(label);
        panel1.add(comboBox1);
        panel1.add(label2);
        panel1.add(textField1);
        panel1.add(label3);
        panel1.add(textField2);
        panel1.add(label4);
        panel1.add(comboBox2);
        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);
        comboBox1.addItem("Select Account");
        comboBox2.addItem("Select Account");

        menuItem1.addActionListener(this);
        menuItem2.addActionListener(this);
        menuItem3.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        comboBox1.addItemListener(this);



        frame.add(panel1,BorderLayout.NORTH);
        frame.add(panel2,BorderLayout.CENTER);
        frame.add(scrollPane,BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();

    }

    public static void main(String[] args) {
        GUIBANK guibank = new GUIBANK();
        guibank.init();
    }

}
