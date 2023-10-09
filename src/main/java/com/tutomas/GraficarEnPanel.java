package com.tutomas;

import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GraficarEnPanel implements Border {
    private BufferedImage ixD;

    public GraficarEnPanel(BufferedImage nueva) {
        this.ixD = nueva;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        if (ixD != null) {
            g.drawImage(ixD, 0, 0, width, height, null);
        }
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(0, 0, 0, 0);
    }

    public boolean isBorderOpaque() {
        return true;
    }
}
