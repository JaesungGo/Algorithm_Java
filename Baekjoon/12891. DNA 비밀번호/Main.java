package com.example.demo;

import java.io.*;
import java.util.*;

public class Main {

    static char[] arrChar = {'A','C','G','T'};
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numM = sc.nextInt();
        int numN = sc.nextInt();

        int leftIdx = 0;
        int rightIdx = numN-1;

        String stringDNA = sc.next();

        int[] arrAnswer = new int[4];
        for(int k=0; k<4; k++){
            arrAnswer[k] = sc.nextInt();
        }

        int[] arrInt = new int[4];
        for(int i=0; i<numN; i++){
            moveWindow(stringDNA.charAt(i), arrInt, 1);
        }
        if( isTrue(arrInt,arrAnswer)){
            count++;
        }


        while(rightIdx < numM-1){
            moveWindow(stringDNA.charAt(leftIdx),arrInt,-1);
            leftIdx++;
            rightIdx++;
            moveWindow(stringDNA.charAt(rightIdx),arrInt,1);
            if (isTrue(arrInt, arrAnswer)){
                count++;
            }
        }

        System.out.println(count);

    }

    private static void moveWindow(char c, int[] counts, int move) {
        for(int i = 0; i < arrChar.length; i++) {
            if(c == arrChar[i]) {
                counts[i] += move;
                break;
            }
        }
    }

    private static boolean isTrue(int[] arrInt, int[] arrAnswer){
        for(int i=0; i<4; i++){
            if(arrInt[i] < arrAnswer[i]){
                return false;
            }
        }
        return true;
    }
}