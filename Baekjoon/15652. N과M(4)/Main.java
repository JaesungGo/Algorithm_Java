package com.example.demo;

import java.util.*;
import java.io.*;

/**
 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

 1부터 N까지 자연수 중에서 M개를 고른 수열
 같은 수를 여러 번 골라도 된다.
 고른 수열은 비내림차순이어야 한다. -> 오름차순
 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
 */


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numN = sc.nextInt();
        int numM = sc.nextInt();

        int[] arrInt = new int[numN+1];

        StringBuilder sb = new StringBuilder();
        makeAllDecide(arrInt, numM, 1, sb);
        System.out.println(sb);

    }

    static void makeAllDecide(int[] arrInt, int depth, int count, StringBuilder sb){
        if(depth < count){
            for(int i=1; i<count; i++){
                sb.append(arrInt[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<arrInt.length; i++){
            if(count == 1 || arrInt[count-1] <= i ){
                arrInt[count] = i;
                makeAllDecide(arrInt,depth,count+1,sb);
            }
        }
    }
}