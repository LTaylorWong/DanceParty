
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import PartyRoom;
import sun.audio.*;

import java.awt.event.ActionListener;


/**
 * Created by Lian Wong on 2/25/2017.
 */
public class Party extends JFrame implements ActionListener, MouseListener{
    private Container pane;
    private String name;
    public String outputCode = "";

    private JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7,panel8;
    private JButton button1, button2, button3;
    private JButton addPeeps, addSize, addBalloons;
    private JButton chooseFood, chooseMusic;
    private JButton inviteYes, inviteNo;
    private JTextArea intInputs, condInputs, boolInputs, codeOutput, codeOutput2, codeOutput3,codeOutput4;

    private ImageIcon G1,G2,G3,G4,G5;
    private JLabel p1,p2,p3,p4,p5;
    private JLabel finalOuput;

    private int numPeople;
    private int roomSize;
    private int numBalloons;
    private String food;
    private String music;
    private boolean needInvitation;

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button1){
            //ask name
            this.name = JOptionPane.showInputDialog("What is your name?");
            panel2.setVisible(true);
            panel1.setVisible(false);
        }else if(e.getSource() == button2){
            panel3.setVisible(true);
            panel2.setVisible(false);
        }else if(e.getSource() == addPeeps){
            String input2 = JOptionPane.showInputDialog("Insert number of people");
            intInputs.append("Number of people:" + input2 + "\n" +
                            "What is the size of your party space? \n");
            this.outputCode += "int numPeople = " + input2 + "\n";
            codeOutput.append("int numPeople = " + input2 + "\n");
            this.numPeople = Integer.parseInt(input2);
        }else if(e.getSource() == addSize){
            String input3 = JOptionPane.showInputDialog("Insert size of the room");
            intInputs.append("Size of room: " + input3 + "\n" +
                            "How many balloons do you want? \n");
            this.outputCode += "int roomSize = " + input3 + "\n";
            codeOutput.append("int roomSize = " + input3 + "\n");
            this.roomSize = Integer.parseInt(input3);
        }else if(e.getSource() == addBalloons){
            String input4 = JOptionPane.showInputDialog("Insert number of balloons");
            intInputs.append("Number of Balloons: " + input4 + "\n");
            this.outputCode += "int numBalloons = " + input4 + "\n";
            codeOutput.append("int numBalloons = " + input4 + "\n");
            this.numBalloons = Integer.parseInt(input4);
            panel4.setVisible(true);
            panel3.setVisible(false);

        }else if(e.getSource() == chooseFood){
            String food = JOptionPane.showInputDialog("Choose: Pizza, Cake, or Ice Cream");
            condInputs.append("Food at the party: " + food+ "\n");
            codeOutput2.append("userInput: " + food + "\n" +
                                "if userInput == " + food +
                                "\n display picture of " + food + "\n");
            this.outputCode += "userInput: " + food + "\n" +
                    "if userInput == " + food + "\n" +
                    "display picture of " + food + "\n";
            this.food = food;
        }else if(e.getSource() == chooseMusic){
            String music = JOptionPane.showInputDialog("Choose: Happy Birthday, Jingle Bells, Ice Cream");
            condInputs.append("Music at the party: " + music + "\n");
            codeOutput2.append("userInput: " + music + "\n" +
                    "if userInput == " + music + "\n" +
                    "play " + music);
            this.outputCode += "userInput: " + music + "\n" +
                    "if userInput == " + music +
                    "play " + music;
            this.music = music;
            panel5.setVisible(true);
            panel4.setVisible(false);

        }else if(e.getSource() == inviteYes){
            boolInputs.append("Guests need an invitation to the party");
            codeOutput3.append("boolean needInvitation = " + true + "\n");
            outputCode += "boolean needInvitation = " + true + "\n";
            this.needInvitation = true;
            panel6.setVisible(true);
            panel5.setVisible(false);
        }else if(e.getSource() == inviteNo){
            boolInputs.append("Guests do not need an invitation to the party");
            codeOutput3.append("boolean needInvitation = " + false + "\n");
            outputCode += "boolean needInvitation = " + false + "\n";
            this.needInvitation = false;
            panel6.setVisible(true);
            panel5.setVisible(false);
        }else if(e.getSource() == button3){
            panel7.setVisible(true);
            panel6.setVisible(false);
            PartyRoom p = new PartyRoom(numPeople,roomSize,numBalloons,food,music,needInvitation);
            if(food.equals("Pizza")){
                p1.setVisible(true);
            }
            else if(food.equals("Cake")){
             p2.setVisible(true);
            }
            else{
                p3.setVisible(true);
            }
            for(int i = 0; i < numPeople ; i ++){
                G4 = new ImageIcon(getClass().getResource("dancing-stick-figure.png"));
                p4 = new JLabel(G4);
                panel7.add(p4);
            }
        }

    }
    public void mouseClicked(MouseEvent e) {
        panel7.setVisible(false);
        finalOuput = new JLabel("Output code for " + this.name + "'s party");
        panel8.add(finalOuput);
        panel8.setVisible(true);
        panel8.add(codeOutput4);
        codeOutput4.append(outputCode);
    }
    public void mouseExited(MouseEvent e) {
        //not used
    }
    public void mousePressed(MouseEvent e) {
//not used
    }

    public void mouseReleased(MouseEvent e) {
//not used
    }
    public void mouseEntered(MouseEvent e) {
//not used
    }

    public Party(){
        setTitle("Hello World of Coding");
        setLocation(0,0);
        setSize(950,660);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pane = getContentPane();
        pane.setLayout(new CardLayout(40, 30));

        //opening
        panel1 = new JPanel();
        pane.add(panel1);
        panel1.setVisible(true);
        button1 = new JButton("Party Maker!");
        button1.addActionListener(this);
        button1.setPreferredSize(new Dimension(950,660));
        panel1.add(button1, BorderLayout.CENTER);


        //make party time
        panel2 = new JPanel();
        pane.add(panel2);
        button2 = new JButton("LETS GO MAKE YOUR PARTY");
        button2.addActionListener(this);
        button2.setPreferredSize(new Dimension(950,660));
        panel2.add(button2);

        //making teaching primatives
        panel3 = new JPanel();
        panel3.setVisible(false);
        pane.add(panel3);
        intInputs = new JTextArea("How many people can come to your party? (Click 'Set number of people') \n");
        intInputs.setColumns(70);
        intInputs.setRows(10);
        codeOutput = new JTextArea("Output Code: \n");
        codeOutput.setColumns(70);
        codeOutput.setRows(10);
        addPeeps = new JButton("Set number of people\n");
        addSize = new JButton("Set room size\n");
        addBalloons = new JButton("Set number of balloons\n");
        addPeeps.setBounds(100,100,100,100);
        addPeeps.addActionListener(this);
        addSize.addActionListener(this);
        addBalloons.addActionListener(this);
        panel3.add(intInputs);
        panel3.add(addPeeps);
        panel3.add(addSize);
        panel3.add(addBalloons);
        panel3.add(codeOutput);

        //teaching conditionals
        panel4 = new JPanel();
        panel4.setVisible(false);
        pane.add(panel4);
        condInputs = new JTextArea("What kind of food do you want for your party? \n");
        condInputs.setColumns(70);
        condInputs.setRows(10);
        panel4.add(condInputs);
        chooseFood = new JButton("Choose your food");
        chooseMusic = new JButton("Choose your music");
        chooseFood.addActionListener(this);
        chooseMusic.addActionListener(this);
        panel4.add(chooseFood);
        panel4.add(chooseMusic);
        codeOutput2 = new JTextArea("Output Code: \n");
        codeOutput2.setColumns(70);
        codeOutput2.setRows(10);
        panel4.add(codeOutput2);

        //teaching booleans
        panel5 = new JPanel();
        panel5.setVisible(false);
        pane.add(panel5);
        boolInputs = new JTextArea("Do your party guests need invitations? \n");
        boolInputs.setColumns(70);
        boolInputs.setRows(10);
        panel5.add(boolInputs);
        inviteYes = new JButton("     Yes    ");
        inviteNo = new JButton("     No     ");
        inviteYes.addActionListener(this);
        inviteNo.addActionListener(this);
        panel5.add(inviteYes);
        panel5.add(inviteNo);
        codeOutput3 = new JTextArea("Output code: \n");
        codeOutput3.setColumns(70);
        codeOutput3.setRows(10);
        panel5.add(codeOutput3);

        //generate party
        panel6 = new JPanel();
        panel6.setVisible(false);
        pane.add(panel6);
        button3 = new JButton("GET THIS PARTY STARTED!!");
        panel6.add(button3);
        button3.addActionListener(this);
        button3.setPreferredSize(new Dimension(950,660));

        //party
        panel7 = new JPanel();
        G5 = new ImageIcon(getClass().getResource("ballons.png"));
        p5 = new JLabel(G5);
        p5.addMouseListener(this);
        panel7.add(p5);
        panel7.setVisible(false);
        pane.add(panel7);
        G1 = new ImageIcon(getClass().getResource("pizza.png"));
        p1 = new JLabel(G1);
        panel7.add(p1);
        p1.setVisible(false);
        G2 = new ImageIcon(getClass().getResource("cake.jpg"));
        p2 = new JLabel(G2);
        panel7.add(p2);
        p2.setVisible(false);
        G3 = new ImageIcon(getClass().getResource("iceCream.jpg"));
        p3 = new JLabel(G3);
        panel7.add(p3);
        p3.setVisible(false);

        //final code
        panel8 = new JPanel();
        pane.add(panel8);
        panel8.setVisible(false);

        codeOutput4 = new JTextArea();
        codeOutput4.setColumns(70);
        codeOutput4.setRows(10);




    }

    public static void main(String[] args){
        Party p = new Party();
        p.setVisible(true);
    }

}
