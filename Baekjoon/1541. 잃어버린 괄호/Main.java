package com.example.demo;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] terms = br.readLine().split("-");
        int result = 0;

        for (int i = 0; i < terms.length; i++) {
            int sum = 0;
            String[] addends = terms[i].split("\\+");
            for (String addend : addends) {
                sum += Integer.parseInt(addend);
            }

            if (i == 0) {
                result += sum;
            } else {
                result -= sum;
            }
        }

        System.out.println(result);
    }
}