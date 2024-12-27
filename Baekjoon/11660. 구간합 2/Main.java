package com.example.demo;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int numN = sc.nextInt();
        int numM = sc.nextInt();

        int[][] arrInt = new int[numN+1][numN+1];

        for(int i=1; i<=numN; i++){
            for(int j=1; j<=numN; j++){
                arrInt[i][j] = arrInt[i][j-1] + sc.nextInt();
            }
        }

        for(int i=1; i<=numM; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            System.out.println(querySumArr(arrInt, x1,y1,x2,y2));
        }
    }

    static int querySumArr(int[][] arrInt, int x1, int y1, int x2, int y2){
        int result = 0;
        for(int i=x1; i<=x2; i++){
            result += (arrInt[i][y2] - arrInt[i][y1-1]);
        }
        return result;
    }
}