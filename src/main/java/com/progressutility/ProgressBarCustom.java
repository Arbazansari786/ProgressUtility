package com.progressutility;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.JComponent;
import javax.swing.JProgressBar;
import javax.swing.plaf.basic.BasicProgressBarUI;

public class ProgressBarCustom extends JProgressBar {

    private Color barColor = new Color(70, 136, 255); // Default blue color
    private Color textColor = Color.BLACK; // Default white color

    public ProgressBarCustom() {

        // this represents the text in the bar
        setStringPainted(true);
        setPreferredSize(new Dimension(250, 20)); // Increase height for better visibility
        setBackground(Color.WHITE); // Background color
//        setForeground(barColor); // Default bar color

        setUI(new BasicProgressBarUI() {
            @Override
            protected void paintDeterminate(Graphics g, JComponent c) {
                Graphics2D g2d = (Graphics2D) g;
                Insets b = progressBar.getInsets(); // Border Insets
                int barRectWidth = progressBar.getWidth() - (b.right + b.left);
                int barRectHeight = progressBar.getHeight() - (b.top + b.bottom);
                int arc = 0; // Rounded arc
                int fillBarWidth = (int) (barRectWidth * getPercentComplete());

                // Draw the background
                g2d.setColor(getBackground());
                g2d.fillRoundRect(b.left, b.top, barRectWidth, barRectHeight, arc, arc);

                // Draw the progress bar
                g2d.setColor(barColor);
                g2d.fillRoundRect(b.left, b.top, fillBarWidth, barRectHeight, arc, arc);

                // Draw the string
                if (progressBar.isStringPainted() && progressBar.getString() != null) {
                    System.out.println("hi");
                    g2d.setColor(Color.BLACK);
                    paintString(g, b.left, b.top, barRectWidth, barRectHeight, b.left, b);
                }
            }

            @Override
            protected void paintString(Graphics g, int x, int y, int width, int height, int amountFull, Insets b) {
                super.paintString(g, x, y, width, height, amountFull, b); // Call super.paintString with the modified Graphics2D object


            }
        });

        // Set a custom font for the progress bar text
        setFont(new Font("Arial", Font.BOLD, 12));
        setTextColor(Color.black);
    }

    public Color getBarColor() {
        return barColor;
    }

    public void setBarColor(Color barColor) {
        this.barColor = barColor;
        setForeground(barColor);
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }
}
