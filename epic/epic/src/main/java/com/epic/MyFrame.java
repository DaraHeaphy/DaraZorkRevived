package com.epic;
import javax.swing.*;
import javax.swing.border.BevelBorder;

import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//relevant imports
public class MyFrame extends JFrame {
	
	@Autowired
	private DM_RD dmRD;
	
	@Autowired
	private DM_ID dmID;
	
	@Autowired
	private CS_RD csRD;
	
	@Autowired
	private CS_ID csID;
	
	@Autowired
	private CO_RD coRD;
	
	@Autowired
	private CO_ID coID;
	
	@Autowired
	private QUIZTHREE quizThree;
	
    JButton button;
    //buttons added
    JButton button2;

    JButton button3;

    JButton button4;

    JButton buttonL;

    MyFrame() {
        ImageIcon background = new ImageIcon("back.png");
        //logo import
        ImageIcon logo = new ImageIcon("KS.png");
        button = new JButton();
        button.setBounds(900, 60, 600, 200);
        //position and size of button
        button.setText("Discrete Mathematics");
        button.setFont(new Font("Monospaced", Font.BOLD, 25));
        button.setFocusable(false);
        button.setIcon(background);
        //removes square around text
        button.setVerticalTextPosition(JButton.CENTER);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dmID.run();
                //redirects to next class
            }
        });

        button2 = new JButton();
        button2.setBounds(10, 320, 600, 200);
        button2.setText("Computer Organization");
        button2.setFont(new Font("Monospaced", Font.BOLD, 25));
        button2.setFocusable(false);
        button2.setIcon(background);
        button2.setVerticalTextPosition(JButton.CENTER);
        button2.setHorizontalTextPosition(JButton.CENTER);
        button2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coID.run();
            }
        });

        button3 = new JButton();
        button3.setBounds(900, 580, 600, 200);
        button3.setText("Computer Science");
        button3.setFont(new Font("Monospaced", Font.BOLD, 25));
        button3.setFocusable(false);
        button3.setIcon(background);
        button3.setVerticalTextPosition(JButton.CENTER);
        button3.setHorizontalTextPosition(JButton.CENTER);
        button3.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                csID.run();
            }
        });

        button4 = new JButton();
        button4.setBounds(900, 320, 600, 200);
        button4.setText("Who Wants to be a Millionaire");
        button4.setFont(new Font("Monospaced", Font.BOLD, 25));
        button4.setFocusable(false);
        button4.setIcon(background);
        button4.setVerticalTextPosition(JButton.CENTER);
        button4.setHorizontalTextPosition(JButton.CENTER);
        button4.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quizThree.run();
            }
        });

        buttonL = new JButton();
        buttonL.setBounds(10, 20, 600, 150);
        buttonL.setFocusable(false);
        buttonL.setIcon(logo);
        buttonL.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));


        this.add(button);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(buttonL);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.validate();
        this.getContentPane().setBackground(new Color(255, 150, 150));
        //custom color
        this.setVisible(true);
    }
}