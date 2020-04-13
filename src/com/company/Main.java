package com.company;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {

        com.company.ImageGenerator initiateProgram = new com.company.ImageGenerator();
        try {
            initiateProgram.Generate();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}