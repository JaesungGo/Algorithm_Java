package com.example.demo;

import java.util.*;
import java.io.*;

public class Main {
    static int result = 0;
    static int[] arrInt;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int numN = sc.nextInt();
        arrInt = new int[numN + 1];

        findQueen(1, numN);
        System.out.println(result);
    }

    static void findQueen(int row, int numN) {
        if (row > numN) {
            result++;
            return;
        }

        for (int col = 1; col <= numN; col++) {
            arrInt[row] = col;
            if (isValid(row)) {
                findQueen(row + 1, numN);
            }
        }
    }

    static boolean isValid(int row) {
        for (int i = 1; i < row; i++) {
            if (arrInt[i] == arrInt[row] ||
                    Math.abs(arrInt[i] - arrInt[row]) == row - i) {
                return false;
            }
        }
        return true;
    }
}