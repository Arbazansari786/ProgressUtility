package com.progressutility;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

public class ProgressBarUtility {
    private final JFrame frame;
    private final ProgressBarCustom progressBar;
    private final JLabel progressLabel;

    private final JButton pauseButton;
    JButton resumeButton;

    private boolean paused = false;


    //Creation Of ProgressBar
    public ProgressBarUtility(String title, String iconPath) throws IOException {


        //Setting the Frame
        frame = new JFrame(title);
        frame.setSize(320, 150);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setBackground(Color.WHITE);
        if (iconPath != null) {
            ImageIcon icon = new ImageIcon(iconPath);
            frame.setIconImage(icon.getImage());
        }

        //Setting the ProgressBar and ProgressLabel
        progressLabel = new JLabel();
        frame.add(progressLabel);
        frame.add(Box.createVerticalStrut(25));
        progressBar = new ProgressBarCustom();
        frame.add(progressBar);
        frame.add(Box.createVerticalStrut(35));


        // Setting the BUtton
        resumeButton = new CButton("Resume");
        pauseButton = new CButton("Pause");

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Set the paused flag to true when Pause button is clicked
                paused = true;
                pauseButton.setEnabled(false); // Disable Pause button
                resumeButton.setEnabled(true); // Enable Resume button
            }
        });
        resumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paused = false;
                resumeButton.setEnabled(false); // Disable Resume button
                pauseButton.setEnabled(true); // Enable Pause button

            }
        });

        frame.add(pauseButton);
        frame.add(resumeButton);
    }


    public int getProgressVal(int step, int totalSize) {
        return Math.round((float) (step * 100) / totalSize);
    }

    public void start() {

        frame.setVisible(true);
    }

    public void makeProgress(String text, int progressVal) {
        progressBar.setValue(progressVal);
        progressLabel.setText(text);
    }

    public void stop() {
        frame.dispose();
    }

    public boolean isPaused() {
        return paused;
    }



}
