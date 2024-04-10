package com.dialogutility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DialogBox extends JFrame {

    private JPanel contentPane;


    public DialogBox(String title, String message, boolean isSuccess) {

        Color color=null;
        if(isSuccess)
            color=new Color(47, 123, 252);
        else
            color=new Color(139, 0, 0);

        setUndecorated(true);
        setSize(350, 150);
        setLocationRelativeTo(null); // Center the dialog on the screen
        setResizable(false);

        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
        titleLabel.setForeground(color);

        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(titleLabel, BorderLayout.NORTH);

        JLabel messageLabel = new JLabel(message);
        messageLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(messageLabel, BorderLayout.CENTER);
//        messageLabel.setPreferredSize(new Dimension(250,250));


        JButton closeButton = new JButton("Close");
        closeButton.setOpaque(true);
        closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        closeButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
        closeButton.setForeground(Color.WHITE);
        closeButton.setBackground(color);
        closeButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15)); // Add padding
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the dialog
            }
        });
        contentPane.add(closeButton, BorderLayout.SOUTH);
    }






}
