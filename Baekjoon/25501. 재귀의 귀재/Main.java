package com.example.demo;

import java.util.*;
import java.io.*;

/**
 * 25501. 재귀의 귀재
 */

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for(int i=0; i<num; i++){
            String word = sc.next();
            int[] a = isPalindrome(word);
            System.out.println(a[0]+ " "+ a[1]);
        }

    }

    static int[] isPalindrome(String inputStr){
        char[] arrChar = inputStr.toCharArray();
        int[] arrCount = new int[2];
        arrCount[1] = 1;
        return recursion(arrChar, 0, inputStr.length()-1, arrCount);
    }

    static int[] recursion(char[] arrChar, int l, int r, int[] arrCount){
        if(l>=r) {
            arrCount[0] = 1;
            return arrCount;
        }
        else if(arrChar[l] != arrChar[r]) {
            arrCount[0] = 0;
            return arrCount;
        }
        else {
            arrCount[1]++;
            return recursion(arrChar, l+1, r-1, arrCount);
        }
    }
}