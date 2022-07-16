/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Numata
 */
public class GUI extends JFrame implements ActionListener {

    // panels
    JPanel north, center, south;

    // input and label
    JLabel heading, lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7;
    JTextField nameInput, input1, input2, input3, input4, input5, input6, input7;

    // buttons
    JButton saveBtn, exit, resultBtn, clearBtn;

    // File classes
    FileHandler fh;

    public GUI() {

        // panel instances
        north = new JPanel();
        center = new JPanel();
        south = new JPanel();

        // label instances
        heading = new JLabel("Add You Marks");
        lbl1 = new JLabel("Home Language");
        lbl2 = new JLabel("First Additional Language");
        lbl3 = new JLabel("Life Orientation");
        lbl4 = new JLabel("Maths/Maths Lit");
        lbl5 = new JLabel("Elective 1");
        lbl6 = new JLabel("Elective 2");
        lbl7 = new JLabel("Elective 3");

        // text field instances
        nameInput = new JTextField("Enter Your Name");
        nameInput.setPreferredSize(new Dimension(155, 35));
        
        input1 = new JTextField();
        input2 = new JTextField();
        input3 = new JTextField();
        input4 = new JTextField();
        input5 = new JTextField();
        input6 = new JTextField();
        input7 = new JTextField();

        // button
        saveBtn = new JButton("Save to txt file");
        exit = new JButton("Exit");
        resultBtn = new JButton("Get Result");
        clearBtn = new JButton("Clear");
    }

    public void setGUI() {
        styleGUI();

        // add elements to panels
        north.add(heading);
        north.add(nameInput);
        center.add(lbl1);
        center.add(input1);
        center.add(lbl2);
        center.add(input2);
        center.add(lbl3);
        center.add(input3);
        center.add(lbl4);
        center.add(input4);
        center.add(lbl5);
        center.add(input5);
        center.add(lbl6);
        center.add(input6);
        center.add(lbl7);
        center.add(input7);
        south.add(saveBtn);
        south.add(resultBtn);
        south.add(exit);
        south.add(clearBtn);

        // add panel to gui
        this.add(north, BorderLayout.NORTH);
        this.add(center, BorderLayout.CENTER);
        this.add(south, BorderLayout.SOUTH);

        // event listener on btn
        saveBtn.addActionListener(this);
        exit.addActionListener(this);
        resultBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        // show GUI
        this.setSize(900, 720);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
    }

    public void styleGUI() {
        GridLayout layout = new GridLayout(7, 2);
        layout.setHgap(5);
        layout.setVgap(5);
        
        // set background color or panels
        north.setBackground(new Color(98, 0, 238));
        center.setLayout(layout);
        center.setBackground(new Color(55, 0, 179));
        south.setBackground(new Color(3, 218, 197));
        
        // change color of text
        heading.setForeground(new Color(255, 255, 255));
        lbl1.setForeground(new Color(255, 255, 255));
        lbl2.setForeground(new Color(255, 255, 255));
        lbl3.setForeground(new Color(255, 255, 255));
        lbl4.setForeground(new Color(255, 255, 255));
        lbl5.setForeground(new Color(255, 255, 255));
        lbl6.setForeground(new Color(255, 255, 255));
        lbl7.setForeground(new Color(255, 255, 255));
        
        // create padding on panel
        north.setBorder(new EmptyBorder(40, 10, 40, 10));
        center.setBorder(new EmptyBorder(40, 40, 40, 40));
        south.setBorder(new EmptyBorder(40, 10, 40, 10));
        
        // button color -> 4, 110, 196
        saveBtn.setBackground(new Color(4, 110, 196));
        saveBtn.setForeground(new Color(255, 255, 255));
        saveBtn.setPreferredSize(new Dimension(130, 40));
        
        exit.setBackground(new Color(4, 110, 196));
        exit.setForeground(new Color(255, 255, 255));
        exit.setPreferredSize(new Dimension(130, 40));
        
        resultBtn.setBackground(new Color(4, 110, 196));
        resultBtn.setForeground(new Color(255, 255, 255));
        resultBtn.setPreferredSize(new Dimension(130, 40));
        
        clearBtn.setBackground(new Color(4, 110, 196));
        clearBtn.setForeground(new Color(255, 255, 255));
        clearBtn.setPreferredSize(new Dimension(130, 40));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == saveBtn) {
            String name = nameInput.getText();

            try {
                int mark1 = Integer.parseInt(input1.getText());
                int mark2 = Integer.parseInt(input2.getText());
                int mark3 = Integer.parseInt(input3.getText());
                int mark4 = Integer.parseInt(input4.getText());
                int mark5 = Integer.parseInt(input5.getText());
                int mark6 = Integer.parseInt(input6.getText());
                int mark7 = Integer.parseInt(input7.getText());
                int[] subjectsArray = {mark1, mark2, mark3, mark4, mark5, mark6, mark7};

                Student st = new Student(name, mark1, mark2, mark3, mark4, mark5, mark6, mark7);

                fh = new FileHandler(name + ".txt");
                fh.writeToFile(st.printData());
                fh.close();
                
                // check if values are below or over 100
                boundsCheck(subjectsArray);
                
                JOptionPane.showMessageDialog(null, "Your marks are saved");
            } catch (NumberFormatException nf) {
                JOptionPane.showMessageDialog(null, "You have to enter numbers");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please enter numbers from 1 - 100");
            }

        } else if (ae.getSource() == resultBtn) {
            String name = nameInput.getText();

            try {
                int mark1 = Integer.parseInt(input1.getText());
                int mark2 = Integer.parseInt(input2.getText());
                int mark3 = Integer.parseInt(input3.getText());
                int mark4 = Integer.parseInt(input4.getText());
                int mark5 = Integer.parseInt(input5.getText());
                int mark6 = Integer.parseInt(input6.getText());
                int mark7 = Integer.parseInt(input7.getText());

                String[] subjectNames = {"Home Language", "First Additional Language",
                    "Life Orientation", "Maths/ Maths Literacy", "Elective 1", "Elective 2", "Elective 3"};
                int[] subjectsArray = {mark1, mark2, mark3, mark4, mark5, mark6, mark7};
                int[] marks = new int[subjectsArray.length];
 
                // get code and store in marks array
                this.getCode(subjectsArray, marks);

                // calculate APS
                int aps = calculateAPS(marks);
                
                // get average
                String average = getAverage(subjectsArray) + "";
                
                // render result
                String results = "";
                for (int i = 0; i < marks.length; i++) {
                    results += subjectNames[i] + " - " + marks[i] + "\n";
                }
                
                // check if values are below or over 100
                boundsCheck(subjectsArray);

                JOptionPane.showMessageDialog(null, results);
                JOptionPane.showMessageDialog(null, "Your average mark is: " + average + "\nYour APS is: " + aps);
            } catch (NumberFormatException nf) {
                JOptionPane.showMessageDialog(null, "You have to enter numbers");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please enter numbers from 1 - 100");
            }
        } else if (ae.getSource() == clearBtn) {
            nameInput.setText("");
            input1.setText("");
            input2.setText("");
            input3.setText("");
            input4.setText("");
            input5.setText("");
            input6.setText("");
            input7.setText("");
        }
    }
    
    public int getAverage(int[] subjectsArray) {
        int average = calculateAPS(subjectsArray) / subjectsArray.length;
        return average;
    }
    
    public void boundsCheck(int[] array) throws Exception {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0 || array[i] > 100) {
                throw new Exception();
            }
        }
    }

    public int calculateAPS(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != 2) {
                sum += arr[i];
            }
        }

        return sum;
    }

    public int getCode(int[] subjectsArray, int[] marks) {
        int code = 0;

        for (int i = 0; i < subjectsArray.length; i++) {
            if (subjectsArray[i] < 30) {
                code = 1;
            } else if (subjectsArray[i] >= 30 && subjectsArray[i] < 40) {
                code = 2;
            } else if (subjectsArray[i] >= 40 && subjectsArray[i] < 50) {
                code = 3;
            } else if (subjectsArray[i] >= 50 && subjectsArray[i] < 60) {
                code = 4;
            } else if (subjectsArray[i] >= 60 && subjectsArray[i] < 70) {
                code = 5;
            } else if (subjectsArray[i] >= 70 && subjectsArray[i] < 80) {
                code = 6;
            } else if (subjectsArray[i] >= 80 && subjectsArray[i] <= 100) {
                code = 7;
            }
            marks[i] = code;
        }

        return code;
    }

    public static void main(String[] args) {

        GUI g = new GUI();
        g.setGUI();

    }
}
