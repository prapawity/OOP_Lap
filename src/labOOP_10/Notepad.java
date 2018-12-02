package labOOP_10;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Notepad implements ActionListener {
    JFrame frame;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem1,menuItem2,menuItem3,menuItem4;
    JTextArea textArea;
    GetSaveNotepad getSaveNotepad;
    File file;
    JFileChooser chooser = new JFileChooser();
    JScrollPane scrollPane ;
    int test,state = 0;

    public void init(){

        frame = new JFrame("NotePad");
        frame.setSize(800,800);
        menuBar = new JMenuBar();
        menu = new JMenu("File");
        menuItem1 = new JMenuItem("Open");
        menuItem2 = new JMenuItem("Save");
        menuItem3 = new JMenuItem("New");
        menuItem4 = new JMenuItem("Exit");



        menuItem1.addActionListener(this);
        menuItem2.addActionListener(this);
        menuItem3.addActionListener(this);
        menuItem4.addActionListener(this);
        textArea = new JTextArea(0,10);
        textArea.setEditable(false);
        textArea.setAutoscrolls(true);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuItem3);
        menu.add(menuItem4);
        menuBar.add(menu);
        frame.add(scrollPane);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Notepad notepad = new Notepad();
        notepad.init();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Open":{
                test = chooser.showDialog(null,"Open");
                if(test == JFileChooser.APPROVE_OPTION) {
                    file = chooser.getSelectedFile();
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(file));
                        String line;
                        frame.setTitle(file.toString());
                        while ((line = br.readLine()) != null) {
                            //System.out.println(line);
                            textArea.append(line);
                        }
                        br.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    state = 1;
                }
                break;
            }
            case "Save":{
                if(state==0) {
                    test = chooser.showDialog(null, "Save");
                    file = chooser.getSelectedFile();
                    if (test == JFileChooser.APPROVE_OPTION)
                        getSaveNotepad.saveBalance(textArea.getText(), file.getName());
                }
                else{
                    getSaveNotepad.saveBalance(textArea.getText(), file.getName());
                }
                break;
            }case "New":{
                state = 0;
                textArea.setText("");
                textArea.setEditable(true);
                break;
            }
            case "Exit":{
                System.exit(1);
                break;
            }
        }

    }
}
