package com.progressutility;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class CButton extends JButton {

    private int round = 12; // Increased roundness for a smoother appearance
    private Color shadowColor = new Color(170, 170, 170);
    private final Insets shadowSize = new Insets(2, 5, 8, 5);
    private Color buttonColor = new Color(0, 139, 239); // A blue color for the button

    public CButton(String text) {
        setPreferredSize(new Dimension(70, 30)); // Set preferred size (width, height)
        setFont(new Font("Arial", Font.BOLD, 9)); // Set font size
        setOpaque(true);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setText("<html><div style='padding: 0px;'>"+text+"</div></html>");
        setBorder(new EmptyBorder(10, 7, 15, 7));
        setContentAreaFilled(false);
        setBackground(buttonColor);
        setForeground(Color.white); // Set text color to white for better visibility
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        double width = getWidth() - (shadowSize.left + shadowSize.right);
        double height = getHeight() - (shadowSize.top + shadowSize.bottom);
        double x = shadowSize.left;
        double y = shadowSize.top;
        // Draw Shadow
        g2.setColor(shadowColor);
        g2.fillRoundRect((int) x, (int) y, (int) width, (int) height, round, round);
        // Draw Button Background
        g2.setColor(getBackground());
        Area area = new Area(new RoundRectangle2D.Double(x, y, width, height, round, round));
        g2.fill(area);
        g2.dispose();
        super.paintComponent(grphcs);
    }

}
