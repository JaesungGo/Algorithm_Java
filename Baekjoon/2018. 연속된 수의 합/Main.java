package com.example.demo;

import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arrInt = new int[N + 1];

        for (int i = 0; i < N; i++) {
            arrInt[i] = i + 1;
        }

        int leftIdx = 0;
        int rightIdx = 0;
        int sum = arrInt[0];
        int count = 0;

        while (rightIdx < N) {
            if (sum == N) {
                count++;
                sum = sum - arrInt[leftIdx++];
            } else if (sum < N) {
                rightIdx++;
                if (rightIdx < N) {
                    sum = sum + arrInt[rightIdx];
                }
            } else {
                sum = sum - arrInt[leftIdx++];
            }
        }

        System.out.println(count);
    }
}