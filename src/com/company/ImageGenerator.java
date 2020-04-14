package com.company;

import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.font.GlyphVector;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class ImageGenerator {

    public void Generate() throws IOException {
        // Get random string from method getString below
        String text = getString();


        // Create image showing the string generated, to prevent the ability to copy/paste the string
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        Font font = new Font("Arial", Font.PLAIN, 32);
        g2d.setFont(font);
        FontMetrics fm = g2d.getFontMetrics();
        int width = fm.stringWidth(text);
        int height = fm.getHeight();
        g2d.dispose();

        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        g2d = img.createGraphics();
        g2d.setFont(font);
        fm = g2d.getFontMetrics();
        g2d.setColor(getRandomColor());
        g2d.drawString(text, 0, fm.getAscent());
        g2d.dispose();

        doImage(img, text);
    }

    public static void doImage(BufferedImage img, String text) {
        try {
            ImageIO.write(img, "png", new File("Text.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            displayGUI(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Generates random string from the characters in CHARS
    public String getString() {
        String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder str = new StringBuilder();
        Random rnd = new Random();
        while (str.length() < 6) {
            int index = (int) (rnd.nextFloat() * CHARS.length());
            str.append(CHARS.charAt(index));
        }
        String generatedCaptcha = str.toString();
        return generatedCaptcha;
    }

    public Color getRandomColor() {
        Random random = new Random();
        float r = random.nextFloat();
        float g = random.nextFloat();
        float b = random.nextFloat();
        return new Color(r, g, b);
    }


    public static void displayGUI(String text) throws IOException {
        GUI graphicInterface = new GUI();
        graphicInterface.display(text);
    }

    public void editImage(BufferedImage img) throws IOException {
        WritableRaster wr = img.getRaster();
        int width = img.getWidth();
        int height = img.getHeight();

        for (int ii = 0; ii < width; ii++) {
            for (int jj = 0; jj < height; jj++) {
                int color = img.getRGB(ii, jj);
                wr.setSample(ii, jj, 0, 156);
            }
            ImageIO.write(img, "BMP", new File("Text.png"));
        }
    }
}
