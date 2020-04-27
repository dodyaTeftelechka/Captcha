package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class ImageGenerator {

    private int x;
    private int y;

    public ImageGenerator(int abscissaCaptcha, int ordinateCaptcha){
        this.x = abscissaCaptcha;
        this.y = ordinateCaptcha;
    }

    public ImageGenerator(){

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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

    public void setRandomFont(Graphics2D graphics2D){
        Random rnd = new Random();
        Font[] fonts = {new Font("Arial", Font.PLAIN, rnd.nextInt(60)),
                new Font("Arial", Font.BOLD, rnd.nextInt(60)),
                new Font("Arial", Font.ITALIC, rnd.nextInt(60))};
        int n = rnd.nextInt(3);
        graphics2D.setFont(fonts[n]);
    }


    public String getString() {
        String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder str = new StringBuilder();
        Random rnd = new Random();
        while (str.length() < 6) {
            int index = (int) (rnd.nextFloat() * CHARS.length());

            str.append(CHARS.charAt(index));


        }
        return str.toString();
    }

    public Color getRandomColor() {
        Random random = new Random();
        float r = random.nextFloat();
        float g = random.nextFloat();
        float b = random.nextFloat();
        return new Color(r, g, b);
    }


    public static void displayGUI(String text) throws IOException {
        GUI.display(text);
    }

    public static void editImage(BufferedImage img, String text) throws IOException {
        WritableRaster wr = img.getRaster();
        int width = img.getWidth();
        int height = img.getHeight();

        for (int ii = 0; ii < width; ii++) {
            for (int jj = 0; jj < height; jj++) {
                int color = img.getRGB(ii, jj);
                wr.setSample(ii, jj, 0, 156);
            }
            ImageIO.write(img, "png", new File("Text1.png"));

            try {
                displayGUI(text);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void Generate() throws IOException {
            String text = getString();
            BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = img.createGraphics();
            //setRandomFont(g2d);
            FontMetrics fm = g2d.getFontMetrics();
            int width = fm.stringWidth(text);
            int height = fm.getHeight();
            g2d.dispose();
            img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            g2d = img.createGraphics();
            fm = g2d.getFontMetrics();
            g2d.setColor(getRandomColor());
            g2d.drawString(text, 0, fm.getAscent());
            g2d.dispose();
            doImage(img, text);
    }
}
