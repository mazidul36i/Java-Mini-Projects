package com.em.usecases;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        int k = input.nextInt();
        System.out.println(superDigit(s, k));
    }

    public static int superDigit(String s, int k) {
        long sum = 0;
        for (int i = 0; i < s.length(); i++)
            sum = sum + s.charAt(i) - '0';
        sum = sum * k;
        if (sum < 10)
            return (int) sum;
        else
            return superDigit(String.valueOf(sum), 1);
    }
}