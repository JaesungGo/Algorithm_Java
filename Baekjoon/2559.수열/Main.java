package com.example.demo;

import java.util.*;
import java.io.*;
public class Main {
        public static void main(String[] args) throws IOException {
            int max = 0;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int numN = Integer.parseInt(st.nextToken());
            int numK = Integer.parseInt(st.nextToken());

            int[] temperature = new int[numN];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < numN; i++) {
                temperature[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < numK; i++) {
                max = max + temperature[i];
            }

            int temp = max;
            for (int i = numK; i < numN; i++) {
                temp = temp - temperature[i - numK] + temperature[i];
                max = Math.max(max, temp);
            }

            System.out.println(max);
        }
}