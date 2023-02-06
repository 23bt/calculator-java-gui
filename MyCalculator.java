import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

public class MyCalculator extends JFrame implements ActionListener{  

        double number, answer;
        int calculation;

        JTextField res = new JTextField("", 18);
        JButton back = new JButton("<-");//creating <- JButton 
        JButton clear = new JButton("C");//creating C JButton
        JButton plus = new JButton("+");//creating + JButton

        JButton minus = new JButton("-");//creating - JButton 
        JButton mul = new JButton("*");//creating * JButton
        JButton div = new JButton("/");//creating / JButton
        JButton equal = new JButton("        =        ");//creating = JButton
        JButton dot = new JButton(" . ");//creating . JButton

        //Create number buttons
        JButton b0 = new JButton(" 0 ");
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");

        JRadioButton on = new JRadioButton ("ON");
        JRadioButton off = new JRadioButton ("OFF");

        JPanel panel1 = new JPanel ();
        JPanel panel2 = new JPanel ();
        JPanel panel3 = new JPanel ();
        JPanel panel4 = new JPanel ();
        JPanel panel5 = new JPanel ();

        public MyCalculator() {
            setLayout(new FlowLayout());//using layout managers 

            panel1.add(res);//adding result area  
            add(panel1);
                
            panel2.setLayout(new BorderLayout());
            panel2.add(on,BorderLayout.NORTH);//adding on, off  
            panel2.add(off,BorderLayout.SOUTH);
            panel3.add(panel2);

            panel3.add(back); 
            panel3.add(clear);
            panel3.add(plus);
            add(panel3);

            panel4.setLayout(new java.awt.GridLayout(3, 4, 6, 6));
            //panel4.setLayout(new java.awt.GridBagLayout());
            panel4.add(b7);
            panel4.add(b8);
            panel4.add(b9);
            panel4.add(minus);
            panel4.add(b4);
            panel4.add(b5);
            panel4.add(b6);
            panel4.add(mul);
            panel4.add(b1);
            panel4.add(b2);
            panel4.add(b3);
            panel4.add(div);
            add(panel4);

            setLayout(new FlowLayout(FlowLayout.LEFT));
            panel5.setLayout(new FlowLayout(FlowLayout.LEFT));
            panel5.add(b0);
            panel5.add(dot);
            panel5.add(equal);
            add(panel5);

            b1.addActionListener(this);
            b2.addActionListener(this);
            b3.addActionListener(this);
            b4.addActionListener(this);
            b5.addActionListener(this);
            b6.addActionListener(this);
            b7.addActionListener(this);
            b8.addActionListener(this);
            b9.addActionListener(this);

            back.addActionListener(this);
            clear.addActionListener(this);
            dot.addActionListener(this);

            plus.addActionListener(this);
            minus.addActionListener(this);
            equal.addActionListener(this);
            div.addActionListener(this);
            mul.addActionListener(this);
            
            on.addActionListener(this);
            off.addActionListener(this);

            setTitle("My Calculator");
            setSize(300,500);//400 width and 500 height  
            setVisible(true);//making the frame visible  
        }  


        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source == on) {
                enable();//Calling enable() function
                
            } else if (source == off) {
                disable();//Calling disable function
                
            } else if (source == clear) {
                //Clearing texts of label and text field
                res.setText("");

            } else if (source == back) {
                //Setting functionality for delete button(backspace)
                int length = res.getText().length();
                int number = length - 1;
     
                if (length > 0) {
                    StringBuilder back = new StringBuilder(res.getText());
                    back.deleteCharAt(number);
                    res.setText(back.toString());
                }
              
            } else if (source == b0) {
                if (res.getText().equals("0")) {
                    return;
                } else {
                    res.setText(res.getText() + "0");
                }
            } else if (source == b1) {
                res.setText(res.getText() + "1");
            } else if (source == b2) {
                res.setText(res.getText() + "2");
            } else if (source == b3) {
                res.setText(res.getText() + "3");
            } else if (source == b4) {
                res.setText(res.getText() + "4");
            } else if (source == b5) {
                res.setText(res.getText() + "5");
            } else if (source == b6) {
                res.setText(res.getText() + "6");
            } else if (source == b7) {
                res.setText(res.getText() + "7");
            } else if (source == b8) {
                res.setText(res.getText() + "8");
            } else if (source == b9) {
                res.setText(res.getText() + "9");
            } else if (source == dot) {
                if (res.getText().contains(".")) {
                    return;
                } else {
                    res.setText(res.getText() + ".");
                }
     
            } else if (source == plus) {
                //String str = res.getText();
                number = Double.parseDouble(res.getText());
                res.setText("");

                calculation = 1;
            } else if (source == minus) {
                //String str = res.getText();
                number = Double.parseDouble(res.getText());
                res.setText("");
               
                calculation = 2;
            } else if (source == mul) {
                //String str = res.getText();
                number = Double.parseDouble(res.getText());
                res.setText("");
                
                calculation = 3;
            } else if (source == div) {
                //String str = res.getText();
                number = Double.parseDouble(res.getText());
                res.setText("");
               
                calculation = 4;
            } 
            else if (source == equal) {
               //Setting functionality for equal(=) button
                switch (calculation) {
                    case 1:
                        answer = number + Double.parseDouble(res.getText());
                        if (Double.toString(answer).endsWith(".0")) {
                            res.setText(Double.toString(answer).replace(".0", ""));
                        } else {
                            res.setText(Double.toString(answer));
                        }
                        
                        break;
                    case 2:
                        answer = number - Double.parseDouble(res.getText());
                        if (Double.toString(answer).endsWith(".0")) {
                            res.setText(Double.toString(answer).replace(".0", ""));
                        } else {
                            res.setText(Double.toString(answer));
                        }
                        
                        break;
                    case 3:
                        answer = number * Double.parseDouble(res.getText());
                        if (Double.toString(answer).endsWith(".0")) {
                            res.setText(Double.toString(answer).replace(".0", ""));
                        } else {
                            res.setText(Double.toString(answer));
                        }
                       
                        break;
                    case 4:
                        answer = number / Double.parseDouble(res.getText());
                        if (Double.toString(answer).endsWith(".0")) {
                            res.setText(Double.toString(answer).replace(".0", ""));
                        } else {
                            res.setText(Double.toString(answer));
                        }
                        
                        break;
                }
            }
        }

        public void enable() {
            on.setEnabled(false);
            off.setEnabled(true);
            res.setEnabled(true);
            res.setEditable(true);
            back.setEnabled(true);
            clear.setEnabled(true);
            plus.setEnabled(true);
            b7.setEnabled(true);
            b8.setEnabled(true);
            b9.setEnabled(true);
            minus.setEnabled(true);
            b4.setEnabled(true);
            b5.setEnabled(true);
            b6.setEnabled(true);
            mul.setEnabled(true);
            b1.setEnabled(true);
            b2.setEnabled(true);
            b3.setEnabled(true);
            div.setEnabled(true);
            b0.setEnabled(true);
            dot.setEnabled(true);
            equal.setEnabled(true);
     
        }
     
        public void disable() {
            on.setEnabled(true);
            off.setEnabled(false);
            res.setText("");
            res.setEditable(false);
            back.setEnabled(false);
            clear.setEnabled(false);
            plus.setEnabled(false);
            minus.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            mul.setEnabled(false);
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            div.setEnabled(false);
            b0.setEnabled(false);
            dot.setEnabled(false);
            equal.setEnabled(false);
        }

        public static void main(String[] args) {  
            new MyCalculator();

    }

}  