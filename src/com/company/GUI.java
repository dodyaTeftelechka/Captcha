package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JPanel;

public class GUI {


    public static void display(String captcha) throws IOException {

        int frameStandart = 300;
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        JLabel lblCaptcha = new JLabel("Enter captcha");
        JTextField enterCaptcha = new JTextField(20);
        JButton btnLogin = new JButton("Enter");
        btnLogin.addActionListener(e -> {

            String givenCaptcha = enterCaptcha.getText();


            Boolean correctCaptcha = captcha.equals(givenCaptcha);

            if(correctCaptcha){
                JOptionPane.showMessageDialog(null, "Correct captcha");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                System.exit(0);
            }
            else{
                JOptionPane.showMessageDialog(null, "Incorrect captcha, try again");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    ImageGenerator imageGenerator = new ImageGenerator();
                try {
                    imageGenerator.Generate();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });

        BufferedImage image = ImageIO.read(new File("./Text.png"));
        JLabel loadedImage = new JLabel(new ImageIcon(image));

        // Adding GUI components to panel

        panel.add(lblCaptcha);
        panel.add(loadedImage);
        panel.add(enterCaptcha);
        panel.add(new JLabel("  "));
        panel.add(btnLogin);
        frame.getContentPane().add(BorderLayout.CENTER,panel);


        frame.setSize(frameStandart,frameStandart);
        frame.setBackground(Color.BLUE);
        frame.setVisible(true);

    }
}
