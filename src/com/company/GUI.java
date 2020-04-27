package com.company;

import com.sun.org.apache.xpath.internal.objects.XBoolean;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JPanel;

public class GUI {

    public static ImageGenerator imageGenerator = new ImageGenerator();
    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();
    static JLabel lblCaptcha = new JLabel("Enter captcha");
    static JTextField enterCaptcha = new JTextField(20);
    static JButton btnLogin = new JButton("Get access");
    static BufferedImage image;

    static {
        try {
            image = ImageIO.read(new File("./Text.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static JLabel loadedImage = new JLabel(new ImageIcon(image));

    public static void display(String captcha) throws IOException {
        checkInfo(captcha);
        panel.add(lblCaptcha);
        panel.add(loadedImage);
        panel.add(enterCaptcha);
        panel.add(btnLogin);
        panel.setVisible(true);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setBounds(540, 320, 500, 500);
        frame.setSize(300, 150);
        frame.setVisible(true);
    }


    public static void checkInfo(String captcha) {
        btnLogin.addActionListener(e -> {
            String givenCaptcha = enterCaptcha.getText();
            Boolean correctCaptcha = captcha.equals(givenCaptcha);

            if (correctCaptcha) {
                JOptionPane.showMessageDialog(null, "Correct captcha");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect captcha, try again");
                frame.setVisible(false);
                panel.setVisible(false);

                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
    }
}
