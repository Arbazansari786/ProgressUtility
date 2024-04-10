package com.dialogutility;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ConfirmDialog extends JDialog {

    private JPanel contentPane;

    Boolean isConfirm = null;


    public ConfirmDialog(String title, String message, boolean isSuccess) {


        Color labelColor = null;
        Color yesColor = new Color(44, 183, 44);
        Color noColor = new Color(229, 24, 24);
        if (isSuccess)
            labelColor = new Color(47, 123, 252);
        else
            labelColor = new Color(236, 23, 23);


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
        titleLabel.setForeground(labelColor);
        titleLabel.setBackground( new Color(255, 245, 244, 255));
        titleLabel.setOpaque(true);

        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(titleLabel, BorderLayout.NORTH);

        JLabel messageLabel = new JLabel(message);
        messageLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(messageLabel, BorderLayout.CENTER);


        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton yesButton = new JButton("Yes");
        yesButton.setForeground(Color.WHITE);
        yesButton.setBackground(yesColor);
        yesButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle "Yes" button action
                isConfirm = true;
                dispose(); // Close the dialog
            }
        });
        JButton noButton = new JButton("No");
        noButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
        noButton.setForeground(Color.white);
        noButton.setBackground(noColor);
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle "No" button action
                isConfirm = false;
                dispose(); // Close the dialog
            }
        });
        yesButton.setBorderPainted(false); // Remove border
        noButton.setBorderPainted(false); // Remove border
        yesButton.setFocusPainted(false); // Remove focus border
        noButton.setFocusPainted(false); // Remove focus border
        yesButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set default arrow cursor
        noButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set default arrow cursor


        buttonPanel.add(noButton);
        buttonPanel.add(yesButton);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
    }

    public Boolean getConfirmation() {
        return isConfirm;
    }


}
