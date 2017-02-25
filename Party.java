package Game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JScrollPane;
import java.util.ArrayList;

import java.awt.event.ActionListener;


/**
 * Created by Lian Wong on 2/25/2017.
 */
public class Party extends JFrame implements ActionListener{
    private Container pane;
    private String name;

    //opening screen
    private JPanel panel1, panel2;
    private JButton button1;

    public void actionPerformed(ActionEvent e){
        //opening

    }

    public Party(){
        setTitle("Hello World of Coding");
        setLocation(0,0);
        setSize(950,660);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pane = getContentPane();
        pane.setLayout(new CardLayout());

        //opening
        panel1 = new JPanel();
        pane.add(panel1);
        panel1.setVisible(true);
        button1 = new JButton("Party Maker!");
        panel1.add(button1);

        //ask name
        panel2 = new JPanel();
        pane.add(panel2)
    }

}
