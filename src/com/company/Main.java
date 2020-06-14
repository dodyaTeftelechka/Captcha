package com.company;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        ArithmeticCaptcha arithmeticCaptcha = new ArithmeticCaptcha();
        try {
            arithmeticCaptcha.toBase64();
        } catch (NullPointerException exception) {
        }
    }
}